package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import gui.formeZaPrikaz.ProzorPrikazAdministratora;
import gui.formeZaPrikaz.ProzorPrikazMusterija;
import gui.formeZaPrikaz.ProzorPrikazServisera;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class GlavniProzorAdministrator extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu serviseriMenu= new JMenu("Serviseri");
	private JMenuItem serviseriItem = new JMenuItem("Serviseri"); 
	private JMenu servisneknjiziceMenu = new JMenu("servisne knjizice");
	private JMenu musterijeMenu = new JMenu("Musterije");
	private JMenuItem musterijeItem = new JMenuItem("Musterije");
	private JMenu administratoriMenu = new JMenu("Administratori");
	private JMenuItem administratoriItem = new JMenuItem("Administratori");
	
	private CRUDOperacije crudoperacije;
	private Musterija prijavljeni;
	private Serviser prijavljeniServiser;
	private Administrator prijavljeniAdministrator;
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	
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
		mainMenu.add(serviseriMenu);
		serviseriMenu.add(serviseriItem);
		mainMenu.add(musterijeMenu);
		musterijeMenu.add(musterijeItem);
		mainMenu.add(administratoriMenu);
		administratoriMenu.add(administratoriItem);
		
	}
	
	private void initActions() {
		musterijeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazMusterija ppm = new ProzorPrikazMusterija(crudoperacije);
				ppm.setVisible(true);
			}
		});
		administratoriItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazAdministratora ppa = new ProzorPrikazAdministratora(Crudoperacije);
				ppa.setVisible(true);
				
			}
		});
		serviseriItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazServisera pps = new ProzorPrikazServisera(Crudoperacije);
				pps.setVisible(true);
				
			}
		});
	}
	
}
