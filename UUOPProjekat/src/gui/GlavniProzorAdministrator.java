package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import gui.formeZaPrikaz.ProzorPrikazMusterija;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class GlavniProzorAdministrator extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu automobilMenu= new JMenu("Automobil");
	private JMenuItem nekiItem = new JMenuItem("Neki"); 
	private JMenu servisneknjiziceMenu = new JMenu("servisne knjizice");
	private JMenu musterijeMenu = new JMenu("Musterije");
	private JMenuItem musterijeItem = new JMenuItem("Musterije");
	
	private CRUDOperacije crudoperacije;
	private Musterija prijavljeni;
	private Serviser prijavljeniServiser;
	private Administrator prijavljeniAdministrator;
	
	public GlavniProzorAdministrator(CRUDOperacije crudoperacije, Administrator prijavljeniAdministrator) {
		this.crudoperacije = crudoperacije;
		this.prijavljeniAdministrator = prijavljeniAdministrator;
		setTitle("Administrator: " + prijavljeniAdministrator.getKorisnickoIme());
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
		mainMenu.add(musterijeMenu);
		musterijeMenu.add(musterijeItem);
		
	}
	
	private void initActions() {
		musterijeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazMusterija ppm = new ProzorPrikazMusterija(crudoperacije);
				ppm.setVisible(true);
			}
		});
	}
	
}
