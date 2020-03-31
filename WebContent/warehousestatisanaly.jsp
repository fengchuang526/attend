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
<!-- jqGrid -->
<link rel="stylesheet" href="<%=basePath%>css/jqGrid5.3.2/ui.jqgrid.css">
<link rel="stylesheet" href="<%=basePath%>css/jQueryUI/jquery-ui-1.10.4.custom.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootbox.min.js"></script>
<!-- jqGrid -->
<script src="<%=basePath%>js/jqGrid5.3.2/i18n/grid.locale-en.js"></script>
<script src="<%=basePath%>js/jqGrid5.3.2/jquery.jqGrid.min.js"></script>
<script src="<%=basePath%>js/jquery-ui/jquery-ui.min.js"></script>
<!-- 自定义 -->
<script src="<%=basePath%>js/jsutil.js"></script>
<script src="<%=basePath%>js/mydefinejq.js"></script>
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
  							<div class="col-md-1">
	  							<ul class="list-unstyled">
								  <li><a href="<%=basePath%>warehouse/enterWarehouse.action">商品管理</a></li>
								  <li><a href="<%=basePath%>rela/enterRelaManage.action">相关方管理</a></li>
								  <li><a href="<%=basePath%>warehouse/enterWarehouseOutIn.action">出库入库</a></li>
								  <li><a href="<%=basePath%>warehouseDetail/enterWarehouseStatisAnaly.action">统计分析</a></li>
								</ul>
  							</div>
  							<div class="col-md-11">
  								<div class='row'>
  									<form class="form-inline" id="searchForm" style="margin-bottom:5px;">
									   <div class="form-group">
									    <label class="radio-inline">
										  <input type="radio" name="statisType" value="goods" id="goodsStatis">商品
										</label>
										<label class="radio-inline">
										  <input type="radio" name="statisType" value="rela" id="relaStatis">相关方
										</label>
									   </div>
									   <div class="form-group">
									    <label for="searchDate">时间</label>
									    <input type="date" name="startDate">至
									    <input type="date" name="endDate">
									   </div>
  									</form>
  									<button class='btn btn-sm btn-default' id='resetBtn'>重置</button>
  									<button class='btn btn-sm btn-default' id='searchBtn'>查询</button>
  								</div>
								<div class="jqGrid_wrappper" style='margin:5px 0 0 -10px;'>
									<table id="warehouseTable"></table>
									<div id="warehousePage"></div>
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
	</div>
</body>
  <script type="text/javascript">
  	$(function(){
		//表格配置  		
  		$("#warehouseTable").jqGrid({
  			url : '<%=basePath%>warehouseDetail/searchWarehouseDetailAnaly.action',
  			recordtext: "显示：{0} - {1}，总数：{2} ",
  		    emptyrecords: "本次查询无数据！",
  		    loadtext: "读取中...",
  		    loadui:"block",
  		    pgtext : "第 {0}页， 共{1}页",
  			mtype : "get",
  	        datatype: "json",
  	        height: 350,
  	        autowidth: true,
  	        shrinkToFit: true,
  	        prmNames: {//表示请求页码的参数名称
  	            page: "page",
  	            rows: "size"
  	        },
  	        page : 1,
  	        rowNum: 20,
  	        rowList: [10, 20, 30],
  	        colModel : [{
  	        	label : '相关方',
  	        	name:'name',
  	        	index:'name',
  	        	editable: false,
  	        	search:true,
  	        	hidden : true,
  	        	formatter : function(cellValue,options,rowObject){
  	        		if(isEmpty(cellValue)){
  	        			return '';
  	        		}
  	        		var relaPerson = ${requestScope.relaPerson};
  	        		var result = '';
  	        		for(i in relaPerson){
  	        			if(cellValue == relaPerson[i].id){
  	        				result = relaPerson[i].relaName;
  	        			}
  	        		}
  	        		return result;
  	        	}
  	        },{
  	        	label : '商品名称',
  	        	name:'goodsCode',
  	        	index:'goodsCode',
  	        	editable: false,
  	        	search:true,
  	        	hidden : false,
  	        	formatter : function(cellValue,options,rowObject){
  	        		if(isEmpty(cellValue)){
  	        			return '';
  	        		}
  	        		var goods = <%=request.getAttribute("goods")%>;
  	        		var result = '';
  	        		$.each(goods,function(i,item){
  	        			if(item.goodsCode == cellValue){
  	        				result = item.goodsName;
  	        			}
  	        		});
  	        		return result;
  	        	}
  	        },{
  	        	label : '交易类型',
  	        	name:'detailType',
  	        	index:'detailType',
  	        	editable: false,
  	        	search:true,
  	        	formatter : function(cellValue,options,rowObject){
  	        		if(isEmpty(cellValue)){
  	        			return '';
  	        		}
  	        		var detailType = ${requestScope.detailType};
  	        		var result = '';
  	        		detailType.forEach(function(item){
  	        			if(item.subCode == cellValue){
  	        				result = item.subName;
  	        			}
  	        		});
  	        		return result;
  	        	}
  	        },{
  	        	label : '交易数量',
  	        	name:'goodsCount',
  	        	index:'goodsCount',
  	        	editable: false,
  	        	search:true
  	        },{
  	        	label : '交易总额（元）',
  	        	name:'goodsAmt',
  	        	index:'goodsAmt',
  	        	editable: false,
  	        	search:true
  	        }],
  	        pager: "#warehousePage",
  	        viewrecords: true,
  	        caption: "",
  	        add: true,
  	        edit: true,
  	        addtext: 'Add',
  	        edittext: 'Edit',
  	        rownumbers: true,
  	        hidegrid: true,
  	        jsonReader : {
  	        	root:"response.data",
  	        	records: "response.totalElements",
  	        	total:"response.totalPages",
  	        	page:"response.number"
  	        }
  	    });
  	    $("#warehouseTable").jqGrid('navGrid', '#warehousePage',
  	            {edit: false, add: false, del: false, search: false},
  	            {height: 200, reloadAfterSubmit: true}
  	    );
  	    
  	    //重置
  	    $('#resetBtn').click(function(){
  	    	defineResetForm('#searchForm');
  	    });
  	    
  	    //查询
  	    $('#searchBtn').click(function(){
  	    	var statisType = $('input:radio[name="statisType"]:checked').val();
  	    	if(statisType == 'rela'){
  	    		$("#warehouseTable").setGridParam().showCol("name");
  	    	}else{
  	    		$("#warehouseTable").setGridParam().hideCol("name");
  	    	}
  	    	var data = $('#searchForm').getNotNullJson();
  	    	$("#warehouseTable").jqGrid('clearGridData');//清空表格
  			$("#warehouseTable").jqGrid('setGridParam',{//重新加载数据
  				url : '<%=basePath%>warehouseDetail/searchWarehouseDetailAnaly.action',
  				postData : data
  			},true).trigger("reloadGrid");
  	    });
  	    
  	});
  </script>
</html>