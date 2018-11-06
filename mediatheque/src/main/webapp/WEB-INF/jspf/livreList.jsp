<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.livre.list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary">
				<spring:message code="entities.livre.list.title" />
			</h1>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-light">
						<tr>
							<th><spring:message code="entities.livre.nom" /></th>
							<th><spring:message code="entities.livre.dateParution" /></th>
							<th><spring:message code="entities.livre.favori" /></th>
							<th><spring:message code="entities.livre.utilise" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${livres}" var="livre">
							<tr>
								<td>${livre.nom}</td>
								<td>${livre.dateParution}</td>
								<td><i class="material-icons"><c:if test="${film.favori == true}">check</c:if><c:if test="${film.favori == false}">close</c:if></i></td>
								<td><i class="material-icons"><c:if test="${film.utilise == true}">check</c:if><c:if test="${film.utilise == false}">close</c:if></i></td>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">	
									<td><a href="<c:url value="/livres/toUpdate?id=${livre.id}" />"><spring:message code="entities.update" /></a></td>
									<td><a href="<c:url value="/livres/delete/${livre.id}" />"><spring:message code="entities.delete" /></a></td>
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