<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Venues</title>
	</head>
	<body>
		<h1>Venues</h1>
		<ul>
			
			<c:forEach items="${venues}" var="venue">
				
				<c:url value="/venueDetail" var="venueDetailUrl">
					<c:param name="venueId" value="${venue.id}" />
				</c:url>
				
				<li><a href="${venueDetailUrl}"><c:out value="${venue.name}" /></a></li>
			
			
			</c:forEach>
		
		
		</ul>
	
	</body>
</html>