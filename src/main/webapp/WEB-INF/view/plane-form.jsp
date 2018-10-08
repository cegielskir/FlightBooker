<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Plane</title>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Plane Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Plane</h3>

    <form:form action="savePlane" modelAttribute="plane" method="POST">

        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>Model:</label></td>
                <td><form:input path="model" /></td>
            </tr>

            <tr>
                <td><label>Purchase Date:</label></td>
                <td><form:input path="purchaseDate" /></td>
            </tr>

            <tr>
                <td><label>Will be used from the begining:</label></td>
                <td><form:input path="nowUsed" /></td>
            </tr>

            <tr>
                <td><label>Number of passengers:</label></td>
                <td><form:input path="passengersNumber" /></td>
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
        <a href="${pageContext.request.contextPath}/plane/list">Back to List</a>
    </p>

</div>
</body>
</html>