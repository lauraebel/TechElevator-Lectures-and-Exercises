<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />


<h2>Hand</h2>
<div id="cards" class="cardTile">
	
	
	<c:forEach items="${hand}" var="card">
	
		<c:choose>
			<c:when test="${card.faceUp == true}">
				<c:url var="cardImg"
					value="/img/cards/${card.rank}${card.suit.toUpperCase()}.png" />
				<img class="card" src="${cardImg}" />
			</c:when>
			<c:otherwise>
				<c:url var="cardImg" value="/img/cards/blue_back.png" />
				<c:url var="flipCardUrl" value="/flipCard">
					<c:param name="cardRank" value="${card.rank}" />
					<c:param name="cardSuit" value="${card.suit}" />
					<c:param name="player" value="player" />
				</c:url>

				<img class="card" src="${cardImg}" />
			</c:otherwise>
		</c:choose> 
	</c:forEach>

</div>

<div id="spacer"></div>

<c:if test="${empty result}">
	<div id="gameMenu">
		<form action="<c:url value="hit" />" method="GET" >
			<input type="submit" value="Hit" />
		</form>
		
		<form action="<c:url value="stand" />" method="GET">
			<input type="submit" value="Stand" />
		</form>
		
	</div>
</c:if>

<c:if test="${not empty result}">
	<div id="gameResult">
		<h1>${result}</h1>
		<h2>Total Score: ${total}</h2>
		<form action="<c:url value="/game" />" method="GET">
			<input type="submit" value="Play Again" />
		</form>
	</div>
</c:if>



</section>
</head>
<body>