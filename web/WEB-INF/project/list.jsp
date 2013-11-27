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
       <a class="btn btn-primary" href="<%=request.getContextPath()%>/project/add">Add a project</a>
       <div class="navbar-default">
            <ul class="nav">
            <c:forEach items="${categories}" var="c">
                <li>
                    <a href="#${c.name}"><c:out value="${c.name}"/></a>
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
                        <p><a href="<%=request.getContextPath()%>/project/show?id=<c:out value="${p.id}" />" class="btn btn-primary">See</a></p>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>