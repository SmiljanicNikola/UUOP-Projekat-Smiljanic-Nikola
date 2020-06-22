package gui.zaServisera;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDOperacije;
import gui.formeZaDodavanjeIIzmenu.ServiseriForma;
import model.Serviser;

public class PrikazZaServisera extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private DefaultTableModel tableModel;
	private JTable serviseriTabela;
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	
	public PrikazZaServisera(CRUDOperacije Crudoperacije) {
		this.Crudoperacije = Crudoperacije;
		setTitle("Serviseri");
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
		
		String[] zaglavlje = new String[] {"id", "ime", "prezime", "jmbg", "pol", "adresa", "telefon", "korisnickoIme", "lozinka", "plata", "specijalizacija"};
		Object[][] sadrzaj = new Object[Crudoperacije.getServisere().size()][zaglavlje.length];
		
		for(int i = 0; i<Crudoperacije.getServisere().size(); i++) {
			Serviser serviser = Crudoperacije.getServisere().get(i);
			sadrzaj[i][0] = serviser.getId();
			sadrzaj[i][1] = serviser.getIme();
			sadrzaj[i][2] = serviser.getPrezime();
			sadrzaj[i][3] = serviser.getJmbg();
			sadrzaj[i][4] = serviser.getPol();
			sadrzaj[i][5] = serviser.getAdresa();
			sadrzaj[i][6] = serviser.getTelefon();
			sadrzaj[i][7] = serviser.getKorisnickoIme();
			sadrzaj[i][8] = serviser.getLozinka();
			sadrzaj[i][9] = serviser.getPlata();
			sadrzaj[i][10] = serviser.getSpecijalizacija();
			
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
				ServiseriForma sf = new ServiseriForma(Crudoperacije, null);
				sf.setVisible(true);
				
			}
		});
		
	}
	
}
