package main;

import java.util.ArrayList;

import ispis.UcitajAdministratore;
import ispis.UcitajAutomobile;
import ispis.UcitajMusterije;
import ispis.UcitajServisere;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.Serviser;

public class Test {

	public static void main(String[] args) {
	

		Musterija musterija2 = new Musterija(1, "Stefan", "Lazic", "40005000", "Muski", "Gunduliceva2", "06541212", "stefanl", "6789", 2);
		System.out.println("Podaci za musteriju su: " + musterija2);
		
		Automobil automobil2 = new Automobil(2, musterija2, "Audi", "A4", 2011, "2000cm3", "140KS", "Dizel");
		System.out.println("Podaci o automobilu su: " + automobil2);
		
		System.out.println("\nCitanje iz datoteke 'musterije.txt' : \n");
		
		ArrayList<Musterija> musterije = UcitajMusterije.prikaziMusterije();
		
		for(Musterija musterija : musterije) {
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
		
	}	
}
