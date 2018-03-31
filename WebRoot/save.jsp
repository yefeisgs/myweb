<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
      <!-- System.out.println() -->
      <!-- 所有的资源前面必须要添加工程名 -->
      <form action="${pageContext.request.contextPath}/product/save.mvc" method="post" enctype="multipart/form-data">
            <!-- ctrl + alt + 方向键 -->
      		商品名称:<input type="text" name="name" value="test01" /><br />
      		商品价格:<input type="text" name="price" value="3.14" /><br />
      		商品图片:<input type="file" name="img" /><br />
      		商品备注:<input type="text" name="remark" value="我是备注!" /><br />
      		<button type="submit">提交</button>
      	</form>
  </body>
</html>
