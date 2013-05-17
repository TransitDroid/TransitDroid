<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/creditCard.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/autoFocus.js"></script>
<title>Transit Droid</title>
</head>
<body>
<div id="stylized" class="myform">
<h2>Purchase Individual Tickets</h2>	
<div id="cc">
<form id="singlePass" class="layover" method="POST">
		<label for="cc">Number of Tickets:</label>
		<input class="focusMe" type=text list=numberOfTickets type=text pattern="[1, 6, 12]{1,2}" placeholder="1, 6 or 12 tickets" required>
			<datalist id=numberOfTickets >
			   <option> 1
			   <option> 6
			   <option> 12
			</datalist>
			
	    <label for="cc">Credit Card Number:<span class="small">No charges will apply</span></label>
	    <input id="cc" type=text pattern="[0-9]{13,16}" placeholder="Creditcard Number" required />
	    
	    
	    <img src="${ pageContext.request.contextPath }/UI/img/MCVisa.gif"/></div><br />
	    <button id="payButton">Submit</button>
	    <div id="processing">
    <progress></progress>
    <p style="text-align:center">Processing...</p>
</div>
</form>

</div>
</div>
</body>
</html>