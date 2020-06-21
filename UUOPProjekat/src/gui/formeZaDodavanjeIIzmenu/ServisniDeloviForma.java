package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import CRUD.CRUDOperacije;
import enumeracije.Pol;
import enumeracije.marka;
import enumeracije.model;
import model.Administrator;
import model.ServisniDeo;
import net.miginfocom.swing.MigLayout;

public class ServisniDeloviForma extends JFrame {

	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(8);
	private JLabel lblMarka = new JLabel("Marka");
	private JComboBox<marka> cbMarka = new JComboBox<marka>(marka.values());
	private JLabel lblModel = new JLabel("Model");
	private JComboBox<model> cbModel = new JComboBox<model>(model.values());
	private JLabel lblCena = new JLabel("Cena");
	private JTextField txtCena = new JTextField(10);
	private JLabel lblnazivDela = new JLabel("Naziv dela");
	private JTextField txtnazivDela = new JTextField(15);
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private ServisniDeo servisnideo;

	public ServisniDeloviForma(CRUDOperacije Crudoperacije, ServisniDeo servisnideo) {
		this.Crudoperacije = Crudoperacije;
		this.servisnideo = servisnideo;
		if (servisnideo == null) {
			setTitle("Dodavanje administratora");
		} else {
			setTitle("Izmena podataka - " + servisnideo.getId());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	public void initGUI(){
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);

		if (servisnideo != null) {
			popuniPolja();
		}

		add(lblId);
		add(txtId);
		add(lblMarka);
		add(cbMarka);
		add(lblModel);
		add(cbModel);
		add(lblCena);
		add(txtCena);
		add(lblnazivDela);
		add(txtnazivDela);
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	public void initActions(){
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());
					marka marka = (enumeracije.marka) cbMarka.getSelectedItem();
					model model = (enumeracije.model) cbModel.getSelectedItem();
					int cena = Integer.parseInt(txtCena.getText().trim());
					String nazivDela = txtnazivDela.getText().trim();

					if (servisnideo == null) { 
						ServisniDeo servisnideo = new ServisniDeo(id, marka, model, cena, nazivDela);
						Crudoperacije.dodajServisniDeo(servisnideo);
					} else {
						servisnideo.setId(id);
						servisnideo.setMarkaAutomobila(marka);
						servisnideo.setModelAutomobila(model);
						servisnideo.setCena(cena);
						servisnideo.setNazivDela(nazivDela);
					}
					 Crudoperacije.snimiServisneDelove();
					 ServisniDeloviForma.this.dispose();
					 ServisniDeloviForma.this.setVisible(false);
					
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisniDeloviForma.this.dispose();
				ServisniDeloviForma.this.setVisible(false);
				
			}
		});
	}
	
	public void popuniPolja() {
		txtId.setText(String.valueOf(servisnideo.getId()));
		cbMarka.setSelectedItem(servisnideo.getMarkaAutomobila());
		cbModel.setSelectedItem(servisnideo.getMarkaAutomobila());
		txtCena.setText(String.valueOf(servisnideo.getCena()));
		txtnazivDela.setText(servisnideo.getNazivDela());
	
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popraviti sledece greske u unosu: \n";

		try {
			Integer.parseInt(txtId.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "Id mora biti broj \n";
			ok = false;
		}

		if (txtnazivDela.getText().trim().equals("")) {
			poruka += "Unesite Naziv dela \n";
			ok = false;
		}
		try {
			Integer.parseInt(txtCena.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "Atribut cena mora biti broj \n";
			ok = false;
		}
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}