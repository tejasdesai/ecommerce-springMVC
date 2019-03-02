<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css" />" >
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}

</style>
</head>

<body>
	<div class="login-page">
    	<div class="form">
    		<form:form method="POST" modelAttribute="customerBean" class="login-form" name="loginForm">
	    		<form:input path="txtUsername" placeholder="Enter Username" />
	    		<form:password path="txtPassword" placeholder="Enter Password" />
	    		<input type="submit" value="Login">
	            <input type="reset" value="Reset">    		
	    		<form:hidden path="secretValue" />
	    		<form:errors path="txtUsername" cssClass="error" />
	    		<form:errors path="txtPassword" cssClass="error" />
	    		<form:errors path="secretValue" cssClass="error" />
	    		
	    		<%-- <c:set var="nameHasBindError">
	    			<form:errors path="txtUsername" cssClass="error" />
	    		</c:set>
	    		${nameHasBindError}
	    		<c:set var="passwordHasBindError">
	    			<form:errors path="txtPassword" cssClass="error" />
	    		</c:set>
	    		${passwordHasBindError}
	    		<c:if test="empty ${nameHasBindError}">
	    			<c:set var="invalidloginError">
	    				<form:errors path="secretValue" cssClass="error" />
	    			</c:set>
	    			${invalidloginError}
	    		</c:if> --%>
	      	</form:form>
	    </div>
	</div>
</body>
</html>