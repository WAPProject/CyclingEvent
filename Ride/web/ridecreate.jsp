<%--
  Created by IntelliJ IDEA.
  User: xiuba
  Date: 4/24/2018
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create ride</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<div id="app" >
    <%--enctype="multipart/form-data"--%>
    <form class="login-container" action="ride?action=add" method="post" >
        <h3 class="title">Create Ride</h3>
        <div class="item">
            <label >Route name
                <input name="route" class="input" type="text"  placeholder="Route name">
            </label>
        </div>
        <div class="item">
            <label >Begindate
                <input type="date"  name="begindate" required="required"/>
            </label>
        </div>
        <div class="item">
            <label >Cover image
                <input  type="text"  name="banner" placeholder="Cover image url" >
            </label>
        </div>
        <div class="item">
            <label >
                <input class="submit"  type="submit" value="Create">
            </label>
        </div>

    </form>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/vue.js"></script>
<script src="js/app.js"></script>
<script src="js/ajaxfileupload.js"></script>
<script src="js/ridecreate.js"></script>
</body>
</html>