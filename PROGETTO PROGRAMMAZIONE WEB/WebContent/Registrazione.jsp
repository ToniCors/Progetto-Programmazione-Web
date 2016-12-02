<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.Cliente"%>
   
   <%	
 
	 Cliente cliente = (Cliente)session.getAttribute("cliente");
      Integer errore =  (Integer)request.getAttribute("erroreR");  
      if(cliente!=null){
       response.sendRedirect("AreaRiservata.jsp");}
 
    
      %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
 <script src="script/val.js" type="text/javascript"></script>
<title>REGISTRATI SU AMERICAN !</title>

         
 <style type ="text/css">	
	@import url("css/registrazione.css");
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
<br>

<script> 

$("p.erroreusername").css({"display":"none"});
$("p.erroreemail").css({"display":"none"});

</script>


<p class="erroreemail">   EMAIL GIA ESISTENTE </p>
<p class="erroreusername">   USERNAME GIA ESISTENTE </p>


<%if(errore!=null && errore==2 ) {%>

<script>

$("p.errorepass").css({"display":"inherit"});
$("p.erroreusername").css({"display":"none"});

</script>
<%} %>

<%if(errore!=null && errore==1) {%>
<script>

$("p.erroreusername").css({"display":"inherit"});
$("p.errorepass").css({"display":"none"});

</script>
<%} %> 

<%if(errore!=null && errore==3) {%>
<script>

$("p.erroreusername").css({"display":"inherit"});
$("p.errorepass").css({"display":"inherit"});

</script>
<%} %> 

<br>

<div class="form">
<div class="log">
<p class="nolog"> <h1> Registrati  !</h1></p>
<form name="reg"   id="registrazione" method="post" onsubmit="return validazione()" action ="ClienteRegistrazione"> 
<p id="mn">&nbsp;</p>

Nome:      <input type = "text" name = "nome"  onblur="valNome()">*  
<br><br> <p id="mc">&nbsp;</p>
Cognme:    <input type = "text" name = "cognome" onblur="valCognome()">* 
<br><br> <p id="mu">&nbsp;</p>
Username:  <input type = "text" name = "username" onblur="valUsername()">*
<br><br> <p id="mp">&nbsp;</p>
Password:  <input type = "password" name = "password" onblur="valPassword()" >*  
<br><br> <p id="me">&nbsp;</p> 
Email:     <input type = "email" name = "email" onblur="valEmail()" >* 
<br><br> <p id="mcell">&nbsp;</p>
Cellulare: <input type = "text" name = "cellulare" onblur="valTel()">* 

<br><br> <p id="ms">&nbsp;</p>
Sesso:* <br>M:<input type = "radio" name = "sesso" value="M" >
       F:<input type = "radio" name = "sesso" value="F"> 
	   
<br><br>
<p id="mdata">&nbsp;</p> 
   
Data Di Nascita :* <br>
GIORNO: <select name ="giorno">
<option value="00">&nbsp;</option>
<option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option>
</select>

MESE: <select name ="mese">
<option value ="00">&nbsp;</option>
<option value="0">01</option><option value="1">02</option><option value="2">03</option><option value="3">04</option><option value="4">05</option><option value="5">06</option><option value="6">07</option><option value="7">08</option><option value="8">09</option><option value="9">10</option><option value="10">11</option><option value="11">12</option>
</select>

ANNO:<select name ="anno">
<option value ="00">&nbsp;</option>
<option value="1936">1936</option><option value="1937">1937</option><option value="1938">1938</option><option value="1939">1939</option><option value="1940">1940</option><option value="1941">1941</option><option value="1942">1942</option><option value="1943">1943</option><option value="1944">1944</option><option value="1945">1945</option><option value="1946">1946</option><option value="1947">1947</option><option value="1948">1948</option><option value="1949">1949</option><option value="1950">1950</option><option value="1951">1951</option><option value="1952">1952</option><option value="1953">1953</option><option value="1954">1954</option><option value="1955">1955</option><option value="1956">1956</option><option value="1957">1957</option><option value="1958">1958</option><option value="1959">1959</option><option value="1960">1960</option><option value="1961">1961</option><option value="1962">1962</option><option value="1963">1963</option><option value="1964">1964</option><option value="1965">1965</option><option value="1966">1966</option><option value="1967">1967</option><option value="1968">1968</option><option value="1969">1969</option><option value="1970">1970</option><option value="1971">1971</option><option value="1972">1972</option><option value="1973">1973</option><option value="1974">1974</option><option value="1975">1975</option><option value="1976">1976</option><option value="1977">1977</option><option value="1978">1978</option><option value="1979">1979</option><option value="1980">1980</option><option value="1981">1981</option><option value="1982">1982</option><option value="1983">1983</option><option value="1984">1984</option><option value="1985">1985</option><option value="1986">1986</option><option value="1987">1987</option><option value="1988">1988</option><option value="1989">1989</option><option value="1990">1990</option><option value="1991">1991</option><option value="1992">1992</option><option value="1993">1993</option><option value="1994">1994</option><option value="1995">1995</option><option value="1996">1996</option><option value="1997">1997</option><option value="1998">1998</option><option value="1999">1999</option><option value="2000">2000</option><option value="2001">2001</option><option value="2002">2002</option><option value="2003">2003</option><option value="2004">2004</option><option value="2005">2005</option><option value="2006">2006</option>
                                          
</select>
<br><br>
<input class="invia" type="submit" value="invia" >
<br><br>
</form>
</div>
</div></div>

<%@ include file="footer.html" %>
</body>
</html>