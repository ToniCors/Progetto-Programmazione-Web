package test;

import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import modelDM.FilmModelDM;
import modelDM.ProiezioneModelDM;
import oggetti.Film;
import oggetti.Proiezione;

public class jasonTest {
public static void main(String[] args) {
	
	Gson json = new Gson();
   
     String data = "7-6"   ;

GregorianCalendar z =new GregorianCalendar();

data=""+z.get(GregorianCalendar.YEAR)+"-"+data;

System.out.println(data);




//PrintWriter out = new PrintWriter("");
    
ProiezioneModelDM pm = new ProiezioneModelDM();
	FilmModelDM fm = new FilmModelDM();		
	ArrayList<Proiezione> pro;
	try {
		pro = pm.doRetrieveDistinctByDate(data);
		Film f1,f2,f3,f4;
		f1= fm.doRetrieveByKey(pro.get(0).getFilm());
		f2= fm.doRetrieveByKey(pro.get(1).getFilm());
		f3= fm.doRetrieveByKey(pro.get(2).getFilm());
		f4= fm.doRetrieveByKey(pro.get(3).getFilm());
		
		ArrayList<Object> o = new ArrayList<>();
		
		o.add(pro.get(0));
		o.add(pro.get(1));
		o.add(pro.get(2));
		o.add(pro.get(3));
		
		o.add(f1);
		o.add(f2);
		o.add(f3);
		o.add(f4);
		
		/*
		out.print(json.toJson(f1));
		out.append(json.toJson(f2));
		out.append(json.toJson(f3));
		out.append(json.toJson(f4));
		out.append(json.toJson(pro));
		
		System.out.println(out.toString()); */
		json.toJson(o);
		
		System.out.println(""+json.toJson(o));
	
		//out.flush();
		//out.close();
	} catch (SQLException exe) {
		
	}
	
	
	
	
	
}	
	
	
	
	
	
	
	
	
}

