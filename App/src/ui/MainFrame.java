package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(false);
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
	public MainFrame(boolean staffOnly) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRezervare = new JButton("Rezervare zbor");
		btnRezervare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RezervareZborFrame rezervareZbor = new RezervareZborFrame(false);
				rezervareZbor.setVisible(true);
			}
		});
		btnRezervare.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnRezervare.setForeground(Color.WHITE);
		btnRezervare.setBounds(364, 380, 246, 66);
		btnRezervare.setBackground(new Color(55, 71, 133));
		btnRezervare.setOpaque(true);
		// Round the button with radius = 30
		btnRezervare.setBorder(new RoundButton(30));

		btnRezervare.setUI(new ButtonFill());
		contentPane.add(btnRezervare);

		JLabel lblSalutare = new JLabel();
		lblSalutare.setForeground(Color.DARK_GRAY);
		lblSalutare.setText("Buna ...");
		lblSalutare.setFont(new Font("Consolas", Font.PLAIN, 30));
		lblSalutare.setBounds(318, 50, 324, 56);

		String lblText = "Buna ";
		DateTimeFormatter oraFormatter = DateTimeFormatter.ofPattern("hh a");
		String rawOra = oraFormatter.format(LocalDateTime.now());
		String[] dataOra = rawOra.split(" ");

		if (dataOra[1].equals("AM")) {
			if (Integer.parseInt(dataOra[0]) < 10)
				lblText += "dimineata";
			else
				lblText += "ziua";
		} else {
			if (Integer.parseInt(dataOra[0]) < 18)
				lblText += "ziua";
			else
				lblText += "seara";
		}

		lblSalutare.setText(lblText);
		lblSalutare.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblSalutare);

		JLabel lblOra = new JLabel("Ora: --/--");
		lblOra.setForeground(Color.WHITE);
		lblOra.setFont(new Font("Consolas", Font.PLAIN, 30));
		lblOra.setBounds(383, 161, 318, 56);

		//
		Timer t = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter oraFormatter = DateTimeFormatter.ofPattern("hh:mm:ss", new Locale("ro", "RO"));
				String ora = oraFormatter.format(LocalDateTime.now());
				lblOra.setText("Ora: " + ora);
			}
		});
		t.setRepeats(true);
		t.setCoalesce(true);
		t.setInitialDelay(0);
		t.start();

		contentPane.add(lblOra);

		JLabel lblDataCurenta = new JLabel("Data curenta: --/--/--");
		lblDataCurenta.setForeground(Color.WHITE);
		lblDataCurenta.setFont(new Font("Consolas", Font.PLAIN, 30));
		lblDataCurenta.setBounds(282, 117, 470, 56);

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd MMMM uuuu", new Locale("ro", "RO"));
		String data = dataFormatter.format(now);

		lblDataCurenta.setText("Data curenta: " + data);
		contentPane.add(lblDataCurenta);

		JLabel lblMultumimCaAlegeti = new JLabel("Multumim ca alegeti serviciile noastre !");
		lblMultumimCaAlegeti.setForeground(Color.DARK_GRAY);
		lblMultumimCaAlegeti.setFont(new Font("Consolas", Font.PLAIN, 30));
		lblMultumimCaAlegeti.setBounds(169, 251, 685, 56);
		contentPane.add(lblMultumimCaAlegeti);

		// Login button
		JLabel lblLogin = new JLabel("<HTML><U>Login Staff</U></HTML>");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginStaffFrame loginStaff = new LoginStaffFrame(false);
				loginStaff.setVisible(true);
			}
		});
		lblLogin.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblLogin.setBounds(435, 514, 109, 19);
		contentPane.add(lblLogin);

		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnHelp.setBackground(new Color(55, 71, 133));
		btnHelp.setBounds(869, 490, 89, 43);
		btnHelp.setOpaque(true);
		// Round the button with radius = 30
		btnHelp.setBorder(new RoundButton(30));

		btnHelp.setUI(new ButtonFill());
		contentPane.add(btnHelp);
	}
}
