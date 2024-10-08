package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee newTrophee = new Trophee(gaulois,equipement); 
		trophees[nbTrophee]= newTrophee; 
		nbTrophee++;  
	}
	
	public String extraireInstructionsOCaml() {
		StringBuilder ocamlString = new StringBuilder("let musee = [\n");
        for (Trophee trophee : trophees) {
            ocamlString.append("\"").append(trophee.donnerNom()).append("\", \"")
                       .append(trophee.getEquipement()).append("\";\n");
        }
        if (ocamlString.length() > 0) {
            ocamlString.setLength(ocamlString.length() - 2);
        }
        ocamlString.append("\n]");
        return ocamlString.toString();
    }
	
	public static void main(String[] args) {
	
       
    }
}
