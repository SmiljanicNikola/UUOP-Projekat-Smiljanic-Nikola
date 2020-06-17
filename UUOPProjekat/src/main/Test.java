package main;

import java.util.ArrayList;
import CRUD.CRUDOperacije;

import ispis.UcitajAdministratore;
import ispis.UcitajAutomobile;
import ispis.UcitajMusterije;
import ispis.UcitajServisere;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.Serviser;
import upis.upisiMusterije;

public class Test {
	
	//public static String ADMINISTRATORI_FAJL = "administratori.txt";
	// static String AUTOMOBILI_FAJL = "automobili.txt";
	//public static String MUSTERIJE_FAJL = "musterije.txt";
	//public static String SERVISERI_FAJL = "serviseri.txt";
	//public static String SERVISIAUTOMOBILA_FAJL = "servisiautomobila.txt";
	//public static String SERVISNJEKNJIZICE_FAJL = "servisneknjizice.txt";
	//public static String SERVISNIDELOVI_FAJL = "servisnidelovi.txt";
	
	
	
	
	public static void main(String[] args) {
	
		
		CRUDOperacije crudOperacije = new CRUDOperacije();
		
		System.out.println("\nCitanje iz datoteke 'musterije.txt' : \n");
		
		ArrayList<Musterija> ucitaneMusterije = UcitajMusterije.prikaziMusterije();
		for(Musterija musterija : ucitaneMusterije) {
			System.out.println(musterija);
		}
		
		System.out.println("\nCitanje iz datoteke 'serviseri.txt' : \n");
	
		ArrayList<Serviser> serviseri = UcitajServisere.prikaziServisere();
		for(Serviser serviser : serviseri) {
			System.out.println(serviser);
		}
		
		System.out.println("\n Citanje iz datoteke 'administratori.txt' : \n");
		
		ArrayList<Administrator> administratori = UcitajAdministratore.prikaziAdministratore();
		for(Administrator administrator: administratori) {
			System.out.println(administrator);
		}
		
		System.out.println("\n Citanje iz datoteke 'automobili.txt' : \n");
		ArrayList<Automobil> automobili = UcitajAutomobile.prikaziAutomobile();
		for(Automobil automobil : automobili) {
			System.out.println(automobil);
		}
		
		
		System.out.println("\n U listi 'ucitaneMusterije' nalaze se sledece musterije: \n");
		

		//Musterija musterija1 = new Musterija(1, "Stefan", "Lodge", "51515", "ghaha", "adresaa", "telefon", "fafa", "loz", 14);
		//crudOperacije.dodajMusteriju(musterija1);
		//ucitaneMusterije.add(musterija1);
		
		for(Musterija musterija : ucitaneMusterije) {
			System.out.println(musterija);
		}
	
		//upis.upisiServisere.snimiServisere();
		upis.upisiAdministratore.snimiAdministratore();
	}
	    
	
}
