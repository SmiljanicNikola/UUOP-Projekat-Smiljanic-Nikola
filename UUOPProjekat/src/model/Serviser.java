package model;

public class Serviser extends Osoba {
	
	public double plata;
	public enumeracije.specijalizacija specijalizacija;
	public int isDeleted;
	
	public Serviser() {
		super();
		this.plata = 0;
		this.specijalizacija = enumeracije.specijalizacija.automehanicar;
		this.isDeleted = 0;
		
	}

	

	public Serviser(int id, String ime, String prezime, String jmbg, enumeracije.Pol pol, String adresa, String telefon,
			String korisnickoIme, String lozinka, double plata, enumeracije.specijalizacija specijalizacija, int isDeleted) {
		super(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
		this.isDeleted = isDeleted;
	}



	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}


	public enumeracije.specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}



	public void setSpecijalizacija(enumeracije.specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}


	public int getIsDeleted() {
		return isDeleted;
	}



	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}



	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", isDeleted=" + isDeleted
				+ ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", adresa=" + adresa + ", telefon=" + telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + "]";
	}



	
	
	
	
	
	
}
