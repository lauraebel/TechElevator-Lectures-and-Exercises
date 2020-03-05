<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things</title>
		<link rel="stylesheet" href="css/site.css"></link>
	</head>
	<body>
		<div id="main_content">
			<h1>Favorite Things Survey</h1>
			<h2>Here are your Favorite Things!</h2>
						
<table>
	<tr>
		<td>Animal:</td>
		<td><c:out value="${animal}" /></td>
	</tr>
	<tr>
		<td>Car:</td>
		<td><c:out value="${car}" /></td>
	</tr>
	<tr>
		<td>Dance:</td>
		<td><c:out value="${dance}" /></td>
	</tr>

</table>
				    
			</form>
		</div>
	</body>
</html>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />