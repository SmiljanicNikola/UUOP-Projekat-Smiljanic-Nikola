package CRUD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import gui.formeZaDodavanjeIIzmenu.ServisneKnjiziceForma;
import ispis.UcitajAdministratore;
import ispis.UcitajAutomobile;
import ispis.UcitajMusterije;
import ispis.UcitajServiseAutomobila;
import ispis.UcitajServisere;
import ispis.UcitajServisneDelove;
import ispis.UcitajServisneKnjizice;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.Osoba;
import model.ServisAutomobila;
import model.Serviser;
import model.ServisnaKnjizica;
import model.ServisniDeo;

public class CRUDOperacije {
	
	//private ArrayList<Musterija> musterije;
	//private ArrayList<Serviser> serviseri;
	//private ArrayList<Administrator> administratori; 
	
	private ArrayList<Automobil> ucitaniAutomobili = UcitajAutomobile.prikaziAutomobile();
	private static ArrayList<Serviser> ucitaniServiseri = UcitajServisere.prikaziServisere();
	private ArrayList<Administrator> ucitaniAdministratori = UcitajAdministratore.prikaziAdministratore();
	private static ArrayList<Musterija> ucitani = UcitajMusterije.prikaziMusterije();
	private ArrayList<ServisnaKnjizica> ucitaneServisneKnjizice = UcitajServisneKnjizice.prikaziServisneKnjizice();
	private ArrayList<ServisAutomobila> ucitaniServisi = UcitajServiseAutomobila.prikaziServiseAutomobila();
	private ArrayList<ServisniDeo> ucitaniDelovi = UcitajServisneDelove.prikaziServisneDelove();
	
	public CRUDOperacije() {
		//this.musterije = new ArrayList<Musterija>();
		//this.serviseri = new ArrayList<Serviser>();
		//this.ucitaniAdministratori = new ArrayList<Administrator>();
		}
	
	//public ArrayList<Musterija> getMusterije2() {
		//return this.getMusterije();
	//}
	
	public ArrayList<ServisAutomobila> getServiseAutomobila(){
		return ucitaniServisi;
	}
	
	public ArrayList<ServisniDeo> getServisniDeo(){
		return ucitaniDelovi;
	}
	
	public ArrayList<ServisnaKnjizica> getServisneKnjizice(){
		return ucitaneServisneKnjizice;
	}
	
	public ArrayList<Automobil> getAutomobile(){
		return ucitaniAutomobili;
	}
	
	public ArrayList<Administrator> getAdministratore(){
		return ucitaniAdministratori;
	}
	
	public ArrayList<Serviser> getServisere(){
		return ucitaniServiseri;
	}
	
	public ArrayList< Musterija> getMusterije(){
		return ucitani;
	}
	
	public void dodajServisAutomobila(ServisAutomobila servisautomobila) {
		this.ucitaniServisi.add(servisautomobila);
	}
	
	public void dodajServisniDeo(ServisniDeo servisnideo) {
		this.ucitaniDelovi.add(servisnideo);
	}
	
	public void dodajAutomobil(Automobil automobil) {
		this.ucitaniAutomobili.add(automobil);
	}
	
	public void dodajServisnuKnjizicu(ServisnaKnjizica servisnaknjKnjizica) {
		this.ucitaneServisneKnjizice.add(servisnaknjKnjizica);
	}
	
	public void dodajServisera(Serviser serviser) {
		this.ucitaniServiseri.add(serviser);
	}
	
	public void dodajMusteriju(Musterija musterija) {
		this.ucitani.add(musterija);

	}
	
	public void DodajAdministratora(Administrator administrator) {
		this.ucitaniAdministratori.add(administrator);
	}
	
	
	public void obrisiMusteriju(Musterija musterija1) {
		
		this.ucitani.remove(musterija1);
	}
	
	
	public Musterija login(String korisnickoIme, String lozinka) {
		ArrayList<Musterija> ucitaneMusterije = UcitajMusterije.prikaziMusterije();
		for(Musterija musterija : ucitaneMusterije) {
			if(musterija.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && musterija.getLozinka().contentEquals(lozinka)) {
				return musterija;
			}
		}
		return null;
	}
	
	
	public Serviser loginServiser(String korisnickoIme, String lozinka) {
		for(Serviser serviser : ucitaniServiseri) {
			if(serviser.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && serviser.getLozinka().contentEquals(lozinka)) {
				return serviser;
			}
		}
		return null;
	}
	
	
	public Administrator loginAdministrator(String korisnickoIme, String lozinka) {
		for(Administrator administrator : ucitaniAdministratori) {
			if(administrator.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && administrator.getLozinka().contentEquals(lozinka)) {
				return administrator;
			}
		}
		return null;
	}
	
	public void snimiServisere() {
		try {
			File file = new File("src/fajlovi/serviseri.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(Serviser serviser : ucitaniServiseri) {
				sadrzaj += serviser.getId() + "|" + serviser.getIme() + "|" + serviser.getPrezime() + "|" + serviser.getJmbg() + "|" + serviser.getPol() + "|" +  serviser.getAdresa() + "|" + serviser.getTelefon() + "|" + serviser.getKorisnickoIme() + "|" + serviser.getLozinka() + "|" + serviser.getPlata() + "|" + serviser.getSpecijalizacija() + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void snimiServisneDelove() {
		try {
			File file = new File("src/fajlovi/servisnidelovi.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(ServisniDeo servisnideo : ucitaniDelovi) {
				sadrzaj += servisnideo.getId() + "|" + servisnideo.getMarkaAutomobila() + "|" + servisnideo.getModelAutomobila() + "|" + servisnideo.getCena() +  "|" + servisnideo.getNazivDela()  + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void snimiAutomobile() {
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(Automobil automobil : ucitaniAutomobili) {
				sadrzaj += automobil.getId() + "|" + automobil.getVlasnik() + "|" + automobil.getMarka() + "|" + automobil.getModel() + "|" + automobil.getGodinaProizvodnje() + "|" +  automobil.getZapreminaMotora() + "|" + automobil.getSnagaMotora() + "|" + automobil.getVrstaGoriva() + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void snimiMusterije() {
		try {
			File file = new File("src/fajlovi/musterije.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(Musterija musterija : ucitani) {
				sadrzaj += musterija.getId() + "|" + musterija.getIme() + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getPol() + "|" +  musterija.getAdresa() + "|" + musterija.getTelefon() + "|" + musterija.getKorisnickoIme() + "|" + musterija.getLozinka() + "|" + musterija.getNagradniBodovi() + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void snimiServisneKnjizice(){
		try {
			File file = new File("src/fajlovi/servisneknjizice.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(ServisnaKnjizica servisnaknjizica : ucitaneServisneKnjizice) {
				sadrzaj += servisnaknjizica.getId() + "|" + servisnaknjizica.getVlasnistvo() + "|" + servisnaknjizica.getObavljeniServisi() + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void snimiServiseAutomobila() {
		try {
			File file = new File("src/fajlovi/servisiautomobila.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(ServisAutomobila servisautomobila : ucitaniServisi) {
				sadrzaj += servisautomobila.getId() + "|" + servisautomobila.getServisiraniAutomobil() + "|" + servisautomobila.getServiser() + "|" + servisautomobila.getTerminServisa() + "|" + servisautomobila.getKratakOpis() + "|" +  servisautomobila.getDelovi() + "|" + servisautomobila.getStatusServisa()  + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void snimiAdministratore() {
		try {
			File file = new File("src/fajlovi/administratori.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for(Administrator administrator : ucitaniAdministratori) {
				sadrzaj += administrator.getId() + "|" + administrator.getIme() + "|" + administrator.getPrezime() + "|" + administrator.getJmbg() + "|" + administrator.getPol() + "|" +  administrator.getAdresa() + "|" + administrator.getTelefon() + "|" + administrator.getKorisnickoIme() + "|" + administrator.getLozinka() + "|" + administrator.getPlata() + "\n";
			}
			br.write(sadrzaj);
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//public Automobil nadjiAutomobil(String id) {
		///for (Automobil automobil : ucitaniAutomobili) {
		//	if(automobil.getId() == Integer.parseInt(id) && automobil instanceof Automobil) {	
			//	}
			//}
		//return null;
		//}
	
	
	public Musterija nadjiMusteriju2(String vlasnikId) {
		
		ArrayList<Musterija> musterije = UcitajMusterije.prikaziMusterije();
		for(Musterija musterija : musterije) {
		if(musterija.getId() == Integer.parseInt(vlasnikId) && musterija instanceof Musterija) {
				return musterija;
			}
		}
		return null;
	}
	
	//
	public static Automobil nadjiAutomobil(String automobilId) {
		ArrayList<Automobil> automobili = UcitajAutomobile.prikaziAutomobile();
		for(Automobil automobil : automobili) {
			if((automobil.getId() == Integer.parseInt(automobilId))) {
				return automobil;
			}
		}
		return null;
	}
	public ServisniDeo nadjiDeo(int id) {
		for(ServisniDeo servisnideo : ucitaniDelovi) {
			if(servisnideo.getId() == id) {
				return servisnideo;
			}
		}
		return null;
	}
	
	public Automobil nadjiAutomobil(int id) {
		for(Automobil automobil : ucitaniAutomobili) {
			if(automobil.getId() == id) {
				return automobil;
			}
		}
		return null;
	}
	
	public Administrator nadjiAdministratora(String korisnickoIme) {
		for(Administrator administrator : ucitaniAdministratori) {
			if(administrator.getKorisnickoIme().equals(korisnickoIme)) {
				return administrator;
			}
		}
		return null;
	}
	
	public ServisnaKnjizica nadjiServisnuKnjizicu(int servisnaId) {
		for(ServisnaKnjizica servisnaknjizica : ucitaneServisneKnjizice) {
			if(servisnaknjizica.getId() == servisnaId) {
				return servisnaknjizica;
			}
		}
		return null;
	}
	public ServisAutomobila nadjiServiseAutomobila(int id) {
		for(ServisAutomobila servisautomobila : ucitaniServisi) {
			if(servisautomobila.getId() == id) {
				return servisautomobila;
			}
		}
		return null;
	}
	
	//public Musterija nadjiMusteriju(String oznaka) {
	//	for(Korisnik musterija : korisnici) {
	//		if(musterija.getOznaka().equals(oznaka) && musterija instanceof Musterija) return (Musterija) musterija;
	////	}
		//return null;
	//}

	public static Musterija nadjiMusteriju(String korisnickoIme) {
		for(Musterija musterija : ucitani) {
			if(musterija.getKorisnickoIme().equals(korisnickoIme) && musterija instanceof Musterija) {
				return musterija;
			}
		}
		return null;
	}
	
	public Musterija nadjiMusterijuPoKorisnickom(String korisnickoIme) {
		for(Musterija musterija: ucitani) {
			if(musterija.getKorisnickoIme().equals(korisnickoIme)) return musterija;
		}
		return null;
	}

	
	public static Serviser nadjiServisera(String korisnickoIme) {
		for(Serviser serviser : ucitaniServiseri) {
			if(serviser.getKorisnickoIme().equals(korisnickoIme)) {
				return serviser;
			}
		}
		return null;
	}


	
}

