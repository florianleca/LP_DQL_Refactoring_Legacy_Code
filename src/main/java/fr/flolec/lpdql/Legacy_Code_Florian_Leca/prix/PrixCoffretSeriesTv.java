package fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix;

public class PrixCoffretSeriesTv extends Prix {

	@Override
	public double getMontant(int nbJours) {
		return 0.5 * nbJours;
	}

	@Override
	public int getPointsFidelite(int nbJours) {
		return 0;
	}

}
