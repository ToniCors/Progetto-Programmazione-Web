
//validazione TITOLO
function valTitolo(){
var u = document.forms["insFilm"]["Titolo"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mF").innerHTML = "IL TITOLO  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mF").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}

//validazione GENERE
function valGenere(){
var u = document.forms["insFilm"]["Genere"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mG").innerHTML = "IL GENERE  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mG").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}


//validazione REGISTA
function valRegista(){
var u = document.forms["insFilm"]["Regista"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mR").innerHTML = "IL REGISTA  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mR").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}

//validazione TRAILER
function valTrailer(){
var u = document.forms["insFilm"]["Trailer"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mT").innerHTML = "IL TRAILER  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mT").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}

//validazione TRAMA
function valTrama(){
var u = document.forms["insFilm"]["Trama"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mTR").innerHTML = "LA TRAMA  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mTR").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}


//validazione IMMAGINE
function valImmagine(){
var u = document.forms["insFilm"]["Immagine"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mI").innerHTML = "L'IMMAGINE  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mI").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}

//validazione DURATA
function valDurata(){
var u = document.forms["insFilm"]["Durata"].value;

 if (u == null || u == "" || (isNaN(u)) ) {	 
	      
	     document.getElementById("mD").innerHTML = "LA DURATA  E' OBLIGATORIO E DEVE ESSERE UN NUMERO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mD").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}

//validazione film totale

function validazioneFilm(){
if(valDurata() && valImmagine() && valTrama() && valTrailer() && valTitolo() && valGenere() && valRegista()){
	return true;
}

else{
	alert("Opss c'e' qualche errore in qualche campo !!");
	return false;
}

}

