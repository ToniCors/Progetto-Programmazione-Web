package serverlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import modelDM.ClienteModelDM;
import modelDM.FilmModelDM;
import oggetti.*;


@WebServlet("/InserimentoFIlm")
public class InserimentoFIlm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static FilmModelDM  model= new FilmModelDM();
	
	public InserimentoFIlm() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
				
	String t = request.getParameter("Titolo");
	String g = request.getParameter("Genere");
	int d = Integer.parseInt(request.getParameter("Durata"));
	String r = request.getParameter("Regista");
	String tre = request.getParameter("Trailer");
	String tr = request.getParameter("Trama");
	String Img = request.getParameter("Immagine");


			 Film f= new Film();
			 f.setDurata(d);
		     f.setGenere(g);
		     f.setImmagine(Img);
		     f.setRegista(r);
		     f.setTitolo(t);
		     f.setTrailer(tre);
		     f.setTrama(tr);
		     System.out.println(""+f.toString());
		     
		 	try {
				model.doSave(f);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			} 
			
			response.sendRedirect("HomeAdmin.jsp");


		} 
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
