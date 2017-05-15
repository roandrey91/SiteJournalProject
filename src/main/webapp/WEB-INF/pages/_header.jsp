
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        function postToDbCart() {
            document.activeElement.parentElement.submit();
        }

        function postToDbCart2() {
            document.activeElement.parentElement.parentElement.submit();
        }
        function emptyCart() {
            document.getElementById("emptyCart").click();
        }
        function emptyCartOnSessionOrderDelete(sessionOrderId, orderToDelId) {
            if (sessionOrderId == orderToDelId) {
                emptyCart();
            }
        }
    </script>
    <title>Site Journal Bootstrap Responsive Website Template | w3layouts</title>
    <link href="../css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../css/component.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Site Journal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <%--<script type="application/x-javascript"> addEventListener("load", function () {--%>
        <%--setTimeout(hideURLbar, 0);--%>
    <%--}, false);--%>
    <%--function hideURLbar() {--%>
        <%--window.scrollTo(0, 1);--%>
    <%--} </script>--%>
    <!--webfont-->
    <!-- for bootstrap working -->
    <script type="text/javascript" src="../js/bootstrap-3.1.1.min.js"></script>
    <!-- //for bootstrap working -->
    <!-- cart -->
    <script src="../js/simpleCart.min.js"></script>
    <!-- cart -->
    <link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="screen"/>
</head>
<body>
<!-- header-section-starts -->
<div class="header">
    <div class="header-top-strip">
        <div class="container">
            <div class="header-top-left">
                <ul>
                    <sec:authorize access="isAnonymous()">
                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"> </span>Login</a></li>
                        <li><a href="/register"><span class="glyphicon glyphicon-log-out"> </span>Create an Account</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li>
                            <a href="/account"><span class="glyphicon glyphicon-user"> </span>
                                <sec:authentication property="principal.username"/></a>
                        </li>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li>
                                <a href="/admin"><span class="glyphicon glyphicon-lock"> </span>Admin</a>
                            </li>
                        </sec:authorize>
                        <li>
                            <form action="/checkout/empty" method="post">
                                <a href="/logout" onclick="emptyCart()">
                                    <span class="glyphicon glyphicon-log-out"> </span>
                                    Logout
                                </a>
                            </form>
                        </li>
                    </sec:authorize>
                </ul>
            </div>

            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- header-section-ends -->
<div class="inner-banner">
    <div class="container">
        <div class="banner-top inner-head">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="logo">
                        <h1><a href="/index"><span>Si</span> te-Journal</a></h1>
                    </div>
                </div>
                <!--/.navbar-header-->

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/index">HOME</a></li>
                        <li><a href="/employees">EMPLOYEES</a></li>
                        <li><a href="/situation">DAY SITUATION</a></li>
                        <li><a href="/dayquantities">QUANTITIES DAY LIST</a></li>
                        <li><a href="/projectinfo">PROJECT INFORMATION</a></li>
                    </ul>
                </div>
                <!--/.navbar-collapse-->
            </nav>
            <!--/.navbar-->
        </div>
    </div>
</div>