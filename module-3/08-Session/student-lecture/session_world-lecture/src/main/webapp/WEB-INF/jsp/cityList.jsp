<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<table class="table">
<tr>
<th>Name</th>
<th>District</th>
<th>Population</th>
</tr>
<c:forEach items="${cities}" var="city">
<tr>
	<td><c:out value="${city.name}" /></td>
	<td><c:out value="${city.district}" /></td>
	<td><c:out value="${city.population}" /></td>
</tr>
</c:forEach>
</table>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />