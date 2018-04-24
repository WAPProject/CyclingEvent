$(function(){
    function getRootPath(){
        //get current website,ex： http://localhost:8090/jobservice/service/meun.jsp
        var curWwwPath=window.document.location.href;
        //get the path name behind domain name,ex： jobservice/service/menu.jsp
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        //get domain host,ex： http://localhost:8090
        var localhostPaht=curWwwPath.substring(0,pos);
        //get the action name,ex：/jobservice
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        return(localhostPaht+projectName);
    }
    $.ajax({
       url : "/ride",
        data : {"action": "rideusers","id":10},

        //    data : {"action": "rideusers","id":window.location.search.split("=").slice(-1)[0]},
       type : "GET",
       dataType : "json",
       success : function(result) {
           //uselist
            console.log("get the ride userlist",result)
            var tablebody = $("#ridinfousers");
          // ridinfousers
            for (var i = 0; i < result.length; i++) {
                console.log(result[i].name);
                var user = result[i];
                tablebody.append('<tr>');
                var $tr = $('<tr/>');
                $tr.append('<td>' + user.id + '</td>');
                $tr.append('<td>' + user.username +'</td>');
                $tr.append('<td>' + user.name +'</td>');
                $tr.append('<td>' + user.email +'</td>');
                $tr.append('</tr>');
                tablebody.append($tr);
            }
       }
    });
})