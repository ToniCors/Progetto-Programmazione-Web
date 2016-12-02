package oggetti;



public class Ubicazione {
	
	private String sala;
	private int proiezione;
	
	public Ubicazione(String s, int p){
		sala =s;
		proiezione=p;
	}
	
	public Ubicazione(){}
	
	
	public String getSala(){
		return sala;
	}
	
	public int getProiezione(){
		return proiezione;
	}
	
	public void setSala(String s){
		sala =s;
	}
	
	public void setProiezione(int p){
		proiezione =p;
	}

	
	public String toString() {
		return "Ubicazione [sala=" + sala + ", proiezione=" + proiezione + "]";
	}
	
	

}
