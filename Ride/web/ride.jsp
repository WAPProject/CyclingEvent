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
            <label >route name
                <input name="route" class="input" type="text"  required="true" placeholder="Ride name">
            </label>
        </div>
        <div class="item">
            <label >begindate
                <input name="begindate" class="input"  type = "date" required="true"  />
            </label>
        </div>

        <div class="item">
            <label >cover image
                <input  type="text"  name="banner"  required="true" >
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
<%--<script src="js/bootstrap-table.js"></script>--%>
<%--<script src="js/bootstrap-datetimepicker.min.js"></script>--%>
<script src="js/vue.js"></script>
<script src="js/app.js"></script>
<script src="js/ajaxfileupload.js"></script>
<script src="js/ride.js"></script>
</body>
</html>
