<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card Example</title>
<c:url value="/css/cards.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
</head>
<body>

<section id="pageHeader">

<h1>Card Example</h1>
<div> <a href="<c:url value="/" />">Deck</a>  <a href="<c:url value="/game" />">Twenty One Game</a></div>

</section>

<section id="content">