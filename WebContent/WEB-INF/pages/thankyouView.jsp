<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Thank you for shopping</title>
	</head>
	<body>
		<table style="height: 100%; width: 100%;">
			<tbody>
			<tr style="height: 125px;">
			<td style="width: 369px; height: 125px; border: solid 2px lightgrey; text-align: center;" colspan="2"> 
				<%@ include file="headerView.jsp" %>
			</td>
			</tr>
			<tr style="height: 400px;">
			<td style="width: 109px; height: 400px; border: solid 2px lightgrey;">
				<%@ include file="menuView.jsp" %>
			</td>
			<td style="width: 260px; height: 400px; border: solid 2px lightgrey;">
				<h2>Thank you for shopping!!!</h2>
			</td>
			</tr>
			<tr style="height: 100px;">
			<td style="width: 369px; height: 100px; border: solid 2px lightgrey; text-align: center;" colspan="2">
				<%@ include file="footerView.jsp" %>
			</td>
			</tr>
			</tbody>
		</table>
	</body>
</html>