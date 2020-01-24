<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</section>

<div id="formDiv">
	<c:url var="showCardsUrl" value="/" />
	<form action="${showCardsUrl}" method="POST">
		<select name="number">
			<c:forEach var="cnt" begin="1" end="6">
				<option value="${cnt}">${cnt}</option> 
			</c:forEach>
		</select>
		<input type="submit" value="Deal" />
	</form>
</div>
</head>
<body>
