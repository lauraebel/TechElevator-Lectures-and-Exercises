<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>${user.name}'s Trips</h1>

<ol>
<c:forEach items="${trips}" var="t">
	<li><c:out value="${t.name}" /> - <c:out value="${t.miles}" /></li>

</c:forEach>
<li><a href="<c:url value="/addTrip" />">Add New Trip</a></li>

</ol>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />