<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.user.edit.title" /></h1>
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <div class="row">
        <form role="form" action="<c:out value="${originURL}" />" method="post">
            <div class="form-group <c:if test="${result != null}">${empty errors['sex'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="sex"><fmt:message key="db.user.sex" /></label>
                <select id="sex" name="sex" class="form-control">
                    <option
                            <c:if test="${user.sex == false}">selected="selected"</c:if>
                            value="false"><fmt:message key="db.user.sex.0"/></option>
                    <option
                            <c:if test="${user.sex == true}">selected="selected"</c:if>
                            value="true"><fmt:message key="db.user.sex.1"/></option>
                </select>
                <c:if test="${errors['sex'] != null}">
                    <span class="help-block"><fmt:message key="${errors['sex']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['firstname'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="firstname"><fmt:message key="db.user.firstname" /></label>
                <input type="text"
                       class="form-control"
                       id="firstname"
                       name="firstname"
                       required="required"
                       value="<c:out value="${user.firstname}"/>"
                       maxlength="255">
                <c:if test="${errors['firstname'] != null}">
                    <span class="help-block"><fmt:message key="${errors['firstname']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['lastname'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="lastname"><fmt:message key="db.user.lastname" /></label>
                <input type="text"
                       class="form-control"
                       id="lastname"
                       name="lastname"
                       required="required"
                       value="<c:out value="${user.lastname}"/>"
                       maxlength="255">
                <c:if test="${errors['lastname'] != null}">
                    <span class="help-block"><fmt:message key="${errors['lastname']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['email'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="email"><fmt:message key="db.user.email" /></label>
                <input type="email"
                       class="form-control"
                       id="email"
                       name="email"
                       required="required"
                       value="<c:out value="${user.email}"/>">
                <c:if test="${errors['email'] != null}">
                    <span class="help-block"><fmt:message key="${errors['email']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['password'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="password"><fmt:message key="db.user.password" /></label>
                <input type="password"
                       class="form-control"
                       id="password"
                       name="password"
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
                       value="<c:out value="${param.confirmPassword}"/>">
                <c:if test="${errors['confirmPassword'] != null}">
                    <span class="help-block"><fmt:message key="${errors['confirmPassword']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['address'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="address"><fmt:message key="db.user.address" /></label>
                <input type="text"
                       class="form-control"
                       id="address"
                       name="address"
                       value="<c:out value="${user.address}"/>"
                       maxlength="255">
                <c:if test="${errors['address'] != null}">
                    <span class="help-block"><fmt:message key="${errors['address']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['zipCode'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="zipCode"><fmt:message key="db.user.zipcode" /></label>
                <input type="text"
                       class="form-control"
                       id="zipCode"
                       name="zipCode"
                       value="<c:out value="${user.zipCode}"/>"
                       maxlength="255">
                <c:if test="${errors['zipCode'] != null}">
                    <span class="help-block"><fmt:message key="${errors['zipCode']}" /></span>
                </c:if>
            </div>
            <div class="form-group <c:if test="${result != null}">${empty errors['city'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="city"><fmt:message key="db.user.city" /></label>
                <input type="text"
                       class="form-control"
                       id="city"
                       name="city"
                       value="<c:out value="${user.city}"/>"
                       maxlength="255">
                <c:if test="${errors['city'] != null}">
                    <span class="help-block"><fmt:message key="${errors['city']}" /></span>
                </c:if>
            </div>
            <button type="submit" class="btn btn-default"><fmt:message key="submit" /></button>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>