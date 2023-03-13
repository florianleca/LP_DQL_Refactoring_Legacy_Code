package fr.flolec.lpdql.Legacy_Code_Florian_Leca;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScenarioText {

	public String locationNouveauClient(String nomClient, String nomFilm, int typeFilm, int nbJours) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.getTextStatement();
	}

	public void cumulLocation(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}

	// test location film normal d'une durée inférieure à 3 jours
	@Test
	public void testLocationFilmNormalDureeInf3j() {
		String attendu = "Situation du client: un client\n" + "\tTaxi Driver\t2.0\n" + "Total dû 2.0\n"
				+ "Vous gagnez 1 points de fidélité\n";
		String obtenu = locationNouveauClient("un client", "Taxi Driver", Film.NORMAL, 2);
		assertEquals(attendu, obtenu);
	}

	// test location film normal d'une durée d'au moins 3 jours
	@Test
	public void testLocationFilmNormalDureeSup3j() {
		String attendu = "Situation du client: un client\n" + "\tTaxi Driver\t3.5\n" + "Total dû 3.5\n"
				+ "Vous gagnez 1 points de fidélité\n";
		String obtenu = locationNouveauClient("un client", "Taxi Driver", Film.NORMAL, 3);
		assertEquals(attendu, obtenu);
	}

	// test location film nouveauté d'une durée inférieure à 2 jours
	@Test
	public void testLocationFilmNouveauDureeInf2j() {
		String attendu = "Situation du client: un client\n" + "\t11 heures 14\t3.0\n" + "Total dû 3.0\n"
				+ "Vous gagnez 1 points de fidélité\n";
		String obtenu = locationNouveauClient("un client", "11 heures 14", Film.NOUVEAUTE, 1);
		assertEquals(attendu, obtenu);
	}

	// test location film nouveauté d'une durée d'au moins 2 jours
	@Test
	public void testLocationFilmNouveauDureeSup2j() {
		String attendu = "Situation du client: un client\n" + "\t11 heures 14\t12.0\n" + "Total dû 12.0\n"
				+ "Vous gagnez 2 points de fidélité\n";
		String obtenu = locationNouveauClient("un client", "11 heures 14", Film.NOUVEAUTE, 4);
		assertEquals(attendu, obtenu);
	}

	// test location film enfant d'une durée inférieure à 4 jours
	@Test
	public void testLocationFilmEnfantDureeInf4j() {
		String attendu = "Situation du client: un client\n" + "\tCendrillon\t1.5\n" + "Total dû 1.5\n"
				+ "Vous gagnez 1 points de fidélité\n";
		String obtenu = locationNouveauClient("un client", "Cendrillon", Film.ENFANT, 3);
		assertEquals(attendu, obtenu);
	}

	// test location film enfant d'une durée d'au moins 4 jours
	@Test
	public void testLocationFilmEnfantDureeSup4j() {
		String attendu = "Situation du client: un client\n" + "\tCendrillon\t3.0\n" + "Total dû 3.0\n"
				+ "Vous gagnez 1 points de fidélité\n";
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
		String attendu = "Situation du client: client cumul\n" + "\tTaxi Driver\t2.0\n" + "\t11 heures 14\t3.0\n"
				+ "\tCendrillon\t1.5\n" + "Total dû 6.5\n" + "Vous gagnez 3 points de fidélité\n";
		String obtenu = unClient.getTextStatement();
		assertEquals(attendu, obtenu);
	}

}
