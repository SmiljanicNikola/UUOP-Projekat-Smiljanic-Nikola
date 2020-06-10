package upis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class upisiAdministratore {

	public static String ucitajIzFajla() {
		String sadrzaj = "";
		File file = new File("src/fajlovi/musterije.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				sadrzaj += line + "\n";
				
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Greska!");
		}
		return sadrzaj;
	}

	public static void snimiAdministratore(){
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Unesite id: ");
		int id = scanner.nextInt();
		scanner.hasNextLine();
		
		System.out.println("Unesite ime: ");
		String ime = scanner.nextLine();
		
		System.out.println("Unesite prezime: ");
		String prezime = scanner.nextLine();
		
		System.out.println("Unesite jmbg: ");
		String jmbg = scanner.nextLine();
		
		System.out.println("Unesite pol: ");
		String pol = scanner.nextLine();
		
		System.out.println("Unesite adresu: ");
		String adresa = scanner.nextLine();
		
		System.out.println("Unesite telefon: ");
		String telefon = scanner.nextLine();
		
		System.out.println("Unesite korisnickoIme: ");
		String korisnickoIme = scanner.nextLine();
		
		System.out.println("Unesite lozinku: ");
		String lozinka = scanner.nextLine();
		
		System.out.println("Unesite platu: ");
		int plata = scanner.nextInt(); 
		scanner.hasNextLine();
		
		scanner.close();
		String stari = ucitajIzFajla();
		String sadrzaj = id + "|" + ime + "|" + prezime + "|" + jmbg + "|" + pol + "|" + adresa + "|" + telefon + "|" + korisnickoIme + "|" + lozinka + "|" + plata;  
		try {
			
	File upisUFajl = new File("src/fajlovi/administratori.txt");
	BufferedWriter writer = new BufferedWriter(new FileWriter(upisUFajl));
	writer.write(stari + sadrzaj);
	writer.close();
			}
		catch(IOException e) {
			System.out.println("Greska!");
			}
		}
	}