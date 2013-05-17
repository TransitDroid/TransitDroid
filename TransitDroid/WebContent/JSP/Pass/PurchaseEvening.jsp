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
<h2>Purchase Evening Pass</h2>	
<div id="cc">
<form id="weekendPass" class="layover" method="POST">

			
	    <label for="cc">Credit Card Number:<span class="small">No charges will apply</span></label>
	    <input class ="focusMe" id="cc" type=text pattern="[0-9]{13,16}" placeholder="Creditcard Number" required />
	    
	    
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