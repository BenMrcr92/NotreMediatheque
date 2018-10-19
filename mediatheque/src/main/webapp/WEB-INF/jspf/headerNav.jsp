<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<span id="TOP"></span>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="nav navbar-nav"><span class="navbar-brand text-info"><spring:message code="commons.nav.brand" /></span>
		<sec:authorize access="isAuthenticated()">
			<li class="nav-item"><a class="nav-link" href="<c:url value="/home/welcome" />"><spring:message code="commons.nav.home" /></a></li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="commons.nav.elements" /></a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="<c:url value="/films/toCreate" />"><spring:message code="commons.nav.film" /></a>
					<a class="dropdown-item" href="<c:url value="/livres/toCreate" />"><spring:message code="commons.nav.livre" /></a>
					<a class="dropdown-item" href="<c:url value="/jeux/toCreate" />"><spring:message code="commons.nav.jeu" /></a>
					<a class="dropdown-item" href="<c:url value="/dvds/toCreate" />"><spring:message code="commons.nav.dvd" /></a>
					<a class="dropdown-item" href="<c:url value="/cds/toCreate" />"><spring:message code="commons.nav.cd" /></a>
				</div>
			</li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav-item"><a class="nav-link" href="<c:url value="/users/toList" />"><spring:message code="commons.nav.userList" /></a></li>
		</sec:authorize>
		
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="commons.nav.languages" /></a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<c:set var="langBaseUrl" value="/security/login" />
				<sec:authorize access="isAuthenticated()">
					<c:set var="langBaseUrl" value="/home/welcome" />
				</sec:authorize>
				<a class="dropdown-item" href="<c:url value="${langBaseUrl}?lang=fr" />"><spring:message code="commons.nav.languages.french" /></a>
				<a class="dropdown-item isDisabled" href="<c:url value="${langBaseUrl}?lang=en" />"><spring:message code="commons.nav.languages.english" /></a>
			</div>
		</li>
		<sec:authorize access="isAuthenticated()">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><sec:authentication property="principal.user.pseudo" /></a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="<c:url value="/users/toUpdate?id=" /><sec:authentication property="principal.user.id" />"><spring:message code="commons.nav.settings.account" /></a>
					<a class="dropdown-item" href="<c:url value="/logout" />"><spring:message code="commons.nav.settings.logout" /></a>
				</div>
			</li>
		</sec:authorize>
	</ul>
</nav>