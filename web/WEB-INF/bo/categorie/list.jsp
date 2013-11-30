<%--
  Created by IntelliJ IDEA.
  User: Romain Letrémy
  Date: 26/11/13
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.categorie.list.title" /></h1>

    <table class="table table-striped">
        <thead>
            <tr>
                <th><fmt:message key="bo.page.categorie.list.table.head.id" /></th>
                <th><fmt:message key="bo.page.categorie.list.table.head.name" /></th>
                <th><fmt:message key="bo.page.categorie.list.table.head.actions" /></th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${categories.isEmpty()}">
            <tr>
                <td colspan="5"><fmt:message key="bo.page.categorie.list.table.empty" /></td>
            </tr>
        </c:if>
        <c:forEach items="${categories}" var="c">
            <tr>
                <td><c:out value="${c.id}" /></td>
                <td><c:out value="${c.name}" /></td>
                <td>
                    <a href="<%=request.getContextPath()%>/bo/categorie/show?id=<c:out value="${c.id}" />"
                       class="glyphicon glyphicon-eye-open">&nbsp;</a>
                    <a href="<%=request.getContextPath()%>/bo/categorie/edit?id=<c:out value="${c.id}" />"
                       class="glyphicon glyphicon-pencil">&nbsp;</a>
                    <a href="<%=request.getContextPath()%>/bo/categorie/delete?id=<c:out value="${c.id}" />"
                       class="glyphicon glyphicon-remove-sign">&nbsp;</a>
               </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>