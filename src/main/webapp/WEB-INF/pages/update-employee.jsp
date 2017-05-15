
<jsp:include page="_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="registration-form">
    <div class="container">
        <div class="dreamcrub">
            <ul class="breadcrumbs">
                <li class="home">
                    <a href="/index" title="Go to Home Page">Home</a>&nbsp;
                    <span>&gt;</span>
                </li>
                <li class="women">
                    Employee
                </li>
            </ul>
            <ul class="previous">
                <li><a href="/index">Back to Previous Page</a></li>
            </ul>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<h2>Employee information</h2>
<h3>Edit formular</h3>


<%--adding employee form--%>

<div class="registration-grids">
    <div class="reg-form">
        <div class="reg">

            <jsp:useBean id="existingEmployee" class="com.sitejournal.data.Employee" scope="request"/>
            <form:form method="post" action="/editEmployee" modelAttribute="existingEmployee">
                <form:hidden path="id"/>
                <ul>
                    <li class="text-info">First Name:</li>
                    <li><input type="text" name="firstName" value="${existingEmployee.firstName}" required></li>
                </ul>
                <ul>
                    <li class="text-info">Last Name:</li>
                    <li><input type="text" name="lastName" value="${existingEmployee.lastName}" required></li>
                </ul>
                <ul>
                    <li class="text-info">Email:</li>
                    <li><input type="text" name="email" value="${existingEmployee.email}" required></li>
                </ul>
                <ul>
                    <li class="text-info">Job:</li>
                    <li><input type="text" name="job" value="${existingEmployee.job}" required></li>
                </ul>
                <ul>
                    <li class="text-info">Birth date:</li>
                    <li><input type="date" value="${existingEmployee.birthDate}" required></li>
                </ul>
                <ul>
                    <li class="text-info">Salary</li>
                    <li><input type="text" name="salary" value="${existingEmployee.salary}" required></li>
                </ul>

                <input type="submit" value="Edit">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            </form:form>


            <%--<c:if test="${error != null}">--%>
            <%--<p style="color: darkred">Cannot register following email. Please enter another one.</p>--%>
            <%--</c:if>--%>
        </div>
    </div>



    <div class="reg-right">

        <h3>Edit employee</h3>
        <img src="../images/Employees2.jpg" style="border-image-width: 21%" alt=""/>
    </div>

</div>
</div>
</div>


<jsp:include page="_footer.jsp"/>