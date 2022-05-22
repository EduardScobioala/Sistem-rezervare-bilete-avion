package functionalities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RezervareZbor {
	private String origine;
	private String destinatie;
	private Date dataPlecare;
	private int nrBilete;
	private String tipLoc;
	private String clasa;
	private Date dataIntoarcere;
	boolean retur;

	public RezervareZbor(String origine, String destinatie, Date dataPlecare, int nrBilete, String tipLoc,
			String clasa, boolean retur, Date dataIntoarcere) {
		super();
		this.origine = origine;
		this.destinatie = destinatie;
		this.dataPlecare = dataPlecare;
		this.nrBilete = nrBilete;
		this.tipLoc = tipLoc;
		this.clasa = clasa;
		this.dataIntoarcere = dataIntoarcere;
		this.retur = retur;
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

	public Date getDataPlecare() {
		return dataPlecare;
	}

	public void setDataPlecare(Date dataPlecare) {
		this.dataPlecare = dataPlecare;
	}

	public int getNrBilete() {
		return nrBilete;
	}

	public void setNrBilete(int nrBilete) {
		this.nrBilete = nrBilete;
	}

	public String getTipLoc() {
		return tipLoc;
	}

	public void setTipLoc(String tipLoc) {
		this.tipLoc = tipLoc;
	}

	public String getClasa() {
		return clasa;
	}

	public void setClasa(String clasa) {
		this.clasa = clasa;
	}

	public Date getDataIntoarcere() {
		return dataIntoarcere;
	}

	public void setDataIntoarcere(Date data_intoarcere) {
		this.dataIntoarcere = data_intoarcere;
	}

	public boolean isRetur() {
		return retur;
	}

	public void setRetur(boolean retur) {
		this.retur = retur;
	}

	private String readFile(String path) throws IOException {
		byte[] data = Files.readAllBytes(Paths.get(path));
		return new String(data);
	}
	
	private List<CursaZbor> getData(String filename) {
		String jsonFileContent = null;

		try {
			jsonFileContent = readFile(filename);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		java.lang.reflect.Type curseZborListType = new TypeToken<ArrayList<CursaZbor>>() {
		}.getType();
		List<CursaZbor> _curseZbor = new Gson().fromJson(jsonFileContent, curseZborListType);

		return _curseZbor;
	}
	
	private boolean gotCursaLaData(CursaZbor cursaZbor, Date dateForChecking) {
		boolean flag = false;
		
		int[] zileOperare = cursaZbor.getZileOperare();

		LocalDate date = dateForChecking.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if (zileOperare[date.getDayOfWeek().getValue() - 1] == 1) flag = true;
		
		return flag;
	}
	
	private boolean meetRequirements(CursaZbor cursaZbor) {
		boolean flag = true;
		
		// verificare datele de pornire/sosire
		if (!cursaZbor.getAeroportPlecare().toLowerCase().equals(origine.toLowerCase())) flag = false;
		if (!cursaZbor.getAeroportSosire().toLowerCase().equals(destinatie.toLowerCase())) flag = false;
		// verificare existenta a rutei pentru o anumita data
		if (!gotCursaLaData(cursaZbor, dataPlecare)) flag = false;
		// verificare suficienta bilete pentru anumita clasa
		if (clasa.equals("Econom"))
			if(!(cursaZbor.getLocuriDisponibile()[0] >= cursaZbor.getLocuriRezervate()[0] + nrBilete)) flag = false;
		else if (clasa.equals("Business"))
			if(!(cursaZbor.getLocuriDisponibile()[1] >= cursaZbor.getLocuriRezervate()[1] + nrBilete)) flag = false;
		else
			if(!(cursaZbor.getLocuriDisponibile()[2] >= cursaZbor.getLocuriRezervate()[2] + nrBilete)) flag = false;
		
		return flag;
	}
	
	public List<CursaZbor> getCurseZborDisponibile(String filename) {
		List<CursaZbor> curseZborDisponibile = new ArrayList<CursaZbor>();
		List<CursaZbor> curseZbor = getData(filename);
		
		int index = -1;
		for(var cursa : curseZbor) {
			index++;
			if (meetRequirements(cursa)) curseZborDisponibile.add(cursa);
		}
		
		return curseZborDisponibile;
	}
}
