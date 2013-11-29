<%--
  Created by IntelliJ IDEA.
  User: Robin
  Date: 28/11/13
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>

<div class="container" style="width: 50%">
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <h2 class="form">Merci pour votre contribution !</h2>

    <p>
        Nous vous remercions pour votre participation de <strong>${param.amount}€</strong> au projet : <strong>${projectName}</strong>
    </p>

    <p><a href="<%=request.getContextPath()%>/project/show?id=<c:out value="${param.projectId}" />" class="btn btn-primary">Retour au projet</a></p>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
