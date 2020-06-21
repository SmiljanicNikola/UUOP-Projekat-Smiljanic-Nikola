package model;

import java.util.ArrayList;
import java.util.List;

public class ServisnaKnjizica {
	
	public int id;
	public Automobil vlasnistvo;
	public List<ServisAutomobila> listaObavljenihServisa;
	
	public ServisnaKnjizica() {
		this.id = 0;
		this.vlasnistvo = new Automobil();
		this.listaObavljenihServisa = new ArrayList<ServisAutomobila>();

	}

	


	public ServisnaKnjizica(int id, Automobil vlasnistvo, List<ServisAutomobila> listaObavljenihServisa) {
		super();
		this.id = id;
		this.vlasnistvo = vlasnistvo;
		this.listaObavljenihServisa = listaObavljenihServisa;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Automobil getVlasnistvo() {
		return vlasnistvo;
	}

	public void setVlasnistvo(Automobil vlasnistvo) {
		this.vlasnistvo = vlasnistvo;
	}

	public List<ServisAutomobila> getListaObavljenihServisa() {
		return listaObavljenihServisa;
	}

	public void setListaObavljenihServisa(List<ServisAutomobila> listaObavljenihServisa) {
		this.listaObavljenihServisa = listaObavljenihServisa;
	}


	@Override
	public String toString() {
		return "ServisnaKnjizica [id=" + id + ", vlasnistvo=" + vlasnistvo + ", listaObavljenihServisa="
				+ listaObavljenihServisa + "]";
	}

	
	
	
	
	
}
