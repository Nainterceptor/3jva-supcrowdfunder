<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.contribute.edit.title" /></h1>
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <div class="row">
        <form role="form" action="<c:out value="${originURL}" />" method="post">
            <div class="form-group <c:if test="${result != null}">${empty errors['amount'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="amount"><fmt:message key="db.contribute.amount" /></label>
                <input type="text"
                       class="form-control"
                       id="amount"
                       name="amount"
                       required="required"
                       value="<c:out value="${param.amount}"/>"
                       maxlength="255">
                <c:if test="${errors['amount'] != null}">
                    <span class="help-block"><fmt:message key="${errors['amount']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['userId'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="userId"><fmt:message key="db.contribute.userId" /></label>
                <input type="text"
                       class="form-control"
                       id="userId"
                       name="userId"
                       required="required"
                       value="<c:out value="${param.userId}"/>"
                       maxlength="255">
                <c:if test="${errors['userId'] != null}">
                    <span class="help-block"><fmt:message key="${errors['userId']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['projectId'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="projectId"><fmt:message key="db.contribute.projectId" /></label>
                <input type="text"
                       class="form-control"
                       id="projectId"
                       name="projectId"
                       required="required"
                       value="<c:out value="${param.projectId}"/>">
                <c:if test="${errors['projectId'] != null}">
                    <span class="help-block"><fmt:message key="${errors['projectId']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['rightNow'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="rightNow"><fmt:message key="db.contribute.date" /></label>
                <input type="date"
                       class="form-control"
                       id="rightNow"
                       name="rightNow"
                       value="<c:out value="${param.rightNow}"/>">
                <c:if test="${errors['rightNow'] != null}">
                    <span class="help-block"><fmt:message key="${errors['rightNow']}" /></span>
                </c:if>
            </div>
            <button type="submit" class="btn btn-default"><fmt:message key="submit" /></button>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>