<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.supinfo.supcrowdfunder.util.FlashBag" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="com.supinfo.supcrowdfunder.lang.Msg" />
<fmt:setLocale value="fr" scope="session"/>
<!doctype html>
<html>
<head>
    <title>SupCrowdfunder</title>
    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
    <header class="navbar navbar-fixed-top">
        <div class="navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/">SupCrowdfunder</a>
                </div>
                <nav class="collapse navbar-collapse" role="navigation">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="<%=request.getContextPath()%>/project">Projets</a>
                        </li>
                    </ul>
                    <c:if test="${sessionScope.email == null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="<%=request.getContextPath()%>/login">Login</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/registration">Sign in</a>
                        </li>
                    </ul>
                    </c:if>
                    <c:if test="${sessionScope.email != null}">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="<%=request.getContextPath()%>/me/logout">Logout</a>
                            </li>
                        </ul>
                    </c:if>
                </nav>
            </div>
        </div>
    </header>
    <c:if test="${flashbag != null && flashbag.hasFlashs()}">
        <div class="container">
        <c:forEach var="f" items="${flashbag.getFlashs().entrySet()}">
            <c:forEach var="m" items="${flashbag.getOnceFlash(f.key)}">
                <div class="alert alert-<c:out value="${f.key}" /> alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <fmt:message key="${m}" />
                </div>
            </c:forEach>
        </c:forEach>
        </div>
    </c:if>

