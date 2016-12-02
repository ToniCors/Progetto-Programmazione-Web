<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="script/validazioneFilm.js" type="text/javascript"></script>
<title>Admin</title>
<style type ="text/css">	
	@import url("css/slideshow.css");		
	@import url("css/home.css");
	@import url("css/registrazione.css");
</style>
</head>
<%@ include file="MenuLoggAdmin.html" %>  

<body>

  <div class="form">

<div class="logADM">

<h1>Inserisci Film</h1>
<form name="insFilm"   id="insFilm" method="post" onsubmit="return validazioneFilm()" action ="InserimentoFIlm"> 

<p id="mF"> &nbsp;</p>
Titolo : &nbsp;<input type = "text" name = "Titolo" onblur="valTitolo()">* <br><br>
<p id="mG"> &nbsp;</p>
Genere :&nbsp;<input type = "text" name = "Genere" onblur="valGenere()">* <br><br>
<p id="mD"> &nbsp;</p>
Durata :&nbsp;<input type = "text" name = "Durata" onblur="valDurata()">* <br><br>
<p id="mR"> &nbsp;</p>
Regista:&nbsp;<input type = "text" name = "Regista" onblur="valRegista()">* <br><br>
<p id="mT"> &nbsp;</p>
Trailer:&nbsp;<input type = "text" name = "Trailer" onblur="valTrailer()">* <br><br>
<p id="mTR"> &nbsp;</p>
Trama :&nbsp;<input type = "text" name = "Trama" onblur="valTrama()">* <br><br>
<p id="mI"> &nbsp;</p>
Immagine :&nbsp;<input type = "text" name = "Immagine" onblur="valImmagine()">* <br><br>
<input class="invia" type="submit" value="invia" >
</form>


</div>
<%@ include file="footer.html" %>
</body>
</html>