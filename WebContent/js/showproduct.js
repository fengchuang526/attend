      function sub(){
	var buyNum = parseInt($("#buyNum").text());
	if(buyNum <= 1){
	   return;
	}
	$("#buyNum").text(--buyNum);
	
      }

      function add(){
	var buyNum = parseInt($("#buyNum").text());
	$("#buyNum").text(++buyNum);
      }    