<%@ page import="com.deal.entity.book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/10/12
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mycart</title>
</head>
<body>
<table width="100%" height="100%" border="0">
    <tr>
        <td align="center" valign="middle">
            <table border="1px" cellspacing="0">
                <tr>
                    <th>书号</th>
                    <th>书名</th>
                    <th>单价</th>
                    <th>操作</th>
                    <th>数量</th>
                    <th>操作</th>
                    <th>合计</th>
                </tr>

                <%
                    int total = 0;
                    Map<Integer, Integer> map = (Map<Integer, Integer>) request.getAttribute("map");
                    List<book> cartbook = (List<book>) request.getAttribute("cartbook");
                    for (book car : cartbook) {
                        total += car.getBprice() * map.get(car.getBno());
                %>
                <tr align="center">
                    <td><%=car.getBno()%>
                    </td>
                    <td><%=car.getBname()%>
                        <img src="img/<%=car.getBno()%>.png" style="width: 40px;height: 60px "></td>
                    <td><%=car.getBprice()%>
                    </td>
                    <td><a href="BuyServlet?bno=<%=car.getBno()%>">+</a>
                    <td><%=map.get(car.getBno())%>
                    </td>
                    <td><a href="DeleteCartServlet?bno=<%=car.getBno()%>">-</a></td>
                    <%
                        }
                    %>
                    <td bgcolor="black"><span style="font-size: large; color: whitesmoke; "><%=total%></span></td>
                </tr>
            </table>
            <br/>
            <a href="GetBookByPageServlet?page=1">首页</a>&&<a href="SettlementServlet?total=<%=total%>">结算</a>&&<a
                href="SettlementServlet?total=0">全部删除</a>
        </td>
    </tr>
</table>
</body>
</html>
