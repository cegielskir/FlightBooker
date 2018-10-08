<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Airport List</title>


</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2> List Of Airports </h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Airport"
               onclick="window.location.href='airportForm'; return false;"
               class="add-button"
        />

        <table>
            <tr>
                <th>Name</th>
                <th>Country</th>
                <th>City</th>
            </tr>

            <%--@elvariable id="flights" type="java.util.List"--%>
            <c:forEach var="tempAirport" items="${airports}">

                <%--<c:url var="updateLink" value="/customer/showFormForUpdate">--%>
                <%--<c:param name="customerId" value="${tempCustomer.id}" />--%>
                <%--</c:url>--%>

                <c:url var="deleteLink" value="/airport/deleteAirport">
                <c:param name="airportId" value="${tempAirport.id}" />
                </c:url>
                <tr>
                    <td> ${tempAirport.name} </td>
                    <td> ${tempAirport.country} </td>
                    <td> ${tempAirport.city} </td>
                        <%--<td>--%>
                        <%--<a href="${updateLink}">Update</a>--%>
                        <%--|--%>
                    <td>
                        <a href="${deleteLink}"
                                onclick="if (!(confirm('Are you sure you want to delete this airport?')))
                                    return false;">Delete</a>
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