<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/10/30
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="100%" height="100%" border="0">
    <tr>
        <td align="center" valign="middle">
            <%
                int store = (int) request.getAttribute("store");
                int bno = (int) request.getAttribute("bno");
            %>
            增加成功！
            <br/>
            书号<%=bno%><br/>
            库存<%=store%><br/>
            <a href="../GetBookByPageServlet?page=1">首页</a>&&<a href="Manager.jsp">继续添加</a>
        </td>
    </tr>
</table>
</body>
</html>
