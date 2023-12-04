<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Edit Person</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/editPerson.js"></script>
    <style>
      .label {
        color: #000;
      }
    </style>
</head>
<body>
    <h2>Edit Person</h2>
    <s:form action="updatePerson" method="post">
        <s:hidden name="person.personId" />
        <s:textfield name="person.firstName" label="First Name"/>
        <s:textfield name="person.lastName" label="Last Name"/>
        <s:textfield name="person.sport" label="Sport"/>
        <s:textfield name="person.gender" label="Gender"/>
        <!-- Add other fields as needed -->
        <s:submit value="Update" />
        <s:submit value="Cancel" action="personAction"/>
    </s:form>

</body>
</html>
