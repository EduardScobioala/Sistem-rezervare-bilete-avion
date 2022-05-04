package main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import java.awt.SystemColor;

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
		
		JButton btnRezervare = new JButton("Rezervare zbor");
		btnRezervare.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnRezervare.setForeground(new Color(0, 0, 0));
		btnRezervare.setBounds(306, 343, 231, 56);
		btnRezervare.setBackground(new Color(55, 71, 133));
		btnRezervare.setOpaque(true);
		//Round the button with radius = 30
		btnRezervare.setBorder(new RoundButton(30));

		btnRezervare.setUI(new ButtonFill());
		contentPane.add(btnRezervare);
		
		JLabel lblNewLabel = new JLabel("Buna dimineata/ziua/seara");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblNewLabel.setBounds(269, 40, 324, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblOra = new JLabel("Ora: --/--");
		lblOra.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblOra.setBounds(359, 102, 133, 56);
		contentPane.add(lblOra);
		
		JLabel lblDataCurenta = new JLabel("Data curenta --/--/--");
		lblDataCurenta.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblDataCurenta.setBounds(306, 145, 324, 56);
		contentPane.add(lblDataCurenta);
		
		JLabel lblMultumimCaAlegeti = new JLabel("Multumim ca alegeti serviciile noastre !");
		lblMultumimCaAlegeti.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblMultumimCaAlegeti.setBounds(216, 212, 480, 56);
		contentPane.add(lblMultumimCaAlegeti);
		
		JLabel lblNewLabel_1 = new JLabel("<HTML><U>Login Staff</U></HTML>");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginStaff loginStaff = new LoginStaff();
				loginStaff.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(378, 474, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnHelp = new JButton("?");
		btnHelp.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnHelp.setBackground(new Color(55, 71, 133));
		btnHelp.setBounds(814, 445, 43, 43);
		btnHelp.setBorder(new RoundButton(30));
		btnHelp.setUI(new ButtonFill());
		contentPane.add(btnHelp);
	}
}
