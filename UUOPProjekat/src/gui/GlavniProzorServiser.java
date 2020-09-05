package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import gui.formeZaDodavanjeIIzmenu.ServiseriForma;
import gui.zaServisera.PrikazZaServisera;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class GlavniProzorServiser extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu ServisiMenu= new JMenu("Servisi");
	private JMenuItem pregledIKreiranjeItem = new JMenuItem("Pregled i kreiranje servisa");
	private JMenu izlazMenu= new JMenu("Izlaz");
	private JMenuItem izlazItem = new JMenuItem("Izlaz"); 

	
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
		mainMenu.add(ServisiMenu);
		ServisiMenu.add(pregledIKreiranjeItem);
		mainMenu.add(izlazMenu);
		izlazMenu.add(izlazItem);
		
	}
	
	private void initActions() {
		pregledIKreiranjeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazZaServisera pzs = new PrikazZaServisera(crudoperacije);
				pzs.setVisible(true);
				
			}
		});
		izlazItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GlavniProzorServiser.this.dispose();
				GlavniProzorServiser.this.setVisible(false);
				
			}
		});
		
	}
	
}
