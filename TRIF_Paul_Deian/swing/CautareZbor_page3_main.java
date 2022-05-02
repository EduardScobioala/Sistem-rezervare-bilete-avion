package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CautareZbor_page3_main extends JFrame {

	private JPanel contentPane;

	private RezervareZbor rezervare;
	RezervareZbor ZborAles = null;
	
	public CautareZbor_page3_main(RezervareZbor rezervare) {
		this.rezervare=rezervare;
	}
	
	private static CautareZbor_page3_main frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CautareZbor_page3_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//functii utilitare
	
	public CautareZbor_page3_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ZboruriDisponibile = new JLabel("Zboruri disponibile");
		lbl_ZboruriDisponibile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ZboruriDisponibile.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ZboruriDisponibile.setBounds(132, 10, 182, 42);
		contentPane.add(lbl_ZboruriDisponibile);
		
		JList lst_ZboruriDisponibile = new JList();
		lst_ZboruriDisponibile.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String aux;
				
				aux = lst_ZboruriDisponibile.getSelectedValuesList().get(lst_ZboruriDisponibile.getSelectedIndex()-1).toString();
				
				//dev: to parse the above-mentioned RezervareZbor[] structure and find the selected flight - aux - and return the details of that flight in
				//the variable 'ZborAles'; do not forget about the price of the ticket
				/*
				 for(;;)
				 {
				 
				 }
				 */
				
				
				frame.dispose();
			}
		});
		lst_ZboruriDisponibile.setBounds(10, 62, 416, 191);
		contentPane.add(lst_ZboruriDisponibile);
	}


}
