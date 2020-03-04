<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jspf"%>


<h1>Squirrel Cigar Parties for Dummies</h1>

<img src="<c:url value="/img/forDummies.png" />" />

		<h1>Reader Reviews</h1>
			
			<c:forEach items="${reviews}" var="review">
			<div class="reviewList"></div>
				<h3><c:out value="${review.username}" /></h3>
				<c:forEach begin="1" end="${review.rating}" >
					<img src="<c:url value="/img/star.png" />"/>
				</c:forEach>
				<h4><c:out value="${review.title}" /></h4>
				<h5><c:out value="${review.text}"/></h5>
				<p><c:out value="${review.dateSubmitted}" /></p>
			</div>
			
			</c:forEach>
		
<p><a href="<c:url value="/createReview" />">Click Here to Leave a Review!</a></p>

<%@include file="common/footer.jspf"%>
