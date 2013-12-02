<%--
  Created by IntelliJ IDEA.
  User: Robin
  Date: 01/12/13
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>

<div class="container">
    <h1><fmt:message key="page.project.show.title" /></h1>
    <table class="table table-striped">
        <tbody>
        <tr>
            <th><fmt:message key="db.id" /></th>
            <td><c:out value="${project.name}" /></td>
        </tr>
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
            <td><c:out value="${func:calculateSumContibutes(p.id)}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.details" /></th>
            <td><c:out value="${project.details}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.term" /></th>
            <td><c:out value="${func:dateToStringVue(project.term)}" /></td>
        </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>