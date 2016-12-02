package serverlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogAdmin
 */


@WebServlet("/LogAdmin")

public class LogAdmin extends HttpServlet {
	private static final long serialVersionUID =1L;
       
   
    public LogAdmin() {
        super();
          }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("usernameA");
		String password= request.getParameter("passwordA");
		
		System.out.println("servlet opne");
		
		String path=null;
		Boolean check= checkLogin(username,password);
		
		
		if(check){
			System.out.println("true");
			request.getSession().setAttribute("adminR", new Boolean(true));
			path="/HomeAdmin.jsp";
		}
		
		
		
		else{
			System.out.println("false");
			request.getSession().removeAttribute("adminR");
		     path="/Login.jsp";
	     }
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	protected Boolean checkLogin(String username,String password){
		return (username.equals("root")&&password.equals("A234"));
	}
	
}
