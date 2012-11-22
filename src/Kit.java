import java.util.ArrayList;

public class Kit {
	
	private ArrayList<Aktor> aktorList;
	
	public Kit() {
		this.aktorList = new ArrayList<Aktor>();
	}
	
	public PowerClass getPowerClass() {
		double summe = 0;
		
		for(Aktor temp : this.aktorList) {
			summe += temp.getkW();
		}
		
		return PowerClass.getPowerClass(summe);
	}
	
	public void addAktor(Aktor temp) {
		this.aktorList.add(temp);
	}
	
}
