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
    <h1><c:out value="${project.name}" /> <small><c:out value="${project.categories.name}" /></small></h1>
    <div class="row">
        <div class="col-lg-6">
            <table class="table table-striped">
                <tbody>
                <tr>
                    <th><fmt:message key="db.project.needCredits" /></th>
                    <td><c:out value="${project.needCredits}" /></td>
                </tr>
                <tr>
                    <th><fmt:message key="db.project.actualCredits" /></th>
                    <td><c:out value="${actualCredits}" /></td>
                </tr>
                <tr>
                    <th><fmt:message key="db.project.createdAt" /></th>
                    <td><c:out value="${func:dateToStringVue(project.createdAt)}" /></td>
                </tr>
                <tr>
                    <th><fmt:message key="db.project.term" /></th>
                    <td><c:out value="${func:dateToStringVue(project.term)}" /></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="form"><fmt:message key="page.show.project.participate" /></h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" action="<%=request.getContextPath()%>/me/contribute" method="get">
                        <div class="form-group <c:if test="${result != null}">${empty errors['amount'] ? 'has-success' : 'has-error'}</c:if>">
                            <label for="amount" class="col-md-3 text-left control-label "><fmt:message key="form.contribute.amount" /></label>
                            <div class="col-md-5 input-group">
                                <span class="input-group-addon">$</span>
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
                            <div class="col-md-4">
                                <button class="btn btn-primary" type="submit"><fmt:message key="submit" /></button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
    <div>
        <c:if test="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits) < 100}">
            <div class="progress">
                <div class="progress-bar progress-bar-info"
                     role="progressbar"
                     aria-valuenow="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>"
                     aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>%">
                    <c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>% <fmt:message key="page.list.project.progressbar" />
                </div>
            </div>
        </c:if>
        <c:if test="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits) >= 100}">
        <div class="progress progress-striped">
            <div class="progress-bar progress-bar-success" role="progressbar"
                 aria-valuenow="<c:out value="${10000/func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>"
                 aria-valuemin="0"
                 aria-valuemax="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>"
                 style="width: <c:out value="${10000/func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>%">
                <c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>% <fmt:message key="page.list.project.progressbar" />
            </div>
            <div class="progress-bar progress-bar-info"
                 role="progressbar"
                 aria-valuenow="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)-100}"/>"
                 aria-valuemin="0"
                 aria-valuemax="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits)}"/>"
                 style="width: <c:out value="${100-(10000/func:calculatePercentage(func:calculateSumContibutes(project.id), project.needCredits))}"/>%"></div>
        </div>
    </c:if>
    </div>
    <p><c:out value="${project.details}" /></p>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>