package serverlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelDM.BigliettoModelDM;
import modelDM.ProiezioneModelDM;
import oggetti.Biglietto;
import oggetti.Cliente;
import sun.util.calendar.Gregorian;


@WebServlet("/ConfermaAcquisto")


public class ConfermaAcquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConfermaAcquisto() {
        super();
         }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cli = request.getParameter("user").trim();
		GregorianCalendar adesso= new GregorianCalendar();
		int gg =adesso.get(Calendar.DAY_OF_MONTH);
		int mm =adesso.get(Calendar.MONTH)+1;
		int aa =adesso.get(Calendar.YEAR);
		int hh =adesso.get(Calendar.HOUR_OF_DAY);
		int min =adesso.get(Calendar.MINUTE);
		
		
		String pro= request.getParameter("idProiezione");
		int idpro = Integer.parseInt(pro.trim());
		double pz =5 ;
		try {
			 pz = (new ProiezioneModelDM().doRetrieveByKey(idpro)).getPrezzoBase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String b1=	request.getParameter("b1");
		String b2=	request.getParameter("b2");
		String b3=	request.getParameter("b3");
		String b4=	request.getParameter("b4");
		String b5=	request.getParameter("b5");
		
			
		if(b1.equals("")){}
		else{
			String[] B1 = b1.split(": ");	
			System.out.println("leggo : "+B1[1]);
			Biglietto bb1 = new Biglietto(idpro,Integer.parseInt(B1[1]),cli,pz,gg,mm,aa,hh,min);
			try {
				new BigliettoModelDM().doSave(bb1);
			} catch (SQLException e) {}			
		}
		
		
		if(b2.equals("")){}
		else{
			String[] B2 = b2.split(": ");
			System.out.println("leggo : "+B2[1]);
			Biglietto bb2 = new Biglietto(idpro,Integer.parseInt(B2[1]),cli,pz,gg,mm,aa,hh,min);
			try {
				new BigliettoModelDM().doSave(bb2);
			} catch (SQLException e) {}
		}
		
		if(b3.equals("")){}
		else{
			String[] B3 = b3.split(": ");
			System.out.println("leggo : "+B3[1]);
			Biglietto bb3 = new Biglietto(idpro,Integer.parseInt(B3[1]),cli,pz,gg,mm,aa,hh,min);
			try {
				new BigliettoModelDM().doSave(bb3);
			} catch (SQLException e) {}
		}
		
		if(b4.equals("")){}
		else{
			String[] B4 = b4.split(": ");
			System.out.println("leggo : "+B4[1]);			
			Biglietto bb4 = new Biglietto(idpro,Integer.parseInt(B4[1]),cli,pz,gg,mm,aa,hh,min);
			try {
				new BigliettoModelDM().doSave(bb4);
			} catch (SQLException e) {}
		}
		
		if(b5.equals("")){}
		else{
			String[] B5 = b5.split(": ");
			System.out.println("leggo : "+B5[1]);
			Biglietto bb5 = new Biglietto(idpro,Integer.parseInt(B5[1]),cli,pz,gg,mm,aa,hh,min);
			try {
				new BigliettoModelDM().doSave(bb5);
			} catch (SQLException e) {}
		}
	
		
		response.sendRedirect("home.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
