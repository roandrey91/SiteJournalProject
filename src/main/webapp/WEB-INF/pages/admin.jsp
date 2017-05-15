<jsp:include page="_header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- registration-form -->
<div class="registration-form">
    <div class="container">
        <div class="dreamcrub">
            <ul class="breadcrumbs">
                <li class="home">
                    <a href="/index" title="Go to Home Page">Home</a>&nbsp;
                    <span>&gt;</span>
                </li>
                <li class="women">
                    Admin Page
                </li>
            </ul>
            <div class="clearfix"></div>
        </div>


        <h2>Add books to server</h2>

        <div class="registration-grids">
            <div class="reg-form">
                <div class="reg">

                    <div class="reg-form-right">


                        <c:if test="${numAccountsDeleted != null}">
                            <p>Accounts deleted: ${numAccountsDeleted}</p>
                        </c:if>
                        <div class="reg">
                            <form action="/admin/dropAccounts" method="post">
                                <input type="submit" value="Delete All Accounts">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <div class="strip"></div>
                        </div>

                        <p>Inspect User Account</p>

                        <div class="reg">
                            <form action="/admin/account" method="get">
                                <ul>
                                    <li class="text-info">User Email:</li>
                                    <li><input type="text" name="userEmail" value="" required></li>
                                </ul>
                                <input type="submit" value="Find">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <div class="strip"></div>
                        </div>


                    </div>
                    <div class="strip"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- registration-form -->
</div>
<jsp:include page="_footer.jsp"/>