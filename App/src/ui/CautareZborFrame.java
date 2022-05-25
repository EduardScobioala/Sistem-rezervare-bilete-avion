package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import functionalities.CursaZbor;
import functionalities.RezervareZbor;

import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CautareZborFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	@SuppressWarnings("unchecked")
	public CautareZborFrame(List<CursaZbor> curseZborDisponibile, RezervareZbor rezervare, List<CursaZbor> curseRezervareDisponibile, boolean staffOnly) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
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

		// Lista de afisare
		JList lstZboruriDisponibile = new JList();
		lstZboruriDisponibile.setModel(new AbstractListModel() {
			String[] values = getInfoCurse(curseZborDisponibile, rezervare, curseRezervareDisponibile);

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lstZboruriDisponibile.setFont(new Font("Consolas", Font.PLAIN, 15));
		lstZboruriDisponibile.setBackground(new Color(220, 220, 220));
		lstZboruriDisponibile.setBounds(10, 62, 964, 420);
		contentPane.add(lstZboruriDisponibile);
		
		// Butonul de rezervare
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
				
				// a fost selectat un zbor
				if (index != -1) {
					List<CursaZbor> curseZborValide = new ArrayList<CursaZbor>();
					
					// se adauga la lista cursele disponibile pentru a transmite cursa dupa index
					for (var cursa : curseZborDisponibile) {
						if (gotCursa(cursa, rezervare)) curseZborValide.add(cursa);
					}
					// index se afla in cursele de tur
					if (index < curseZborValide.size() ) {
						float pret = getPret(curseZborValide.get(index), rezervare);
						// se transmit datele spre afisare
						VizualizareZborFrame vizualizareZborFrame = new VizualizareZborFrame(curseZborValide.get(index), rezervare, pret, staffOnly);
						vizualizareZborFrame.setVisible(true);
						dispose();
					} // index se afla in raza de curse retur
					else {
						JOptionPane.showMessageDialog(null, "Zborurile de retur sunt cu scop informativ!");
					}
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
	
	// calculare pret conform criterii
	private float getPret(CursaZbor cursa, RezervareZbor rezervare) {
		int index = 0;
		if (rezervare.getClasa().equals("Business")) index = 1;
		if (rezervare.getClasa().equals("Premium")) index = 2;
		
		float pret = cursa.getPretClase()[index] * rezervare.getNrBilete();
		
		// discount last-minute
		LocalDate rezervareDate = rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate todayDate = LocalDate.now();
		
		if (todayDate.isEqual(rezervareDate)) pret = pret * 0.5f;
		
		if (rezervare.getTipLoc().equals("Copil")) pret *= 0.9f;
		
		// discount tur retur
		if (rezervare.isRetur()) pret = pret * 0.8f;
		
		return pret;
	}
	
	// verificare zile disponibile
	private boolean gotCursa(CursaZbor cursa, RezervareZbor rezervare) {
		boolean flag = false;
		
		LocalDate rezervareDate = rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(cursa.getZileOperare()[rezervareDate.getDayOfWeek().getValue()-1] == 1) flag = true;
		
		return flag;
	}
	
	// conversie  date in String pentru lista de zboruri
	private String[] getInfoCurse(List<CursaZbor> curseZborDisponibile, RezervareZbor rezervare, List<CursaZbor> curseRezervareDisponibile) {
		List<String> rawInfoCurse = new ArrayList<String>();

		for (var cursa : curseZborDisponibile) {
			if (gotCursa(cursa, rezervare)) {
				rawInfoCurse.add(cursa.getNumeCompanie() + " : " + cursa.getCodCursa()
				+ ", Data: " + rezervare.getDataPlecare().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
				", Orar: " + cursa.getOraPlecare() + "-" + cursa.getOraSosire() + ", "+ rezervare.getNrBilete() + " bilete, "
				+ "Pret: " + String.valueOf(getPret(cursa, rezervare)) + " RON");
			}
		}
		
		if (curseRezervareDisponibile != null) {
			RezervareZbor rezervareRetur = new RezervareZbor(rezervare.getOrigine(), rezervare.getDestinatie(), 
					rezervare.getDataIntoarcere(), rezervare.getNrBilete(), rezervare.getTipLoc(), rezervare.getClasa(),
					true, null);
			for (var cursa : curseRezervareDisponibile) {
				if (gotCursa(cursa, rezervareRetur)) {
					rawInfoCurse.add(cursa.getNumeCompanie() + " : " + cursa.getCodCursa()
					+ ", Data: " + rezervare.getDataIntoarcere().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
					", Orar: " + cursa.getOraPlecare() + "-" + cursa.getOraSosire() + ", "+ rezervare.getNrBilete() + " bilete, "
					+ "Pret: " + String.valueOf(getPret(cursa, rezervareRetur)) + " RON");
				}
			}
		}
		
		String[] infoCurse = new String[rawInfoCurse.size()];
		
		for (int i = 0; i < rawInfoCurse.size(); i++) {
			infoCurse[i] = rawInfoCurse.get(i);
		}

		return infoCurse;
	}
}
