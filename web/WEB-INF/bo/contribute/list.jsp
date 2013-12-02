<%--
  Created by IntelliJ IDEA.
  User: Robin
  Date: 28/11/13
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>
<div class="container">
    <h1><fmt:message key="bo.page.contribute.list.title" /></h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th><fmt:message key="db.id" /></th>
            <th><fmt:message key="db.contribute.amount" /></th>
            <th><fmt:message key="db.contribute.date" /></th>
            <th><fmt:message key="db.contribute.userId" /></th>
            <th><fmt:message key="db.contribute.projectId" /></th>
            <th><fmt:message key="bo.page.contribute.list.table.head.actions" /></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${contributes.isEmpty()}">
            <tr>
                <td colspan="5"><fmt:message key="bo.page.contribute.list.table.empty" /></td>
            </tr>
        </c:if>
        <c:forEach items="${contributes}" var="c">
            <tr>
                <td><c:out value="${c.id}" /></td>
                <td><c:out value="${c.amount}" /> €</td>
                <td><c:out value="${func:dateToStringVue(c.rightNow)}" /></td>
                <td><c:out value="${c.user.id}" /> <em><a href="<%=request.getContextPath()%>/bo/user/edit?id=<c:out value="${c.user.id}" />">(${c.user.email})</a></em></td>
                <td><c:out value="${c.project.id}" /> <em>(${c.project.name})</em></td>
                <td>
                    <a href="<%=request.getContextPath()%>/bo/contribute/edit?id=<c:out value="${c.id}" />"
                    class="glyphicon glyphicon-pencil">&nbsp;</a>
                    <a onclick="return confirm('<fmt:message key="bo.page.contribute.list.actions.removeConfirm" />')" href="<%=request.getContextPath()%>/bo/contribute/delete?id=<c:out value="${c.id}" />"
                    class="glyphicon glyphicon-remove-sign">&nbsp;</a>
                </td>
            </tr>
        </c:forEach>
            <tr>
                <td colspan="6" class="text-center"><a href="<%=request.getContextPath()%>/bo/contribute/create"><fmt:message key="bo.page.contribute.list.button.new" /></a></td>
            </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>