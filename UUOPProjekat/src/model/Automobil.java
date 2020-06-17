package model;

public class Automobil {
	
	public int id;
	public Musterija vlasnik;
	public String marka;
	public String model;
	public int godinaProizvodnje;
	public String zapreminaMotora;
	public String snagaMotora;
	public enumeracije.vrstaGoriva vrstaGoriva;
	
	public Automobil() {
		this.id = 0;
		this.vlasnik = new Musterija();
		this.marka = "";
		this.model = "";
		this.godinaProizvodnje = 0;
		this.zapreminaMotora = "";
		this.snagaMotora = "";
		this.vrstaGoriva = enumeracije.vrstaGoriva.dizel;
	}

	public Automobil(int id, Musterija vlasnik, String marka, String model, int godinaProizvodnje,
			String zapreminaMotora, String snagaMotora, enumeracije.vrstaGoriva vrstaGoriva) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.zapreminaMotora = zapreminaMotora;
		this.snagaMotora = snagaMotora;
		this.vrstaGoriva = vrstaGoriva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Musterija getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getZapreminaMotora() {
		return zapreminaMotora;
	}

	public void setZapreminaMotora(String zapreminaMotora) {
		this.zapreminaMotora = zapreminaMotora;
	}

	public String getSnagaMotora() {
		return snagaMotora;
	}

	public void setSnagaMotora(String snagaMotora) {
		this.snagaMotora = snagaMotora;
	}


	public enumeracije.vrstaGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(enumeracije.vrstaGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	@Override
	public String toString() {
		return "Automobil [id=" + id + ", vlasnik=" + vlasnik + ", marka=" + marka + ", model=" + model
				+ ", godinaProizvodnje=" + godinaProizvodnje + ", zapreminaMotora=" + zapreminaMotora + ", snagaMotora="
				+ snagaMotora + ", vrstaGoriva=" + vrstaGoriva + "]";
	}
	
	
	
}