<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="changeBackgroundUrl" value="/changeBackground" />

<form action="${changeBackgroundUrl}" method="POST">
	<label for="bgColor">Select Background Color:</label>
	<select name="bgColor">
		<option value="red">Red</option>
		<option value="BurlyWood">Burly Wood</option>
		<option value="CornflowerBlue">Cornflower Blue</option>
		<option value="DarkSeaGreen">Dark Sea Green</option> 
		<option value="white">White</option>
	</select>
	<input type="submit" value="Apply" />
		
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />