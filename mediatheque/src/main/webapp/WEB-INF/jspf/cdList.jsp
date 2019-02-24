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
			<h1 class="text-primary text-center"><spring:message code="entities.cd.list.title" /></h1>
			<div class="row justify-content-between mb-3">
				<div class="input-group col-4">
	   				<div class="input-group-prepend">
	   					<i class="material-icons input-group-text">search</i>
	   				</div>
					<input class="form-control" id="recherche" type="text">
				</div>
				<a class="btn btn-primary" href="<c:url value="/cds/toCreate" />"><i class="material-icons align-bottom">add_circle</i></a>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-primary">
						<tr>
							<th scope="col"><spring:message code="entities.cd.nom" /></th>
							<th scope="col"><spring:message code="entities.cd.dateSortie" /></th>
							<th scope="col"><spring:message code="entities.cd.favori" /></th>
							<th scope="col"><spring:message code="entities.cd.utilise" /></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="tableau">
						<tr>
						<c:forEach items="${cds}" var="cd">
							<tr>
								<td>${cd.nom}</td>
								<td>${cd.dateSortie}</td>
								<td><i class="material-icons"><c:if test="${cd.favori == true}">favorite</c:if><c:if test="${cd.favori == false}">favorite_border</c:if></i></td>
								<td><i class="material-icons"><c:if test="${cd.utilise == true}">check</c:if><c:if test="${cd.utilise == false}">close</c:if></i></td>
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">	
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/cds/toUpdate?id=${cd.id}" />"><i class="material-icons align-bottom">create</i></a></td>
									<td><a class="btn btn-primary btn-sm" href="<c:url value="/cds/delete/${cd.id}" />"><i class="material-icons align-bottom">delete</i></a></td>
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
		function myFunction() {
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("recherche");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("tableau");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
	</script>
</body>
</html>