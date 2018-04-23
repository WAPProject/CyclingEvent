<%--
  Created by IntelliJ IDEA.
  User: xiuba
  Date: 4/22/2018
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="app" >
    <form class="login-container" action="user?action=add" method="post">
        <h3 class="title">Register</h3>
        <div class="item">
            <label >
                <input name="username" class="input" type="text"  placeholder="User name">
            </label>
        </div>
        <div class="item">
            <label >
                <input name="emailaddress" class="input" type="text"  placeholder="Email address">
            </label>
        </div>
        <div class="item">
            <label >
                <input name="password" class="input" type="password"  placeholder="Password">
            </label>
        </div>
        <div class="item">
            <label >
                <input class="submit"  type="submit" value="Register">
            </label>
        </div>
    </form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/vue.js"></script>
<script src="js/app.js"></script>
</body>
</html>
