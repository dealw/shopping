<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/10/12
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ page pageEncoding="utf-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    您的购物车已清空快去添加物品吧！您本次消费：
    <%response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=UTF-8");
    int total= (int) request.getAttribute("total");
    out.print(total);
    %><br/>
    页面三秒钟后跳转,
    <%
        response.setHeader("refresh", "3;url=AllBookServlet");
        out.write("如果没有跳转，请点击<a href='AllBookServlet'>这里</a>");
        %>

</body>
</html>
