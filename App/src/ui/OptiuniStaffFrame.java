package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class OptiuniStaffFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { OptiuniStaffFrame frame = new
	 * OptiuniStaffFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public OptiuniStaffFrame(boolean staffOnly) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Optiuni disponibile");
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIntroducere = new JButton("Introducere curse");
		btnIntroducere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroducereZborFrame form_introducere = new IntroducereZborFrame(staffOnly);
				form_introducere.setVisible(true);
				setVisible(false);
			}
		});
		btnIntroducere.setOpaque(true);
		btnIntroducere.setForeground(Color.WHITE);
		btnIntroducere.setFont(new Font("Consolas", Font.PLAIN, 30));
		btnIntroducere.setBackground(new Color(55, 71, 133));
		btnIntroducere.setBounds(278, 41, 400, 125);
		btnIntroducere.setOpaque(true);
		// Round the button with radius = 30
		btnIntroducere.setBorder(new RoundButton(30));

		btnIntroducere.setUI(new ButtonFill());
		contentPane.add(btnIntroducere);

		JButton btnActualizareZbor = new JButton("Actualizare zbor");
		btnActualizareZbor.setOpaque(true);
		btnActualizareZbor.setForeground(Color.WHITE);
		btnActualizareZbor.setFont(new Font("Consolas", Font.PLAIN, 30));
		btnActualizareZbor.setBackground(new Color(55, 71, 133));
		btnActualizareZbor.setBounds(278, 219, 400, 125);
		btnActualizareZbor.setOpaque(true);
		// Round the button with radius = 30
		btnActualizareZbor.setBorder(new RoundButton(30));
		btnActualizareZbor.setUI(new ButtonFill());
		
		btnActualizareZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizareZborFrame form_actualizare = new ActualizareZborFrame(staffOnly);
				form_actualizare.setVisible(true);
				setVisible(false);
			}
		});
		
		contentPane.add(btnActualizareZbor);
		
		JButton btnCautareZbor = new JButton("Cautare Zbor");
		btnCautareZbor.setOpaque(true);
		btnCautareZbor.setForeground(Color.WHITE);
		btnCautareZbor.setFont(new Font("Consolas", Font.PLAIN, 30));
		btnCautareZbor.setBackground(new Color(55, 71, 133));
		btnCautareZbor.setBounds(278, 394, 400, 125);
		btnCautareZbor.setBorder(new RoundButton(30));
		btnCautareZbor.setUI(new ButtonFill());
		
		btnCautareZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RezervareZborFrame rezervareZbor = new RezervareZborFrame(staffOnly);
				rezervareZbor.setVisible(true);
			}
		});
		
		contentPane.add(btnCautareZbor);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				MainFrame mainFrame = new MainFrame(staffOnly);
				mainFrame.setVisible(true);
			}
		});
	}
}
