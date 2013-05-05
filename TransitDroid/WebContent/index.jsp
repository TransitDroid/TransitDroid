<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="JSP/links.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Transit Droid</title>
</head>

<body onload='load();'>
	<!-- overlayed element -->
<div class="apple_overlay" id="overlay">
	<!-- the external content is loaded inside this tag -->
	<div class="contentWrap"></div>
</div>


<div id="container">

      <div id="header"><jsp:include page="/Header.jsp"></jsp:include></div>

<div id="slideShowHolder">

<div id="slideshow">
    <img src="${ pageContext.request.contextPath }/UI/img/stm-option2.png" alt="Slideshow Image 1" class="active"  />
    <img src="${ pageContext.request.contextPath }/UI/img/metroFlute.jpg" alt="Slideshow Image 3" />
    <img src="${ pageContext.request.contextPath }/UI/img/TO.jpg" alt="Slideshow Image 4" class="active"  />
    <img src="${ pageContext.request.contextPath }/UI/img/sanFran.jpeg" alt="Slideshow Image 5" />
    <img src="${ pageContext.request.contextPath }/UI/img/newYork.jpg" alt="Slideshow Image 6" />
</div>
</div>

	<div class="holder_content">
	<jsp:include page="loggedOutContent.jsp"/> 
	</div>
   <div id="footer">
   <div class="containerMain">  
   <div id="FooterTwo"> © 2013 Transit Droid </div>
   <div id="FooterTree"> Capstone Team 5 </div> 
   </div>
   </div>
</div>

</body>
</html>