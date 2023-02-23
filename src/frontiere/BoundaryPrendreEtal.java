package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			StringBuilder phrase1 = new StringBuilder();
			phrase1.append("Je suis désolée ");
			phrase1.append(nomVendeur);
			phrase1.append(" Je vais voir si je peux vous trouver un étal\n");
			System.out.println(phrase1.toString());
		}
		else {
			StringBuilder phrase2 = new StringBuilder();
			phrase2.append("Bonjour ");
			phrase2.append(nomVendeur);
			phrase2.append(" Je vais voir si je peux vous trouver un étal\n");
			System.out.println(phrase2.toString());
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				StringBuilder phrase3 = new StringBuilder();
				phrase3.append("Désolée ");
				phrase3.append(nomVendeur);
				phrase3.append(" Je n'ai plus d'étal qui soit disponible\n");
				System.out.println(phrase3.toString());
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("Parfait, il me reste un étal pour vous!\n");
		System.out.println("Il me faudrait quelques renseignements:\n");
		System.out.println("Quel produit souhaitez-vous vendre?\n");
		String produit = scan.nextLine();
		System.out.println("Combien souhaitez-vous en vendre?\n");
		int nbProduit = scan.nextInt();
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=(-1)) {
			StringBuilder phrase4 = new StringBuilder();
			phrase4.append("Le vendeur ");
			phrase4.append(nomVendeur);
			phrase4.append(" s'est installé à l'étal numéro ");
			phrase4.append(numeroEtal);
			System.out.println(phrase4.toString());
		}
	}
}
