package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert forceRomainPositive();
	}
	
	private String prendreParole() {
		return "Le romain " + nom + ": ";
	}
	
	private boolean forceRomainPositive() {
		return force > 0;
	}
	
	private boolean forceRomainDiminue(int debut, int fin) {
		return debut>fin;
	}
		
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement ;
		System.out.println("Le soldat " + getNom() + "s'equipe avec un " + equipement);
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "Â« " + texte +"Â»");
	}
	
	public void recevoirCoup( int forceCoup) {
		assert forceRomainPositive();
		int forceDebut = force;
		force -= forceCoup;
		
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		
		int forceFin = force;
		assert forceRomainDiminue(forceDebut, forceFin);
	}
	
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + getNom() + " est deja bien protégé !");
			break;
		case 0 :
			ajouterEquipement(equipement);
			break;
		default:
			if (equipements[nbEquipement].equals(equipement)) {
				System.out.println("Le soldat " + getNom() + "possède deja un " + equipement );
			} else {
				ajouterEquipement(equipement);
			}
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		for (Equipement equipement : Equipement.values()) {
			System.out.println("- " + equipement);
		}
	}
}
