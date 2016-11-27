window.onload = init;
var socket = new WebSocket("wss://localhost/BridgeCardGame/actions");
socket.onmessage = onMessage;
function onMessage(event) {
	
	//alert("On message");
	//window.location.href = "game.jsp";
	document.getElementById("waiting").style.display = "none";
	document.getElementById("cards").style.display = "";
	var player = JSON.parse(event.data);
	document.getElementById("gameType").value = player.gameType;
	
    if (player.playerName === "South") {
    	
        //alert("South Player");
        
        document.getElementById("playerName").value = player.playerName;
        var temp="card";
        var clubs=" ";
		var diamonds=" ";
		var hearts=" ";
		var spades=" ";
        for(var i=1;i<=13;i++)
        {
        	
        	var card=temp+i;
        	if(player.hasOwnProperty(card))
        	{
        		var cardData=player[card];
        		//alert(cardData);
        		var cardDataArray=cardData.split("-");
        		//alert(cardDataArray[0]);
        		if(cardDataArray[0]=="3")
        		{
        			clubs+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="2")
        		{
        			diamonds+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="1")
        		{
        			hearts+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="0")
        		{
        			spades+=cardDataArray[1]+" ";
        		}
        	}
        	
        	
        }
        
        document.getElementById("Sclubs").value=clubs;
        document.getElementById("Sdiamonds").value=diamonds;
        document.getElementById("Shearts").value=hearts;
        document.getElementById("Sspades").value=spades;
        if(player.gameType=="Bidding Phase")
    	{
    		document.getElementById("SSubmitCard").style.display = "none";
    		document.getElementById("SubmitBid").style.display = "";
    	}
    	if(player.gameType=="Game Phase")
    	{
    		document.getElementById("SSubmitBid").style.display = "none";
    		document.getElementById("SSubmitCard").style.display = "";
    	}
    }
	if (player.playerName === "West") {
	    	
	        //alert("West Player");
	        document.getElementById("playerName").value = player.playerName;
	        var temp="card";
	        var clubs=" ";
			var diamonds=" ";
			var hearts=" ";
			var spades=" ";
	        for(var i=1;i<=13;i++)
	        {
	        	
	        	var card=temp+i;
	        	if(player.hasOwnProperty(card))
	        	{
	        		var cardData=player[card];
	        		//alert(cardData);
	        		var cardDataArray=cardData.split("-");
	        		//alert(cardDataArray[0]);
	        		if(cardDataArray[0]=="3")
	        		{
	        			clubs+=cardDataArray[1]+" ";
	        		}
	        		if(cardDataArray[0]=="2")
	        		{
	        			diamonds+=cardDataArray[1]+" ";
	        		}
	        		if(cardDataArray[0]=="1")
	        		{
	        			hearts+=cardDataArray[1]+" ";
	        		}
	        		if(cardDataArray[0]=="0")
	        		{
	        			spades+=cardDataArray[1]+" ";
	        		}
	        	}
	        	
	        	
	        }
	        
	        document.getElementById("Wclubs").value=clubs;
	        document.getElementById("Wdiamonds").value=diamonds;
	        document.getElementById("Whearts").value=hearts;
	        document.getElementById("Wspades").value=spades;
	        if(player.gameType=="Bidding Phase")
	    	{
	    		document.getElementById("WSubmitCard").style.display = "none";
	    		document.getElementById("WSubmitBid").style.display = "";
	    	}
	    	if(player.gameType=="Game Phase")
	    	{
	    		document.getElementById("WSubmitBid").style.display = "none";
	    		document.getElementById("WSubmitCard").style.display = "";
	    	}
	}
	if (player.playerName === "North") {
		
	   //alert("North Player");
	    document.getElementById("playerName").value = player.playerName;
	    var temp="card";
        var clubs=" ";
		var diamonds=" ";
		var hearts=" ";
		var spades=" ";
        for(var i=1;i<=13;i++)
        {
        	
        	var card=temp+i;
        	if(player.hasOwnProperty(card))
        	{
        		var cardData=player[card];
        		//alert(cardData);
        		var cardDataArray=cardData.split("-");
        		//alert(cardDataArray[0]);
        		if(cardDataArray[0]=="3")
        		{
        			clubs+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="2")
        		{
        			diamonds+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="1")
        		{
        			hearts+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="0")
        		{
        			spades+=cardDataArray[1]+" ";
        		}
        	}
        	
        	
        }
        
        document.getElementById("Nclubs").value=clubs;
        document.getElementById("Ndiamonds").value=diamonds;
        document.getElementById("Nhearts").value=hearts;
        document.getElementById("Nspades").value=spades;
        if(player.gameType=="Bidding Phase")
    	{
    		document.getElementById("NSubmitCard").style.display = "none";
    		document.getElementById("NSubmitBid").style.display = "";
    	}
    	if(player.gameType=="Game Phase")
    	{
    		document.getElementById("NSubmitBid").style.display = "none";
    		document.getElementById("NSubmitCard").style.display = "";
    	}
	}
	if (player.playerName === "East") {
		
	    //alert("East Player");
	    document.getElementById("playerName").value = player.playerName;
	    var temp="card";
        var clubs=" ";
		var diamonds=" ";
		var hearts=" ";
		var spades=" ";
        for(var i=1;i<=13;i++)
        {
        	
        	var card=temp+i;
        	if(player.hasOwnProperty(card))
        	{
        		var cardData=player[card];
        		//alert(cardData);
        		var cardDataArray=cardData.split("-");
        		//alert(cardDataArray[0]);
        		if(cardDataArray[0]=="3")
        		{
        			clubs+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="2")
        		{
        			diamonds+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="1")
        		{
        			hearts+=cardDataArray[1]+" ";
        		}
        		if(cardDataArray[0]=="0")
        		{
        			spades+=cardDataArray[1]+" ";
        		}
        	}
        	
        	
        }
        
        document.getElementById("Eclubs").value=clubs;
        document.getElementById("Ediamonds").value=diamonds;
        document.getElementById("Ehearts").value=hearts;
        document.getElementById("Espades").value=spades;
        if(player.gameType=="Bidding Phase")
    	{
    		document.getElementById("ESubmitCard").style.display = "none";
    		document.getElementById("ESubmitBid").style.display = "";
    	}
    	if(player.gameType=="Game Phase")
    	{
    		document.getElementById("ESubmitBid").style.display = "none";
    		document.getElementById("ESubmitCard").style.display = "";
    	}
	}
	
}

function formSubmit() {
	hideForm();
	document.getElementById("waiting").style.display = "";
	socket.send("Hello");
}
function hideForm() {
    document.getElementById("form1").style.display = "none";
    document.getElementById("welcome").style.display = "none";
}
function init() {
    hideDiv();
}
function hideDiv() {
    document.getElementById("cards").style.display = "none";
    document.getElementById("waiting").style.display = "none";
    document.getElementById("SSubmitBid").style.display = "none";
    document.getElementById("SSubmitCard").style.display = "none";
    document.getElementById("WSubmitBid").style.display = "none";
    document.getElementById("WSubmitCard").style.display = "none";
    document.getElementById("NSubmitBid").style.display = "none";
    document.getElementById("NSubmitCard").style.display = "none";
    document.getElementById("ESubmitBid").style.display = "none";
    document.getElementById("ESubmitCard").style.display = "none";
}