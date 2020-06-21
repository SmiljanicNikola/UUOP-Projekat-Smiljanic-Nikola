package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import CRUD.CRUDOperacije;
import enumeracije.marka;
import enumeracije.statusServisa;
import model.Automobil;
import model.ServisAutomobila;
import model.Serviser;
import model.ServisnaKnjizica;
import model.ServisniDeo;

public class UcitajServiseAutomobila {
	
public static ArrayList<ServisAutomobila> prikaziServiseAutomobila() { 
		
	
	ArrayList<ServisAutomobila> servisiautomobila = new ArrayList<ServisAutomobila>();
	try {
		File file = new File("src/fajlovi/servisiautomobila.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null){
			String[] lineSplit = (line.split("\\|"));
			int id = Integer.parseInt(lineSplit[0]);
			String automobilId = lineSplit[1];
			Automobil servisiraniAutomobil = CRUDOperacije.nadjiAutomobil(automobilId);
			String korisnickoIme = lineSplit[2];
			Serviser serviser = CRUDOperacije.nadjiServisera(korisnickoIme);
			String terminServisa = lineSplit[3];
			String kratakOpis = lineSplit[4];
			String delovi = lineSplit[5];
			statusServisa statusServisa = enumeracije.statusServisa.valueOf(lineSplit[6]);
			ServisAutomobila servisautomobila1 = new ServisAutomobila(id, servisiraniAutomobil, serviser, terminServisa, kratakOpis, delovi, statusServisa);
			servisiautomobila.add(servisautomobila1);
		}
			reader.close();
		} catch(IOException e) {
			System.out.println("Desila se greska!");
		}
		return servisiautomobila;
			
	}	
}
