<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
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
                <td><c:out value="${user.address}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.zipcode" /></th>
                <td><c:out value="${user.zipCode}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.city" /></th>
                <td><c:out value="${user.city}" /></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.sex" /></th>
                <td><c:choose>
                        <c:when test="${user.sex == true}">
                            <fmt:message key="db.user.sex.1" />
                        </c:when>
                        <c:when test="${user.sex == false}">
                            <fmt:message key="db.user.sex.0" />
                        </c:when>
                    </c:choose></td>
            </tr>
            <tr>
                <th><fmt:message key="db.user.admin" /></th>
                <td><c:choose>
                    <c:when test="${user.admin == true}">
                        <fmt:message key="yes" />
                    </c:when>
                    <c:otherwise>
                        <fmt:message key="no" />
                    </c:otherwise>
                </c:choose></td>
            </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>