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
			<h2>What is your favorite dance craze?</h2>
			
			<form action="<c:url value="/FavoriteThings/Page3" />" method="POST">
			
					<input type="radio" name="dance" value="The Dougie"/>
				    <label for="dougie">The Dougie</label>
				    </br>
				    </br>
					<input type="radio" name="dance" value="Gangnam Style"/>
				    <label for="gangnam">Gangnam Style</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Macarena"/>
				    <label for="macarena">Macarena</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Harlem Shake"/>
				    <label for="harlem">Harlem Shake</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Cha Cha Slide"/>
				    <label for="cha">Cha Cha Slide</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="The Floss"/>
				    <label for="floss">The Floss</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="The Hustle"/>
				    <label for="hustle">The Hustle</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="The Hokey Pokey"/>
				    <label for="hokey">The Hokey Pokey</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Wobble"/>
				    <label for="wobble">Wobble</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="The Time Warp"/>
				    <label for="warp">The Time Warp</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Walk Like An Egyptian"/>
				    <label for="walk">Walk Like An Egyptian</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Vogue"/>
				    <label for="vogue">Vogue</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Twist and Shout"/>
				    <label for="twist">Twist and Shout</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Electric Slide"/>
				    <label for="electric">Electric Slide</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="Whip and Nae Nae"/>
				    <label for="nae">Whip and Nae Nae</label>
				    </br>
				    </br>
				    <input type="radio" name="dance" value="The Funky Chicken Dance"/>
				    <label for="chicken">The Funky Chicken Dance</label>
				    </br>
				    </br>
				   
				   <input type="submit" value="Complete Survey ->" />
				    
			</form>
		</div>
	</body>
</html>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />