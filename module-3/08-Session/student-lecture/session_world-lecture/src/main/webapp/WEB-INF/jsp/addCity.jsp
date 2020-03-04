<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="addCityUrl" value="/addCity" />

<c:url var="wizardUrl" value="/addCity/stepOne" />

<h1><a style="color:black;" href="${wizardUrl}">Click here to use the new Add City Wizard</a></h1>

<br />
<br />

<form action="${addCityUrl}" method="POST">
	<label for="name">Name:</label>
	<input type="text" name="name" /><br />
	<label for="district">District:</label>
	<input type="text" name="district" /><br />
	<label for="population">Population:</label>
	<input type="text" name="population" /><br /><br />
	<input type="submit" value="Add City" />

</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

