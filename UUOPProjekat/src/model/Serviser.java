package model;

public class Serviser extends Osoba {
	
	public int id;
	public double plata;
	public String specijalizacija;
	
	public Serviser() {
		super();
		this.id = 0;
		this.plata = 0;
		this.specijalizacija = "";
	}

	public Serviser(int idOsoba, String ime, String prezime, String jmbg, String pol, String adresa, String telefon,
			String korisnickoIme, String lozinka, int id, double plata, String specijalizacija) {
		super(idOsoba, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.id = id;
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "Serviser [id=" + id + ", plata=" + plata + ", specijalizacija=" + specijalizacija + ", idOsoba="
				+ idOsoba + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa="
				+ adresa + ", telefon=" + telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	
	
	
	
	
}
