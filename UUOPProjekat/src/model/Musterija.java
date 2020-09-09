package model;

import java.util.ArrayList;

import ispis.UcitajMusterije;

public class Musterija extends Osoba {
	
	public int nagradniBodovi;
	public int isDeleted;
	
	public Musterija() {
		super();
		this.nagradniBodovi = 0;
		this.isDeleted = 0;
	}

	public Musterija(int id, String ime, String prezime, String jmbg, enumeracije.Pol pol, String adresa, String telefon,
			String korisnickoIme, String lozinka, int nagradniBodovi, int isDeleted) {
		
		super(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
		this.nagradniBodovi = nagradniBodovi;
		this.isDeleted = isDeleted;
	}

	public int getNagradniBodovi() {
		return nagradniBodovi;
	}

	public void setNagradniBodovi(int nagradniBodovi) {
		this.nagradniBodovi = nagradniBodovi;
	}

	
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Musterija [nagradniBodovi=" + nagradniBodovi + ", isDeleted=" + isDeleted + ", id=" + id + ", ime="
				+ ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", telefon="
				+ telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}

	
	
}
