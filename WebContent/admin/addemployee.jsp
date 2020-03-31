<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
<style type="text/css">
	.panel-body {
		height:480px
	}
	.form-group{
		margin:20px 0 20px 0
	}
	.formBody{
		margin-top:20px
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
						<form class="form-inline formBody" id="addEmplForm" method="post">
						  <input type="hidden" id="emplId" name="id" value="${requestScope.empl.id}">
						  <div class="form-group col-md-4">
						    <label for="emplName" class="control-label">姓名<span style="color:red;font-size:20px;">*</span></label>
						    <input type="input"  required="required" class="form-control" id="emplName" value="${requestScope.empl.emplName}" name="emplName" placeholder="请输入姓名">
						    <span id="nameSpan"></span>
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplEntryDate" class="control-label">入职时间<span style="color:red;font-size:20px;">*</span></label>
						    <input type="date" required="required" class="form-control" value='<fmt:formatDate value="${requestScope.empl.emplEntryDate}" pattern="yyyy-MM-dd"/>' id="emplEntryDate" name="emplEntryDate">
						    <span id="entrSpan"></span>
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplAddress" class="control-label">住址<span style="color:red;font-size:20px;">*</span></label>
						    <input type="input" required="required" class="form-control" id="emplAddress" value="${requestScope.empl.emplAddress}" name="emplAddress" placeholder="请输入家庭住址">
						    <span id="addressSpan"></span>
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplWechat" class="control-label">微信号</label>
						    <input type="input" class="form-control" id="emplWechat" value="${requestScope.empl.emplWechat}" name="emplWechat" placeholder="请输入微信号">
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplEmail" class="control-label">邮箱</label>
						    <input type="email" class="form-control" id="emplEmail" value="${requestScope.empl.emplEmail}" name="emplEmail" placeholder="请输入邮箱">
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplPhoneOne" class="control-label">电话<span style="color:red;font-size:20px;">*</span></label>
						    <input type="input" required="required" class="form-control" id="emplPhoneOne" value="${requestScope.empl.emplPhoneOne}" name="emplPhoneOne" placeholder="请输入电话1">
						    <span id="phoneSpan"></span>
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplPhoneTwo" class="control-label">电话2</label>
						    <input type="input" class="form-control" id="emplPhoneTwo" value="${requestScope.empl.emplPhoneTwo}" name="emplPhoneTwo" placeholder="请输入电话2">
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplPhoneThre" class="control-label">电话3</label>
						    <input type="input" class="form-control" id="emplPhoneThre" value="${requestScope.empl.emplPhoneThre}" name="emplPhoneThre" placeholder="请输入电话3">
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplBirthday" class="control-label">生	日</label>
						    <input type="date" class="form-control" id="emplBirthday" value='<fmt:formatDate value="${requestScope.empl.emplBirthday}" pattern="yyyy-MM-dd"/>' name="emplBirthday">
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplBankNo" class="control-label">银行卡号</label>
						    <input type="input" class="form-control" id="emplBankNo" value="${requestScope.empl.emplBankNo}" name="emplBankNo" placeholder="请输入银行卡号">
						  </div>
						  <div class="form-group col-md-4">
						    <label for="emplAlipay" class="control-label">支付宝帐号</label>
						    <input type="input" class="form-control" id="emplAlipay" value="${requestScope.empl.emplAlipay}" name="emplAlipay" placeholder="请输入支付宝账号">
						  </div>
						  <div class="form-group col-md-12">
						      <button type="button" class="btn btn-primary center-block" id="sub">
						         	<c:if test="${requestScope.empl == null}">提交</c:if>
						         	<c:if test="${requestScope.empl != null}">更新</c:if>
						      </button>
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
 
  	//验证表单必输项函数
  	function check(){
  		var emplName = $("#emplName").val();
  		if(!emplName){
  			$("#nameSpan").html("姓名不能为空！");
  			$("#nameSpan").css({
  				"color":"red",
  				"font-weight":"bold"
  			});
  			return false;
  		}else{
			$("#nameSpan").html("通过!");
			$("#nameSpan").css({
				"color":"green",
				"font-weight":"bold"
			});
  		}
  		
  		var emplPhoneOne = $("#emplPhoneOne").val();
  		if(!emplPhoneOne){
  			$("#phoneSpan").html("电话1不能为空！");
  			$("#phoneSpan").css({
  				"color":"red",
  				"font-weight":"bold"
  			});
  			return false;
  		}else{
			$("#phoneSpan").html("通过!");
			$("#phoneSpan").css({
				"color":"green",
				"font-weight":"bold"
			});
  		}
  		
  		var emplAddress = $("#emplAddress").val();
  		if(!emplAddress){
  			$("#addressSpan").html("电话1不能为空！");
  			$("#addressSpan").css({
  				"color":"red",
  				"font-weight":"bold"
  			});
  			return false;
  		}else{
			$("#addressSpan").html("通过!");
			$("#addressSpan").css({
				"color":"green",
				"font-weight":"bold"
			});
  		}
  		
  		var emplEntryDate = $("#emplEntryDate").val();
  		if(emplEntryDate==null||emplEntryDate==""){
  			$("#entrSpan").html("入职时间不能为空！");
  			$("#entrSpan").css({
  				"color":"red",
  				"font-weight":"bold"
  			});
  			return false;
  		}else{
			$("#entrSpan").html("通过!");
			$("#entrSpan").css({
				"color":"green",
				"font-weight":"bold"
			});
  		}
  		return true;
  	};
  
  	$("#sub").click(function(){
  		if(!check()){
  			return false;
  		}
  		var emplId = $("#emplId").val();
  		if(emplId != null && emplId != ""){
  			$("#addEmplForm").get(0).action = "<%=basePath%>admin/updateEmployee.action";
  		}else{
  			$("#addEmplForm").get(0).action = "<%=basePath%>admin/addEmployee.action";
  		}
		$("#addEmplForm").submit();
  	});
  </script>
</html>





