<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2017/4/1 0001
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">


    <title>Ride Website</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/ride-homepage.css" rel="stylesheet">

</head>

<body>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    模态框（Modal）标题
                </h4>
            </div>
            <div class="modal-body">
                在这里添加一些文本
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<!-- Navigation -->
<%----%>
<%--bigdragon--%>
<%----%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="ride?action=create">Create a ride</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
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

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">

            <h1 class="my-4"></h1>
            <div class="list-group">
                <a href="#" class="list-group-item OutgoingBtn" >Ongoing</a>
                <a href="#" class="list-group-item FlagBtn">Flag</a>
                <a href="#" class="list-group-item UpcommingBtn">Upcomming</a>
            </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <div class="row">
                <c:forEach varStatus="status" items="${notstart}" var="ride" >
                    <div class="col-lg-4 col-md-6 mb-4 notstart">
                        <div class="card h-100">
                            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">Ride ${status.count}</a>
                                </h4>
                                <h5><a href="${pageContext.request.contextPath}/ride?action=listpaticipants&id=${ride.id}" target="_blank">See Members</a></h5>
                                <p class="card-text">${ride.route}</p>
                            </div>
                            <div class="card-footer">
                                <button type="button"  class="btn btn-warning " rideId="${ride.id}" id="join">join</button>
                                <c:if test="${ride.creatorUserId eq currentuserid}">
                                <button type="button"  class="btn btn-success " rideId="${ride.id}" id="start">Start</button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>


            <c:forEach var="ride"  items="${inprocessing}" varStatus="status">
                <div class="col-lg-4 col-md-6 mb-4 inprocessing">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Ride ${status.count}</a>
                            </h4>
                            <h5><a href="${pageContext.request.contextPath}/ride?action=listpaticipants&id=${ride.id}" target="_blank">See Members</a></h5>
                            <p class="card-text">${ride.route}</p>
                        </div>
                        <div class="card-footer">
                            <button type="button"  class="btn btn-default " rideId="${ride.id}"  id="join" >Join</button>
                            <%--<button type="button"  class="btn btn-danger " rideId="${ride.id}"  id="pause" data-toggle="modal" data-target="#myModal" >Pause</button>--%>
                            <button type="button"  class="btn btn-danger " rideId="${ride.id}"  id="pause"  >Pause</button>
                            <button type="button"  class="btn btn-warning" id="endRide"   rideId="${ride.id}" >End</button>
                            <%--<button type="button"  class="btn btn-success " >Start</button>--%>
                        </div>
                    </div>
                </div>
            </c:forEach>

                <c:forEach var="fride"  items="${flag}" varStatus="status">


                    <div class="col-lg-4 col-md-6 mb-4 flag">
                        <div class="card h-100">
                            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">${status.count}</a>
                                </h4>
                                <h5><a href="${pageContext.request.contextPath}/ride?action=listpaticipants&id=${ride.id}" target="_blank">See Members</a></h5>
                                <p class="card-text">${ride.route}</p>
                            </div>
                            <div class="card-footer">
                                    <%--<button type="button"  class="btn btn-default " >Join</button>--%>
                                    <%--<button type="button"  class="btn btn-danger " data-toggle="modal" data-target="#myModal" >Pause</button>--%>
                                    <button type="button"  class="btn btn-warning " id="resume" rideId="${fride.id}" >Resume</button>
                                <%--<button type="button"  class="btn btn-success " id="start" rideId="${fride.id}" >Start</button>--%>
                            </div>
                        </div>
                    </div>
                </c:forEach>



            </div>
            <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy;  MUM 2018</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="js/homepage.js"></script>
</body>

</html>
