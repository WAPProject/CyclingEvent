$(function(){
    function getRootPath(){
        //获取当前网址，如： http://localhost:8090/jobservice/service/meun.jsp
        var curWwwPath=window.document.location.href;
        //获取主机地址之后的目录，如： jobservice/service/menu.jsp
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8090
        var localhostPaht=curWwwPath.substring(0,pos);
        //获取带"/"的项目名，如：/jobservice
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        return(localhostPaht+projectName);
    }

    //
    $(".notstart").hide();
    $(".inprocessing").show();
    $(".flag").hide();


    $(".OutgoingBtn").click(function(){
        $(".notstart").hide();
        $(".flag").hide();
        $(".inprocessing").show();
    });

    $(".UpcommingBtn").click(function(){
        $(".notstart").show();
        $(".inprocessing").hide();
        $(".flag").hide();
    });

    $(".FlagBtn").click(function(){
        $(".notstart").hide();
        $(".inprocessing").hide();
        $(".flag").show();
    });



    $("#start").click(function(){
        const id = $(this).attr("rideId");
        window.location.href=getRootPath()+"/ride?action=start&id="+id;
        //$.ajax({
        //    url : "<%=path%>/ride",
        //    data : {"action": "start","id":id},
        //    type : "POST",
        //    dataType : "json",
        //    success : function(result) {
        //
        //    }
        //});
    });

    $("#join").click(function(){
        const id = $(this).attr("rideId");
        window.location.href=getRootPath()+"/ride?action=join&id="+id;
    });

    $("#pause").click(function(){
        const id = $(this).attr("rideId");
        window.location.href=getRootPath()+"/ride?action=flag&id="+id;
    });

    $("#resume").click(function(){
        const id = $(this).attr("rideId");
        window.location.href=getRootPath()+"/ride?action=unflag&id="+id;
    });

    $("#endRide").click(function(){
        const id = $(this).attr("rideId");
        window.location.href=getRootPath()+"/ride?action=end&id="+id;
    });


    setInterval(function(){
        $.get(getRootPath()+'/ride?action=message').done(function(o){
            console.log(o);
            let obj = JSON.parse(o);
            console.log(typeof obj);
            let msgArray = o.msglist;
            $('#envelope').html(msgArray.length);
        })

    },20000);

})