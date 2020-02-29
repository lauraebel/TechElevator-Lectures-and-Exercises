<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp">
	<c:param name="pageTitle" value="Planet Details" /> 
 </c:import>
        <%-- Parameter ^ came from header.jsp --%>

<c:forEach items="${planets}" var="planet">
	<c:set var="planet" value="${planet}" scope="request" />
	
	<c:import url="/WEB-INF/jsp/singlePlanet.jsp" >
	</c:import>
</c:forEach>


<c:import url="/WEB-INF/jsp/footer.jsp" />
