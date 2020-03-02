<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Form Example with GET Request Result Page</title>
		<style>
			td:first-child {
				font-weight: bold;
				width: 125px;
			}
		</style>
	</head>
	<body>
		<table>
			<tr>
				<td>First Name:</td>
				<td><c:out value="${fName}"/> </td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><c:out value="${lName}"/> </td>
			</tr>
			<tr>
				<td>Selected Color:</td>
				<td><c:out value="${selColor}"/> </td>
			</tr>
		
		</table>		
	</body>
</html>