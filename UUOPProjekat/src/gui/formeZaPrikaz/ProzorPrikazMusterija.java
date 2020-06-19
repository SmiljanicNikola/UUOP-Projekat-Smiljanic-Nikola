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
import gui.formeZaDodavanjeIIzmenu.MusterijeForma;
import model.Musterija;

public class ProzorPrikazMusterija extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private DefaultTableModel tableModel;
	private JTable musterijeTabela;
	
	private CRUDOperacije crudoperacije;
	
	public ProzorPrikazMusterija(CRUDOperacije crudoperacije) { 
		this.crudoperacije = crudoperacije;
		setTitle("Musterije");
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
		
		String[] zaglavlje = new String[] {"id", "ime", "prezime", "jmbg", "pol", "adresa", "telefon", "korisnickoIme", "lozinka", "nagradniBodovi"};
		Object[][] sadrzaj = new Object[crudoperacije.getMusterije().size()][zaglavlje.length];
		
		for(int i = 0; i<crudoperacije.getMusterije().size(); i++) {
			Musterija musterija = crudoperacije.getMusterije().get(i);
			sadrzaj[i][0] = musterija.getId();
			sadrzaj[i][1] = musterija.getIme();
			sadrzaj[i][2] = musterija.getPrezime();
			sadrzaj[i][3] = musterija.getJmbg();
			sadrzaj[i][4] = musterija.getPol();
			sadrzaj[i][5] = musterija.getAdresa();
			sadrzaj[i][6] = musterija.getTelefon();
			sadrzaj[i][7] = musterija.getKorisnickoIme();
			sadrzaj[i][8] = musterija.getLozinka();
			sadrzaj[i][9] = musterija.getNagradniBodovi();
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		musterijeTabela = new JTable(tableModel);
		
		musterijeTabela.setRowSelectionAllowed(true);
		musterijeTabela.setColumnSelectionAllowed(false);
		musterijeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijeTabela.setDefaultEditor(Object.class, null);
		musterijeTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(musterijeTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = musterijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate selektovati zeljeni red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String id = tableModel.getValueAt(red, 0).toString();
					Musterija musterija = crudoperacije.nadjiMusteriju(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete musteriju ?", "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						tableModel.removeRow(red);
						
					}
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijeForma mf = new MusterijeForma(crudoperacije, null);
				mf.setVisible(true);
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = musterijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate selektovati zeljeni red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String id = tableModel.getValueAt(red, 0).toString();
					Musterija musterija = crudoperacije.nadjiMusteriju(id);
					if(musterija == null) {
						JOptionPane.showConfirmDialog(null, "Greska prilikom pronalazenja prodavca sa tim Id-om", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						MusterijeForma mf = new MusterijeForma(crudoperacije, musterija);
						mf.setVisible(true);
					}
				}
				
			}
		});
		
	}
	
	
}
