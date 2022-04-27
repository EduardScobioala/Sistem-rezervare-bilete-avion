package src.cautareZbor_page_3;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import src.rezervareZbor_page_2.RezervareZbor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CautareZbor_page3_Main {

	protected Shell shell;
	RezervareZbor rezervare;
	
	public CautareZbor_page3_Main(RezervareZbor rezervare) {
		this.rezervare=rezervare;
	}
		
	public CautareZbor_page3_Main() {
		
	}
	
	public static void main(String[] args) {
		try {
			CautareZbor_page3_Main window = new CautareZbor_page3_Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	RezervareZbor ZborAles = null;
	
	public RezervareZbor open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		return ZborAles;
	}
	
	protected void createContents() {
		shell = new Shell();
		shell.setSize(555, 383);
		shell.setText("SWT Application");
		
		//dev: need to implement search for flight and add compatible flights to lst_ZboruriDisponibile here;
		//also need to implement a structure of type RezervareZbor[] or similar to store all the details of each flight
		/*
		for(;;)
		{
		lst_ZboruriDisponibile.add(null);
		}
		*/
		
		List lst_ZboruriDisponibile = new List(shell, SWT.BORDER);
		lst_ZboruriDisponibile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String aux;
				
				aux = lst_ZboruriDisponibile.getSelection()[lst_ZboruriDisponibile.getSelectionIndex()-1];
				
				//dev: to parse the above-mentioned RezervareZbor[] structure and find the selected flight - aux - and return the details of that flight in
				//the variable 'ZborAles'
				/*
				 for(;;)
				 {
				 
				 }
				 */
				
				shell.close();
			}
		});
		lst_ZboruriDisponibile.setBounds(10, 63, 515, 265);
		
		Label lbl_ZboruriDisponibile = new Label(shell, SWT.NONE);
		lbl_ZboruriDisponibile.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lbl_ZboruriDisponibile.setBounds(138, 10, 241, 43);
		lbl_ZboruriDisponibile.setText("Zboruri disponibile");
		
	}
	
}