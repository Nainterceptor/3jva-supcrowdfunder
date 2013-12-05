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
            <td><c:out value="${project.id}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.name" /></th>
            <td><c:out value="${project.name}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.categorie" /></th>
            <td><c:out value="${project.categories.id}" /> <em>
                <a href="<%=request.getContextPath()%>/bo/categorie/show?id=<c:out value="${project.categories.id}" />">
                    (${project.categories.name})</a></em></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.userId" /></th>
            <td><c:out value="${project.user.id}" /> <em>
                <a href="<%=request.getContextPath()%>/bo/categorie/user?id=<c:out value="${project.user.id}" />">
                    (${project.user.email})</a></em></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.needCredits" /></th>
            <td><c:out value="${project.needCredits}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.actualCredits" /></th>
            <td><c:out value="${func:calculateSumContibutes(project.id)}" /></td>
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
    <p><a href="<%=request.getContextPath()%>/bo/project/edit?id=<c:out value="${project.id}" />" class="btn btn-primary">Editer</a></p>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>