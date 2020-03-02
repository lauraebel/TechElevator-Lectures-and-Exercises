<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<form action="<c:url value="/actorSearchResult" />" method="GET">
<label for="lastName"> Enter a Last Name: </label>
<input type="text" name="lastName" />
<input type="submit" value="Search" />
</form>

<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
<li><c:out value="${actor.firstName} ${actor.lastName}"></c:out></li>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>