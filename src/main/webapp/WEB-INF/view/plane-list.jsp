<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Plane List</title>


</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2> List Of Planes </h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Plane"
               onclick="window.location.href='planeForm'; return false;"
               class="add-button"
        />

        <table>
            <tr>
                <th>Model</th>
                <th>Purchase Date</th>
                <th>Number Of Passengers</th>
                <th>Now used</th>
            </tr>

            <%--@elvariable id="flights" type="java.util.List"--%>
            <c:forEach var="tempPlane" items="${planes}">

                <c:url var="updateLink" value="/plane/showFormForUpdate">
                    <c:param name="planeId" value="${tempPlane.id}" />
                </c:url>

                <c:url var="deleteLink" value="/plane/deleteFlight">
                    <c:param name="planeId" value="${tempPlane.id}" />
                </c:url>
                <tr>
                    <td> ${tempPlane.model} </td>
                    <td> ${tempPlane.purchaseDate} </td>
                    <td> ${tempPlane.passengersNumber} </td
                    <td> ${tempPlane.nowUsed} </td>


                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this plane?')))
                                   return false;">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>



    </div>
</div>



</body>
</html>