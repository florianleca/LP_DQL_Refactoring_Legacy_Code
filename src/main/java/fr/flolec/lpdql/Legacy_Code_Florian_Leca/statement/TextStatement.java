package fr.flolec.lpdql.Legacy_Code_Florian_Leca.statement;

import fr.flolec.lpdql.Legacy_Code_Florian_Leca.Client;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.Location;

public class TextStatement extends Statement {

	public TextStatement(Client client) {
		super(client);
	}

	@Override
	public String redactionEntete() {
		return "Situation du client: " + client.getNom() + "\n";
	}

	@Override
	public String redactionRecap() {
		String affichage = "Total dû " + getMontantTotal() + "\n";
		affichage += "Vous gagnez " + getPointsFidelitesTotal() + " points de fidélité\n";
		return affichage;
	}

	@Override
	protected String afficherUnFilm(Location location) {
		return "\t" + location.getFilm().getTitre() + "\t" + location.getMontant() + "\n";
	}

}
