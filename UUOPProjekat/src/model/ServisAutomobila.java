package model;

import java.util.ArrayList;
import java.util.List;

public class ServisAutomobila {

	public int id;
	public Automobil servisiraniAutomobil;
	public Serviser serviser;
	public String terminServisa;
	public String kratakOpis;
	public List<ServisniDeo> listaDelova;
	public boolean statusServisa;
	
	public ServisAutomobila() {
		this.id = 0;
		this.servisiraniAutomobil = new Automobil();
		this.serviser = new Serviser();
		this.terminServisa = "";
		this.kratakOpis = "";
		this.listaDelova = new ArrayList<ServisniDeo>();
		this.statusServisa = false;
	}

	public ServisAutomobila(int id, Automobil servisiraniAutomobil, Serviser serviser, String terminServisa,
			String kratakOpis, List<ServisniDeo> listaDelova, boolean statusServisa) {
		super();
		this.id = id;
		this.servisiraniAutomobil = servisiraniAutomobil;
		this.serviser = serviser;
		this.terminServisa = terminServisa;
		this.kratakOpis = kratakOpis;
		this.listaDelova = listaDelova;
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

	public List<ServisniDeo> getListaDelova() {
		return listaDelova;
	}

	public void setListaDelova(List<ServisniDeo> listaDelova) {
		this.listaDelova = listaDelova;
	}

	public boolean isStatusServisa() {
		return statusServisa;
	}

	public void setStatusServisa(boolean statusServisa) {
		this.statusServisa = statusServisa;
	}

	@Override
	public String toString() {
		return "ServisAutomobila [id=" + id + ", servisiraniAutomobil=" + servisiraniAutomobil + ", serviser="
				+ serviser + ", terminServisa=" + terminServisa + ", kratakOpis=" + kratakOpis + ", listaDelova="
				+ listaDelova + ", statusServisa=" + statusServisa + "]";
	}
	
	
	
}
