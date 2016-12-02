package serverlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelDM.ProiezioneModelDM;


@WebServlet("/CambiaPrezzo")


public class CambiaPrezzo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CambiaPrezzo() {
        super();
         }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pz = request.getParameter("nuovoPrezzo").trim();
	    double prez = Double.parseDouble(pz);		
		String p= request.getParameter("idProiezione");
		int pro = Integer.parseInt(p.trim());
		
		System.out.println(" "+prez+pro);
		
		
		System.out.println(" "+p.toString());
		
		try {
			new ProiezioneModelDM().ChangePrezzo(pro,prez);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(" "+p.toString());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
