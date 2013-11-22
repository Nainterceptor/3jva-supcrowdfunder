<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container">
    <div class="row">
        <form role="form" action="/registration" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>