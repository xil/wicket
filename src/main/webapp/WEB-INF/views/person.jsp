<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>

<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="person">

	<table>
		<tr>
			<td><form:label path="lastname">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="firstname">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="middlename">
				<spring:message code="label.middlename" />
			</form:label></td>
			<td><form:input path="middlename" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addcontact"/>" /></td>
		</tr>
	</table>
</form:form>

<p><a href="<c:url value="/open" />">
	<spring:message code="label.open" />
</a>
</p>
<p><a href="<c:url value="/panic" />">
	<spring:message code="label.panic" />
</a>
</p>
<h3><spring:message code="label.contacts" /></h3>
<c:if test="${!empty personList}">
	<table class="data">
		<tr>
		    <th><spring:message code="label.last" /></th>
			<th><spring:message code="label.firstname" /></th>
			<th><spring:message code="label.middle" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${personList}" var="person">
			<tr>
				<td>${person.lastname}</td>
				<td>${person.firstname}</td>
				<td>${person.middlename}</td>
				<td><a href="delete/${person.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>