package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import enumeracije.Pol;
import ispis.UcitajMusterije;
import model.Musterija;
import model.Osoba;
import net.miginfocom.swing.MigLayout;





public class MusterijeForma extends JFrame {
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(8);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(15);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblTelefon = new JLabel("Telefon");
	private JTextField txtTelefon = new JTextField(20);
	private JLabel lblkorisnickoIme = new JLabel("korisnickoIme");
	private JTextField txtkorisnickoIme = new JTextField(20);
	private JLabel lblSifra = new JLabel("Sifra");
	private JPasswordField pfSifra = new JPasswordField(20);
	private JLabel lblnagradniBodovi = new JLabel("Nagradni bodovi");
	private JTextField txtnagradniBodovi = new JTextField(10);
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	private Musterija musterija;
	CRUDOperacije Crudoperacije = new CRUDOperacije();

	
	public MusterijeForma(CRUDOperacije Crudoperacije, Musterija musterija) {
		this.Crudoperacije = Crudoperacije;
		this.musterija = musterija;
		if(musterija == null) {
			setTitle("Dodavanje musterije");
		} else {
			 setTitle("Izmena podataka - " + musterija.getId());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	public void initGUI() {
		MigLayout layout = new MigLayout("wrap 2","[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(musterija != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblPol);
		add(cbPol);
		add(lblAdresa);
		add(txtAdresa);
		add(lblTelefon);
		add(txtTelefon);
		add(lblkorisnickoIme);
		add(txtkorisnickoIme);
		add(lblSifra);
		add(pfSifra);
		add(lblnagradniBodovi);
		add(txtnagradniBodovi);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		
	}
	
	public void initActions() {
		btnOk.addActionListener(new ActionListener() {
			private ArrayList<Musterija> ucitani = UcitajMusterije.prikaziMusterije();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String adresa = txtAdresa.getText().trim();
					String telefon = txtTelefon.getText().trim();
					String korisnickoIme = txtkorisnickoIme.getText().trim();
					String sifra = new String(pfSifra.getPassword()).trim();
					int nagradniBodovi = Integer.parseInt(txtnagradniBodovi.getText().trim());
					Integer isDeleted = 0;
					
					if(musterija == null) { //Dodaj:
					Musterija musterija = new Musterija(id, ime, prezime, jmbg, pol, adresa, telefon, korisnickoIme, sifra, nagradniBodovi, isDeleted);
					Crudoperacije.dodajMusteriju(musterija);
					} else { //Izmeni:
						musterija.setId(id);
						musterija.setIme(ime);
						musterija.setPrezime(prezime);
						musterija.setJmbg(jmbg);
						musterija.setPol(pol);
						musterija.setAdresa(adresa);
						musterija.setTelefon(telefon);
						musterija.setKorisnickoIme(korisnickoIme);
						musterija.setLozinka(sifra);
						musterija.setNagradniBodovi(nagradniBodovi);
					}
					 Crudoperacije.snimiMusterije();
					 MusterijeForma.this.dispose();
					 MusterijeForma.this.setVisible(false);
				}
				
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijeForma.this.dispose();
				MusterijeForma.this.setVisible(false);
				
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(musterija.getId()));
		txtIme.setText(musterija.getIme());
		txtPrezime.setText(musterija.getPrezime());
		txtJmbg.setText(musterija.getJmbg());
		cbPol.setSelectedItem(musterija.getPol());
		txtAdresa.setText(musterija.getAdresa());
		txtTelefon.setText(musterija.getTelefon());
		txtkorisnickoIme.setText(musterija.getKorisnickoIme());
		pfSifra.setText(musterija.getLozinka());
		txtnagradniBodovi.setText(String.valueOf(musterija.getNagradniBodovi()));
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popraviti sledece greske u unosu: \n";
		
		try {
			Integer.parseInt(txtId.getText().trim());
		} catch(NumberFormatException e) {
			poruka += "Id mora biti broj \n";
			ok = false;
		}
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "Unesite ime \n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "Unesite prezime \n";
			ok = false;
		}
		if(txtJmbg.getText().trim().equals("")) {
			poruka += "Unesite jmbg \n";
			ok = false;
		}
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "Unesite adresu \n";
			ok = false;
		}
		if(txtTelefon.getText().trim().equals("")) {
			poruka += "Unesite telefon \n";
			ok = false;
		}
		if(txtkorisnickoIme.getText().trim().equals("")) {
			poruka += "Unesite korisniko ime \n";
			ok = false;
		}
		String sifra = new String(pfSifra.getPassword()).trim();
		if(sifra.equals("")) {
			poruka += "Unesite sifru \n";
			ok = false;
		}
		try {
			Integer.parseInt(txtnagradniBodovi.getText().trim());
		} catch(NumberFormatException e) {
			poruka += "Atribut 'nagradni bodovi' mora biti broj \n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "neispravni podaci", JOptionPane.WARNING_MESSAGE);	
		}
		return ok;
	}
	
	
}
