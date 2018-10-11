<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Flight List</title>


</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2> List Of Flights </h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

            <input type="button" value="Add Flight"
                   onclick="window.location.href='flightForm'; return false;"
                   class="add-button"
            />

            <table>
                <tr>
                    <th>Name</th>
                    <th>Departure Date</th>
                    <th>Arrival Date</th>
                </tr>

                <%--@elvariable id="flights" type="java.util.List"--%>
                <c:forEach var="tempFlight" items="${flights}">

                    <c:url var="updateLink" value="/flight/showFormForUpdate">
                        <c:param name="flightId" value="${tempFlight.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/flight/deleteFlight">
                        <c:param name="flightId" value="${tempFlight.id}" />
                    </c:url>


                    <tr>
                        <td> ${tempFlight.name} </td>
                        <td> ${tempFlight.departureDate} </td>
                        <td> ${tempFlight.arrivalDate} </td>

                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this flight?')))
                                   return false;">Delete</a>
                            |
                            <c:if test="${tempFlight.flightDetails == null}">
                                <a href='/flight/setDetails/${tempFlight.id}'>Set Details</a>
                            </c:if>
                            <c:if test="${tempFlight.flightDetails != null}">
                                <a href='/flight/showDetails/${tempFlight.id}'>Show Details</a>
                            </c:if>

                        </td>
                    </tr>
                </c:forEach>
            </table>



        </div>
    </div>

    <br><br>
    <a href="/"> Back to main menu</a>



</body>
</html>