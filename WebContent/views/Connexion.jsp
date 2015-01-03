
<%@ include file="_header.jsp"%>

<style>
.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
    margin-left:20px;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}
</style>


<div class="container">
    <div class="row">
	<div class="box">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center"><fmt:message key="general.signin" /></h1>
                <img class="img-circle center-block" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                <form class="form-signin" role="form" method="post" action="<c:url value="/Connexion"/>">
                <c:if test="${requestScope['error']}">
	                <div class="alert alert-danger alert-dismissible" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  <strong>Oh snap!</strong> <c:out value="${requestScope['error']}"/>
					</div>
				</c:if>
                
                <input name="pseudoUser" type="text" class="form-control" placeholder="<fmt:message key="connection.pseudo" />" required autofocus>
                <input name="password" type="password" class="form-control" placeholder="<fmt:message key="register.password" />" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    <fmt:message key="general.signin" /></button>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    <fmt:message key="connection.remember" />
                </label>
                <span class="clearfix"></span>
                </form>
            <a href="<c:url value="/Inscription"/>" class="text-center new-account"><fmt:message key="connection.account" /></a>
        </div>
    </div>
</div>
</div>

<%@ include file="_footer.jsp"%>