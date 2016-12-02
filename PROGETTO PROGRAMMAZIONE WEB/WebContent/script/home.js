
function azzeraColore(){
	for(var h=1;h<=7;h++){
	$("label#day"+h).css({"background":"none"});
	}
	
}


function show3Dicon(who){
	
	$(who).css({"display":"inline"});
	
} 


function jason(day){
	   
	  $.ajax({
		  type:'GET',
		 url:'proiezioniDay?data='+$(day).text(),
				
		headedrs:{
			Accept: "application/json; charset=utf-8",
      "Content-type": "application/json; charset=utf-8",
		},
		
		success:function(result){
			//alert("succerss");
			var risultato = $.parseJSON(result);
			
		
			//		" data= "+risultato[i].data.month +"-"+risultato[i].data.dayOfMonth);}
			
			
			for(var j =1 ; j<=4;j++){
			
			azzeraColore();
			
			$(day).css({"background":"white"});
			document.getElementById(j+"I").setAttribute("src","css/img/film/"+risultato[j+3].immagine);
			document.getElementById(j+"F").innerHTML = risultato[j+3].titolo;
			document.getElementById(j+"D").innerHTML = risultato[j+3].durata;
			document.getElementById(j+"R").innerHTML = "regia : "+ risultato[j+3].regista;
			document.getElementById(j+"G").innerHTML = "genere : "+ risultato[j+3].genere;
			document.getElementById(j+"T").setAttribute("href","filmTrailer?titolo="+risultato[j+3].titolo);
		
			if(risultato[j-1]._3d==true){				
				$("#"+j+"D").css({"display":"inline"});
			  }
			
			if(risultato[j-1]._3d==false){
			   $("#"+j+"D").css({"display":"none"});			
		    }
				
				
				document.getElementById(j+"-f"+1).setAttribute("href","biglietti?proiezione="+risultato[j-1].idProiezione);
				document.getElementById(j+"-f"+2).setAttribute("href","biglietti?proiezione="+(parseInt(risultato[j-1].idProiezione)+4));
				document.getElementById(j+"-f"+3).setAttribute("href","biglietti?proiezione="+(parseInt(risultato[j-1].idProiezione)+8));

					
			
			
			
			
			
			  }
				}	  
	  })	  
};


$(document).ready(function() {  
	  $(".Dicon").rotate({
		  bind:
		  {
		    mouseover : function() {
		    $(this).rotate({animateTo:360})
		  },
		  mouseout : function() {
		    $(this).rotate({animateTo:0})
		    }
		  }

		});

	      });   

	
function mouseIN(a){
	 $(a).fadeTo("slow", 0.15);
	 $(a).rotate({animateTo:360})
}

function mouseOUT(o){
	 $(o).fadeTo(1000, 1);
	 $(o).rotate({animateTo:0})
}





