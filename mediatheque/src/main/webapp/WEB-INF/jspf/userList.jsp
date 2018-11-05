<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="home.welcome.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<h1 class="text-primary">
			<spring:message code="entities.user.list.title" />
		</h1>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead class="thead-light">
					<tr>
						<th><spring:message code="entities.user.pseudo" /></th>
						<th><spring:message code="entities.user.email" /></th>
						<th><spring:message code="entities.user.lastname" /></th>
						<th><spring:message code="entities.user.firstname" /></th>
						
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.pseudo}</td>
							<td>${user.email}</td>
							<td>${user.lastname}</td>
							<td>${user.firstname}</td>
							
							<td><a href="<c:url value="/users/toUpdate?id=${user.id}" />"><spring:message code="entities.user.list.update" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>