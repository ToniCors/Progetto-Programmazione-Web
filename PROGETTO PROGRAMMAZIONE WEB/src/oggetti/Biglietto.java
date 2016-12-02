package oggetti;

import java.util.GregorianCalendar;

public class Biglietto {	
	
	
	private String idBiglietto;
	private GregorianCalendar dataOra;
	private double prezzoFinale;
	private int posto;
	private String cliente;
	private int proiezione;
	
	
  public Biglietto (int pr, int p, String c,double pf,  GregorianCalendar dp){
	  dataOra =dp;
	  prezzoFinale=pf;
	  posto=p;
	  cliente=c;
	  proiezione=pr;	
	  idBiglietto=pr+"-"+p;
	}
  
public Biglietto (int pr, int p, String c,double pf, int gg,int mm,int aa,int hh,int min){
	  dataOra =new GregorianCalendar(aa, mm, gg, hh, min);
	  prezzoFinale=pf;
	  posto=p;
	  cliente=c;
	  proiezione=pr;	
	  idBiglietto=pr+"-"+p;
	}
  
  public Biglietto(){}
  
  public double getPrezzoFinale(){
	  return prezzoFinale;
	  
  }
  
  public int getPosto(){
	  return posto;
  }
  
  public String getCliente(){
	  return cliente;
  }
  
  public String getBiglietto(){
	  return idBiglietto;
  }
  
  public int getProiezione(){
	  return proiezione;
  }
  
  
  public GregorianCalendar getDataOraAcquisto(){
		return dataOra;
		}
  
  
	public String getDataOraAcquistoStr(){
		return ""+dataOra.get(GregorianCalendar.YEAR)+"-"+
				dataOra.get(GregorianCalendar.MONTH)+"-"+
				dataOra.get(GregorianCalendar.DAY_OF_MONTH)+" "+
				dataOra.get(GregorianCalendar.HOUR_OF_DAY)+":"+
				dataOra.get(GregorianCalendar.MINUTE)
	                       ;}
	
	public String getDataAcquistoStr(){
		return ""+dataOra.get(GregorianCalendar.YEAR)+"-"+
				dataOra.get(GregorianCalendar.MONTH)+"-"+
				dataOra.get(GregorianCalendar.DAY_OF_MONTH)
	                       ;}
	
	public String getOraAcquistoStr(){
		return ""+dataOra.get(GregorianCalendar.HOUR_OF_DAY)+":"+
				dataOra.get(GregorianCalendar.MINUTE)
	                       ;}
	
	public void setPrezzoFinale(double pr){
		  prezzoFinale = pr;
		  
	  }
	  
	  public void setPosto( int po){
		  posto=po;
	  }
	  
	  public void setCliente(String c){
		 cliente=c;
	  }
	  
	  public void setBiglietto(String id){
			 idBiglietto=id;
		  }
	  
	  public void setProiezione(int pr){
		  proiezione=pr;
	  }
	  
	  public void setDataOra(String dt, String ora){
		  
		  String[] g = dt.split("-");
		     
	        int aa=Integer.parseInt(g[0]);
			int mm=Integer.parseInt(g[1]);
			int gg=Integer.parseInt(g[2]);
		  
			 String[] o = ora.split(":");
		     
		    int hh=Integer.parseInt(o[0]);
			int min=Integer.parseInt(o[1]);
				
			GregorianCalendar	data=new GregorianCalendar(aa,mm,gg,hh,min);
			 this.setDataOraAcquisto(data);
			}
		
		public void setDataOraAcquisto(GregorianCalendar dt){				
			 dataOra=dt;
			}

		
		public String toString() {
			return "Biglietto [idBiglietto=" + idBiglietto + ", dataOra=" +  this.getDataOraAcquistoStr()  + ", prezzoFinale=" + prezzoFinale
					+ ", posto=" + posto + ", cliente=" + cliente + ", proiezione=" + proiezione + "]";
		}
		
		
	  

}
