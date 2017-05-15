<jsp:include page="_header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- content-section-starts -->
<div class="content">
    <div class="container">
        <div class="login-page">
            <div class="dreamcrub">
                <ul class="breadcrumbs">
                    <li class="home">
                        <a href="/index" title="Go to Home Page">Home</a>&nbsp;
                        <span>&gt;</span>
                    </li>
                    <li class="women">
                        Login
                    </li>
                </ul>
                <ul class="previous">
                    <li><a href="/index">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="account_grid">
                <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
                    <h2>NEW ENGINEER</h2>

                    <p>By creating an account, you will be able to move through the application,
                        manage your employees, add situation day description and create quantities day
                        list and many more soon.</p>
                    <a class="acount-btn" href="/register">Create an Account</a>
                </div>
                <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                    <h3>REGISTERED ENGINEER</h3>

                    <p>If you have an account with us, please log in.</p>

                    <form name='loginForm' action="/j_spring_security_check" method='POST'>
                        <div>
                            <span>Email Address<label>*</label></span>
                            <input type="text" name="j_login">
                        </div>
                        <div>
                            <span>Password<label>*</label></span>
                            <input type="password" name="j_password">
                        </div>
                        <c:if test="${param.error ne null}">
                            <p>Wrong email or password!</p>
                        </c:if>
                        <a class="forgot" href="#">Forgot Your Password?</a>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" value="Login" onclick="emptyCart()">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- content-section-ends -->
</div>
<jsp:include page="_footer.jsp"/>