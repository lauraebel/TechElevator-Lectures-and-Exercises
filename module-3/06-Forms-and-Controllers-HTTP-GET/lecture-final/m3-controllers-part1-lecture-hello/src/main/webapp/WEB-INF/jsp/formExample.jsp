<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Form Example with GET Request</title>
		<style>
			input:not([type=radio]) {
				display: block;
			}
			label {
				display: inline-block;
				margin-top: 15px;
			}
			input[type=submit] {
				margin-top: 10px;
			}
		</style>
	</head>
	<body>
		<c:url value="/formExampleSubmission" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="firstName">First Name: </label>
			<input type="text" id="firstName" name="firstName" />
			
			<label for="lastName">Last Name: </label>
			<input type="text" id="lastName" name="lastName" />
			
			<label for="selectedColor">Select a Color: </label>
			<input type="radio" id="selectedColor" name="selectedColor" value="Red"/>Red
			
			<input type="radio" id="selectedColor" name="selectedColor" value="Blue" />Blue
			
			<input type="radio" id="selectedColor" name="selectedColor" value="Yellow" />Yellow
			
			<input type="submit" value="Submit" />
		</form>
	</body>
</html>