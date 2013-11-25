<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
    <h1><fmt:message key="page.registration.title" /></h1>
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <div class="row">
        <form role="form" action="<%=request.getContextPath()%>/registration" method="post">
            <div class="form-group <c:if test="${result != null}">${empty errors['firstname'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="firstname"><fmt:message key="form.registration.firstname" /></label>
                <input type="text"
                       class="form-control"
                       id="firstname"
                       name="firstname"
                       required="required"
                       placeholder="<fmt:message key="form.registration.firstname.placeholder" />"
                       value="<c:out value="${param.firstname}"/>"
                       maxlength="255">
                <c:if test="${errors['firstname'] != null}">
                    <span class="help-block"><fmt:message key="${errors['firstname']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['lastname'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="lastname"><fmt:message key="form.registration.lastname" /></label>
                <input type="text"
                       class="form-control"
                       id="lastname"
                       name="lastname"
                       required="required"
                       placeholder="<fmt:message key="form.registration.lastname.placeholder" />"
                       value="<c:out value="${param.lastname}"/>"
                       maxlength="255">
                <c:if test="${errors['lastname'] != null}">
                    <span class="help-block"><fmt:message key="${errors['lastname']}" /></span>
                </c:if>
            </div>
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
            <div class="form-group <c:if test="${result != null}">${empty errors['confirmPassword'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="confirmPassword"><fmt:message key="form.registration.confirmPassword" /></label>
                <input type="password"
                       class="form-control"
                       id="confirmPassword"
                       name="confirmPassword"
                       required="required"
                       placeholder="<fmt:message key="form.registration.confirmPassword.placeholder" />"
                       value="<c:out value="${param.confirmPassword}"/>">
                <c:if test="${errors['confirmPassword'] != null}">
                    <span class="help-block"><fmt:message key="${errors['confirmPassword']}" /></span>
                </c:if>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>