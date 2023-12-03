<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Person List</title>
    <!-- Include necessary CSS and JS files, e.g., Bootstrap and jQuery -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Add any other necessary stylesheets -->

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <!-- Add any other necessary scripts -->
</head>
<body>
    <div class="container mt-4">
        <h2>Person List</h2>
        <s:url var="url" action="editPerson" />
        <table class="table">
            <thead>
                <tr>
                    <th>Person ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Sport</th>
                    <th>Gender</th>
                    <th>Country</th>
                    <th>Over 21</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="persons">
                    <tr>
                        <td><s:property value="personId" /></td>
                        <td><s:property value="firstName" /></td>
                        <td><s:property value="lastName" /></td>
                        <td><s:property value="sport" /></td>
                        <td><s:property value="gender" /></td>
                        <td><s:property value="country.countryName" /></td>
                        <td><s:property value="over21" /></td>
                        <td><s:property value="email" /></td>
                        <td><s:property value="phoneNumber" /></td>
                        <td><s:url action="editPerson" var="url"><s:param name="personId" value="personId"/></s:url><a href="<s:property value="#url"/>">Edit</a></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>

    <!-- Add any other HTML elements or scripts as needed -->
</body>
</html>
