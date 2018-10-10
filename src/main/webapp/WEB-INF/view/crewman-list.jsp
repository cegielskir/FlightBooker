<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Crewman List</title>


</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2> List Of Crewmen </h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Crewman"
               onclick="window.location.href='crewmanForm'; return false;"
               class="add-button"
        />

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Role</th>
                <th>Employment Date</th>
                <th>Dismissal Date</th>
            </tr>

            <%--@elvariable id="flights" type="java.util.List"--%>
            <c:forEach var="tempCrewman" items="${crewmen}">

                <%--<c:url var="updateLink" value="/customer/showFormForUpdate">--%>
                <%--<c:param name="customerId" value="${tempCustomer.id}" />--%>
                <%--</c:url>--%>

                <c:url var="deleteLink" value="/crewman/deleteCrewman">
                <c:param name="crewmanId" value="${tempCrewman.id}" />
                </c:url>
                <tr>
                    <td> ${tempCrewman.firstName} </td>
                    <td> ${tempCrewman.lastName} </td>
                    <td> ${tempCrewman.email} </td>
                    <td> ${tempCrewman.phoneNumber} </td>
                    <td> ${tempCrewman.role} </td>
                    <td> ${tempCrewman.employmentDate} </td>
                    <td> ${tempCrewman.dismissalDate} </td>
                        <%--<td>--%>
                        <%--<a href="${updateLink}">Update</a>--%>
                        <%--|--%>
                    <td>
                        <a href="${deleteLink}"
                                onclick="if (!(confirm('Are you sure you want to delete this crewman?')))
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