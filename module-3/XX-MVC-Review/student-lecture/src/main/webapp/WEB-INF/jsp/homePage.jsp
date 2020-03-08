<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Hello ${user.name}</h1>

<form action="<c:url value="/" />" method="POST">
	<label for ="username">Name</label>
	<input type="text" name="username"/>
	
	<input type="submit" value="Submit" />
</form>








<c:import url="/WEB-INF/jsp/common/footer.jsp" />