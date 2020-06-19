package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import CRUD.CRUDOperacije;
import net.miginfocom.swing.MigLayout;

public class IzborLogina extends JFrame {
	
	CRUDOperacije crudoperacije = new CRUDOperacije();
	
	private JLabel lbl1 = new JLabel("Ulogujte se kao:");
	private JButton btnAdministrator = new JButton("Administrator");
	private JButton btnMusterija = new JButton("Musterija");
	private JButton btnServiser = new JButton("Serviser");
	private JButton btnCancel = new JButton("Cancel");
	
	public IzborLogina() {
		setTitle("Odabir logina");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 1");
		setLayout(mig);
		
		add(lbl1);
		add(btnAdministrator);
		add(btnMusterija);
		add(btnServiser);
		add(btnCancel);
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IzborLogina.this.dispose();
				IzborLogina.this.setVisible(false);
				
			}
		});
		btnAdministrator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		btnMusterija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IzborLogina.this.dispose();
				IzborLogina.this.setVisible(false);
				LoginProzorMusterija lpm = new LoginProzorMusterija(crudoperacije);
				lpm.setVisible(true);
				
			}
		});
		btnServiser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IzborLogina.this.dispose();
				IzborLogina.this.setVisible(false);
				LoginProzorServiser lps = new LoginProzorServiser(crudoperacije);
				lps.setVisible(true);
				
				
			}
		});
		btnAdministrator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IzborLogina.this.dispose();
				IzborLogina.this.setVisible(false);
				LoginProzorAdministrator lpa = new LoginProzorAdministrator(crudoperacije);
				lpa.setVisible(true);
				
			}
		});
	}
}
