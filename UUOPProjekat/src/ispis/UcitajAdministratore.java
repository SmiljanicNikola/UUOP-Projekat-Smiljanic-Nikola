package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Administrator;

public class UcitajAdministratore {
	
	public static ArrayList<Administrator> prikaziAdministratore() {
		
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		
		try {
			File file = new File("src/fajlovi/administratori.txt");
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
				String telefon = lineSplit[6];
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				int nagradniBodovi = Integer.parseInt(lineSplit[9]);
				Administrator administrator1 = new Administrator(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, lozinka, nagradniBodovi);
				administratori.add(administrator1);
				
				
			}
			reader.close();
			
		} catch(IOException e) {
			System.out.println("Desila se greska!");
		}
		return administratori;
	}
	
}
