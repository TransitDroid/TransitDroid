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
<h2>Purchase Single Passes</h2>	
<div id="cc">
<form id="singlePass" class="layover" method="POST">

	<label>Quantity<span class="small">Select from list</span></label><input list="types" id="singlePassQuantity" autofocus required><br/>
	    <label for="cc">Credit Card Number:<span class="small">No charges will apply</span></label>
	    <input id="cc" type="text" pattern="[0-9]{13,16}" required />
	    <div class="input-validation"></div><br />
	    <img src="${ pageContext.request.contextPath }/UI/img/MCVisa.gif"/>
	    <button id="payButton">Submit</button>
		<datalist id="types">
		<option value="One Ticket">
		<option value="Six Tickets">
		<option value="Ten Tickets">
		<option value="Twenty Tickets">
		</datalist>
</form>

<div id="processing">
    <progress></progress>
    <p style="text-align:center">Processing...</p>
</div></div>
</div>
</body>
</html>