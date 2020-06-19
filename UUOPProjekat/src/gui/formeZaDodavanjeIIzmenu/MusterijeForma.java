package gui.formeZaDodavanjeIIzmenu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import enumeracije.pol;
import model.Musterija;
import model.Osoba;
import net.miginfocom.swing.MigLayout;





public class MusterijeForma extends JFrame {
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(8);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(15);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<pol> cbPol = new JComboBox<pol>(pol.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblTelefon = new JLabel("Telefon");
	private JTextField txtTelefon = new JTextField(20);
	private JLabel lblkorisnickoIme = new JLabel("korisnickoIme");
	private JTextField txtkorisnickoIme = new JTextField(20);
	private JLabel lblSifra = new JLabel("Sifra");
	private JPasswordField pfsifra = new JPasswordField(20);
	private JLabel lblnagradniBodovi = new JLabel("Nagradni bodovi");
	private JTextField txtnagradniBodovi = new JTextField(10);
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	private CRUDOperacije crudoperacije;
	private Musterija musterija;
	
	public MusterijeForma(CRUDOperacije crudOperacije, Musterija musterija) {
		this.crudoperacije = crudoperacije;
		this.musterija = musterija;
		if(musterija == null) {
			setTitle("Dodavanje musterije");
		} else {
			 setTitle("Izmena podataka - " + musterija.getId());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	public void initGUI() {
		MigLayout layout = new MigLayout("wrap 2","[][]", "[][][][][]20[]");
		setLayout(layout);
		
		add(lblId);
		add(txtId);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblPol);
		add(cbPol);
		add(lblAdresa);
		add(txtAdresa);
		add(lblTelefon);
		add(txtTelefon);
		add(lblkorisnickoIme);
		add(txtkorisnickoIme);
		add(lblSifra);
		add(pfsifra);
		add(lblnagradniBodovi);
		add(txtnagradniBodovi);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		
	}
	
	public void initActions() {
		
	}
	
	
	
	
	
}
