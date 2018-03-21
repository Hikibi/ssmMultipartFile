<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/9
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/fileUpload" enctype="multipart/form-data" method="post">
    选择要上传的文件: <br>
    <input type="file" name="picture"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
