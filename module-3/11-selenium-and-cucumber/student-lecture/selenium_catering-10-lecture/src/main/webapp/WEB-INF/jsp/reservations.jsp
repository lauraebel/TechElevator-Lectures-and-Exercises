<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Venues</title>
	</head>
	<body>
		<h1>Reservations for <c:out value="${venue.name}" /></h1>
	
		<table>
			<tr>
				<th>Space</th>
				<th>Reserved For</th>
				<th>From</th>
				<th>To</th>
			
			</tr>
			
			<c:forEach items="${reservations}" var="reservation">
				<tr>
					<td><c:out value="${reservation.space}" /></td>
					<td><c:out value="${reservation.reservedFor}" /></td>
					<td><c:out value="${reservation.startDate}" /></td>
					<td><c:out value="${reservation.endDate}" /></td>
				
				</tr>
			
			
			</c:forEach>
			
		
		</table>
	
	</body>
</html>