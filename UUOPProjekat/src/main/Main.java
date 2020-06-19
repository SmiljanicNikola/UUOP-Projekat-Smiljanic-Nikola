package main;

import java.util.ArrayList;

import CRUD.CRUDOperacije;
import gui.IzborLogina;
import gui.LoginProzorMusterija;
import ispis.UcitajAdministratore;
import ispis.UcitajMusterije;
import ispis.UcitajServisere;
import model.Administrator;
import model.Musterija;
import model.Osoba;
import model.Serviser;



public class Main {
	

	public static void main(String[] args) {
		
	
		
		//ispis Musterija iz datoteke
		ArrayList<Musterija> ucitaneMusterije = UcitajMusterije.prikaziMusterije();
		for(Musterija musterija : ucitaneMusterije) {
			System.out.println(musterija);
		} System.out.println("\n");
		
		//ispis servisera iz datoteke
		ArrayList<Serviser> serviseri = UcitajServisere.prikaziServisere();
		for(Serviser serviser : serviseri) {
			System.out.println(serviser);
		} System.out.println("\n");
		
		//ispis administratora iz datoteke
		ArrayList<Administrator> administratori = UcitajAdministratore.prikaziAdministratore();
		for(Administrator administrator: administratori) {
			System.out.println(administrator);
		} System.out.println("\n");
		
		//LoginProzor lp = new LoginProzor(crudoperacije);
		//lp.setVisible(true);
		
		IzborLogina il = new IzborLogina();
		il.setVisible(true);
		
		
		
	}

}
