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
			<div class="row justify-content-between mb-3">
				<div class="input-group col-4">
	   				<div class="input-group-prepend">
	   					<i class="material-icons input-group-text">search</i>
	   				</div>
					<input class="form-control" id="recherche" type="text">
				</div>
				<a class="btn btn-primary" href="<c:url value="/users/toCreate" />"><i class="material-icons align-bottom">add_circle</i></a>
			</div>
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
				<tbody id="myTable">
					<tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.pseudo}</td>
							<td>${user.email}</td>
							<td>${user.lastname}</td>
							<td>${user.firstname}</td>
							<td><a class="btn btn-primary btn-sm" href="<c:url value="/users/toUpdate?id=${user.id}" />"><i class="material-icons align-bottom">create</i></a></td>
							<td><a class="btn btn-primary btn-sm" href="<c:url value="/users/delete/${user.id}" />"><i class="material-icons align-bottom">delete</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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