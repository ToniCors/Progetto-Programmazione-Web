<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*"%>
   
   <%	
 
      Proiezione proiezione =  (Proiezione)request.getAttribute("proiezione"); 
      Sala sala =  (Sala)request.getAttribute("sala");        
 	  Biglietto biglietto = (Biglietto)request.getAttribute("biglietto");

   
 	//Biglietto biglietti=(Biglietto)session.getAttribute("biglietti");

      %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STAMAP IL BIGLIETTO</title>

 <style type ="text/css">	
	@import url("css/biglietto.css");
</style>


</head>
<body>


<div  class="c-container">

<h1 class="a"> AMERICAN</h1>


<div class="container">

  <div class="infosx">
  <br>
    <p>Codice Biglietto:</p> &nbsp;&nbsp;<span><%=biglietto.getBiglietto() %></span>  <br><br>
     <p>Data :</p>     &nbsp;&nbsp; <span><%=proiezione.getDataStr() %></span>  <br><br>
      <p>Ora:</p>     &nbsp;&nbsp; <span><%=proiezione.getFasciaOrariaStr() %></span>  <br><br>
     <p>Sala:</p>      &nbsp;&nbsp;  <span><%=sala.getSala() %></span>   <br><br>
     <p>Prezzo:</p>  &nbsp;&nbsp; <span><%=biglietto.getPrezzoFinale() %></span>   <br><br>

         

      </div>
      
      <div class="infodx">
      
    <br>  
      <p>Titolo:</p>
    <h1><%=proiezione.getFilm() %></h1>  
    <hr>
     <p>Posto:</p>  &nbsp;&nbsp;  <span><%=biglietto.getPosto() %></span>
      
     

      </div>

</div>
</div>

</body>
</html>