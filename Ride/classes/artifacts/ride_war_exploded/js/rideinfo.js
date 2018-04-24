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
       url : "<%=path%>/ride",
       data : {"action": "start","id":id},
       type : "GET",
       dataType : "json",
       success : function(result) {
            console.log("get the ride userlist")

           //
           //  <thead>
           //  <tr>
           //  <th>No.</th>
           //  <th>Name</th>
           //  <th>UserName</th>
           //  <th>Email</th>
           //  </tr>
           //  </thead>
           //  <tbody><c:forEach items="${userList}" var="user" varStatus="status">
           //     <tr>
           //     <td>${status.count}</td>
           //     <td>Name:${user.name}</td>
           // <td>UserName:${user.username}</td>
           // <td>Email:${user.email}</td>
           // </tr>
           // </c:forEach></tbody>
       }
    });

})