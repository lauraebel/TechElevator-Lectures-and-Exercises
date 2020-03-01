<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	<div class="main-content">
		<!-- Container for Sorting Choices
         
         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
    	-->
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
				<li><a href="#">Price - Low to High</a></li>
				<li><a href="#">Price - High to Low</a></li>
				<li><a href="#">Rating - High to Low</a></li>
			</ul>
		</div>


		<div id="grid">

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
					<p class="name">${product.name}</p>
					<p class="price"><fmt:formatNumber value="${product.price}" type="currency" currencyCode="USD" /></p>
				</div>

				<div class="rating">
					<c:forEach begin="1" end="${product.averageRating}">
						<span class="filled">&#9734;</span>
					</c:forEach>

					<c:forEach begin="${product.averageRating}" end="4">
						<span class="empty-list">&#9734;</span>
					</c:forEach>
				</div>

				<c:if test="${product.topSeller && product.remainingStock > 0}">
					<span class="banner top-seller">TOP SELLER!</span>
				</c:if>
				
				<c:if test="${product.remainingStock == 0}">
					<span class="banner">SOLD OUT</span>
				</c:if>

				<c:if
					test="${product.remainingStock > 0 && product.remainingStock <=5}">
					<span class="product-alert">ONLY ${product.remainingStock} LEFT!</span>
				</c:if>


			
		</div>
</c:forEach>	
</div>	
</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />