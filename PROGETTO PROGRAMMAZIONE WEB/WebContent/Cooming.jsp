<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*,modelDM.*"%>
   
   <%	
 
	 Cliente cliente = (Cliente)session.getAttribute("cliente");
   Boolean adminR=(Boolean) session.getAttribute("adminR");
   
   GregorianCalendar oggi =new GregorianCalendar();    
   String lunedi= Proiezione.GetMonday(oggi);
   
   String[] g = lunedi.split("-");
		     
     int aa=Integer.parseInt(g[0]);
		int mm=Integer.parseInt(g[1]);
		int gg=Integer.parseInt(g[2]);		
				GregorianCalendar	mer=new GregorianCalendar(aa,mm,(gg+9));
				
				String mercoledi = ""+mer.get(GregorianCalendar.YEAR)+"-"+
                     ( mer.get(GregorianCalendar.MONTH))+"-"+
		                  mer.get(GregorianCalendar.DAY_OF_MONTH);
				
GregorianCalendar	lun=new GregorianCalendar(aa,mm,(gg+7));
				
				String lunediProssimo = ""+lun.get(GregorianCalendar.YEAR)+"-"+
                     ( lun.get(GregorianCalendar.MONTH))+"-"+
		                  lun.get(GregorianCalendar.DAY_OF_MONTH);
       
  ProiezioneModelDM pm = new ProiezioneModelDM();
		FilmModelDM fm = new FilmModelDM();		
		ArrayList<Proiezione> lunediPro =  pm.doRetrieveDistinctByDate(lunediProssimo);
		ArrayList<Proiezione> mercolediPro =  pm.doRetrieveDistinctByDate(mercoledi);
		Film f1,f2,f3,f4,f5,f6,f7,f8;
		
		f1= fm.doRetrieveByKey(lunediPro.get(0).getFilm());
		f2= fm.doRetrieveByKey(lunediPro.get(1).getFilm());
		f3= fm.doRetrieveByKey(lunediPro.get(2).getFilm());
		f4= fm.doRetrieveByKey(lunediPro.get(3).getFilm());
		
		f5= fm.doRetrieveByKey(mercolediPro.get(0).getFilm());
		f6= fm.doRetrieveByKey(mercolediPro.get(1).getFilm());
		f7= fm.doRetrieveByKey(mercolediPro.get(2).getFilm());
		f8= fm.doRetrieveByKey(mercolediPro.get(3).getFilm());
		
    
      %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="http://beneposto.pl/jqueryrotate/js/jQueryRotateCompressed.js"></script>

 <script src="script/coming.js" type="text/javascript"></script>
 
 <title>COOMINS SOON</title>

<style type ="text/css">			
	@import url("css/films.css");
</style>

<script type="text/javascript"> 
  $(document).ready(function() {  
   $("li.csoon").css({"background-color":"rgba(0, 255, 255, 0.6)"});
      
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
<p class="intestazione"> I FILM DELLA PROSSIMA SETTIMANA </p>


<div class ="prog">

<div class ="progdx">

<div class="f1"> 

<div class="imgfilm"><img src="css/img/film/<%=f1.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
         <div class="infofilm">
                      <p class="titolo"><%=f1.getTitolo() %></p>
                      <p class="info">regia: <%=f1.getRegista()%></p>
                      <p class="info">durata: <%=f1.getDurata()%>  </p>
                      <p class="info">genere: <%=f1.getGenere()%> </p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f1.getTitolo()%>" >Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>  

<div class="f2"> 
<div class="imgfilm"><img src="css/img/film/<%=f2.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
           <div class="infofilm">
                      <p class="titolo"><%=f2.getTitolo() %></p>
                      <p class="info">regia: <%=f2.getRegista()%></p>
                      <p class="info">durata: <%=f2.getDurata()%> </p>
                      <p class="info">tipo: <%=f2.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f2.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>

<div class="f3"> 
<div class="imgfilm"><img src="css/img/film/<%=f3.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
           <div class="infofilm">
                      <p class="titolo"><%=f3.getTitolo() %></p>
                      <p class="info">regia: <%=f3.getRegista()%></p>
                      <p class="info">durata: <%=f3.getDurata()%> </p>
                      <p class="info">tipo: <%=f3.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f3.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>

<div class="f4"> 
<div class="imgfilm"><img src="css/img/film/<%=f4.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
           <div class="infofilm">
                      <p class="titolo"><%=f4.getTitolo() %></p>
                      <p class="info">regia: <%=f4.getRegista()%></p>
                      <p class="info">durata: <%=f4.getDurata()%></p>
                      <p class="info">tipo: <%=f4.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f4.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		   </div>
		
        </div> 
    </div>
</div>

<div class ="progsx">

<div class="f5"> 
<div class="imgfilm"><img src="css/img/film/<%=f5.getImmagine()%>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
         <div class="infofilm">
                      <p class="titolo"><%=f5.getTitolo() %></p>
                      <p class="info">regia: <%=f5.getRegista()%></p>
                      <p class="info">durata:<%=f5.getDurata()%></p>
                      <p class="info">tipo: <%=f5.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f5.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>

<div class="f6"> 
<div class="imgfilm"><img src="css/img/film/<%=f6.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
           <div class="infofilm">
                      <p class="titolo"><%=f6.getTitolo() %></p>
                      <p class="info">regia: <%=f6.getRegista()%></p>
                      <p class="info">durata: <%=f6.getDurata()%></p>
                      <p class="info">tipo: <%=f6.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f6.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>

<div class="f7"> 
<div class="imgfilm"><img src="css/img/film/<%=f7.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
           <div class="infofilm">
                      <p class="titolo"><%=f7.getTitolo() %></p>
                      <p class="info">regia: <%=f7.getRegista()%></p>
                      <p class="info">durata: <%=f7.getDurata()%></p>
                      <p class="info">tipo: <%=f7.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f7.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>

<div class="f8"> 
<div class="imgfilm"><img src="css/img/film/<%=f8.getImmagine() %>" width="200" height="300" alt=""   onmouseover="mouseIN(this)"  onmouseout="mouseOUT(this)"></div>
<div class="noimg">
          <div class="infofilm">
                      <p class="titolo"><%=f8.getTitolo() %></p>
                      <p class="info">regia:<%=f8.getRegista()%></p>
                      <p class="info">durata:<%=f8.getDurata()%></p>
                      <p class="info">tipo:<%=f8.getGenere()%></p>
					 <p class="trailer"><a href="filmTrailer?titolo=<%=f8.getTitolo()%>">Trailer/SchedaFilm</a></p> 
		</div>
				
     
   </div> 
</div>
</div>

     
   </div>  
   
   
   </div> 



<%@ include file="footer.html" %>
</body>
</html>