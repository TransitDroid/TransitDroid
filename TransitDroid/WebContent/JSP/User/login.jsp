<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/creditCard.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/autoFocus.js"></script>
<jsp:include page="/JSP/links.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<div id="warning"></div>

<div id="stylized" class="myform">
<form method="POST" onsubmit="return login();")>
<h2>Log In</h2>

<label>Username</label>  <input id = "username" class="focusMe" placeholder="username" type="text"><br/>
<label>Password</label>  <input id = "password" placeholder="password" type="password"><br/>
<button id="logonButton" type="submit">Log in</button>
<br/><br/>
<a class="signup" href="${ pageContext.request.contextPath }/JSP/User/CreateUser.jsp" rel="#overlay">Don't have an account yet? Click here to create an account today!</a>

<br/>
<div id="processing">
    <progress></progress>
    <p style="text-align:center">Processing...</p>
</div>
<div class="spacer"></div>
</div>
</form>

</body>
</html>