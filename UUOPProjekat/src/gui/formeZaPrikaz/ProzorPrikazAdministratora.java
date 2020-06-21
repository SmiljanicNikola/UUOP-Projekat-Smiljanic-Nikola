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
import javax.swing.table.TableModel;

import CRUD.CRUDOperacije;
import gui.formeZaDodavanjeIIzmenu.AdministratoriForma;
import gui.formeZaDodavanjeIIzmenu.MusterijeForma;
import model.Administrator;
import model.Musterija;

public class ProzorPrikazAdministratora extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private DefaultTableModel tableModel;
	private JTable administratoriTabela;

	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	
	public ProzorPrikazAdministratora(CRUDOperacije Crudoperacije) {
		this.Crudoperacije = Crudoperacije;
		setTitle("Administratori");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	private void initGUI() {
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
		
		String[] zaglavlje = new String[] {"id", "ime", "prezime", "jmbg", "pol", "adresa", "telefon", "korisnickoIme", "lozinka", "plata"};
		Object[][] sadrzaj = new Object[Crudoperacije.getAdministratore().size()][zaglavlje.length];
		
		for(int i = 0; i<Crudoperacije.getAdministratore().size(); i++) {
			Administrator administrator = Crudoperacije.getAdministratore().get(i);
			sadrzaj[i][0] = administrator.getId();
			sadrzaj[i][1] = administrator.getIme();
			sadrzaj[i][2] = administrator.getPrezime();
			sadrzaj[i][3] = administrator.getJmbg();
			sadrzaj[i][4] = administrator.getPol();
			sadrzaj[i][5] = administrator.getAdresa();
			sadrzaj[i][6] = administrator.getTelefon();
			sadrzaj[i][7] = administrator.getKorisnickoIme();
			sadrzaj[i][8] = administrator.getLozinka();
			sadrzaj[i][9] = administrator.getPlata();
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		administratoriTabela = new JTable(tableModel);
		
		administratoriTabela.setRowSelectionAllowed(true);
		administratoriTabela.setColumnSelectionAllowed(false);
		administratoriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		administratoriTabela.setDefaultEditor(Object.class, null);
		administratoriTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(administratoriTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriForma af = new AdministratoriForma(Crudoperacije, null);
				af.setVisible(true);
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = administratoriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					
					String korisnickoIme = tableModel.getValueAt(red, 7).toString();
					Administrator administrator = Crudoperacije.nadjiAdministratora(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete administratora?", "Potvrda", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						administrator.setId(-1);
						tableModel.removeRow(red);
						Crudoperacije.snimiAdministratore();
					}
				}
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = administratoriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 7).toString();
					Administrator administrator = Crudoperacije.nadjiAdministratora(korisnickoIme);
					if(administrator == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja administratora", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						AdministratoriForma af = new AdministratoriForma(Crudoperacije, administrator);
						af.setVisible(true);
					}
				}
				
			}
		});
	}
	
}
