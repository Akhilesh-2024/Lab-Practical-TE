<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
<%
String name = request.getParameter("username");
String Mobile = request.getParameter("mobile");
String Email = request.getParameter("email");
session.setAttribute("name", name);
session.setAttribute("mobile", Mobile);
session.setAttribute("email", Email);
%>
Hi!!! My name is <% out.println(session.getAttribute("name")); %><br /><br>
Mobile Number is:- <% out.println(session.getAttribute("mobile")); %><br><br>
Email id:- <% out.println(session.getAttribute("email")); %><br><br>
</body>
</html>