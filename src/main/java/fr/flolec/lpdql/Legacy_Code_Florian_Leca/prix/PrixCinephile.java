package fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix;

public class PrixCinephile extends Prix {

	@Override
	public double getMontant(int nbJours) {
		double montant = 2;
		if (nbJours > 1) {
			montant += 4 * (nbJours - 1);
		}
		return montant;
	}

	@Override
	public int getPointsFidelite(int nbJours) {
		int points = 3;
		if (nbJours > 1) {
			points = 0;
		}
		return points;
	}

}
