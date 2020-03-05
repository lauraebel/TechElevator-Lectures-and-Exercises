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
			<h2>What is your favorite car?</h2>
			
			<form action="<c:url value="/FavoriteThings/Page2" />" method="POST">
			
					<input type="text" name="car" id="car" />

					<input type="submit" value="Next ->" />
			</form>
		</div>
	</body>
</html>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />