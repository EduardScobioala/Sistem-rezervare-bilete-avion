package ui;

import logic.RezervareZbor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VizualizareZborFrame extends JFrame {

	private JPanel contentPane;

	
	private RezervareZbor zbor;
	private JTextField txt_OrasPlecare;
	private JTextField txt_OrasDestinatie;
	private JTextField txt_NrZbor;
	private JTextField txt_Durata;
	private JTextField txt_Pret;
	private JTextField dateTime_DataZbor;
	private JTextField txt_Nume;
	private JTextField txt_Prenume;
	private JTextField txt_Telefon;
	private JTextField txt_Email;
	private JTextField txt_NrCard;
	private JTextField txt_NumeTitular;
	private JTextField txt_CVC;
	private JTextField txt_PlataCashSuma;
	private boolean plata_cash;
	
	public VizualizareZborFrame(RezervareZbor zbor, boolean plata_cash) {
		this.zbor=zbor;
		this.plata_cash=plata_cash;
	}

	static VizualizareZborFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VizualizareZborFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				frame.open();
				
			}
		});
	}
	
	public void open()
	{
		//load selected flight details
		if(zbor==null) {
			boolean ok=false;
			JOptionPane.showMessageDialog(null, "Eroare �nc�rcare detalii zbor ales");
			frame.dispose();
		}
		else {
		txt_OrasPlecare.setText(zbor.getOrigine());
		txt_OrasDestinatie.setText(zbor.getDestinatie());
		txt_Durata.setText(""+zbor.getDurata());
		txt_Pret.setText(""+zbor.getPret());
		//dateTime_DataZbor.setData(zbor.getData());
		txt_NrZbor.setText(zbor.getNr());
		}
	}
	
	public VizualizareZborFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 540, 681);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 506, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_DetaliiZborTitlu = new JLabel("Detalii zbor");
		lbl_DetaliiZborTitlu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_DetaliiZborTitlu.setBounds(194, 10, 114, 38);
		panel.add(lbl_DetaliiZborTitlu);
		
		JLabel lbl_OrasPlecare = new JLabel("Origine:");
		lbl_OrasPlecare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_OrasPlecare.setBounds(10, 51, 78, 23);
		panel.add(lbl_OrasPlecare);
		
		JLabel lbl_OrasDestinatie = new JLabel("Destina\u021Bie:");
		lbl_OrasDestinatie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_OrasDestinatie.setBounds(10, 95, 78, 23);
		panel.add(lbl_OrasDestinatie);
		
		JLabel lbl_NrZbor = new JLabel("Num\u0103r zbor:");
		lbl_NrZbor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NrZbor.setBounds(10, 139, 78, 23);
		panel.add(lbl_NrZbor);
		
		JLabel lbl_DurataZbor = new JLabel("Durat\u0103 zbor:");
		lbl_DurataZbor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_DurataZbor.setBounds(230, 58, 78, 23);
		panel.add(lbl_DurataZbor);
		
		JLabel lbl_DataPlecare = new JLabel("Dat\u0103:");
		lbl_DataPlecare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_DataPlecare.setBounds(230, 102, 78, 23);
		panel.add(lbl_DataPlecare);
		
		JLabel lbl_Pret = new JLabel("Pre\u021B:");
		lbl_Pret.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Pret.setBounds(230, 146, 78, 23);
		panel.add(lbl_Pret);
		
		JLabel lbl_RON_ReadOnly = new JLabel("RON");
		lbl_RON_ReadOnly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_RON_ReadOnly.setBounds(450, 146, 45, 23);
		panel.add(lbl_RON_ReadOnly);
		
		JLabel lbl_DurataZbor_ore = new JLabel("ore");
		lbl_DurataZbor_ore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_DurataZbor_ore.setBounds(450, 58, 30, 23);
		panel.add(lbl_DurataZbor_ore);
		
		txt_OrasPlecare = new JTextField();
		txt_OrasPlecare.setEditable(false);
		txt_OrasPlecare.setBounds(98, 58, 122, 19);
		panel.add(txt_OrasPlecare);
		txt_OrasPlecare.setColumns(10);
		
		txt_OrasDestinatie = new JTextField();
		txt_OrasDestinatie.setEditable(false);
		txt_OrasDestinatie.setColumns(10);
		txt_OrasDestinatie.setBounds(98, 99, 122, 19);
		panel.add(txt_OrasDestinatie);
		
		txt_NrZbor = new JTextField();
		txt_NrZbor.setEditable(false);
		txt_NrZbor.setColumns(10);
		txt_NrZbor.setBounds(98, 143, 122, 19);
		panel.add(txt_NrZbor);
		
		txt_Durata = new JTextField();
		txt_Durata.setEditable(false);
		txt_Durata.setColumns(10);
		txt_Durata.setBounds(318, 62, 122, 19);
		panel.add(txt_Durata);
		
		txt_Pret = new JTextField();
		txt_Pret.setEditable(false);
		txt_Pret.setColumns(10);
		txt_Pret.setBounds(318, 143, 122, 19);
		panel.add(txt_Pret);
		
		dateTime_DataZbor = new JTextField();
		dateTime_DataZbor.setEditable(false);
		dateTime_DataZbor.setColumns(10);
		dateTime_DataZbor.setBounds(318, 106, 122, 19);
		panel.add(dateTime_DataZbor);
		
		JLabel lbl_RezervareTitlu = new JLabel("Rezervare");
		lbl_RezervareTitlu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_RezervareTitlu.setBounds(202, 201, 114, 38);
		contentPane.add(lbl_RezervareTitlu);
		
		JLabel lbl_Nume = new JLabel("Nume:");
		lbl_Nume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Nume.setBounds(31, 246, 68, 23);
		contentPane.add(lbl_Nume);
		
		JLabel lbl_Prenume = new JLabel("Prenume:");
		lbl_Prenume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Prenume.setBounds(31, 279, 68, 23);
		contentPane.add(lbl_Prenume);
		
		JLabel lbl_Varsta = new JLabel("V\u00E2rst\u0103:");
		lbl_Varsta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Varsta.setBounds(31, 312, 68, 23);
		contentPane.add(lbl_Varsta);
		
		JLabel lbl_Email = new JLabel("E-mail:");
		lbl_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Email.setBounds(269, 246, 59, 23);
		contentPane.add(lbl_Email);
		
		JLabel lbl_Telefon = new JLabel("Telefon:");
		lbl_Telefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Telefon.setBounds(269, 279, 59, 23);
		contentPane.add(lbl_Telefon);
		
		txt_Nume = new JTextField();
		txt_Nume.setColumns(10);
		txt_Nume.setBounds(124, 250, 122, 19);
		contentPane.add(txt_Nume);
		
		txt_Prenume = new JTextField();
		txt_Prenume.setColumns(10);
		txt_Prenume.setBounds(124, 283, 122, 19);
		contentPane.add(txt_Prenume);
		
		txt_Telefon = new JTextField();
		txt_Telefon.setColumns(10);
		txt_Telefon.setBounds(334, 283, 122, 19);
		contentPane.add(txt_Telefon);
		
		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		txt_Email.setBounds(334, 250, 122, 19);
		contentPane.add(txt_Email);
		
		JSpinner spinner_Varsta = new JSpinner();
		spinner_Varsta.setBounds(124, 316, 122, 20);
		contentPane.add(spinner_Varsta);
		
		JPanel groupBox_PlataBanca = new JPanel();
		groupBox_PlataBanca.setBounds(10, 350, 326, 223);
		contentPane.add(groupBox_PlataBanca);
		groupBox_PlataBanca.setLayout(null);
		
		JLabel lbl_ModalitatePlata = new JLabel("Modalitate plat\u0103:");
		lbl_ModalitatePlata.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ModalitatePlata.setBounds(10, 10, 113, 23);
		groupBox_PlataBanca.add(lbl_ModalitatePlata);
		
		JRadioButton radio_Card = new JRadioButton("Card");
		radio_Card.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_Card.setBounds(129, 13, 55, 21);
		groupBox_PlataBanca.add(radio_Card);
		
		JRadioButton radio_ViramentBancar = new JRadioButton("Virament bancar");
		radio_ViramentBancar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radio_ViramentBancar.setBounds(186, 13, 127, 21);
		groupBox_PlataBanca.add(radio_ViramentBancar);
		
		JLabel lbl_NrCard_sau_Cont = new JLabel("Num\u0103r card/cont:");
		lbl_NrCard_sau_Cont.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NrCard_sau_Cont.setBounds(10, 56, 127, 23);
		groupBox_PlataBanca.add(lbl_NrCard_sau_Cont);
		
		JLabel lbl_DataExpirareCard = new JLabel("Dat\u0103 expirare card:");
		lbl_DataExpirareCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_DataExpirareCard.setBounds(10, 89, 127, 23);
		groupBox_PlataBanca.add(lbl_DataExpirareCard);
		
		JLabel lbl_NumeTitular = new JLabel("Nume titular:");
		lbl_NumeTitular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NumeTitular.setBounds(10, 122, 127, 23);
		groupBox_PlataBanca.add(lbl_NumeTitular);
		
		JLabel lbl_CodCVC = new JLabel("Cod CVC:");
		lbl_CodCVC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CodCVC.setBounds(10, 155, 127, 23);
		groupBox_PlataBanca.add(lbl_CodCVC);
		
		txt_NrCard = new JTextField();
		txt_NrCard.setColumns(10);
		txt_NrCard.setBounds(157, 60, 122, 19);
		groupBox_PlataBanca.add(txt_NrCard);
		
		txt_NumeTitular = new JTextField();
		txt_NumeTitular.setColumns(10);
		txt_NumeTitular.setBounds(157, 126, 122, 19);
		groupBox_PlataBanca.add(txt_NumeTitular);
		
		txt_CVC = new JTextField();
		txt_CVC.setColumns(10);
		txt_CVC.setBounds(157, 159, 122, 19);
		groupBox_PlataBanca.add(txt_CVC);
		
		JSpinner dateTime_ExpirareCard = new JSpinner();
		dateTime_ExpirareCard.setBounds(157, 93, 122, 20);
		groupBox_PlataBanca.add(dateTime_ExpirareCard);
		
		JPanel groupBox_PlataCash = new JPanel();
		groupBox_PlataCash.setBounds(344, 425, 270, 105);
		contentPane.add(groupBox_PlataCash);
		groupBox_PlataCash.setLayout(null);
		
		JLabel lbl_PlataCashTitlu = new JLabel("Plat\u0103 cash");
		lbl_PlataCashTitlu.setBounds(10, 10, 73, 17);
		lbl_PlataCashTitlu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		groupBox_PlataCash.add(lbl_PlataCashTitlu);
		
		JLabel lbl_PlataCashSuma = new JLabel("Suma:");
		lbl_PlataCashSuma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_PlataCashSuma.setBounds(10, 37, 49, 17);
		groupBox_PlataCash.add(lbl_PlataCashSuma);
		
		txt_PlataCashSuma = new JTextField();
		txt_PlataCashSuma.setColumns(10);
		txt_PlataCashSuma.setBounds(60, 37, 122, 19);
		groupBox_PlataCash.add(txt_PlataCashSuma);
		
		JLabel lbl_RON = new JLabel("RON");
		lbl_RON.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_RON.setBounds(192, 41, 45, 23);
		groupBox_PlataCash.add(lbl_RON);
		
		JLabel lbl_ErrData = new JLabel("#ERROR#");
		lbl_ErrData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ErrData.setBounds(361, 607, 68, 23);
		contentPane.add(lbl_ErrData);
		
		JButton btn_RezervaLocul = new JButton("Rezerv\u0103 locul");
		btn_RezervaLocul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean err_nume=false;
				boolean err_prenume=false;
				boolean err_dataExpirare=false;
				boolean err_email=false;
				boolean err_tel = false;
				boolean err_varsta = false;
				boolean err_nrCardCont = false;
				boolean err_NumeTitular = false;
				boolean err_CVC = false;
				boolean err=false;
				String[] data;
				String err_desc="";
				Color c_err=Color.red;
				
				//functii de verificare
				if(!numeValid(txt_Nume.getText()))
				{
					err=true;
					err_nume=true;
					err_desc+="\nNume invalid";
					txt_Nume.setBackground(c_err);
				}
				
				if(!numeValid(txt_Prenume.getText()))
				{
					err=true;
					err_prenume=true;
					err_desc+="\nPrenume invalid";
					txt_Prenume.setBackground(c_err);
				}
				
				data = txt_NumeTitular.getText().split(" ");
				for(int i=0;i<data.length;i++)
				{
					if(!numeValid(data[i])) {
						err=true;
						err_NumeTitular=true;
						err_desc+="\nNume titular invalid";
						txt_NumeTitular.setBackground(c_err);
						break;
					}
				}
				
				if(spinner_Varsta.getValue()==null || (spinner_Varsta.getValue()!=null && Integer.parseInt(spinner_Varsta.getValue().toString())<=0))
				{
					err=true;
					err_varsta=true;
					err_desc+="\nV�rst� invalid�";
					spinner_Varsta.setBackground(c_err);
				}
				
				if(!emailValid(txt_Email.getText()))
				{
					err=true;
					err_email=true;
					err_desc+="\nE-mail invalid";
					txt_Email.setBackground(c_err);
				}
				
				if(!CVCValid(txt_CVC.getText()))
				{
					err=true;
					err_CVC=true;
					err_desc+="\nCod CVC invalid";
					txt_CVC.setBackground(c_err);
				}
				
				int[] date=new int[4];
				SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy");
				
				// data plecare
				String[] buf = form.format(dateTime_ExpirareCard.getValue()).split("/");
				date[0] = Integer.parseInt(buf[2]);

				if (buf[1].equals("Jan"))
					date[1] = 1;
				else if (buf[1].equals("Feb"))
					date[1] = 2;
				else if (buf[1].equals("Mar"))
					date[1] = 3;
				else if (buf[1].equals("Apr"))
					date[1] = 4;
				else if (buf[1].equals("May"))
					date[1] = 5;
				else if (buf[1].equals("Jun"))
					date[1] = 6;
				else if (buf[1].equals("Jul"))
					date[1] = 7;
				else if (buf[1].equals("Aug"))
					date[1] = 8;
				else if (buf[1].equals("Sep"))
					date[1] = 9;
				else if (buf[1].equals("Oct"))
					date[1] = 10;
				else if (buf[1].equals("Nov"))
					date[1] = 11;
				else if (buf[1].equals("Dec"))
					date[1] = 12;

				date[2] = Integer.parseInt(buf[5]);

				
				
				if(!dataExpirareValida(date))
				{
					err=true;
					err_dataExpirare=true;
					err_desc+="\nCard expirat";
					lbl_ErrData.setVisible(err_dataExpirare);
					dateTime_ExpirareCard.setBackground(c_err);
				}
				
				
				if(!nrCardContValid(txt_NrCard.getText(), radio_Card.isSelected()))
				{
					err=true;
					err_email=true;
					err_desc+="\nNum�r card eronat";
					txt_NrCard.setBackground(c_err);
				}
				
				if(!nrTelValid(txt_Telefon.getText()))
				{
					err=true;
					err_email=true;
					err_desc+="\nNum�r de telefon eronat";
					txt_Telefon.setBackground(c_err);
				}
				
				if(!sumaCashValida(txt_PlataCashSuma.getText()))
				{
					err=true;
					err_email=true;
					err_desc+="\nSum� eronat�";
					txt_PlataCashSuma.setBackground(c_err);
				}
				
				if(err==true)
				{
					JOptionPane.showMessageDialog(null, err_desc);
				}
			
			}
		});
		btn_RezervaLocul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_RezervaLocul.setBounds(202, 603, 133, 31);
		contentPane.add(btn_RezervaLocul);
		
		JButton btn_Iesire = new JButton("\u00CEnapoi");
		btn_Iesire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Iesire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Iesire.setBounds(10, 603, 133, 31);
		contentPane.add(btn_Iesire);
	}


//verifica daca numele pasagerului este valid (fiecare cuvant din nume, fara spatii)
protected boolean numeValid(String nume)
{
	if(nume==null || nume.length()==0) return false;
	
	for(int i=0;i<nume.length();i++)
	{
		if(i==0 && (nume.charAt(i)<'A' || nume.charAt(i)>'Z')) return false;
		if(i!=0 && (nume.charAt(i)<'a' || nume.charAt(i)>'z')) return false;
	}
	return true;
}

//verifica daca e-mail-ul dat este valid
protected boolean emailValid(String email)
{
	if(email==null || email.equals("")) return false;
	int at=0,dot=0;
	for(int i=0;i<email.length();i++)
	{
		if(email.charAt(i)=='@') at++;
		if(email.charAt(i)=='.') dot++;
		if(email.charAt(i)==' ') return false;
	}
	if(at!=1 || dot!=1) return false;
	
	return true;
}

//verifica daca este valid codul CVC dat
protected boolean CVCValid(String CVC)
{
	if(CVC==null || CVC.length()!=3) return false;
	for(int i=0;i<CVC.length();i++)
	{
		if(CVC.charAt(i)<'0' || CVC.charAt(i)>'9') return false;
	}
	
	return true;
}

//verifica daca este valid numarul cardului dat
protected boolean nrCardContValid(String nr, boolean card)
{
	boolean err=false;
	
	if(nr==null || nr=="") return false;
	if(card==true)
	{
		if(nr.length()!=16) return false;
		for(int i=0;i<nr.length();i++)
		{
			if(nr.charAt(i)<'0' || nr.charAt(i)>'9') return false;
		}
		
	}else {
		if(nr.length()!=24) return false;
		if(nr.charAt(0)<'A' || nr.charAt(0)>'Z' || nr.charAt(1)<'A' || nr.charAt(1)>'Z') return false;
		
		for(int i=0;i<nr.length();i++)
		{
			if(nr.charAt(i)<'0') err=true;
			if(nr.charAt(i)>'9' && nr.charAt(i)<'A') err=true;
			if(nr.charAt(i)>'Z') err=true;
			
		}
		
		//more checks should be implemented here (realistically)
	}
	return !err;
}

//verifica daca nu este expirat cardul dat
protected boolean dataExpirareValida(int[] dataExpirare)
{
	if(dataExpirare==null) return false;
	
	if(dataExpirare[0]<=0 || dataExpirare[0]>31) return false;
	if(dataExpirare[1]<=0 || dataExpirare[1]>12) return false;
	if(dataExpirare[2]<2020) return false;
	
	Calendar aux = Calendar.getInstance();
	
	if(dataExpirare[2]<aux.get(Calendar.YEAR)) return false;
	else if(dataExpirare[2]==aux.get(Calendar.YEAR) && dataExpirare[1]<aux.get(Calendar.MONTH)+1) return false;
	else if(dataExpirare[2]==aux.get(Calendar.YEAR) && dataExpirare[1]==(aux.get(Calendar.MONTH)+1) && dataExpirare[0]<aux.get(Calendar.DAY_OF_MONTH)) return false;
	
	return true;
}

//verifica daca suma inregistrata este valida
protected boolean sumaCashValida(String suma)
{
	boolean dot=false;
	double d_suma;
	if(suma==null || suma.equals("")) return false;
	
	for(int i=0;i<suma.length();i++)
	{
		if((suma.charAt(i)<'0' || suma.charAt(i)>'9') && suma.charAt(i)!='.') return false;
		if(suma.charAt(i)=='.') dot=true;
	}
	
	if(!dot) return false;
	d_suma = Double.parseDouble(suma);
	
	return true;
}

//verifica daca numarul de telefon dat este valid
protected boolean nrTelValid(String tel)
{
	if(tel == null || tel.length()!=10) return false;
	
	for(int i=0;i<tel.length();i++)
	{
		if(tel.charAt(i)<'0' || tel.charAt(i)>'9') return false;
	}
	
	return true;
}
}