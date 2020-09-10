package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import CRUD.CRUDOperacije;
import enumeracije.Pol;
import model.Administrator;
import model.Automobil;
import model.ServisAutomobila;
import model.ServisnaKnjizica;
import model.ServisniDeo;
import net.miginfocom.swing.MigLayout;

public class ServisneKnjiziceForma extends JFrame {
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(8);
	private JLabel lblVlasnistvo = new JLabel("Vlasnistvo");
	private JComboBox<String> cbAutomobil = new JComboBox<String>();
	//private JLabel lblOdradjeniServisi = new JLabel("Odradjeni servisi");
	//private JTextField txtOdradjeniServisi = new JTextField(20);
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private ServisnaKnjizica servisnaknjizica;
	
	
	public ServisneKnjiziceForma(CRUDOperacije Crudoperacije, ServisnaKnjizica servisnaknjizica) {
		this.Crudoperacije = Crudoperacije;
		this.servisnaknjizica = servisnaknjizica;
		if (servisnaknjizica == null) {
			setTitle("Dodavanje automobila: ");
		} else {
			setTitle("Izmena podataka - " + servisnaknjizica.getId());
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
			if(servisiraniautomobil instanceof Automobil) cbAutomobil.addItem(servisiraniautomobil.getId() + "-" + servisiraniautomobil.getMarka() + servisiraniautomobil.getModel());
		}
		
		if (servisnaknjizica != null) {
			popuniPolja();
		}

		add(lblId);
		add(txtId);
		add(lblVlasnistvo);
		add(cbAutomobil);
		//add(lblOdradjeniServisi);
		//add(txtOdradjeniServisi);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	public void initActions(){
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());
					String automobilId = ((String) cbAutomobil.getSelectedItem()).split("\\-")[0];
					Automobil vlasnistvo = Crudoperacije.nadjiAutomobil2(automobilId);
					//String automobilId = (txtVlasnistvo.getText().trim());
					//Automobil vlasnistvo = CRUDOperacije.nadjiAutomobil(automobilId);
					//String obavljeniServisi = txtOdradjeniServisi.getText().trim();
					Integer isDeleted = 0;
					if (servisnaknjizica == null) { 
						ServisnaKnjizica servisnaknjizica = new ServisnaKnjizica(id, vlasnistvo, new ArrayList<ServisAutomobila>(), isDeleted);
								Crudoperacije.dodajServisnuKnjizicu(servisnaknjizica);
					} else { 
						servisnaknjizica.setId(id);
						servisnaknjizica.setVlasnistvo(vlasnistvo);
						//servisnaknjizica.setObavljeniServisi(obavljeniServisi);
						
						
					}
					Crudoperacije.snimiServisneKnjizice();
					ServisneKnjiziceForma.this.dispose();
					ServisneKnjiziceForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisneKnjiziceForma.this.dispose();
				ServisneKnjiziceForma.this.setVisible(false);
				
			}
		});
	}
	private void popuniPolja() {
		txtId.setText(String.valueOf(servisnaknjizica.getId()));
		if(servisnaknjizica.getVlasnistvo() == null) {
			cbAutomobil.setSelectedItem("--");
		} else {
			cbAutomobil.setSelectedItem(servisnaknjizica.getVlasnistvo().getId() + " | " + servisnaknjizica.getVlasnistvo().getMarka() + " " + servisnaknjizica.getVlasnistvo().getModel());
		}
		//txtOdradjeniServisi.setText(String.valueOf(servisnaknjizica.getObavljeniServisi()));

	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popraviti sledece greske u unosu: \n";

		if(txtId.getText().trim().equals("")) {
			poruka += "Id mora biti broj \n";
			ok = false;
		}
		else if(servisnaknjizica == null) {
			int id = Integer.parseInt(txtId.getText().trim());
			ServisnaKnjizica servisnaknjizica = Crudoperacije.nadjiServisnuKnjizicu(id);
			if(servisnaknjizica != null) {
				poruka += "Servisna knjizica sa tim id-om vec postoji \n";
				ok = false;
			}
		}

		//if (txtVlasnistvo.getText().trim().equals("")) {
		//	poruka += "Unesite vlasnistvo \n";
		//	ok = false;
		//}
		//if (txtOdradjeniServisi.getText().trim().equals("")) {
		//	poruka += "Unesite id-ove od odradjenih servisa \n";
		//	ok = false;
		//}
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
