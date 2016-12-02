package serverlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelDM.BigliettoModelDM;
import modelDM.ProiezioneModelDM;
import modelDM.SalaModelDM;
import oggetti.*;

@WebServlet("/StampaBiglietto")
public class StampaBiglietto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public StampaBiglietto() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Cliente cli = (Cliente)session.getAttribute("cliente");
		if(cli == null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
		    dispatcher.forward(request, response);
			
		}
		
		else{
		String idB = request.getParameter("idBiglietto");
		try {
			Biglietto b = new BigliettoModelDM().doRetrieveByKey(idB);
			Proiezione pro = new ProiezioneModelDM().doRetrieveByKey(b.getProiezione());
			Sala s = new SalaModelDM().doRetrieveByProiezione(b.getProiezione());
			
			
			request.setAttribute("proiezione", pro);
			request.setAttribute("sala", s);
			request.setAttribute("biglietto", b);
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/biglietto.jsp");
		   dispatcher.forward(request, response);	
		
	                
	                }




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

