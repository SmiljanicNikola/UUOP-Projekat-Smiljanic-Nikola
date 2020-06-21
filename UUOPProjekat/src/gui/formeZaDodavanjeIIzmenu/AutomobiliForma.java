package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import enumeracije.Pol;
import enumeracije.marka;
import enumeracije.model;
import enumeracije.vrstaGoriva;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import net.miginfocom.swing.MigLayout;

public class AutomobiliForma extends JFrame {
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(8);
	
	private JLabel lblVlasnik = new JLabel("Vlasnik");
	private JTextField txtVlasnik = new JTextField(20);
	
	private JLabel lblMarka = new JLabel("Marka");
	private JComboBox<marka> cbMarka = new JComboBox<marka>(marka.values());
	
	private JLabel lblModel = new JLabel("Model");;
	private JComboBox<model> cbModel = new JComboBox<model>(model.values());
	
	private JLabel lblgodinaProizvodnje = new JLabel("Godina Proizvodnje");
	private JTextField txtgodinaProizvodnje = new JTextField(20);
	
	private JLabel lblzapreminaMotora = new JLabel("Zapremina Motora");
	private JTextField txtzapreminaMotora = new JTextField(20);
	
	private JLabel lblsnagaMotora = new JLabel("Snaga Motora");
	private JTextField txtsnagaMotora = new JTextField(20);
	
	private JLabel lblvrstaGoriva = new JLabel("Vrsta Goriva");
	private JComboBox<vrstaGoriva> cbvrstaGoriva = new JComboBox<vrstaGoriva>(vrstaGoriva.values());
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	

	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private Automobil automobil;
	
	
	public AutomobiliForma(CRUDOperacije Crudoperacije, Automobil automobil) {
		this.Crudoperacije = Crudoperacije;
		this.automobil = automobil;
		if (automobil == null) {
			setTitle("Dodavanje automobila: ");
		} else {
			setTitle("Izmena podataka - " + automobil.getId());
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

		if (automobil != null) {
			popuniPolja();
		}

		add(lblId);
		add(txtId);
		add(lblVlasnik);
		add(txtVlasnik);
		add(lblMarka);
		add(cbMarka);
		add(lblModel);
		add(cbModel);
		add(lblgodinaProizvodnje);
		add(txtgodinaProizvodnje);
		add(lblzapreminaMotora);
		add(txtzapreminaMotora);
		add(lblsnagaMotora);
		add(txtsnagaMotora);
		add(lblvrstaGoriva);
		add(cbvrstaGoriva );
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
					String korisnickoIme = txtVlasnik.getText().trim();
					Musterija vlasnik = Crudoperacije.nadjiMusteriju(korisnickoIme);
					marka marka = (marka) cbMarka.getSelectedItem();
					model model = (model) cbModel.getSelectedItem();
					int godinaProizvodnje = Integer.parseInt(txtgodinaProizvodnje.getText().trim());
					String zapreminaMotora = txtzapreminaMotora.getText().trim();
					String snagaMotora = txtsnagaMotora.getText().trim();
					vrstaGoriva vrstaGoriva = (vrstaGoriva) cbvrstaGoriva.getSelectedItem();

					if (automobil == null) { 
						Automobil automobil = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva);
							Crudoperacije.dodajAutomobil(automobil);
					}else { 
						automobil.setId(id);
						automobil.setVlasnik(vlasnik);
						automobil.setMarka(marka);
						automobil.setModel(model);
						automobil.setGodinaProizvodnje(godinaProizvodnje);
						automobil.setZapreminaMotora(zapreminaMotora);
						automobil.setSnagaMotora(snagaMotora);
						automobil.setVrstaGoriva(vrstaGoriva);
					}
					Crudoperacije.snimiAutomobile();
					AutomobiliForma.this.dispose();
					AutomobiliForma.this.setVisible(false);
					
			}}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(automobil.getId()));
		txtVlasnik.setText(String.valueOf(automobil.getVlasnik()));
		cbMarka.setSelectedItem(automobil.getMarka());
		cbModel.setSelectedItem(automobil.getModel());
		txtgodinaProizvodnje.setText(String.valueOf(automobil.godinaProizvodnje));
		txtzapreminaMotora.setText(automobil.getZapreminaMotora());
		txtsnagaMotora.setText(automobil.getSnagaMotora());
		cbvrstaGoriva.setSelectedItem(automobil.getVrstaGoriva());

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

		if (txtVlasnik.getText().trim().equals("")) {
			poruka += "Unesite id \n";
			ok = false;
		}
		if (txtgodinaProizvodnje.getText().trim().equals("")) {
			poruka += "Unesite godinu proizvodnje \n";
			ok = false;
		}
		if (txtzapreminaMotora.getText().trim().equals("")) {
			poruka += "Unesite zapreminu motora \n";
			ok = false;
		}
		if (txtsnagaMotora.getText().trim().equals("")) {
			poruka += "Unesite snagu motora \n";
			ok = false;
		}
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
