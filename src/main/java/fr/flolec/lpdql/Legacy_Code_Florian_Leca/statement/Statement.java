package fr.flolec.lpdql.Legacy_Code_Florian_Leca.statement;

import java.util.Iterator;

import fr.flolec.lpdql.Legacy_Code_Florian_Leca.Client;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.Location;

public abstract class Statement {

	protected Client client;

	public abstract String redactionEntete();

	protected abstract String afficherUnFilm(Location location);

	public abstract String redactionRecap();

	protected Statement(Client client) {
		this.client = client;
	}

	public String redactionStatement() {
		String affichage = redactionEntete();
		affichage += redactionLocations();
		affichage += redactionRecap();
		return affichage;
	}

	public String redactionLocations() {
		String affichage = "";
		Iterator<Location> iteratorLocations = client.getLocations().iterator();
		while (iteratorLocations.hasNext()) {
			Location location = iteratorLocations.next();
			affichage += afficherUnFilm(location);
		}
		return affichage;
	}

	// Ces deux méthodes pourraient plutôt être dans Client :
	
	public double getMontantTotal() {
		double montantTotal = 0;
		Iterator<Location> iteratorLocations = client.getLocations().iterator();
		while (iteratorLocations.hasNext()) {
			Location location = iteratorLocations.next();
			montantTotal += location.getMontant();
		}
		return montantTotal;
	}

	public int getPointsFidelitesTotal() {
		int pointsFidelitesTotal = 0;
		Iterator<Location> iteratorLocations = client.getLocations().iterator();
		while (iteratorLocations.hasNext()) {
			Location location = iteratorLocations.next();
			pointsFidelitesTotal += location.getPointsFidelite();
		}
		return pointsFidelitesTotal;
	}
}
