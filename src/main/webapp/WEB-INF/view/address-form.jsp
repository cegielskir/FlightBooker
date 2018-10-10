<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Address</title>

</head>

<body>

<%--<div id="wrapper">--%>
    <%--<div id="header">--%>
        <%--<h2>Address Manager</h2>--%>
    <%--</div>--%>
<%--</div>--%>

<div id="container">
    <h3>Save Address</h3>

    <%--@elvariable id="flight" type="com.cegielskir.entity.Flight"--%>
    <form:form action="saveAddress" modelAttribute="address" method="POST">

        <form:hidden path="id" />

        <table>
            <tbody>

            <tr>
                <td><label>Country:</label></td>
                <td><form:input path="country" /></td>
            </tr>

            <tr>
                <td><label>City:</label></td>
                <td><form:input path="city" /></td>
            </tr>

            <tr>
                <td><label>Street:</label></td>
                <td><form:input path="street" /></td>
            </tr>

            <tr>
                <td><label>Postal Code:</label></td>
                <td><form:input path="postalCode" /></td>
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
        <a href="${pageContext.request.contextPath}/address/list">Back to List</a>
    </p>

</div>
</body>
</html>