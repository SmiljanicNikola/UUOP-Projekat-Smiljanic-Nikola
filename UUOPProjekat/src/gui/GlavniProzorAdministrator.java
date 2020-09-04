package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import gui.formeZaPrikaz.ProzorPrikazAdministratora;
import gui.formeZaPrikaz.ProzorPrikazAutomobila;
import gui.formeZaPrikaz.ProzorPrikazMusterija;
import gui.formeZaPrikaz.ProzorPrikazServisaAutomobila;
import gui.formeZaPrikaz.ProzorPrikazServisera;
import gui.formeZaPrikaz.ProzorPrikazServisnihDelova;
import gui.formeZaPrikaz.ProzorPrikazServisnihKnjizica;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class GlavniProzorAdministrator extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu serviseriMenu= new JMenu("Serviseri");
	private JMenuItem serviseriItem = new JMenuItem("Serviseri"); 
	private JMenu musterijeMenu = new JMenu("Musterije");
	private JMenuItem musterijeItem = new JMenuItem("Musterije");
	private JMenu administratoriMenu = new JMenu("Administratori");
	private JMenuItem administratoriItem = new JMenuItem("Administratori");
	private JMenu ostaloMenu = new JMenu("Ostalo");
	private JMenuItem automobiliItem = new JMenuItem("Automobili");
	private JMenuItem servisneknjiziceItem = new JMenuItem("Servisne knjizice");
	private JMenuItem servisnideloviItem = new JMenuItem("Servisni delovi");
	private JMenuItem servisiautomobilaItem = new JMenuItem("Servisi automobila");
	private JMenu izlazMenu= new JMenu("Izlaz");
	private JMenuItem izlazItem = new JMenuItem("Izlaz"); 
	
	private CRUDOperacije crudoperacije;
	//private Musterija prijavljeni;
	private Serviser prijavljeniServiser;
	private Administrator prijavljeniAdministrator;
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private Musterija musterija;
	//private Administrator admin;
	
	public GlavniProzorAdministrator(CRUDOperacije crudoperacije, Administrator prijavljeniAdministrator, Musterija musterija) {
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
		mainMenu.add(izlazMenu);
		izlazMenu.add(izlazItem);
		mainMenu.add(serviseriMenu);
		serviseriMenu.add(serviseriItem);
		mainMenu.add(musterijeMenu);
		musterijeMenu.add(musterijeItem);
		mainMenu.add(administratoriMenu);
		administratoriMenu.add(administratoriItem);
		mainMenu.add(ostaloMenu);
		ostaloMenu.add(automobiliItem);
		ostaloMenu.add(servisnideloviItem);
		ostaloMenu.add(servisneknjiziceItem);
		ostaloMenu.add(servisiautomobilaItem);
		
		
		
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
		automobiliItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazAutomobila ppauto = new ProzorPrikazAutomobila(Crudoperacije, prijavljeniAdministrator, musterija);
				ppauto.setVisible(true);
				
			}
		});
		servisneknjiziceItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazServisnihKnjizica ppsk = new ProzorPrikazServisnihKnjizica(Crudoperacije);
				ppsk.setVisible(true);
				
			}
		});
		servisnideloviItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazServisnihDelova ppsd = new ProzorPrikazServisnihDelova(Crudoperacije);
				ppsd.setVisible(true);
				
			}
		});
		servisiautomobilaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorPrikazServisaAutomobila ppsa = new ProzorPrikazServisaAutomobila(Crudoperacije);
				ppsa.setVisible(true);
				
			}
		});
		izlazItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GlavniProzorAdministrator.this.dispose();
				GlavniProzorAdministrator.this.setVisible(false);
				
			}
		});
	}
	
}
