<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<nav class="navbar navbar-default" style="border:0;background-color:#f5f5f5;">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<c:forEach items="${sessionScope.menus}" var="menu">
      		<li>
      			<a href="<%=basePath%>${menu.menuUrl}" style="color:#3383c0;font-weight:bold;">${menu.menuName}</a>
      		</li>
      	</c:forEach>
      </ul>
    </div>
  </div>
</nav>