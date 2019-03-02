<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Cart</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="<c:url value="/resources/css/cart.css" />" >
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript"> 
			function closeThis(field) {
		    	$(field).parent().fadeOut( "slow" );
		  	}
			setTimeout(function(){ $(".success_notification").fadeOut( "slow" ); }, 3000);
		</script>
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
				          <h4><strong>Available Products</strong></h4>
				          <div class="cart-container">
					          <c:if test="${not empty allProductList}">
						          <ul class="w3-ul w3-card-4">
						          	<li class="w3-bar">
						              <div class="item-container w3-bar-item">
						              	<span class="cart-item-check w3-large">&nbsp;</span>
						                <span class="cart-item w3-large">Id</span>
						                <span class="cart-item-name w3-large">Name</span>
						                <span class="cart-item w3-large">Price</span>
						                <span class="cart-item w3-large">Quantity</span>
						              </div>
						            </li>
						            <c:forEach var="product" items="${allProductList}" varStatus="i">
						            	<c:set var = "productId" scope = "session" value = "${String.valueOf(product.getId())}"/>
						            	<c:set var = "quant" scope = "session" value = ""/>
						            	<c:if test="${cartProducts.size() != 0}">
						            		<c:if test="${cartProducts.containsKey(productId)}">
						            			<c:set var = "quant" scope = "session" value = "${cartProducts.get(productId)}"/>
						            			<c:set var="checked" scope = "session" value="checked"></c:set>
						            		</c:if>
						            		<c:if test="${!cartProducts.containsKey(productId)}">
						            			<c:set var = "quant" scope = "session" value = ""/>
						            			<c:set var="checked" scope = "session" value=""></c:set>
						            		</c:if>
						            	</c:if>
						            	<li class="w3-bar">
											<span class="cart-item-check">
												<form:checkbox name="oneProduct" path="selectedProducts" value="${product.getId()}" />
											</span>
											<span class="cart-item">${product.getId()}</span>
											<span class="cart-item-name">${product.getName()}</span>
											<span class="cart-item">$ ${product.getCost()}</span>
											<span class="cart-item"><form:input path="quantity[${product.getId()}]" value="${quant}" name="${product.getName()}"/></span>
										</li>
									</c:forEach>
						           </ul>
								 </c:if>
					         </div>
				        </div>
				        <div class="button-container">
				        	<input type="submit" value="Add to Cart" name="action" />
							<input type="submit" value="Checkout" name="action" />
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