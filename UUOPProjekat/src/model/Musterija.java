package model;

public class Musterija extends Osoba {
	
	public int id;
	public int nagradniBodovi;
	
	public Musterija() {
		super();
		this.id = 0;
		this.nagradniBodovi = 0;
	}

	public Musterija(int idOsoba, String ime, String prezime, String jmbg, String pol, String adresa, String telefon,
			String korisnickoIme, String lozinka, int id, int nagradniBodovi) {
		super(idOsoba, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.id = id;
		this.nagradniBodovi = nagradniBodovi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNagradniBodovi() {
		return nagradniBodovi;
	}

	public void setNagradniBodovi(int nagradniBodovi) {
		this.nagradniBodovi = nagradniBodovi;
	}

	@Override
	public String toString() {
		return "Musterija [id=" + id + ", nagradniBodovi=" + nagradniBodovi + ", idOsoba=" + idOsoba + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", telefon="
				+ telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	
	
	
}
