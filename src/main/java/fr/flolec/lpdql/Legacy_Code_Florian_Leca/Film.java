package fr.flolec.lpdql.Legacy_Code_Florian_Leca;

import fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix.Prix;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix.PrixCinephile;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix.PrixCoffretSeriesTv;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix.PrixEnfant;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix.PrixNormal;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.prix.PrixNouveaute;

public class Film {
	public static final int CINEPHILE = 4;
	public static final int COFFRETSERIETV = 3;
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;

	private String titre;
	private Prix prix;

	public Film(String titre, int codePrix) {
		this.titre = titre;
		setCodePrix(codePrix);
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int codePrix) {
		switch (codePrix) {
		case NORMAL:
			prix = new PrixNormal();
			break;
		case NOUVEAUTE:
			prix = new PrixNouveaute();
			break;
		case ENFANT:
			prix = new PrixEnfant();
			break;
		case COFFRETSERIETV:
			prix = new PrixCoffretSeriesTv();
			break;
		case CINEPHILE:
			prix = new PrixCinephile();
			break;
		default:
			prix = new PrixNormal();
			break;
		}
	}

	public double getMontant(int nbJours) {
		return prix.getMontant(nbJours);
	}

	public int getPointsFidelite(int nbJours) {
		return prix.getPointsFidelite(nbJours);
	}

}
