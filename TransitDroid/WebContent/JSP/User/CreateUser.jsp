<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/creditCard.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/autoFocus.js"></script>
<title></title>
</head>
<body>
<div id="stylized" class="myform">
	<form method="POST" onsubmit = "return createUser()">
	<div id="warning"></div>
	<h2>Sign Up</h2>
	<label>First Name </label> <input id="firstName" class="focusMe" type="text" autofocus="autofocus"><br/>
	<label>Last Name</label> <input id="lastName" type="text"><br/>
	<label>Username</label>  <input id="createUserUsername" type="text"><br/>
	<label>Password</label>  <input id="createUserPassword" name="createUserPassword" type="password"><br/>
	<label>Opus Card<span class="small">Optional</span></label> <input name="card" type="text">
<!-- 		<div id="cc">
		    <label for="cc">Credit Card Number:</label>
		    <input id="cc" type="text" pattern="[0-9]{13,16}" autofocus required />
		    <div class="input-validation"></div>
		    <img src="${ pageContext.request.contextPath }/UI/img/MCVisa.gif"/> -->
	    <button id="payButton" onClick="createUser()">Register</button>
			<br/>
		</div>
		</form>
		<div id="processing">
		    <progress class="FullWidth"></progress>
		    <p style="text-align:center">Processing...</p>
		</div>
</div>


</body>
</html>