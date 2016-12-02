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
<title>ABOUT</title>
 <style type ="text/css">	
	@import url("css/listino.css");
</style>   

<script type="text/javascript"> 
  $(document).ready(function() {  
   $("li.contatti").css({"background-color":"rgba(0, 0, 255, 0.6)"});
     
 }); </script>      
         


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

<div class="int">
<span>RAGGIUNGICI AD AMERICAN</span><br>


</div>

<div class="map">
<iframe class="mapabout" src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d3020.3140152524807!2d14.5398983!3d40.7990929!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sit!2sit!4v1466159541740"  ></iframe>


</div>

<div class="contatti">
<span>via Roma n°30 80033 Poggiomarino(NA)</span><br>
<span>Tel : 081528607</span><br>
<span>E-mail : america@cinema.it</span>

</div><br><br>

</div>

<%@ include file="footer.html" %>
</body>
</html>