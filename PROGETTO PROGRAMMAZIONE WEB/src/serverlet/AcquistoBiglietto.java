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
import modelDM.FilmModelDM;
import modelDM.ProiezioneModelDM;
import modelDM.SalaModelDM;
import oggetti.Biglietto;
import oggetti.Cliente;
import oggetti.FileGestione;
import oggetti.Film;
import oggetti.Proiezione;
import oggetti.Sala;

	@WebServlet("/AcquistoBiglietto")
	
	public class AcquistoBiglietto extends HttpServlet {
		private static final long serialVersionUID = 1L;

			
			

		public AcquistoBiglietto() {
			super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			HttpSession session=request.getSession();
			Cliente cli = (Cliente)session.getAttribute("cliente");
			System.err.println(""+cli);
			Boolean adminR=(Boolean) session.getAttribute("adminR");
			System.err.println(""+adminR);
			
			
			if(cli == null && adminR==null) {
				System.out.println("falsi entrambi ");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
			    dispatcher.forward(request, response);
				
			}
			
			if(adminR!=null ){
				if(adminR==true){
				String proiezione = request.getParameter("proiezione");
				try {
					Proiezione p=new ProiezioneModelDM().doRetrieveByKey(Integer.parseInt(proiezione));
					Film f = new FilmModelDM().doRetrieveByKey(p.getFilm());
					Sala s = new SalaModelDM().doRetrieveByProiezione(Integer.parseInt(proiezione));
					ArrayList<Biglietto> b =new BigliettoModelDM().doRetrieveByProiezione(proiezione);
					System.out.println("numero biglietti"+b.size());
					
					System.out.println(p.toString());
					
					for(int i=0;i<b.size();i++)
					{
						
						System.out.println("prima di aggiungere  =  "+b.get(i).toString());
					}
					
					request.setAttribute("film", f);
					request.setAttribute("proiezione", p);
					request.setAttribute("sala", s);
					
					
					request.setAttribute("biglietti", b);
			
					
					System.out.println("dopo aggiunto = "+ request.getAttribute("biglietti"));
					
					
					
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
				
				
				System.out.println(""+proiezione);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CarrelloAdmin.jsp");
			   dispatcher.forward(request, response);				
			}}
			
			
			
			else{
				String proiezione = request.getParameter("proiezione");
				try {
					Proiezione p=new ProiezioneModelDM().doRetrieveByKey(Integer.parseInt(proiezione));
					Cliente c=(Cliente)session.getAttribute("cliente");
					Film f = new FilmModelDM().doRetrieveByKey(p.getFilm());
					Sala s = new SalaModelDM().doRetrieveByProiezione(Integer.parseInt(proiezione));
					ArrayList<Biglietto> b =new BigliettoModelDM().doRetrieveByProiezione(proiezione);
					System.out.println("numero biglietti"+b.size());
					for(int i=0;i<b.size();i++)
					{
						
						System.out.println("prima di aggiungere  =  "+b.get(i).toString());
					}
					
					request.setAttribute("film", f);
					request.setAttribute("proiezione", p);
					
					request.setAttribute("cliente", c);
					request.setAttribute("sala", s);
					
					
					request.setAttribute("biglietti", b);
			
					
					System.out.println("dopo aggiunto = "+ request.getAttribute("biglietti"));
					
					
					
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
				
				
				System.out.println(""+proiezione);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
			   dispatcher.forward(request, response);				
			}
			
		
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

	}

	

