<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="loginUrl" value="/login" />

<h2>Please Login</h2>

<h2 class="error">${error}</h2>

<form action="${login}" method="POST">
	<label for="name">UserName:</label>
	<input type="text" name="username" /><br />
	<label for="password">Password:</label>
	<input type="password" name="password" /><br />
	<input type="submit" value="Login" />

</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />