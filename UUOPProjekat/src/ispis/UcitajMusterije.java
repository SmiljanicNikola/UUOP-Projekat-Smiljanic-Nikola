package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import model.Musterija;
import java.io.IOException;

public class UcitajMusterije {

	public static ArrayList<Musterija> prikaziMusterije() { 
		
		ArrayList<Musterija> musterije = new ArrayList<Musterija>();
		
		try {
				
		File file = new File("src/fajlovi/musterije.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null) {
			String[] lineSplit = (line.split("\\|"));
			int id = Integer.parseInt(lineSplit[0]);
			String ime = lineSplit[1];
			String prezime = lineSplit[2];
			String jmbg = lineSplit[3];
			int indeksPola = Integer.parseInt(lineSplit[4]);
			enumeracije.pol pol = enumeracije.pol.values()[indeksPola];
			String adresa = lineSplit[5];
			String brojTelefona = lineSplit[6];
			String korisnickoIme = lineSplit[7];
			String lozinka = lineSplit[8];
			int nagradniBodovi = Integer.parseInt(lineSplit[9]);	
			Musterija musterija1 = new Musterija(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, nagradniBodovi);
			musterije.add(musterija1);
		}
		reader.close(); 
	} catch(IOException e) {
		System.out.println("Greska!");
	}
		return musterije;
	}
}
		
