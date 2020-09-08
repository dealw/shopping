<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/11/19
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!int pageCount = 0;

    void addCount() {
        pageCount++;
    }%>

<%
    addCount();
%>
<div style="text-align: center;">
    <p>Edit from deal 2019| 访问次数：<%=pageCount%></p>
</div>


</body>
</html>
