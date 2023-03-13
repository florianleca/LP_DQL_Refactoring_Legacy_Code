package fr.flolec.lpdql.Legacy_Code_Florian_Leca;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScenarioHtml {

	public String locationNouveauClient(String nomClient, String nomFilm, int typeFilm, int nbJours) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.getHtmlStatement();
	}

	public void cumulLocation(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}

	// test location film normal d'une durée inférieure à 3 jours
	@Test
	public void testLocationFilmNormalDureeInf3j() {
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : un client</h1>\n"
				+ "<ul><li>Taxi Driver\t2.0</li></ul>\n"
				+ "<p>Total dû 2.0</p> \n<p>Vous gagnez 1 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = locationNouveauClient("un client", "Taxi Driver", Film.NORMAL, 2);
		assertEquals(attendu, obtenu);
	}

	// test location film normal d'une durée d'au moins 3 jours
	@Test
	public void testLocationFilmNormalDureeSup3j() {
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : un client</h1>\n"
				+ "<ul><li>Taxi Driver\t3.5</li></ul>\n"
				+ "<p>Total dû 3.5</p> \n<p>Vous gagnez 1 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = locationNouveauClient("un client", "Taxi Driver", Film.NORMAL, 3);
		assertEquals(attendu, obtenu);
	}

	// test location film nouveauté d'une durée inférieure à 2 jours
	@Test
	public void testLocationFilmNouveauDureeInf2j() {
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : un client</h1>\n"
				+ "<ul><li>11 heures 14\t3.0</li></ul>\n"
				+ "<p>Total dû 3.0</p> \n<p>Vous gagnez 1 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = locationNouveauClient("un client", "11 heures 14", Film.NOUVEAUTE, 1);
		assertEquals(attendu, obtenu);
	}

	// test location film nouveauté d'une durée d'au moins 2 jours
	@Test
	public void testLocationFilmNouveauDureeSup2j() {
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : un client</h1>\n"
				+ "<ul><li>11 heures 14\t12.0</li></ul>\n"
				+ "<p>Total dû 12.0</p> \n<p>Vous gagnez 2 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = locationNouveauClient("un client", "11 heures 14", Film.NOUVEAUTE, 4);
		assertEquals(attendu, obtenu);
	}

	// test location film enfant d'une durée inférieure à 4 jours
	@Test
	public void testLocationFilmEnfantDureeInf4j() {
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : un client</h1>\n"
				+ "<ul><li>Cendrillon\t1.5</li></ul>\n"
				+ "<p>Total dû 1.5</p> \n<p>Vous gagnez 1 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = locationNouveauClient("un client", "Cendrillon", Film.ENFANT, 3);
		assertEquals(attendu, obtenu);
	}

	// test location film enfant d'une durée d'au moins 4 jours
	@Test
	public void testLocationFilmEnfantDureeSup4j() {
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : un client</h1>\n"
				+ "<ul><li>Cendrillon\t3.0</li></ul>\n"
				+ "<p>Total dû 3.0</p> \n<p>Vous gagnez 1 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = locationNouveauClient("un client", "Cendrillon", Film.ENFANT, 4);
		assertEquals(attendu, obtenu);
	}

	// test cumul de plusieurs locations
	@Test
	public void testCumul() {
		Client unClient = new Client("client cumul");
		cumulLocation(unClient, "Taxi Driver", Film.NORMAL, 2);
		cumulLocation(unClient, "11 heures 14", Film.NOUVEAUTE, 1);
		cumulLocation(unClient, "Cendrillon", Film.ENFANT, 2);
		String attendu = "<!doctype html>\r\n <html lang=\"fr\">\r\n <head>\r\n <meta charset=\"utf-8\">\r\n"
				+ "<title>Situation client</title>\r\n </head>\r\n <body><h1> Situation de : client cumul</h1>\n"
				+ "<ul><li>Taxi Driver\t2.0</li>"
				+ "<li>11 heures 14\t3.0</li>"
				+ "<li>Cendrillon\t1.5</li></ul>\n"
				+ "<p>Total dû 6.5</p> \n<p>Vous gagnez 3 points de fidélité.</p> \n </body> \n </html>";
		String obtenu = unClient.getHtmlStatement();
		assertEquals(attendu, obtenu);
	}
}
