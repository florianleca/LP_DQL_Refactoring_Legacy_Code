package fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix;

public class PrixNormal extends Prix {

	@Override
	public double getMontant(int nbJours) {
		double montantDu = 2;
		if (nbJours > 2) {
			montantDu += (nbJours - 2) * 1.5;
		}		
		return montantDu;
	}


	@Override
	public int getPointsFidelite(int nbJours) {
		return 1;
	}

}
