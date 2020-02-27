<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="FizzBuzz"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>
	</ul>
</nav>


<ul id="fizzbuzz">
<c:forEach begin="1" end="${param.number}" var="number">
<c:set var="word" value="" />
<c:set var="Class" value="" />
<c:choose>
<c:when test="${number%3 == 0 && number%5 == 0}">
	<c:set var="word" value="FizzBuzz!" />
		<c:set var="Class" value="fizzbuzz" />	
</c:when>
<c:when test="${number%5 == 0}">
	<c:set var="word" value="Buzz!" />
	<c:set var="Class" value="buzz" />	
</c:when>
<c:when test="${number%3 == 0}">
	<c:set var="word" value="Fizz!" />
	<c:set var="Class" value="fizz" />	
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
<c:if test="${not empty word}">
<li class="${Class}">${word}</li>
</c:if>
<c:if test="${empty word}">
<li>${number}</li>
</c:if>
</c:forEach>
</ul>


<c:import url="common/footer.jsp"></c:import>