package model;

import java.util.ArrayList;
import java.util.List;

public class ServisnaKnjizica {
	
	public int id;
	public Automobil vlasnistvo;
	public String obavljeniServisi;
	public int isDeleted;
	
	public ServisnaKnjizica() {
		this.id = 0;
		this.vlasnistvo = new Automobil();
		this.obavljeniServisi = "";
		this.isDeleted = 0;

	}
	public ServisnaKnjizica(int id, Automobil vlasnistvo, String obavljeniServisi, int isDeleted) {
		super();
		this.id = id;
		this.vlasnistvo = vlasnistvo;
		this.obavljeniServisi = obavljeniServisi;
		this.isDeleted = isDeleted;
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
	
	
	
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "ServisnaKnjizica [id=" + id + ", vlasnistvo=" + vlasnistvo + ", obavljeniServisi=" + obavljeniServisi
				+ ", isDeleted=" + isDeleted + "]";
	}
	
	
	
	
	

	
	
	
	
	
}
