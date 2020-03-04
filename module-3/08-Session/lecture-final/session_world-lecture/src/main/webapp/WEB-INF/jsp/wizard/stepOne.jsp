<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<h1>Step One: What is the name of the city?</h1>
	<form action="<c:url value="/addCity/stepOne" />" method="POST">
		<input type="text" name="name" />
		<input type="submit" value="Next >>" />
	
	</form>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />