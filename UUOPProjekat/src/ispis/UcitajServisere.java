package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Serviser;

public class UcitajServisere {
	
	public static ArrayList<Serviser> prikaziServisere() { 
		
		
		ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
		
		try {
				
		File file = new File("src/fajlovi/serviseri.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null) {
			String[] lineSplit = (line.split("\\|"));
			int idOsobe = Integer.parseInt(lineSplit[0]);
			String ime = lineSplit[1];
			String prezime = lineSplit[2];
			String jmbg = lineSplit[3];
			String pol = lineSplit[4];
			String adresa = lineSplit[5];
			String brojTelefona = lineSplit[6];
			String korisnickoIme = lineSplit[7];
			String lozinka = lineSplit[8];
			int id = Integer.parseInt(lineSplit[9]);
			double plata = Double.parseDouble(lineSplit[10]);
			String specijalizacija = lineSplit[11];	
			Serviser serviser1 = new Serviser(idOsobe, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, id, plata, specijalizacija);
			serviseri.add(serviser1);
		}
		reader.close(); 
	} catch(IOException e) {
		System.out.println("Greska!");
	}
		return serviseri;
	}
}

