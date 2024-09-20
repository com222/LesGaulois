package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain; 

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obélix",25);
		Romain minus = new Romain("Minues", 6);
		Druide panoramix = new Druide("Panoramix",5,10);
		
		
		panoramix.parler("Je vais aller peéparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		
		obelix.parler("Par Bélénos,ce n'est pas juste!");
		
		asterix.parler("Bonjour à tous");
		
		minus.parler("UN GAU... UNA GAUGAU...");
		
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		
	}

}
