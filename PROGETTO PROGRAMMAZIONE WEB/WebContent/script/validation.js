
//validazione username
function valUsername(){
var u = document.forms["reg"]["username"].value;

 if (u == null || u == "") {	 
	      
	     document.getElementById("mu").innerHTML = "L' USERNAME  E' OBLIGATORIO";	
	     return false;
        
    }
	
	else{
		 document.getElementById("mu").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}
	
//validazione password	
function valPassword(){
  var p = document.forms["reg"]["password"].value;

 if (p == null || p == "" ||p.length<=6) {	 
	     
	     document.getElementById("mp").innerHTML = "LA PASSWORD E' OBLIGATORIA E DEVE ESSERE DI ALMENO 6 CARATTERI";		 
	     return false;
        
    }
	
	else{
		 document.getElementById("mp").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}


//validazione usernameA
function valUsernameA(){
	var u = document.forms["regA"]["usernameA"].value;
	
	 if (u == null || u == "") {	 
		      
		     document.getElementById("muu").innerHTML = "L' USERNAME  E' OBLIGATORIO";	
		     
	         return false;
	        
	    }
		
		else{
			 document.getElementById("muu").innerHTML = "ok !!";		 
	         return true;
			
		}
		
		}
		
	//validazione passwordA
	function valPasswordA(){
	  var p = document.forms["regA"]["passwordA"].value;
	 
	 if (p == null || p == "" ) {	 
		     
		     document.getElementById("mpp").innerHTML = "LA PASSWORD E' OBLIGATORIA ";		 
		     
		     return false;
	        
	    }
		
		else{
			 document.getElementById("mpp").innerHTML = "ok !!";		 
	         return true;
			
		}
		
		}
	

//validazione totale login
function validazione2(){
	if(valUsername() && valPassword()){
	
        }
   else{
	alert("Opss c'e' qualche errore in qualche campo !!");
	return false;}
	
}

function validazione2A(){
	if(valUsernameA() && valPasswordA()){
	
        }
   else{
	alert("Opss c'e' qualche errore in qualche campo !!");
	return false;}
	
}

