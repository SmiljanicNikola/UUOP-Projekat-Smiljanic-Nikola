package CRUD;

import java.util.ArrayList;

import ispis.UcitajAdministratore;
import ispis.UcitajMusterije;
import ispis.UcitajServisere;
import model.Administrator;
import model.Musterija;
import model.Osoba;
import model.Serviser;

public class CRUDOperacije {
	
	ArrayList<Musterija> ucitaneMusterije = UcitajMusterije.prikaziMusterije();
	ArrayList<Serviser> ucitaniServiseri = UcitajServisere.prikaziServisere();
	ArrayList<Administrator> ucitaniAdministratori = UcitajAdministratore.prikaziAdministratore();
	
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Administrator> administratori; 
	
	public CRUDOperacije() {
		this.musterije = new ArrayList<Musterija>();
		this.serviseri = new ArrayList<Serviser>();
		this.administratori = new ArrayList<Administrator>();
		}
	
	public ArrayList< Musterija> getMusterije(){
		return musterije;
	}
	
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
 

	}
	
	public void obrisiMusteriju(Musterija musterija1) {
		this.musterije.remove(musterija1);
	}
	
	public Musterija login(String korisnickoIme, String lozinka) {
		for(Musterija musterija : ucitaneMusterije) {
			if(musterija.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && musterija.getLozinka().contentEquals(lozinka)) {
				return musterija;
			}
		}
		return null;
	}
	
	public Serviser loginServiser(String korisnickoIme, String lozinka) {
		for(Serviser serviser : ucitaniServiseri) {
			if(serviser.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && serviser.getLozinka().contentEquals(lozinka)) {
				return serviser;
			}
		}
		return null;
	}
	
	public Administrator loginAdministrator(String korisnickoIme, String lozinka) {
		for(Administrator administrator : ucitaniAdministratori) {
			if(administrator.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && administrator.getLozinka().contentEquals(lozinka)) {
				return administrator;
			}
		}
		return null;
	}
}
