package src.vizualizareZbor_page_4;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.util.Calendar;

import src.rezervareZbor_page_2.RezervareZbor;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VizualizareZbor_page4_Main {

	protected Shell shell;
	private Text txt_OrasPlecare;
	private Text txt_OrasDestinatie;
	private Text txt_Durata;
	private Text txt_NrZbor;
	private Text txt_Nume;
	private Text txt_Prenume;
	private Text txt_Email;
	private Text txt_Telefon;
	private Text txt_NrCard;
	private Text txt_NumeTitular;
	
	boolean plata_cash=false;
	
	public VizualizareZbor_page4_Main(boolean plata_cash) {
		this.plata_cash=plata_cash;
	}
	
	public VizualizareZbor_page4_Main() {
	}
	
	RezervareZbor zbor = null;
	
	public VizualizareZbor_page4_Main(RezervareZbor zbor) {
		this.zbor=zbor;
	}

	private Text txt_CVC;
	private Text txt_PlataCashSuma;
	private Text txt_Pret;

	public static void main(String[] args) {
		try {
			VizualizareZbor_page4_Main window = new VizualizareZbor_page4_Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		
		//load selected flight details
		if(zbor==null) {
			boolean ok=false;
			JOptionPane.showMessageDialog(null, "Eroare încãrcare detalii zbor ales");
			shell.close();
		}
		else {
		txt_OrasPlecare.setText(zbor.getOrigine());
		txt_OrasDestinatie.setText(zbor.getDestinatie());
		txt_Durata.setText(""+zbor.getDurata());
		txt_Pret.setText(""+zbor.getPret());
		//dateTime_DataZbor.setData(zbor.getData());
		txt_NrZbor.setText(zbor.getNr());
		}
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(724, 681);
		shell.setText("SWT Application");
		
		Label lbl_RezervareTitlu = new Label(shell, SWT.NONE);
		lbl_RezervareTitlu.setText("Rezervare");
		lbl_RezervareTitlu.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lbl_RezervareTitlu.setBounds(261, 158, 128, 46);
		
		Label lbl_Nume = new Label(shell, SWT.NONE);
		lbl_Nume.setText("Nume:");
		lbl_Nume.setBounds(10, 222, 70, 20);
		
		txt_Nume = new Text(shell, SWT.BORDER);
		txt_Nume.setBounds(102, 219, 231, 26);
		
		Label lbl_Prenume = new Label(shell, SWT.NONE);
		lbl_Prenume.setText("Prenume:");
		lbl_Prenume.setBounds(10, 251, 70, 20);
		
		txt_Prenume = new Text(shell, SWT.BORDER);
		txt_Prenume.setBounds(102, 248, 231, 26);
		
		Label lbl_Email = new Label(shell, SWT.NONE);
		lbl_Email.setText("E-mail:");
		lbl_Email.setBounds(344, 219, 70, 20);
		
		txt_Email = new Text(shell, SWT.BORDER);
		txt_Email.setBounds(436, 216, 231, 26);
		
		Label lbl_Telefon = new Label(shell, SWT.NONE);
		lbl_Telefon.setText("Telefon:");
		lbl_Telefon.setBounds(344, 254, 70, 20);
		
		txt_Telefon = new Text(shell, SWT.BORDER);
		txt_Telefon.setBounds(436, 251, 231, 26);
		
		Label lbl_Varsta = new Label(shell, SWT.NONE);
		lbl_Varsta.setText("V\u00E2rst\u0103:");
		lbl_Varsta.setBounds(10, 291, 70, 20);
		
		Spinner spinner_Varsta = new Spinner(shell, SWT.BORDER);
		spinner_Varsta.setBounds(102, 288, 231, 26);
		
		Composite groupBox_PlataBanca = new Composite(shell, SWT.NONE);
		groupBox_PlataBanca.setBounds(10, 329, 404, 231);
		
		Label lbl_ModalitatePlata = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_ModalitatePlata.setBounds(10, 10, 128, 20);
		lbl_ModalitatePlata.setText("Modalitate plat\u0103:");
		
		Button radio_Card = new Button(groupBox_PlataBanca, SWT.RADIO);
		radio_Card.setBounds(144, 13, 70, 20);
		radio_Card.setText("Card");
		radio_Card.setSelection(true);
		
		Button radio_ViramentBancar = new Button(groupBox_PlataBanca, SWT.RADIO);
		radio_ViramentBancar.setBounds(222, 13, 133, 20);
		radio_ViramentBancar.setText("Virament bancar");
		
		txt_NrCard = new Text(groupBox_PlataBanca, SWT.BORDER);
		txt_NrCard.setBounds(102, 39, 231, 26);
		
		Label lbl_NrCard_sau_Cont = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_NrCard_sau_Cont.setBounds(10, 42, 86, 20);
		lbl_NrCard_sau_Cont.setText("Num\u0103r card:");
		
		Label lbl_DataExpirareCard = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_DataExpirareCard.setBounds(10, 75, 133, 20);
		lbl_DataExpirareCard.setText("Dat\u0103 expirare card:");
		
		DateTime dateTime_ExpirareCard = new DateTime(groupBox_PlataBanca, SWT.BORDER);
		dateTime_ExpirareCard.setBounds(157, 71, 176, 28);
		
		txt_NumeTitular = new Text(groupBox_PlataBanca, SWT.BORDER);
		txt_NumeTitular.setBounds(102, 113, 231, 26);
		
		Label lbl_NumeTitular = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_NumeTitular.setBounds(10, 116, 86, 20);
		lbl_NumeTitular.setText("Nume titular:");
		
		Label lbl_CodCVC = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_CodCVC.setBounds(10, 153, 86, 20);
		lbl_CodCVC.setText("Cod CVC:");
		
		txt_CVC = new Text(groupBox_PlataBanca, SWT.BORDER);
		txt_CVC.setBounds(102, 147, 231, 26);
		
		Composite groupBox_PlataCash = new Composite(shell, SWT.NONE);
		groupBox_PlataCash.setBounds(393, 377, 274, 79);
		
		Label lbl_PlataCashTitlu = new Label(groupBox_PlataCash, SWT.NONE);
		lbl_PlataCashTitlu.setText("Cash");
		lbl_PlataCashTitlu.setBounds(10, 10, 86, 20);
		
		Label lbl_PlataCashSuma = new Label(groupBox_PlataCash, SWT.NONE);
		lbl_PlataCashSuma.setText("Sum\u0103:");
		lbl_PlataCashSuma.setBounds(10, 38, 51, 20);
		
		txt_PlataCashSuma = new Text(groupBox_PlataCash, SWT.BORDER);
		txt_PlataCashSuma.setBounds(79, 35, 123, 26);
		
		Label lbl_RON = new Label(groupBox_PlataCash, SWT.NONE);
		lbl_RON.setText("RON");
		lbl_RON.setBounds(208, 38, 86, 20);

		groupBox_PlataBanca.setVisible(!plata_cash);
		
		Label lbl_ErrData = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_ErrData.setVisible(false);
		lbl_ErrData.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_ErrData.setBounds(339, 75, 70, 20);
		lbl_ErrData.setText("!");
		
		groupBox_PlataCash.setLocation(10,329);
		groupBox_PlataCash.setVisible(plata_cash);
		
		Composite groupBox_DetaliiZbor = new Composite(shell, SWT.NONE);
		groupBox_DetaliiZbor.setBounds(10, 10, 683, 154);
		
		Label lbl_OrasPlecare = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_OrasPlecare.setBounds(10, 57, 70, 20);
		lbl_OrasPlecare.setText("Plecare:");
		
		txt_OrasPlecare = new Text(groupBox_DetaliiZbor, SWT.BORDER);
		txt_OrasPlecare.setBounds(102, 54, 252, 26);
		txt_OrasPlecare.setEditable(false);
		
		Label lbl_DurataZbor = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_DurataZbor.setBounds(376, 57, 49, 20);
		lbl_DurataZbor.setText("Durat\u0103:");
		
		txt_Durata = new Text(groupBox_DetaliiZbor, SWT.BORDER);
		txt_Durata.setBounds(431, 54, 123, 26);
		txt_Durata.setEditable(false);
		
		Label lbl_DurataZbor_ore = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_DurataZbor_ore.setBounds(561, 57, 81, 20);
		lbl_DurataZbor_ore.setText("ore");
		
		DateTime dateTime_DataZbor = new DateTime(groupBox_DetaliiZbor, SWT.BORDER);
		dateTime_DataZbor.setBounds(431, 89, 123, 28);
		
		Label lbl_DataPlecare = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_DataPlecare.setBounds(376, 94, 45, 20);
		lbl_DataPlecare.setText("Dat\u0103:");
		
		txt_OrasDestinatie = new Text(groupBox_DetaliiZbor, SWT.BORDER);
		txt_OrasDestinatie.setBounds(102, 86, 252, 26);
		txt_OrasDestinatie.setEditable(false);
		
		txt_NrZbor = new Text(groupBox_DetaliiZbor, SWT.BORDER);
		txt_NrZbor.setBounds(102, 118, 252, 26);
		txt_NrZbor.setEditable(false);
		
		Label lbl_NrZbor = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_NrZbor.setBounds(10, 121, 81, 20);
		lbl_NrZbor.setText("Num\u0103r zbor:");
		
		Label lbl_OrasDestinatie = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_OrasDestinatie.setBounds(10, 89, 81, 20);
		lbl_OrasDestinatie.setText("Destina\u021Bie:");
		
		Label lbl_DetaliiZborTitlu = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_DetaliiZborTitlu.setBounds(249, 0, 151, 46);
		lbl_DetaliiZborTitlu.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lbl_DetaliiZborTitlu.setText("Detalii zbor");
		
		Label lbl_Pret = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_Pret.setText("Pre\u021B:");
		lbl_Pret.setBounds(376, 124, 49, 20);
		
		txt_Pret = new Text(groupBox_DetaliiZbor, SWT.BORDER);
		txt_Pret.setEditable(false);
		txt_Pret.setBounds(431, 121, 123, 26);
		
		Label lbl_RON_ReadOnly = new Label(groupBox_DetaliiZbor, SWT.NONE);
		lbl_RON_ReadOnly.setText("RON");
		lbl_RON_ReadOnly.setBounds(561, 124, 81, 20);
		
		Button btn_RezervaLocul = new Button(shell, SWT.NONE);
		btn_RezervaLocul.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
				
				//functii de verificare
				if(!numeValid(txt_Nume.getText()))
				{
					err=true;
					err_nume=true;
					err_desc+="\nNume invalid";
					txt_Nume.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!numeValid(txt_Prenume.getText()))
				{
					err=true;
					err_prenume=true;
					err_desc+="\nPrenume invalid";
					txt_Prenume.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				data = txt_NumeTitular.getText().split(" ");
				for(int i=0;i<data.length;i++)
				{
					if(!numeValid(data[i])) {
						err=true;
						err_NumeTitular=true;
						err_desc+="\nNume titular invalid";
						txt_NumeTitular.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
						break;
					}
				}
				
				if(spinner_Varsta.getText().isEmpty() || (!spinner_Varsta.getText().isEmpty() && spinner_Varsta.getSelection()<=0))
				{
					err=true;
					err_varsta=true;
					err_desc+="\nVârstã invalidã";
					spinner_Varsta.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!emailValid(txt_Email.getText()))
				{
					err=true;
					err_email=true;
					err_desc+="\nE-mail invalid";
					txt_Email.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!CVCValid(txt_CVC.getText()))
				{
					err=true;
					err_CVC=true;
					err_desc+="\nCod CVC invalid";
					txt_CVC.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!dataExpirareValida(dateTime_ExpirareCard))
				{
					err=true;
					err_dataExpirare=true;
					err_desc+="\nCard expirat";
					lbl_ErrData.setVisible(err_dataExpirare);
					dateTime_ExpirareCard.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121)); //does not seem to work
				}
				
				
				if(!nrCardContValid(txt_NrCard.getText(), radio_Card.getSelection()))
				{
					err=true;
					err_email=true;
					err_desc+="\nNumãr card eronat";
					txt_NrCard.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!nrTelValid(txt_Telefon.getText()))
				{
					err=true;
					err_email=true;
					err_desc+="\nNumãr de telefon eronat";
					txt_Telefon.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!sumaCashValida(txt_PlataCashSuma.getText()))
				{
					err=true;
					err_email=true;
					err_desc+="\nSumã eronatã";
					txt_PlataCashSuma.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(err==true)
				{
					JOptionPane.showMessageDialog(null, err_desc);
				}
			}
		});
		btn_RezervaLocul.setBounds(281, 597, 133, 30);
		btn_RezervaLocul.setText("Rezerv\u0103 locul");
		
		Button btn_Iesire = new Button(shell, SWT.NONE);
		btn_Iesire.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close(); //dev: to implement more here
			}
		});
		btn_Iesire.setText("\u00CEnapoi");
		btn_Iesire.setBounds(10, 597, 133, 30);
		
		
		if(zbor!=null) dateTime_DataZbor.setData(zbor.getData_plecare()); //control not found at 'open' method level
		else {
			lbl_DetaliiZborTitlu.setText("Zbor negãsit");
			lbl_DetaliiZborTitlu.setForeground(new org.eclipse.swt.graphics.Color(210, 121, 121));
			
		}
	}
	
	private boolean numeValid(String nume)
	{
		if(nume.length()==0) return false;
		
		for(int i=0;i<nume.length();i++)
		{
			if(i==0 && (nume.charAt(i)<'A' || nume.charAt(i)>'Z')) return false;
			if(i!=0 && (nume.charAt(i)<'a' || nume.charAt(i)>'z')) return false;
		}
		return true;
	}
	
	private boolean emailValid(String email)
	{
		int at=0,dot=0;
		for(int i=0;i<email.length();i++)
		{
			if(email.charAt(i)=='@') at++;
			if(email.charAt(i)=='.') dot++;
		}
		if(at!=1 || dot!=1) return false;
		
		return true;
	}
	
	private boolean CVCValid(String CVC)
	{
		if(CVC.length()!=3) return false;
		for(int i=0;i<CVC.length();i++)
		{
			if(CVC.charAt(i)<'0' || CVC.charAt(i)>'9') return false;
		}
		
		return true;
	}
	
	private boolean nrCardContValid(String nr, boolean card)
	{
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
			//more checks should be implemented here
		}
		
		return true;
	}
	
	private boolean dataExpirareValida(DateTime dataExpirare)
	{
		Calendar aux = Calendar.getInstance();
		if(dataExpirare.getYear()<aux.get(Calendar.YEAR)) return false;
		if(dataExpirare.getMonth()<aux.get(Calendar.MONTH)) return false;
		if(dataExpirare.getDay()<aux.get(Calendar.DAY_OF_MONTH)) return false;
		
		return true;
	}
	
	private boolean sumaCashValida(String suma)
	{
		double d_suma;
		if(suma.equals("")) return false;
		
		for(int i=0;i<suma.length();i++)
		{
			if((suma.charAt(i)<'0' || suma.charAt(i)>'9') && suma.charAt(i)!='.') return false;
		}
		
		d_suma = Double.parseDouble(suma);
		
		if(d_suma<0) return false; //maybe even implement a maximum sum ?
		
		return true;
	}
	
	private boolean nrTelValid(String tel)
	{
		if(tel.length()!=10) return false;
		
		for(int i=0;i<tel.length();i++)
		{
			if(tel.charAt(i)<'0' || tel.charAt(i)>'9') return false;
		}
		
		return true;
	}
}