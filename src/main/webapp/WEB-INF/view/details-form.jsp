<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Details</title>
    <style>
        .error {color:red}
    </style>

</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2>Details Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Details</h3>

        <form:form action="/flight/saveDetails/${flight.id}" modelAttribute="details" method="POST">

            <form:hidden path="id" />

            <table>
                <tbody>
                <tr>

                    <td> Plane: </td>

                    <td>
                        <form:select  path="plane">

                            <form:options items="${planes}"  itemValue="id"/>

                        </form:select>
                    </td>
                    <%--<c:if test="${not empty error}">--%>
                        <%--<td class="error"> ${error} </td>--%>
                    <%--</c:if>--%>

                </tr>
                        <%--<td><label>Crewmen: </label></td>--%>
                        <%--<td>--%>
                        <%--<form:select path="crewmen" multiple="true" size="10" cssStyle="width: 275px" >--%>
                            <%--<form:options items="${crewmen}"  itemValue="id" />--%>
                        <%--</form:select>--%>
                        <%--</td>--%>
                    <tr><td> Crewmen: </td></tr>
                    <tr><td><form:checkboxes element="li" items="${crewmen}" path="crewmen" /></td></tr>


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