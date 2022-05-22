package functionalities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ManagementCurseZbor {

	private List<CursaZbor> curseZbor;
	
	public ManagementCurseZbor() {
		curseZbor = getPreviousData();
	}

	public ManagementCurseZbor(String numeCompanie, String aeroportPlecare, String aeroportSosire, String oraPlecare, String oraSosire,
			int[] zileOperare, float[] pretClase, int[] locuriDisponibile, int[] locuriRezervate, String codCursa, String tipAvion, boolean discountDusIntors,
			boolean discountLastMinute) {
		// get the previous Data
		curseZbor = getPreviousData();
		
		// add the new Data
		curseZbor.add(new CursaZbor(numeCompanie, aeroportPlecare, aeroportSosire, oraPlecare, oraSosire,
			zileOperare, pretClase, locuriDisponibile, locuriRezervate, codCursa, tipAvion, discountDusIntors, discountLastMinute));
	}
	
	private String readFile(String path) throws IOException {
		byte[] data = Files.readAllBytes(Paths.get(path));
		return new String(data);
	}
	
	private List<CursaZbor> getPreviousData() {
		String jsonFileContent = null;

		try {
			jsonFileContent = readFile("curseZbor.json");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		java.lang.reflect.Type curseZborListType = new TypeToken<ArrayList<CursaZbor>>() {
		}.getType();
		List<CursaZbor> _curseZbor = new Gson().fromJson(jsonFileContent, curseZborListType);

		return _curseZbor;
	}
	
	public void saveCursaZbor() throws IOException {
		// Save Data to file
		BufferedWriter writer = new BufferedWriter(new FileWriter("curseZbor.json"));
		writer.write(new Gson().toJson(curseZbor));

		writer.close();
	}
	
	public CursaZbor findCursa(String codCursa) {
		CursaZbor cursaZbor = null;
		
		for(var cursa : curseZbor)
			if (cursa.getCodCursa().equals(codCursa)) {
				cursaZbor = cursa;
				break;
			}
		
		return cursaZbor;
	}
	
	public void actualizareCurseZbor(String codCursa, CursaZbor cursaZbor) {
		int index = -1;
		for(var cursa : curseZbor) {
			index++;
			if (cursa.getCodCursa().equals(codCursa)) {
				cursa = cursaZbor;
				break;
			}
		}
		
		// Update with the new cursaZbor
		curseZbor.set(index, cursaZbor);
		
		try {
			saveCursaZbor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
