package src.rezervareZbor_page_2;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.eclipse.swt.widgets.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import src.cautareZbor_page_3.CautareZbor_page3_Main;
import src.vizualizareZbor_page_4.VizualizareZbor_page4_Main;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;

public class RezervareZbor_page2_Main {

	protected Shell shell;
	private Text txt_OrasPlecare;
	private Text txt_OrasDestinatie;
	boolean plata_cash=false;
	
	public static void main(String[] args) {
		try {
			RezervareZbor_page2_Main window = new RezervareZbor_page2_Main();
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


	//functii utilitare
	
	protected boolean numeOrasValid(String oras)
	{
		java.util.List<String> orase = new ArrayList<String>();
		BufferedReader read = null;
		boolean gasit=false;
		
		try {
			read = new BufferedReader(new InputStreamReader(new FileInputStream("orase.txt")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String buf;
		
		try {
			while((buf=read.readLine())!=null)
			{
				orase.add(buf);
				if(buf.equals(oras)) gasit=true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(oras.equals("")) return false;
		
		return gasit;
	}
	
	protected boolean dateValide(DateTime data1, DateTime data2)
	{
		if(data1.getYear()>data2.getYear()) return false;
		else if(data1.getMonth()>data2.getMonth()) return false;
		else if(data1.getDay()>data2.getDay()) return false;
		
		return true;
	}
	RezervareZbor rezervare=null;
	RezervareZbor zbor = null;
	//contents & event handlers
	protected void createContents() {
		shell = new Shell();
		shell.setSize(842, 459);
		shell.setText("SWT Application");
		
		Label lbl_OrasPlecare = new Label(shell, SWT.NONE);
		lbl_OrasPlecare.setBounds(10, 10, 120, 20);
		lbl_OrasPlecare.setText("Ora\u0219 de plecare:");
		
		Label lbl_OrasSosire = new Label(shell, SWT.NONE);
		lbl_OrasSosire.setText("Ora\u0219 de sosire:");
		lbl_OrasSosire.setBounds(10, 48, 120, 20);
		
		Label lbl_DataPlecarii = new Label(shell, SWT.NONE);
		lbl_DataPlecarii.setText("Data plec\u0103rii:");
		lbl_DataPlecarii.setBounds(10, 93, 120, 20);
		
		Label lbl_TipLoc = new Label(shell, SWT.NONE);
		lbl_TipLoc.setText("Tipul locului:");
		lbl_TipLoc.setBounds(10, 144, 120, 20);
		
		Label lbl_ZborRetur = new Label(shell, SWT.NONE);
		lbl_ZborRetur.setText("Zbor dus-\u00EEntors:");
		lbl_ZborRetur.setBounds(10, 204, 120, 20);
		
		Label lbl_DataIntoarcere = new Label(shell, SWT.NONE);
		lbl_DataIntoarcere.setText("Data \u00EEntoarcerii:");
		lbl_DataIntoarcere.setBounds(217, 204, 120, 20);
		
		Label lbl_Clasa = new Label(shell, SWT.NONE);
		lbl_Clasa.setText("Clasa la care se dore\u0219te rezervarea:");
		lbl_Clasa.setBounds(10, 264, 237, 20);
		
		Label lbl_ListaLocuri = new Label(shell, SWT.NONE);
		lbl_ListaLocuri.setText("Listă locuri");
		lbl_ListaLocuri.setBounds(605, 10, 76, 20);
		
		txt_OrasPlecare = new Text(shell, SWT.BORDER);
		txt_OrasPlecare.setBounds(131, 10, 135, 26);
		
		txt_OrasDestinatie = new Text(shell, SWT.BORDER);
		txt_OrasDestinatie.setBounds(131, 45, 135, 26);
		
		Combo combo_TipLoc = new Combo(shell, SWT.NONE);
		combo_TipLoc.setItems(new String[] {});
		combo_TipLoc.setBounds(136, 141, 130, 28);
		
		Combo combo_Clasa = new Combo(shell, SWT.NONE);
		combo_Clasa.setBounds(253, 261, 130, 28);
		
		DateTime dateTime_DataIntoarcerii = new DateTime(shell, SWT.BORDER);
		dateTime_DataIntoarcerii.setBounds(344, 196, 96, 28);
		
		DateTime dateTime_DataPlecarii = new DateTime(shell, SWT.BORDER);
		dateTime_DataPlecarii.setBounds(131, 85, 135, 28);
		
		Button chk_ZborRetur = new Button(shell, SWT.CHECK);
		chk_ZborRetur.setBounds(136, 204, 49, 20);
		chk_ZborRetur.setText("Da");
		
		List lst_LocuriDisponibile = new List(shell, SWT.BORDER);
		lst_LocuriDisponibile.setBounds(496, 44, 316, 354);
		
		Button btn_RezervareLoc = new Button(shell, SWT.NONE);
		btn_RezervareLoc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(lst_LocuriDisponibile.getItemCount()==0 || lst_LocuriDisponibile.getSelection()[lst_LocuriDisponibile.getSelectionIndex()-1].equals(""))
				{
					JOptionPane.showMessageDialog(null, "Alegeți un loc");
				}else if(rezervare==null){
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				}				
				else {
					CautareZbor_page3_Main CautareZbor = new CautareZbor_page3_Main(rezervare);
					zbor = CautareZbor.open();
					
					VizualizareZbor_page4_Main VizualizareZbor = new VizualizareZbor_page4_Main(zbor, plata_cash);
					VizualizareZbor.open();

				}
			}
		});
		btn_RezervareLoc.setBounds(10, 368, 120, 30);
		btn_RezervareLoc.setText("Rezervare loc");
		
		Button btn_CautareZbor = new Button(shell, SWT.NONE);
		btn_CautareZbor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				boolean err_plecare=false;
				boolean err_destinatie=false;
				boolean err_date=false;
				boolean err_retur=false;
				boolean err_tipLoc=false;
				boolean err_clasa=false;
				boolean err=false;
				
				Color c_err;
				
				//functii de verificare
				if(!numeOrasValid(txt_OrasPlecare.getText()))
				{
					err=true;
					err_plecare=true;
					
					txt_OrasPlecare.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}

				if(!numeOrasValid(txt_OrasDestinatie.getText()))
				{
					err=true;
					err_destinatie=true;
					
					txt_OrasDestinatie.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!dateValide(dateTime_DataPlecarii, dateTime_DataIntoarcerii))
				{
					err=true;
					err_date=true;
					
					dateTime_DataPlecarii.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
					dateTime_DataIntoarcerii.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(combo_TipLoc.getText().equals(""))
				{
					err=true;
					err_tipLoc=true;
					
					combo_TipLoc.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(combo_Clasa.getText().equals(""))
				{
					err=true;
					err_clasa=true;
					
					combo_Clasa.setBackground(new org.eclipse.swt.graphics.Color(210, 121, 121));
				}
				
				if(!err) {
					rezervare = new RezervareZbor(
							txt_OrasPlecare.getText(),
							txt_OrasDestinatie.getText(),
							combo_TipLoc.getText(),
							combo_Clasa.getText(),
							dateTime_DataPlecarii,
							chk_ZborRetur.getSelection(),
							dateTime_DataIntoarcerii,
							0,  //price is 0 for the searched flight; or it could be the maximum/minimum price desired; will be replaced with actual price 
							0, //duration will be replaced with actual flight duration at search
							"N/A" //flight no. will be replaced with actual flight no. at search
							);
				}else {
					JOptionPane.showMessageDialog(null, "Date zbor incorecte");
				}
			}
		});
		btn_CautareZbor.setText("C\u0103utare zbor");
		btn_CautareZbor.setBounds(370, 368, 120, 30);
	}
}