<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common/header.jspf"%>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/site.css"></link>
	</head>
	<body>
		<div id="main_content">
		
			<h1>Want to post your own review? Enter your username below!</h1>
			<form action="reviewUsernameInput" method="POST">
				<div class="formGroup">
					<label for="userName">Username: </label>
					<input type="text" name="userName" id="userName" />
				</div>
				<div class="formGroup">		
					<label for="Rating">Rate the Book 1 through 5: </label>
					<input type="text" name="Rating" id="age" />
				</div>	
				<div class="formGroup">		
					<label for="Rating Title">Rating Title: </label>
					<input type="text" name="ratingTitle" id="ratingTitle" />
				</div>
				<div class="formGroup">		
					<label for="Rating Text">Describe the Reason for your Rating: </label>
					<input type="text" name="ratingText" id="ratingText" />
				</div>
				<div class="formGroup">
					<input type="submit" value="Submit Review" />
				</div>		
			</form>
		</div>
	</body>
</html>




<%@include file="common/footer.jspf"%>
