<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.myBack {
	background : url('images/login1.jpg') no-repeat;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style='margin:5px 0 0 0;'>
			<div class="col-md-4 col-md-offset-4">
				<div style="padding:200px 0px 190px 0px;">
					<h3 style='text-align:center;font-weight:bold;'>微企业员工管理系统</h3>
					<form method="post" action="<%=basePath%>userLogin.action" class="form-horizontal">
					    <div class="form-group">
						    <label for="userNo" class="col-sm-2 control-label">账号</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="userNo" name="userNo" placeholder="请输入账号">
						    </div>
						</div>
					    <div class="form-group">
						    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" id="inputPassword3" name="userPwd" placeholder="请输入密码">
						    </div>
					    </div>
					    <button type="submit" class="col-sm-offset-5 btn btn-blue">登录</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
    var msg = "${requestScope.msg}";
    if (!!msg) {
    	alert(msg);
    }
</script>
</html>