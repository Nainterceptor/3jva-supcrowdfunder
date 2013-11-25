<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container" style="width: 50%">
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <h2 class="form">Création d'un nouveau projet</h2>

    <form class="form-horizontal" action="/addProject">
        </br>
        <div class="form-group<c:if test="${result != null}">${empty errors['name'] ? 'has-success' : 'has-error'}</c:if>">
            <label class="col-sm-3 control-label"><fmt:message key="form.project.name" /></label>
            <div class="col-sm-9">
                <input type="text"
                       class="form-control"
                       id="name"
                       name="name"
                       required="required"
                       placeholder="<fmt:message key="form.project.name.placeholder" />"
                       value="<c:out value="${param.name}"/>"
                       maxlength="255">
                <c:if test="${errors['name'] != null}">
                    <span class="help-block"><fmt:message key="${errors['name']}" /></span>
                </c:if>
            </div>

        </div>
        <div class="form-group <c:if test="${result != null}">${empty errors['needCredits'] ? 'has-success' : 'has-error'}</c:if>">
            <label><fmt:message key="form.project.needCredits" /></label>
            <input type="text"
                   class="form-control"
                   id="needCredits"
                   name="needCredits"
                   required="required"
                   placeholder="<fmt:message key="form.project.needCredits.placeholder" />"
                   value="<c:out value="${param.needCredits}"/>"
                   maxlength="255">
            <c:if test="${errors['needCredits'] != null}">
                <span class="help-block"><fmt:message key="${errors['needCredits']}" /></span>
            </c:if>
        </div>
        <div class="form-group <c:if test="${result != null}">${empty errors['details'] ? 'has-success' : 'has-error'}</c:if>">
            <label><fmt:message key="form.project.details" /></label>
            <input type="textarea"
                   class="form-control"
                   id="details"
                   name="details"
                   required="required"
                   placeholder="<fmt:message key="form.project.details.placeholder" />"
                   value="<c:out value="${param.details}"/>"
                   maxlength="255">
            <c:if test="${errors['details'] != null}">
                <span class="help-block"><fmt:message key="${errors['details']}" /></span>
            </c:if>
        </div>
        <div class="form-group <c:if test="${result != null}">${empty errors['term'] ? 'has-success' : 'has-error'}</c:if>">
            <label><fmt:message key="form.project.term" /></label>
            <input type="date"
                   class="form-control"
                   id="details"
                   name="details"
                   required="required"
                   placeholder="<fmt:message key="form.project.term.placeholder" />"
                   value="<c:out value="${param.term}"/>"
                   maxlength="255">
            <c:if test="${errors['term'] != null}">
                <span class="help-block"><fmt:message key="${errors['term']}" /></span>
            </c:if>
        </div>
        <button class="btn btn-lg btn-primary" type="submit">Submit</button>
    </form>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
