<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Confirm your choices</h1>

<table>
	<tr>
		<td>Name</td>
		<td><c:out value="${city.name}" /></td>
	</tr>
	<tr>
		<td>State</td>
		<td><c:out value="${city.district}" /></td>
	</tr>
	<tr>
		<td>Population</td>
		<td><c:out value="${city.population}" /></td>
	</tr>

</table>

<div>
	<form action="<c:url value="/addCity/save" />" method="POST">
		<input type="submit" value="Save" />
	</form>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />