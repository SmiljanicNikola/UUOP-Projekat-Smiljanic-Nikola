package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDOperacije;
import gui.formeZaDodavanjeIIzmenu.AdministratoriForma;
import gui.formeZaDodavanjeIIzmenu.ServisAutomobilaForma;
import model.Administrator;
import model.Automobil;
import model.ServisAutomobila;
import model.ServisniDeo;

public class ProzorPrikazServisaAutomobila extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private DefaultTableModel tableModel;
	private JTable servisiAutomobilaTabela;

	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private ServisAutomobila servisautomobila;
	
	public ProzorPrikazServisaAutomobila(CRUDOperacije Crudoperacije) {
		this.Crudoperacije = Crudoperacije;
		setTitle("Servisi automobila: ");
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
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false); //Onemogucava korisniku da pomera Toolbar za akcije
		
		String[] zaglavlje = new String[] {"id", "Servisirani automobil", "serviser", "Termin servisa", "Kratak opis", "Delovi", "Status servisa"};
		Object[][] sadrzaj = new Object[Crudoperacije.getServiseAutomobila().size()][zaglavlje.length];
		
		for(int i = 0; i<Crudoperacije.getServiseAutomobila().size(); i++) {
			ServisAutomobila servisautomobila = Crudoperacije.getServiseAutomobila().get(i);
			sadrzaj[i][0] = servisautomobila.getId();
			sadrzaj[i][1] = servisautomobila.getServisiraniAutomobil().getId() + " | " + servisautomobila.getServisiraniAutomobil().getMarka() + " " + servisautomobila.getServisiraniAutomobil().getModel();
			sadrzaj[i][2] = servisautomobila.getServiser().getIme() + " " + servisautomobila.getServiser().getPrezime() + " | " + servisautomobila.getServiser().getKorisnickoIme();
			sadrzaj[i][3] = servisautomobila.getTerminServisa();
			sadrzaj[i][4] = servisautomobila.getKratakOpis();
			//String delovi = "";
			//for(ServisniDeo deo : servisautomobila.getDelovi()) {
			//	delovi += deo.getNazivDela() + ", ";
			//}
			String delovi = "";
			for(ServisniDeo deo : Crudoperacije.getServisniDeo()) {
				//if(deo.getServis().equals(servisautomobila)) {
					delovi = deo.getNazivDela();
				//}
			}
			sadrzaj[i][5] = delovi;
			sadrzaj[i][6] = servisautomobila.getStatusServisa();
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		servisiAutomobilaTabela = new JTable(tableModel);
		
		servisiAutomobilaTabela.setRowSelectionAllowed(true);
		servisiAutomobilaTabela.setColumnSelectionAllowed(false);
		servisiAutomobilaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisiAutomobilaTabela.setDefaultEditor(Object.class, null);
		servisiAutomobilaTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(servisiAutomobilaTabela);
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
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisiAutomobilaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odaberete red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = (int) tableModel.getValueAt(red, 0);
					ServisAutomobila servisautomobila = Crudoperacije.nadjiServiseAutomobila(id);
					if(servisautomobila == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja servisa automobila", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						ServisAutomobilaForma aaf = new ServisAutomobilaForma(Crudoperacije, servisautomobila);
						aaf.setVisible(true);
					}
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisiAutomobilaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odaberete red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = (int) tableModel.getValueAt(red, 0);
					ServisAutomobila servisautomobila = Crudoperacije.nadjiServiseAutomobila(id);
				
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete servis automobila?", "Potvrda", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						servisautomobila.setId(-1);
						tableModel.removeRow(red);
						Crudoperacije.snimiServiseAutomobila();
					}
				}
				
			}
		});
	}
	
	
}
