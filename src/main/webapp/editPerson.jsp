<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Edit Person</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/editPerson.js"></script>
</head>
<body>
    <h2>Edit Person</h2>
    <s:form action="updatePerson" method="post">
        <s:hidden name="person.personId" />
        <label for="firstName">First Name:</label>
        <s:textfield name="person.firstName" />
        <label for="lastName">Last Name:</label>
        <s:textfield name="person.lastName" />
        <label for="sport">Sport:</label>
        <s:textfield name="person.sport" />
        <label for="gender">Gender:</label>
        <s:textfield name="person.gender" />
        <!-- Add other fields as needed -->
        <s:submit value="Update" />
        <s:submit value="Cancel" action="personAction"/>
    </s:form>

</body>
</html>
