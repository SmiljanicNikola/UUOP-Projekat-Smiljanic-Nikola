package model;

public abstract class Osoba {
	
	protected int idOsoba;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String pol;
	protected String adresa;
	protected String telefon;
	protected String korisnickoIme;
	protected String lozinka;
	
	public Osoba() {
		this.idOsoba = 0;
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = "";
		this.adresa = "";
		this.telefon = "";
		this.korisnickoIme = "";
		this.lozinka = "";
	}

	public Osoba(int idOsoba, String ime, String prezime, String jmbg, String pol, String adresa, String telefon,
			String korisnickoIme, String lozinka) {
		super();
		this.idOsoba = idOsoba;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.telefon = telefon;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public int getIdOsoba() {
		return idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Osoba [idOsoba=" + idOsoba + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", adresa=" + adresa + ", telefon=" + telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + "]";
	}
	
	
	
}
