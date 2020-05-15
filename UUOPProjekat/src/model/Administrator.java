package model;

public class Administrator extends Osoba {
	
	public int id;
	public double plata;
	
	public Administrator() {
		super();
		this.id = 0;
		this.plata = 0;
	}

	public Administrator(int idOsoba, String ime, String prezime, String jmbg, String pol, String adresa,
			String telefon, String korisnickoIme, String lozinka, int id, double plata) {
		super(idOsoba, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.id = id;
		this.plata = plata;
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

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", plata=" + plata + ", idOsoba=" + idOsoba + ", ime=" + ime + ", prezime="
				+ prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", telefon=" + telefon
				+ ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	
	
	
}
