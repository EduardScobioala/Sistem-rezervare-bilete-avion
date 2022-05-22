package functionalities;

public class CursaZbor {

	private String numeCompanie;
	private String aeroportPlecare;
	private String aeroportSosire;
	private String oraPlecare;
	private String oraSosire;
	private int[] zileOperare;
	private int[] locuriDisponibile;
	private int[] locuriRezervate;
	private float[] pretClase;
	private String codCursa;
	private String tipAvion;
	private boolean discountDusIntors;
	private boolean discountLastMinute;
	
	public CursaZbor(String numeCompanie, String aeroportPlecare, String aeroportSosire, String oraPlecare, String oraSosire,
			int[] zileOperare, float[] pretClase, int[] locuriDisponibile, int[] locuriRezervate, String codCursa, String tipAvion, boolean discountDusIntors,
			boolean discountLastMinute) {
		this.numeCompanie = numeCompanie;
		this.aeroportPlecare = aeroportPlecare;
		this.aeroportSosire = aeroportSosire;
		this.oraPlecare = oraPlecare;
		this.oraSosire = oraSosire;
		this.zileOperare = zileOperare;
		this.pretClase = pretClase;
		this.locuriDisponibile = locuriDisponibile;
		this.locuriRezervate = locuriRezervate;
		this.codCursa = codCursa;
		this.tipAvion = tipAvion;
		this.discountDusIntors = discountDusIntors;
		this.discountLastMinute = discountLastMinute;
	}

	public String getNumeCompanie() {
		return numeCompanie;
	}

	public void setNumeCompanie(String numeCompanie) {
		this.numeCompanie = numeCompanie;
	}

	public String getAeroportPlecare() {
		return aeroportPlecare;
	}

	public void setAeroportPlecare(String aeroportPlecare) {
		this.aeroportPlecare = aeroportPlecare;
	}

	public String getAeroportSosire() {
		return aeroportSosire;
	}

	public void setAeroportSosire(String aeroportSosire) {
		this.aeroportSosire = aeroportSosire;
	}

	public String getOraPlecare() {
		return oraPlecare;
	}

	public void setOraPlecare(String oraPlecare) {
		this.oraPlecare = oraPlecare;
	}

	public String getOraSosire() {
		return oraSosire;
	}

	public void setOraSosire(String oraSosire) {
		this.oraSosire = oraSosire;
	}

	public int[] getZileOperare() {
		return zileOperare;
	}

	public void setZileOperare(int[] zileDeOperare) {
		this.zileOperare = zileDeOperare;
	}

	public float[] getPretClase() {
		return pretClase;
	}

	public void setPretClase(float[] pretClase) {
		this.pretClase = pretClase;
	}
	
	public int[] getLocuriDisponibile() {
		return locuriDisponibile;
	}

	public void setLocuriDisponibile(int[] locuriDisponibile) {
		this.locuriDisponibile = locuriDisponibile;
	}

	public int[] getLocuriRezervate() {
		return locuriRezervate;
	}

	public void setLocuriRezervate(int[] locuriRezervate) {
		this.locuriRezervate = locuriRezervate;
	}
	
	public String getCodCursa() {
		return codCursa;
	}

	public void setCodCursa(String codCursa) {
		this.codCursa = codCursa;
	}

	public String getTipAvion() {
		return tipAvion;
	}

	public void setTipAvion(String tipAvion) {
		this.tipAvion = tipAvion;
	}

	public boolean isDiscountDusIntors() {
		return discountDusIntors;
	}

	public void setDiscountDusIntors(boolean discountDusIntors) {
		this.discountDusIntors = discountDusIntors;
	}

	public boolean isDiscountLastMinute() {
		return discountLastMinute;
	}

	public void setDiscountLastMinute(boolean discountLastMinute) {
		this.discountLastMinute = discountLastMinute;
	}
}
