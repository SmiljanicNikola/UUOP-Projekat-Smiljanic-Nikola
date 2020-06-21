package model;

import java.util.ArrayList;
import java.util.List;

public class ServisAutomobila {

	public int id;
	public Automobil servisiraniAutomobil;
	public Serviser serviser;
	public String terminServisa;
	public String kratakOpis;
	public String delovi;
	public enumeracije.statusServisa statusServisa;
	
	public ServisAutomobila() {
		this.id = 0;
		this.servisiraniAutomobil = new Automobil();
		this.serviser = new Serviser();
		this.kratakOpis = "";
		this.delovi = "";
		this.statusServisa = enumeracije.statusServisa.aktivan;
	}


	public ServisAutomobila(int id, Automobil servisiraniAutomobil, Serviser serviser, String terminServisa,
			String kratakOpis, String delovi, enumeracije.statusServisa statusServisa) {
		super();
		this.id = id;
		this.servisiraniAutomobil = servisiraniAutomobil;
		this.serviser = serviser;
		this.terminServisa = terminServisa;
		this.kratakOpis = kratakOpis;
		this.delovi = delovi;
		this.statusServisa = statusServisa;
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


	public enumeracije.statusServisa getStatusServisa() {
		return statusServisa;
	}

	public void setStatusServisa(enumeracije.statusServisa statusServisa) {
		this.statusServisa = statusServisa;
	}

	public String getDelovi() {
		return delovi;
	}


	public void setDelovi(String delovi) {
		this.delovi = delovi;
	}


	@Override
	public String toString() {
		return "ServisAutomobila [id=" + id + ", servisiraniAutomobil=" + servisiraniAutomobil + ", serviser="
				+ serviser + ", terminServisa=" + terminServisa + ", kratakOpis=" + kratakOpis + ", delovi=" + delovi
				+ ", statusServisa=" + statusServisa + "]";
	}


	

	
	
	
}
