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
    <title><fmt:message key="fo.title" /></title>
    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
    <header class="navbar navbar-fixed-top">
        <div class="navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/"><fmt:message key="fo.title" /></a>
                </div>
                <nav class="collapse navbar-collapse" role="navigation">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="<%=request.getContextPath()%>/project"><fmt:message key="fo.menu.projects" /></a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/me/edit"><fmt:message key="fo.menu.profil" /></a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Langages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Français</a></li>
                                <li><a href="#">English</a></li>
                                <li><a href="#">Spain</a></li>
                                <li><a href="#">Deutsch</a></li>
                            </ul>
                        </li>
                        <c:choose>
                            <c:when test="${sessionScope.email != null}">
                                <li>
                                    <a href="<%=request.getContextPath()%>/me/logout"><fmt:message key="menu.logout" /></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="<%=request.getContextPath()%>/login"><fmt:message key="fo.menu.login" /></a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/registration"><fmt:message key="fo.menu.registration" /></a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
<%@ include file="/WEB-INF/includes/flashbag.jsp"%>