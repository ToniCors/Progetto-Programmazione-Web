package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that prints out the param1, param2, and param3
 *  request parameters. Does not filter out HTML tags.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/params")
public class params extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
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
                "<UL>\n" +
                "  <LI><B>param1</B>: "
                + request.getParameter("nome") + "\n" +
                "  <LI><B>param2</B>: "
                + request.getParameter("cognome") + "\n" +
                "  <LI><B>param3</B>: "
                + request.getParameter("username") + "\n" +
                "  <LI><B>param3</B>: "
                + request.getParameter("email") + "\n" +
                "  <LI><B>param3</B>: "
                + request.getParameter("password") + "\n" +
                "  <LI><B>param3</B>: "
                + request.getParameter("cellulare") + "\n" +
                "  <LI><B>param3</B>: "
                + request.getParameter("codicefiscsale") + "\n" +
                "  <LI><B>param3</B>: "
                + request.getParameter("sesso") + "\n" +
                "  <LI><B>gg</B>: "
                + request.getParameter("giorno") + "\n" +
                "  <LI><B>mm</B>: "
                + request.getParameter("mese") + "\n" +
                "  <LI><B>aa</B>: "
                + request.getParameter("anno") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }
}
