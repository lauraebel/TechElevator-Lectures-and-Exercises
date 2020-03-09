<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Venues</title>
	</head>
	<body>
		<h1>Details for <c:out value="${venue.name}" /></h1>

		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Open</th>
				<th>Close</th>
				<th>Daily Rate</th>
				<th>Max. Occupancy</th>
			</tr>
			
			<c:forEach items="${venue.spaces}" var="space">
				<tr>
					<td><c:out value="${space.id}" /></td>
					<td><c:out value="${space.name}" /></td>
					<td><c:out value="${space.openFrom}" /></td>
					<td><c:out value="${space.openTo}" /></td>
					<td><c:out value="${space.dailyRate}" /></td>
					<td><c:out value="${space.maxOccupancy}" /></td>
				</tr>
			
			
			</c:forEach>
			
		
		</table>
	
		<div>
			<form action="<c:url value="/makeReservation" />" method="POST">
				<label for="spaceId">Id</label>
				<input type="text" name="spaceId" />
				<label for="numberOfAttendees">Number of Attendees</label>
				<input type="number" name="numberOfAttendees" />
				<label for="startDate">Start Date</label>
				<input type="date" name="startDate" />
				<label for="endDate">End Date</label>
				<input type="date" name="endDate" />
				<label for="reservedFor">Reserved For</label>
				<input type="text" name="reservedFor" />
				<input type="hidden" name="venueId" value="${venue.id}" />
				<input type="submit" value="Reserve" />
			
			</form>
		
		</div>
	
	
	</body>
</html>