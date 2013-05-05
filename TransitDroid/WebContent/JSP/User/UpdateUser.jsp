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
	<form method="POST" onsubmit="return updateUser();">
	<div id="warning"></div>
	<h2>Update User Detail</h2>
	<label>First Name </label> <input id="updateFirstName" class="focusMe" type="text" autofocus="autofocus"><br/>
	<label>Last Name</label> <input id="updateLastName" type="text"><br/>
	<label>Username</label>  <input id="updateUsername" type="text"><br/>
	<label>Password</label>  <input name="updatePassword" type="password"><br/>
	<label>Opus Card<span class="small">Optional</span></label> <input name="card" type="text">
<!-- 		<div id="cc">
		    <label for="cc">Credit Card Number:</label>
		    <input id="cc" type="text" pattern="[0-9]{13,16}" autofocus required />
		    <div class="input-validation"></div>
		    <img src="${ pageContext.request.contextPath }/UI/img/MCVisa.gif"/> -->
	    <button id="payButton" onClick="logout()">Submit</button>
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