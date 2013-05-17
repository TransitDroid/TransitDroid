<header>
    <ul id="menu">
        <li><a href="#"><img src="${pageContext.request.contextPath }/UI/images/smallTransitDroidWhite.png" border="none"></a></li>
        <div id="hidden_links">
        <li>                <a href="#">Purchase Pass</a>
                <ul>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseSingle.jsp" rel="#overlay">Individual Tickets</a></li>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseMonthly.jsp" rel="#overlay">Monthly</a></li>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseYearly.jsp" rel="#overlay">Yearly</a></li>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseDaily.jsp" rel="#overlay">Daily</a></li>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseThreeDay.jsp" rel="#overlay">Three Day</a></li>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseEvening.jsp" rel="#overlay">Evening</a></li>
                        	<li><a href="${ pageContext.request.contextPath }/JSP/Pass/PurchaseWeekend.jsp" rel="#overlay">Weekend</a></li>
                </ul>
        </li>
        <li><a href="${ pageContext.request.contextPath }/JSP/About.jsp" rel="#overlay">About</a></li>
        </div>
       	<li class="login" id="loginListItem"><a href="${ pageContext.request.contextPath }/JSP/User/login.jsp" rel="#overlay"><img id ="user" src="${ pageContext.request.contextPath }/UI/images/login.png" height="20" border="none"></a>
       		<ul>
       			<li class="login" id="loginListItem"><a href="${ pageContext.request.contextPath }/JSP/User/CreateUser.jsp" rel="#overlay">Sign Up</a>
       		</ul>
       	</li>
       	<li class="login" id="setting"><a id="userName"></a></li>

	</ul>

</header>


