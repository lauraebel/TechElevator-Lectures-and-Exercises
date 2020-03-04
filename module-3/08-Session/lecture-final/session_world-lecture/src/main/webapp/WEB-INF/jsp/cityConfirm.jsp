<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<H1>Thank you for adding a new city!</H1>

<h3>You added:</h3>

<table class="table">
<tr>
<th>Name</th>
<th>District</th>
<th>Population</th>
</tr>
<tr>
	<td><c:out value="${city.name}" /></td>
	<td><c:out value="${city.district}" /></td>
	<td><c:out value="${city.population}" /></td>
</tr>
</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />