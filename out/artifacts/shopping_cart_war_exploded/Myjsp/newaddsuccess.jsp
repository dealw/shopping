<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/11/20
  Time: 0:25
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
                String  bname=(String)request.getAttribute("bname");
                int price=(int)request.getAttribute("price");
                int flag=(int)request.getAttribute("flag");
                if(flag==1){
                    out.print("增加成功");
                }else{
                    out.print("增加失败,书号重复！");
                    return;
                }
            %>
            <br/>
            书号:<%=bno%><br/>
            书名:<%=bname%><br/>
            库存:<%=store%><br/>
            价格:<%=price%><br/>
            <a href="../GetBookByPageServlet?page=1">首页</a>&&<a href="Manager.jsp">继续添加</a>
        </td>
    </tr>
</table>
</body>
</html>
