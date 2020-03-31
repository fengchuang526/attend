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
						<div class="col-md-12">
							<button type="button" id="creaRoleBtn" class="btn btn-default btn-sm" data-toggle="modal" data-target="#addRoleModal">
							  创建角色
							</button>
							<div class="modal fade" id="addRoleModal" tabindex="-1" role="dialog" aria-labelledby="addRoleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title text-center" id="addRoleModalLabel">创建角色</h4>
							      </div>
							      <div class="modal-body">
							        <form class="form-horizontal" id="addRoleForm" action="<%=basePath%>admin/" method="post">
							        	  <div class="form-group">
										    <label for="roleCode" class="col-md-offset-2 col-md-2 control-label">角色编码</label>
										    <div class="col-md-4">
										      <input type="input"  required="required" class="form-control" id="roleCode" name="roleCode" placeholder="请输入角色编码">
										    </div>
										  </div>
										  <div class="form-group">
										    <label for="roleName" class="col-md-offset-2 col-md-2 control-label">角色名称</label>
										    <div class="col-md-4">
										      <input type="input"  required="required" class="form-control" id="roleName" name="roleName" placeholder="请输入角色名称">
										    </div>
										  </div>
										  <div class="form-group">
										    <label for="isUse" class="col-md-offset-2 col-md-2 control-label">是否启用</label>
										    <div class="col-md-4">
										      <select id="isUse" class="form-control" required="required" name="isUse">
										      	<option value="">请选择菜单有效性</option>
										      	<c:forEach items="${requestScope.yesOrNo}" var="each">
										      		<option value="${each.subValue}">${each.subName}</option>
										      	</c:forEach>
										      </select>
										    </div>
										  </div>
										  <div class="form-group">
										      <button type="button" class="btn btn-default col-md-offset-5" data-dismiss="modal">关闭</button>
									          <button type="button" class="btn btn-primary" id="btnSub">提交</button>
										  </div>
							        </form>
							        <table class="table table-bordered" data-click-to-select="true" data-single-select="false" id="menuTable" data-toggle="table">
										<thead>
											<tr>
												<th data-checkbox="true">选择</th>
												<th data-visible="false" data-field="id">id</th>
												<th data-field="menuCode">菜单编码</th>
												<th data-field="menuName">菜单名称</th>
											</tr>
										</thead>
									</table>
							      </div>
							    </div>
							  </div>
							</div>
								
								
						</div>
						<div class="col-md-12">
							
						</div>
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
		
		$("#creaRoleBtn").click(function(){
			$("#menuTable").bootstrapTable("refresh",{
				url : "<%=basePath%>admin/getUseMenus.action"
			});
			
		});
		
		
		$("#btnSub").click(function(){
			var form = $("#addRoleForm");
			
		});
		
		
	});
	
  </script>
</html>