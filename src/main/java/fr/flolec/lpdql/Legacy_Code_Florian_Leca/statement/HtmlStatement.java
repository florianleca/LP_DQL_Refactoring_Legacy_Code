package fr.flolec.lpdql.Legacy_Code_Florian_Leca.statement;

import fr.flolec.lpdql.Legacy_Code_Florian_Leca.Client;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.Location;

public class HtmlStatement extends Statement {

	public HtmlStatement(Client client) {
		super(client);
	}

	@Override
	public String redactionEntete() {
		return "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : " + client.getNom()
				+ "</h1>\n<ul>";
	}

	@Override
	public String redactionRecap() {
		String affichage = "</ul>\n<p>Total dû " + getMontantTotal() + "</p> \n";
		affichage += "<p>Vous gagnez " + getPointsFidelitesTotal() + " points de fidélité.</p> \n </body> \n </html>";

		return affichage;
	}

	@Override
	protected String afficherUnFilm(Location location) {
		return "<li>" + location.getFilm().getTitre() + "\t" + location.getMontant() + "</li>";
	}

}
