<%--
  Created by IntelliJ IDEA.
  User: xiuba
  Date: 4/23/2018
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <style>
        body {
            text-align: center;
        }
    </style>
</head>

<body>

<h2 class="alert alert-danger">Emergency flag(s) : ${fn:length(msglist)}  </h2>
<table class="table table-striped">

    <thead>
    <tr>
        <th>No.</th>
        <th>Route</th>
        <th>Paticipants</th>
    </tr>
    </thead>
    <tbody><c:forEach items="${msglist}" var="msg" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${msg.route}</td>
            <td>${msg.paticipants}</td>
        </tr>
    </c:forEach></tbody>
</table>

</body>
</html>
