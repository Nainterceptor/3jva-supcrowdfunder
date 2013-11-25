<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
    <h1><fmt:message key="page.login.title" /></h1>
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <div class="row">
        <form role="form" action="<%=request.getContextPath()%>/login" method="post">
            <div class="form-group <c:if test="${result != null}">${empty errors['email'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="email"><fmt:message key="form.registration.email" /></label>
                <input type="email"
                       class="form-control"
                       id="email"
                       name="email"
                       required="required"
                       placeholder="<fmt:message key="form.registration.email.placeholder" />"
                       value="<c:out value="${param.email}"/>">
                <c:if test="${errors['email'] != null}">
                    <span class="help-block"><fmt:message key="${errors['email']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['password'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="password"><fmt:message key="form.registration.password" /></label>
                <input type="password"
                       class="form-control"
                       id="password"
                       name="password"
                       required="required"
                       placeholder="<fmt:message key="form.registration.password.placeholder" />"
                       value="<c:out value="${param.password}"/>">
                <c:if test="${errors['password'] != null}">
                    <span class="help-block"><fmt:message key="${errors['password']}" /></span>
                </c:if>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>