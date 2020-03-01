<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Tile View" />
</c:import>

<div id="masonry-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	
	<div id="grid" class="main-content">

		<c:forEach var="product" items="${products}">
			<c:set var="cssClass" value="" />
				<c:choose>
					<c:when test="${product.remainingStock == 0}">
						<c:set var="cssClass" value="tile  sold-out" />
					</c:when>

					<c:when test="${product.topSeller}">
						<c:set var="cssClass" value="tile  top-seller" />
					</c:when>

					<c:otherwise>
						<c:set var="cssClass" value="tile  " />
					</c:otherwise>
				</c:choose>
				
			<div class="${cssClass}">
				
				<c:url var="productDetailUrl" value="/products/detail" >
					<c:param name="id" value="${product.id}" />
				</c:url>
					
				<a class="product-image" href="${productDetailUrl}"> <c:url var="imgUrl"
						value="/images/product-images/${product.imageName}" /> <img
					src="${imgUrl}"></img>
				</a>
			
			<div class="details">
				<p class="name">
					<a href="#">${product.name}</a>	
				</p>
				
				<c:if test="${product.remainingStock == 0}">
				<br />
					<span class="banner">SOLD OUT</span>
				</c:if> 

				<div class="rating">
					<c:forEach begin="1" end="${product.averageRating}">
						<span class="filled">&#9734;</span>
					</c:forEach>

					<c:forEach begin="${product.averageRating}" end="4">
						<span class="empty-list">&#9734;</span>
					</c:forEach>
				</div>
				
				<c:if test="${product.topSeller && product.remainingStock > 0}">
				<br />
					<span class="product-alert">TOP SELLER!</span>
				</c:if>
				
				<c:if test="${product.remainingStock > 0 && product.remainingStock <=5}">
					<span class="product-alert">${product.remainingStock} REMAINING!</span>
				</c:if>
				
				
				<p class="price"><fmt:formatNumber value="${product.price}" type="currency" currencyCode="USD" /></p>
				
			</div>
		</div>
		</c:forEach>
		
			</div>
		</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />