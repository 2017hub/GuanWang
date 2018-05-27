<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>注册页面</h2>
<%--<form action="/register/orgUser" method="post">--%>
<%--<table>--%>
    <%--<tr>--%>
        <%--<td>昵称</td>--%>
        <%--<td><input type="text" name="nick" pattern="[\u4e00-\u9fa5]{4,10}" required="required" placeholder="请输入4~10位汉语"></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>密码</td>--%>
        <%--<td><input type="password" name="password" pattern="\w{3,6}" required="required" placeholder="请输入3~6位密码"></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>手机号</td>--%>
        <%--<td><input type="text" name="phone" pattern="1[3578]\d{9}" required="required" placeholder="请输入正确格式的手机号"></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>邮箱</td>--%>
        <%--<td><input type="email" name="emaile" required="required" placeholder="请输入正确的邮箱格式"></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>年龄</td>--%>
        <%--<td><input type="text" name="age" pattern="[1-9]\d{0,3}" required="required" ></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td><input type="submit" value="注册"></td>--%>
        <%--<td><input type="reset" value="重置"></td>--%>
    <%--</tr>--%>
<%--</table>--%>
<%--</form>--%>

<form action="/register/orgUser" method="post">
    <table>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="nick"   placeholder="请输入4~10位汉语"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"  placeholder="请输入3~6位密码"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text" name="phone" placeholder="请输入正确格式的手机号"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="emaile"  placeholder="请输入正确的邮箱格式"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"  ></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
