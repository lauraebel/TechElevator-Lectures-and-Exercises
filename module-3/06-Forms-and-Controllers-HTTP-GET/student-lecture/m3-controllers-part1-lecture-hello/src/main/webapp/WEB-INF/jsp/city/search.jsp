<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<form action="<c:url value="/searchResult" />" method="GET">
			<label for="countryCode">Country Code: </label>
			<input type="text" name="countryCode" id="cCode" />
			<input type="submit" value="Search" />
		</form>
	</body>
</html>