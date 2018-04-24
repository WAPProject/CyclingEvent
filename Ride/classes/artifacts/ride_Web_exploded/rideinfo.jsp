<%@ page import="com.cs.entity.Ride" %><%--
  Created by IntelliJ IDEA.
  User: xiuba
  Date: 4/23/2018
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
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

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div id="app" >
        <h3 class="title">Ride Infomation</h3>

        <div class="item">
            <label >
                <span >Route: <%= request.getAttribute("route")%></span>
            </label>
        </div>
        <div class="item">
            <label >
                <span >Status: <%= request.getAttribute("status")%></span>
            </label>
        </div>
        <div class="item">
            <label >
                <span >CurrentLocation: <%= request.getAttribute("location")%></span>
            </label>
        </div>
        <div class="item">
            <label >
                <span >BeginDate: <%= request.getAttribute("begindate")%></span>
            </label>
        </div>
    </div>
</div>

<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy;  MUM 2018</p>
    </div>
</footer>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/vue.js"></script>
<script src="js/app.js"></script>

</body>
</html>
