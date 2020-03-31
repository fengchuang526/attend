<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微企业员工管理系统</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-table.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootbox.min.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/bootstrap-table-zh-CN.js"></script>
<style type="text/css">
	.panel-body {
		height:480px
	}
</style>
</head>
<body>
	<div class="container-fluid"  style="margin-top:7px">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">
							<h2>微企业员工管理系统</h2>
						</div>
						<jsp:include page="/nav.jsp"></jsp:include>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" style="margin-top:80px;" method="post" id="menuForm">
						  <input type="hidden" id="menuId" name="id" value="${requestScope.menu.id}">
						  <div class="form-group">
						    <label for="menuCode" class="col-sm-2 control-label col-sm-offset-3">菜单编码</label>
						    <div class="col-sm-2">
						      <input type="text" required="required" name="menuCode" value="${requestScope.menu.menuCode}" class="form-control" id="menuCode" placeholder="请输入菜单编码">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="menuName" class="col-sm-2 control-label col-sm-offset-3">菜单名称</label>
						    <div class="col-sm-2">
						      <input type="text" required="required" name="menuName" value="${requestScope.menu.menuName}" class="form-control" id="menuName" placeholder="请输入菜单名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="menuUrl" class="col-sm-2 control-label col-sm-offset-3">菜单地址</label>
						    <div class="col-sm-2">
						      <input type="text" required="required" name="menuUrl" value="${requestScope.menu.menuUrl}" class="form-control" id="menuUrl" placeholder="请输入菜单地址">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="isUse" class="col-sm-2 control-label col-sm-offset-3">是否使用</label>
						    <div class="col-sm-2">
						      <select id="isUse" class="form-control" required="required">
						      	<option value="">请选择菜单有效性</option>
						      	<c:forEach items="${requestScope.yesOrNo}" var="each">
						      		<c:if test="${requestScope.menu.isUse==each.subValue}">
						      			<option selected="true" value="${each.subValue}">${each.subName}</option>
						      		</c:if>
						      		<c:if test="${requestScope.menu.isUse!=each.subValue}">
						      			<option value="${each.subValue}">${each.subName}</option>
						      		</c:if>
						      	</c:forEach>
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-5 col-sm-4">
						      <button type="submit" class="btn btn-primary" id="subBtn">
						      	<c:if test="${requestScope.menu!=null}">提交</c:if>
						      	<c:if test="${requestScope.menu==null}">更新</c:if>
						      </button>
						    </div>
						  </div>
						</form>
					</div>
					<div class="panel-footer">
						<jsp:include page="/footer.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
  <script type="text/javascript">
  
  	$(function(){
  		
  		$("#subBtn").click(function(){
  			var id = $("#menuId").val();
  			if(id == null || id == ""){
  				$("#menuForm").get(0).action = "<%=basePath%>admin/addMenu.action";
  			}else{
  				$("#menuForm").get(0).action = "<%=basePath%>admin/updataMenu.action";
  			}
  		});
  		
  	});
  	
  </script>
</html>