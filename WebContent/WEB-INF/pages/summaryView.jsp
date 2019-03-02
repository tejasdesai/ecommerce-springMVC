<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cart Summary</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="<c:url value="/resources/css/summary.css" />" >
	</head>
	<body>
		<form:form method="POST" modelAttribute="cartBean">
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
					
					<div class="w3-container">
				          <h2>Cart Summary</h2>
				          <ul class="w3-ul w3-card-4">
				          	<li class="w3-bar">
				          		<c:forEach var="product" items="${cartProducts}" varStatus="i">
				          			<div class="item-holder"><span class="cart-item-name">${product.value.get(0)}: ${product.value.get(1)}</span> <span class="cart-item">$ ${product.value.get(2)}</span></div>
				          		</c:forEach>
				        	</li>
					
							<li class="w3-bar">
								<div class="item-holder"><span class="cart-item-name"><strong>Total: </strong></span> <span class="cart-item"><strong>$ ${totalCost}</strong></span></div>
							</li>
						</ul>
				    </div>
					<div class="button-container">
						<input class="button" type="submit" name="action" value="Back To Cart" />
						<input class="button" type="submit" name="action" value="Checkout" />
					</div>
				</td>
				</tr>
				<tr style="height: 100px;">
				<td style="width: 369px; height: 100px; border: solid 2px lightgrey; text-align: center;" colspan="2">
					<%@ include file="footerView.jsp" %>
				</td>
				</tr>
				</tbody>
			</table>
		</form:form>
	</body>
</html>