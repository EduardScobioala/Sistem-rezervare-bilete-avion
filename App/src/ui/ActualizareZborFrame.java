package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.CursaZbor;
import functionalities.ManagementCurseZbor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActualizareZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodCursa;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ActualizareZborFrame frame = new
	 * ActualizareZborFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ActualizareZborFrame(boolean staffOnly) {
		setTitle("Actualizare zbor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNrZbor = new JLabel("Cod Cursa:");
		lblNrZbor.setFont(new Font("Consolas", Font.PLAIN, 40));
		lblNrZbor.setBounds(356, 93, 262, 50);
		contentPane.add(lblNrZbor);

		txtCodCursa = new JTextField();
		txtCodCursa.setHorizontalAlignment(JTextField.CENTER);
		txtCodCursa.setFont(new Font("Consolas", Font.PLAIN, 40));
		txtCodCursa.setBounds(168, 197, 630, 60);
		contentPane.add(txtCodCursa);
		txtCodCursa.setColumns(10);

		JButton btnActualizare = new JButton("Actualizare");
		btnActualizare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementCurseZbor manager = new ManagementCurseZbor();
				
				CursaZbor cursa = manager.findCursa(txtCodCursa.getText());
				
				if (cursa != null) {
					dispose();
					EditareCursaFrame editareCursa = new EditareCursaFrame(cursa, staffOnly);
					editareCursa.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Codul de Cursa nu a fost gasit!");
				}
			}
		});
		btnActualizare.setOpaque(true);
		btnActualizare.setForeground(Color.WHITE);
		btnActualizare.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnActualizare.setBorder(new RoundButton(30));
		btnActualizare.setUI(new ButtonFill());
		btnActualizare.setBackground(new Color(55, 71, 133));
		btnActualizare.setBounds(278, 378, 400, 100);
		contentPane.add(btnActualizare);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				OptiuniStaffFrame optiuni_staff = new OptiuniStaffFrame(staffOnly);
				optiuni_staff.setVisible(true);
			}
		});
	}
}
