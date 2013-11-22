<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="/css/style.css" />
</head>
<body>
<%@ include file="/WEB-INF/includes/header.jsp"%>

<div class="container-at-bar">
    <a class="btn btn-primary" href="<%=request.getContextPath()%>/addProject">Add a project</a>
</div>
</body>
</html>