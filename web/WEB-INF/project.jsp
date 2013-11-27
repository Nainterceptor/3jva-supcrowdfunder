<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-2">
           <a class="btn btn-primary" href="<%=request.getContextPath()%>/addProject">Add a project</a>
           <div class="navbar-default">
                <ul class="nav">
                    <li>
                        <a href="#Test">Test</a>
                    </li>
                    <li>
                        <a href="#Test">Test</a>
                    </li>
                    <li>
                        <a href="#Test">Test</a>
                    </li>
                    <li>
                        <a href="#Test">Test</a>
                    </li>
                    <li>
                        <a href="#Test">Test</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-8">
            <c:forEach items="${projects}" var="p">
            <div class="col-md-4">
                <div class="thumbnail">
                    <div class="caption">
                        <h3><c:out value="${p.name}"/></h3>
                        <p><c:out value="${p.details}"/></p>
                        <a class="btn btn-primary">See</a>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>