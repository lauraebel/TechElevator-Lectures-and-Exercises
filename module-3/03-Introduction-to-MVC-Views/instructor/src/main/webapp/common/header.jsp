<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Intro to Views - <c:out value="${ param.title }" /></title>

	<link rel="stylesheet" href="<c:url value="css/site.css" />" />
	<link rel="stylesheet" href="<c:url value="css/bootstrap.css" />" />

</head>
<body>
       
    <nav>
        <ul>
            <li><a href="<c:url value="fizzBuzz.jsp" />">FizzBuzz</a></li>
            <li><a href="<c:url value="fibonacci.jsp" />">Fibonacci</a></li>
            <li><a href="<c:url value="echo.jsp" />">Echo</a></li>
        </ul>
    </nav>

    <div class="container body-content">
 
		<h2>${ param.title }</h2>