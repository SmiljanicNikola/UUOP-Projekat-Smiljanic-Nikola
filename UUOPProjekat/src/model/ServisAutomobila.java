package model;

import java.util.ArrayList;
import java.util.List;


public class ServisAutomobila {

	public int id;
	public Automobil servisiraniAutomobil;
	public Serviser serviser;
	public String terminServisa;
	public String kratakOpis;
	private ArrayList<ServisniDeo> delovi;
	public enumeracije.statusServisa statusServisa;
	public int isDeleted;
	
	public ServisAutomobila() {
		this.id = 0;
		this.servisiraniAutomobil = new Automobil();
		this.serviser = new Serviser();
		this.kratakOpis = "";
		this.delovi = new ArrayList<ServisniDeo>();
		this.statusServisa = enumeracije.statusServisa.aktivan;
		this.isDeleted = 0;
	}


	public ServisAutomobila(int id, Automobil servisiraniAutomobil, Serviser serviser, String terminServisa,
			String kratakOpis, ArrayList<ServisniDeo> delovi, enumeracije.statusServisa statusServisa, int isDeleted) {
		super();
		this.id = id;
		this.servisiraniAutomobil = servisiraniAutomobil;
		this.serviser = serviser;
		this.terminServisa = terminServisa;
		this.kratakOpis = kratakOpis;
		this.delovi = delovi;
		this.statusServisa = statusServisa;
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Automobil getServisiraniAutomobil() {
		return servisiraniAutomobil;
	}

	public void setServisiraniAutomobil(Automobil servisiraniAutomobil) {
		this.servisiraniAutomobil = servisiraniAutomobil;
	}

	public Serviser getServiser() {
		return serviser;
	}

	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}

	public String getTerminServisa() {
		return terminServisa;
	}

	public void setTerminServisa(String terminServisa) {
		this.terminServisa = terminServisa;
	}

	public String getKratakOpis() {
		return kratakOpis;
	}

	public void setKratakOpis(String kratakOpis) {
		this.kratakOpis = kratakOpis;
	}

	public ArrayList<ServisniDeo> getDelovi() {
		return delovi;
	}


	public void setDelovi(ArrayList<ServisniDeo> delovi) {
		this.delovi = delovi;
	}

	public ArrayList<ServisniDeo> getDelovi(int del) {
		ArrayList<ServisniDeo> delovi = new ArrayList<ServisniDeo>();
		for(ServisniDeo deo : this.delovi) {
			if(deo.getIsDeleted() == del) delovi.add(deo);
		}
		return delovi;
	}
	
	public enumeracije.statusServisa getStatusServisa() {
		return statusServisa;
	}

	public void setStatusServisa(enumeracije.statusServisa statusServisa) {
		this.statusServisa = statusServisa;
	}
	
	public int getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	

	@Override
	public String toString() {
		return "ServisAutomobila [id=" + id + ", servisiraniAutomobil=" + servisiraniAutomobil + ", serviser="
				+ serviser + ", terminServisa=" + terminServisa + ", kratakOpis=" + kratakOpis + ", delovi=" + delovi
				+ ", statusServisa=" + statusServisa + ", isDeleted=" + isDeleted + "]";
	}


	public String toFile() {
		return String.format("%s|%s|%s|%s|%s|%s|%.2f|%d", id, servisiraniAutomobil.getId(), serviser.getKorisnickoIme(), 
				terminServisa, kratakOpis, delovi, statusServisa);
	}
	
	public void dodajDeo(ServisniDeo deo) {
		if(deo != null) delovi.add(deo);
	}


	
	
	
}
