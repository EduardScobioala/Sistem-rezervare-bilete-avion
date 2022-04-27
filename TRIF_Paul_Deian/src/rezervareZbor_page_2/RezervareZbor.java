package src.rezervareZbor_page_2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.DateTime;

import com.ibm.icu.util.Calendar;

public class RezervareZbor {
	String origine,destinatie, clasa, tipLoc;
	DateTime data_plecare, data_sosire;
	boolean retur;
	
	public RezervareZbor(String origine, String destinatie, String tipLoc, String clasa, DateTime data_plecare,boolean retur, DateTime data_sosire) {
		super();
		this.origine = origine;
		this.destinatie = destinatie;
		this.clasa = clasa;
		this.data_plecare = data_plecare;
		this.data_sosire = data_sosire;
		this.retur = retur;
		this.tipLoc = tipLoc;
	}
	
	@Override
	public String toString() {
		return "RezervareZbor [origine=" + origine + ", destinatie=" + destinatie + ", clasa=" + clasa
				+ ", data_plecare=" + data_plecare + ", data_sosire=" + data_sosire + ", retur=" + retur + "]";
	}

	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	public String getDestinatie() {
		return destinatie;
	}
	public void setDestinatie(String destinatie) {
		this.destinatie = destinatie;
	}
	public String getClasa() {
		return clasa;
	}
	public void setClasa(String clasa) {
		this.clasa = clasa;
	}
	public DateTime getData_plecare() {
		return data_plecare;
	}
	public void setData_plecare(DateTime data_plecare) {
		this.data_plecare = data_plecare;
	}
	public DateTime getData_sosire() {
		return data_sosire;
	}
	public void setData_sosire(DateTime data_sosire) {
		this.data_sosire = data_sosire;
	}
	public boolean isRetur() {
		return retur;
	}
	public void setRetur(boolean retur) {
		this.retur = retur;
	}
	
	
}
