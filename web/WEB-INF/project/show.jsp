<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 26/11/13
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
    <h1><fmt:message key="page.project.show.title" /></h1>
    <table class="table table-striped">
        <tbody>
        <tr>
            <th><fmt:message key="db.project.name" /></th>
            <td><c:out value="${project.name}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.categorie" /></th>
            <td><c:out value="${project.categories.name}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.needCredits" /></th>
            <td><c:out value="${project.needCredits}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.actualCredits" /></th>
            <td><c:out value="${project.actualCredits}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.details" /></th>
            <td><c:out value="${project.details}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.term" /></th>
            <td><c:out value="${project.term}" /></td>
        </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>