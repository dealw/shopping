<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/10/30
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String  str = (String)request.getAttribute("str");
%>
<table width="100%" height="100%" border="0"  >
    <tr>
        <td align="center" valign="middle">
       <form action="CheckLogServlet" method="post">
           用户名:<input name="uname" placeholder="<%=str==null?"":str%>" ><br/>
           密码:<input type="password" placeholder="<%=str==null?"":str%>" name="upwd" ><br/>
           <input type="submit" value="登陆">
       </form>
        </td>
    </tr>
</table>
</body>
</html>
