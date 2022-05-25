package ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.CursaZbor;
import functionalities.RezervareZbor;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

public class RezervareZborFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOrasDestinatie;
	private JTextField txtOrasPlecare;
	private RezervareZbor rezervare = null;
	private RezervareZbor rezervareRetur = null;
	private JLabel lblNrBilete;

	// Genereaza forma
	public RezervareZborFrame(boolean staffOnly) {
		setTitle("Rezervare Zbor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOrasPlecare = new JLabel("Ora\u0219 origine:");
		lblOrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblOrasPlecare.setBounds(153, 42, 161, 30);
		contentPane.add(lblOrasPlecare);

		JLabel lblOrasSosire = new JLabel("Ora\u0219 destina\u021Bie:");
		lblOrasSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblOrasSosire.setBounds(153, 83, 187, 30);
		contentPane.add(lblOrasSosire);

		JLabel lblDataPlecarii = new JLabel("Data plec\u0103rii:");
		lblDataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDataPlecarii.setBounds(202, 145, 161, 30);
		contentPane.add(lblDataPlecarii);

		JLabel lblTipLoc = new JLabel("Tip loc:");
		lblTipLoc.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblTipLoc.setBounds(202, 255, 100, 30);
		contentPane.add(lblTipLoc);

		JLabel lblClasa = new JLabel("Clasa la care se dore\u0219te rezervarea:");
		lblClasa.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblClasa.setBounds(107, 400, 407, 30);
		contentPane.add(lblClasa);

		JLabel lblDataIntoarcere = new JLabel("Data \u00EEntoarcerii:");
		lblDataIntoarcere.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDataIntoarcere.setBounds(361, 320, 199, 30);
		contentPane.add(lblDataIntoarcere);

		txtOrasDestinatie = new JTextField();
		txtOrasDestinatie.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOrasDestinatie.setColumns(10);
		txtOrasDestinatie.setBounds(362, 83, 420, 30);
		contentPane.add(txtOrasDestinatie);

		JSpinner dateTimeDataPlecarii = new JSpinner(new SpinnerDateModel(new Date(System.currentTimeMillis()),
				new Date(1651524853330L), new Date(1967144053330L), Calendar.DAY_OF_YEAR));
		dateTimeDataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 20));
		JSpinner.DateEditor de_dateTimeDataPlecarii = new JSpinner.DateEditor(dateTimeDataPlecarii, "dd.MM.yy");
		dateTimeDataPlecarii.setEditor(de_dateTimeDataPlecarii);
		dateTimeDataPlecarii.setBounds(437, 145, 249, 30);
		contentPane.add(dateTimeDataPlecarii);

		JSpinner dateTimeDataIntoarcerii = new JSpinner(new SpinnerDateModel(new Date(System.currentTimeMillis()),
				new Date(1651524884913L), new Date(1967144084913L), Calendar.DAY_OF_YEAR));
		dateTimeDataIntoarcerii.setFont(new Font("Consolas", Font.PLAIN, 20));
		JSpinner.DateEditor de_dateTimeDataIntoarcerii = new JSpinner.DateEditor(dateTimeDataIntoarcerii, "dd.MM.yy");
		dateTimeDataIntoarcerii.setEditor(de_dateTimeDataIntoarcerii);
		dateTimeDataIntoarcerii.setBounds(652, 320, 130, 30);
		dateTimeDataIntoarcerii.setEnabled(false);
		contentPane.add(dateTimeDataIntoarcerii);

		String[] tipLoc = { "Adult", "Copil" };
		JComboBox comboTipLoc = new JComboBox(tipLoc);
		comboTipLoc.setFont(new Font("Consolas", Font.PLAIN, 20));
		comboTipLoc.setBounds(437, 255, 249, 30);
		contentPane.add(comboTipLoc);

		JCheckBox chkZborRetur = new JCheckBox("Retur");
		chkZborRetur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTimeDataIntoarcerii.setEnabled(chkZborRetur.isSelected() ? true : false);
			}
		});
		chkZborRetur.setBackground(new Color(168, 208, 224));
		chkZborRetur.setHorizontalAlignment(SwingConstants.LEFT);
		chkZborRetur.setFont(new Font("Consolas", Font.PLAIN, 20));
		chkZborRetur.setBounds(153, 320, 112, 30);
		contentPane.add(chkZborRetur);

		String[] clasaBilet = { "Econom", "Business", "Premium" };
		JComboBox comboClasa = new JComboBox(clasaBilet);
		comboClasa.setFont(new Font("Consolas", Font.PLAIN, 20));
		comboClasa.setBounds(598, 400, 222, 30);
		contentPane.add(comboClasa);

		txtOrasPlecare = new JTextField();
		txtOrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOrasPlecare.setColumns(10);
		txtOrasPlecare.setBounds(363, 42, 419, 30);
		contentPane.add(txtOrasPlecare);

		lblNrBilete = new JLabel("Numar bilete:");
		lblNrBilete.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNrBilete.setBounds(202, 200, 154, 30);
		contentPane.add(lblNrBilete);

		JSpinner spinnerNrBilete = new JSpinner();
		spinnerNrBilete.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerNrBilete.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerNrBilete.setBounds(437, 200, 249, 25);
		contentPane.add(spinnerNrBilete);

		JButton btnCautareZbor = new JButton("Căutare cursa de Zbor");
		btnCautareZbor.setForeground(Color.WHITE);
		btnCautareZbor.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnCautareZbor.setBounds(318, 475, 310, 49);
		btnCautareZbor.setBackground(new Color(55, 71, 133));
		btnCautareZbor.setOpaque(true);
		btnCautareZbor.setBorder(new RoundButton(30));
		btnCautareZbor.setUI(new ButtonFill());

		btnCautareZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean err = false;
				Color errColor = new Color(237, 181, 191);

				// Verificare Date Introduse

				// verificare oras de plecare
				if (!numeOrasValid(txtOrasPlecare.getText())) {
					err = true;
					txtOrasPlecare.setBackground(errColor);
				} else {
					txtOrasPlecare.setBackground(Color.white);
				}

				// verificare oras destinatie
				if (!numeOrasValid(txtOrasDestinatie.getText())) {
					err = true;
					txtOrasDestinatie.setBackground(errColor);
				} else {
					txtOrasDestinatie.setBackground(Color.white);
				}

				// visual solve for user playing with wrong dates
				dateTimeDataIntoarcerii.getEditor().getComponent(0).setBackground(Color.white);
				dateTimeDataPlecarii.getEditor().getComponent(0).setBackground(Color.white);
				// verificare consistenta date de plecare si sosire
				if (!dateValide((Date) dateTimeDataPlecarii.getValue(), (Date) dateTimeDataIntoarcerii.getValue(),
						chkZborRetur.isSelected())) {
					err = true;
					dateTimeDataPlecarii.getEditor().getComponent(0).setBackground(errColor);
					if (chkZborRetur.isSelected())
						dateTimeDataIntoarcerii.getEditor().getComponent(0).setBackground(errColor);
				} else {
					dateTimeDataPlecarii.getEditor().getComponent(0).setBackground(Color.white);
					dateTimeDataIntoarcerii.getEditor().getComponent(0).setBackground(Color.white);
				}

				// verificare bilete introduse
				if (0 >= (int) spinnerNrBilete.getValue()) {
					err = true;
					spinnerNrBilete.getEditor().getComponent(0).setBackground(errColor);
				} else {
					spinnerNrBilete.getEditor().getComponent(0).setBackground(Color.white);
				}

				// Daca datele au fost completate corect, trecem la rezervare
				if (!err) {
					// cream un obiect de tipul rezervare
					rezervare = new RezervareZbor(txtOrasPlecare.getText(), txtOrasDestinatie.getText(),
							(Date) dateTimeDataPlecarii.getValue(), (int) spinnerNrBilete.getValue(),
							(String) comboTipLoc.getSelectedItem(), (String) comboClasa.getSelectedItem(),
							chkZborRetur.isSelected(),
							chkZborRetur.isSelected() ? (Date) dateTimeDataIntoarcerii.getValue() : null);

					// o lista cu cursele tur si retur disponibile conform cerintelor
					List<CursaZbor> curseZborDisponibile = new ArrayList<CursaZbor>();
					List<CursaZbor> curseRezervareDisponibile = null;
					curseZborDisponibile = rezervare.getCurseZborDisponibile("curseZbor.json");

					// daca a fost selectata optiunea de return
					if (rezervare.isRetur()) {
						// se creaza un alt obiect rezervare cu datele de retur
						rezervareRetur = new RezervareZbor(rezervare.getDestinatie(), rezervare.getOrigine(),
								rezervare.getDataIntoarcere(), rezervare.getNrBilete(), rezervare.getTipLoc(),
								rezervare.getClasa(), false, null);
						curseRezervareDisponibile = new ArrayList<CursaZbor>();
						curseRezervareDisponibile = rezervareRetur.getCurseZborDisponibile("curseZbor.json");
					}

					// daca s-au gasit curse acestea sunt transmise spre afisare in 'CautareZbor'
					if (!curseZborDisponibile.isEmpty()) {
						CautareZborFrame cautareZbor = new CautareZborFrame(curseZborDisponibile, rezervare,
								curseRezervareDisponibile, staffOnly);
						cautareZbor.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ne pare rau, dar nu am gasit nici un zbor potrivit!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				}
			}

		});
		contentPane.add(btnCautareZbor);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				MainFrame mainFrame = new MainFrame(false);
				mainFrame.setVisible(true);
			}
		});
	}
	// Functii Verificare

	// verifica daca numele orasului este valid
	public boolean numeOrasValid(String oras) {
		if (oras == null || oras.equals(""))
			return false;

		return true;
	}

	// verifica daca datele de plecare (data1) si intoarcere (data2) sunt valide
	public boolean dateValide(Date date1, Date date2, boolean isRetur) {

		LocalDate _date1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate _date2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate _date = LocalDate.now().minusDays(1);

		if (isRetur) {
			// data 1 este trecut
			if (_date1.compareTo(_date) < 0)
				return false;
			// date 2 este trecut
			if (_date2.compareTo(_date) < 0)
				return false;
			// date 2 este trecut fata de date 1
			if (_date1.compareTo(_date2) > 0)
				return false;
		} else {
			// date 1 este trecut
			if (_date1.compareTo(_date) < 0)
				return false;
		}

		return true;
	}

}
