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
import gui.formeZaDodavanjeIIzmenu.AutomobiliForma;
import model.Administrator;
import model.Automobil;

public class ProzorPrikazAutomobila extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private DefaultTableModel tableModel;
	private JTable automobiliTabela;

	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private Automobil automobil;
	
	public ProzorPrikazAutomobila(CRUDOperacije Crudoperacije) {
		this.Crudoperacije = Crudoperacije;
		setTitle("Automobili");
		setSize(850,450);
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
		
		String[] zaglavlje = new String[] {"id", "vlasnik", "marka", "model", "godina proizvodnje", "zapremina", "snaga Motora",  "Vrsta goriva"};
		Object[][] sadrzaj = new Object[Crudoperacije.getAutomobile().size()][zaglavlje.length];
		
		for(int i = 0; i<Crudoperacije.getAutomobile().size(); i++) {
			Automobil automobil = Crudoperacije.getAutomobile().get(i);
			sadrzaj[i][0] = automobil.getId();
			sadrzaj[i][1] = automobil.getVlasnik();
			sadrzaj[i][2] = automobil.getMarka();
			sadrzaj[i][3] = automobil.getModel();
			sadrzaj[i][4] = automobil.getGodinaProizvodnje();
			sadrzaj[i][5] = automobil.getZapreminaMotora();
			sadrzaj[i][6] = automobil.getSnagaMotora();
			sadrzaj[i][7] = automobil.getVrstaGoriva();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		automobiliTabela = new JTable(tableModel);
		
		automobiliTabela.setRowSelectionAllowed(true);
		automobiliTabela.setColumnSelectionAllowed(false);
		automobiliTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		automobiliTabela.setDefaultEditor(Object.class, null);
		automobiliTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(automobiliTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			private Automobil automobil;

			@Override
			public void actionPerformed(ActionEvent e) {
				AutomobiliForma autof = new AutomobiliForma(Crudoperacije, automobil);
				autof.setVisible(true);
				
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = automobiliTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = (int) tableModel.getValueAt(red, 0);
					Automobil automobil = Crudoperacije.nadjiAutomobil(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete automobil?", "Potvrda", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						automobil.setId(-1);
						tableModel.removeRow(red);
						Crudoperacije.snimiAutomobile();
					}
				}
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = automobiliTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = (int) tableModel.getValueAt(red, 0);
					Automobil automobil = Crudoperacije.nadjiAutomobil(id);
					if(automobil == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja administratora", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						AutomobiliForma af = new AutomobiliForma(Crudoperacije, automobil);
						af.setVisible(true);
					}
				}
				
			}
		});
	}
	
}
