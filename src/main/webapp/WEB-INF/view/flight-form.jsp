<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Flight</title>
    <style>
        .error {color:red}
    </style>

</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2>Flight Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Flight</h3>

        <%--@elvariable id="flight" type="com.cegielskir.entity.Flight"--%>
        <form:form action="saveFlight" modelAttribute="flight" method="POST">

            <form:hidden path="id" />

            <table>
                <tbody>
                <tr>
                    <td><label>Name:</label></td>
                    <td><form:input path="name" /></td>
                    <td><form:errors path="name" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><label>Departure Time:</label></td>
                    <td><form:input path="departureTime" /></td>
                    <td><form:errors path="departureTime" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><label>Departure Date:</label></td>
                    <td><form:input path="departureDate" /></td>
                    <td><form:errors path="departureDate" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><label>Arrival Time:</label></td>
                    <td><form:input path="arrivalTime" /></td>
                    <td><form:errors path="arrivalTime" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><label>Arrival Date:</label></td>
                    <td><form:input path="arrivalDate" /></td>
                    <td><form:errors path="arrivalDate" cssClass="error" /></td>
                </tr>

                <br>

                From Airport:

                <form:select  path="fromAirport">

                    <form:options items="${airports}"  itemValue="id"/>

                </form:select>

                <br>
                <br>

                To Airport:

                <form:select  path="toAirport">

                    <form:options items="${airports}"  itemValue="id"/>

                </form:select>

                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear; both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/flight/list">Back to List</a>
        </p>

    </div>
</body>
</html>