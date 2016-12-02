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

<title>FOODS</title>

 <style type ="text/css">			
	@import url("css/foods.css");
</style>

<script type="text/javascript"> 
  $(document).ready(function() {  
   $("li.foods").css({"background-color":"rgba(255, 102, 255, 0.6)"});
     
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

<div class="tabella">
<table id="foods">
   <tr>
   <td id ="cibo">
   <div id = "img">
   <img src="css/img/food/patatine.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt" >
  <section>
    <h2>PATATINE FRITTE </h2>
    <article>Patatine tagliate e fritte al momento</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <td id="drink">
   <div id = "img">
   <img src="css/img/food/naturale.gif" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt" >
   <section>
    <h2>ACQUA NATURALE </h2>
    <article>Acqua minerale naturale</article>
    <h5>prezzo : 0,70 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <tr>
   <td id ="cibo">
   <div id = "img">
   <img src="css/img/food/popcorn.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>POP CORN </h2>
    <article>Chicci di mais scoppiati</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <td id="drink">
   <div id = "img">
   <img src="css/img/food/lete.jpeg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>ACQUA FRIZZANTE </h2>
    <article>Acqua effervescente naturale</article>
    <h5>prezzo : 1,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <tr>
   <td id ="cibo">
   <div id = "img">
   <img src="css/img/food/ali.jpeg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>ALI DI POLLO</h2>
    <article>Ali di pollo infarinate,panate e fritte </article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <td id="drink">
   <div id = "img">
   <img src="css/img/food/coca.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
  <section>
    <h2>COCA-COLA </h2>
    <article>Bevanda analcolica a base di caffeina</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <tr>
   <td id ="cibo">
   <div id = "img">
   <img src="css/img/food/nachos.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>NACHOS</h2>
    <article>Triangolini di farina di mais accompagnati da salsa piccante</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <td id="drink">
   <div id = "img">
   <img src="css/img/food/aranciata.png" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>ARANCIATA FANTA</h2>
    <article>Bevanda analcolica a base di arancia</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <tr>
   <td id ="cibo">
   <div id = "img">
   <img src="css/img/food/hotdog.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>HOT DOG</h2>
    <article>Panino con hotdog,cipolla,cetriolini,ketcup,senape</article>
    <h5>prezzo : 3,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <td id="drink">
   <div id = "img">
   <img src="css/img/food/coca0.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>COCA-COLA ZERO </h2>
    <article>Bevanda analcolica a base di caffeina con zero calorie</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <tr>
   <td id ="cibo">
   <div id = "img">
   <img src="css/img/food/hamburger.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>HAMBURGER</h2>
    <article>Panino con hamburgher,cipolla,pomodoro e insalata</article>
    <h5>prezzo : 5,00 &#8364; </h5>
  </section>
   </div>
   </td>
   
   <td id="drink">
   <div id = "img">
   <img src="css/img/food/redbull.jpg" alt ="pat" width ="200" height ="200">
   </div>
   
   <div id = "txt">
   <section>
    <h2>RED BULL</h2>
    <article>Bevanda energetica analcolica al sapore di fragola</article>
    <h5>prezzo : 2,00 &#8364; </h5>
  </section>
   </div>
   </td>    
	 
    </table>	

</div>
</div>



<%@ include file="footer.html" %>
</body>
</html>