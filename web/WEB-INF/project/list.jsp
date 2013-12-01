<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/includes/header.jsp"%>

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
                        <%--<p>--%>
                            <%--<c:if test="${p.percentage() < 100}">--%>
                                <%--<div class="progress">--%>
                                    <%--<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<c:out value="${p.percentage()}"/>" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${p.percentage()}"/>%">--%>
                                        <%--&lt;%&ndash;<span class="sr-only"><c:out value="${p.percentage()}"/>% Complete</span>&ndash;%&gt;--%>
                                        <%--<c:out value="${p.percentage()}"/>% Complete--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${p.percentage() >= 100}">--%>
                                <%--<div class="progress progress-striped"">--%>
                                    <%--<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<c:out value="${10000/p.percentage()}"/>" aria-valuemin="0" aria-valuemax="<c:out value="${p.percentage()}"/>" style="width: <c:out value="${10000/p.percentage()}"/>%"><c:out value="${p.percentage()}"/>% Complete--%>
                                    <%--</div>--%>
                                    <%--<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<c:out value="${p.percentage()-100}"/>" aria-valuemin="0" aria-valuemax="<c:out value="${p.percentage()}"/>" style="width: <c:out value="${100-(10000/p.percentage())}"/>%"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</c:if>--%>
                        <%--</p>--%>
                        <p><a href="<%=request.getContextPath()%>/project/show?id=<c:out value="${p.id}" />" class="btn btn-primary">See</a></p>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>