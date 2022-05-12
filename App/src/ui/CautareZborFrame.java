package ui;

import logic.RezervareZbor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.AbstractListModel;
import java.awt.Color;

public class CautareZborFrame extends JFrame {

	private JPanel contentPane;

	private RezervareZbor rezervare;
	RezervareZbor ZborAles = null;
	private RezervareZborFrame initial_frame;

	public CautareZborFrame(RezervareZbor rezervare) {
		this.rezervare = rezervare;
	}

	private static CautareZborFrame frame;
	/*
	 * public static void main(RezervareZborFrame initial_frame, String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { frame = new
	 * CautareZborFrame(); frame.initial_frame=initial_frame;
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	// functii utilitare

	
	//functia main
	public static void main(RezervareZborFrame initial_frame, String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CautareZborFrame();
					frame.initial_frame=initial_frame;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RezervareZbor getZbor()
	{
		return this.ZborAles;
	}
	
	//functii
	//generare forma
	public CautareZborFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 208, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_ZboruriDisponibile = new JLabel("Zboruri disponibile");
		lbl_ZboruriDisponibile.setFont(new Font("Consolas", Font.PLAIN, 22));
		lbl_ZboruriDisponibile.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ZboruriDisponibile.setBounds(351, 9, 256, 42);
		contentPane.add(lbl_ZboruriDisponibile);

		JList lst_ZboruriDisponibile = new JList();
		lst_ZboruriDisponibile.setBackground(new Color(220, 220, 220));
		lst_ZboruriDisponibile.setModel(new AbstractListModel() {
			String[] values = new String[] { "item1", "item2" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lst_ZboruriDisponibile.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String aux;

				aux = lst_ZboruriDisponibile.getSelectedValuesList().get(0).toString();
				// dev: to parse the above-mentioned RezervareZbor[] structure and find the
				// selected flight - aux - and return the details of that flight in
				// the variable 'ZborAles'; do not forget about the price of the ticket
				/*
				 * for(;;) {
				 * 
				 * }
				 */

				// frame.dispose();
				
				
				//frame.dispose();
				initial_frame.setZborAles(ZborAles);
				frame.setVisible(false);
			}
		});
		lst_ZboruriDisponibile.setBounds(10, 62, 964, 465);
		contentPane.add(lst_ZboruriDisponibile);
	}

}
