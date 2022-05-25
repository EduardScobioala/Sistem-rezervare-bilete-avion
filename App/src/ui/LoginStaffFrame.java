package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.Login;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class LoginStaffFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;

	public LoginStaffFrame(boolean staffOnly) {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
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

		textUsername = new JTextField();
		textUsername.setFont(new Font("Consolas", Font.PLAIN, 20));
		textUsername.setBounds(213, 59, 277, 30);
		contentPane.add(textUsername);
		textUsername.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Consolas", Font.PLAIN, 20));
		passwordField.setBounds(213, 116, 277, 30);
		contentPane.add(passwordField);

		JLabel lblLoginFailed = new JLabel("");
		lblLoginFailed.setForeground(new Color(255, 0, 0));
		lblLoginFailed.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblLoginFailed.setBounds(427, 208, 130, 14);
		contentPane.add(lblLoginFailed);

		JButton btnLogin = new JButton("Logare");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Logare functionar companie
				if (textUsername.getText().equals("godMode") && new String(passwordField.getPassword()).equals("godMode")) {
					lblLoginFailed.setText("");
					dispose();
					OptiuniStaffFrame optiuniStaff = new OptiuniStaffFrame(staffOnly);
					optiuniStaff.setVisible(true);
				} // Logare staff aeroport prin tryLogin al obiectului de tip Login
				else if (new Login(textUsername.getText(), String.valueOf(passwordField.getPassword())).tryLogin()) {
					lblLoginFailed.setText("");
					dispose();
					RezervareZborFrame rezervareZbor = new RezervareZborFrame(true);
					rezervareZbor.setVisible(true);
				}
				else {
					lblLoginFailed.setText("Wrong credentials!");
				}
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
				MainFrame mainFrame = new MainFrame(false);
				mainFrame.setVisible(true);
			}
		});
	}
}
