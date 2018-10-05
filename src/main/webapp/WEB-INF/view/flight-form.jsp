<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Flight</title>

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
                </tr>

                <tr>
                    <td><label>Departure Time:</label></td>
                    <td><form:input path="departureTime" /></td>
                    <form:errors path="departureTime" cssClass="error" />
                </tr>

                <tr>
                    <td><label>Departure Date:</label></td>
                    <td><form:input path="departureDate" /></td>
                    <form:errors path="departureDate" cssClass="error" />
                </tr>

                <tr>
                    <td><label>Arrival Time:</label></td>
                    <td><form:input path="arrivalTime" /></td>
                    <form:errors path="arrivalTime" cssClass="error" />
                </tr>

                <tr>
                    <td><label>Arrival Date:</label></td>
                    <td><form:input path="arrivalDate" /></td>
                    <form:errors path="arrivalDate" cssClass="error" />
                </tr>

                <br>

                From Airport:

                <form:select  path="fromAirport">

                    <form:options items="${airports}" />

                </form:select>

                <br>
                <br>

                To Airport:

                <form:select  path="toAirport">

                    <form:options items="${airports}" />

                </form:select>

                <br>

                <form:errors path="name" />

                <tr>
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