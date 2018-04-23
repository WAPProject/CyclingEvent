<%--
  Created by IntelliJ IDEA.
  User: xiuba
  Date: 4/23/2018
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Ride Info</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/ride-homepage.css" rel="stylesheet">
</head>

<body>
<h2>${fn:length(userList)} paticipants</h2>
<ol>
<c:forEach items="${userList}" var="user">
    <li>Name:${user.name} Email:${user.email}</li>
</c:forEach>
</ol>
</body>
</html>
