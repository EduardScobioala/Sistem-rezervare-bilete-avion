package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.CursaZbor;
import functionalities.RezervareZbor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class VizualizareZborFrame extends JFrame {

	private JPanel contentPane;

	private RezervareZbor zbor;
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
	private boolean plata_cash;
	private JTextField textClasaBilete;
	private JTextField textTipBilet;

	
	/*
	 * public VizualizareZborFrame(RezervareZbor zbor, boolean plata_cash) {
	 * this.zbor = zbor; this.plata_cash = plata_cash; }
	 * 
	 * static VizualizareZborFrame frame;
	 */
	 

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { frame = new VizualizareZborFrame();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * frame.open();
	 * 
	 * } }); }
	 */

	/*
	 * public void open() { // load selected flight details if (zbor == null) {
	 * boolean ok = false; JOptionPane.showMessageDialog(null,
	 * "Eroare �nc�rcare detalii zbor ales"); frame.dispose(); } else {
	 * txt_OrasPlecare.setText(zbor.getOrigine());
	 * txt_OrasDestinatie.setText(zbor.getDestinatie()); //
	 * dateTime_DataZbor.setData(zbor.getData()); } }
	 */

	public VizualizareZborFrame(CursaZbor cursaZbor, RezervareZbor rezervare, float pret, boolean staffOnly) {
		setTitle("Vizualizare Zbor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

		JRadioButton radio_Card = new JRadioButton("Card");
		radio_Card.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_Card.setBounds(177, 8, 55, 20);
		groupBox_PlataBanca.add(radio_Card);

		JRadioButton radio_ViramentBancar = new JRadioButton("Virament bancar");
		radio_ViramentBancar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_ViramentBancar.setBounds(276, 8, 127, 20);
		groupBox_PlataBanca.add(radio_ViramentBancar);

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

		JSpinner dateTime_ExpirareCard = new JSpinner();
		dateTime_ExpirareCard.setFont(new Font("Consolas", Font.PLAIN, 13));
		dateTime_ExpirareCard.setBounds(512, 56, 122, 20);
		groupBox_PlataBanca.add(dateTime_ExpirareCard);

		JPanel groupBox_PlataCash = new JPanel();
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

		JLabel lbl_ErrData = new JLabel("#ERROR#");
		lbl_ErrData.setFont(new Font("Consolas", Font.PLAIN, 16));
		lbl_ErrData.setBounds(866, 523, 68, 25);
		contentPane.add(lbl_ErrData);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(168, 208, 224));
		panel_1.setBounds(10, 170, 964, 132);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JSpinner spinner_Varsta = new JSpinner();
		spinner_Varsta.setFont(new Font("Consolas", Font.PLAIN, 13));
		spinner_Varsta.setBounds(448, 44, 160, 20);
		panel_1.add(spinner_Varsta);

		JButton btn_RezervaLocul = new JButton("Rezerv\u0103 locul");
		btn_RezervaLocul.setForeground(Color.WHITE);
		btn_RezervaLocul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean err_nume = false;
				boolean err_prenume = false;
				boolean err_dataExpirare = false;
				boolean err_email = false;
				boolean err_tel = false;
				boolean err_varsta = false;
				boolean err_nrCardCont = false;
				boolean err_NumeTitular = false;
				boolean err_CVC = false;
				boolean err = false;
				String[] data;
				String err_desc = "";
				Color c_err = Color.red;

				// functii de verificare
				if (!numeValid(txt_Nume.getText())) {
					err = true;
					err_nume = true;
					err_desc += "\nNume invalid";
					txt_Nume.setBackground(c_err);
				}

				if (!numeValid(txt_Prenume.getText())) {
					err = true;
					err_prenume = true;
					err_desc += "\nPrenume invalid";
					txt_Prenume.setBackground(c_err);
				}

				data = txt_NumeTitular.getText().split(" ");
				for (int i = 0; i < data.length; i++) {
					if (!numeValid(data[i])) {
						err = true;
						err_NumeTitular = true;
						err_desc += "\nNume titular invalid";
						txt_NumeTitular.setBackground(c_err);
						break;
					}
				}

				if (spinner_Varsta.getValue() == null || (spinner_Varsta.getValue() != null
						&& Integer.parseInt(spinner_Varsta.getValue().toString()) <= 0)) {
					err = true;
					err_varsta = true;
					err_desc += "\nV�rst� invalid�";
					spinner_Varsta.setBackground(c_err);
				}

				if (!emailValid(txt_Email.getText())) {
					err = true;
					err_email = true;
					err_desc += "\nE-mail invalid";
					txt_Email.setBackground(c_err);
				}

				if (!CVCValid(txt_CVC.getText())) {
					err = true;
					err_CVC = true;
					err_desc += "\nCod CVC invalid";
					txt_CVC.setBackground(c_err);
				}

				int[] date = new int[4];
				SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy");

				// data plecare
				String[] buf = form.format(dateTime_ExpirareCard.getValue()).split("/");
				date[0] = Integer.parseInt(buf[2]);

				if (buf[1].equals("Jan"))
					date[1] = 1;
				else if (buf[1].equals("Feb"))
					date[1] = 2;
				else if (buf[1].equals("Mar"))
					date[1] = 3;
				else if (buf[1].equals("Apr"))
					date[1] = 4;
				else if (buf[1].equals("May"))
					date[1] = 5;
				else if (buf[1].equals("Jun"))
					date[1] = 6;
				else if (buf[1].equals("Jul"))
					date[1] = 7;
				else if (buf[1].equals("Aug"))
					date[1] = 8;
				else if (buf[1].equals("Sep"))
					date[1] = 9;
				else if (buf[1].equals("Oct"))
					date[1] = 10;
				else if (buf[1].equals("Nov"))
					date[1] = 11;
				else if (buf[1].equals("Dec"))
					date[1] = 12;

				date[2] = Integer.parseInt(buf[5]);

				if (!dataExpirareValida(date)) {
					err = true;
					err_dataExpirare = true;
					err_desc += "\nCard expirat";
					lbl_ErrData.setVisible(err_dataExpirare);
					dateTime_ExpirareCard.setBackground(c_err);
				}

				if (!nrCardContValid(txt_NrCard.getText(), radio_Card.isSelected())) {
					err = true;
					err_email = true;
					err_desc += "\nNum�r card eronat";
					txt_NrCard.setBackground(c_err);
				}

				if (!nrTelValid(txt_Telefon.getText())) {
					err = true;
					err_email = true;
					err_desc += "\nNum�r de telefon eronat";
					txt_Telefon.setBackground(c_err);
				}

				if (!sumaCashValida(txt_PlataCashSuma.getText())) {
					err = true;
					err_email = true;
					err_desc += "\nSum� eronat�";
					txt_PlataCashSuma.setBackground(c_err);
				}

				if (err == true) {
					JOptionPane.showMessageDialog(null, err_desc);
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
		txt_Prenume.setBounds(448, 78, 160, 20);
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
		txt_Email.setBounds(125, 78, 160, 20);
		panel_1.add(txt_Email);
		txt_Email.setColumns(10);

		txt_Telefon = new JTextField();
		txt_Telefon.setFont(new Font("Consolas", Font.PLAIN, 13));
		txt_Telefon.setBounds(709, 60, 225, 20);
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
		dateTime_DataZbor.setText(rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
		dateTime_DataZbor.setEditable(false);
		txtOrarZbor.setText(cursaZbor.getOraPlecare() + " - " + cursaZbor.getOraSosire());
		txtOrarZbor.setEditable(false);
		txt_NrBilete.setText("" + rezervare.getNrBilete());
		txt_NrBilete.setEditable(false);
		txt_Pret.setText(Float. toString(pret));
		txt_Pret.setEditable(false);
		textTipBilet.setText(rezervare.getTipLoc());
		textTipBilet.setEditable(false);
		textClasaBilete.setText(rezervare.getClasa());
		textClasaBilete.setEditable(false);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				RezervareZborFrame rezervareZbor = new RezervareZborFrame(staffOnly);
				rezervareZbor.setVisible(true);;
			}
		});
	}

//verifica daca numele pasagerului este valid (fiecare cuvant din nume, fara spatii)
	protected boolean numeValid(String nume) {
		if (nume == null || nume.length() == 0)
			return false;

		for (int i = 0; i < nume.length(); i++) {
			if (i == 0 && (nume.charAt(i) < 'A' || nume.charAt(i) > 'Z'))
				return false;
			if (i != 0 && (nume.charAt(i) < 'a' || nume.charAt(i) > 'z'))
				return false;
		}
		return true;
	}

//verifica daca e-mail-ul dat este valid
	protected boolean emailValid(String email) {
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
	protected boolean CVCValid(String CVC) {
		if (CVC == null || CVC.length() != 3)
			return false;
		for (int i = 0; i < CVC.length(); i++) {
			if (CVC.charAt(i) < '0' || CVC.charAt(i) > '9')
				return false;
		}

		return true;
	}

//verifica daca este valid numarul cardului dat
	protected boolean nrCardContValid(String nr, boolean card) {
		boolean err = false;

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
					err = true;
				if (nr.charAt(i) > '9' && nr.charAt(i) < 'A')
					err = true;
				if (nr.charAt(i) > 'Z')
					err = true;

			}

			// more checks should be implemented here (realistically)
		}
		return !err;
	}

//verifica daca nu este expirat cardul dat
	protected boolean dataExpirareValida(int[] dataExpirare) {
		if (dataExpirare == null)
			return false;

		if (dataExpirare[0] <= 0 || dataExpirare[0] > 31)
			return false;
		if (dataExpirare[1] <= 0 || dataExpirare[1] > 12)
			return false;
		if (dataExpirare[2] < 2020)
			return false;

		Calendar aux = Calendar.getInstance();

		if (dataExpirare[2] < aux.get(Calendar.YEAR))
			return false;
		else if (dataExpirare[2] == aux.get(Calendar.YEAR) && dataExpirare[1] < aux.get(Calendar.MONTH) + 1)
			return false;
		else if (dataExpirare[2] == aux.get(Calendar.YEAR) && dataExpirare[1] == (aux.get(Calendar.MONTH) + 1)
				&& dataExpirare[0] < aux.get(Calendar.DAY_OF_MONTH))
			return false;

		return true;
	}

//verifica daca suma inregistrata este valida
	protected boolean sumaCashValida(String suma) {
		boolean dot = false;
		double d_suma;
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
		d_suma = Double.parseDouble(suma);

		return true;
	}

//verifica daca numarul de telefon dat este valid
	protected boolean nrTelValid(String tel) {
		if (tel == null || tel.length() != 10)
			return false;

		for (int i = 0; i < tel.length(); i++) {
			if (tel.charAt(i) < '0' || tel.charAt(i) > '9')
				return false;
		}

		return true;
	}
}