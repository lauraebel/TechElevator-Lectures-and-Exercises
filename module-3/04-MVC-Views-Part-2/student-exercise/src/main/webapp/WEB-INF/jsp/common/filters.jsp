<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="filter-options">
	<h3>Refine By</h3>
	<ul>
		<li><a href="${baseRoute}?maxPrice=25">Under $25</a></li>
		<li><a href="${baseRoute}?maxPrice=50&minPrice=25">$25 to $50</a></li>
		<li><a href="${baseRoute}?minPrice=50">$50 &amp; Above</a></li>
	</ul>
	<p>Avg. Review</p>
	<ul>
		<li>
			<a class="rating" href="${baseRoute}?minRating=4">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${baseRoute}?minRating=3">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${baseRoute}?minRating=2">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${baseRoute}?minRating=1">
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
	</ul>
	<p>Category</p>
	<ul>
		<li><a href="${baseRoute}?category=Home">Home</a></li>
		<li><a href="${baseRoute}?category=Apparel">Apparel</a></li>
		<li><a href="${baseRoute}?category=Jewelry">Jewelry</a></li>
		<li><a href="${baseRoute}?category=Garden">Garden</a></li>
	</ul>
</div>
