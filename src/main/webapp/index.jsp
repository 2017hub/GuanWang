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
<%--单文件上传--%>
<%--<form action="/upload/sigonFile"  method="post" enctype="multipart/form-data">--%>
    <%--文件：<input type="file" name="bigHeadImage" value=""><br/>--%>
    <%--<input type="submit" value="上传文件">--%>
<%--</form>--%>

<form action="/upload/uploadFiles"  method="post" enctype="multipart/form-data">
    文件1：<input type="file" name="bigHeadImage" value=""><br/>
    文件2：<input type="file" name="smallHeadImage" value=""><br/>
    文件3：<input type="file" name="artHeadImage" value=""><br/>
    <input type="submit" value="上传文件">
</form>


</body>
</html>
