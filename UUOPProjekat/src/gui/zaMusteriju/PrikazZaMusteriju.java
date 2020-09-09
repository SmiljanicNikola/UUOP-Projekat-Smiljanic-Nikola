package gui.zaMusteriju;

import java.awt.BorderLayout;
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
import model.Automobil;
import model.Musterija;
import model.ServisAutomobila;
import model.Serviser;

public class PrikazZaMusteriju extends JFrame {
	private DefaultTableModel tableModel;
	private JTable njegoviAutiTabela;
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	public Musterija prijavljenaMusterija;
	
	public PrikazZaMusteriju(CRUDOperacije Crudoperacije, Musterija prijavljenaMusterija) {
		this.Crudoperacije = Crudoperacije;
		this.prijavljenaMusterija = prijavljenaMusterija;
		setTitle("Automobili od prijavljene musterije");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}

	public void initGUI() {
		ArrayList<Automobil> automobili = null;
		if(prijavljenaMusterija instanceof Musterija) {
			automobili = new ArrayList<Automobil>();
			for(Automobil auto : Crudoperacije.getAutomobile(0)) {
				if(auto.getVlasnik().getKorisnickoIme().equals(prijavljenaMusterija.getKorisnickoIme()));
					automobili.add(auto);
			}
		}
		
		String[] zaglavlje = new String[] {"id", "vlasnik", "marka", "model", "godina proizvodnje", "zapremina", "snaga Motora",  "Vrsta goriva"};
		Object[][] sadrzaj = new Object[automobili.size()][zaglavlje.length];
		
		for(int i=0; i<automobili.size(); i++) {
			Automobil auto = automobili.get(i);
			sadrzaj[i][0] = auto.getId();
			sadrzaj[i][1] = auto.getVlasnik().getKorisnickoIme();
			sadrzaj[i][2] = auto.getMarka();
			sadrzaj[i][3] = auto.getModel();
			sadrzaj[i][4] = auto.getGodinaProizvodnje();
			sadrzaj[i][5] = auto.getZapreminaMotora();
			sadrzaj[i][6] = auto.getSnagaMotora();
			sadrzaj[i][7] = auto.getVrstaGoriva();
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		njegoviAutiTabela = new JTable(tableModel);
		
		njegoviAutiTabela.setRowSelectionAllowed(true);
		njegoviAutiTabela.setColumnSelectionAllowed(false);
		njegoviAutiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		njegoviAutiTabela.setDefaultEditor(Object.class, null);
		njegoviAutiTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(njegoviAutiTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void initActions() {
		
	}
}
