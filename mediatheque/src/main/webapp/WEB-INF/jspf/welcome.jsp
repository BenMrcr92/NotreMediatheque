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
		<section>
			<h1 class="text-primary">
				<spring:message code="home.welcome.films" />
			</h1>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-light">
						<tr>
							<th><spring:message code="home.welcome.films.nom" /></th>
							<th><spring:message code="home.welcome.films.dateSortie" /></th>
							<th><spring:message code="home.welcome.films.favori" /></th>
							<th><spring:message code="home.welcome.films.utilise" /></th>
							<th><spring:message code="commons.symbols.nbsp" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${films}" var="film">
							<tr>
								<td>${film.nom}</td>
								<td>${film.dateSortie}</td>
								<td>${film.favori}</td>
								<td>${film.utilise}</td>
								<td><a href="<c:url value="/films/toUpdate?id=${film.id}" />"><spring:message code="home.welcome.films.update" /></a></td>
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