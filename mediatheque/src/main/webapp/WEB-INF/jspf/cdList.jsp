<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.cd.list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary">
				<spring:message code="entities.cd.list.title" />
			</h1>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-light">
						<tr>
							<th><spring:message code="entities.cd.nom" /></th>
							<th><spring:message code="entities.cd.dateSortie" /></th>
							<th><spring:message code="entities.cd.favori" /></th>
							<th><spring:message code="entities.cd.utilise" /></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${cds}" var="cd">
							<tr>
								<td>${cd.nom}</td>
								<td>${cd.dateSortie}</td>
								<td><i class="material-icons"><c:if test="${cd.favori == true}">check</c:if><c:if test="${cd.favori == false}">close</c:if></i></td>
								<td><i class="material-icons"><c:if test="${cd.utilise == true}">check</c:if><c:if test="${cd.utilise == false}">close</c:if></i></td>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">	
									<td><a href="<c:url value="/cds/toUpdate?id=${cd.id}" />"><spring:message code="entities.update" /></a></td>
									<td><a href="<c:url value="/cds/delete/${cd.id}" />"><spring:message code="entities.delete" /></a></td>
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