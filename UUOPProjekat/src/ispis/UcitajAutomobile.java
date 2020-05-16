package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Automobil;
import model.Musterija;

public class UcitajAutomobile {
	
	public static ArrayList<Automobil> prikaziAutomobile() {
		
		
		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = (line.split("\\|"));
				int id = Integer.parseInt(lineSplit[0]);
				Object vlasnik = lineSplit[1];
				String marka = lineSplit[2];
				String model = lineSplit[3];
				int godinaProizvodnje = Integer.parseInt(lineSplit[4]);
				String zapreminaMotora = lineSplit[5];
				String snagaMotora = lineSplit[6];
				String vrstaGoriva = lineSplit[7];
				Automobil automobil1 = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva);
				automobili.add(automobil1);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska!");
		}
		return automobili;
	}

}