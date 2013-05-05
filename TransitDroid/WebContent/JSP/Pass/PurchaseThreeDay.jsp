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
<h2>Purchase Three Day Pass</h2>	
<div id="cc">
<form id="threeDayPass" class="layover" method="POST">

	    <label for="cc">Credit Card Number:</label>
	    <input class ="focusMe" id="cc" type="text" pattern="[0-9]{13,16}" required />
	    <div class="input-validation"></div><br />
	    <img src="${ pageContext.request.contextPath }/UI/img/MCVisa.gif"/>
	    <button id="payButton">Submit</button>
</form>

<div id="processing">
    <progress></progress>
    <p style="text-align:center">Processing...</p>
</div></div>
</div>
</body>
</html>