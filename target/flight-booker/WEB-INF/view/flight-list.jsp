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
                    <th>Departure Time</th>
                    <th>Departure Date</th>
                    <th>Arrival Time</th>
                    <th>Arrival Date</th>
                </tr>

                <%--@elvariable id="flights" type="java.util.List"--%>
                <c:forEach var="tempFlight" items="${flights}">

                    <%--<c:url var="updateLink" value="/customer/showFormForUpdate">--%>
                        <%--<c:param name="customerId" value="${tempCustomer.id}" />--%>
                    <%--</c:url>--%>

                    <%--<c:url var="deleteLink" value="/customer/delete">--%>
                        <%--<c:param name="customerId" value="${tempCustomer.id}" />--%>
                    <%--</c:url>--%>
                    <tr>
                        <td> ${tempFlight.name} </td>
                        <td> ${tempFlight.departureTime} </td>
                        <td> ${tempFlight.departureDate} </td>
                        <td> ${tempFlight.arrivalTime} </td>
                        <td> ${tempFlight.arrivalDate} </td>

                        <%--<td>--%>
                            <%--<a href="${updateLink}">Update</a>--%>
                            <%--|--%>
                            <%--<a href="${deleteLink}"--%>
                               <%--onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>--%>
                        <%--</td>--%>
                    </tr>
                </c:forEach>
            </table>



        </div>
    </div>



</body>
</html>