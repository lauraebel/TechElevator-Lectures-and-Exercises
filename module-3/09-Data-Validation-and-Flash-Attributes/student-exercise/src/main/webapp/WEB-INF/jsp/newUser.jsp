<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<c:url var="newUserUrl" value="/newUser" />

<form:form action="${newUserUrl}" method="POST" modelAttribute="registration">
<label for="firstName">First Name:</label>
<form:input path="firstName" />
<form:errors path="firstName" cssClass="errors" />
<br/>

<label for="lastName">Last Name:</label>
<form:input path="lastName" />
<form:errors path="lastName" cssClass="errors" />
<br/>

<label for="email">Email Address:</label>
<form:input path="email" />
<form:errors path="email" cssClass="errors" />
<br/>

<label for="confirmEmail">Confirm Email Address:</label>
<form:input path="confirmEmail" />
<form:errors path="confirmEmail" cssClass="errors" />
<br/>

<label for="password">Password:</label>
<form:input type="password" path="password" />
<form:errors path="password" cssClass="errors" />
<br/>

<label for="confirmPassword">Confirm Password:</label>
<form:input type="password" path="confirmPassword" />
<form:errors path="confirmPassword" cssClass="errors" />
<br/>

<label for="birthdate">Birthdate (yyyy-MM-dd):</label>
<form:input path="birthdate" />
<form:errors path="birthdate" cssClass="errors" />
<br/>

<label for="tickets">Number Of Tickets:</label>
<form:input path="tickets" />
<form:errors path="tickets" cssClass="errors" />
<br/>
<br/>
<input type="submit" value="Register"/>



</form:form>





<%@include file="common/footer.jspf" %>
