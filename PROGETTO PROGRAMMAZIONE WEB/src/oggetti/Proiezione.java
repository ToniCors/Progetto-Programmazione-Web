package oggetti;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Proiezione {
	
	private String idProiezione;
	private String film;
	private double prezzoBase;
	private int fasciaOraria;
	private boolean _3d;
	private GregorianCalendar data;
	
	
	
	public Proiezione(String id,double pb,int fo,boolean ddd,String f,GregorianCalendar d){
		idProiezione=id;
		prezzoBase =pb;
		fasciaOraria =fo;
		_3d =ddd;
		film =f;	
		data=d;
	}

	
public Proiezione(String id,double pb,int fo,boolean ddd,String f,int gg,int mm,int aa){
		idProiezione=id;
		prezzoBase =pb;
		fasciaOraria =fo;
		_3d =ddd;
		film =f;	
		data=new GregorianCalendar(aa, mm, gg);
	}
	
	public Proiezione(){}
	
	public double getPrezzoBase(){
		return prezzoBase;
	}
	
	public String getIdProiezione(){
		return idProiezione;
	}
	
	public int getFasciaOraria(){
		return fasciaOraria;
	}
	
	public String getFasciaOrariaStr(){
		if(fasciaOraria == 1)
			return "(16-18)";
		else if(fasciaOraria == 2)
						return "(19-21)";
		else
			return "(22-24)";
	}
	public boolean is3D(){
		return _3d;
	}
	
	public String getFilm(){
		return film;
	}
	

	public GregorianCalendar getData(){
		return data;}
	
	public String getDataStr(){
				
		return ""+data.get(GregorianCalendar.YEAR)+"-"+
			data.get(GregorianCalendar.MONTH)+"-"+
            data.get(GregorianCalendar.DAY_OF_MONTH);
		}


	public void setIdProiezione(String id){
		idProiezione = id;
	}

	
	public void setPrezzoBase(double pB){
		 prezzoBase=pB;
	}
	
	public void setFasciaOraria(int fO){
		fasciaOraria=fO;
	}
	public void set3D(boolean tre){
		_3d=tre;
	}
	
	public void setFilm(String f){
		film=f;
	}
	
	public void  setDataStr(String dt){
		
		 String[] g = dt.split("-");
	     
	        int aa=Integer.parseInt(g[0]);
			int mm=Integer.parseInt(g[1]);
			int gg=Integer.parseInt(g[2]);	
		GregorianCalendar	data=new GregorianCalendar(aa,mm,gg);
		 this.setData(data);
		
		}
	
	public void  setData(GregorianCalendar d){
		data=d;}
	
	public static String GetMonday(GregorianCalendar today){
	   
	   GregorianCalendar lunedi=null;
		
		int day = today.get(GregorianCalendar.DAY_OF_WEEK);
		int distance = 0;
		
		if (day == GregorianCalendar.MONDAY)
		{
			return ""+today.get(GregorianCalendar.YEAR)+"-"+
		                    ( today.get(GregorianCalendar.MONTH)+1)+"-"+
					         today.get(GregorianCalendar.DAY_OF_MONTH);
		}
		
		else{
			distance = day - GregorianCalendar.MONDAY;
			if (distance == -1)
				distance = 6;
				lunedi = today;
				lunedi.setTimeInMillis(lunedi.getTimeInMillis()-(1000 * 60 * 60 * 24 * (distance)));
				return ""+lunedi.get(GregorianCalendar.YEAR)+"-"+
                         ( lunedi.get(GregorianCalendar.MONTH)+1)+"-"+
		                  lunedi.get(GregorianCalendar.DAY_OF_MONTH);
		}		
				
	}
	
	
	public static Date GetCurrentMonday(Date today)
	{
	Date monday = null;
	Calendar rightNow = Calendar.getInstance();
	rightNow.setTime(today);
	int day = rightNow.get(Calendar.DAY_OF_WEEK);
	int distance = 0;
	if (day == Calendar.MONDAY)
	{
	monday = rightNow.getTime();
	}
	else
	{
	distance = day - Calendar.MONDAY;
	if (distance == -1)
	distance = 6;
	monday = (Date) (rightNow.getTime());
	monday.setTime(monday.getTime() - 1000 * 60 * 60 * 24 * (distance));
	}
	return monday;
	}


	public String toString() {
		return "Proiezione [idProiezione=" + idProiezione + ", film=" + film + ", prezzoBase=" + prezzoBase
				+ ", fasciaOraria=" + fasciaOraria + this.getFasciaOrariaStr()+ ", _3d=" + _3d + ", data=" + this.getDataStr() + "]";
	}
	
	
	
	

}
