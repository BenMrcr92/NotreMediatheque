<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.user.update.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary text-center"><spring:message code="entities.user.update.title" /></h1>
			<form:form action="update" method="POST" modelAttribute="user">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<form:hidden path="id"/>
				<form:hidden path="email"/>
				<form:hidden path="role"/>
				<div class="form-row">
					<div class="form-group col">
						<form:label path="pseudo"><spring:message code="entities.user.pseudo" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="pseudo" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="pseudo" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="firstname"><spring:message code="entities.user.firstname" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="firstname" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="firstname" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="lastname"><spring:message code="entities.user.lastname" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="lastname" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="lastname" cssClass="invalid-feedback" />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col">
						<form:label path="email"><spring:message code="entities.user.email" /></form:label>
						<div class="input-group">
							<div class="input-group-prepend">
						        <div class="input-group-text"><spring:message code="commons.symbols.email" /></div>
						     </div>
							<form:input path="email" maxlength="255" cssClass="form-control" disabled="true" autocomplete="off" />
						</div>
					</div>
					<div class="form-group col">
						<form:label path="password"><spring:message code="entities.user.passwordUpdate" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:password path="password" maxlength="100" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="password" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="role"><spring:message code="entities.user.role" /></form:label>
						<form:select path="role" cssClass="form-control" disabled="true">
							<form:options items="${roles}" itemValue="name" itemLabel="name" />
						</form:select>
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