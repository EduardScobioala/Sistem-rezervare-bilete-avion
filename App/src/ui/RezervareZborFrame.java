package ui;

import logic.RezervareZbor;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class RezervareZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_OrasPlecare;
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

	// functii utilitare

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

	protected boolean dateValide(int[] data1, int[] data2) {
		if (data1[2] > data2[2])
			return false;
		else if (data1[1] > data2[1])
			return false;
		else if (data1[0] > data2[0])
			return false;

		return true;
	}

	public void setZborAles(RezervareZbor zbor) {
		this.zbor = zbor;
	}

	public RezervareZborFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_OrasPlecare = new JLabel("Ora\u0219 origine:");
		lbl_OrasPlecare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_OrasPlecare.setBounds(10, 10, 98, 21);
		contentPane.add(lbl_OrasPlecare);

		JLabel lbl_OrasSosire = new JLabel("Ora\u0219 destina\u021Bie:");
		lbl_OrasSosire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_OrasSosire.setBounds(10, 40, 98, 21);
		contentPane.add(lbl_OrasSosire);

		JLabel lbl_DataPlecarii = new JLabel("Data plec\u0103rii:");
		lbl_DataPlecarii.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_DataPlecarii.setBounds(10, 85, 98, 21);
		contentPane.add(lbl_DataPlecarii);

		JLabel lbl_TipLoc = new JLabel("Tip loc:");
		lbl_TipLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TipLoc.setBounds(10, 133, 53, 21);
		contentPane.add(lbl_TipLoc);

		JLabel lbl_Clasa = new JLabel("Clasa la care se dore\u0219te rezervarea:");
		lbl_Clasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Clasa.setBounds(10, 211, 222, 21);
		contentPane.add(lbl_Clasa);

		JLabel lbl_DataIntoarcere = new JLabel("Data \u00EEntoarcerii:");
		lbl_DataIntoarcere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_DataIntoarcere.setBounds(130, 170, 109, 21);
		contentPane.add(lbl_DataIntoarcere);

		txt_OrasPlecare = new JTextField();
		txt_OrasPlecare.setBounds(118, 13, 96, 19);
		contentPane.add(txt_OrasPlecare);
		txt_OrasPlecare.setColumns(10);

		txt_OrasDestinatie = new JTextField();
		txt_OrasDestinatie.setColumns(10);
		txt_OrasDestinatie.setBounds(118, 43, 96, 19);
		contentPane.add(txt_OrasDestinatie);

		JSpinner dateTime_DataPlecarii = new JSpinner(new SpinnerDateModel(new Date(1651524853330L),
				new Date(1651524853330L), new Date(1967144053330L), Calendar.DAY_OF_YEAR));
		JSpinner.DateEditor editor_plecare = new JSpinner.DateEditor(dateTime_DataPlecarii, "dd.MM.yy");
		dateTime_DataPlecarii.setEditor(editor_plecare);
		dateTime_DataPlecarii.setBounds(116, 83, 98, 29);
		contentPane.add(dateTime_DataPlecarii);

		JSpinner dateTime_DataIntoarcerii = new JSpinner(new SpinnerDateModel(new Date(1651524884913L),
				new Date(1651524884913L), new Date(1967144084913L), Calendar.DAY_OF_YEAR));
		JSpinner.DateEditor editor_intoarcere = new JSpinner.DateEditor(dateTime_DataIntoarcerii, "dd.MM.yy");
		dateTime_DataIntoarcerii.setEditor(editor_intoarcere);
		dateTime_DataIntoarcerii.setBounds(242, 168, 98, 29);
		contentPane.add(dateTime_DataIntoarcerii);

		JComboBox combo_TipLoc = new JComboBox();
		combo_TipLoc.setBounds(73, 135, 123, 21);
		contentPane.add(combo_TipLoc);

		JCheckBox chk_ZborRetur = new JCheckBox("Retur");
		chk_ZborRetur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chk_ZborRetur.setBounds(10, 170, 67, 21);
		contentPane.add(chk_ZborRetur);

		JComboBox combo_Clasa = new JComboBox();
		combo_Clasa.setBounds(242, 213, 123, 21);
		contentPane.add(combo_Clasa);

		JLabel lbl_ListaLocuri = new JLabel("List\u0103 locuri");
		lbl_ListaLocuri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ListaLocuri.setBounds(539, 10, 98, 21);
		contentPane.add(lbl_ListaLocuri);

		JList lst_LocuriDisponibile = new JList();
		lst_LocuriDisponibile.setBounds(469, 41, 243, 277);
		contentPane.add(lst_LocuriDisponibile);

		JButton btn_RezervareLoc = new JButton("Rezervare loc");
		btn_RezervareLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lst_LocuriDisponibile.getComponentCount() == 0
						|| (lst_LocuriDisponibile.getSelectedValuesList().size() != 0
								&& lst_LocuriDisponibile.getSelectedValuesList()
										.get(lst_LocuriDisponibile.getSelectedIndex() - 1).equals(""))) {
					JOptionPane.showMessageDialog(null, "Alegeți un loc");
				} else if (rezervare == null) {
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				} else {
					// deschidere pagina vizualizare zbor
					// VizualizareZborFrame.main(null);

				}

			}
		});
		btn_RezervareLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_RezervareLoc.setBounds(10, 289, 123, 29);
		contentPane.add(btn_RezervareLoc);

		JButton btn_CautareZbor = new JButton("Căutare zbor");
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

					dateTime_DataPlecarii.setBackground(c_err);
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
					buf = form.format(dateTime_DataPlecarii.getValue()).split("/");
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
							chk_ZborRetur.isSelected(), data2, 0.0, // price is 0 for the searched flight; or it could
																	// be the maximum/minimum price desired; will be
																	// replaced with actual price
							0.0, // duration will be replaced with actual flight duration at search
							"N/A" // flight no. will be replaced with actual flight no. at search
					);

					zbor = new RezervareZbor("ERROR");
					// deschidere pagina cautare zbor
					// CautareZbor_page3_main.main(frame,null);

				} else {
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				}

			}
		});
		btn_CautareZbor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_CautareZbor.setBounds(316, 289, 123, 29);
		contentPane.add(btn_CautareZbor);

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
