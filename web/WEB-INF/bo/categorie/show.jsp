<%--
  Created by IntelliJ IDEA.
  User: Romain Letrémy
  Date: 30/11/13
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.categorie.show.title" /></h1>
    <table class="table table-striped">
        <tbody>
            <tr>
                <th><fmt:message key="bo.page.categorie.show.id" /></th>
                <td><c:out value="${categorie.id}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="bo.page.categorie.show.name" /></th>
                <td><c:out value="${categorie.name}" /></td>
            </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>