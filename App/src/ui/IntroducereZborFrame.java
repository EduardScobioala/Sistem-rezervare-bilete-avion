package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class IntroducereZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAeroportPlecare;
	private JTextField txtAeroportSosire;
	private JTextField txtDataPlecarii;
	private JTextField txtNumarZbor;
	private JTextField txtClasa;
	private JTextField txtOraPlecare;
	private JTextField txtOraSosire;
	private JTextField txtPret;
	private JTextField txtTraseuComplet;

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
	public IntroducereZborFrame() {
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
		
		JLabel lblNewLabel = new JLabel("Aeroport de plecare:");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel.setBounds(120, 35, 228, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aeroport de sosire:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(120, 80, 228, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data plec\u0103rii:");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(120, 125, 228, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Num\u0103r zbor:");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(120, 170, 228, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Num\u0103r de locuri:");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(120, 215, 228, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Clasa:");
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(120, 260, 228, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pre\u021B:");
		lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(120, 305, 228, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ora de plecare:");
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(120, 350, 228, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ora de sosire:");
		lblNewLabel_8.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(120, 395, 228, 25);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Traseu complet:");
		lblNewLabel_9.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(120, 440, 228, 25);
		contentPane.add(lblNewLabel_9);
		
		JCheckBox chckbxDiscountDusIntors = new JCheckBox("Discount dus-\u00EEntors");
		chckbxDiscountDusIntors.setFont(new Font("Consolas", Font.PLAIN, 20));
		chckbxDiscountDusIntors.setBackground(new Color(168, 208, 224));
		chckbxDiscountDusIntors.setBounds(120, 490, 234, 25);
		contentPane.add(chckbxDiscountDusIntors);
		
		JCheckBox chckbxDiscountLastMinute = new JCheckBox("Discount last-minute");
		chckbxDiscountLastMinute.setFont(new Font("Consolas", Font.PLAIN, 20));
		chckbxDiscountLastMinute.setBackground(new Color(168, 208, 224));
		chckbxDiscountLastMinute.setBounds(375, 490, 254, 25);
		contentPane.add(chckbxDiscountLastMinute);
		
		txtAeroportPlecare = new JTextField();
		txtAeroportPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtAeroportPlecare.setBounds(433, 35, 390, 25);
		contentPane.add(txtAeroportPlecare);
		txtAeroportPlecare.setColumns(10);
		
		txtAeroportSosire = new JTextField();
		txtAeroportSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtAeroportSosire.setBounds(433, 79, 390, 25);
		contentPane.add(txtAeroportSosire);
		txtAeroportSosire.setColumns(10);
		
		txtDataPlecarii = new JTextField();
		txtDataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtDataPlecarii.setToolTipText("Introduce\u021Bi data de forma \"zz.ll.aaaa\"");
		txtDataPlecarii.setBounds(433, 124, 390, 25);
		contentPane.add(txtDataPlecarii);
		txtDataPlecarii.setColumns(10);
		
		txtNumarZbor = new JTextField();
		txtNumarZbor.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtNumarZbor.setBounds(433, 169, 390, 25);
		contentPane.add(txtNumarZbor);
		txtNumarZbor.setColumns(10);
		
		JSpinner spinnerNrLocuri = new JSpinner();
		spinnerNrLocuri.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerNrLocuri.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerNrLocuri.setBounds(433, 214, 390, 25);
		contentPane.add(spinnerNrLocuri);
		
		txtClasa = new JTextField();
		txtClasa.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtClasa.setBounds(433, 259, 390, 25);
		contentPane.add(txtClasa);
		txtClasa.setColumns(10);
		
		txtOraPlecare = new JTextField();
		txtOraPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOraPlecare.setToolTipText("Introduce\u021Bi ora de forma \"hh:mm\"");
		txtOraPlecare.setBounds(433, 349, 390, 25);
		contentPane.add(txtOraPlecare);
		txtOraPlecare.setColumns(10);
		
		txtOraSosire = new JTextField();
		txtOraSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOraSosire.setToolTipText("Introduce\u021Bi ora de forma \"hh:mm\"");
		txtOraSosire.setBounds(433, 394, 390, 25);
		contentPane.add(txtOraSosire);
		txtOraSosire.setColumns(10);
		
		txtPret = new JTextField();
		txtPret.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtPret.setBounds(433, 304, 390, 25);
		contentPane.add(txtPret);
		txtPret.setColumns(10);
		
		txtTraseuComplet = new JTextField();
		txtTraseuComplet.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtTraseuComplet.setBounds(433, 439, 390, 25);
		contentPane.add(txtTraseuComplet);
		txtTraseuComplet.setColumns(10);
		
		JButton btnIntroducereZbor = new JButton("Introducere zbor");
		btnIntroducereZbor.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnIntroducereZbor.setForeground(Color.WHITE);
		btnIntroducereZbor.setBackground(new Color(55, 71, 133));
		btnIntroducereZbor.setOpaque(true);
		btnIntroducereZbor.setBounds(672, 494, 287, 56);
		//Round the button with radius = 30
		btnIntroducereZbor.setBorder(new RoundButton(30));

		btnIntroducereZbor.setUI(new ButtonFill());
		contentPane.add(btnIntroducereZbor);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				OptiuniStaffFrame optiuni_staff = new OptiuniStaffFrame();
				optiuni_staff.setVisible(true);
			}
		});
	}
}