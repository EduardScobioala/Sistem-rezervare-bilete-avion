package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import functionalities.CalendarWindow;
import functionalities.CursaZbor;
import functionalities.ManagementCurseZbor;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;

public class IntroducereZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAeroportPlecare;
	private JTextField txtAeroportSosire;
	private JTextField txtOraPlecare;
	private JTextField txtOraSosire;
	private JTextField textCodCursa;
	private JTextField textTipAvion;
	JCheckBox chboxLuni, chboxMarti, chboxMiercuri, chboxJoi, chboxVineri, chboxSambata, chboxDuminica;
	JSpinner spinnerEconomy, spinnerBusiness, spinnerPremium;
	JSpinner spinnerPretEconomy, spinnerPretBusiness, spinnerPretPremium;
	ManagementCurseZbor introducereZbor;
	int[] zileOperare, locuriDisponibile, locuriRezervate = new int[]{0, 0, 0};
	float[] pretClase;
	private JTextField txtNumeCompanie;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IntroducereZbor frame = new IntroducereZbor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public IntroducereZborFrame(boolean staffOnly) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Introducere zbor");
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeCompanie = new JLabel("Nume Companie:");
		lblNumeCompanie.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNumeCompanie.setBounds(200, 20, 160, 25);
		contentPane.add(lblNumeCompanie);
		
		txtNumeCompanie = new JTextField();
		txtNumeCompanie.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtNumeCompanie.setColumns(10);
		txtNumeCompanie.setBounds(390, 20, 369, 25);
		contentPane.add(txtNumeCompanie);
		
		JLabel lblAeroportPlecare = new JLabel("Aeroport de plecare:");
		lblAeroportPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblAeroportPlecare.setBounds(70, 70, 228, 25);
		contentPane.add(lblAeroportPlecare);

		JLabel lblAeroportSosire = new JLabel("Aeroport de sosire:");
		lblAeroportSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblAeroportSosire.setBounds(70, 120, 228, 25);
		contentPane.add(lblAeroportSosire);

		JLabel lblZileDeOperare = new JLabel("Zile de operare:");
		lblZileDeOperare.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblZileDeOperare.setBounds(70, 170, 178, 25);
		contentPane.add(lblZileDeOperare);

		JLabel lblNumarLocuri = new JLabel("Num\u0103r de locuri:");
		lblNumarLocuri.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNumarLocuri.setBounds(70, 210, 200, 25);
		contentPane.add(lblNumarLocuri);

		JLabel lblPret = new JLabel("Pre\u021B -");
		lblPret.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblPret.setBounds(150, 300, 80, 25);
		contentPane.add(lblPret);

		JLabel lblOraPlecare = new JLabel("Ora de plecare:");
		lblOraPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblOraPlecare.setBounds(532, 70, 170, 25);
		contentPane.add(lblOraPlecare);

		JLabel lblOraSosire = new JLabel("Ora de sosire:");
		lblOraSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblOraSosire.setBounds(532, 120, 170, 25);
		contentPane.add(lblOraSosire);

		JCheckBox chckbxDiscountDusIntors = new JCheckBox("Discount dus-\u00EEntors");
		chckbxDiscountDusIntors.setFont(new Font("Consolas", Font.PLAIN, 20));
		chckbxDiscountDusIntors.setBackground(new Color(168, 208, 224));
		chckbxDiscountDusIntors.setBounds(200, 420, 234, 25);
		contentPane.add(chckbxDiscountDusIntors);

		JCheckBox chckbxDiscountLastMinute = new JCheckBox("Discount last-minute");
		chckbxDiscountLastMinute.setFont(new Font("Consolas", Font.PLAIN, 20));
		chckbxDiscountLastMinute.setBackground(new Color(168, 208, 224));
		chckbxDiscountLastMinute.setBounds(523, 420, 254, 25);
		contentPane.add(chckbxDiscountLastMinute);

		txtAeroportPlecare = new JTextField();
		txtAeroportPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtAeroportPlecare.setBounds(308, 70, 195, 25);
		contentPane.add(txtAeroportPlecare);
		txtAeroportPlecare.setColumns(10);

		txtAeroportSosire = new JTextField();
		txtAeroportSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtAeroportSosire.setBounds(308, 120, 195, 25);
		contentPane.add(txtAeroportSosire);
		txtAeroportSosire.setColumns(10);

		try {
			txtOraPlecare = new JFormattedTextField(new MaskFormatter ("##:##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtOraPlecare.setHorizontalAlignment(JTextField.CENTER);
		txtOraPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOraPlecare.setToolTipText("Introduce\u021Bi ora de forma \"hh:mm\"");
		txtOraPlecare.setBounds(712, 70, 195, 25);
		contentPane.add(txtOraPlecare);
		txtOraPlecare.setColumns(10);

		try {
			txtOraSosire = new JFormattedTextField(new MaskFormatter ("##:##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtOraSosire.setHorizontalAlignment(JTextField.CENTER);
		txtOraSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOraSosire.setToolTipText("Introduce\u021Bi ora de forma \"hh:mm\"");
		txtOraSosire.setBounds(712, 120, 195, 25);
		contentPane.add(txtOraSosire);
		txtOraSosire.setColumns(10);
		
		chboxLuni = new JCheckBox("Lu");
		chboxLuni.setBounds(308, 170, 50, 23);
		contentPane.add(chboxLuni);
		
		chboxMarti = new JCheckBox("Ma");
		chboxMarti.setBounds(408, 170, 50, 23);
		contentPane.add(chboxMarti);
		
		chboxMiercuri = new JCheckBox("Me");
		chboxMiercuri.setBounds(508, 170, 50, 23);
		contentPane.add(chboxMiercuri);
		
		chboxJoi = new JCheckBox("J");
		chboxJoi.setBounds(608, 170, 50, 23);
		contentPane.add(chboxJoi);
		
		chboxVineri = new JCheckBox("V");
		chboxVineri.setBounds(708, 170, 50, 23);
		contentPane.add(chboxVineri);
		
		chboxSambata = new JCheckBox("S");
		chboxSambata.setBounds(808, 170, 50, 23);
		contentPane.add(chboxSambata);
		
		chboxDuminica = new JCheckBox("D");
		chboxDuminica.setBounds(908, 170, 50, 23);
		contentPane.add(chboxDuminica);
		
		JLabel lblCodCursa = new JLabel("Cod Cursa:");
		lblCodCursa.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblCodCursa.setBounds(70, 360, 135, 25);
		contentPane.add(lblCodCursa);
		
		JLabel lblTipAvion = new JLabel("Tip Avion:");
		lblTipAvion.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblTipAvion.setBounds(509, 360, 135, 25);
		contentPane.add(lblTipAvion);
		
		textCodCursa = new JTextField();
		textCodCursa.setFont(new Font("Consolas", Font.PLAIN, 20));
		textCodCursa.setColumns(10);
		textCodCursa.setBounds(203, 360, 270, 25);
		contentPane.add(textCodCursa);
		
		textTipAvion = new JTextField();
		textTipAvion.setFont(new Font("Consolas", Font.PLAIN, 20));
		textTipAvion.setColumns(10);
		textTipAvion.setBounds(637, 360, 270, 25);
		contentPane.add(textTipAvion);
		
		JLabel lblEconom = new JLabel("Econom -");
		lblEconom.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblEconom.setBounds(150, 250, 100, 25);
		contentPane.add(lblEconom);
		
		spinnerEconomy = new JSpinner();
		spinnerEconomy.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		spinnerEconomy.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerEconomy.setBounds(260, 250, 100, 25);
		contentPane.add(spinnerEconomy);
		
		JLabel lblBusiness = new JLabel("Business -");
		lblBusiness.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblBusiness.setBounds(423, 250, 110, 25);
		contentPane.add(lblBusiness);
		
		spinnerBusiness = new JSpinner();
		spinnerBusiness.setModel(new SpinnerNumberModel(0, 0, 30, 1));
		spinnerBusiness.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerBusiness.setBounds(542, 250, 100, 25);
		contentPane.add(spinnerBusiness);
		
		JLabel lblPremium = new JLabel("Premium -");
		lblPremium.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblPremium.setBounds(697, 250, 100, 25);
		contentPane.add(lblPremium);
		
		spinnerPremium = new JSpinner();
		spinnerPremium.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinnerPremium.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerPremium.setBounds(807, 250, 100, 25);
		contentPane.add(spinnerPremium);
		
		spinnerPretEconomy = new JSpinner();
		spinnerPretEconomy.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinnerPretEconomy.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerPretEconomy.setBounds(260, 300, 100, 25);
		contentPane.add(spinnerPretEconomy);
		
		JLabel lblPret_1 = new JLabel("Pre\u021B -");
		lblPret_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblPret_1.setBounds(697, 300, 80, 25);
		contentPane.add(lblPret_1);
		
		spinnerPretPremium = new JSpinner();
		spinnerPretPremium.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinnerPretPremium.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerPretPremium.setBounds(807, 300, 100, 25);
		contentPane.add(spinnerPretPremium);
		
		spinnerPretBusiness = new JSpinner();
		spinnerPretBusiness.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinnerPretBusiness.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerPretBusiness.setBounds(542, 300, 100, 25);
		contentPane.add(spinnerPretBusiness);
		
		JLabel lblPret_2 = new JLabel("Pre\u021B -");
		lblPret_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblPret_2.setBounds(423, 300, 80, 25);
		contentPane.add(lblPret_2);
		
		JButton btnIntroducereZbor = new JButton("Introducere zbor");
		btnIntroducereZbor.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnIntroducereZbor.setForeground(Color.WHITE);
		btnIntroducereZbor.setBackground(new Color(55, 71, 133));
		btnIntroducereZbor.setOpaque(true);
		btnIntroducereZbor.setBounds(357, 475, 287, 56);
		// Round the button with radius = 30
		btnIntroducereZbor.setBorder(new RoundButton(30));
		btnIntroducereZbor.setUI(new ButtonFill());
		
		btnIntroducereZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zileOperare = getZileOperare();
				pretClase = getPretClase();
				locuriDisponibile = getLocuriDisponibile();
				
				introducereZbor = new ManagementCurseZbor(txtNumeCompanie.getText(), txtAeroportPlecare.getText(), txtAeroportSosire.getText(), txtOraPlecare.getText(),
						txtOraSosire.getText(), zileOperare, pretClase, locuriDisponibile, locuriRezervate, textCodCursa.getText(), textTipAvion.getText(),
						chckbxDiscountDusIntors.isSelected(), chckbxDiscountLastMinute.isSelected());
				
				try {
					introducereZbor.saveCursaZbor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				// cursa adaugata, reintoarcere pe pagina anterioara
				dispose();
				OptiuniStaffFrame optiuni_staff = new OptiuniStaffFrame(staffOnly);
				optiuni_staff.setVisible(true);
			}
		});
		
		contentPane.add(btnIntroducereZbor);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				OptiuniStaffFrame optiuni_staff = new OptiuniStaffFrame(staffOnly);
				optiuni_staff.setVisible(true);
			}
		});
	}
	
	private int[] getZileOperare() {
		int[] zileOperare = new int[7];
		
		zileOperare[0] = chboxLuni.isSelected() ? 1 : 0;
		zileOperare[1] = chboxMarti.isSelected() ? 1 : 0;
		zileOperare[2] = chboxMiercuri.isSelected() ? 1 : 0;
		zileOperare[3] = chboxJoi.isSelected() ? 1 : 0;
		zileOperare[4] = chboxVineri.isSelected() ? 1 : 0;
		zileOperare[5] = chboxSambata.isSelected() ? 1 : 0;
		zileOperare[6] = chboxDuminica.isSelected() ? 1 : 0;
		
		return zileOperare;
	}
	
	private float[] getPretClase() {
		float[] pretClase = new float[3];
		
		pretClase[0] = (float) spinnerPretEconomy.getValue();
		pretClase[1] = (float) spinnerPretBusiness.getValue();
		pretClase[2] = (float) spinnerPretPremium.getValue();
		
		return pretClase;
	}
	
	private int[] getLocuriDisponibile() {
		int[] locuriDisponibile = new int[3];
		
		locuriDisponibile[0] = (int) spinnerEconomy.getValue();
		locuriDisponibile[1] = (int) spinnerBusiness.getValue();
		locuriDisponibile[2] = (int) spinnerPremium.getValue();
		
		return locuriDisponibile;
	}
}
