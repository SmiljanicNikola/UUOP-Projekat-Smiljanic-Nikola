package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import gui.zaMusteriju.PrikazZaMusteriju;
import gui.zaServisera.PrikazZaServisera;
import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.Serviser;

public class GlavniProzorMusterija extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu mogucnostiMenu = new JMenu("Mogucnosti");
	private JMenuItem zakaziteservisItem = new JMenuItem("Zakazite Servis");
	private JMenuItem prikazivanjeAutomobilaMusterijeItem = new JMenuItem("Prikazi automobile od musterije");
	private JMenu izlazMenu= new JMenu("Izlaz");
	private JMenuItem izlazItem = new JMenuItem("Izlaz"); 

	
	private CRUDOperacije crudoperacije;
	private Musterija prijavljenaMusterija;
	private Serviser prijavljeniServiser;
	private Administrator prijavljeniAdministrator;
	private Automobil automobil;
	
	public GlavniProzorMusterija(CRUDOperacije crudoperacije, Musterija prijavljenaMusterija) {
		this.crudoperacije = crudoperacije;
		this.prijavljenaMusterija = prijavljenaMusterija;
		setTitle("Musterija: " + prijavljenaMusterija.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(mogucnostiMenu);
		mogucnostiMenu.add(zakaziteservisItem);
		mogucnostiMenu.add(prikazivanjeAutomobilaMusterijeItem);
		mainMenu.add(izlazMenu);
		izlazMenu.add(izlazItem);
	}
	
	private void initActions() {
		izlazItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GlavniProzorMusterija.this.dispose();
				GlavniProzorMusterija.this.setVisible(false);
				
			}
		});
		prikazivanjeAutomobilaMusterijeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.zaMusteriju.PrikazZaMusteriju pzm = new gui.zaMusteriju.PrikazZaMusteriju(crudoperacije, prijavljenaMusterija, automobil);
				pzm.setVisible(true);
				
			}
		});
	}
	
}