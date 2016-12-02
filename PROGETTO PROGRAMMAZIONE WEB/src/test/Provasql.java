package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import modelDM.*;
import oggetti.*;



public class Provasql {

	public static void main(String[] args) throws SQLException {
		
		
		
		int p =3;
		double d = 300;
		
		Proiezione pp =new ProiezioneModelDM().doRetrieveByKey(p);
		
		System.out.println("prima "+pp.toString());
		
		new ProiezioneModelDM().ChangePrezzo(p, d);
		
		
		pp =new ProiezioneModelDM().doRetrieveByKey(p);
		
		System.out.println("dopo "+pp.toString());
		
		
		
		/*
		Film f = new FilmModelDM().doRetrieveByKey("a");
		
		System.out.println(""+f.toString());
		
		/*
		int p = 10;
		String a="B";
		ArrayList<Posto> posti = new PostoModelDM().doRetrieveAllBySala(a);
		
		for(int i=0;i<posti.size();i++) {
			
		System.out.println(""+posti.get(i).toString());
		
		}//Sala s = new SalaModelDM().doRetrieveByProiezione(p);
		
		//System.out.println(s.toString());
		
		
		/*
		
		GregorianCalendar d = new GregorianCalendar();
		String a = "a";
		String code="Kaiku";
		Cliente cliente = new Cliente(a,a,code,a,a,a,a,d);
		
		/*String dt = "2016-01-01";
		int aa=Integer.parseInt(dt.substring(0, 4));
		int mm=Integer.parseInt(dt.substring(6, 7));
		int gg=Integer.parseInt(dt.substring(9, 10));
		
		int aa=d.get(GregorianCalendar.YEAR);
			int mm=	d.get(GregorianCalendar.MONTH);
	          int gg=  d.get(GregorianCalendar.DAY_OF_MONTH);
		
		System.out.println(""+aa);
		System.out.println(""+mm);
		System.out.println(""+gg);
		GregorianCalendar	dataNascita=new GregorianCalendar(aa,mm,gg);
		
		cliente.setDataNascita(dataNascita);
		System.out.println(""+cliente.getDataNascitaStr());
		
	   /*
	    model = new ProductModelDM();*/
		
		//Collection<Cliente>ci =new LinkedList<Cliente>();
			
			
		
	//	ClienteModelDM model= new ClienteModelDM();
		//model.doSave(cliente);
		//cliente =model.doRetrieveByKey(code);
		//System.out.println(""+cliente);
		//boolean kk = model.doDelete("Kairoku");
		//System.out.println(""+kk);
		
		//ci=model.doRetrieveAll();
		

			//System.out.println(ci.toString()); */
		
		
		
		
		
		
	
	

	}

}
