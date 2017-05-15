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


<%--adding employee form--%>

            <div class="container-fluid">
                <div class="row">

                    <div class="col-md-12">
                        <div class="">
                            <a  class="btn btn-primary" href="/employee" style="margin-left:50%;">Add Employee</a>
                        </div>
                        <div class="table-responsive">

                            <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                                <thead>
                                <th>Id</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Birthday</th>
                                <th>Job</th>
                                <th>Email</th>
                                <th>Salary</th>
                                <th>Edit / Delete</th>
                                </thead>
                                <tbody>
                                <c:forEach var="employee" items="${employees}">
                                    <tr>
                                        <td>${employee.id}</td>
                                        <td>${employee.firstName}</td>
                                        <td>${employee.lastName}</td>
                                        <td>${employee.birthDate}</td>
                                        <td>${employee.job}</td>
                                        <td>${employee.email}</td>
                                        <td>${employee.salary}</td>

                                        <td>
                                            <a  class="btn btn-primary" href="editEmployee?id=${employee.id}">Edit</a>
                                            <a  class="btn btn-warning" href="deleteEmployee/${employee.id}">Delete</a>
                                            <%--<form action="/editEmployee/${employee.id}" method="get">--%>
                                                <%--<input type="submit" name="Edit">--%>
                                            <%--</form>--%>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <%--<form action="/employee" method="get">--%>
                <%--<input type="submit" name="Edit"/>--%>
                <%--Edit--%>
            <%--</form>--%>

