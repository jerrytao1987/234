<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layout</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid({    
	    url:'${pageContext.request.contextPath }/json/datagrid_data.json',    
	    columns:[[    
	        {field:'code',title:'编码',width:100,checkbox:true},    
	        {field:'name',title:'名称',width:100},    
	        {field:'price',title:'价格',width:100,align:'right'}    
	    ]],
	    rownumbers:true,
	    singleSelect:true,
	    toolbar:[
	             {text:"添加",iconCls:'icon-add',handler:function(){
	            	 alert("add");
	             }},
	             {text:"删除",iconCls:'icon-remove'},
	             {text:"修改",iconCls:'icon-edit'},
	             {text:"查询",iconCls:'icon-search'}
	             ],
	  pagination:true
	});
}) ;
</script>
</head>
<body>
	<table class="easyui-datagrid">   
    <thead>   
        <tr>   
            <th data-options="field:'code'">编码</th>   
            <th data-options="field:'name'">名称</th>   
            <th data-options="field:'price'">价格</th>   
        </tr>   
    </thead>   
    <tbody>   
        <tr>   
            <td>001</td><td>name1</td><td>2323</td>   
        </tr>   
        <tr>   
            <td>002</td><td>name2</td><td>4612</td>   
        </tr>   
    </tbody>   
</table>  

<table class="easyui-datagrid" style="height:250px"   
        data-options="url:'${pageContext.request.contextPath }/json/datagrid_data.json',fitColumns:true,singleSelect:true">   
    <thead>   
        <tr>   
            <th data-options="field:'code',width:100">编码</th>   
            <th data-options="field:'name',width:100">名称</th>   
            <th data-options="field:'price',width:100,align:'right'">价格</th>   
        </tr>   
    </thead>   
</table> 

<table id="dg"></table>	
</body>
</html>