package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import CRUD.CRUDOperacije;
import model.Automobil;
import model.Musterija;
import model.ServisAutomobila;
import model.Serviser;
import model.ServisnaKnjizica;

public class UcitajServisneKnjizice {

	public static ArrayList<ServisnaKnjizica> prikaziServisneKnjizice() { 
	
	ArrayList<ServisnaKnjizica> servisneknjizice = new ArrayList<ServisnaKnjizica>();
	try {
		
		File file = new File("src/fajlovi/servisneknjizice.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null){
			String[] lineSplit = (line.split("\\|"));
			int id = Integer.parseInt(lineSplit[0]);
			String automobilId = lineSplit[1];
			Automobil vlasnistvo = CRUDOperacije.nadjiAutomobil(automobilId);
			String obavljeniServisi = lineSplit[2];
			int isDeleted = Integer.parseInt(lineSplit[3]);
			ServisnaKnjizica servisna1 = new ServisnaKnjizica(id, vlasnistvo, obavljeniServisi, isDeleted);
			servisneknjizice.add(servisna1);	
		}
			reader.close();
		} catch(IOException e) {
			System.out.println("Desila se greska!");
		}
		return servisneknjizice;
			
	}	
}