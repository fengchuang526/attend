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
	.form-group {
		margin:10px 0 10px 30px
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
						<div class="col-md-8 col-md-offset-2">
							<form class="form-inline" id="emplWorkForm" method="post">
							  <input type="hidden" name="id" value="${requestScope.work.id }" id="workId">
							  <div class="form-group">
							    <label for="emplId">姓名</label>
							    <select class="form-control" id="emplId" style="width:195px;" name="emplId">
							    	<option value="">请选择员工</option>
							    	<c:forEach items="${requestScope.empls}" var="empl">
							    		<c:if test="${empl.id==work.emplId}">
							    			<option selected="true" value="${empl.id}">${empl.emplName}</option>
							    		</c:if>
							    		<c:if test="${empl.id!=work.emplId}">
							    			<option value="${empl.id}">${empl.emplName}</option>
							    		</c:if>
							    	</c:forEach>
							    </select>
							  </div>
							  <input type="hidden" id="emplName" name="emplName" value="${requestScope.work.emplName}">
							  <div class="form-group">
							    <label for="workDate">日期</label>
							    <input type="date" value='<fmt:formatDate value="${requestScope.work.workDate}" pattern="yyyy-MM-dd"/>' style="width:195px;" name="workDate" class="form-control" id="workDate">
							  </div>
							  <div class="form-group">
							    <label for="workWay">方式</label>
							    <select class="form-control" id="workWay" style="width:200px;" name="workWay">
							    	<option>请选择方式</option>
							    	<c:forEach items="${requestScope.countPayWay}" var="way">
							    		<c:if test="${way.subCode==work.workWay}">
							    			<option selected="true" value="${way.subCode}">${way.subName}</option>
							    		</c:if>
							    		<c:if test="${way.subCode!=work.workWay}">
							    			<option value="${way.subCode}">${way.subName}</option>
							    		</c:if>
							    	</c:forEach>
							    </select>
							  </div>
							  <div class="form-group">
							    <label for="workPrice">单价</label>
							    <input type="number" step="0.0001" name="workPrice" value="${requestScope.work.workPrice}" class="form-control" id="workPrice" placeholder="请输入单价">
							  </div>
							  <div class="form-group">
							    <label for="workCount">总计</label>
							    <input type="number" step="0.01" name="workCount" value="${requestScope.work.workCount }" class="form-control" id="workCount" placeholder="请输入工作总计">
							  </div>
							  <div class="form-group">
							    <label for="workAllow">补助</label>
							    <input type="number" step="0.01" name="workAllow" value="${requestScope.work.workAllow }" class="form-control" id="workAllow" placeholder="请输入工作补助">
							  </div>
							  <div class="form-group">
							    <label for="workAmount">薪资</label>
							    <input type="number" step="0.0001" readonly name="workAmount" value="${requestScope.work.workAmount }" class="form-control" id="workAmount" placeholder="此项是计算出的">
							  </div>
							  <div></div>
							  <div class="form-group">
							    <label for="remark">备注</label>
							    <textarea id="remark" name="remark" class="form-control" rows="5" cols="97">${requestScope.work.remark}</textarea>
							  </div>
							  <div></div>
							  <div style="margin:10px 0 10px 0;">
								  <button type="submit" id="subBtn" class="btn btn-primary center-block">
								  	<c:if test="${requestScope.work==null}">提交</c:if>
								  	<c:if test="${requestScope.work!=null}">更新</c:if>
								  </button>
							  </div>
							</form>
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
  		
		$("#workPrice,#workCount,#workAllow,#workWay").change(function(){
			var  workPrice = $("#workPrice").val();
			var  workCount = $("#workCount").val();
			var  workAllow = $("#workAllow").val();
			if(workPrice == undefined || workPrice ==null || workPrice == ""){
				return false;
			}
			if(workCount == undefined || workCount ==null || workCount == ""){
				return false;
			}
			if(workAllow == undefined || workAllow ==null || workAllow == ""){
				return false;
			}
			var wayType = $("#workWay").val();
			var countInit = 0.00;
			if(wayType == "byHour"){
				var tmp = workCount.split(".");
				if(tmp.length==1){
					countInit = parseFloat(tmp[0]);
				}else{
					countInit = parseFloat(tmp[0])+parseFloat(tmp[1]/60);
				}
			}else if(wayType == "byCount"){
				countInit = parseFloat(workCount);
			}else{
				bootbox.alert("请先选择计薪方式！");
				return false;
			}
			$("#workAmount").val(Math.round((parseFloat(workPrice)*countInit+parseFloat(workAllow))*100)/100);
		});  		
  		
		$("#subBtn").click(function(){
			var emplId = $("#emplId").val();
			if(emplId == null || emplId ==""){
				bootbox.alert("请先选择一名员工!");
				return false;
			}
			var workPrice = $("#workPrice").val();
			if(workPrice == undefined || workPrice ==null || workPrice == ""){
				bootbox.alert("请先填写单价!");
				return false;
			}
			var workCount = $("#workCount").val();
			if(workCount == undefined || workCount ==null || workCount == ""){
				bootbox.alert("请先填写总计!");
				return false;
			}
			var workAllow = $("#workAllow").val();
			if(workAllow == undefined || workAllow ==null || workAllow == ""){
				bootbox.alert("请先填写补助!");
				return false;
			}
			var emplName = $("#emplId").find("option:selected").text();
			$("#emplName").val(emplName);
			var id = $("#workId").val();
			if(id==null||id==""){
				$("#emplWorkForm").get(0).action = "<%=basePath%>addEmplWork.action";
			}else{
				$("#emplWorkForm").get(0).action = "<%=basePath%>updateEmplWork.action";
			}
		});
  		
  	});	
  </script>
</html>