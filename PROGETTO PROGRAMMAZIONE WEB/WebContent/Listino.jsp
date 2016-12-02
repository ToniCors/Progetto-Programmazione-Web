<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.Cliente"%>
   
   <%	
 
	 Cliente cliente = (Cliente)session.getAttribute("cliente");
   Boolean adminR=(Boolean) session.getAttribute("adminR");
    
      %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Listino Prezzi</title>
 <style type ="text/css">	
	@import url("css/listino.css");
</style>   

<script type="text/javascript"> 
  $(document).ready(function() {  
   $("li.lprezzi").css({"background-color":"rgba(0, 255, 0, 0.6)"});
      
 });   </script>
 
 <script src="script/val.js" type="text/javascript"></script>
 </head>
<body>
<%if((cliente!=null)&&(adminR==null))  { %>  
<%@ include file="menuLogged.html" %>
	<% }%>  
	
 <% if((cliente==null)&&(adminR!=null)){  %>
   <%@ include file="MenuLoggAdmin.html" %>
<% }%>  
<%if((cliente==null)&&(adminR==null)){%>
<%@ include file="menu.html" %>  
<%} %>

<div class="body">

<div class="tableconteiner">

<table class="listino">

<tr><th>Listino </th><th>2D  </th><th>3D  </th></tr>

<tr>      <th>LUNEDI'</th><td> 5&euro; </td><td> 7&euro; </td></tr>
<tr>      <th>MARTEDI'</th><td> 3&euro; </td><td> 5&euro; </td></tr>
<tr>      <th>MERCOLEDI'</th><td> 5&euro; </td><td> 7&euro; </td></tr>
<tr>      <th>GIOVEDI'</th><td> 3&euro; </td><td> 5&euro; </td></tr>
<tr>      <th>VENERDI'</th><td> 5&euro;  </td><td> 7&euro; </td></tr>
<tr>      <th>SABATO</th><td> 5&euro;  </td><td> 7&euro;  </td></tr>
<tr>      <th>DOMENICA</th><td> 5&euro;  </td><td> 7&euro;  </td></tr>

</table> 

</div></div>

<%@ include file="footer.html" %>
</body>
</html>