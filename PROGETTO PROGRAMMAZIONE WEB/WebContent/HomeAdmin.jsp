<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%  Boolean adminR=(Boolean) session.getAttribute("adminR");
    if((adminR==null)||(!adminR.booleanValue()))
    {response.sendRedirect("./Login.jsp");
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator</title>
<style type ="text/css">	
			
	@import url("css/home.css");
	
</style>

</head>
<body>
<%@ include file="MenuLoggAdmin.html" %> 
<div class="indirizzi1">

<br></br>
<h2 class="WA">Welcome in the side of Administrator</h2> 
<br></br>
<br></br>
<br></br>
<div class="indirizzi2">
<ul >
  <li  class ="Inseriscifilm"><a href="InserisciFilm.jsp"><h2 class="WA">Film</h2></a></li>
</ul>
</div>
<div class="indirizzi3">
<ul >
  <li class ="Proiezione"><a href="InserisciProiezione.jsp"><h2 class="WA">Proiezione</h2></a></li>
</ul>
</div>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
</div>
<%@ include file="footer.html" %>

</body>
</html>