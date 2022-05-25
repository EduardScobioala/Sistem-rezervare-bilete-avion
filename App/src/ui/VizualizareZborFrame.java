package ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.CursaZbor;
import functionalities.ManagementCurseZbor;
import functionalities.RezervareZbor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class VizualizareZborFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_OrasPlecare;
	private JTextField txt_OrasDestinatie;
	private JTextField txt_NrBilete;
	private JTextField txtOrarZbor;
	private JTextField txt_Pret;
	private JTextField dateTime_DataZbor;
	private JTextField txt_Nume;
	private JTextField txt_Prenume;
	private JTextField txt_Telefon;
	private JTextField txt_Email;
	private JTextField txt_NrCard;
	private JTextField txt_NumeTitular;
	private JTextField txt_CVC;
	private JTextField txt_PlataCashSuma;
	private JTextField textClasaBilete;
	private JTextField textTipBilet;
	private float _pret;

	public VizualizareZborFrame(CursaZbor cursaZbor, RezervareZbor rezervare, float pret, boolean staffOnly) {
		_pret = pret;
		setTitle("Vizualizare Zbor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(168, 208, 224));
		panel.setBounds(10, 11, 964, 148);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_DetaliiZborTitlu = new JLabel("Detalii zbor");
		lbl_DetaliiZborTitlu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_DetaliiZborTitlu.setBounds(407, 0, 114, 38);
		panel.add(lbl_DetaliiZborTitlu);

		JLabel lbl_OrasPlecare = new JLabel("Origine:");
		lbl_OrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_OrasPlecare.setBounds(24, 43, 70, 20);
		panel.add(lbl_OrasPlecare);

		JLabel lbl_OrasDestinatie = new JLabel("Destina\u021Bie:");
		lbl_OrasDestinatie.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_OrasDestinatie.setBounds(339, 43, 114, 20);
		panel.add(lbl_OrasDestinatie);

		JLabel lbl_NrBilete = new JLabel("Număr bilete:");
		lbl_NrBilete.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_NrBilete.setBounds(176, 120, 114, 20);
		panel.add(lbl_NrBilete);

		JLabel lbl_DurataZbor = new JLabel("Orar zbor:");
		lbl_DurataZbor.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_DurataZbor.setBounds(24, 84, 105, 20);
		panel.add(lbl_DurataZbor);

		JLabel lbl_DataPlecare = new JLabel("Dat\u0103:");
		lbl_DataPlecare.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_DataPlecare.setBounds(679, 43, 70, 20);
		panel.add(lbl_DataPlecare);

		JLabel lbl_Pret = new JLabel("Pre\u021B:");
		lbl_Pret.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_Pret.setBounds(528, 120, 78, 20);
		panel.add(lbl_Pret);

		JLabel lbl_RON_ReadOnly = new JLabel("RON");
		lbl_RON_ReadOnly.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_RON_ReadOnly.setBounds(745, 120, 45, 20);
		panel.add(lbl_RON_ReadOnly);

		txt_OrasPlecare = new JTextField();
		txt_OrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_OrasPlecare.setEditable(false);
		txt_OrasPlecare.setBounds(117, 43, 140, 20);
		panel.add(txt_OrasPlecare);
		txt_OrasPlecare.setColumns(10);

		txt_OrasDestinatie = new JTextField();
		txt_OrasDestinatie.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_OrasDestinatie.setEditable(false);
		txt_OrasDestinatie.setColumns(10);
		txt_OrasDestinatie.setBounds(450, 43, 140, 20);
		panel.add(txt_OrasDestinatie);

		txt_NrBilete = new JTextField();
		txt_NrBilete.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_NrBilete.setEditable(false);
		txt_NrBilete.setColumns(10);
		txt_NrBilete.setBounds(300, 120, 140, 20);
		panel.add(txt_NrBilete);

		txtOrarZbor = new JTextField();
		txtOrarZbor.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtOrarZbor.setEditable(false);
		txtOrarZbor.setColumns(10);
		txtOrarZbor.setBounds(117, 84, 140, 20);
		panel.add(txtOrarZbor);

		txt_Pret = new JTextField();
		txt_Pret.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_Pret.setEditable(false);
		txt_Pret.setColumns(10);
		txt_Pret.setBounds(593, 120, 140, 20);
		panel.add(txt_Pret);

		dateTime_DataZbor = new JTextField();
		dateTime_DataZbor.setFont(new Font("Consolas", Font.PLAIN, 13));
		dateTime_DataZbor.setEditable(false);
		dateTime_DataZbor.setColumns(10);
		dateTime_DataZbor.setBounds(751, 43, 140, 20);
		panel.add(dateTime_DataZbor);

		JPanel groupBox_PlataBanca = new JPanel();
		groupBox_PlataBanca.setBackground(new Color(168, 208, 224));
		groupBox_PlataBanca.setBounds(10, 334, 644, 132);
		contentPane.add(groupBox_PlataBanca);
		groupBox_PlataBanca.setLayout(null);

		JLabel lbl_ModalitatePlata = new JLabel("Modalitate plat\u0103:");
		lbl_ModalitatePlata.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_ModalitatePlata.setBounds(10, 10, 147, 23);
		groupBox_PlataBanca.add(lbl_ModalitatePlata);

		JLabel lbl_NrCard_sau_Cont = new JLabel("Num\u0103r card/cont:");
		lbl_NrCard_sau_Cont.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_NrCard_sau_Cont.setBounds(10, 56, 140, 20);
		groupBox_PlataBanca.add(lbl_NrCard_sau_Cont);

		JLabel lbl_DataExpirareCard = new JLabel("Dat\u0103 expirare card:");
		lbl_DataExpirareCard.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_DataExpirareCard.setBounds(343, 57, 159, 20);
		groupBox_PlataBanca.add(lbl_DataExpirareCard);

		JLabel lbl_NumeTitular = new JLabel("Nume titular:");
		lbl_NumeTitular.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_NumeTitular.setBounds(10, 90, 147, 20);
		groupBox_PlataBanca.add(lbl_NumeTitular);

		JLabel lbl_CodCVC = new JLabel("Cod CVC:");
		lbl_CodCVC.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_CodCVC.setBounds(343, 91, 92, 20);
		groupBox_PlataBanca.add(lbl_CodCVC);

		txt_NrCard = new JTextField();
		txt_NrCard.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_NrCard.setColumns(10);
		txt_NrCard.setBounds(165, 56, 160, 20);
		groupBox_PlataBanca.add(txt_NrCard);

		txt_NumeTitular = new JTextField();
		txt_NumeTitular.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_NumeTitular.setColumns(10);
		txt_NumeTitular.setBounds(165, 90, 159, 20);
		groupBox_PlataBanca.add(txt_NumeTitular);

		txt_CVC = new JTextField();
		txt_CVC.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_CVC.setColumns(10);
		txt_CVC.setBounds(512, 90, 122, 20);
		groupBox_PlataBanca.add(txt_CVC);

		JSpinner dateTime_ExpirareCard = new JSpinner(new SpinnerDateModel(new Date(System.currentTimeMillis()),
				new Date(1651524853330L), new Date(1967144053330L), Calendar.DAY_OF_YEAR));
		JSpinner.DateEditor de_dateTime_ExpirareCard = new JSpinner.DateEditor(dateTime_ExpirareCard, "MM.yy");
		dateTime_ExpirareCard.setEditor(de_dateTime_ExpirareCard);
		dateTime_ExpirareCard.setFont(new Font("Consolas", Font.PLAIN, 13));
		dateTime_ExpirareCard.setBounds(512, 56, 122, 20);
		groupBox_PlataBanca.add(dateTime_ExpirareCard);

		JPanel groupBox_PlataCash = new JPanel();
		groupBox_PlataCash.setVisible(staffOnly);
		groupBox_PlataCash.setBackground(new Color(168, 208, 224));
		groupBox_PlataCash.setBounds(664, 361, 270, 80);
		contentPane.add(groupBox_PlataCash);
		groupBox_PlataCash.setLayout(null);

		JLabel lbl_PlataCashTitlu = new JLabel("Plat\u0103 cash");
		lbl_PlataCashTitlu.setBounds(10, 10, 122, 20);
		lbl_PlataCashTitlu.setFont(new Font("Consolas", Font.PLAIN, 15));
		groupBox_PlataCash.add(lbl_PlataCashTitlu);

		JLabel lbl_PlataCashSuma = new JLabel("Suma:");
		lbl_PlataCashSuma.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_PlataCashSuma.setBounds(10, 37, 49, 20);
		groupBox_PlataCash.add(lbl_PlataCashSuma);

		txt_PlataCashSuma = new JTextField();
		txt_PlataCashSuma.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_PlataCashSuma.setColumns(10);
		txt_PlataCashSuma.setBounds(60, 37, 136, 20);
		groupBox_PlataCash.add(txt_PlataCashSuma);

		JLabel lbl_RON = new JLabel("RON");
		lbl_RON.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_RON.setBounds(215, 37, 45, 20);
		groupBox_PlataCash.add(lbl_RON);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(168, 208, 224));
		panel_1.setBounds(10, 170, 964, 132);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JSpinner spinner_Varsta = new JSpinner();
		spinner_Varsta.setFont(new Font("Consolas", Font.PLAIN, 13));
		spinner_Varsta.setBounds(448, 44, 160, 20);
		panel_1.add(spinner_Varsta);
		
		JRadioButton radio_Card = new JRadioButton("Card");
		radio_Card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_DataExpirareCard.setVisible(true);
				lbl_CodCVC.setVisible(true);
				dateTime_ExpirareCard.setVisible(true);
				txt_CVC.setVisible(true);
			}
		});
		radio_Card.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_Card.setBounds(177, 8, 55, 20);
		radio_Card.setSelected(true);
		groupBox_PlataBanca.add(radio_Card);
		
		JRadioButton radio_ViramentBancar = new JRadioButton("Virament bancar");
		radio_ViramentBancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_DataExpirareCard.setVisible(false);
				lbl_CodCVC.setVisible(false);
				dateTime_ExpirareCard.setVisible(false);
				txt_CVC.setVisible(false);
			}
		});
		radio_ViramentBancar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_ViramentBancar.setBounds(276, 8, 127, 20);
		groupBox_PlataBanca.add(radio_ViramentBancar);
		
		ButtonGroup plataGroup = new ButtonGroup();
		plataGroup.add(radio_Card);
		plataGroup.add(radio_ViramentBancar);		
		
		JButton btn_RezervaLocul = new JButton("Rezerv\u0103 locul");
		btn_RezervaLocul.setForeground(Color.WHITE);
		btn_RezervaLocul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean err = false;
				String[] data;
				String err_desc = "";
				Color errColor = new Color(237, 181, 191);

				// Functii de Validare

				// verificare Nume
				if (!numeValid(txt_Nume.getText())) {
					err = true;
					err_desc += "\nNume invalid";
					txt_Nume.setBackground(errColor);
				} else {
					txt_Nume.setBackground(Color.white);
				}

				// verificare Prenume
				if (!numeValid(txt_Prenume.getText())) {
					err = true;
					err_desc += "\nPrenume invalid";
					txt_Prenume.setBackground(errColor);
				} else {
					txt_Prenume.setBackground(Color.white);
				}

				// verificare Nume Titular card bancar
				data = txt_NumeTitular.getText().split(" ");
				for (int i = 0; i < data.length; i++) {
					if (!numeValid(data[i])) {
						err = true;
						err_desc += "\nNume titular invalid";
						txt_NumeTitular.setBackground(errColor);
						break;
					} else {
						txt_NumeTitular.setBackground(Color.white);
					}
				}

				// verificare varsta
				if (spinner_Varsta.getValue() == null || (int)spinner_Varsta.getValue() < 16) {
					err = true;
					err_desc += "\nVarsta invalida";
					spinner_Varsta.getEditor().getComponent(0).setBackground(errColor);
				} else {
					spinner_Varsta.getEditor().getComponent(0).setBackground(Color.white);
				}

				// verificare email
				if (!emailValid(txt_Email.getText())) {
					err = true;
					err_desc += "\nE-mail invalid";
					txt_Email.setBackground(errColor);
				} else {
					txt_Email.setBackground(Color.white);
				}

				if (radio_Card.isSelected()) {
					// verificare CVC
					if (!CVCValid(txt_CVC.getText())) {
						err = true;
						err_desc += "\nCod CVC invalid";
						txt_CVC.setBackground(errColor);
					} else {
						txt_CVC.setBackground(Color.white);
					}

					// verificare data de exprirare card
					if (!dataExpirareValida((Date) dateTime_ExpirareCard.getValue())) {
						err = true;
						err_desc += "\nCard expirat";
						dateTime_ExpirareCard.getEditor().getComponent(0).setBackground(Color.white);
					} else {
						dateTime_ExpirareCard.getEditor().getComponent(0).setBackground(Color.white);
					}
				}

				// verificare card/cont
				if (!nrCardContValid(txt_NrCard.getText(), radio_Card.isSelected())) {
					err = true;
					err_desc += "\nNumar card eronat";
					txt_NrCard.setBackground(errColor);
				} else {
					txt_NrCard.setBackground(Color.white);
				}

				// verificare telefon 
				if (!nrTelValid(txt_Telefon.getText())) {
					err = true;
					err_desc += "\nNumar de telefon eronat";
					txt_Telefon.setBackground(errColor);
				} else {
					txt_Telefon.setBackground(Color.white);
				}

				// verificare suma cash introdusa
				if (staffOnly) {
					if (!sumaCashValida(txt_PlataCashSuma.getText(), rezervare.isRetur())) {
						err = true;
						err_desc += "\nSuma eronata";
						txt_PlataCashSuma.setBackground(errColor);
					} else {
						txt_PlataCashSuma.setBackground(Color.white);
					}
				}

				// REZERVAREA
				if (err) {
					JOptionPane.showMessageDialog(null, err_desc);
				} else {
					rezervareBilete(cursaZbor, rezervare, "curseZbor.json");
					JOptionPane.showMessageDialog(null,
							"Cursa a fost rezervata, multumim ca alegeti serviciile noastre <3");

					dispose();
					MainFrame mainFrame = new MainFrame(false);
					mainFrame.setVisible(true);
				}
			}
		});

		btn_RezervaLocul.setFont(new Font("Consolas", Font.PLAIN, 16));
		btn_RezervaLocul.setBounds(366, 500, 240, 50);
		btn_RezervaLocul.setBackground(new Color(55, 71, 133));
		btn_RezervaLocul.setOpaque(true);
		// Round the button with radius = 30
		btn_RezervaLocul.setBorder(new RoundButton(30));
		btn_RezervaLocul.setUI(new ButtonFill());
		contentPane.add(btn_RezervaLocul);

		JLabel lbl_RezervareTitlu = new JLabel("Rezervare");
		lbl_RezervareTitlu.setBounds(425, 11, 89, 25);
		panel_1.add(lbl_RezervareTitlu);
		lbl_RezervareTitlu.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_Email = new JLabel("E-mail:");
		lbl_Email.setBounds(640, 60, 59, 23);
		panel_1.add(lbl_Email);
		lbl_Email.setFont(new Font("Consolas", Font.PLAIN, 15));

		JLabel lbl_Prenume = new JLabel("Prenume:");
		lbl_Prenume.setBounds(31, 78, 68, 23);
		panel_1.add(lbl_Prenume);
		lbl_Prenume.setFont(new Font("Consolas", Font.PLAIN, 15));

		txt_Prenume = new JTextField();
		txt_Prenume.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_Prenume.setBounds(125, 80, 160, 20);
		panel_1.add(txt_Prenume);
		txt_Prenume.setColumns(10);

		JLabel lbl_Varsta = new JLabel("V\u00E2rst\u0103:");
		lbl_Varsta.setBounds(356, 44, 68, 23);
		panel_1.add(lbl_Varsta);
		lbl_Varsta.setFont(new Font("Consolas", Font.PLAIN, 15));

		JLabel lbl_Nume = new JLabel("Nume:");
		lbl_Nume.setBounds(31, 44, 68, 23);
		panel_1.add(lbl_Nume);
		lbl_Nume.setFont(new Font("Consolas", Font.PLAIN, 15));

		txt_Nume = new JTextField();
		txt_Nume.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_Nume.setBounds(125, 44, 160, 20);
		panel_1.add(txt_Nume);
		txt_Nume.setColumns(10);

		txt_Email = new JTextField();
		txt_Email.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_Email.setBounds(709, 62, 184, 20);
		panel_1.add(txt_Email);
		txt_Email.setColumns(10);

		txt_Telefon = new JTextField();
		txt_Telefon.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_Telefon.setBounds(448, 80, 160, 20);
		panel_1.add(txt_Telefon);
		txt_Telefon.setColumns(10);

		JLabel lbl_Telefon = new JLabel("Telefon:");
		lbl_Telefon.setBounds(356, 78, 73, 23);
		panel_1.add(lbl_Telefon);
		lbl_Telefon.setFont(new Font("Consolas", Font.PLAIN, 15));

		JLabel lbl_ClasaBilete = new JLabel("Clasa:");
		lbl_ClasaBilete.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_ClasaBilete.setBounds(679, 84, 70, 20);
		panel.add(lbl_ClasaBilete);

		textClasaBilete = new JTextField();
		textClasaBilete.setText("<dynamic> - <dynamic>");
		textClasaBilete.setFont(new Font("Consolas", Font.PLAIN, 13));
		textClasaBilete.setEditable(false);
		textClasaBilete.setColumns(10);
		textClasaBilete.setBounds(751, 84, 140, 20);
		panel.add(textClasaBilete);

		JLabel lbl_OrasDestinatie_1 = new JLabel("Tip bilet:");
		lbl_OrasDestinatie_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lbl_OrasDestinatie_1.setBounds(339, 84, 114, 20);
		panel.add(lbl_OrasDestinatie_1);

		textTipBilet = new JTextField();
		textTipBilet.setText((String) null);
		textTipBilet.setFont(new Font("Consolas", Font.PLAIN, 13));
		textTipBilet.setEditable(false);
		textTipBilet.setColumns(10);
		textTipBilet.setBounds(450, 84, 140, 20);
		panel.add(textTipBilet);

		// add the previous data
		txt_OrasPlecare.setText(cursaZbor.getAeroportPlecare());
		txt_OrasPlecare.setEditable(false);
		txt_OrasDestinatie.setText(cursaZbor.getAeroportSosire());
		txt_OrasDestinatie.setEditable(false);
		dateTime_DataZbor.setText(
				rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
		dateTime_DataZbor.setEditable(false);
		txtOrarZbor.setText(cursaZbor.getOraPlecare() + " - " + cursaZbor.getOraSosire());
		txtOrarZbor.setEditable(false);

		if (rezervare.isRetur()) {
			txt_NrBilete.setText("" + rezervare.getNrBilete() * 2);
			txt_NrBilete.setEditable(false);
			txt_Pret.setText(Float.toString(pret * 2));
			txt_Pret.setEditable(false);
		} else {
			txt_NrBilete.setText("" + rezervare.getNrBilete());
			txt_NrBilete.setEditable(false);
			txt_Pret.setText(Float.toString(pret));
			txt_Pret.setEditable(false);
		}

		textTipBilet.setText(rezervare.getTipLoc());
		textTipBilet.setEditable(false);
		textClasaBilete.setText(rezervare.getClasa());
		textClasaBilete.setEditable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				// inregistarea rezervarii
				RezervareZborFrame rezervareZbor = new RezervareZborFrame(staffOnly);
				rezervareZbor.setVisible(true);
				;
			}
		});
	}

	// verifica daca numele pasagerului este valid (fiecare cuvant din nume, fara spatii)
	public boolean numeValid(String nume) {
		if (nume == null || nume.length() == 0)
			return false;

		for (int i = 0; i < nume.length(); i++) {
			if (nume.charAt(i) < 'A' || nume.charAt(i) > 'z')
				return false;
			if (nume.charAt(i) >= '[' && nume.charAt(i) <= '`')
				return false;
		}
		return true;
	}

//verifica daca e-mail-ul dat este valid
	public boolean emailValid(String email) {
		if (email == null || email.equals(""))
			return false;
		int at = 0, dot = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@')
				at++;
			if (email.charAt(i) == '.')
				dot++;
			if (email.charAt(i) == ' ')
				return false;
		}
		if (at != 1 || dot != 1)
			return false;

		return true;
	}

//verifica daca este valid codul CVC dat
	public boolean CVCValid(String CVC) {
		if (CVC == null || CVC.length() != 3)
			return false;
		for (int i = 0; i < CVC.length(); i++) {
			if (CVC.charAt(i) < '0' || CVC.charAt(i) > '9')
				return false;
		}
		return true;
	}

//verifica daca este valid numarul cardului dat
	public boolean nrCardContValid(String nr, boolean card) {

		if (nr == null || nr == "")
			return false;
		
		if (card == true) {
			if (nr.length() != 16)
				return false;
			for (int i = 0; i < nr.length(); i++) {
				if (nr.charAt(i) < '0' || nr.charAt(i) > '9')
					return false;
			}
		} else {
			if (nr.length() != 24)
				return false;
			if (nr.charAt(0) < 'A' || nr.charAt(0) > 'Z' || nr.charAt(1) < 'A' || nr.charAt(1) > 'Z')
				return false;

			for (int i = 0; i < nr.length(); i++) {
				if (nr.charAt(i) < '0')
					return false;
				if (nr.charAt(i) > '9' && nr.charAt(i) < 'A')
					return false;
				if (nr.charAt(i) > 'Z')
					return false;
			}
		}
		return true;
	}

//verifica daca nu este expirat cardul dat
	public boolean dataExpirareValida(Date date) {
		LocalDate _date = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate time = LocalDate.now();
		
		if (_date.compareTo(time) < 0) return false;

		return true;
	}

//verifica daca suma inregistrata este valida
	public boolean sumaCashValida(String suma, boolean flag) {
		boolean dot = false;
		if (suma == null || suma.equals(""))
			return false;

		for (int i = 0; i < suma.length(); i++) {
			if ((suma.charAt(i) < '0' || suma.charAt(i) > '9') && suma.charAt(i) != '.')
				return false;
			if (suma.charAt(i) == '.')
				dot = true;
		}

		if (!dot)
			return false;
		
		if (flag) {
			if (_pret*2 > Float.parseFloat(suma)) return false;			
		} else {
			if (_pret > Float.parseFloat(suma)) return false;			
		}

		return true;
	}

//verifica daca numarul de telefon dat este valid
	public boolean nrTelValid(String tel) {
		if (tel == null || tel.length() != 10)
			return false;

		for (int i = 0; i < tel.length(); i++) {
			if (tel.charAt(i) < '0' || tel.charAt(i) > '9')
				return false;
		}
		return true;
	}

	void rezervareBilete(CursaZbor cursaZbor, RezervareZbor rezervare, String filename) {
		ManagementCurseZbor manager = new ManagementCurseZbor();

		// clasa to int index
		int index = 0;
		if (rezervare.getClasa().equals("Business"))
			index = 1;
		if (rezervare.getClasa().equals("Premium"))
			index = 2;

		// get locurile deja rezervare
		int[] locuriRezervate = cursaZbor.getLocuriRezervate();

		// adaugare locuri rezervate
		if (rezervare.isRetur()) {
			locuriRezervate[index] += rezervare.getNrBilete() * 2;
		} else {
			locuriRezervate[index] += rezervare.getNrBilete();
		}

		// crearea cursa cu datele adaugate
		CursaZbor newCursaZbor = new CursaZbor(cursaZbor.getNumeCompanie(), cursaZbor.getAeroportPlecare(),
				cursaZbor.getAeroportSosire(), cursaZbor.getOraPlecare(), cursaZbor.getOraSosire(),
				cursaZbor.getZileOperare(), cursaZbor.getPretClase(), cursaZbor.getLocuriDisponibile(), locuriRezervate,
				cursaZbor.getCodCursa(), cursaZbor.getTipAvion(), cursaZbor.isDiscountDusIntors(),
				cursaZbor.isDiscountLastMinute());

		// datele actualizate
		manager.actualizareCurseZbor(cursaZbor.getCodCursa(), newCursaZbor);
	}
}