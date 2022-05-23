package ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionalities.CursaZbor;
import functionalities.RezervareZbor;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SpinnerNumberModel;

public class RezervareZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrasDestinatie;
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
	private JTextField txtOrasPlecare;
	private JLabel lblNrBilete;

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
	public RezervareZborFrame(boolean staffOnly) {
		setTitle("Rezervare Zbor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOrasPlecare = new JLabel("Ora\u0219 origine:");
		lblOrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblOrasPlecare.setBounds(153, 42, 161, 30);
		contentPane.add(lblOrasPlecare);

		JLabel lblOrasSosire = new JLabel("Ora\u0219 destina\u021Bie:");
		lblOrasSosire.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblOrasSosire.setBounds(153, 83, 187, 30);
		contentPane.add(lblOrasSosire);

		JLabel lblDataPlecarii = new JLabel("Data plec\u0103rii:");
		lblDataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDataPlecarii.setBounds(202, 145, 161, 30);
		contentPane.add(lblDataPlecarii);

		JLabel lblTipLoc = new JLabel("Tip loc:");
		lblTipLoc.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblTipLoc.setBounds(202, 255, 100, 30);
		contentPane.add(lblTipLoc);

		JLabel lblClasa = new JLabel("Clasa la care se dore\u0219te rezervarea:");
		lblClasa.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblClasa.setBounds(107, 400, 407, 30);
		contentPane.add(lblClasa);

		JLabel lblDataIntoarcere = new JLabel("Data \u00EEntoarcerii:");
		lblDataIntoarcere.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDataIntoarcere.setBounds(361, 320, 199, 30);
		contentPane.add(lblDataIntoarcere);

		txtOrasDestinatie = new JTextField();
		txtOrasDestinatie.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOrasDestinatie.setColumns(10);
		txtOrasDestinatie.setBounds(362, 83, 420, 30);
		contentPane.add(txtOrasDestinatie);

		JSpinner dateTimeDataPlecarii = new JSpinner(new SpinnerDateModel(new Date(1651524853330L),
				new Date(1651524853330L), new Date(1967144053330L), Calendar.DAY_OF_YEAR));
		dateTimeDataPlecarii.setFont(new Font("Consolas", Font.PLAIN, 20));
		JSpinner.DateEditor de_dateTimeDataPlecarii = new JSpinner.DateEditor(dateTimeDataPlecarii, "dd.MM.yy");
		dateTimeDataPlecarii.setEditor(de_dateTimeDataPlecarii);
		dateTimeDataPlecarii.setBounds(437, 145, 249, 30);
		contentPane.add(dateTimeDataPlecarii);

		JSpinner dateTimeDataIntoarcerii = new JSpinner(new SpinnerDateModel(new Date(1651524884913L),
				new Date(1651524884913L), new Date(1967144084913L), Calendar.DAY_OF_YEAR));
		dateTimeDataIntoarcerii.setFont(new Font("Consolas", Font.PLAIN, 20));
		JSpinner.DateEditor de_dateTimeDataIntoarcerii = new JSpinner.DateEditor(dateTimeDataIntoarcerii, "dd.MM.yy");
		dateTimeDataIntoarcerii.setEditor(de_dateTimeDataIntoarcerii);
		dateTimeDataIntoarcerii.setBounds(652, 320, 130, 30);
		dateTimeDataIntoarcerii.setEnabled(false);
		contentPane.add(dateTimeDataIntoarcerii);

		String[] tipLoc = { "Adult", "Copil" };
		JComboBox comboTipLoc = new JComboBox(tipLoc);
		comboTipLoc.setFont(new Font("Consolas", Font.PLAIN, 20));
		comboTipLoc.setBounds(437, 255, 249, 30);
		contentPane.add(comboTipLoc);

		JCheckBox chkZborRetur = new JCheckBox("Retur");
		chkZborRetur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTimeDataIntoarcerii.setEnabled(chkZborRetur.isSelected() ? true : false);
			}
		});
		chkZborRetur.setBackground(new Color(168, 208, 224));
		chkZborRetur.setHorizontalAlignment(SwingConstants.LEFT);
		chkZborRetur.setFont(new Font("Consolas", Font.PLAIN, 20));
		chkZborRetur.setBounds(153, 320, 112, 30);
		contentPane.add(chkZborRetur);

		String[] clasaBilet = { "Econom", "Business", "Premium" };
		JComboBox comboClasa = new JComboBox(clasaBilet);
		comboClasa.setFont(new Font("Consolas", Font.PLAIN, 20));
		comboClasa.setBounds(598, 400, 222, 30);
		contentPane.add(comboClasa);

		txtOrasPlecare = new JTextField();
		txtOrasPlecare.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtOrasPlecare.setColumns(10);
		txtOrasPlecare.setBounds(363, 42, 419, 30);
		contentPane.add(txtOrasPlecare);
		
		lblNrBilete = new JLabel("Numar bilete:");
		lblNrBilete.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNrBilete.setBounds(202, 200, 154, 30);
		contentPane.add(lblNrBilete);
		
		JSpinner spinnerNrBilete = new JSpinner();
		spinnerNrBilete.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerNrBilete.setFont(new Font("Consolas", Font.PLAIN, 20));
		spinnerNrBilete.setBounds(437, 200, 249, 25);
		contentPane.add(spinnerNrBilete);
		
		JButton btnCautareZbor = new JButton("Căutare cursa de Zbor");
		btnCautareZbor.setForeground(Color.WHITE);
		btnCautareZbor.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnCautareZbor.setBounds(318, 475, 310, 49);
		btnCautareZbor.setBackground(new Color(55, 71, 133));
		btnCautareZbor.setOpaque(true);
		btnCautareZbor.setBorder(new RoundButton(30));
		btnCautareZbor.setUI(new ButtonFill());
		
		btnCautareZbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rezervare = new RezervareZbor(txtOrasPlecare.getText(), txtOrasDestinatie.getText(),
						(Date)dateTimeDataPlecarii.getValue(), (int)spinnerNrBilete.getValue(),
						(String)comboTipLoc.getSelectedItem(), (String)comboClasa.getSelectedItem(),chkZborRetur.isSelected(),
						chkZborRetur.isSelected() ? (Date)dateTimeDataIntoarcerii.getValue() : null);
				
				List<CursaZbor> curseZborDisponibile = new ArrayList<CursaZbor>();
				curseZborDisponibile = rezervare.getCurseZborDisponibile("curseZbor.json");
				
				CautareZborFrame cautareZbor = new CautareZborFrame(curseZborDisponibile, rezervare, false);
				cautareZbor.setVisible(true);
				dispose();
				
				/////////////////////////////////////////////////
				/*boolean err_plecare = false;
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
				if (!numeOrasValid(txtOrasPlecare.getText())) {
					err = true;
					err_plecare = true;

					txtOrasPlecare.setBackground(c_err);
				}

				if (!numeOrasValid(txtOrasDestinatie.getText())) {
					err = true;
					err_destinatie = true;

					txtOrasDestinatie.setBackground(c_err);
				}

				if (!dateValide(data1, data2)) {
					err = true;
					err_date = true;

					dateTimeDataPlecarii.setBackground(c_err);
					dateTimeDataIntoarcerii.setBackground(c_err);
				}

				if (comboTipLoc.getSelectedItem() == null) {
					err = true;
					err_tipLoc = true;

					comboTipLoc.setBackground(c_err);
				}

				if (comboClasa.getSelectedItem() == null) {
					err = true;
					err_clasa = true;

					comboClasa.setBackground(c_err);
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
					buf = form.format(dateTimeDataIntoarcerii.getValue()).split("/");
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

					//zbor = new RezervareZbor("ERROR");
					// deschidere pagina cautare zbor
					// CautareZbor_page3_main.main(frame,null);
*/
			} /*
				 * else { JOptionPane.showMessageDialog(null, "Date zbor incorecte"); }
				 */
		});
		contentPane.add(btnCautareZbor);
		
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
