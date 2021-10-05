<%--
  Created by IntelliJ IDEA.
  User: emerson
  Date: 05/10/2021
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String nomeEmpresa = (String) request.getAttribute("empresa");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>
