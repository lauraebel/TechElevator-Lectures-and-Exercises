<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common/header.jspf"%>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/site.css"></link>
	</head>
	<body>
		<div id="main_content">
		
			<h1>Want to post your own review? Enter your information below!</h1>
			
			<form action="<c:url value="/reviewInput" />" method="POST">
			
					<label for="username">Username: </label>
					<input type="text" name="username" id="userName" />

					<label for="rating">Rate the Book 1 through 5: </label>
				<select id="reviews" name="rating">
					<option value="">Choose One</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>

					<label for="title">Rating Title: </label>
					<input type="text" name="title" id="title"/>
					
					<label for="text">Describe the Reason for your Rating: </label>
					<textarea name="text" rows="6" cols="50" required></textarea>

					<input type="submit" value="Submit Review" />
			</form>
		</div>
	</body>
</html>




<%@include file="common/footer.jspf"%>
