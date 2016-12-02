package serverlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelDM.*;
import oggetti.Film;


@WebServlet("/FilmTrailer")


public class FilmTrailer extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	static FilmModelDM model = new FilmModelDM();
	
	
	public FilmTrailer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Film film= null;
		
		String titolo = request.getParameter("titolo");
		System.out.println(""+titolo);
		
		
		
		try {
			
			if(titolo!=null){
			film=model.doRetrieveByKey(titolo);}
			
			
			
		} catch (SQLException e) {
			
		}
		
		request.setAttribute("film", film);
		System.out.println(" "+ request.getAttribute("film").toString());
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/film.jsp");
	    dispatcher.forward(request, response);
		
		
		
	}	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
