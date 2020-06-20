package model;

public abstract class Osoba {
	
	protected int id;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected enumeracije.Pol pol;
	protected String adresa;
	protected String telefon;
	protected String korisnickoIme;
	protected String lozinka;
	
	public Osoba() {
		this.id = 0;
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = enumeracije.Pol.muski;
		this.adresa = "";
		this.telefon = "";
		this.korisnickoIme = "";
		this.lozinka = "";
	}

	public Osoba(int id, String ime, String prezime, String jmbg, enumeracije.Pol pol, String adresa, String telefon,
			String korisnickoIme, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.telefon = telefon;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public enumeracije.Pol getPol() {
		return pol;
	}

	public void setPol(enumeracije.Pol pol) {
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
		return "Osoba [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", adresa=" + adresa + ", telefon=" + telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + "]";
	}
	
	
	
}
