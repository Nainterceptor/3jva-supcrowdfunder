<%--
  Created by IntelliJ IDEA.
  User: Romain Letrémy
  Date: 26/11/13
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/includes/headerBO.jsp"%>
<div class="container">
    <h1><fmt:message key="bo.page.categorie.edit.title" /></h1>

    <c:if test="${errors['internal'] != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <fmt:message key="${errors['internal']}" />
        </div>
    </c:if>
    <div class="row">
        <form role="form" action="${originURL}" method="post">
            <div class="form-group <c:if test="${result != null}">${empty errors['name'] ? 'has-success' : 'has-error'}</c:if>">
                <label class="control-label" for="name"><fmt:message key="bo.page.categorie.edit.form.name" /></label>
                <input type="text"
                       class="form-control"
                       id="name"
                       name="name"
                       required="required"
                       value="<c:out value="${categorie.name}"/>"
                       maxlength="255">
                <c:if test="${errors['name'] != null}">
                    <span class="help-block"><fmt:message key="${errors['name']}" /></span>
                </c:if>
            </div>

            <button type="submit" class="btn btn-default"><fmt:message key="bo.page.categorie.edit.form.editer" /></button>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>