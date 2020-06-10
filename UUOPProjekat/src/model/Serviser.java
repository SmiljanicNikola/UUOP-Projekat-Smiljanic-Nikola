package model;

public class Serviser extends Osoba {
	
	public double plata;
	public String specijalizacija;
	
	public Serviser() {
		super();
		this.plata = 0;
		this.specijalizacija = "";
	}

	

	public Serviser(int id, String ime, String prezime, String jmbg, enumeracije.pol pol, String adresa, String telefon,
			String korisnickoIme, String lozinka, double plata, String specijalizacija) {
		super(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
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
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa="
				+ adresa + ", telefon=" + telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	
	
	
	
	
}
