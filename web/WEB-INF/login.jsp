<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
    <form class="form-signin" action="/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" class="form-control" placeholder="Password" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>