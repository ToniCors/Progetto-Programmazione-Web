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

import modelDM.ClienteModelDM;
import oggetti.Cliente;




@WebServlet("/ClienteRegistrazione")

public class ClienteRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

		static ClienteModelDM model = new ClienteModelDM();

	public ClienteRegistrazione() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int flag = 0;
		int error=0;		
		Cliente cl=null;
		boolean esiste =false;
			
		String n = request.getParameter("nome");
		String c = request.getParameter("cognome");
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String s = request.getParameter("sesso");
		String cell = request.getParameter("cellulare");
		int gg = Integer.parseInt(request.getParameter("giorno"));
		//System.out.println("giorno inserito "+gg);
		int mm = Integer.parseInt(request.getParameter("mese"));
		System.out.println("mese inserito "+mm);
		int aa = Integer.parseInt(request.getParameter("anno"));
		//System.out.println("anno inserito "+aa);
	
	
		System.out.println("\n\n");
		

		
		try {
			cl=	model.doRetrieveByKey(u);	
			
			if(cl!=null){
				System.out.println("esiste user");
				error=1;
				flag=1;}
				
			esiste=model.doRetrieveByEmeil(e);
			if(esiste==true){
				System.out.println("esiste emeil");
				error=error+2;
				flag=1;
			}  
			
			
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
		
		System.out.println("flag prima if =  "+flag);
		
			
if(flag ==0){
	System.out.println("flag dopo if =  "+flag);
		
		Cliente cliente = new Cliente();		
		cliente.setNome(n);
		cliente.setCognome(c);
		cliente.setUsername(u);
		cliente.setEmail(e);
		cliente.setPassword(p);
		cliente.setSesso(s);
		cliente.setCellulare(cell);
		cliente.setDataNascita(new GregorianCalendar(aa,mm+1,gg));
		
	
		try {
			model.doSave(cliente);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} 
		
		response.sendRedirect("Login.jsp");
		
}

else{
	
	
	request.setAttribute("errore", error);
	System.out.println(" "+ request.getAttribute("erroreR"));
	
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Registrazione.jsp");
    dispatcher.forward(request, response);
	
}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
