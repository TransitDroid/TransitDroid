<jsp:include page="JSP/links.jsp"></jsp:include>

<a href="${ pageContext.request.contextPath }/JSP/User/UpdateUser.jsp"
	rel="#overlay"> <img id="user" src="UI/img/Melinda-98-Edit.jpg"
	height="20" border="none">
</a>
	<ul>
		<li><a href="#">Update User Details</a></li>
		<li><a href="javascript:void(0);" onclick="upload();">Upload Photo</a></li>
		<li><a href="${ pageContext.request.contextPath }/JSP/User/UserProfile.jsp">Change Password</a></li>
		<li><a href="javascript:void(0);" onclick="logout(); window.location.reload( true );">Log Out</a></li>
	</ul>