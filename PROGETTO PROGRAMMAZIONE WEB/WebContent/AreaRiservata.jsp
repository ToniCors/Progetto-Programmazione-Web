<%@page import="modelDM.ProiezioneModelDM"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*,modelDM.*"%>
    
   <%	
   Cliente cliente = (Cliente)session.getAttribute("cliente");
        if(cliente==null){
     response.sendRedirect("Login.jsp");}
     else{
			ArrayList<Biglietto> biglietti =new BigliettoModelDM().doRetrieveByCliente(cliente.getUsername());

			
		
			
			
			
			
    	 %>
     
     

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
 <script src="script/areaRiservata.js" type="text/javascript"></script>


<!--  

 <script type="text/javascript"> 
  $(document).ready(function() {  
   $("li.areaR").css({"background-color":"rgba(255,255,255, 0.3)"});
     
 }); </script> -->


<title>AREA PERSONALE</title>

 <style type ="text/css">			
	
	@import url("css/riservata.css");
</style>

</head>
<body>
<%@ include file="menuLogged.html" %>

<div class="body">


 <div class="areariservata">
<label class="acquisti" onclick="s()">ACQUISTI  &nbsp;&nbsp;&nbsp;</label> 
<label class="dati" onclick="ss()">   DATI PERSONALI</label> 

<script >

</script>

     <div class="datipersonali">
        <p>NOME: <%=cliente.getNome()%></p>
        <p>COGNOME: <%=cliente.getCognome()%></p>
        <p>DATA DI NASCITA: <%=cliente.getDataNascitaStr()%></p>
        <p>USERNAME: <%=cliente.getUsername()%></p>
        <p>EMAIL: <%=cliente.getEmail()%></p>
        <p>PASSWORLD: <%=cliente.getPassword()%></p>
        <p>SESSO: <%=cliente.getSesso()%> </p>
        <p>CELLULARE: <%=cliente.getCellulare()%></p>
        
      </div>
      <div class="acquisti">
      
      <div class ="tabella">
      <table>
      <tr><th>CODICE BIGLIETTO</th><th>SCARICA</th><th>TITOLO</th><th>SALA</th><th>POSTO</th><th>DATA PROIEZIONE</th><th>ORA PROIEZIONE</th><th>PREZZO</th><th>3D</th><th>DATA  ACQUISTO</th><th>ORA  ACQUISTO</th></tr>
      <% if(biglietti !=  null){
          for(int i=0 ; i<biglietti.size();i++){ 
          Proiezione proiezione = new ProiezioneModelDM().doRetrieveByKey(((Biglietto)biglietti.get(i)).getProiezione());
          Sala sala =new SalaModelDM().doRetrieveByProiezione(((Biglietto)biglietti.get(i)).getProiezione());
        
          %>
        	 <tr><td><%=biglietti.get(i).getBiglietto() %></td>
        	 
        	 <td>  <a href="stampaBiglietto?idBiglietto=<%=biglietti.get(i).getBiglietto() %>"><img src ="css/img/download.png" width="60" height="60"></td> </a>
        	 <td><%=proiezione.getFilm() %></td><td><%=sala.getSala()%></td>
        	 <td><%=biglietti.get(i).getPosto() %></td>
        	<td><%=proiezione.getDataStr()%> </td>
        	 <td><%=proiezione.getFasciaOrariaStr()%></td>        	 
        	 <td><%=biglietti.get(i).getPrezzoFinale() %></td>
        	 <td><%=proiezione.is3D()%></td>
        	  <td><%=biglietti.get(i).getDataAcquistoStr() %></td>
        	 <td><%=biglietti.get(i).getOraAcquistoStr() %></td>
        	 
        	 </tr> 
           
           <%} }%>
     
     
      </table>
      </div>
      
      </div>


 </div>



</div>
<%@ include file="footer.html" %> 
</body> 
</html>  <%} %>