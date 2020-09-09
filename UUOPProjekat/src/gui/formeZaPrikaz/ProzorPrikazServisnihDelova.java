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
import enumeracije.*;

import CRUD.CRUDOperacije;
import enumeracije.marka;
import gui.formeZaDodavanjeIIzmenu.AdministratoriForma;
import gui.formeZaDodavanjeIIzmenu.ServisniDeloviForma;
import model.Administrator;
import model.Automobil;
import enumeracije.marka;
import enumeracije.model;
import model.ServisAutomobila;
import model.ServisniDeo;

public class ProzorPrikazServisnihDelova extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private DefaultTableModel tableModel;
	private JTable servisniDeloviTabela;

	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	//public Administrator admin;
	//public ServisAutomobila servisauta;
	private ServisniDeo servisnideo;
	
	public ProzorPrikazServisnihDelova(CRUDOperacije Crudoperacije) {
		this.Crudoperacije = Crudoperacije;
		setTitle("Servisni delovi");
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
		
		String[] zaglavlje = new String[] {"id", "Marka automobila", "Model automobila", "cena", "naziv dela", "servisId", "Kratak opis"};
		Object[][] sadrzaj = new Object[Crudoperacije.getServisniDeo().size()][zaglavlje.length];
		
		for(int i = 0; i<Crudoperacije.getServisniDeo().size(); i++) {
			ServisniDeo servisnideo = Crudoperacije.getServisniDeo().get(i);
			sadrzaj[i][0] = servisnideo.getId();
			sadrzaj[i][1] = servisnideo.getMarkaAutomobila();
			sadrzaj[i][2] = servisnideo.getModelAutomobila();
			sadrzaj[i][3] = servisnideo.getCena();
			sadrzaj[i][4] = servisnideo.getNazivDela();
			sadrzaj[i][5] = servisnideo.getServis().getId();
			sadrzaj[i][6] = servisnideo.getServis().getKratakOpis();
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		servisniDeloviTabela = new JTable(tableModel);
		
		servisniDeloviTabela.setRowSelectionAllowed(true);
		servisniDeloviTabela.setColumnSelectionAllowed(false);
		servisniDeloviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisniDeloviTabela.setDefaultEditor(Object.class, null);
		servisniDeloviTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(servisniDeloviTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisniDeloviForma sdf = new ServisniDeloviForma(Crudoperacije, null);
				sdf.setVisible(true);
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int red = servisniDeloviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = (int) tableModel.getValueAt(red, 0);
					ServisniDeo servisnideo = Crudoperacije.nadjiDeo(id);
					if(servisnideo == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja dela", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						ServisniDeloviForma sdf = new ServisniDeloviForma(Crudoperacije, servisnideo);
						sdf.setVisible(true);
					}
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisniDeloviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = (int) tableModel.getValueAt(red, 0);
					ServisniDeo servisnideo = Crudoperacije.nadjiDeo(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete deo?", "Potvrda", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						servisnideo.setId(-1);
						tableModel.removeRow(red);
						Crudoperacije.snimiServisneDelove();
					}
				}
				
			}
		});
		
	}
	
	
}
