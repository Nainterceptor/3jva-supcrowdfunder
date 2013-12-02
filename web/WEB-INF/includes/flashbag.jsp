<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:if test="${flashbag != null && flashbag.hasFlashs()}">
    <div class="container">
        <c:forEach var="f" items="${flashbag.getFlashs().entrySet()}">
            <c:forEach var="m" items="${flashbag.getOnceFlash(f.key)}">
                <div class="alert alert-<c:out value="${f.key}" /> alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <fmt:message key="${m}" />
    </div>
    </c:forEach>
    </c:forEach>
    </div>
</c:if>

