package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginStaffFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginStaff frame = new LoginStaff();
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
	public LoginStaffFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel.setBounds(93, 59, 110, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(93, 117, 110, 29);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.PLAIN, 20));
		textField.setBounds(213, 59, 277, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		textField_1.setBounds(213, 116, 277, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnLogin = new JButton("Logare");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				OptiuniStaffFrame optiuniStaff = new OptiuniStaffFrame();
				optiuniStaff.setVisible(true);
			}
		});
		
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(55, 71, 133));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(197, 186, 168, 45);
		btnLogin.setOpaque(true);
		btnLogin.setBorder(new RoundButton(30));
		btnLogin.setUI(new ButtonFill());
		contentPane.add(btnLogin);

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