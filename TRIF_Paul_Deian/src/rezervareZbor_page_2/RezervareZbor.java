package src.rezervareZbor_page_2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.DateTime;

import com.ibm.icu.util.Calendar;

public class RezervareZbor {
	String origine,destinatie, clasa, tipLoc, nr;
	DateTime data_plecare, data_intoarcere;
	boolean retur;
	double pret, durata;
	
	public RezervareZbor(String origine, String destinatie, String tipLoc, String clasa, DateTime data_plecare,boolean retur, DateTime data_intoarcere, double pret, double durata, String nr) {
		super();
		this.origine = origine;
		this.destinatie = destinatie;
		this.clasa = clasa;
		this.data_plecare = data_plecare;
		this.data_intoarcere = data_intoarcere;
		this.retur = retur;
		this.tipLoc = tipLoc;
		this.durata=durata;
		this.nr=nr;
	}
	
	@Override
	public String toString() {
		return "RezervareZbor [origine=" + origine + ", destinatie=" + destinatie + ", clasa=" + clasa
				+ ", data_plecare=" + data_plecare + ", data_sosire=" + data_intoarcere + ", retur=" + retur + "]";
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
	public DateTime getData_intoarcere() {
		return data_intoarcere;
	}
	public void setData_intoarcere(DateTime data_intoarcere) {
		this.data_intoarcere = data_intoarcere;
	}
	public boolean isRetur() {
		return retur;
	}
	public void setRetur(boolean retur) {
		this.retur = retur;
	}
	
	public void setPret(double pret) {
		this.pret = pret;
	}
	
	public double getPret() {
		return this.pret;
	}
	
	public void setNr(String nr) {
		this.nr = nr;
	}
	
	public String getNr() {
		return this.nr;
	}
	
	public void setDurata(double durata)
	{
		this.durata=durata;
	}
	
	public double getDurata()
	{	
		return this.durata;
	}
	
}
