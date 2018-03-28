<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>
<body>
         你好${sessionScope.users.name},欢迎来到后台管理员页面<br />
   <%=session.getId() %>
</body>
</html>
