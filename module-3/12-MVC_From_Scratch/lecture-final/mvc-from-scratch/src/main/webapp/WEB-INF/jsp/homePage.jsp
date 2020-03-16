<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
	</head>
	<body>
		<h1>Cities by Country</h1>
		<div>
			<form action="<c:url value="/" />" method="GET">
				<label for="country">Country:</label>
				
				<select name="country">
					<c:forEach items="${countries}" var="country">
						<c:set var="selected" value="" />
						<c:if test="${country.code == param.country}">
							<c:set var="selected" value="SELECTED" />
						</c:if>
					
						<option value="${country.code}" ${selected}>${country.name}</option>
					</c:forEach>
				
				</select>
				
				<input type="submit" value="Select" />
			</form>
			
			
		</div>
		<div>
			<ol>
				<c:forEach items="${cities}" var="city">
					<li><c:out value="${city.name}" /></li>
				</c:forEach>
			
			</ol>
		
		</div>
	</body>
</html>