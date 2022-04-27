package src.vizualizareZbor_page_4;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Composite;

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

	private Text txt_CVC;
	private Text txt_PlataCashSuma;

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
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(724, 622);
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
		
		Button btn_RezervaLocul = new Button(shell, SWT.NONE);
		btn_RezervaLocul.setBounds(561, 513, 133, 30);
		btn_RezervaLocul.setText("Rezerv\u0103 locul");
		
		Composite groupBox_PlataBanca = new Composite(shell, SWT.NONE);
		groupBox_PlataBanca.setBounds(10, 329, 404, 231);
		
		Label lbl_ModalitatePlata = new Label(groupBox_PlataBanca, SWT.NONE);
		lbl_ModalitatePlata.setBounds(10, 10, 128, 20);
		lbl_ModalitatePlata.setText("Modalitate plat\u0103:");
		
		Button radio_Card = new Button(groupBox_PlataBanca, SWT.RADIO);
		radio_Card.setBounds(144, 13, 70, 20);
		radio_Card.setText("Card");
		
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
		

	}
}