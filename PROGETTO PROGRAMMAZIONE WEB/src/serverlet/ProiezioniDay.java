package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelDM.FilmModelDM;
import modelDM.ProiezioneModelDM;
import oggetti.Film;
import oggetti.Proiezione;

@WebServlet("/ProiezioniDay")


public class ProiezioniDay extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	static FilmModelDM model = new FilmModelDM();
	
	
	public ProiezioniDay() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Gson json = new Gson();
	   
	        
	String data=	request.getParameter("data");
	GregorianCalendar z =new GregorianCalendar();
	
	data=""+z.get(GregorianCalendar.YEAR)+"-"+data;
	
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
			
			//o.add(pro);
			
			o.add(pro.get(0));
			o.add(pro.get(1));
			o.add(pro.get(2));
			o.add(pro.get(3));
			
			o.add(f1);
			o.add(f2);
			o.add(f3);
			o.add(f4);
			
					
			out.print(json.toJson(o));
			System.out.println(json.toJson(o));
			
			out.flush();
			out.close();
		} catch (SQLException exe) {
			
		}
		
		
		
		
		
	}	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
