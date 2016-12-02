<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,oggetti.*"%>
   
   <%	
 
	 Cliente cliente = (Cliente)session.getAttribute("cliente");       
      Film film =  (Film)request.getAttribute("film"); 
      Proiezione proiezione =  (Proiezione)request.getAttribute("proiezione"); 
      Sala sala =  (Sala)request.getAttribute("sala");        
 	 ArrayList<?> biglietti = (ArrayList<?>)request.getAttribute("biglietti");

      %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" contenet="This web side is one seller movie"/>
<meta name="author" contenet=" Russo Gennaro Antonio Corsuto"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

 <script src="script/carrello.js" type="text/javascript"></script>

<title>Acquista</title>

 <style type ="text/css">		
	@import url("css/carello.css");
</style>


</head>
<body>

<%@ include file="menuLogged.html" %>  

<div class="body">

  <div class="carrello">

    <div class="carrellosx">
    
    
          <h2 class="selDis">SELEZIONA UN POSTO TRA QUELLI DISPONIBILI</h2>
          
           <div class="posti" id="postiSala">
           
           <img alt="DISPLAY" src="css/img/schermo.jpg" >
           <br><br><br><br> 
           
           <% for(int i =1 ; i<=100;i++){ %>
        	   <input class="bottonePosto"  id="posto<%=i%>" type ="submit" value="<%=i%>" name="<%=i%>" onclick="clickPosto(this)">
        	   
        	   <%if(i%5==0){ %>
        	   <label>&nbsp;&nbsp;&nbsp;&nbsp;</label> <%} %>
        	   
        	 <%if(i%10==0){ %>
        	   <br><%} %>
           
           <%} %>
           
         <%  if(biglietti!= null)
         {
        for(int i=0;i<biglietti.size();i++)	{  /* la variabile biglietti contiene i biglietti gia venduti per questa proiezione */
        	int pp =((Biglietto)biglietti.get(i)).getPosto();  %>
        	
        	
        	<!-- la variabile pp contiene ad ogni ciclo l'id dell posto da occupare -->
           <script>occupaPosto(<%= pp%>);/* la funzion eoccupa posto setta lo sfondo del o */
          </script>
            <% }} %>
           <script>
           vediPosti();</script>
           
           
          
                     </div>
                     <br>
                     <div class="legenda">LEGENDA <br><br>
                     <span> OCCUPATO
                      <input class="bottonePostoOcc"  type ="submit" value="&nbsp;&nbsp;" disabled="disabled">
                        &nbsp;&nbsp; </span> LIBERO
                         <input class="bottonePostoLib" type ="submit"  value="&nbsp;&nbsp;" disabled="disabled">
                           &nbsp;&nbsp; <span>
                         </span> SELEZIONATO
                         <input class="bottonePostoClik" type ="submit" value="&nbsp;&nbsp;"  disabled="disabled">
                            <span>
                         </span>
                     
                     </div>
                     
     <br><br><br><br>
     </div>

     <div class="carrellodx">
     
            <div class="riepilogo"  id="riepilogo">
            <p class="carrello">CARRELLO</p>
            <div class="infoproiezione">
            ID proiezione:&nbsp;&nbsp;<span id="proiezioneJason" class="altreinfo"><%=proiezione.getIdProiezione() %> </span>        <br>
            Prezzo:&nbsp;&nbsp;<span id="prezzoBase" class="altreinfo"><%=proiezione.getPrezzoBase() %> </span> <br>     
            Username:&nbsp;&nbsp;<span id="username" class="altreinfo"><%=cliente.getUsername()%></span> <br>       
           
           <div class="divaltreinfo">
          
          
          Data Proiezione:&nbsp;&nbsp;<span  class="altreinfo"><%=proiezione.getDataStr()%> </span> <br>
          
          Fascia Oraria:&nbsp;&nbsp;<span  class="altreinfo"><%=proiezione.getFasciaOrariaStr()%> </span> <br>
          
          Titolo Film:&nbsp;&nbsp;<span  class="altreinfo"><%=proiezione.getFilm()%> </span> <br>
          
          3D:&nbsp;&nbsp;<span  class="altreinfo"><%=proiezione.is3D()%></span> <br>
          
          Sala:&nbsp;&nbsp;<span  class="altreinfo"><%=sala.getSala()%> </span> <br>
          
           </div>
         <br><span>Altre Info </span>  <label onclick="info()" class="freccette" id="freccette">&laquo; &nbsp; &raquo;</label>
          
          <script >
     function info(){	
	     $("div.divaltreinfo").toggle();
	    
	    }
      </script>
          
           </div>
           <BR>
         
            <span class="biglietto" id="biglietto1"  title="1"></span>  
            <input class="annulla" id="annulla1" type ="submit" value="X" name="1" onclick="unClickPosto(this)">
            <BR><BR>
            <span class="biglietto" id="biglietto2" title="2"></span>
            <input class="annulla" id="annulla2" type ="submit" value="X" name="2" onclick="unClickPosto(this)">
            <BR><BR>
            <span class="biglietto" id="biglietto3" title="3"></span>
            <input class="annulla" id="annulla3" type ="submit" value="X" name="3" onclick="unClickPosto(this)">
            <BR><BR>
            <span class="biglietto" id="biglietto4" title="4"></span>
            <input class="annulla" id="annulla4" type ="submit" value="X" name="4" onclick="unClickPosto(this)">
            <BR><BR>
           <span class="biglietto" id="biglietto5" title="5"></span>
           <input class="annulla" id="annulla5" type ="submit" value="X" name="5" onclick="unClickPosto(this)">
            <BR><BR>
           <p id="totale" class="totale">TOTALE =  0 &euro;</p>
            
           
            </div>
            <div class="pagamento">
            
             <div> Seleziona il metodo di pagamento:</div>
             
                    <select name="Payment" class="Payment" onchange="cambiaCarta()">
                        <option value="1">MasterCard</option>
                        <option value="2">Visa</option>
                        <option value="3">PayPal</option>
                        <option value="4">postepay</option>
                        <option value="5">Maestro</option>
                        <option value="6">American Express</option>
                        <option value="7">Discover</option>
                        <option value="8">Aura</option>
                     </select>
                    
                    <div class="Numerocarta">
                    
                    <p  class="input">Numero carta</p>
                    <input id="NumeroCarta" class="input" type="text" name="NumeroCarta"> 
                    
                    <p  class="mailhidden">Email</p>
                    <input  id="paypalEmail" class="mailhidden" type="text" name="Email"> 
                
                                                    
                    </div>
            
            <!--  <p  class="pagamentop" >INSERISCI IL CODICE DELLA CARTA PER IL PAGAMENTO</p>
             <input  id="pagamentoc" class="campopagamento" type ="text" >--> 
                   
            </div>  
            
              
                   
               
            
            
            
            
            
            
            <div class="conferma">
           
             <input id="bottoneConferma"  class="bottoneConferma" type ="submit" value="CONFERMA"   onclick="conferma()">
                   
            </div>


      </div>

  </div>
<center><img class="filazero" src="css/img/filazero2.png"></center>

</div>


<%@ include file="footer.html" %>
</body>
</html>