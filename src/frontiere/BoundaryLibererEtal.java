package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.valueOf(donneesEtal[0])) {
				StringBuilder phrase = new StringBuilder();
				phrase.append("Vous avez vendu ");
				phrase.append(donneesEtal[4]);
				phrase.append(" sur ");
				phrase.append(donneesEtal[3]);
				phrase.append(" ");
				phrase.append(donneesEtal[2]);
				System.out.println(phrase.toString());
				System.out.println("Au revoir "+ nomVendeur + " passez une bonne journée");
			}
		}
	}

}
