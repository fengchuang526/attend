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
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-5">
							<div class="row">
								<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#addCateModal">
								  添加大类
								</button>
								<div class="modal fade" id="addCateModal" tabindex="-1" role="dialog" aria-labelledby="addCateModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title text-center" id="addCateModalLabel">添加大类</h4>
								      </div>
								      <div class="modal-body">
								        <form class="form-horizontal" id="addCateForm" action="<%=basePath%>admin/addCate.action" method="post">
								        	  <div class="form-group">
											    <label for="cateCode" class="col-md-offset-2 col-md-2 control-label">大类编码</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="cateCode" name="cateCode" placeholder="请输入大类编码">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="cateName" class="col-md-offset-2 col-md-2 control-label">大类名称</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="cateName" name="cateName" placeholder="请输入大类名称">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="cateDesc" class="col-md-offset-2 col-md-2 control-label">大类描述</label>
											    <div class="col-md-4">
											      <input type="input" class="form-control" id="cateDesc" name="cateDesc" placeholder="请输入大类描述">
											    </div>
											  </div>
											  <div class="form-group">
											      <button type="button" class="btn btn-default col-md-offset-5" data-dismiss="modal">关闭</button>
										          <button type="submit" class="btn btn-primary">提交</button>
											  </div>
								        </form>
								      </div>
								    </div>
								  </div>
								</div>
								
								<button type="button" id="editCateBtn" class="btn btn-default btn-sm" data-toggle="modal" data-target="#editCateModal">
								  编辑大类
								</button>
								<div class="modal fade" id="editCateModal" tabindex="-1" role="dialog" aria-labelledby="editCateModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title text-center" id="addCateModalLabel">编辑大类</h4>
								      </div>
								      <div class="modal-body">
								        <form class="form-horizontal" id="updateCateForm" action="<%=basePath%>admin/updateCate.action" method="post">
								        	  <input type="hidden" name="id" id="editId">
								        	  <div class="form-group">
											    <label for="updatecateCode" class="col-md-offset-2 col-md-2 control-label">大类编码</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="updatecateCode" name="cateCode" placeholder="请输入大类编码">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="updatecateName" class="col-md-offset-2 col-md-2 control-label">大类名称</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="updatecateName" name="cateName" placeholder="请输入大类名称">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="updatecateDesc" class="col-md-offset-2 col-md-2 control-label">大类描述</label>
											    <div class="col-md-4">
											      <input type="input" class="form-control" id="updatecateDesc" name="cateDesc" placeholder="请输入大类描述">
											    </div>
											  </div>
											  <div class="form-group">
											      <button type="button" class="btn btn-default col-md-offset-5" data-dismiss="modal">关闭</button>
										          <button type="submit" class="btn btn-primary">提交</button>
											  </div>
								        </form>
								      </div>
								    </div>
								  </div>
								</div>
								
							</div>
							<div class="row">
								<table class="table table-hover" id="cateTable">
									<tr>
										<th style="display:none;">id</th>
										<th>类型编码</th>
										<th>类型名称</th>
										<th>类型描述</th>
										<th>操作</th>
									</tr>
									<c:forEach items="${requestScope.cates}" var="cate">
										<tr>
											<td style="display:none;">${cate.id}</td>
											<td>${cate.cateCode}</td>
											<td>${cate.cateName}</td>
											<td>${cate.cateDesc}</td>
											<td><a class="btn btn-default" href="<%=basePath%>admin/delCate.action?id=${cate.id}" role="button">删除</a></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
						<div class="col-md-offset-1 col-md-6">
							<div class="row">
								<button type="button" id="addSubBtn" class="btn btn-default btn-sm" data-toggle="modal" data-target="#addSubModal">
								  添加小类
								</button>
								<div class="modal fade" id="addSubModal" tabindex="-1" role="dialog" aria-labelledby="addSubModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title text-center" id="addSubModalLabel">添加小类</h4>
								      </div>
								      <div class="modal-body">
								        <form class="form-horizontal" id="addSubForm" action="<%=basePath%>admin/addSub.action" method="post">
								        	  <input type="hidden" name="pId" id="addSubCateId">
								        	  <div class="form-group">
											    <label for="subCode" class="col-md-offset-2 col-md-2 control-label">小类编码</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="subCode" name="subCode" placeholder="请输入小类编码">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="subName" class="col-md-offset-2 col-md-2 control-label">小类名称</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="subName" name="subName" placeholder="请输入小类名称">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="subValue" class="col-md-offset-2 col-md-2 control-label">小类值</label>
											    <div class="col-md-4">
											      <input type="input" required="required" class="form-control" id="subValue" name="subValue" placeholder="请输入小类值">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="subDesc" class="col-md-offset-2 col-md-2 control-label">小类描述</label>
											    <div class="col-md-4">
											      <input type="input" class="form-control" id="subDesc" name="subDesc" placeholder="请输入小类描述">
											    </div>
											  </div>
											  <div class="form-group">
											      <button type="button" class="btn btn-default col-md-offset-5" data-dismiss="modal">关闭</button>
										          <button type="submit" class="btn btn-primary">提交</button>
											  </div>
								        </form>
								      </div>
								    </div>
								  </div>
								</div>
								
								
								<button type="button" id="editSubBtn" class="btn btn-default btn-sm" data-toggle="modal" data-target="#updateSubModal">
								  编辑小类
								</button>
								<div class="modal fade" id="updateSubModal" tabindex="-1" role="dialog" aria-labelledby="updateSubModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title text-center" id="updateSubModalLabel">添加小类</h4>
								      </div>
								      <div class="modal-body">
								        <form class="form-horizontal" id="updateSubForm" action="<%=basePath%>admin/updateSub.action" method="post">
								        	  <input type="hidden" name="id" id="updateSubId" >
								        	  <input type="hidden" name="pId" id="updateSubCateId" >
								        	  <div class="form-group">
											    <label for="updateSubCode" class="col-md-offset-2 col-md-2 control-label">小类编码</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="updateSubCode" name="subCode" placeholder="请输入小类编码">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="updateSubName" class="col-md-offset-2 col-md-2 control-label">小类名称</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="updateSubName" name="subName" placeholder="请输入小类名称">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="updateSubValue" class="col-md-offset-2 col-md-2 control-label">小类值</label>
											    <div class="col-md-4">
											      <input type="input"  required="required" class="form-control" id="updateSubValue" name="subValue" placeholder="请输入小类值">
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="updateSubDesc" class="col-md-offset-2 col-md-2 control-label">小类描述</label>
											    <div class="col-md-4">
											      <input type="input" class="form-control" id="updateSubDesc" name="subDesc" placeholder="请输入小类描述">
											    </div>
											  </div>
											  <div class="form-group">
											      <button type="button" class="btn btn-default col-md-offset-5" data-dismiss="modal">关闭</button>
										          <button type="submit" class="btn btn-primary">提交</button>
											  </div>
								        </form>
								      </div>
								    </div>
								  </div>
								</div>
								
								<button type="button" id="subDelBtn" class="btn btn-default btn-sm" >
								  删除小类
								</button>
							</div>
							<div class="row">
								<table class="table table-bordered" data-click-to-select="true" data-single-select="true" id="subTable" data-toggle="table">
									<thead>
										<tr>
											<th data-checkbox="true">选择</th>
											<th data-visible="false" data-field="id">id</th>
											<th data-visible="false" data-field="pId">cateId</th>
											<th data-field="subCode">小类编码</th>
											<th data-field="subName">小类名称</th>
											<th data-field="subValue">小类值</th>
											<th data-field="subDesc">小类描述</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<jsp:include page="/footer.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
  <script type="text/javascript">
  	$(function(){
  		<c:if test="${requestScope.cateId != null}">
			$("#subTable").bootstrapTable("refresh", {
		    	pagination: true, //启动分页
		    	pageSize: 1,  //每页显示的记录数
		    	url: "findSubsByCateId.action?id=${requestScope.cateId}"
		    });
		</c:if>
  		var cateTr = null;//大类选中的行
  		
  		$("#cateTable tr").click(function(){//为表格的行添加点击事件
  		    var tr = $(this);
  		  	cateTr = tr.find("td");
  		  	var cateId = cateTr[0].innerHTML;
  		    $("#subTable").bootstrapTable("refresh", {
  		    	pagination: true, //启动分页
  		    	pageSize: 1,  //每页显示的记录数
  		    	url: "findSubsByCateId.action?id="+tr.find("td")[0].innerHTML
  		    });
  		});
  		
  		$("#editCateBtn").click(function(){
  			if(!cateTr){
  				bootbox.alert("请先选择一条大类记录！");
  				return false;
  			}
  			$("#editId").val(cateTr[0].innerHTML);
  			$("#updatecateCode").val(cateTr[1].innerHTML);
  			$("#updatecateName").val(cateTr[2].innerHTML);
  			$("#updatecateDesc").val(cateTr[3].innerHTML);
  		});
  		
  		$("#addSubBtn").click(function(){
  			if(!cateTr){
  				bootbox.alert("请先选择一条大类记录！");
  				return false;
  			}
  			$("#addSubCateId").val(cateTr[0].innerHTML);
  		});
  		
  		$("#editSubBtn").click(function(){
  			var subTr = $("#subTable").bootstrapTable('getSelections');
  			if(subTr.length <= 0){
  				bootbox.alert("请先选择一条小类记录！");
  				return false;
  			}
  			$("#updateSubId").val(subTr[0].id);
  			$("#updateSubCateId").val(subTr[0].pId);
  			$("#updateSubCode").val(subTr[0].subCode);
  			$("#updateSubName").val(subTr[0].subName);
  			$("#updateSubValue").val(subTr[0].subValue);
  			$("#updateSubDesc").val(subTr[0].subDesc);
  		});
  		
  		$("#subDelBtn").click(function(){
  			var sub = $("#subTable").bootstrapTable('getSelections')[0];
  			$.ajax({
  				type : "post",
  				url : "<%=basePath%>admin/delSub.action?id="+sub.id,
  				dataType : "json",
  				success:function(data){
  					if(data.success){
  						$("#subTable").bootstrapTable("refresh", {
  			  		    	pagination: true, //启动分页
  			  		    	pageSize: 1,  //每页显示的记录数
  			  		    	url: "findSubsByCateId.action?id="+sub.pId
  			  		    });
  						bootbox.alert("成功删除!");
  					}
  				},
  				fail:function(info){
  					bootbox.alert("操作出错，请联系管理员！");
  				}
  			});
  			
  		});
  		
  	});
  
  </script>
</html>