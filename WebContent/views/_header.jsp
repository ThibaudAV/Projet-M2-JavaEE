<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}" scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.blog.i18n.langue" />

<!DOCTYPE html>
<html lang="${language}">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog - ${language}</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/business-casual.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>

<body>

    <div class="brand">Le P'ti dev</div>
    <div class="address-bar"><fmt:message key="general.subtitle" /></div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="<c:url value="/Articles"/>">Le P'ti dev</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<c:url value="/Articles"/>"><fmt:message key="general.blog" /></a>
                    </li>
                    <li>
                        <a href="<c:url value="/About"/>"><fmt:message key="general.who" /></a>
                    </li>
                    <li class="dropdown">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
			          <c:if test="${language == 'en'}">
			          	<img alt="Brand" width="32px" height="32px" src="${pageContext.request.contextPath}/static/img/en-EN.png"> English
			          </c:if>
			          <c:if test="${language == 'fr'}">
			          	<img alt="Brand" width="32px" height="32px" src="${pageContext.request.contextPath}/static/img/fr-FR.png"> Francais
			          </c:if> <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="?language=en&${pageContext.request.queryString}"><img alt="Brand" width="32px" height="32px" src="${pageContext.request.contextPath}/static/img/en-EN.png"> English</a></li>
			            <li><a href="?language=fr&${pageContext.request.queryString}"><img alt="Brand" width="32px" height="32px" src="${pageContext.request.contextPath}/static/img/fr-FR.png"> Francais</a></li>
			          </ul>
			        </li>
                    	<c:choose> 
                    		<c:when test="${!empty sessionScope.user}">	
			                    <li class="dropdown">
			          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
			          					<span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${sessionScope.user.pseudo}<span class="caret"></span>
			          				</a>
						          <ul class="dropdown-menu" role="menu">
						          
						            <li><a href="<c:url value="/Article_my"/>"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> <fmt:message key="general.myarticles" /></a></li>
						            <li><a href="<c:url value="/Article_create"/>"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span><fmt:message key="general.addarticle" /></a></li>
						            <li><a href="<c:url value="/Profil"/>"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><fmt:message key="general.profile" /></a></li>
						          	<li><a href="<c:url value="/Connexion?query=deconnexion"/>"><fmt:message key="general.signout" /></a></li>
						          </ul>
						        </li>
                    		</c:when>
  							<c:otherwise>
			                    <li class="dropdown">
			          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
			          					<span class="glyphicon glyphicon-user" aria-hidden="true"></span> <fmt:message key="general.signin" /> <span class="caret"></span>
			          				</a>
						          <ul class="dropdown-menu" role="menu">
						            <li><a href="<c:url value="/Inscription"/>"> <fmt:message key="general.register" /></a></li>
						            <li><a href="<c:url value="/Connexion"/>"><fmt:message key="general.signin" /></a></li>
						          </ul>
						        </li>
                        	</c:otherwise>
                    	</c:choose>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">