<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<%--<form action="/login" method="POST">--%>
    <%--username: <input type="text" name="username" value=""/><br/>--%>
    <%--pwd: <input type="password" name="pwd" value=""/><br/>--%>
    <%--<input type="submit" value="submit">--%>
<%--</form>--%>

<form action="/upload/sigonFile"  method="post" enctype="multipart/form-data">
    文件：<input type="file" name="bigHeadImage" value=""><br/>
    <input type="submit" value="上传文件">
</form>
</body>
</html>
