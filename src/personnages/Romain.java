package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false; 

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

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		System.out.println("Le soldat " + getNom() + " s'equipe avec un " + equipement);
		nbEquipement++;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public boolean getVainqueur() {
		return vainqueur; 
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

//	public void recevoirCoup( int forceCoup) {
//		assert force > 0 ;
//		int forceDebut = force;
	
//		force -= forceCoup;
//		assert forceRomainPositive() ;
	
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceDebut > force ;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			vainqueur = true; 
		} 
//		switch (force) {
//		case 0:
//			parler("A�e");
//			break;
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement; 
		forceCoup = Math.max(forceCoup, 0); 
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		System.out.println("L'�quipement de " + nom.toString() + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + getNom() + " est deja bien prot�g� !");
			break;
		case 0:
			ajouterEquipement(equipement);
			break;
		default:
			if (equipements[nbEquipement]!= null && equipements[nbEquipement].equals(equipement)) {
				System.out.println("Le soldat " + getNom() + "poss�de deja un " + equipement);
			} else {
				ajouterEquipement(equipement);
			}
			break;
		}

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		for (Equipement equipement : Equipement.values()) {
			System.out.println("- " + equipement);
		}
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
