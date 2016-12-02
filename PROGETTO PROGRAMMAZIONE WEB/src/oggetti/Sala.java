package oggetti;

public class Sala {
	
	private int numeroPosti;
	private String sala;
	
	public Sala(String s,int np){
		numeroPosti =np;
		sala=s;
	}
	
	
	public Sala(){}
	
	public String getSala(){
		return sala;
		}
	public int getNumPosti(){
		return numeroPosti;
		}

	public void setSala(String s){
		sala=s;
		}
	public void setNumPosti(int nP){
		 numeroPosti=nP;
		}
	
	public String toString() {
		return "Sala [numeroPosti=" + numeroPosti + ", sala=" + sala + "]";
	}

}
