<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<!-- The current product is available using the `product` variable -->
<div id="product-detail">
	<img src="<c:url value="/images/product-images/grey-sofa.jpg" />" />
	<div class="product-description">
		<h3>Grey Sofa</h3>

		<!-- .filled will make the star solid -->
		<div class="rating">
			<span class="filled">&#9734;</span> 
			<span class="filled">&#9734;</span>
			<span>&#9734;</span> 
			<span>&#9734;</span> 
			<span>&#9734;</span>
		</div>

		<!-- Include this if the product has a Remaining Stock of 5 or less -->
		<p class="alert-remaining">BUY NOW! Only 4 left!</p>
		<p class="description">Large four seater grey sofa.</p>
		<p class="price">$939.00</p>

		<!-- If item is in stock -->
		<button class="action">Add to Cart</button>
		<!-- OR if item is out of stock -->
		<!--<button disabled>Sold Out</button>-->
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />