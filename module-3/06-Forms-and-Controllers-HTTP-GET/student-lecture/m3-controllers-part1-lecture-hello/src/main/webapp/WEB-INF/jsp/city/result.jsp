<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Cities found in ${param.countryCode}</h1>
		<ul>
		
		<c:forEach items="${cities}" var="city">
			<li><c:out value="${city.name}"></c:out></li>
		</c:forEach>
		
		</ul>
	</body>
</html>