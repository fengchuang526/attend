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
  									<button class='btn btn-sm btn-default' id='newBtn'>新增</button>
  									<button class='btn btn-sm btn-default' id='editBtn'>编辑</button>
  									<!-- 商品模态框 -->
  									<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id='warehouseModal'>
									  <div class="modal-dialog" role="document">
									    <div class="modal-content">
									      <div class="modal-header">
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									        <h4 class="modal-title" id="gridSystemModalLabel"></h4>
									      </div>
									      <div class="modal-body">
									      	<form class="form-horizontal" id="warehouseForm">
									      		<input type="hidden" name="id">
									      		<div class="form-group">
												    <label for="goodsCode" class="col-sm-2 control-label">商品编码</label>
												    <div class="col-sm-10">
												    	<input type="text" class="form-control" name="goodsCode" id="goodsCode">
												    </div>
											  	</div>
											  	<div class="form-group">
												    <label for="goodsName" class="col-sm-2 control-label">商品名称</label>
												    <div class="col-sm-10">
												    	<input type="text" class="form-control" name="goodsName" id="goodsName">
												    </div>
											  	</div>
											  	<div class="form-group">
												    <label for="goodsDesc" class="col-sm-2 control-label">商品描述</label>
												    <div class="col-sm-10">
													    <textarea class="form-control" rows="3" name="goodsDesc"></textarea>
												    </div>
											  	</div>
											  	<div class="form-group">
												    <label for="goodsType" class="col-sm-2 control-label">商品类型</label>
												    <div class="col-sm-10">
													    <select class="form-control" name="goodsType">
													    	<option>请选择</option>
													    	<c:forEach items="${requestScope.goodsType}" var="type">
													    		<option value='${type.subCode}'>${type.subName}</option>
													    	</c:forEach>
														</select>
												    </div>
											  	</div>
											  	<div class="form-group">
												    <label for="goodsPrice" class="col-sm-2 control-label">单价(元)</label>
												    <div class="col-sm-10">
													    <input type="number" step="0.0001" class="form-control" name="goodsPrice" id="goodsPrice">
												    </div>
											  	</div>
											  	<div class="form-group">
												    <label for="goodsNum" class="col-sm-2 control-label">商品数量</label>
												    <div class="col-sm-10">
													    <input type="number" class="form-control" name="goodsNum" id="goodsNum">
												    </div>
											  	</div>
									      	</form>
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									        <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
									      </div>
									    </div><!-- /.modal-content -->
									  </div><!-- /.modal-dialog -->
									</div><!-- /.modal -->
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
  		//刷新
  		function searchFn(){
  			$("#warehouseTable").jqGrid('clearGridData');//清空表格
  			$("#warehouseTable").jqGrid('setGridParam',{//重新加载数据
  			},true).trigger("reloadGrid");
  		}
  		//新增
  		$('#newBtn').click(function(){
  			$('#gridSystemModalLabel').text('新增');
  			defineResetForm('#warehouseForm');
  			$('#warehouseModal').modal('show');
  		});
  		//编辑
  		$('#editBtn').click(function(){
  			var rowId = $("#warehouseTable").jqGrid("getGridParam","selrow");
  			if(isEmpty(rowId)){
  				bootbox.alert("请先选择一条记录!");
  	    		return false;
  			}
  			var rowData = $("#warehouseTable").jqGrid("getRowData",rowId);
  			$('#gridSystemModalLabel').text('编辑');
  			$('#warehouseForm').loadJson(rowData);
  			$('#warehouseModal').modal('show');
  		});
  		
  		$("#warehouseTable").jqGrid({
  			url:"<%=basePath%>/warehouse/findWarehouse.action",
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
  	        	label : 'id',
  	        	name:'id',
  	        	index:'id',
  	        	editable: false,
  	        	search:true,
  	        	hidden : true
  	        },{
  	        	label : '商品编码',
  	        	name:'goodsCode',
  	        	index:'goodsCode',
  	        	editable: false,
  	        	search:true,
  	        	hidden : false
  	        },{
  	        	label : '商品名称',
  	        	name:'goodsName',
  	        	index:'goodsName',
  	        	editable: false,
  	        	search:true
  	        },{
  	        	label : '商品类型',
  	        	name:'goodsType',
  	        	index:'goodsType',
  	        	editable: false,
  	        	search:true,
  	        	formatter : function(cellValue,options,rowObject){
  	        		if(isEmpty(cellValue)){
  	        			return '';
  	        		}
  	        		var goodsType = ${requestScope.goodsType};
  	        		var result ='';
  	        		for(type of goodsType){
  	        			if(type.subCode == cellValue){
  	        				result = type.subName;
  	        			}
  	        		}
  	        		return result;
  	        	}
  	        },{
  	        	label : '初始化前商品类型',
  	        	name:'goodsType',
  	        	index:'goodsType',
  	        	editable: false,
  	        	search:true,
  	        	hidden : true
  	        },{
  	        	label : '商品单价（元）',
  	        	name:'goodsPrice',
  	        	index:'goodsPrice',
  	        	editable: false,
  	        	search:true
  	        },{
  	        	label : '商品数量',
  	        	name:'goodsNum',
  	        	index:'goodsNum',
  	        	editable: false,
  	        	search:true
  	        },{
  	        	label : '商品描述',
  	        	name:'goodsDesc',
  	        	index:'goodsDesc',
  	        	editable: false,
  	        	search:true
  	        },{
  	        	label : '创建时间',
  	        	name:'createDate',
  	        	index:'createDate',
  	        	editable: false,
  	        	search:true,
  	        	formatter : function(cellValue,options,rowObject){
  	        		if(isEmpty(cellValue)){
  	        			return '';
  	        		}
  	        		return formatYMDS(cellValue);
  	        	}
  	        },{
  	        	label : '更新时间',
  	        	name:'updateDate',
  	        	index:'updateDate',
  	        	editable: false,
  	        	search:true,
  	        	formatter : function(cellValue,options,rowObject){
  	        		if(isEmpty(cellValue)){
  	        			return '';
  	        		}
  	        		return formatYMDS(cellValue);
  	        	}
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
  	    
  	    //保存商品
  	    $('#saveBtn').click(function(){
  	    	var goodsCode = $('#goodsCode').val();
  	    	var goodsNum = $('#goodsNum').val();
  	    	if(isSelect(goodsCode) || isEmpty(goodsNum)){
  	    		bootbox.alert("请先填写商品编码、数量!");
  	    		return false;
  	    	}
  	    	var param = {
  	    		data : JSON.stringify($('#warehouseForm').getJson())
  	    	};
  	    	ajaxRequestCloseFn('<%=basePath%>warehouse/saveWarehouse.action',param,'#warehouseModal',searchFn);
  	    });
  	});
  </script>
</html>