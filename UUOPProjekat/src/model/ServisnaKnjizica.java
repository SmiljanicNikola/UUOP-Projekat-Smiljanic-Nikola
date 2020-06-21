package model;

import java.util.ArrayList;
import java.util.List;

public class ServisnaKnjizica {
	
	public int id;
	public Automobil vlasnistvo;
	public String obavljeniServisi;
	
	public ServisnaKnjizica() {
		this.id = 0;
		this.vlasnistvo = new Automobil();
		this.obavljeniServisi = "";

	}
	public ServisnaKnjizica(int id, Automobil vlasnistvo, String obavljeniServisi) {
		super();
		this.id = id;
		this.vlasnistvo = vlasnistvo;
		this.obavljeniServisi = obavljeniServisi;
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

	


	public String getObavljeniServisi() {
		return obavljeniServisi;
	}
	public void setObavljeniServisi(String obavljeniServisi) {
		this.obavljeniServisi = obavljeniServisi;
	}
	@Override
	public String toString() {
		return "ServisnaKnjizica [id=" + id + ", vlasnistvo=" + vlasnistvo + ", obavljeniServisi=" + obavljeniServisi
				+ "]";
	}
	
	

	
	
	
	
	
}
