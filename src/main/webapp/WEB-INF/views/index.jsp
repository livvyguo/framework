<%--
  Created by IntelliJ IDEA.
  User: livvy
  Date: 14-4-29
  Time: 下午6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
hello spring mvc

<div id="serverTimeContent">

</div>
<c:out value="thhthht"/>
<c:out value="${timeMillis}"/>
<script type="text/javascript" src='<c:url value="/resource/javascript/jquery/jquery-1.11.0.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resource/javascript/servertime.js"/>'></script>
<script>

    $(function(){
        $.post("zz.json",{},function(data) {
            console.log(data);
            //alert(data.toString());
        },"json");
    });

    var srvClock = new ServerClock(<c:out value="${timeMillis}"/>);
    srvClock.setDelay(0);
    window.setInterval(function() {
        $("#serverTimeContent").text(srvClock.getServerTime().format("yyyy-MM-dd hh:mm:ss"))

    },500);
</script>
</body>
</html>
