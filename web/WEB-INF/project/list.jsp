<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<%@taglib uri="/WEB-INF/tags/functions.tld" prefix="func" %>

<div class="container">
    <div class="col-md-2">
       <a class="btn btn-primary" href="<%=request.getContextPath()%>/me/project/add">Add a project</a>
       <div class="navbar-default">
            <ul class="nav">
            <c:forEach items="${categories}" var="c">
                <li>
                    <a href="<%=request.getContextPath()%>/project?category=<c:out value="${c.id}" />"><c:out value="${c.name}"/></a>
                </li>
            </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col-md-8">
        <div class="row">
            <c:forEach items="${projects}" var="p">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <div class="caption">
                        <h3><c:out value="${p.name}"/></h3>
                        <p><c:out value="${p.details}"/></p>
                        <p><b><fmt:message key="page.list.project.cash" /></b> <c:out value="${p.needCredits}"/></p>
                        <p>
                            <c:if test="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits) < 100}">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>%">
                                        <%--<span class="sr-only"><c:out value="${func.percentage()}"/>% Complete</span>--%>
                                        <c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>% Complete
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits) >= 100}">
                                <div class="progress progress-striped">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<c:out value="${10000/func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>" aria-valuemin="0" aria-valuemax="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>" style="width: <c:out value="${10000/func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>%"><c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>% Complete
                                    </div>
                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)-100}"/>" aria-valuemin="0" aria-valuemax="<c:out value="${func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits)}"/>" style="width: <c:out value="${100-(10000/func:calculatePercentage(func:calculateSumContibutes(p.id), p.needCredits))}"/>%"/>
                                    </div>
                                </div>
                            </c:if>
                        </p>
                        <p><a href="<%=request.getContextPath()%>/project/show?id=<c:out value="${p.id}" />" class="btn btn-primary">See</a></p>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>