package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Rezervare zbor");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(55, 71, 133));
		btnNewButton.setOpaque(true);
		btnNewButton.setBounds(327, 343, 176, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Buna dimineata/ziua/seara");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(269, 40, 324, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblOra = new JLabel("Ora: --/--");
		lblOra.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblOra.setBounds(352, 95, 133, 56);
		contentPane.add(lblOra);
		
		JLabel lblDataCurenta = new JLabel("Data curenta --/--/--");
		lblDataCurenta.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDataCurenta.setBounds(306, 145, 324, 56);
		contentPane.add(lblDataCurenta);
		
		JLabel lblMultumimCaAlegeti = new JLabel("Multumim ca alegeti serviciile noastre !");
		lblMultumimCaAlegeti.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMultumimCaAlegeti.setBounds(216, 212, 480, 56);
		contentPane.add(lblMultumimCaAlegeti);
		
		JLabel lblNewLabel_1 = new JLabel("Login Staff");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginStaff loginStaff = new LoginStaff();
				loginStaff.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(378, 474, 79, 14);
		contentPane.add(lblNewLabel_1);
	}
}
