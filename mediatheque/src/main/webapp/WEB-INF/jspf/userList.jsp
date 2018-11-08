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
		<h1 class="text-primary text-center"><spring:message code="entities.user.list.title" /></h1>
			<a class="btn btn-primary float-right" href="<c:url value="/users/toCreate" />"><i class="material-icons">add_circle</i></a>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead class="thead-light">
					<tr>
						<th scope="col"><spring:message code="entities.user.pseudo" /></th>
						<th scope="col"><spring:message code="entities.user.email" /></th>
						<th scope="col"><spring:message code="entities.user.lastname" /></th>
						<th scope="col"><spring:message code="entities.user.firstname" /></th>
						<th scope="col"></th>
						<th scope="col"></th>
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
							<td><a class="btn btn-primary btn-sm" href="<c:url value="/users/toUpdate?id=${user.id}" />"><i class="material-icons">create</i></a></td>
							<td><a class="btn btn-primary btn-sm" href="<c:url value="/users/delete/${user.id}" />"><i class="material-icons">delete</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>