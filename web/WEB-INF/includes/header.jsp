<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="com.supinfo.supcrowdfunder.lang.Msg" />
<fmt:setLocale value="fr" scope="session"/>
<!doctype html>
<html>
<head>
    <title>SupCrowdfunder</title>
    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
        <div class="navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/">SupCrowdfunder</a>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="<%=request.getContextPath()%>/Project">Projets</a>
                        </li>
                        <li>
                            <a href="#">Utilisateurs</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>