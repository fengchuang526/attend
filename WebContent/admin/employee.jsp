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
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootbox.min.js"></script>
<style type="text/css">
	.panel-body {
		height:480px
	}
</style>
</head>
<body>
	<div class="container-fluid" style="margin-top:7px">
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
  						<div class="row">
  							<div class="col-md-12">
  								<a class="btn btn-default" href="<%=basePath%>admin/addEmpl.action" role="button">添加员工</a>
  								<button class="btn btn-default" id="editBtn" type="button">编辑信息</button>
  								<button class="btn btn-default" id="disBtn"  type="button">员工离职</button>
  							</div>
  						</div>
  						<div class="row">
  							<div class="col-md-12">
  								<table class="table table-hover" id="emplTable">
  									<tr>
  										<th style="display:none;">id</th>
  										<th style="display:none;">员工编号</th>
  										<th>员工名</th>
  										<th>员工电话</th>
  										<th>员工家庭地址</th>
  										<th>员工状态</th>
  									</tr>
  									<c:forEach items="${requestScope.empls}" var="empl">
  										<tr>
	  										<td style="display:none;">${empl.id}</td>
	  										<td style="display:none;">${empl.emplNo}</td>
	  										<td>${empl.emplName}</td>
	  										<td>${empl.emplPhoneOne}</td>
	  										<td>${empl.emplAddress}</td>
	  										<td>
	  											<select disabled="true" class="form-control">
	  												<c:forEach items="${requestScope.emplStatus}" var="status">
	  													<c:if test="${empl.emplStatus==status.subValue}">
	  														<option selected="selected" value="${status.subValue}">${status.subName}</option>
	  													</c:if>
	  													<c:if test="${empl.emplStatus!=status.subValue}">
	  														<option value="${status.subValue}">${status.subName}</option>
	  													</c:if>
	  												</c:forEach>
	  											</select>
	  										</td>
  										</tr>
  									</c:forEach>
  								</table>
  							</div>
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
  		var empl = null;//表格选中行
  		$("#emplTable tr").click(function(){
  			empl = $(this).find("td");
  		});
  		
  		$("#editBtn").click(function(){
  			if(!empl){
  				bootbox.alert("请先选择一条记录!");
  				return false;
  			}
  			window.location.href = "<%=basePath%>admin/updateEmpl.action?id="+empl[0].innerHTML;
  		});
  		
  		$("#disBtn").click(function(){
  			if(!empl){
  				bootbox.alert("请先选择一条记录!");
  				return false;
  			}
  			window.location.href = "<%=basePath%>admin/fireEmpl.action?id="+empl[0].innerHTML;
  		});
  	});
  </script>
</html>