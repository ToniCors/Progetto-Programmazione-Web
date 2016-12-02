package serverlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelDM.ProiezioneModelDM;
import oggetti.Film;
import oggetti.Proiezione;


@WebServlet("/InserimentoProiezione")
public class InserimentoProiezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProiezioneModelDM model= new  ProiezioneModelDM();
	public InserimentoProiezione() {
		super();    
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	  
	

		int  f =Integer.parseInt( request.getParameter("FasciaOraria"));
		int  p = Integer.parseInt(request.getParameter("PrezzoBase"));	
		String fil = request.getParameter("Film");
		String d = request.getParameter("DDD");
		boolean ddd ;
		
		if(d.equals("true")){
			ddd=true;
		}
		else{
			ddd=true;
		}
		
		int gg = Integer.parseInt(request.getParameter("giorno"));
		//System.out.println("giorno inserito "+gg);
		int mm = Integer.parseInt(request.getParameter("mese"));
		System.out.println("mese inserito "+mm);
		int aa = Integer.parseInt(request.getParameter("anno"));
		//System.out.println("anno inserito "+aa);



		
			Proiezione pr= new Proiezione();
			
			pr.setIdProiezione("null");
			pr.setFilm(fil);			
			pr.set3D(ddd);
			pr.setData(new GregorianCalendar(aa, mm+1, gg));
			pr.setFasciaOraria(f);
			pr.setPrezzoBase(p);
			
			System.out.println(" "+pr.toString());

			
			try {
				model.doSave(pr);
			} catch (SQLException e1) {

				e1.printStackTrace();
			 } 
			
			response.sendRedirect("HomeAdmin.jsp");
		}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				doGet(request, response);
			}

		}
