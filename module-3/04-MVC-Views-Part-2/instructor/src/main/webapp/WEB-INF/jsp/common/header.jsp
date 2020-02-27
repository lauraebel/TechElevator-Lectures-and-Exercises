<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>${param.pageTitle}</title>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet" />
<c:url var="cssUrl" value="/css/site.css" />
<link rel="stylesheet" href="${cssUrl}" />
</head>

<body>
	<nav>
		<ul>
			<c:url var="baseProductsUrl" value="/products" />
			<li><a href="${baseProductsUrl}">Gallery</a></li>
			<li><a href="${baseProductsUrl}/tiles">Grid</a></li>
		</ul>
	</nav>

	<main>
	<h2>${param.pageTitle}</h2>