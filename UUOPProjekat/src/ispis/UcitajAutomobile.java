package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Administrator;
import model.Automobil;
import model.Musterija;
import CRUD.CRUDOperacije;
import enumeracije.Pol;
import enumeracije.marka;
import enumeracije.model;
import enumeracije.vrstaGoriva;


public class UcitajAutomobile {
	//!!!
	public static ArrayList<Automobil> prikaziAutomobile() {

		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = (line.split("\\|"));
				int id = Integer.parseInt(lineSplit[0]);
				String korisnickoIme = lineSplit[1];
				Musterija vlasnik = CRUDOperacije.nadjiMusteriju(korisnickoIme);
				marka marka = enumeracije.marka.valueOf(lineSplit[2]);
				model model = enumeracije.model.valueOf(lineSplit[3]);
				int godinaProizvodnje = Integer.parseInt(lineSplit[4]);
				String zapreminaMotora = lineSplit[5];
				String snagaMotora = lineSplit[6];
				vrstaGoriva vrstaGoriva = enumeracije.vrstaGoriva.valueOf(lineSplit[7]);
				int isDeleted = Integer.parseInt(lineSplit[8]);
				Automobil automobil1 = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora,vrstaGoriva, isDeleted);
				automobili.add(automobil1);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska!");
		}
		return automobili;
	}

		//private static Musterija nadjiMusteriju(String vlasnikId) {
	
		//ArrayList<Musterija> musterije = UcitajMusterije.prikaziMusterije();
		//for(Musterija musterija : musterije) {
		//if(musterija.getId() == Integer.parseInt(vlasnikId) && musterija instanceof Musterija) {
		//		return musterija;
		///	}
		//}
		//return null;
	//}

}