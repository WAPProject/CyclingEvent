<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2017/4/1 0001
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<div id="app" >
    <form class="login-container" action="${pageContext.request.contextPath}/user?action=login" method="post">
        <h3 class="title">Login</h3>
        <div class="item">
            <label >
                <input name="username" class="input" type="text"  placeholder="User name">
            </label>
        </div>
        <div class="item">
            <label >
                <input name="password" class="input" type="password"  placeholder="密码">
            </label>
        </div>
        <div class="item">
            <label >
                <input class="submit"  type="submit" value="Login">
            </label>
        </div>
        <div class="item">
            <label >
                <span class="reglink">Dont' have a account? <a href="register.jsp" class="link">Sign up</a> </span>
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
