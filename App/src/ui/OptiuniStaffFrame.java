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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptiuniStaffFrame frame = new OptiuniStaffFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OptiuniStaffFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Optiuni disponibile");
		setResizable(false);
		setBounds(100, 100, 360, 240);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIntroducere = new JButton("Introducere curse");
		btnIntroducere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroducereZborFrame form_introducere = new IntroducereZborFrame();
				form_introducere.setVisible(true);
				setVisible(false);
			}
		});
		btnIntroducere.setOpaque(true);
		btnIntroducere.setForeground(Color.WHITE);
		btnIntroducere.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIntroducere.setBackground(new Color(55, 71, 133));
		btnIntroducere.setBounds(90, 30, 170, 45);
		contentPane.add(btnIntroducere);
		
		JButton btnActualizareZbor = new JButton("Actualizare zbor");
		btnActualizareZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizareZborFrame form_actualizare = new ActualizareZborFrame();
				form_actualizare.setVisible(true);
				setVisible(false);
			}
		});
		btnActualizareZbor.setOpaque(true);
		btnActualizareZbor.setForeground(Color.WHITE);
		btnActualizareZbor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizareZbor.setBackground(new Color(55, 71, 133));
		btnActualizareZbor.setBounds(90, 124, 170, 45);
		contentPane.add(btnActualizareZbor);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}
		});
	}

}
