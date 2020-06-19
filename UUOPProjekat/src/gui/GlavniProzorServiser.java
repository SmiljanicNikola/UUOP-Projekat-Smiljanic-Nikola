package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class GlavniProzorServiser extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu automobilMenu= new JMenu("Automobil");
	private JMenuItem nekiItem = new JMenuItem("Neki"); 
	private JMenu servisneknjiziceMenu = new JMenu("servisne knjizice");
	private JMenuItem servoItem = new JMenuItem("servo");
	
	private CRUDOperacije crudoperacije;
	private Musterija prijavljeni;
	private Serviser prijavljeniServiser;
	private Administrator prijavljeniAdministrator;
	
	public GlavniProzorServiser(CRUDOperacije crudoperacije, Serviser prijavljeniServiser) {
		this.crudoperacije = crudoperacije;
		this.prijavljeniServiser = prijavljeniServiser;
		setTitle("Serviser: " + prijavljeniServiser.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(automobilMenu);
		automobilMenu.add(nekiItem);
		mainMenu.add(servisneknjiziceMenu);
		servisneknjiziceMenu.add(servoItem);
	}
	
	private void initActions() {
		
	}
	
}
