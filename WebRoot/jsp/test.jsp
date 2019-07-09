<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'Test.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <script type="text/javascript">

        window.onload = function () {
            alert(window.frames["test-iframe"]);
        }
    </script>
</head>

<body>
测试
<iframe id="test-iframe" name="test-iframe" src="http://hj.gold600.com/laomiaojiage/"
        scrolling="auto" style="border:none;" width="100%" height="100%"></iframe>
</body>
</html>
