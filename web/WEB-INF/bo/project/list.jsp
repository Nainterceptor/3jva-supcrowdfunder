<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>
<div class="container">
    <h1><fmt:message key="bo.page.project.list.title" /></h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th><fmt:message key="db.id" /></th>
            <th><fmt:message key="db.project.name" /></th>
            <th><fmt:message key="db.project.categorie" /></th>
            <th><fmt:message key="db.project.userId" /></th>
            <th><fmt:message key="db.project.needCredits" /></th>
            <th><fmt:message key="db.project.actualCredits" /></th>
            <th><fmt:message key="db.project.term" /></th>
            <th><fmt:message key="bo.page.project.list.table.head.actions" /></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${projects.isEmpty()}">
            <tr>
                <td colspan="5"><fmt:message key="bo.page.project.list.table.empty" /></td>
            </tr>
        </c:if>
        <c:forEach items="${projects}" var="p">
            <tr>
                <td><c:out value="${p.id}" /></td>
                <td><c:out value="${p.name}" /></td>
                <td><c:out value="${p.categories.id}" /> <em>
                    <a href="<%=request.getContextPath()%>/bo/categorie/show?id=<c:out value="${p.categories.id}" />">
                        (${p.categories.name})</a></em></td>
                <td><c:out value="${p.user.id}" /> <em>
                    <a href="<%=request.getContextPath()%>/bo/categorie/user?id=<c:out value="${p.user.id}" />">
                        (${p.user.email})</a></em></td>
                <td><c:out value="${p.needCredits}" /></td>
                <td><c:out value="${func:calculateSumContibutes(p.id)}" /></td>
                <td><c:out value="${func:dateToStringVue(p.term)}" /></td>
                <td>
                    <a href="<%=request.getContextPath()%>/bo/project/show?id=<c:out value="${p.id}" />"
                    class="glyphicon glyphicon-eye-open">&nbsp;</a>
                    <a href="<%=request.getContextPath()%>/bo/project/edit?id=<c:out value="${p.id}" />"
                    class="glyphicon glyphicon-pencil">&nbsp;</a>
                    <a onclick="return confirm('<fmt:message key="bo.page.project.list.actions.removeConfirm" />')" href="<%=request.getContextPath()%>/bo/project/delete?id=<c:out value="${p.id}" />"
                    class="glyphicon glyphicon-remove-sign">&nbsp;</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" class="text-center"><a href="<%=request.getContextPath()%>/bo/project/create"><fmt:message key="bo.page.project.list.button.new" /></a></td>
        </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>