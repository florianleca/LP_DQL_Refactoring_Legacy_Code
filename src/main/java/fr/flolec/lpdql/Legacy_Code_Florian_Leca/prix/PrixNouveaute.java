package fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix;

public class PrixNouveaute extends Prix {

	@Override
	public double getMontant(int nbJours) {
		return nbJours * 3.;
	}

	@Override
	public int getPointsFidelite(int nbJours) {
		if (nbJours > 1) {
			return 2;
		}
		return 1;
	}

}
