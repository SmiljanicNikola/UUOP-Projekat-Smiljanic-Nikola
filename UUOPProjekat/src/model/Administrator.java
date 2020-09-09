package model;

public class Administrator extends Osoba {
	
	public double plata;
	public int isDeleted;
	
	public Administrator() {
		super();
		this.plata = 0;
		this.isDeleted = 0;
		
	}

	public Administrator(int id, String ime, String prezime, String jmbg, enumeracije.Pol pol, String adresa,
			String telefon, String korisnickoIme, String lozinka, double plata, int isDeleted) {
		super(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.plata = plata;
		this.isDeleted = isDeleted;
	}


	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", isDeleted=" + isDeleted + ", id=" + id + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", telefon="
				+ telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}

	
	
	
	
}
