<%--
  Created by IntelliJ IDEA.
  User: Robin
  Date: 27/11/13
  Time: 00:30
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
    <h2 class="form">Participer au projet</h2>

    <form class="form" action="<%=request.getContextPath()%>/me/contribute" method="get">
        </br>
        <div class="form-group <c:if test="${result != null}">${empty errors['amount'] ? 'has-success' : 'has-error'}</c:if>">
            <label><fmt:message key="form.contribute.amount" /></label>
            <input type="text"
                   class="form-control"
                   id="amount"
                   name="amount"
                   required="required"
                   placeholder="<fmt:message key="form.contribute.amount.placeholder" />"
                   value="<c:out value="${param.amount}"/>"
                   maxlength="255">
            <c:if test="${errors['amount'] != null}">
                <span class="help-block"><fmt:message key="${errors['amount']}" /></span>
            </c:if>
        </div>
        <button class="btn btn-lg btn-primary" type="submit"><fmt:message key="submit" /></button>
    </form>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
