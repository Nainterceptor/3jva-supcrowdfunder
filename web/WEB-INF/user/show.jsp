<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.user.show.title" /></h1>
    <table class="table table-striped">
        <tbody>
            <tr>
                <th><fmt:message key="db.id" /></th>
                <td><c:out value="${user.id}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.email" /></th>
                <td><c:out value="${user.email}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.firstname" /></th>
                <td><c:out value="${user.firstname}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.lastname" /></th>
                <td><c:out value="${user.lastname}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.address" /></th>
                <td><c:out value="${user.address}" /><br />
                    <c:out value="${user.zipCode}" /> <c:out value="${user.city}" /></td>
            </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>