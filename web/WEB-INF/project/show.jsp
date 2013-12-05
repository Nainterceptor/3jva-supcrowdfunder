<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 26/11/13
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>

<div class="container">
    <h1><fmt:message key="page.project.show.title" /></h1>
    <table class="table table-striped">
        <tbody>
        <tr>
            <th><fmt:message key="db.project.name" /></th>
            <td><c:out value="${project.name}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.categorie" /></th>
            <td><c:out value="${project.categories.name}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.needCredits" /></th>
            <td><c:out value="${project.needCredits}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.actualCredits" /></th>
            <td><c:out value="${actualCredits}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.details" /></th>
            <td><c:out value="${project.details}" /></td>
        </tr>
        <tr>
            <th><fmt:message key="db.project.term" /></th>
            <td><c:out value="${func:dateToStringVue(project.term)}" /></td>
        </tr>
        </tbody>
    </table>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="form">Participer au projet</h3>
        </div>
        <div class="panel-body">

            <form class="form-horizontal" action="<%=request.getContextPath()%>/me/contribute" method="get">
                </br>
                <div class="form-group <c:if test="${result != null}">${empty errors['amount'] ? 'has-success' : 'has-error'}</c:if>">
                    <label for="amount" class="col-md-2 text-left control-label "><fmt:message key="form.contribute.amount" /></label>
                    <div class="col-md-2">
                        <input type="text"
                               class="form-control"
                               id="amount"
                               name="amount"
                               required="required"
                               placeholder="<fmt:message key="form.contribute.amount.placeholder" />"
                               value="<c:out value="${param.amount}"/>"
                               maxlength="255">
                    </div>
                    <c:if test="${errors['amount'] != null}">
                        <span class="help-block"><fmt:message key="${errors['amount']}" /></span>
                    </c:if>
                    <input type="hidden"
                           class="form-control"
                           id="projectId"
                           name="projectId"
                           required="required"
                           value="<c:out value="${project.id}" />">
                </div>
                <button class="btn btn-lg btn-primary" type="submit"><fmt:message key="submit" /></button>
        </div>
        </form>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>