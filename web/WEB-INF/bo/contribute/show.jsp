<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>
<div class="container">
    <h1><fmt:message key="bo.page.contribute.show.title" /></h1>
    <table class="table table-striped">
        <tbody>
        <tr>
            <th><fmt:message key="db.id" /></th>
            <td><c:out value="${contribute.id}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.contribute.amount" /></th>
            <td><c:out value="${contribute.amount}" />€</td>
        </tr>
        <tr>
            <th><fmt:message key="db.contribute.date" /></th>
            <td><c:out value="${func:dateToStringVue(contribute.rightNow)}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.contribute.userId" /></th>
            <td><c:out value="${contribute.user.id}" /> <em>
                <a href="<%=request.getContextPath()%>/bo/user/show?id=<c:out value="${contribute.user.id}" />">
                    (${contribute.user.email})</a></em></td>
        </tr>
        <tr>
            <th><fmt:message key="db.contribute.projectId" /></th>
            <td><c:out value="${contribute.project.id}" /> <em>
                <a href="<%=request.getContextPath()%>/bo/project/show?id=<c:out value="${contribute.project.id}" />">
                    (${contribute.project.name})</a></em></td>
        </tr>
        </tbody>
    </table>
    <p><a href="<%=request.getContextPath()%>/bo/contribute/edit?id=<c:out value="${contribute.id}" />" class="btn btn-primary">Editer</a></p>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>