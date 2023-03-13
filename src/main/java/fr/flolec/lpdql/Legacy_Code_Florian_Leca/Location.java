package fr.flolec.lpdql.Legacy_Code_Florian_Leca;

public class Location {
	private Film film;
	private int nbJours;

	public Location(Film film, int nbJours) {
		this.film = film;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.film;
	}

	public double getMontant() {
		return film.getMontant(nbJours);
	}
	
	public int getPointsFidelite() {
		return film.getPointsFidelite(nbJours);
	}

}
