/*空判断*/
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}

/*非空判断*/
function isNotEmpty(obj){
	return !isEmpty(obj);
}

/*下拉框空判断*/
function isSelect(obj){
    if(typeof obj == "undefined" || obj == null || obj == "请选择" || obj == ''){
        return true;
    }else{
        return false;
    }
}

/*下拉框非空判断*/
function isNotSelect(obj){
	return !isSelect(obj);
}

/*IF转换成可计算的eval公式*/
function ifFormulaTransEvalFormula(obj){
	if(isEmpty(obj)){
		return obj;
	}
	if(!(obj.indexOf('IF') > -1)){
		return obj;
	}
	var resu = '';
	obj = obj.replace(/IF/g,'');
	var arr = obj.split(',');
	for(var i=0;i<arr.length;i++){
		resu += arr[i];
		if(i == arr.length-1){
			break;
		}
		if(i%2==0){
			resu += '?';
		}else{
			resu += ':';
		}
	}
	return resu;
}

/* 指标编码简单规则
 * 规则： 直接取机构编码，不足位数在前面补0
 * */
function indexCodeSimpleRule(orgCode,num){
	var res = '';
	if(isEmpty(orgCode)){
		for(var i=0;i<num;i++){
			res += '0';
		}
		return res;
	}
	var length = orgCode.length;
	res += orgCode;
	for(var i=0;i<num-length;i++){
		res += '0';
	}
	return res;
}

/*配置表格
 * tableId 表格ID（jquery格式）
 * pageId  分页ID（jquery格式）
 * url	       请求URL
 * colNames 表头
 * colModel 列属性
 * */
function jqGridConfig(tableId,pageId,url,colNames,colModel){
	$.jgrid.gridUnload(tableId);
	$(tableId).jqGrid({
		url : url,
		recordtext: "显示：{0} - {1}，总数：{2} ",
	    emptyrecords: "本次查询无数据！",
	    loadtext: "读取中...",
	    loadui:"block",
	    pgtext : "第 {0}页， 共{1}页",
		mtype : "get",
        datatype: "json",
        height: 350,
        autowidth: true,
        shrinkToFit : false,  
        autoScroll : true,
        prmNames: {//表示请求页码的参数名称
            page: "page",
            rows: "size"
        },
        page : 0,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames : colNames,
        colModel : colModel,
        pager: pageId,
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
    $(tableId).jqGrid('navGrid', pageId,
            {edit: false, add: false, del: false, search: false},
            {height: 200, reloadAfterSubmit: true}
    );
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $(tableId).setGridWidth(width);
    });
}

/*配置表格
 * tableId 表格ID（jquery格式）
 * pageId  分页ID（jquery格式）
 * url	       请求URL
 * colModel 列属性
 * */
function jqGridConfigColModel(tableId,pageId,url,colModel){
	$.jgrid.gridUnload(tableId);
	$(tableId).jqGrid({
		url : url,
		recordtext: "显示：{0} - {1}，总数：{2} ",
	    emptyrecords: "本次查询无数据！",
	    loadtext: "读取中...",
	    loadui:"block",
	    pgtext : "第 {0}页， 共{1}页",
		mtype : "get",
        datatype: "json",
        height: 350,
        autowidth: true,
        shrinkToFit : true,  
        autoScroll : true,
        prmNames: {//表示请求页码的参数名称
            page: "page",
            rows: "size"
        },
        page : 1,
        rowNum: 20,
        rowList: [10, 20, 30],
        colModel : colModel,
        pager: pageId,
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
}

/*
 * 还原表单(包括hidden)
 * formId 表单ID
 * */
function defineResetForm(formId){
	$(formId)[0].reset();
	$(formId+' input[type="hidden"]').val('');
}

/*
 * jquery的ajax的请求
 * url 请求地址
 * param 参数，json对象
 * */
function ajaxRequestBootbox(url, param) {
	$.ajax({
		url : url,
		type : "post",
		dataType : "json",
		data : param,
		success : function(data,textStatus) {
			bootbox.alert(data.data);
		},
		error : function(data, textStatus){
			bootbox.alert('请求失败！');
		}
	});
}

/*
 * jquery的ajax的请求
 * url 请求地址
 * param 参数，json对象
 * fn 回调函数
 * */
function ajaxRequestBootboxFn(url, param,fn) {
	$.ajax({
		url : url,
		type : "post",
		dataType : "json",
		data : param,
		success : function(data,textStatus) {
			bootbox.alert(data.data);
			fn();
		},
		error : function(data, textStatus){
			bootbox.alert('请求失败！');
		}
	});
}

/*
 * jquery的ajax的请求
 * url 请求地址
 * param 参数，json对象
 * modalId 模态框id，需要加#
 * refreshFn 刷新回调函数
 * */
function ajaxRequestCloseFn(url, param,modalId,refreshFn) {
	$.ajax({
		url : url,
		type : "post",
		dataType : "json",
		data : param,
		success : function(data,textStatus) {
			if(data.flag == true){
				bootbox.alert(data.data);
				$(modalId).modal('hide');
				refreshFn();
			}else{
				bootbox.alert(data.data);
			}
		},
		error : function(data, textStatus){
			bootbox.alert('请求失败！');
		}
	});
}

//获取url中的参数
function getQueryVariable(variable) {
      var query = window.location.search.substring(1);
      var vars = query.split("&");
      for (var i=0;i<vars.length;i++) {
              var pair = vars[i].split("=");
              if(pair[0] == variable){return pair[1];}
      }
      return(false);
}

//格式化时间（年-月-日 时：分：秒）
function formatYMDS(mill){
	var date = new Date(mill);
	var Y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    var H = date.getHours();
    var i = date.getMinutes();
    var s = date.getSeconds();
	return Y + '-' + m + '-' + d + ' ' + H + ':' + i + ':' + s;
}

//格式化时间（年-月-日）
function formatYMD(mill){
	var date = new Date(mill);
	var Y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
	return Y + '-' + m + '-' + d;
}