  function mouseIN(a){
  	 $(a).fadeTo("slow", 0.15);
  	 $(a).rotate({animateTo:360})
  }

  function mouseOUT(o){
  	 $(o).fadeTo(1000, 1);
  	 $(o).rotate({animateTo:0})
  }
   