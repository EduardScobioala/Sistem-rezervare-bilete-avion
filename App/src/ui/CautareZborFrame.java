package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import functionalities.CursaZbor;
import functionalities.RezervareZbor;

import javax.swing.event.ListSelectionEvent;
import javax.swing.AbstractListModel;
import java.awt.Color;

public class CautareZborFrame extends JFrame {

	private JPanel contentPane;

	private RezervareZbor rezervare;
	RezervareZbor ZborAles = null;
	private RezervareZborFrame initial_frame;

	// private static CautareZborFrame frame;

	// functii utilitare

	// functia main
	/*
	 * public static void main(RezervareZborFrame initial_frame, String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { frame = new
	 * CautareZborFrame(); frame.initial_frame = initial_frame;
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	public RezervareZbor getZbor() {
		return this.ZborAles;
	}

	// functii
	// generare forma
	@SuppressWarnings("unchecked")
	public CautareZborFrame(List<CursaZbor> curseZborDisponibile) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblZboruriDisponibile = new JLabel("Zboruri disponibile");
		lblZboruriDisponibile.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblZboruriDisponibile.setHorizontalAlignment(SwingConstants.CENTER);
		lblZboruriDisponibile.setBounds(351, 9, 256, 42);
		contentPane.add(lblZboruriDisponibile);

		JList lstZboruriDisponibile = new JList();
		lstZboruriDisponibile.setModel(new AbstractListModel() {
			String[] values = getInfoCurse(curseZborDisponibile);

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lstZboruriDisponibile.setFont(new Font("Consolas", Font.PLAIN, 15));
		lstZboruriDisponibile.setBackground(new Color(220, 220, 220));
		/*
		 * lstZboruriDisponibile.addListSelectionListener(new ListSelectionListener() {
		 * public void valueChanged(ListSelectionEvent e) { String aux;
		 * 
		 * aux = lstZboruriDisponibile.getSelectedValuesList().get(0).toString(); //
		 * dev: to parse the above-mentioned RezervareZbor[] structure and find the //
		 * selected flight - aux - and return the details of that flight in // the
		 * variable 'ZborAles'; do not forget about the price of the ticket
		 * 
		 * for(;;) {
		 * 
		 * }
		 * 
		 * 
		 * // frame.dispose();
		 * 
		 * // frame.dispose(); initial_frame.setZborAles(ZborAles);
		 * //frame.setVisible(false); } });
		 */
		lstZboruriDisponibile.setBounds(10, 62, 964, 465);
		contentPane.add(lstZboruriDisponibile);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				RezervareZborFrame rezervareZbor = new RezervareZborFrame();
				rezervareZbor.setVisible(true);;
			}
		});
	}

	private String getZileOperare(CursaZbor cursa) {
		int[] zileOperare = cursa.getZileOperare();
		String zile = "";

		if (zileOperare[0] == 1)
			zile += "Lu, ";
		if (zileOperare[1] == 1)
			zile += "Ma, ";
		if (zileOperare[2] == 1)
			zile += "Mi, ";
		if (zileOperare[3] == 1)
			zile += "Jo, ";
		if (zileOperare[4] == 1)
			zile += "Vi, ";
		if (zileOperare[5] == 1)
			zile += "Sa, ";
		if (zileOperare[6] == 1)
			zile += "Du, ";

		zile = (String) zile.subSequence(0, zile.length() - 2);

		return zile;
	}

	private float getPret(CursaZbor cursa) {
		float pret = 1000;
		
		// inplementation
		
		return pret;
	}
	
	private String[] getInfoCurse(List<CursaZbor> curseZborDisponibile) {
		String[] infoCurse = new String[curseZborDisponibile.size()];

		int index = -1;
		for (var cursa : curseZborDisponibile) {
			index++;
			infoCurse[index] = cursa.getNumeCompanie() + " : " + cursa.getCodCursa()
					+ ", Zile de Operare: " + getZileOperare(cursa) + ", Orar: " + cursa.getOraPlecare()
					+ "-" + cursa.getOraSosire() + ", "+ "Pret: " + String.valueOf(getPret(cursa)) + " RON";
		}

		return infoCurse;
	}
}
