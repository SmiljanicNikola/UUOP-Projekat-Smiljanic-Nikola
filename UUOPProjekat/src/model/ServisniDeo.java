package model;

public class ServisniDeo {

	public int id;
	public String markaAutomobila;
	public String modelAutomobila;
	public int cena;
	public String nazivDela;
	
	public ServisniDeo() {
		this.id = 0;
		this.markaAutomobila = "";
		this.modelAutomobila = "";
		this.cena = 0;
		this.nazivDela = "";
	}

	public ServisniDeo(int id, String markaAutomobila, String modelAutomobila, int cena, String nazivDela) {
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

	public String getMarkaAutomobila() {
		return markaAutomobila;
	}

	public void setMarkaAutomobila(String markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}

	public String getModelAutomobila() {
		return modelAutomobila;
	}

	public void setModelAutomobila(String modelAutomobila) {
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
