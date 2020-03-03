<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<form action="<c:url value="/customerSearchResult" />" method="GET">
<label for="customerName"> Enter a Name in all Uppercase: </label>
<input type="text" name="customerName" />

<label for="sort"> Sort: </label>
	
	<select id="sorted" name="sort"> 
		<option value="">Choose One </option>
		<option value="Last Name">Last Name </option>
		<option value="Email">Email </option>
		<option value="Active">Active </option>
	 </select>
	 
<input type="submit" value="Search" />

</form>

<table class="table">
<tr>
<th>Name</th>
<th>Email</th>
<th>Active</th>

</tr>
<c:forEach items="${customers}" var="customer">
<tr>
<td><c:out value="${customer.firstName} ${customer.lastName}" /></td>
<td><c:out value="${customer.email}" /></td>
<td><c:out value="${customer.active}" /></td>
</tr>
</c:forEach>
</table>

 <%@include file="common/footer.jspf"%> 