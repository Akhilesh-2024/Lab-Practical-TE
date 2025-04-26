<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Congratulations!</h1>
        <p>Welcome, <s:property value="user.name" />!</p>
        <p>You have successfully logged in with:</p>
        <ul>
            <li>Mobile: <s:property value="user.mobile" /></li>
            <li>Email: <s:property value="user.email" /></li>
        </ul>
    </div>
</body>
</html>