<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.jeu.list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary">
				<spring:message code="entities.jeu.list.title" />
			</h1>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-light">
						<tr>
							<th><spring:message code="entities.jeu.nom" /></th>
							<th><spring:message code="entities.jeu.dateEdition" /></th>
							<th><spring:message code="entities.jeu.favori" /></th>
							<th><spring:message code="entities.jeu.utilise" /></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${jeux}" var="jeu">
							<tr>
								<td>${jeu.nom}</td>
								<td>${jeu.dateEdition}</td>
								<td><i class="material-icons"><c:if test="${jeu.favori == true}">favorite</c:if><c:if test="${jeu.favori == false}">favorite_border</c:if></i></td>
								<td><i class="material-icons"><c:if test="${jeu.utilise == true}">check</c:if><c:if test="${jeu.utilise == false}">close</c:if></i></td>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">	
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/jeux/toUpdate?id=${jeu.id}" />"><i class="material-icons">create</i></a></td>
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/jeux/delete/${jeu.id}" />"><i class="material-icons">delete</i></a></td>
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