<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/10/30
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
您的购物车内物品已全部删除快去添加物品吧！
<%response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=UTF-8");
%><br/>
页面三秒钟后跳转,
<%
    response.setHeader("refresh", "3;url=AllBookServlet");
    out.write("如果没有跳转，请点击<a href='AllBookServlet'>这里</a>");
%>
</body>
</html>
