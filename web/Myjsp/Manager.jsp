<%--
  Created by IntelliJ IDEA.
  User: Deal
  Date: 2019/10/30
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<table width="100%" height="100%" border="0"  >
    <tr>
        <th>添加库存</th>
        <th>添加新书</th>
        <th>删除已有</th>
    </tr>
    <td align="center" valign="middle">
        <form action="ManagerServlet" method="post">
            书号：<input name="bno" placeholder="在此输入要添加库存的书号"><br/>
            数量：<input name="bnum" placeholder="在此输入要添加的数量"><br/>
            <input type="submit" value="提交">
        </form>
    </td>
    <td align="center"  align="left" >
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            书号<input name="bno" placeholder="在此输入要添加的书号"><br/>
            书名:<input name="bname" placeholder="在此输入要添加的书名"><br/>
            数量<input name="bnum" placeholder="在此输入要添加的数量"><br/>
            价格:<input name="bprice" placeholder="在此输入价格"><br/>
            上传图片:<input type="file" name="filename"><br/>
            <input type="submit" value="提交">
        </form>
    <td align="center" valign="middle">
        <form action="DeleteShopServlet" method="post">
            书号：<input name="bno" placeholder="在此输入要删除的书号"><br/>
            <input type="submit" value="提交">
        </form>
    </td>
    <tr>

    </tr>
</table>
</body>
</html>
