<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Crewman</title>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Airport Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Airport</h3>

    <%--@elvariable id="flight" type="com.cegielskir.entity.Flight"--%>
    <form:form action="saveCrewman" modelAttribute="crewman" method="POST">

        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName" /></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email" /></td>
            </tr>

            <tr>
                <td><label>Phone number:</label></td>
                <td><form:input path="phoneNumber" /></td>
            </tr>

            <tr>

                <td><label>Role: </label></td>
                <td>
                <form:select  path="role">

                    <form:options items="${crewman.roles}" />

                </form:select>
                </td>

            </tr>

            <tr>
                <td><label>Employment date:</label></td>
                <td><form:input path="employmentDate" /></td>
            </tr>


            <tr>

                <td> Address: </td>

                <td>
                    <form:select  path="address">

                        <form:options items="${addresses}"  itemValue="id"/>

                    </form:select>
                </td>

            </tr>




            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form:form>

    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/crewman/list">Back to List</a>
    </p>

</div>
</body>
</html>