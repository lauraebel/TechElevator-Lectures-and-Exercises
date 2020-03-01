<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

	
<div id="product-detail">
	
	<c:url var="imgUrl" value="/images/product-images/${product.imageName}" />
	<img src="${imgUrl}" />
	<div class="product-description">
	
		<h3>${product.name}</h3>

		<div class="rating">
					<c:forEach begin="1" end="${product.averageRating}">
						<span class="filled">&#9734;</span>
					</c:forEach>

					<c:forEach begin="${product.averageRating}" end="4">
						<span class="empty-list">&#9734;</span>
					</c:forEach>
		</div>
		
		<c:if test="${product.remainingStock > 0 && product.remainingStock <=5}" >
			<p class="alert-remaining">BUY NOW! Only ${product.remainingStock} left!</p>
		</c:if>
		
		<p class="description">${product.description}</p>
		<p class="price"><fmt:formatNumber value="${product.price}" type="currency" currencyCode="USD" /></p>

		<c:if test="${product.remainingStock >0}">
		<button class="action">Add to Cart</button>
		</c:if>
		
		<c:if test="${product.remainingStock == 0}">
		<button disabled>Sold Out</button>
		</c:if>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />