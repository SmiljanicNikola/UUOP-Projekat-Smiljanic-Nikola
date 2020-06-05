package CRUD;

import java.util.ArrayList;

import model.Administrator;
import model.Musterija;
import model.Serviser;

public class CRUDOperacije {
	
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Administrator> administratori;

	public CRUDOperacije() {
		this.musterije = new ArrayList<Musterija>();
		this.serviseri = new ArrayList<Serviser>();
		this.administratori = new ArrayList<Administrator>();
		}
	
	public ArrayList< Musterija> getMusterije(){
		return musterije;
	}
	
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}
	
	public void obrisiMusteriju(Musterija musterija1) {
		this.musterije.remove(musterija1);
	}
}
