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
			<h1 class="text-primary text-center"><spring:message code="entities.livre.list.title" /></h1>
			<div class="row justify-content-between mb-3">
				<div class="input-group col-4">
	   				<div class="input-group-prepend">
	   					<i class="material-icons input-group-text">search</i>
	   				</div>
					<input class="form-control" id="recherche" type="text">
				</div>
				<a class="btn btn-primary" href="<c:url value="/livres/toCreate" />"><i class="material-icons align-bottom">add_circle</i></a>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-primary">
						<tr>
							<th scope="col"><spring:message code="entities.livre.nom" /></th>
							<th scope="col"><spring:message code="entities.livre.dateParution" /></th>
							<th scope="col"><spring:message code="entities.livre.favori" /></th>
							<th scope="col"><spring:message code="entities.livre.utilise" /></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="myTable">
						<tr>
						<c:forEach items="${livres}" var="livre">
							<tr>
								<td>${livre.nom}</td>
								<td>${livre.dateParution}</td>
								<td><i class="material-icons"><c:if test="${livre.favori == true}">favorite</c:if><c:if test="${livre.favori == false}">favorite_border</c:if></i></td>
								<td><i class="material-icons"><c:if test="${livre.utilise == true}">check</c:if><c:if test="${livre.utilise == false}">close</c:if></i></td>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">	
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/livres/toUpdate?id=${livre.id}" />"><i class="material-icons align-bottom">create</i></a></td>
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/livres/delete/${livre.id}" />"><i class="material-icons align-bottom">delete</i></a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
	<c:import url="footerNav.jsp" />
	<script>
		$(document).ready(function(){
		  $("#recherche").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
</body>
</html>