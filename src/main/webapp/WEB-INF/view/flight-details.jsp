<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Flight Details</title>


</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2> Details of flight </h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

            <table>
                <tbody>
                <tr>
                    <td><label>Name:</label></td>
                    <td>${flight.name}</td>
                </tr>

                <tr>
                    <td><label>Departure Time:</label></td>
                    <td>${flight.departureTime}</td>
                </tr>

                <tr>
                    <td><label>Departure Date:</label></td>
                    <td>${flight.departureDate}</td>
                </tr>

                <tr>
                    <td><label>Arrival Time:</label></td>
                    <td>${flight.arrivalTime}</td>
                </tr>

                <tr>
                    <td><label>Arrival Date:</label></td>
                    <td>${flight.arrivalTime}</td>
                </tr>

                <tr>
                    <td> From Airport: </td>
                    <td>${flight.fromAirport}</td>
                </tr>
                <tr>
                    <td> To Airport: </td>
                    <td>${flight.toAirport}</td>

                </tr>

                <tr>
                    <td> Plane: </td>
                    <td>${flightDetails.plane}</td>
                </tr>

                <tr><td>Crewmen: </td></tr>
                <c:forEach var="crewman" items="${flightDetails.crewmen}">
                    <tr>
                        <td>${crewman}</td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>

    <br><br>
    <a href="/"> Back to main menu</a>



</body>
</html>