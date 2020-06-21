package main;

import java.util.ArrayList;
import CRUD.CRUDOperacije;
import gui.LoginProzorMusterija;
import ispis.UcitajAdministratore;
import ispis.UcitajAutomobile;
import ispis.UcitajMusterije;
import ispis.UcitajServiseAutomobila;
import ispis.UcitajServisere;
import ispis.UcitajServisneDelove;
import ispis.UcitajServisneKnjizice;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.ServisAutomobila;
import model.Serviser;
import model.ServisnaKnjizica;
import model.ServisniDeo;
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
		ArrayList<Automobil> ucitaniAutomobili = UcitajAutomobile.prikaziAutomobile();
		for(Automobil automobil : ucitaniAutomobili) {
			System.out.println(automobil);
		}
		
		System.out.println("\n");
		System.out.println("Citanje iz datoteke 'servisneknjizice.txt' : \n");
		ArrayList<ServisnaKnjizica> servisneknjizice = UcitajServisneKnjizice.prikaziServisneKnjizice();
		for(ServisnaKnjizica servisnaknjizica : servisneknjizice) {
			System.out.println(servisnaknjizica);
		}
		
		System.out.println("\n");
		System.out.println("Citanje iz datoteke 'servisnidelovi.txt : \n");
		ArrayList<ServisniDeo> servisnidelovi = UcitajServisneDelove.prikaziServisneDelove();
		for(ServisniDeo servisnideo : servisnidelovi ) {
			System.out.println(servisnideo);
		}
		
		System.out.println("\n");
		System.out.println("Citanje iz datoteke 'servisiautomobila.txt : \n");
		ArrayList<ServisAutomobila> servisiautomobila = UcitajServiseAutomobila.prikaziServiseAutomobila();
		for(ServisAutomobila servisautomobila : servisiautomobila ) {
			System.out.println(servisautomobila);
		}

		//Musterija musterija1 = new Musterija(1, "Stefan", "Lodge", "51515", "ghaha", "adresaa", "telefon", "fafa", "loz", 14);
		//crudOperacije.dodajMusteriju(musterija1);
		//ucitaneMusterije.add(musterija1);
		
		//System.out.println("\n U listi 'ucitaneMusterije' nalaze se sledece musterije: \n");
		
		//for(Musterija musterija : ucitaneMusterije) {
		//	System.out.println(musterija);
		//}
	
		//upis.upisiServisere.snimiServisere();
		//upis.upisiAdministratore.snimiAdministratore();
		//upis.upisiMusterije.snimiMusterije();
		
		//LoginProzor lp = new LoginProzor();
		//lp.setVisible(true);
	}
	    
	
}
