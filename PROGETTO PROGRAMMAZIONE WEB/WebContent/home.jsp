<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*,modelDM.*"%>
   
   <%	
 
	 Cliente cliente = (Cliente)session.getAttribute("cliente");
     Boolean adminR=(Boolean) session.getAttribute("adminR");
 
   
   
     GregorianCalendar oggi =new GregorianCalendar();  
     String tod = ""+oggi.get(GregorianCalendar.YEAR)+"-"+
             ( oggi.get(GregorianCalendar.MONTH)+1)+"-"+
             oggi.get(GregorianCalendar.DAY_OF_MONTH);
     
     ProiezioneModelDM pm = new ProiezioneModelDM();
		FilmModelDM fm = new FilmModelDM();		
		ArrayList<Proiezione> pro =  pm.doRetrieveDistinctByDate(tod);
		
		Film f1,f2,f3,f4;
		int p1,p2,p3,p4;
		p1=Integer.parseInt(pro.get(0).getIdProiezione());
		p2=Integer.parseInt(pro.get(1).getIdProiezione());
		p3=Integer.parseInt(pro.get(2).getIdProiezione());
		p4=Integer.parseInt(pro.get(3).getIdProiezione());
		
		f1= fm.doRetrieveByKey(pro.get(0).getFilm());
		f2= fm.doRetrieveByKey(pro.get(1).getFilm());
		f3= fm.doRetrieveByKey(pro.get(2).getFilm());
		f4= fm.doRetrieveByKey(pro.get(3).getFilm());
    
      %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="icon" href="css/img/favicon.ico"  type="image/gif" sizes="16x16">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script src="script/slideshow.js"></script>
 <script src="script/home.js" type="text/javascript"></script>

<script type="text/javascript" src="script/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="http://beneposto.pl/jqueryrotate/js/jQueryRotateCompressed.js"></script>
<title>AMERICAN</title>

 <style type ="text/css">	
	@import url("css/slideshow.css");		
	@import url("css/home.css");
</style>

<script type="text/javascript"> 

<!-- scegli il colore -->

  $(document).ready(function() {
	  
   $("li.home").css({"background-color":"rgba(255, 255, 0, 0.6)"});
      });   
  

</script>



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

<div class="slideshow-container">

<div class="mySlides fade">
  
  <img src="css/img/photos/sl4.jpg" style="width:100%">

</div>

<div class="mySlides fade">
  
  <img src="css/img/photos/sl1.jpg" style="width:100%">

</div>

<div class="mySlides fade">
  
  <img src="css/img/photos/sl2.jpg" style="width:100%">
  
</div>

<div class="mySlides fade">
 
  <img src="css/img/photos/sl3.jpg" style="width:100%">

</div>

<div class="mySlides fade">
  
  <img src="css/img/photos/sl6.png" style="width:100%">
 
</div>

<div class="mySlides fade">
  
  <img src="css/img/filazero2.png" style="width:100%">
 
</div>




<a class="prev" onclick="plusSlides(-1)"><img src="css/img/freccoasx.ico"></a>
<a class="next" onclick="plusSlides(1)"><img src="css/img/freccoadx.ico"></a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
   <span class="dot" onclick="currentSlide(4)"></span> 
   <span class="dot" onclick="currentSlide(5)"></span> 
   <span class="dot" onclick="currentSlide(6)"></span> 
</div>

 <script src="script/slideshow.js"></script>

<%
GregorianCalendar today = new GregorianCalendar();
String day1=""+(today.get(GregorianCalendar.MONTH)+1)+"-"+today.get(GregorianCalendar.DAY_OF_MONTH);
GregorianCalendar d2 = new GregorianCalendar(2016,today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.DAY_OF_MONTH)+1);
String day2=""+(d2.get(GregorianCalendar.MONTH)+1)+"-"+d2.get(GregorianCalendar.DAY_OF_MONTH);

GregorianCalendar d3 = new GregorianCalendar(2016,today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.DAY_OF_MONTH)+2);
String day3=""+(d3.get(GregorianCalendar.MONTH)+1)+"-"+d3.get(GregorianCalendar.DAY_OF_MONTH);

GregorianCalendar d4 = new GregorianCalendar(2016,today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.DAY_OF_MONTH)+3);
String day4=""+(d4.get(GregorianCalendar.MONTH)+1)+"-"+d4.get(GregorianCalendar.DAY_OF_MONTH);

GregorianCalendar d5 = new GregorianCalendar(2016,today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.DAY_OF_MONTH)+4);
String day5=""+(d5.get(GregorianCalendar.MONTH)+1)+"-"+d5.get(GregorianCalendar.DAY_OF_MONTH);

GregorianCalendar d6 = new GregorianCalendar(2016,today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.DAY_OF_MONTH)+5);
String day6=""+(d6.get(GregorianCalendar.MONTH)+1)+"-"+d6.get(GregorianCalendar.DAY_OF_MONTH);

GregorianCalendar d7 = new GregorianCalendar(2016,today.get(GregorianCalendar.MONTH),today.get(GregorianCalendar.DAY_OF_MONTH)+6);
String day7=""+(d7.get(GregorianCalendar.MONTH)+1)+"-"+d7.get(GregorianCalendar.DAY_OF_MONTH);

%>


<div class="progday"> 
<div id="giorno" class="g1"><label class="day" id="day1" onclick=jason(this);><%=day1 %></label></div>
<div id="giorno" class="g2"><label class="day" id="day2" onclick=jason(this);><%=day2 %></label></div>
<div id="giorno" class="g3"><label class="day" id="day3" onclick=jason(this);><%=day3 %></label></div>
<div id="giorno" class="g4"><label class="day" id="day4" onclick=jason(this);><%=day4 %></label></div>
<div id="giorno" class="g5"><label class="day" id="day5" onclick=jason(this);><%=day5 %></label></div>
<div id="giorno" class="g6"><label class="day" id="day6" onclick=jason(this);><%=day6 %></label></div>
<div id="giorno" class="g7"><label class="day" id="day7" onclick=jason(this);><%=day7 %></label></div>
</div>

<script type="text/javascript">
$("label#day1").css({"background":"white"});
</script>

<div class="prog">

<div class="f1">
<div class="imgfilm"><img id="1I" src="css/img/film/<%=f1.getImmagine()%>" width="200" height="300" alt=""  onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)">  </div>
<div class="noimg">
         <div id="infofilm1" class="infofilm">
         
                      <span id="1F" class="titolo"><%=f1.getTitolo() %></span>
                    
                      <img id="1D" class="Dicon" src ="css/img/3dglass.png" width="70" height="70">
                      <%if(pro.get(0).is3D()) {%>
                       <script > show3Dicon("#1D");</script> 
                         <%} %>                 
                      
                      <p  id="1R" class="info">regia: <%=f1.getRegista() %></p>
                      <p  id="1D" class="info">durata: <%=f1.getDurata() %></p>
                      <p id="1G" class="info">genere: <%=f1.getGenere() %></p>
					 <p   class="trailer"><a id="1T" href="filmTrailer?titolo=<%=f1.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				<div class="bottoniora"> 
				<a id="1-f1" href="biglietti?proiezione=<%=p1%>"> <input  class="bottoneOra" type ="submit" value="16:00"> </a>
				<a id="1-f2" href="biglietti?proiezione=<%=p1+4%>" >  <input  class="bottoneOra" type ="submit" value="19:00"> </a> 
					<a id="1-f3"  href="biglietti?proiezione=<%=p1+8%>"  >  <input class="bottoneOra" type ="submit" value="21:00"> </a>
				 </div>
     
   </div> 
</div>


<div class="f2"> 
<div class="imgfilm"><img id="2I" src="css/img/film/<%=f2.getImmagine()%>" width="200" height="300" alt="" onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
         <div class="infofilm">
         
                      <span id="2F" class="titolo"><%=f2.getTitolo() %></span>
                    
                      <img id="2D" class="Dicon" src ="css/img/3dglass.png" width="70" height="70">
                    <%if(pro.get(1).is3D()) {%>
                       <script > show3Dicon("#2D");</script> 
                         <%} %>  
                     
                       <p  id="2R" class="info">regia: <%=f2.getRegista() %></p>
                       <p  id="2D" class="info">durata: <%=f2.getDurata() %></p>
                       <p id="2G" class="info">genere: <%=f2.getGenere() %></p>
					 <p   class="trailer"><a id="2T" href="filmTrailer?titolo=<%=f2.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				<div class="bottoniora"> 
					  <a id="2-f1" href="biglietti?proiezione=<%=p2%>"><input  class="bottoneOra" type ="submit" value="16:00"> </a>
					  <a id="2-f2" href="biglietti?proiezione=<%=p2+4%>"><input class="bottoneOra" type ="submit" value="19:00"> </a>
					  <a id="2-f3"  href="biglietti?proiezione=<%=p2+8%>"> <input class="bottoneOra" type ="submit" value="21:00"> </a>
				 </div>
     
   </div> 
</div>


<div class="f3">
<div class="imgfilm"><img id="3I" src="css/img/film/<%=f3.getImmagine()%>" width="200" height="300" alt="" onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
         <div class="infofilm">
         
                      <span  id="3F" class="titolo"><%=f3.getTitolo() %></span >
                     
                      <img id="3D" class="Dicon" src ="css/img/3dglass.png" width="70" height="70">
                      <%if(pro.get(2).is3D()) {%>
                       <script > show3Dicon("#3D");</script> 
                         <%} %>  
                      <p  id="3R" class="info">regia: <%=f3.getRegista() %></p>
                      <p  id="3D" class="info">durata: <%=f3.getDurata() %></p>
                      <p id="3G" class="info">genere: <%=f3.getGenere() %></p>
					 <p   class="trailer"><a id="3T" href="filmTrailer?titolo=<%=f3.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				<div class="bottoniora"> 
					  <a id="3-f1" href="biglietti?proiezione=<%=p3%>"><input  class="bottoneOra" type ="submit" value="16:00"> </a>
					  <a id="3-f2" href="biglietti?proiezione=<%=p3+4%>"><input  class="bottoneOra" type ="submit" value="19:00"> </a>
					  <a id="3-f3" href="biglietti?proiezione=<%=p3+8%>"><input  class="bottoneOra" type ="submit" value="21:00"> </a>
				 </div>
     
   </div> 
</div>


<div class="f4"> 
<div class="imgfilm"><img id="4I" src="css/img/film/<%=f4.getImmagine()%>" width="200" height="300" alt="" onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
         <div class="infofilm">
         
                      <span  id="4F" class="titolo"><%=f4.getTitolo()%></span>
                     
                      <img id="4D" class="Dicon" src ="css/img/3dglass.png" width="70" height="70">
                        <%if(pro.get(3).is3D()) {%>
                       <script > show3Dicon("#4D")</script> 
                         <%} %>  
                       
                      <p  id="4R" class="info">regia: <%=f4.getRegista() %></p>
                      <p  id="4D" class="info">durata: <%=f4.getDurata() %></p>
                      <p id="4G" class="info">genere: <%=f4.getGenere() %></p>
					 <p   class="trailer"><a id="4T" href="filmTrailer?titolo=<%=f4.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				<div class="bottoniora"> 
					  <a id="4-f1" href="biglietti?proiezione=<%=p4%>"> <input  class="bottoneOra" type ="submit" value="16:00"> </a>
					  <a id="4-f2" href="biglietti?proiezione=<%=p4+4%>"><input  class="bottoneOra" type ="submit" value="19:00"> </a>
					  <a id="4-f3" href="biglietti?proiezione=<%=p4+8%>"><input  class="bottoneOra" type ="submit" value="21:00"> </a>
				 </div>
     
   </div> 
</div>


</div>

</div>


<%@ include file="footer.html" %>
</body>
</html>