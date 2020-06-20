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


public class UcitajAutomobile {
	
	CRUDOperacije crudoperacije = new CRUDOperacije();
	
	public static ArrayList<Automobil> prikaziAutomobile() {
		
		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = (line.split("\\|"));
				int id = Integer.parseInt(lineSplit[0]);
				String vlasnikId = lineSplit[1];
				Musterija vlasnik = CRUDOperacije.nadjiMusteriju2(vlasnikId);
				String marka = lineSplit[2];
				String model = lineSplit[3];
				int godinaProizvodnje = Integer.parseInt(lineSplit[4]);
				String zapreminaMotora = lineSplit[5];
				String snagaMotora = lineSplit[6];
				int indeksGoriva = Integer.parseInt(lineSplit[7]);
				enumeracije.vrstaGoriva vrstaGoriva = enumeracije.vrstaGoriva.values()[indeksGoriva];
				Automobil automobil1 = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva);
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