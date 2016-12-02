package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oggetti.Cliente;


@WebServlet("/ClienteLogout")
public class ClienteLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ClienteLogout() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("logoutttttt");
	
		HttpSession session=request.getSession();
		Cliente cli = (Cliente)session.getAttribute("cliente");
		if(cli != null) {						
			session.removeAttribute("cliente");			
		}
		
         session.removeAttribute("adminR");
		
		
		
		
		
		response.sendRedirect("home.jsp");
	                
	                }




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}



