package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

import functionalities.CursaZbor;
import functionalities.RezervareZbor;

import javax.swing.event.ListSelectionEvent;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	public CautareZborFrame(List<CursaZbor> curseZborDisponibile, RezervareZbor rezervare, boolean staffOnly) {
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
			String[] values = getInfoCurse(curseZborDisponibile, rezervare);

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
		lstZboruriDisponibile.setBounds(10, 62, 964, 420);
		contentPane.add(lstZboruriDisponibile);
		
		JButton btnRezerva = new JButton("Rezerva");
		btnRezerva.setForeground(Color.WHITE);
		btnRezerva.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnRezerva.setBounds(376, 507, 232, 43);
		btnRezerva.setBackground(new Color(55, 71, 133));
		btnRezerva.setOpaque(true);
		btnRezerva.setBorder(new RoundButton(30));
		btnRezerva.setUI(new ButtonFill());
		
		btnRezerva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = lstZboruriDisponibile.getSelectedIndex();
				
				if (index != -1) {
					List<CursaZbor> curseZborValide = new ArrayList<CursaZbor>();
					
					for (var cursa : curseZborDisponibile) {
						if (gotCursa(cursa, rezervare)) curseZborValide.add(cursa);
					}
					
					VizualizareZborFrame vizualizareZborFrame = new VizualizareZborFrame(curseZborValide.get(index), rezervare, getPret(curseZborValide.get(index), rezervare), staffOnly);
					vizualizareZborFrame.setVisible(true);
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Nici un zbor selectat!");
				}
			}
		});
		
		contentPane.add(btnRezerva);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				RezervareZborFrame rezervareZbor = new RezervareZborFrame(staffOnly);
				rezervareZbor.setVisible(true);
			}
		});
	}
	
	private float getPret(CursaZbor cursa, RezervareZbor rezervare) {
		int index = 0;
		if (rezervare.getClasa().equals("Business")) index = 1;
		if (rezervare.getClasa().equals("Premium")) index = 2;
		
		float pret = cursa.getPretClase()[index] * rezervare.getNrBilete();
		
		// discount last-minute
		LocalDate rezervareDate = rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate todayDate = LocalDate.now();
		
		if (todayDate.isEqual(rezervareDate)) pret = pret * 0.5f;
		
		// discount tur retur
		if (rezervare.isRetur()) pret = pret * 0.8f;
		
		return pret;
	}
	
	private boolean gotCursa(CursaZbor cursa, RezervareZbor rezervare) {
		boolean flag = false;
		
		LocalDate rezervareDate = rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(cursa.getZileOperare()[rezervareDate.getDayOfWeek().getValue()-1] == 1) flag = true;
		
		return flag;
	}
	
	private String[] getInfoCurse(List<CursaZbor> curseZborDisponibile, RezervareZbor rezervare) {
		List<String> rawInfoCurse = new ArrayList<String>();

		for (var cursa : curseZborDisponibile) {
			if (gotCursa(cursa, rezervare)) {
				rawInfoCurse.add(cursa.getNumeCompanie() + " : " + cursa.getCodCursa()
				+ ", Data: " + rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
				", Orar: " + cursa.getOraPlecare() + "-" + cursa.getOraSosire() + ", "+ rezervare.getNrBilete() + " bilete, "
				+ "Pret: " + String.valueOf(getPret(cursa, rezervare)) + " RON");
			}
		}
		
		String[] infoCurse = new String[rawInfoCurse.size()];
		
		for (int i = 0; i < rawInfoCurse.size(); i++) {
			infoCurse[i] = rawInfoCurse.get(i);
		}

		return infoCurse;
	}
}
