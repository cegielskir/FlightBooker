<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Airport</title>

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
    <form:form action="saveAirport" modelAttribute="airport" method="POST">

        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>Name:</label></td>
                <td><form:input path="name" /></td>
            </tr>

            <tr>
                <td><label>Country:</label></td>
                <td><form:input path="country" /></td>
            </tr>

            <tr>
                <td><label>City:</label></td>
                <td><form:input path="city" /></td>
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
        <a href="${pageContext.request.contextPath}/airport/list">Back to List</a>
    </p>

</div>
</body>
</html>