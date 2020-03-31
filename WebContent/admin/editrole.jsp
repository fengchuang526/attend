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
							<a class="btn btn-default btn-sm" href="" role="button">添加角色</a>
							<button class="btn btn-default btn-sm" id="editBtn" type="button">编辑角色</button>
							<button class="btn btn-default btn-sm" id="delBtn"  type="button">删除角色</button>
						</div>
						<div class="col-md-4">
							<table class="table table-hover" id="menuTable">
								<tr>
									<th style="display:none;">id</th>
									<th>角色编码</th>
									<th>角色名称</th>
									<th>是否使用</th>
								</tr>
								<c:forEach items="${requestScope.auths}" var="auth">
									<tr>
										<td style="display:none;">${auth.id}</td>
										<td>${auth.menuCode}</td>
										<td>${auth.menuName}</td>
										<td>
											<select class="form-control" disabled="true">
												<c:forEach items="${requestScope.yesOrNo}" var="each">
													<c:if test="${auth.isUse==each.subValue}">
														<option value="${subValue}" selected="true">${each.subName}</option>
													</c:if>
													<c:if test="${auth.isUse!=each.subValue}">
														<option value="${subValue}">${each.subName}</option>
													</c:if>
												</c:forEach>
											</select>
										</td>
									</tr>
								</c:forEach>
							</table>
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
	
  </script>
</html>