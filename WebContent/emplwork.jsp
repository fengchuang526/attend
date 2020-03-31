<%@page import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String newDate = new SimpleDateFormat("yyyy-MM").format(new Date());
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
						<div class="col-md-12">
							<div class="col-md-12">
								<a class="btn btn-default" href="<%=basePath%>enterAddWork.action" role="button">记录考勤</a>
  								<button class="btn btn-default" id="editBtn" type="button">编辑考勤</button>
  								<button class="btn btn-default" id="delBtn"  type="button">删除考勤</button>
						        <form class="navbar-form navbar-right" role="search" id="searchForm" method="post">
						          <div class="form-group">
						          	<select id="serchSelect" class="form-control">
						          		<option value="">请选择要搜索的员工</option>
						          		<c:forEach items="${requestScope.empls}" var="empl">
						          			<option value="${empl.id}">${empl.emplName}</option>
						          		</c:forEach>
						          	</select>
						          </div>
						          <button type="submit" id="searchBtn" class="btn btn-default">搜索</button>
						        </form>
						        <form class="navbar-form navbar-right" role="search" id="exportForm" method="post">
						          <div class="form-group">
						          	<input type="month" name="exportDate" class="form-control" value="<%=newDate%>">
						          </div>
						          <button type="submit" id="exportBtn" class="btn btn-default">导出考勤</button>
						        </form>
							</div>
							<div class="col-md-12">
								<table class="table table-hover" id="workTable">
									<tr>
										<th style="display:none;">id</th>
										<th>员工姓名</th>
										<th>工作日期</th>
										<th>计薪方式</th>
										<th>计薪单价</th>
										<th>工作总计</th>
										<th>工作补助</th>
										<th>总计金额(元)</th>
										<th>备注</th>
									</tr>
									<c:forEach items="${requestScope.works}" var="work">
										<tr>
											<td style="display:none;">${work.id}</td>
											<td>${work.emplName}</td>
											<td><fmt:formatDate value="${work.workDate}" pattern="yyyy-MM-dd"/></td>
											<td>
												<select style="width:80px;" disabled="true" class="form-control">
													<c:forEach items="${requestScope.countPayWay}" var="way">
														<c:if test="${way.subCode==work.workWay}">
															<option value="${work.workWay}" selected="true">${way.subName}</option>
														</c:if>
														<c:if test="${way.subCode!=work.workWay}">
															<option value="${work.workWay}">${way.subName}</option>
														</c:if>
													</c:forEach>
												</select>
											</td>
											<td>${work.workPrice}</td>
											<td>${work.workCount}</td>
											<td>${work.workAllow}</td>
											<td>${work.workAmount}</td>
											<td>${work.remark}</td>
										</tr>
									</c:forEach>
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
		var workId = null;//员工考勤记录的ID
		
		$("#workTable tr").click(function(){
			workId = $(this).find("td")[0].innerHTML;
		});
		
		$("#editBtn").click(function(){
			if(workId == null || workId == ""){
				bootbox.alert("请先选择一条考勤记录！");
				return false;
			}
			window.location.href = "<%=basePath%>enterUpdateWork.action?id="+workId;
		});
		
		$("#delBtn").click(function(){
			if(workId == null || workId == ""){
				bootbox.alert("请先选择一条考勤记录！");
				return false;
			}
			window.location.href = "<%=basePath%>deleteWork.action?id="+workId;
		});
		
		$("#searchBtn").click(function(){
			var searchId = $("#serchSelect option:selected").val();
			if(searchId == null || searchId == ""){
				bootbox.alert("请先选择要搜索的员工!");
				return false;
			}
			$("#searchForm").get(0).action = "<%=basePath%>searchEmplWorks.action?emplId="+searchId;
		});
		
		$("#exportBtn").click(function(){
			$("#exportForm").get(0).action = "<%=basePath%>exportWorks.action";
		});
	});
</script>
</html>