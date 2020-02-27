<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
			<c:forEach var="name" items="${requestScope.listOfNames}">
				<li>${name}</li>
			</c:forEach>
		</ol>	
		
		<h1>${listOfNames[1]} is the second name in the list</h1>
	
		${herds.Lion}
		${herds.Crow}
		
		<br />
		<c:forEach items="${herds}" var="entry">
			${entry.key} - ${entry.value}
		</c:forEach>
	
	</body>
</html>