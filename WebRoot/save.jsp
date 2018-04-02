<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
  </head>
  
  <body>
  <div id="container">
  
       <form class="form-horizontal" action="${pageContext.request.contextPath}/product/save.mvc" method="post" enctype="multipart/form-data">
          
          <div class="form-group">
          
				<label for="inputName" class="col-sm-2 control-label">商品名称:</label>
				<div class="col-sm-6">
					<input type="text" name="name" class="form-control" id="inputName"
						placeholder="商品名称">
				</div>
			</div>
      		
      		
      		<div class="form-group">
				<label for="inputPic" class="col-sm-2 control-label">商品图片:</label>
				<div class="col-sm-6">
					<input type="file" name="img" class="form-control" id="inputPic"
						placeholder="商品图片">
				</div>
			</div>
      		
      		<div class="form-group">
				<label for="inputPic" class="col-sm-2 control-label">商品价格:</label>
				<div class="col-sm-2">
					<input type="number" name="price" class="form-control"
						id="inputPrice" placeholder="商品价格">
				</div>
			</div>
      	
      		<div class="form-group">
				<label for="inputRemark" class="col-sm-2 control-label">商品备注:</label>
				<div class="col-sm-6">
					<textarea placeholder="请输入商品备注信息" class="form-control" name="remark" id="inputRemark"></textarea>
				</div>
			</div>
       
      	<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
      		<button type="submit" class="btn btn-primary">添加商品</button>
      	</div>
      </div>
      </form>
     </div>
  </body>
  
</html>
