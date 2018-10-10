<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Address List</title>


</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2> List Of Addresses </h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Address"
               onclick="window.location.href='addressForm'; return false;"
               class="add-button"
        />

        <table>
            <tr>
                <th>Country</th>
                <th>City</th>
                <th>Street</th>
                <th>Postal Code</th>
            </tr>

            <%--@elvariable id="flights" type="java.util.List"--%>
            <c:forEach var="tempAddress" items="${addresses}">

                <%--<c:url var="updateLink" value="/customer/showFormForUpdate">--%>
                <%--<c:param name="customerId" value="${tempCustomer.id}" />--%>
                <%--</c:url>--%>

                <c:url var="deleteLink" value="/address/deleteAddress">
                <c:param name="addressId" value="${tempAddress.id}" />
                </c:url>
                <tr>
                    <td> ${tempAddress.country} </td>
                    <td> ${tempAddress.city} </td>
                    <td> ${tempAddress.street} </td>
                    <td> ${tempAddress.postalCode} </td>
                        <%--<td>--%>
                        <%--<a href="${updateLink}">Update</a>--%>
                        <%--|--%>
                    <td>
                        <a href="${deleteLink}"
                                onclick="if (!(confirm('Are you sure you want to delete this address?')))
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