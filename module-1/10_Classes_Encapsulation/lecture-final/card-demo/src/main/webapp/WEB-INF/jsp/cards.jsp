<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Player One's Hand</h2>
<div id="cards" class="cardTile">
	
	
	<c:forEach items="${cards}" var="card">
	
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

				<a href="${flipCardUrl}"><img class="card" src="${cardImg}" /></a>
			</c:otherwise>
		</c:choose> 
	</c:forEach>

</div>

<div id="spacer"></div>

<h2>Player Two's Hand</h2>
<div id="opponentCards" class="cardTile">

	
	<c:forEach items="${opponentCards}" var="card">

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
					<c:param name="player" value="opponent" />
				</c:url>

				<a href="${flipCardUrl}"><img class="card" src="${cardImg}" /></a>
			</c:otherwise>
		</c:choose>

	</c:forEach>

</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />