<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.supinfo.supcrowdfunder.util.FlashBag" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="com.supinfo.supcrowdfunder.lang.Msg" />
<!doctype html>
<html>
<head>
    <title><fmt:message key="bo.title" /></title>
    <meta charset="utf-8" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
    <header class="navbar navbar-fixed-top">
        <div class="navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/bo/"><fmt:message key="bo.title" /></a>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="bo.menu.crud" /> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="<%=request.getContextPath()%>/bo/project"><fmt:message key="bo.menu.projects" /></a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/bo/categorie"><fmt:message key="bo.menu.categories" /></a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/bo/user"><fmt:message key="bo.menu.users" /></a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/bo/contribute"><fmt:message key="bo.menu.contributes" /></a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.languages" /> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="?lang=fr"><fmt:message key="menu.languages.fr" /></a></li>
                                <li><a href="?lang=en"><fmt:message key="menu.languages.en" /></a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.account" /> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="<%=request.getContextPath()%>/me/edit"><fmt:message key="menu.profil" /></a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/me/logout"><fmt:message key="menu.logout" /></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/"><fmt:message key="bo.menu.backToSite" /></a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
    <%@ include file="/WEB-INF/includes/flashbag.jsp"%>
