<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>
<h1>用户注册的页面</h1>
<form action="${ pageContext.request.contextPath }/RegistServlet" method="post">
    <table width="600" border="1">
          <tr>
              <td>用户名</td>
              <td> <input type="text" name = "username" /> </td>
          </tr>
          <tr>
              <td>密码</td>
              <td> <input type="password" name = "password" /> </td>
          </tr>
          <tr>
              <td>昵称</td>
              <td> <input type="text" name = "nickname" /> </td>
          </tr>
          <tr>
              <td>邮箱</td>
              <td> <input type="text" name = "email" /> </td>
          </tr>
          <tr>
              <td colspan="2"> <input type="submit" value="注册" /> </td>
          </tr>
    </table>
</form>
</body>
</html>