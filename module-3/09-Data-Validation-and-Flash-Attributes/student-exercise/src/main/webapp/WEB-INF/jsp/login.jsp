<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<c:url var="loginUrl" value="/login" />

<form:form action="${loginUrl}" method="POST" modelAttribute="login">

<label for="email">Email Address:</label>
<form:input path="email" />
<form:errors path="email" cssClass="errors" />
<br/>

<label for="password">Password:</label>
<form:input path="password" />
<form:errors path="password" cssClass="errors" />
<br/>
<br/>
<input type="submit" value="Log In"/>


</form:form>

<%@include file="common/footer.jspf" %>
