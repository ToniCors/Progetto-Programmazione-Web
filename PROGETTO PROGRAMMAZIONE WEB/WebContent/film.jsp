<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*"%>
   
   <%	
     Film film =  (Film)request.getAttribute("film"); 
        if(film==null){response.sendRedirect("home.jsp");}
        Cliente cliente = (Cliente)session.getAttribute("cliente"); 
	 
	 
      %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

<title>FILM</title>

 <style type ="text/css">			
	@import url("css/films.css");
</style>

</head>
<body>
<%if(cliente==null) {%>
<%@ include file="menu.html" %>  
<%} %>

<%if(cliente!=null) {%>
<%@ include file="menuLogged.html" %>  
<%} %>

<div class="body">

<div class="onefilm">

<div class="trailer">
<iframe class="frametrailer" width="560" height="315" src=<%= film.getTrailer() %>></iframe>
</div>



<div class="trama">
<iframe class="frametrama" width="560" height="315" src=<%=film.getTrama()%>></iframe>
</div>

</div>


</div>


<%@ include file="footer.html" %>
</body>
</html>