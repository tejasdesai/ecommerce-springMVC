<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	
	a:link, a:visited {
	  background-color: #353333;
	  color: white;
	  padding: 14px 20px;
	  margin: 40px 0 0 0;
	  text-align: center; 
	  text-decoration: none;
	  cursor: pointer;
	  display: inline-block;
	  width: 60%;
	}
	
	.buttons-div{
		text-align: center;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="buttons-div"><a href="<c:url value="/login.htm" />" > Logout </a> </div>
   	<div class="buttons-div"><a href="<c:url value="/helpView.htm" />" > Help </a></div>
</body>
</html>