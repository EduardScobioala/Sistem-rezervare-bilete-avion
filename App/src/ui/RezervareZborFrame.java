package ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.RezervareZbor;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RezervareZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_OrasDestinatie;
	static RezervareZborFrame frame;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { frame = new RezervareZborFrame();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	private RezervareZbor rezervare = null;
	private RezervareZbor zbor = null;
	boolean plata_cash = false;
	private JTextField txt_OrasPlecare;

	// functii utilitare

	// verifica daca numele orasului este valid
	protected boolean numeOrasValid(String oras) {
		java.util.List<String> orase = new ArrayList<String>();
		BufferedReader read = null;
		boolean gasit = false;

		try {
			read = new BufferedReader(new InputStreamReader(new FileInputStream("orase.txt")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String buf;

		try {
			while ((buf = read.readLine()) != null) {
				orase.add(buf);
				if (buf.equals(oras))
					gasit = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (oras.equals(""))
			return false;

		return gasit;
	}

	// verifica daca datele de plecare (data1) si intoarcere (data2) sunt valide
	protected boolean dateValide(int[] data1, int[] data2) {

		if (data1.length != 3 || data2.length != 3)
			return false;

		if (data1[0] <= 0 || data1[0] > 31)
			return false;
		if (data1[1] <= 0 || data1[1] > 12)
			return false;
		if (data1[2] < 2022)
			return false;

		if (data2[0] <= 0 || data2[0] > 31)
			return false;
		if (data2[1] <= 0 || data2[1] > 12)
			return false;
		if (data2[2] < 2022)
			return false;

		if (data1[2] > data2[2])
			return false;
		else if (data1[2] == data2[2] && data1[1] > data2[1])
			return false;
		else if (data1[2] == data2[2] && data1[1] == data2[1] && data1[0] > data2[0])
			return false;

		// System.out.println(data1[0]+" "+data1[1]+" "+data1[2]);
		return true;
	}

	// seteaza zborul ales in variabila 'zbor' de tip RezervareZbor
	public void setZborAles(RezervareZbor zbor) {
		this.zbor = zbor;
	}

	// genereaza forma
	public RezervareZborFrame() {
		setTitle("Rezervare Zbor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_OrasPlecare = new JLabel("Ora\u0219 origine:");
		lbl_OrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_OrasPlecare.setBounds(44, 34, 139, 30);
		contentPane.add(lbl_OrasPlecare);

		JLabel lbl_OrasSosire = new JLabel("Ora\u0219 destina\u021Bie:");
		lbl_OrasSosire.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_OrasSosire.setBounds(44, 84, 172, 30);
		contentPane.add(lbl_OrasSosire);

		JLabel lbl_DataPlecarii = new JLabel("Data plec\u0103rii:");
		lbl_DataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_DataPlecarii.setBounds(44, 138, 148, 30);
		contentPane.add(lbl_DataPlecarii);

		JLabel lbl_TipLoc = new JLabel("Tip loc:");
		lbl_TipLoc.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_TipLoc.setBounds(48, 213, 96, 30);
		contentPane.add(lbl_TipLoc);

		JLabel lbl_Clasa = new JLabel("Clasa la care se dore\u0219te rezervarea:");
		lbl_Clasa.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_Clasa.setBounds(44, 338, 365, 30);
		contentPane.add(lbl_Clasa);

		JLabel lbl_DataIntoarcere = new JLabel("Data \u00EEntoarcerii:");
		lbl_DataIntoarcere.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_DataIntoarcere.setBounds(169, 268, 177, 30);
		contentPane.add(lbl_DataIntoarcere);

		txt_OrasDestinatie = new JTextField();
		txt_OrasDestinatie.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_OrasDestinatie.setColumns(10);
		txt_OrasDestinatie.setBounds(245, 84, 222, 30);
		contentPane.add(txt_OrasDestinatie);

		JSpinner dateTimeDataPlecarii = new JSpinner(new SpinnerDateModel(new Date(1651524853330L),
				new Date(1651524853330L), new Date(1967144053330L), Calendar.DAY_OF_YEAR));
		dateTimeDataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 18));
		JSpinner.DateEditor de_dateTimeDataPlecarii = new JSpinner.DateEditor(dateTimeDataPlecarii, "dd.MM.yy");
		dateTimeDataPlecarii.setEditor(de_dateTimeDataPlecarii);
		dateTimeDataPlecarii.setBounds(245, 138, 222, 30);
		contentPane.add(dateTimeDataPlecarii);

		JSpinner dateTime_DataIntoarcerii = new JSpinner(new SpinnerDateModel(new Date(1651524884913L),
				new Date(1651524884913L), new Date(1967144084913L), Calendar.DAY_OF_YEAR));
		dateTime_DataIntoarcerii.setFont(new Font("Consolas", Font.PLAIN, 18));
		JSpinner.DateEditor editor_intoarcere = new JSpinner.DateEditor(dateTime_DataIntoarcerii, "dd.MM.yy");
		dateTime_DataIntoarcerii.setEditor(editor_intoarcere);
		dateTime_DataIntoarcerii.setBounds(356, 268, 111, 30);
		contentPane.add(dateTime_DataIntoarcerii);

		JComboBox combo_TipLoc = new JComboBox();
		combo_TipLoc.setFont(new Font("Consolas", Font.PLAIN, 18));
		combo_TipLoc.setBounds(245, 213, 222, 30);
		contentPane.add(combo_TipLoc);

		JCheckBox chk_ZborRetur = new JCheckBox("Retur");
		chk_ZborRetur.setBackground(new Color(168, 208, 224));
		chk_ZborRetur.setHorizontalAlignment(SwingConstants.LEFT);
		chk_ZborRetur.setFont(new Font("Consolas", Font.PLAIN, 18));
		chk_ZborRetur.setBounds(44, 268, 100, 30);
		contentPane.add(chk_ZborRetur);

		JComboBox combo_Clasa = new JComboBox();
		combo_Clasa.setFont(new Font("Consolas", Font.PLAIN, 18));
		combo_Clasa.setBounds(245, 379, 222, 30);
		contentPane.add(combo_Clasa);

		JLabel lbl_ListaLocuri = new JLabel("List\u0103 locuri");
		lbl_ListaLocuri.setFont(new Font("Consolas", Font.PLAIN, 18));
		lbl_ListaLocuri.setBounds(692, 11, 139, 21);
		contentPane.add(lbl_ListaLocuri);

		JList lst_LocuriDisponibile = new JList();
		lst_LocuriDisponibile.setBounds(557, 40, 403, 495);
		contentPane.add(lst_LocuriDisponibile);

		JButton btn_RezervareLoc = new JButton("Rezervare loc");
		btn_RezervareLoc.setForeground(Color.WHITE);
		btn_RezervareLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst_LocuriDisponibile.getComponentCount() == 0
						|| (lst_LocuriDisponibile.getSelectedValuesList().size() != 0
								&& lst_LocuriDisponibile.getSelectedValuesList()
										.get(lst_LocuriDisponibile.getSelectedIndex() - 1).equals(""))) {
					JOptionPane.showMessageDialog(null, "AlegeČ›i un loc");
				} else if (rezervare == null) {
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				} else {
					// deschidere pagina vizualizare zbor
					// VizualizareZborFrame.main(null);

				}

			}
		});
		btn_RezervareLoc.setFont(new Font("Consolas", Font.PLAIN, 18));
		btn_RezervareLoc.setBounds(44, 481, 200, 40);
		btn_RezervareLoc.setBackground(new Color(55, 71, 133));
		btn_RezervareLoc.setOpaque(true);
		// Round the button with radius = 30
		btn_RezervareLoc.setBorder(new RoundButton(30));

		btn_RezervareLoc.setUI(new ButtonFill());
		contentPane.add(btn_RezervareLoc);

		JButton btn_CautareZbor = new JButton("Căutare zbor");
		btn_CautareZbor.setForeground(Color.WHITE);

		btn_CautareZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean err_plecare = false;
				boolean err_destinatie = false;
				boolean err_date = false;
				boolean err_retur = false;
				boolean err_tipLoc = false;
				boolean err_clasa = false;
				boolean err = false;

				Color c_err = Color.red;
				int[] data1 = new int[4];
				int[] data2 = new int[4];
				String[] buf;

				// functii de verificare
				if (!numeOrasValid(txt_OrasPlecare.getText())) {
					err = true;
					err_plecare = true;

					txt_OrasPlecare.setBackground(c_err);
				}

				if (!numeOrasValid(txt_OrasDestinatie.getText())) {
					err = true;
					err_destinatie = true;

					txt_OrasDestinatie.setBackground(c_err);
				}

				if (!dateValide(data1, data2)) {
					err = true;
					err_date = true;

					dateTimeDataPlecarii.setBackground(c_err);
					dateTime_DataIntoarcerii.setBackground(c_err);
				}

				if (combo_TipLoc.getSelectedItem() == null) {
					err = true;
					err_tipLoc = true;

					combo_TipLoc.setBackground(c_err);
				}

				if (combo_Clasa.getSelectedItem() == null) {
					err = true;
					err_clasa = true;

					combo_Clasa.setBackground(c_err);
				}

				if (!err) {

					SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy");

					// data plecare
					buf = form.format(dateTimeDataPlecarii.getValue()).split("/");
					data1[0] = Integer.parseInt(buf[2]);

					if (buf[1].equals("Jan"))
						data1[1] = 1;
					else if (buf[1].equals("Feb"))
						data1[1] = 2;
					else if (buf[1].equals("Mar"))
						data1[1] = 3;
					else if (buf[1].equals("Apr"))
						data1[1] = 4;
					else if (buf[1].equals("May"))
						data1[1] = 5;
					else if (buf[1].equals("Jun"))
						data1[1] = 6;
					else if (buf[1].equals("Jul"))
						data1[1] = 7;
					else if (buf[1].equals("Aug"))
						data1[1] = 8;
					else if (buf[1].equals("Sep"))
						data1[1] = 9;
					else if (buf[1].equals("Oct"))
						data1[1] = 10;
					else if (buf[1].equals("Nov"))
						data1[1] = 11;
					else if (buf[1].equals("Dec"))
						data1[1] = 12;

					data1[2] = Integer.parseInt(buf[5]);

					// data intoarcere
					buf = form.format(dateTime_DataIntoarcerii.getValue()).split("/");
					data2[0] = Integer.parseInt(buf[2]);

					if (buf[1].equals("Jan"))
						data2[1] = 1;
					else if (buf[1].equals("Feb"))
						data2[1] = 2;
					else if (buf[1].equals("Mar"))
						data2[1] = 3;
					else if (buf[1].equals("Apr"))
						data2[1] = 4;
					else if (buf[1].equals("May"))
						data2[1] = 5;
					else if (buf[1].equals("Jun"))
						data2[1] = 6;
					else if (buf[1].equals("Jul"))
						data2[1] = 7;
					else if (buf[1].equals("Aug"))
						data2[1] = 8;
					else if (buf[1].equals("Sep"))
						data2[1] = 9;
					else if (buf[1].equals("Oct"))
						data2[1] = 10;
					else if (buf[1].equals("Nov"))
						data2[1] = 11;
					else if (buf[1].equals("Dec"))
						data2[1] = 12;

					data2[2] = Integer.parseInt(buf[5]);

					rezervare = new RezervareZbor(txt_OrasPlecare.getText(), txt_OrasDestinatie.getText(),
							combo_TipLoc.getSelectedItem().toString(), combo_Clasa.getSelectedItem().toString(), data1,
							chk_ZborRetur.isSelected(), data2, 0.0, // pretul initial este 0, pana la cautarea zborului
							0.0, // durata zborului va fi inlocuita la cautarea efectiva
							"N/A" // numarul zborului va fi inlocuit la cautarea efectiva
					);

					zbor = new RezervareZbor("ERROR");
					// deschidere pagina cautare zbor
					// CautareZbor_page3_main.main(frame,null);

				} else {
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				}

			}
		});
		btn_CautareZbor.setFont(new Font("Consolas", Font.PLAIN, 18));
		btn_CautareZbor.setBounds(297, 481, 200, 40);
		btn_CautareZbor.setBackground(new Color(55, 71, 133));
		btn_CautareZbor.setOpaque(true);
		// Round the button with radius = 30
		btn_CautareZbor.setBorder(new RoundButton(30));

		btn_CautareZbor.setUI(new ButtonFill());
		contentPane.add(btn_CautareZbor);

		txt_OrasPlecare = new JTextField();
		txt_OrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_OrasPlecare.setColumns(10);
		txt_OrasPlecare.setBounds(245, 35, 222, 30);
		contentPane.add(txt_OrasPlecare);

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
