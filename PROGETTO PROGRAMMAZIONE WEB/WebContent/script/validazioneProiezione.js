//validazione Film
function valFilm(){
 var n = document.forms["insPro"]["Film"].value;
 
if (n == null || n == "" || n=="00") {	 
	       
	     document.getElementById("mf").innerHTML = "IL FILM E' OBLIGATORIO \n";		 
         return false;
        
    }
	else{
		 document.getElementById("mf").innerHTML = "ok !! \n";		 
         return true;
		
	}
	
	}
	
//validaizone FasciaOraria	
function valFascia(){
 var co = document.forms["insPro"]["FasciaOraria"].value;
 
 if (co == null || co == "" || co=="00") {	 
	     
	     document.getElementById("mfo").innerHTML = "LA FASCIA ORARIA E' OBLIGATORIO \n";		 
         return false;
        
    }
	else{
		 document.getElementById("mfo").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}
	
//validazione Prezzo Base
function valPrezzoBase(){
var u = document.forms["insPro"]["PrezzoBase"].value;
 
 if (u == null || u == "" || isNaN(u)) {	 
	      
	     document.getElementById("mpb").innerHTML = "IL PREZZO BASE  E' OBLIGATORIO E DEVE ESSERE UN NUMERO";		 
         return false;
        
    }
	
	else{
		 document.getElementById("mpb").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}
	

	
	

	


//validazione data	
function valData(){
  var gg = document.forms["insPro"]["giorno"].value;
	var mm = document.forms.insPro.mese.value;
	var aa = document.forms["insPro"]["anno"].value;
	
 
 if ( gg=="00"||mm == "00"|| aa =="00"){	
    	  
	     document.getElementById("mdata").innerHTML = "LA DATA E' OBLIGATORIO";
		  return false;}	

     else if(mm==3 && gg ==31){
            
    	   document.getElementById("mdata").innerHTML = "APRILE NON HA 31 GIORNI";
    	   return false;}

     else if(mm==5 && gg ==31){
          
	   document.getElementById("mdata").innerHTML = "GIUGNO NON HA 31 GIORNI";
	   return false;}

     else if(mm==8 && gg ==31){
           
	   document.getElementById("mdata").innerHTML = "SETTEMBRE NON HA 31 GIORNI";
	   return false;}

     else if(mm==10 && gg ==31){
     
	   document.getElementById("mdata").innerHTML = "NOVEMBRE NON HA 31 GIORNI";
	   return false;}

     else if(mm==1 && gg >29){
   
	   document.getElementById("mdata").innerHTML = "FEBBRARIO NON HA NE 31 NE 30 GIORNI";
	   return false;}

     else if(mm==1 && gg ==29 && (aa%4!=0)){
    	
	   document.getElementById("mdata").innerHTML = "QUEST ANNO NON E' BISESTILE";
	   return false;}
	
	else{
		 document.getElementById("mdata").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}


	
//validazione totale Inserimento Proiezione
function validazioneProiezione(){
	var s = document.getElementsByName("DDD")	

	
	var c = -1

for(var i=0; i < s.length; i++){
  if(s[i].checked) {
     c = i; 
  }
}
	
if (c == -1) {
	
	document.getElementById("m3D").innerHTML = "IL CAMPO E' OBLIGATORIO";
	  return false; 		  
}

else{
	
	
	document.getElementById("m3D").innerHTML = "ok!";}


var k = valData();
var r =false;
var y=true;


if(c<-1 || !k){	
    y= false; 
   
}

if(valFilm() && valFascia() && valPrezzoBase() ){
	r=true
	
}

if(!r||!y){
	
	return false;
}

else{
	
	document.getElementById("m3D").innerHTML = "ok !!";
	 
		  return true; 
		 
	
}	
	
	
	
	
	
}
