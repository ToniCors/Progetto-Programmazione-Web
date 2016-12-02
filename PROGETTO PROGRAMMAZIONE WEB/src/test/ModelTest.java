package test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import modelDM.*;
import oggetti.*;



public class ModelTest{

	public static void main(String[] args) throws SQLException {
			
		 GregorianCalendar oggi =new GregorianCalendar();  
	     String tod = ""+oggi.get(GregorianCalendar.YEAR)+"-"+
	             ( oggi.get(GregorianCalendar.MONTH+1))+"-"+
	             oggi.get(GregorianCalendar.DAY_OF_MONTH);
	     
	     ProiezioneModelDM pm = new ProiezioneModelDM();
			FilmModelDM fm = new FilmModelDM();		
			ArrayList<Proiezione> todayPro =  pm.doRetrieveDistinctByDate(tod);
			
			System.out.println(""+tod);
			System.out.println(""+todayPro.size());
			for(int i=0; i<todayPro.size();i++){
				System.out.println(""+todayPro.get(i).getFilm());
			}
		
		
		
		//String pp = sdf.format(d);
		
		//System.out.println(""+pp);
	
	   // Date d = new Date(2016, 7, 13);
		
			
		//ArrayList<Proiezione> a=  pm.doRetrieveDistinctByDate(data);
		
		
		/*
		for(int i =0; i<a.size();i++){
			System.out.println(""+a.get(i).toString());
			Film f =fm.doRetrieveByKey(a.get(i).getFilm());
			System.out.println(""+f);
			
		}*/
		
		
		
		
		//!!tutti i metodi do deletee non cancellano nel database!!
	
	/*	
		//film test
	Film f = new Film("a","a","a",23,"a","a","a");
	Film f2 = new Film("b","a","a",23,"a","a","a");
		FilmModelDM fm = new FilmModelDM();
		//fm.doSave(f);
		//fm.doSave(f2);
		
		Film rs1 =fm.doRetrieveByKey("ak");
		if(rs1!=null)
		System.out.println(" f1  "+rs1.toString());
		else{System.out.println(" rs1  "+null);}
		
		Film rs2 =fm.doRetrieveByKey("b");		
		if(rs2!=null)
		System.out.println(" f2  "+rs2.toString());
		else{System.out.println(" f2  "+null);}
	
		
		dl=fm.doDelete("a");
		dl=fm.doDelete("b");
		System.out.println("cancellato "+dl);
		
		
			Iterator<?> it = fm.doRetrieveAll().iterator();
			while (it.hasNext()) {
				System.out.println("film=  "+it.next().toString());	}  */
	/*	
		//sala test
				Sala s1 = new Sala("r",10);
				Sala s2 = new Sala("t",10);
				
				SalaModelDM sm = new SalaModelDM();
				//sm.doSave(s1);
				//sm.doSave(s2);
				 
		Sala rs1 =sm.doRetrieveByKey("u");
		if(rs1!=null)
		System.out.println(" s1  "+rs1.toString());
		else{System.out.println(" rs1  "+null);}
		
		Sala rs2 =sm.doRetrieveByKey("t");		
		if(rs2!=null)
		System.out.println(" s2  "+rs2.toString());
		else{System.out.println(" f2  "+null);}				
		
		System.out.println(" b=  "+sm.doRetrieveByKey("b").toString());		
				
				dl=sm.doDelete("r");
				System.out.println("cancellato "+dl);	
							
					Iterator<?> it = sm.doRetrieveAll().iterator();
					while (it.hasNext()) {
						System.out.println("sala=  "+it.next().toString());		}		*/
		
		/*
		//test proiezione
		Proiezione p1 = new Proiezione(null,33,23,true,"a",1,1,2011);
		Proiezione p2 = new Proiezione(null,33,23,true,"b",1,1,2011);
		ProiezioneModelDM pm = new ProiezioneModelDM();
			pm.doSave(p1);
			pm.doSave(p2);
			
			Proiezione rs1 =pm.doRetrieveByKey(1);
			if(rs1!=null)
			System.out.println(" p1  "+rs1.toString());
			else{System.out.println(" rs1  "+null);}
			
			Proiezione rs2 =pm.doRetrieveByKey(2);		
			if(rs2!=null)
			System.out.println(" p2  "+rs2.toString());
			else{System.out.println(" p2  "+null);}
		
			
			dl=pm.doDelete(1);
		   System.out.println("cancellato "+dl);
			
			
				Iterator<?> it = pm.doRetrieveAll().iterator();
				while (it.hasNext()) {
					System.out.println("proiezioni=  "+it.next().toString());	}  		
		*/
		
		
		
		
		
		/*
		//test Biglietto
		
		Biglietto b1 = new Biglietto(2,4,"toniCors",9,2,3,2013,23,11);
		Biglietto b2 = new Biglietto(7,5,"toniCors",9,2,3,2013,23,11);
		BigliettoModelDM bm = new BigliettoModelDM();
			//bm.doSave(b1);
			//bm.doSave(b2);
			
		Biglietto rs1 =bm.doRetrieveByKey("1-3");
			if(rs1!=null)
			System.out.println(" b1  "+rs1.toString());
			else{System.out.println(" rs1  "+null);}
			
			Biglietto rs2 =bm.doRetrieveByKey("1-4");		
			if(rs2!=null)
			System.out.println(" b2  "+rs2.toString());
			else{System.out.println(" f2  "+null);}
		
			
			dl=bm.doDelete("1-4");
			System.out.println("cancellato "+dl);
			
			
				Iterator<?> it = bm.doRetrieveAll("toniCors").iterator();
				while (it.hasNext()) {
					System.out.println("film=  "+it.next().toString());	} 
				
			*/
		
		 /*
		//test Ubicazione
		
		 Ubicazione u1 = new  Ubicazione("b",1);
		 Ubicazione u2 = new  Ubicazione("a",2);
		 UbicazioneModelDM um = new  UbicazioneModelDM();
			//um.doSave(u1);
			//um.doSave(u2);
			
		 Ubicazione rs1 =um.doRetrieveByKey(2,"b");
			if(rs1!=null)
			System.out.println(" b1  "+rs1.toString());
			else{System.out.println(" rs1  "+null);}
			
			 Ubicazione rs2 =um.doRetrieveByKey(1,"h");		
			if(rs2!=null)
			System.out.println(" b2  "+rs2.toString());
			else{System.out.println(" f2  "+null);}
		
			
			
			
				Iterator<?> it = um.doRetrieveAll().iterator();
				while (it.hasNext()) {
					System.out.println("all=  "+it.next().toString());	} 
				
				it = um.doRetrieveAllByProiezione(1).iterator();
				while (it.hasNext()) {
					System.out.println("proi=  "+it.next().toString());	} 
				
				it = um.doRetrieveAllBySala("B").iterator();
				while (it.hasNext()) {
					System.out.println("sala=  "+it.next().toString());	}
		
		
		
				
				*/
		
		// /*
		//test Posto
		/*
		Posto p1 = new Posto(1,1,1,300,"c");
		Posto p2 = new Posto(1,1,1,200,"a");
		PostoModelDM pm = new PostoModelDM();
			//pm.doSave(p1);
			//pm.doSave(p2);
		
		Posto rs1 =pm.doRetrieveByKey(300,"c");
		if(rs1!=null)
		System.out.println(" p1  "+rs1.toString());
		else{System.out.println(" rs1  "+null);}
		
		Posto rs2 =pm.doRetrieveByKey(200,"a");		
		if(rs2!=null)
		System.out.println(" p2  "+rs2.toString());
		else{System.out.println(" rs2  "+null);}
			
		
			
			pm.CambiaDisponibilita(0, 1, 200, "a");
			pm.CambiaDisponibilita(0, 2, 200, "a");
			pm.CambiaDisponibilita(0, 3, 200, "a");
			
			pm.CambiaDisponibilita(0, 1, 300, "c");
			pm.CambiaDisponibilita(0, 2, 300, "c");
			pm.CambiaDisponibilita(0, 3, 300, "c");
			
			rs1 =pm.doRetrieveByKey(300,"c");
			if(rs1!=null)
			System.out.println(" p1  "+rs1.toString());
			else{System.out.println(" rs1  "+null);}
			
			rs2 =pm.doRetrieveByKey(200,"a");		
			if(rs2!=null)
			System.out.println(" p2  "+rs2.toString());
			else{System.out.println(" rs2  "+null);}
		
			
				
			
				Iterator<?> it = pm.doRetrieveAllBySala("a").iterator();
				while (it.hasNext()) {
					System.out.println("posti =  "+it.next().toString());	} 
				
				// */
		
		
		
	}
	
}
	

