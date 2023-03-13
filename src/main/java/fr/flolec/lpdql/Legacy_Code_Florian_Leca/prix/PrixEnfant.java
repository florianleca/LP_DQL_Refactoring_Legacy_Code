package fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix;

public class PrixEnfant extends Prix {

	@Override
	public double getMontant(int nbJours) {
		double montantDu = 1.5;
		if (nbJours > 3) {
			montantDu += (nbJours - 3) * 1.5;
		}
		return montantDu;
	}

	@Override
	public int getPointsFidelite(int nbJours) {
		return 1;
	}

	
}
