<%--
  Created by IntelliJ IDEA.
  User: usersLi
  Date: 2019/5/27
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>alipay支付</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <meta content="telephone=no" name="format-detection"/>
</head>
<body>
<form action="../index/alipay1" method="post">
    <input type="text" value="0.01" name="price" id="price"><br><br><br>
    <input type="submit" value="去支付">
</form>

</body>
</html>
