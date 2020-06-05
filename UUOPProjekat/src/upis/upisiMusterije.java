package upis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Musterija;

public class upisiMusterije {
	
	public static void snimiMusterije(){
		ArrayList<Musterija> musterije = new ArrayList<Musterija>();
		try {
			File file1 = new File("src/fajlovi/musterije.txt");
			String content = "";
			for(Musterija musterija : musterije) {
				content += musterija.getId() + "|" + musterija.getIme()
					+ "|" + musterija.getPrezime() + "|" + musterija.getJmbg()
					+ "|" + musterija.getPol() + "|" + musterija.getAdresa() 
					+ "|" + musterija.getTelefon() + "|" + musterija.getKorisnickoIme() 
					+ "|" + musterija.getLozinka() + "|" + musterija.getNagradniBodovi() + "\n";	
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
				writer.write(content);
				writer.close();
		}catch (IOException e) {
			System.out.println("Greska!");
		}
	
	}
	
}
