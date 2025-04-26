<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="css/style.css">
    <s:head/>
</head>
<body>
    <div class="container">
        <h1>User Login</h1>
        
        <s:form action="login" method="post">
            <s:textfield name="user.name" label="Name" />
            <s:textfield name="user.mobile" label="Mobile Number" />
            <s:textfield name="user.email" label="Email ID" />
            <s:submit value="Login" cssClass="btn" />
        </s:form>
    </div>
</body>
</html>