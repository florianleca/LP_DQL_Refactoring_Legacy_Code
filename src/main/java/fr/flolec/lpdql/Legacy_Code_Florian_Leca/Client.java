package fr.flolec.lpdql.Legacy_Code_Florian_Leca;

import java.util.Vector;

import fr.flolec.lpdql.Legacy_Code_Florian_Leca.statement.HtmlStatement;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.statement.Statement;
import fr.flolec.lpdql.Legacy_Code_Florian_Leca.statement.TextStatement;

public class Client {
	private String nom;
	private Vector<Location> locations = new Vector<>();
	private Statement textStatement = new TextStatement(this);
	private Statement htmlStatement = new HtmlStatement(this);

	public Client(String nom) {
		this.nom = nom;
	}

	public void addLocation(Location location) {
		this.locations.add(location);
	}

	public String getNom() {
		return this.nom;
	}

	public Vector<Location> getLocations() {
		return locations;
	}

	public String getTextStatement() {
		return textStatement.redactionStatement();
	}

	public String getHtmlStatement() {
		return htmlStatement.redactionStatement();
	}

}
