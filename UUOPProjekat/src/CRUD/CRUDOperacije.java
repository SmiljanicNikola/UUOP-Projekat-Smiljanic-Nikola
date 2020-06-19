package CRUD;

import java.util.ArrayList;

import ispis.UcitajAdministratore;
import ispis.UcitajAutomobile;
import ispis.UcitajMusterije;
import ispis.UcitajServisere;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.Osoba;
import model.Serviser;

public class CRUDOperacije {
	
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Administrator> administratori; 
	
	private ArrayList<Serviser> ucitaniServiseri = UcitajServisere.prikaziServisere();
	private ArrayList<Administrator> ucitaniAdministratori = UcitajAdministratore.prikaziAdministratore();
	private ArrayList<Automobil> ucitaniAutomobili = UcitajAutomobile.prikaziAutomobile();
	private ArrayList<Musterija> ucitani = UcitajMusterije.prikaziMusterije();
	
	
	public CRUDOperacije() {
		this.musterije = new ArrayList<Musterija>();
		this.serviseri = new ArrayList<Serviser>();
		this.administratori = new ArrayList<Administrator>();
		}
	
	public ArrayList< Musterija> getMusterije(){
		return ucitani;
	}
	
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
 

	}
	
	public void obrisiMusteriju(Musterija musterija1) {
		this.musterije.remove(musterija1);
	}
	
	public Musterija login(String korisnickoIme, String lozinka) {
		ArrayList<Musterija> ucitaneMusterije = UcitajMusterije.prikaziMusterije();
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
	
	//public Automobil nadjiAutomobil(String id) {
		///for (Automobil automobil : ucitaniAutomobili) {
		//	if(automobil.getId() == Integer.parseInt(id) && automobil instanceof Automobil) {	
			//	}
			//}
		//return null;
		//}
	///
	public static Musterija nadjiMusteriju(String id) {
		
		ArrayList<Musterija> musterije = UcitajMusterije.prikaziMusterije();
		for(Musterija musterija : musterije) {
		if(musterija.getId() == Integer.parseInt(id) && musterija instanceof Musterija) {
				return musterija;
			}
		}
		return null;
	}
	public static Automobil nadjiAutomobil(String automobilId) {
		ArrayList<Automobil> automobili = UcitajAutomobile.prikaziAutomobile();
		for(Automobil automobil : automobili) {
			if(automobil.getId() == Integer.parseInt(automobilId) && automobil instanceof Automobil) {
				return automobil;
			}
		}
		return null;
	}
	
}
	//promenio sam u nadji musterija vlasnikId u id!!!
