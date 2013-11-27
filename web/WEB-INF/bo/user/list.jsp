<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.user.list.title" /></h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th><fmt:message key="db.id" /></th>
            <th><fmt:message key="db.user.email" /></th>
            <th><fmt:message key="db.user.firstname" /></th>
            <th><fmt:message key="db.user.lastname" /></th>
            <th><fmt:message key="bo.page.user.list.table.head.actions" /></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${users.isEmpty()}">
            <tr>
                <td colspan="5"><fmt:message key="bo.page.user.list.table.empty" /></td>
            </tr>
        </c:if>
        <c:forEach items="${users}" var="u">
            <tr>
                <td><c:out value="${u.id}" /></td>
                <td><c:out value="${u.email}" /></td>
                <td><c:out value="${u.firstname}" /></td>
                <td><c:out value="${u.lastname}" /></td>
                <td>
                    <a href="<%=request.getContextPath()%>/bo/user/show?id=<c:out value="${u.id}" />"
                       class="glyphicon glyphicon-eye-open">&nbsp;</a>
                    <a href="<%=request.getContextPath()%>/bo/user/edit?id=<c:out value="${u.id}" />"
                       class="glyphicon glyphicon-pencil">&nbsp;</a>
                    <a onclick="return confirm('<fmt:message key="bo.page.user.list.actions.removeConfirm" />')" href="<%=request.getContextPath()%>/bo/user/delete?id=<c:out value="${u.id}" />"
                       class="glyphicon glyphicon-remove-sign">&nbsp;</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>