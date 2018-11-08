<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.film.list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary text-center"><spring:message code="entities.film.list.title" /></h1>
			<a class="btn btn-primary float-right" href="<c:url value="/films/toCreate" />"><i class="material-icons">add_circle</i></a>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-primary">
						<tr>
							<th scope="col"><spring:message code="entities.film.nom" /></th>
							<th scope="col"><spring:message code="entities.film.dateSortie" /></th>
							<th scope="col"><spring:message code="entities.film.favori" /></th>
							<th scope="col"><spring:message code="entities.film.utilise" /></th>
							<th scope="col"><spring:message code="entities.film.dvd" /></th>
							<th scope="col"><spring:message code="entities.film.blueRay" /></th>
							<th scope="col"><spring:message code="entities.film.numerique" /></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${films}" var="film">
							<tr>
								<td>${film.nom}</td>
								<td>${film.dateSortie}</td>
								<td><i class="material-icons"><c:if test="${film.favori == true}">favorite</c:if><c:if test="${film.favori == false}">favorite_border</c:if></i></td>
								<td><i class="material-icons"><c:if test="${film.utilise == true}">check</c:if><c:if test="${film.utilise == false}">close</c:if></i></td>
								<td><i class="material-icons"><c:if test="${film.dvd == true}">check</c:if><c:if test="${film.dvd == false}">close</c:if></i></td>
								<td><i class="material-icons"><c:if test="${film.blueRay == true}">check</c:if><c:if test="${film.blueRay == false}">close</c:if></i></td>
								<td><i class="material-icons"><c:if test="${film.numerique == true}">check</c:if><c:if test="${film.numerique == false}">close</c:if></i></td>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">	
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/films/toUpdate?id=${film.id}" />"><i class="material-icons">create</i></a></td>
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/films/delete/${film.id}" />"><i class="material-icons">delete</i></a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>