<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
      <!-- System.out.println() -->
      <!-- 所有的资源前面必须要添加工程名 -->
      <form action="${pageContext.request.contextPath}/product/update.mvc" method="post">
   
      
            <!-- ctrl + alt + 方向键 -->
      		商品名称:<input type="text" name="name" value="${product.name}" /><br />
      		商品价格:<input type="text" name="price" value="${product.price}" /><br />
      		商品备注:<input type="text" name="remark" value="${product.remark}" /><br />
      		<button type="submit">提交</button>
      		<input type="hidden" name="id" value="${product.id}">
      		      		
      </form>
  </body>
</html>
