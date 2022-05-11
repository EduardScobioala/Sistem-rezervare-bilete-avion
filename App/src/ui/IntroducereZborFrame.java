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
		setBounds(100, 100, 350, 454);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aeroport de plecare:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 11, 136, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aeroport de sosire:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(10, 36, 136, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data plec\u0103rii:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(10, 61, 136, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Num\u0103r zbor:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(10, 86, 136, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Num\u0103r de locuri:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(10, 111, 136, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Clasa:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setBounds(10, 136, 136, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pre\u021B:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setBounds(10, 161, 136, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ora de plecare:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setBounds(10, 186, 136, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ora de sosire:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8.setBounds(10, 211, 136, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Traseu complet:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setBounds(10, 236, 136, 14);
		contentPane.add(lblNewLabel_9);
		
		JCheckBox chckbxDiscountDusIntors = new JCheckBox("Discount dus-\u00EEntors");
		chckbxDiscountDusIntors.setBackground(new Color(168, 208, 224));
		chckbxDiscountDusIntors.setBounds(10, 276, 148, 23);
		contentPane.add(chckbxDiscountDusIntors);
		
		JCheckBox chckbxDiscountLastMinute = new JCheckBox("Discount last-minute");
		chckbxDiscountLastMinute.setBackground(new Color(168, 208, 224));
		chckbxDiscountLastMinute.setBounds(160, 276, 148, 23);
		contentPane.add(chckbxDiscountLastMinute);
		
		txtAeroportPlecare = new JTextField();
		txtAeroportPlecare.setBounds(156, 8, 152, 20);
		contentPane.add(txtAeroportPlecare);
		txtAeroportPlecare.setColumns(10);
		
		txtAeroportSosire = new JTextField();
		txtAeroportSosire.setBounds(156, 33, 152, 20);
		contentPane.add(txtAeroportSosire);
		txtAeroportSosire.setColumns(10);
		
		txtDataPlecarii = new JTextField();
		txtDataPlecarii.setToolTipText("Introduce\u021Bi data de forma \"zz.ll.aaaa\"");
		txtDataPlecarii.setBounds(156, 58, 86, 20);
		contentPane.add(txtDataPlecarii);
		txtDataPlecarii.setColumns(10);
		
		txtNumarZbor = new JTextField();
		txtNumarZbor.setBounds(156, 83, 86, 20);
		contentPane.add(txtNumarZbor);
		txtNumarZbor.setColumns(10);
		
		JSpinner spinnerNrLocuri = new JSpinner();
		spinnerNrLocuri.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerNrLocuri.setBounds(156, 108, 61, 20);
		contentPane.add(spinnerNrLocuri);
		
		txtClasa = new JTextField();
		txtClasa.setBounds(156, 133, 61, 20);
		contentPane.add(txtClasa);
		txtClasa.setColumns(10);
		
		txtOraPlecare = new JTextField();
		txtOraPlecare.setToolTipText("Introduce\u021Bi ora de forma \"hh:mm\"");
		txtOraPlecare.setBounds(156, 183, 86, 20);
		contentPane.add(txtOraPlecare);
		txtOraPlecare.setColumns(10);
		
		txtOraSosire = new JTextField();
		txtOraSosire.setToolTipText("Introduce\u021Bi ora de forma \"hh:mm\"");
		txtOraSosire.setBounds(156, 208, 86, 20);
		contentPane.add(txtOraSosire);
		txtOraSosire.setColumns(10);
		
		txtPret = new JTextField();
		txtPret.setBounds(156, 158, 86, 20);
		contentPane.add(txtPret);
		txtPret.setColumns(10);
		
		txtTraseuComplet = new JTextField();
		txtTraseuComplet.setBounds(156, 233, 152, 20);
		contentPane.add(txtTraseuComplet);
		txtTraseuComplet.setColumns(10);
		
		JButton btnIntroducereZbor = new JButton("Introducere zbor");
		btnIntroducereZbor.setForeground(new Color(0, 0, 0));
		btnIntroducereZbor.setBackground(new Color(55, 71, 133));
		btnIntroducereZbor.setOpaque(true);
		btnIntroducereZbor.setBounds(79, 338, 176, 56);
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