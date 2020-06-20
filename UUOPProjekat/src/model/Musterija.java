package model;

import java.util.ArrayList;

import ispis.UcitajMusterije;

public class Musterija extends Osoba {
	
	public int nagradniBodovi;
	
	public Musterija() {
		super();
		this.nagradniBodovi = 0;
	}

	public Musterija(int id, String ime, String prezime, String jmbg, enumeracije.Pol pol, String adresa, String telefon,
			String korisnickoIme, String lozinka, int nagradniBodovi) {
		super(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka);
	
		this.nagradniBodovi = nagradniBodovi;
	}

	public int getNagradniBodovi() {
		return nagradniBodovi;
	}

	public void setNagradniBodovi(int nagradniBodovi) {
		this.nagradniBodovi = nagradniBodovi;
	}

	@Override
	public String toString() {
		return "Musterija [nagradniBodovi=" + nagradniBodovi + ", id=" + id + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", telefon="
				+ telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}

	
}
