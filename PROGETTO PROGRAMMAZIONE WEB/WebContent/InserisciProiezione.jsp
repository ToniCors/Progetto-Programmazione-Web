<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*,modelDM.*"%>
<%
  ArrayList<Film> films = new ArrayList<Film>();
    GregorianCalendar data = new GregorianCalendar();
    int giorno = data.get(Calendar.DAY_OF_MONTH);
    int mese = data.get(Calendar.MONTH);
    
   films = new FilmModelDM().doRetrieveAll();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="script/validazioneProiezione.js" type="text/javascript"></script>
<title>Proiezione</title>
<style type ="text/css">	
			
	@import url("css/home.css");
	@import url("css/registrazione.css");
</style>
</head>
<%@ include file="MenuLoggAdmin.html" %>  

<body>

  <div class="form">

<div class="logADM">
<h2>Inserisci Proiezione</h2>

<form name="insPro"   id="insPro" method="post" onsubmit="return validazioneProiezione()" action ="InserimentoProiezione"> 


<p id="mf">&nbsp;</p>  
Film <br>
<select name ="Film">
<option value="00">&nbsp;</option>
<%for(int i =0;i<films.size();i++) {%>
<option value="<%=films.get(i).getTitolo() %>"><%=films.get(i).getTitolo() %></option>
<%} %>
</select>


<br><br>

<p id="mfo"> &nbsp;</p>
Fascia Oraria <br>
<select name ="FasciaOraria">
<option value="00">&nbsp;</option>
<option value="01">1</option>
<option value="02">2</option>
<option value="03">3</option>
</select>
<br><br>

<p id="mpb"> &nbsp;</p>
Prezzo Base<br>
<input type = "text" name ="PrezzoBase" onblur="valPrezzoBase()" >* 
<br><br>


<p id="m3D"> &nbsp;</p>
  3D * <br>
      SI:<input type = "radio" name = "DDD" value="true" >
       NO:<input type = "radio" name = "DDD" value="false"> 

<br><br>


<p id="mdata">&nbsp;</p> 
Data  :* <br>
GIORNO: <select name ="giorno">
<option value="00">&nbsp;</option>

<%for(int k =1;k<=31;k++) {%>
<option value="<%=k %>"><%=k %></option>
<%} %>
</select>

MESE: <select name ="mese">
<option value ="00">&nbsp;</option>

<%for(int j =mese+1;j<=12;j++) {%>
<option value="<%=j %>"><%=j+1 %></option>
<%} %>

</select>
<br>
ANNO:<select name ="anno">
<option value ="00">&nbsp;</option>
<option value ="2016">2016</option>
 </select>
 <br><br>
 
<input class="invia" type="submit" value="invia" >

</form>
</div>
<%@ include file="footer.html" %>
</body>
</html>