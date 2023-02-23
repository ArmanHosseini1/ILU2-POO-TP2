package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if ((infosMarche.length)==0) {
			System.out.println("Le marché est vide, revenez plus tard");
		}
		else {
			System.out.println(nomAcheteur + " vous trouverez au marché :\n");
			int i = 0;
			while (i<infosMarche.length){
				StringBuilder phrase = new StringBuilder();
				phrase.append(" - ");
				phrase.append(infosMarche[i]);
				i++;
				phrase.append(" qui vend ");
				phrase.append(infosMarche[i]);
				i++;
				phrase.append(" ");
				phrase.append(infosMarche[i]);
				System.out.println(phrase.toString());
			}
			
		}
	}
}
