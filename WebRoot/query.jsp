<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!-- alt + / -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>商品查询页面</title>
</head>
	<body>
	    <!-- 
	    	post: 安全(传输密码、价格)、性能差、支持文件上传
	    	get:通过地址栏传输,安全性差,性能好
	     -->
		<form action="${pageContext.request.contextPath}/product/query.mvc" method="get">
			关键字:<input type="text" name="keyword" />
			<button type="submit">提交</button>
		</form><br />
		<table border="1" width="600">
			<tr>
				<th>编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品备注</th>
				<th>日期</th>
				<th>操作</th>
			</tr>
			<!-- 应该使用循环迭代数据,可以采用JSTL标签来输出数据(JSTL与HTML无缝整合),tld是标签描述文件 -->
			<!-- 取代: request.getAttribute("proList");  -->
			<c:forEach items="${requestScope.proList}" var="product" varStatus="num">
			<tr>
				<td>${num.count}</td>
			    <!-- 会去查找相应get方法 -->
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
	</body>
</html>
