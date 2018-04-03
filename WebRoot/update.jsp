<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
	<div id="container">
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/product/update.mvc"
			method="post">

			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">商品名称:</label>
				<div class="col-sm-6">
					<input type="text" name="name" class="form-control" id="inputName"
						value="${product.name}" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputPic" class="col-sm-2 control-label">商品图片:</label>
				<div class="col-sm-6">
					<input type="number" name="price" class="form-control"
						id="inputPic" value="${product.price}" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputRemark" class="col-sm-2 control-label">商品备注:</label>
				<div class="col-sm-6">
					<input type="text" name="remark" class="form-control" name="remark"
						id="inputRemark" value="${product.remark}" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">提交</button>
					<input type="hidden" name="id" value="${product.id}">
				</div>
			</div>

		</form>
	</div>
</body>
</html>
