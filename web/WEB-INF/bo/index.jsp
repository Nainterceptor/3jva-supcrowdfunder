<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1><fmt:message key="bo.page.index.title" /></h1>
        </div>
        <form action="/bo/" method="get" class="form-inline col-lg-6 bo-form text-right">
            <div class="form-group">
                <label class="sr-only" for="since"><fmt:message key="bo.page.dashboard.form.from" /></label>
                <input class="form-control"
                        name="since"
                        id="since"
                        value="<c:out value="${param.since}" />"
                        placeholder="<fmt:message key="bo.page.dashboard.form.from" />"
                        />
            </div>
            <div class="form-group">
                <label class="sr-only" for="to"><fmt:message key="bo.page.dashboard.form.to" /></label>
                <input class="form-control"
                       name="to"
                       id="to"
                       value="<c:out value="${param.to}" />"
                       placeholder="<fmt:message key="bo.page.dashboard.form.to" />"
                        />
            </div>
            <button type="submit" class="btn btn-default"><fmt:message key="submit" /></button>
        </form>
    </div>
    <div class="row">
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['nbrUsers']}" />
                <fmt:message key="bo.page.dashboard.nbrUsers" />
            </div>
        </div>
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['nbrProjects']}" />
                <fmt:message key="bo.page.dashboard.nbrProjects" />
            </div>
        </div>
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['nbrCategories']}" />
                <fmt:message key="bo.page.dashboard.nbrCategories" />
            </div>
        </div>
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['nbrContributes']}" />
                <fmt:message key="bo.page.dashboard.nbrContributes" />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['sumNeeded']}" />
                <fmt:message key="bo.page.dashboard.sumNeeded" />
            </div>
        </div>
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['sumContributes']}" />
                <fmt:message key="bo.page.dashboard.sumContributes" />
            </div>
        </div>
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${statsGlobal['nbrProjects'] / statsGlobal['nbrCategories']}" />
                <fmt:message key="bo.page.dashboard.nbrProjectsByCategory" />
            </div>
        </div>
        <div class="col-lg-3 text-center">
            <div class="thumbnail">
                <c:out value="${func:calculatePercentage(statsGlobal['sumContributes'], statsGlobal['sumNeeded'])}" />
                <fmt:message key="bo.page.dashboard.averagePercent" />
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>