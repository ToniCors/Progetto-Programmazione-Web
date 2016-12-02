
function cambiaCarta(){
	
	var Payment=$('.Payment').val();
	if(Payment=='3'){
		$('.Numerocarta .input').hide();		
		$('.mailhidden').show();		

}  else{
	$('.Numerocarta .input').show();
	$('.mailhidden').hide();
}
	
}




function vediPosti(){
	$("#postiSala").toggle();
}

function occupaPosto(i){
	document.getElementById("posto"+i).setAttribute("disabled","disabled");
	$("#posto"+i).css({"background":"red"});
	
}

function disableBottom(){
	$(".bottoneConferma").css({"display":"none"});	
}

function ableBottom(){
	$(".bottoneConferma").css({"display":"inline"});	
}


function confermaP(){
	
	
	var yy =document.getElementById("confermaP").value;
	
	if(yy=="" || isNaN(yy) || yy ==null || yy<1){
		$("#confermaP").css({"background":"red"})
	alert("PREZZO INSERITO NON CORRETTO");
	
	}
	
	else{
	alert("PREZZO CAMBIATO");
	
	$("#confermaP").css({"background":"white"})
	
	  $.ajax({
		  type:'GET',
		 url:'cambiaPrezzo?idProiezione='+$("span#proiezioneJason").text()+'&nuovoPrezzo='+yy,
		 headedrs:{
				Accept: "application/json; charset=utf-8",
	      "Content-type": "application/json; charset=utf-8",
			},
			
			success:function(result){	  
	   window.location.assign("home.jsp");
	}
	  })
	
}
	
}


function conferma(){
	var flag =0;
	
	var Payment=$('.Payment').val();
	
	if(Payment!='3'){	
	var yy =document.getElementById("NumeroCarta").value;
	if(yy=="" || yy==null || yy.length<16){
		$("#NumeroCarta").css({"background":"red"})
		flag=1;
	alert("INSERISCI CORRETTAMENTE IL NUMERO DELLA CARTA");	
	} 
	
	}
	
	
	
	else if(Payment=='3'){	
	var yyy =document.getElementById("paypalEmail").value;
	var email_reg_exp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
	 
	 if (!email_reg_exp.test(yyy) || (yyy== "") || (yyy == null)) {	 
		 
		 $("#paypalEmail").css({"background":"red"})
		 flag=1;
	      alert("INSERISCI CORRETTAMENTE L' EMAIL");	
	}
	 
	}
	
	if(flag==0){
	alert("confermato");
	
	$("#NumeroCarta").css({"background":"white"});
	$("#paypalEmail").css({"background":"white"});
	
	  $.ajax({
		  type:'GET',
		 url:'confermaAcquisto?idProiezione='+$("span#proiezioneJason").text()+'&user='+$("span#username").text()+'&b1='+$("span#biglietto1").text()+'&b2='+$("span#biglietto2").text()+'&b3='+$("span#biglietto3").text()+'&b4='+$("span#biglietto4").text()+'&b5='+$("span#biglietto5").text(),
		headedrs:{
			Accept: "application/json; charset=utf-8",
      "Content-type": "application/json; charset=utf-8",
		},
		
  
	  })
	  
	   window.location.assign("home.jsp")
	  
	
	
	}
	
}

var i=0;
var a = [0,0,0,0,0]; 

function clickPosto(u){
	
	if(i>4){alert("HAI RAGGIUNTO IL LIMITE DI BIGLIETTI");}	
	else{
	var p;
	//var input = document.createElement("input");
	//var mainDiv = document.getElementById("riepilogo");
	
		
	p=document.getElementById(u.id).getAttribute("name");
	document.getElementById(u.id).setAttribute("disabled","disabled");
	$("#posto"+p).css({"background":"yellow"});
	
	//alert(p);
	
	i=i+1;
	a[i]=p;
	var v =document.getElementById("biglietto"+i);
	v.innerHTML = "Biglietto"+i+" &nbsp;&nbsp;&nbsp;&nbsp;  posto: "+p;
	$("#annulla"+i).css({"display":"inline"});
	var tot =$("#prezzoBase").text()*i;
	
	document.getElementById("totale").innerHTML = "TOTALE = "+tot +" &euro;";
	
	ableBottom();
	
	}
}

function unClickPosto(u){	
	var z=document.getElementById(u.id).getAttribute("name");
	var q;	
	q=a[z];	
	document.getElementById("posto"+q).removeAttribute("disabled");	
	$("#posto"+q).css({"background":"LawnGreen "});
	var v =document.getElementById("biglietto"+z);
	v.innerHTML = ""
	$("#annulla"+z).css({"display":"none"});	
	i=i-1
	var tot =$("#prezzoBase").text()*i;
	document.getElementById("totale").innerHTML = "TOTALE = "+tot +" &euro;";
	if(i<=0)
		disableBottom();
}