package gui.zaMusteriju;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import enumeracije.statusServisa;
import model.Automobil;
import model.Musterija;
import model.ServisAutomobila;
import model.ServisnaKnjizica;
import model.ServisniDeo;
import net.miginfocom.swing.MigLayout;

public class ZakazivanjeServisa extends JFrame {
	
	private JLabel lblAutomobil = new JLabel("Automobil");
	private JComboBox<Integer> cbAutomobil = new JComboBox<Integer>();
	
	private JLabel lblKratakOpis= new JLabel("KratakOpis");
	private JTextField txtKratakOpis = new JTextField(50);
	
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	public Musterija prijavljenaMusterija;
	private ServisAutomobila servisautomobila;
	
	public ZakazivanjeServisa(CRUDOperacije Crudoperacije, Musterija prijavljenaMusterija, ServisAutomobila servisautomobila) {
		this.Crudoperacije = Crudoperacije;
		this.prijavljenaMusterija = prijavljenaMusterija;
		this.servisautomobila = servisautomobila;
		
		setTitle("Zakazivanje servisa");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][]20[]");
		setLayout(layout);
		
		for(Automobil auto : Crudoperacije.sviNeobrisaniAutomobili()) {
			if(auto.getVlasnik().getKorisnickoIme().equals(prijavljenaMusterija.getKorisnickoIme())){ 
				cbAutomobil.addItem(auto.getId());
		    }
		}
		
		add(lblAutomobil);
		add(cbAutomobil);
		add(lblKratakOpis);
		add(txtKratakOpis);
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	public void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = (Integer) cbAutomobil.getSelectedItem();
				Automobil servisiraniAutomobil = CRUDOperacije.nadjiAutomobil(id);
				String kratakOpis = txtKratakOpis.getText().trim();
				
				ServisAutomobila servisautomobila = new ServisAutomobila(Crudoperacije.generisiIdServis(), servisiraniAutomobil, null, null, kratakOpis, new ArrayList<ServisniDeo>(), statusServisa.zakazan, 0);
				Crudoperacije.dodajServisAutomobila(servisautomobila);
				//Crudoperacije.snimiServiseAutomobila();
				ZakazivanjeServisa.this.dispose();
				ZakazivanjeServisa.this.setVisible(false);
				
			}
		});
	}

}
