//validazione nome
function valNome(){
 var n = document.forms["reg"]["nome"].value;
 
if (n == null || n == "") {	 
	       
	     document.getElementById("mn").innerHTML = "IL NOME E' OBLIGATORIO \n";		 
         return false;
        
    }
	else{
		 document.getElementById("mn").innerHTML = "ok !! \n";		 
         return true;
		
	}
	
	}
	
//validaizone cognome	
function valCognome(){
 var co = document.forms["reg"]["cognome"].value;
 
 if (co == null || co == "") {	 
	     
	     document.getElementById("mc").innerHTML = "IL  COGNOME E' OBLIGATORIO \n";		 
         return false;
        
    }
	else{
		 document.getElementById("mc").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}
	
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
	
//validazione email	
function valEmail(){
  var e = document.forms["reg"]["email"].value;
	var email_reg_exp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
 
 if (!email_reg_exp.test(e) || (e == "") || (e == null)) {	 
    	  
	     document.getElementById("me").innerHTML = "L' EMAIL DEVE ESSERE DEL TIPO aa@aa.aa";		 
         return false;
        
    }
	
	else{
		 document.getElementById("me").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}
	
//validazione cellulare	
function valTel(){
  var t = document.forms["reg"]["cellulare"].value;
	
 
 if (t == null || t == "" || (isNaN(t))  || t.length<9||t.length>10) {	
    	
	     document.getElementById("mcell").innerHTML = "IL RECAPTO TELEFONICO DEVE ESSERE DI ALMENO 9 NUMERI E MASSIMO 10";
		  return false;
        
    }
	
	else{
		 document.getElementById("mcell").innerHTML = "ok !!";		 
         return true;
		
	}
	
	}

//validazione data	
function valData(){
  var gg = document.forms["reg"]["giorno"].value;
	var mm = document.forms.reg.mese.value;
	var aa = document.forms["reg"]["anno"].value;
	
 
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


//validazione totale login
function validazione2(){
	if(valUsername() && valPassword()){
	
        }
   else{
	alert("Opss c'e' qualche errore in qualche campo !!");
	return false;}
	
}
	
	
//validazione totale Registrazione
function validazione(){
	var s = document.getElementsByName("sesso")	

	
	var c = -1

for(var i=0; i < s.length; i++){
  if(s[i].checked) {
     c = i; 
  }
}
	
if (c == -1) {
	
	document.getElementById("ms").innerHTML = "IL SESSO E' OBLIGATORIO";
	  return false; 		  
}

else{
	
	document.getElementById("ms").innerHTML = "ok!";}


var k = valData();
var r =false;
var y=true;


if(c<-1 || !k){	
    y= false; 		  
}

if(valNome() && valCognome() && valUsername() && valPassword() && valEmail() && valTel()){
	r=true
}

if(!r||!y){
	alert("Opss c'e' qualche errore in qualche campo !!");
	return false;
}

else{
	
	document.getElementById("ms").innerHTML = "ok !!";
		  return true; 
	
}	
	
	
	
	
	
}
	