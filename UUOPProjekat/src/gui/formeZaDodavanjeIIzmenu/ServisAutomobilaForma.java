package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import enumeracije.statusServisa;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.ServisAutomobila;
import model.Serviser;
import net.miginfocom.swing.MigLayout;
import enumeracije.Pol;


public class ServisAutomobilaForma extends JFrame {

	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(8);
	
	private JLabel lblServisiraniAutomobil = new JLabel("Servisirani Automobil");
	private JComboBox<Integer> cbAutomobil = new JComboBox<Integer>();
	
	private JLabel lblServiser = new JLabel("Serviser");
	private JComboBox<String> cbServiser = new JComboBox<String>();
	
	private JLabel lblTerminServisa = new JLabel("Termin Servisa");
	private JTextField txtTerminServisa = new JTextField(15);
	
	private JLabel lblKratakOpis= new JLabel("KratakOpis");
	private JTextField txtKratakOpis = new JTextField(20);
	
	private JLabel lblDelovi = new JLabel("Delovi");
	private JTextField txtDelovi = new JTextField(20);
	
	private JLabel lblStatusServisa = new JLabel("StatusServisa");
	private JComboBox<statusServisa> cbStatusServisa = new JComboBox<statusServisa>(statusServisa.values());
	
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private ServisAutomobila servisautomobila;

	public ServisAutomobilaForma(CRUDOperacije Crudoperacije, ServisAutomobila servisautomobila) {
		this.Crudoperacije = Crudoperacije;
		this.servisautomobila = servisautomobila;
				
		if (servisautomobila == null) {
			setTitle("Dodavanje servisa");
		} else {
			setTitle("Izmena podataka - " + servisautomobila.getId());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	public void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		
		
		for(Automobil servisiraniautomobil : Crudoperacije.getAutomobile()) {
			if(servisiraniautomobil instanceof Automobil) cbAutomobil.addItem(servisiraniautomobil.getId());
		}
		
		for(Serviser serviser : Crudoperacije.getServisere()) {
			if(serviser instanceof Serviser) cbServiser.addItem(serviser.getKorisnickoIme());
		}

		if (servisautomobila != null) {
			popuniPolja();
		}

		add(lblId);
		add(txtId);
		add(lblServisiraniAutomobil);
		add(cbAutomobil);
		add(lblServiser);
		add(cbServiser);
		add(lblTerminServisa);
		add(txtTerminServisa);
		add(lblKratakOpis);
		add(txtKratakOpis);
		add(lblDelovi);
		add(txtDelovi);
		add(lblStatusServisa);
		add(cbStatusServisa);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	public void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());
					//String automobilId = txtServisiraniAutomobil.getText().trim();
					//Automobil servisiraniAutomobil = CRUDOperacije.nadjiAutomobil(automobilId);
					Integer automobilId = (Integer) cbAutomobil.getSelectedItem();
					Automobil servisiraniAutomobil = CRUDOperacije.nadjiAutomobil(automobilId);

					String korisnickoIme = (String) cbServiser.getSelectedItem();
					Serviser serviser = CRUDOperacije.nadjiServisera(korisnickoIme);
					String terminServisa = txtTerminServisa.getText().trim();
					String kratakOpis = txtKratakOpis.getText().trim();
					String delovi = txtDelovi.getText().trim();
					enumeracije.statusServisa statusServisa =  (enumeracije.statusServisa) cbStatusServisa.getSelectedItem();

					if (servisautomobila == null) { 
						ServisAutomobila servisautomobila = new ServisAutomobila(automobilId, servisiraniAutomobil, serviser, terminServisa, kratakOpis, delovi, statusServisa);
								Crudoperacije.dodajServisAutomobila(servisautomobila);
					}  else { 
						servisautomobila.setId(automobilId);
						servisautomobila.setServisiraniAutomobil(servisiraniAutomobil);
						servisautomobila.setServiser(serviser);
						servisautomobila.setTerminServisa(terminServisa);
						servisautomobila.setKratakOpis(kratakOpis);
						servisautomobila.setDelovi(delovi);
						servisautomobila.setStatusServisa(statusServisa);
				
					}
					
					Crudoperacije.snimiServiseAutomobila();
					ServisAutomobilaForma.this.dispose();
					ServisAutomobilaForma.this.setVisible(false);
				}	
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(servisautomobila.getId()));
		if(servisautomobila.getServisiraniAutomobil() == null) {
			cbAutomobil.setSelectedItem("--");
		} else {
			cbAutomobil.setSelectedItem(servisautomobila.getServisiraniAutomobil().getId() + " | " + servisautomobila.getServisiraniAutomobil().getMarka() + " " + servisautomobila.getServisiraniAutomobil().getModel());
		}
		//txtServisiraniAutomobil.setText(String.valueOf(servisautomobila.getServisiraniAutomobil()));
		if(servisautomobila.getServiser() == null) {
			cbServiser.setSelectedItem("--");
		} else {
			cbServiser.setSelectedItem(servisautomobila.getServiser().getKorisnickoIme());
		}
		txtTerminServisa.setText(servisautomobila.getTerminServisa());
		txtKratakOpis.setText(servisautomobila.getKratakOpis());
		txtDelovi.setText(servisautomobila.getDelovi());
		cbStatusServisa.setSelectedItem(servisautomobila.getStatusServisa());
	}
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popraviti sledece greske u unosu: \n";

		try {
			Integer.parseInt(txtId.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "Id mora biti broj \n";
			ok = false;
		}

		//try {
		//	Integer.parseInt(txtServisiraniAutomobil.getText().trim());
		//} catch (NumberFormatException e) {
		//	poruka += "Unesite id servisiranog automobila \n";
		//	ok = false;
		//}
		//if (txtServiser.getText().trim().equals("")) {
		//	poruka += "Unesite korisnicko ime servisera \n";
		//	ok = false;
		//}
		if (txtTerminServisa.getText().trim().equals("")) {
			poruka += "Unesite termin servisa \n";
			ok = false;
		}
		if (txtKratakOpis.getText().trim().equals("")) {
			poruka += "Unesite KratakOpis \n";
			ok = false;
		}
		if (txtDelovi.getText().trim().equals("")) {
			poruka += "Unesite delove \n";
			ok = false;
		}
		
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
