<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="addCityUrl" value="/addCity" />

<form:form action="${addCityUrl}" method="POST" modelAttribute="newCity">
	<label for="name">Name:</label>
	<form:input path="name" />
	<form:errors path="name" cssClass="cityError" />
	<br />
	
	<label for="district">District:</label>
	<form:input path="district" />
	<form:errors path="district" cssClass="cityError" />
	<br />
	
	<label for="population">Population:</label>
	<form:input path="population" />
	<form:errors path="population" cssClass="cityError" />
	<br />
	<br />
	<input type="submit" value="Add City" />
</form:form>

<%@include file="common/footer.jspf"%>

