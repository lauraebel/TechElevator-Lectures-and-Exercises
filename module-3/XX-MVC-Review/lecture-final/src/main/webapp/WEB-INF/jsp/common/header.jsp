<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<head>
		<link href="<c:url value="/css/site.css" />" rel="stylesheet" />
	</head>
	<body>
		<header>
			<img src="<c:url value="/img/header.png" />" />
			<nav>
				<a href="<c:url value="/" />">Home</a>
				<a href="<c:url value="/addTrip" />">Add Trip</a>
				<a href="<c:url value="/trips" />">View Trips</a>
			</nav>
		</header>