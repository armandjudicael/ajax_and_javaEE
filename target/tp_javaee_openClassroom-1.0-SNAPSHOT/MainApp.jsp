<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Tombo Augustin
  Date: 09/04/2022
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>i-Jerry</title>
</head>
<body>
<%
    User connectedUser = (User)request.getAttribute("connectedUser");
%>
<p> Bonjour Monsier <%=connectedUser.toString()%></p>
</body>
</html>
