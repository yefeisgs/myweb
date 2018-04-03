<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>


	<form class="form-horizontal"
		action="${pageContext.request.contextPath}/users/login.mvc"
		method="post">
		<div class="form-group">
			<span class="col-sm-3 control-label"><h3>用户登录</h3></span>
		</div>
		<div class="form-group">

			<label for="inputname" class="col-sm-2 control-label">用戶名</label>
			<div class="col-sm-4">
				<input type="text" name="name" class="form-control" id="inputname"
					placeholder="请输入用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-4">
				<input type="password" name="password" class="form-control"
					id="inputPassword" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> 记住用户名
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">登陆</button>
				${requestScope.error} ${error}
			</div>
		</div>
	</form>

</body>
</html>
