<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!-- alt + / -->
<!DOCTYPE html>
<html>
<head>
<title>商品查询页面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
</head>
	<body>
	    <div class="container">
	    <form class="form-inline" action="${pageContext.request.contextPath}/product/query.mvc" method="get" style="margin-bottom: 20px">
			<div class="form-group">
			<label for="keyword">Search:</label>
			<input type="text" name="keyword" class="form-control" id="keyword"
					placeholder="请输入查询关键字">
			</div>
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
		</form>
		
		
		
		<table class="table table-striped table-hover table-bordered" >
			<tr>
				<th>编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品备注</th>
				<th>日期</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${requestScope.proList}" var="product" varStatus="num">
			<tr>
				<td>${num.count}</td>
			    <td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.remark}</td>
				<td>${product.date}</td>				
				<td><a href="${pageContext.request.contextPath}/product/delete.mvc?id=${product.id}">删除</a>
				|<a href="${pageContext.request.contextPath}/product/getById.mvc?id=${product.id}">更新</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</body>
</html>
