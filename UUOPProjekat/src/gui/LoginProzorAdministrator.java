package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import model.Administrator;
import model.Musterija;
import model.Serviser;
import net.miginfocom.swing.MigLayout;

public class LoginProzorAdministrator extends JFrame {

	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblSifra = new JLabel("Sifra");
	private JPasswordField pfSifra = new JPasswordField(20);
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	private CRUDOperacije crudoperacije;
	private Musterija prijavljeni;
	
	public LoginProzorAdministrator(CRUDOperacije crudoperacije) {
		this.crudoperacije = crudoperacije;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
		
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
		setLayout(mig);
		
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblSifra);
		add(pfSifra);
		add(new JLabel()); 
		add(btnOk,"split2");
		add(btnCancel);
		
		getRootPane().setDefaultButton(btnOk);
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzorAdministrator.this.dispose();
				LoginProzorAdministrator.this.setVisible(false);
				
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska!", JOptionPane.WARNING_MESSAGE);
				} else {
					Administrator prijavljeniAdministrator = crudoperacije.loginAdministrator(korisnickoIme, sifra);
					if(prijavljeniAdministrator == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						System.out.println(prijavljeniAdministrator);
						LoginProzorAdministrator.this.dispose();
						LoginProzorAdministrator.this.setVisible(false);
						GlavniProzorAdministrator gpa = new GlavniProzorAdministrator(crudoperacije, prijavljeniAdministrator);
						gpa.setVisible(true);
					}
				}
			}
		});
	}	
	
}
