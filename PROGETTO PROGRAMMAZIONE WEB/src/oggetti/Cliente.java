package oggetti;


import java.util.GregorianCalendar;

public class Cliente {
	
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;	
	private String sesso;
	private String cellulare;
	private GregorianCalendar dataNascita;
	
	public Cliente(String n,String c,String us,String s,String p,String e,String cell,GregorianCalendar d){
		nome = n ;
		cognome = c;
		sesso=s;
		password = p;
		email=e;		
		cellulare = cell;
		dataNascita = d;
		username = us;
		
	}
	
	public Cliente(){}
	
	public String getNome(){
		return nome;
		}
	public String getCognome(){
		return cognome;
		}
	public String getSesso(){
		return sesso;
		}
	public String getPassword(){
		return password;
		}
	public String getEmail(){
		return email;
		}
	public String getUsername(){
		return username;
		}
	
	public String getCellulare(){
		return cellulare;
		}
	public GregorianCalendar getDataNascita(){
		return dataNascita;
		}
	public String getDataNascitaStr(){
		return ""+dataNascita.get(GregorianCalendar.YEAR)+"-"+
			dataNascita.get(GregorianCalendar.MONTH)+"-"+
            dataNascita.get(GregorianCalendar.DAY_OF_MONTH)
	                       ;}
	public void setNome(String n){
		nome=n;
		}
	public void setCognome(String c){
		 cognome=c;
		}
	public void setSesso(String s){
		sesso=s;
		}
	public void setPassword(String pas){
		password=pas;
		}
	public void setEmail(String emm){
		email=emm;
		}
	public void setUsername(String usr){
		username=usr;
		}

	public void setCellulare(String c){
	 cellulare=c;
		}
	public void setDataNascita(String dt){
		 String[] g = dt.split("-");	     
	        int aa=Integer.parseInt(g[0]);
			int mm=Integer.parseInt(g[1]);
			int gg=Integer.parseInt(g[2]);
			
		GregorianCalendar	data=new GregorianCalendar(aa,mm,gg);
		 this.setDataNascita(data);
		}
	
	public void setDataNascita(GregorianCalendar dt){				
		 dataNascita=dt;
		}
	
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", sesso=" + sesso + ", cellulare=" + cellulare + ", dataNascita=" + this.getDataNascitaStr()
				+ "]";
	}
	
	
	
	}










