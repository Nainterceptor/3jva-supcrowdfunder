<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>
<div class="container" style="width: 50%">
    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <h2 class="form">Création d'un nouveau projet</h2>

    <form class="form-horizontal" action="<%=request.getContextPath()%>/me/project/add" method="post">
        </br>
        <div class="form-group<c:if test="${result != null}">${empty errors['name'] ? 'has-success' : 'has-error'}</c:if>">
            <label class="col-md-3 control-label"><fmt:message key="form.project.name" /></label>
            <div class="col-md-8">
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
            <label class="col-md-3 control-label"><fmt:message key="form.project.needCredits" /></label>
            <div class="col-md-3">
                <input type="text"
                       class="form-control"
                       id="needCredits"
                       name="needCredits"
                       required="required"
                       placeholder="<fmt:message key="form.project.needCredits.placeholder" />"
                       value="<c:out value="${param.needCredits}"/>"
                       maxlength="255">
            </div>
            <c:if test="${errors['needCredits'] != null}">
                <span class="help-block"><fmt:message key="${errors['needCredits']}" /></span>
            </c:if>
        </div>
        <div class="form-group <c:if test="${result != null}">${empty errors['details'] ? 'has-success' : 'has-error'}</c:if>">
            <label class="col-md-3 control-label"><fmt:message key="form.project.details" /></label>
            <div class="col-md-8">
                <textarea
                       class="form-control"
                       rows="12"
                       id="details"
                       name="details"
                       required="required"
                       placeholder="<fmt:message key="form.project.details.placeholder" />"
                       maxlength="5000"><c:out value="${param.details}"/></textarea>
            </div>
            <c:if test="${errors['details'] != null}">
                <span class="help-block"><fmt:message key="${errors['details']}" /></span>
            </c:if>
        </div>
        <div class="form-group <c:if test="${result != null}">${empty errors['categories'] ? 'has-success' : 'has-error'}</c:if>">
            <label class="col-md-3 control-label" for="categories"><fmt:message key="form.project.categorie" /></label>
            <div class="col-md-3">
                <select id="categories" name="categories" class="form-control">
                    <c:forEach items="${categories}" var="c">
                        <option value="<c:out value="${c.id}"/>"><c:out value="${c.name}" /></option>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${errors['categories'] != null}">
                <span class="help-block"><fmt:message key="${errors['categories']}" /></span>
            </c:if>
        </div>
        <div class="form-group <c:if test="${result != null}">${empty errors['term'] ? 'has-success' : 'has-error'}</c:if>">
            <label class="col-md-3 control-label" for="term"><fmt:message key="form.project.term" /></label>
            <div class="col-md-3">
                <input type="date"
                       class="form-control"
                       id="term"
                       name="term"
                       value="<c:out value="${func:dateDefault()}"/>"
                       maxlength="255">
            </div>
            <c:if test="${errors['term'] != null}">
                <span class="help-block"><fmt:message key="${errors['term']}" /></span>
            </c:if>
        </div>
        <div class="form-group">
            <span class="col-md-3"></span>
            <div class="col-md-3">
                <button class="btn btn-lg btn-primary" type="submit"><fmt:message key="submit" /></button>
            </div>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
