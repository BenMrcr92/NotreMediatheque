<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.livre.update.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary"><spring:message code="entities.livre.update.title" /></h1>
			<form:form action="update" method="POST" modelAttribute="livre">
				<div class="form-row">
					<form:hidden path="id" />
					<div class="form-group col">
						<form:label path="nom"><spring:message code="entities.livre.nom" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<form:input path="nom" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" lang="fr" />
							<form:errors element="div" path="nom" cssClass="invalid-feedback" />
						</div>
					</div>
				</div>
				<div class="form-row">
			 		<spring:message code="commons.formats.date" var="datePattern" />
					<div class="form-group col">
						<form:label path="dateParution"><spring:message code="entities.livre.dateParution" /></form:label>
						<form:input path="dateParution" maxlength="10" placeHolder="${datePattern}" cssClass="form-control datepicker" autocomplete="off" />
					</div>
				</div>
			 	<div class="form-row">
			 		<div class="form-group col">
						<form:label path="description"><spring:message code="entities.livre.description" /></form:label>
						<form:textarea path="description" rows="5" cssClass="form-control" lang="fr" />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col">
						<div class="form-check">
							<form:checkbox path="favori" class="form-check-input" id="favori" />
							<form:label path="favori" class="form-check-label" for="favori"><spring:message code="entities.livre.favori" /></form:label>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col">
						<div class="form-check">
							<form:checkbox path="utilise" class="form-check-input" id="utilise" />
							<form:label path="utilise" class="form-check-label" for="utilise"><spring:message code="entities.livre.utilise" /></form:label>
						</div>
					</div>
				</div>
				<button type="reset" class="btn btn-primary mb-3"><spring:message code="commons.forms.reset" /></button>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>