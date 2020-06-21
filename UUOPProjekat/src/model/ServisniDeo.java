package model;

import enumeracije.marka;
import enumeracije.model;

public class ServisniDeo {

	public int id;
	public enumeracije.marka markaAutomobila;
	public enumeracije.model modelAutomobila;
	public int cena;
	public String nazivDela;
	
	public ServisniDeo() {
		this.id = 0;
		this.markaAutomobila = enumeracije.marka.mercedes;
		this.modelAutomobila = enumeracije.model.W220;
		this.cena = 0;
		this.nazivDela = "";
	}

	

	public ServisniDeo(int id, marka markaAutomobila, model modelAutomobila, int cena, String nazivDela) {
		super();
		this.id = id;
		this.markaAutomobila = markaAutomobila;
		this.modelAutomobila = modelAutomobila;
		this.cena = cena;
		this.nazivDela = nazivDela;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public enumeracije.marka getMarkaAutomobila() {
		return markaAutomobila;
	}

	public void setMarkaAutomobila(enumeracije.marka markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}

	public enumeracije.model getModelAutomobila() {
		return modelAutomobila;
	}


	public void setModelAutomobila(enumeracije.model modelAutomobila) {
		this.modelAutomobila = modelAutomobila;
	}



	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNazivDela() {
		return nazivDela;
	}

	public void setNazivDela(String nazivDela) {
		this.nazivDela = nazivDela;
	}



	@Override
	public String toString() {
		return "ServisniDeo [id=" + id + ", markaAutomobila=" + markaAutomobila + ", modelAutomobila=" + modelAutomobila
				+ ", cena=" + cena + ", nazivDela=" + nazivDela + "]";
	}


	
	
	
	
}
