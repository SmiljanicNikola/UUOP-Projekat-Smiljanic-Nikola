package model;

public class Administrator extends Osoba {
	
	public double plata;
	
	public Administrator() {
		super();
		this.plata = 0;
	}

	public Administrator(int id, String ime, String prezime, String jmbg, enumeracije.Pol pol, String adresa,
			String telefon, String korisnickoIme, String lozinka, double plata) {
		super(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.plata = plata;
	}


	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime="
				+ prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", telefon=" + telefon
				+ ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	
	
	
}
