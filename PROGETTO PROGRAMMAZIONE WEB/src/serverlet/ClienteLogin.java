package serverlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelDM.BigliettoModelDM;
import modelDM.ClienteModelDM;
import oggetti.Biglietto;
import oggetti.Cliente;
import oggetti.FileGestione;

	@WebServlet("/ClienteLogin")
	
	public class ClienteLogin extends HttpServlet {
		private static final long serialVersionUID = 1L;

			static ClienteModelDM model = new ClienteModelDM();
			

		public ClienteLogin() {
			super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int flag = -1;
			int error=0;
			Cliente cl=null;
			
		
			
			String u = request.getParameter("username");
			String p = request.getParameter("password");
			 try {
			cl=	model.doRetrieveByKey(u);
			
			if(cl==null){
				error=1;
				flag=0;
				}
			
			else if(!(cl.getPassword().equals(p))){
				error=2;
				flag=0;
			}
			
			else{flag=1;  System.out.println("flag =1 "+cl.getUsername());}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
	if(flag ==1){
		
		HttpSession session=request.getSession();
		
		Cliente cli = (Cliente)session.getAttribute("cliente");
		if(cli == null) {
			cli = new Cliente();
			cli=cl;
			session.setAttribute("cliente", cli);
			
		}
		
			session.setAttribute("cliente",cli);
			
						
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AreaRiservata.jsp");
			    dispatcher.forward(request, response);
			
			
			
		
			/*response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String title = "Reading Three Request Parameters";
		    String docType =
		      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		      "Transitional//EN\">\n";
		    out.println(docType +
		                "<HTML>\n" +
		                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
		                "<UL>\n" +
		                "  <LI><B>nome</B>: "
		                + cliente.getNome() + "\n" +
		                "  <LI><B>cognome</B>: "
		                + cliente.getCognome() + "\n" +
		                "  <LI><B>user</B>: "
		                + cliente.getUsername() + "\n" +
		                "  <LI><B>email</B>: "
		                + cliente.getEmail() + "\n" +
		                "  <LI><B>pass</B>: "
		                + cliente.getPassword() + "\n" +
		                "  <LI><B>cell</B>: "
		                + cliente.getCellulare() + "\n" +
		                "  <LI><B>cf</B>: "
		                + cliente.getSesso()+ "\n" +
		                "  <LI><B>data</B>: "
		                + cliente.getDataNascitaStr()+ "\n" +
		               
		                "</UL>\n" +
		                "</BODY></HTML>");*/
		                
		                }

	else{
		
		
		request.setAttribute("errore", error);
		System.out.println(" "+ request.getAttribute("errore"));
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
	    dispatcher.forward(request, response);
		 }
		/*
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Reading Three Request Parameters";
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    out.println(docType +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	               
	                "  utente non registrato "+
	                
	               
	              
	                "</BODY></HTML>");*/
	}
	
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

	}

	

