package gui.zaServisera;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDOperacije;
import gui.formeZaDodavanjeIIzmenu.ServisAutomobilaForma;
import gui.formeZaDodavanjeIIzmenu.ServiseriForma;
import model.Automobil;
import model.Musterija;
import model.ServisAutomobila;
import model.Serviser;
import model.ServisniDeo;

public class PrikazZaServisera extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private DefaultTableModel tableModel;
	private JTable serviseriTabela;
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	public Serviser prijavljeniServiser;
	
	public PrikazZaServisera(CRUDOperacije Crudoperacije, Serviser prijavljeniServiser) {
		this.Crudoperacije = Crudoperacije;
		this.prijavljeniServiser = prijavljeniServiser;
		setTitle("Servisi");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	public void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);

		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);

		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false); //Onemogucava korisniku da pomera Toolbar za akcije
		
		ArrayList<ServisAutomobila> servisi = null;
		if(prijavljeniServiser instanceof Serviser) {
			servisi = new ArrayList<ServisAutomobila>();
			for(ServisAutomobila servis : Crudoperacije.sviNeobrisaniServisi()) {
				if(servis.getServiser().getKorisnickoIme().equals(prijavljeniServiser.getKorisnickoIme()))
					servisi.add(servis);
			}
		}
		
		String[] zaglavlje = new String[] {"id", "Servisirani automobil", "serviser", "Termin servisa", "Kratak opis", "Delovi", "Status servisa"};
		Object[][] sadrzaj = new Object[servisi.size()][zaglavlje.length];
		
		for(int i=0; i<servisi.size(); i++) {
			ServisAutomobila servisautomobila = servisi.get(i);
			sadrzaj[i][0] = servisautomobila.getId();
			sadrzaj[i][1] = servisautomobila.getServisiraniAutomobil().getId() + " | " + servisautomobila.getServisiraniAutomobil().getMarka() + " " + servisautomobila.getServisiraniAutomobil().getModel();
			sadrzaj[i][2] = servisautomobila.getServiser().getIme() + " " + servisautomobila.getServiser().getPrezime() + " | " + servisautomobila.getServiser().getKorisnickoIme();
			sadrzaj[i][3] = servisautomobila.getTerminServisa();
			sadrzaj[i][4] = servisautomobila.getKratakOpis();
			String delovi = "";
			for(ServisniDeo deo : Crudoperacije.sviNeobrisaniServisniDelovi()) {
				if(deo.getServis().getId() == servisautomobila.getId()) {
					delovi += deo.getNazivDela() + "|";
				}
			
			}
			sadrzaj[i][5] = delovi;
			//sadrzaj[i][5] = servisautomobila.getDelovi();
			sadrzaj[i][6] = servisautomobila.getStatusServisa();
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		serviseriTabela = new JTable(tableModel);
		
		serviseriTabela.setRowSelectionAllowed(true);
		serviseriTabela.setColumnSelectionAllowed(false);
		serviseriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		serviseriTabela.setDefaultEditor(Object.class, null);
		serviseriTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(serviseriTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisAutomobilaForma saf = new ServisAutomobilaForma(Crudoperacije, null);
				saf.setVisible(true);
				
			}
		});
		
	}
	
}
