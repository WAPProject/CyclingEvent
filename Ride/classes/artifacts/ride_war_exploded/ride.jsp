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
    <title>Create a ride event</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<div id="app" >
    <form class="login-container" action="ride?action=add" method="post">
        <h3 class="title">Create Ride</h3>
        <div class="item">
            <label >route
                <input name="route" class="input" type="text"  placeholder="route">
                <%--<textarea class="input" name="route" id="route" cols="30" rows="10"></textarea>--%>
            </label>
        </div>
        <div class="item">
            <label >begindate
                <input name="begindate" type="date" class="input"  />
            </label>
        </div>

        <div class="item">
            <label >cover image
                <input   type="file" value="Login">
            </label>
        </div>
        <div class="item">
            <label >
                <input class="submit"  type="submit" value="Create">
            </label>
        </div>

    </form>
</div>
<script>


$('#testDate').datetimepicker({
sideBySide: true //可以同时选择日期和时间
});
$('#testDate').data('DateTimePicker').format('YYYY-MM-DD HH:mm'); //格式化日期显式格式
$('#testDate').data('DateTimePicker').date(moment()); //设置控件时间
</script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/vue.js"></script>
<script src="js/app.js"></script>
</body>
</html>
