package oggetti;

public class Film {
	
	private String titolo;
	private String genere;
	private String regista;
	private int durata;
	private String trailer;
	private String trama;
	private String immagine;
	
	
	public Film(String t,String g,String r ,int d,String tr,String ta,String i ){
		titolo =t;
		genere=g;
		regista = r;
		durata =d;
		trailer =tr;
		trama=ta;
		immagine=i;
	}
	
	public Film(){}
	
	public String getTitolo(){
		return titolo;
		}
	
	public String getRegista(){
		return regista;
		}
	
	public String getGenere(){
		return genere;
		}
	
	public int getDurata(){
		return durata;
		}
	
	public String getTrama(){
		return trama;
		}
	
	public String getTrailer(){
		return trailer;
		}
	
	public String getImmagine(){
		return immagine;
		}
	
	public  void setTitolo(String s){
		titolo=s;
		}
	
	public  void setRegista(String r){
		regista=r;
		}
	
	public  void  setGenere(String g){
		genere=g;
		}
	
	public  void  setDurata(int d){
		 durata=d;;
		}
	
	public  void setTrama(String ta){
		trama=ta;
		}
	
	public  void setTrailer(String tr){
		trailer=tr;
		}
	
	public  void  setImmagine(String i){
		immagine=i;
		}
	

	public String toString() {
		return "Film [titolo=" + titolo + ", genere=" + genere + ", regista=" + regista + ", durata=" + durata
				+ ", trailer=" + trailer + ", trama=" + trama + ", immagine=" + immagine + "]";
	}

	
	

	

}
