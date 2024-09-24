package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom , int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length ) {
			villageois[nbVillageois] = gaulois ;
			nbVillageois++ ;
		}
	}
	
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans " + getNom() + " du chef " + chef.getNom() + " vivent les legendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("village des Irréductibles",30);
		
//		Gaulois gaulois = village.trouverHabitant(30);
//		car le tableau va de l'index  a l'index 29, 30 est donc en dehors du tableau
		
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		l'index donner est le 1 alors que Asterix est a l'index 0
		
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
	}
}

