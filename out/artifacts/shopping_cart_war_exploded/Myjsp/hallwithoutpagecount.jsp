<%@ page import="com.deal.pageUtil.pageUtil" %>
<%@ page import="com.deal.entity.book" %><%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/11/19
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hall</title>
</head>
<style>
    html, body {
        margin: 0;
        height: 100%;
    }

    body {
        background-image: url("./img/bc.jpg");
    }
</style>
<body>
<%@ include file="header.jsp"%>
<table width="100%" height="100%" border="0">
    <tr>
        <td align="center" valign="middle">
            <table border="1px" cellspacing="0" align="center" width="60%" height="50%  style="margin:auto" >
    <tr>
        <th>书号</th>
        <th>书名</th>
        <th>库存</th>
        <th>单价</th>
        <th>操作</th>
    </tr>
    <%
        pageUtil pa = (pageUtil) request.getAttribute("pageBookinf");
        for (book bk : pa.getBook()) {
    %>
    <tr align="center">
        <td><%=bk.getBno()%>
        </td>
        <td><%=bk.getBname()%>
            <img src="img/<%=bk.getBno()%>.png" style="width: 40px;height: 60px ">
        </td>
        <td><%=bk.getBstore()%>
        </td>
        <td><%=bk.getBprice()%>
        </td>
        <td><a href="BuyServlet?bno=<%=bk.getBno()%>">购买</a></td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<div style="text-align: center">
    <a href="GetBookByPageServlet?page=<%=pa.getPage()-1%>">上一页</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="GetBookByPageServlet?page=<%=pa.getPage()+1%>">下一页</a>
</div>
<%--    <div align="center"><a href="AllBookServlet">首页</a>&&<a href="AllCartServlet">购物车</a>&&<a href="Myjsp/login.jsp">我是管理员</a>--%>
<%--    </div>--%>
</td>
</tr>
</table>

</body>
</html>
