<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<!-- 导入ztree类库 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"
	type="text/javascript"></script>	
<script type="text/javascript">
	$(function(){
		// 授权树初始化
		var setting = {
			data : {
				key : {
					title : "t"
				},
				simpleData : {
					enable : true
				}
			},
			check : {
				enable : true,
			}
		};
		
		$.ajax({
			url : '${pageContext.request.contextPath}/functionAction_listajax',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				//var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#functionTree"), setting, data);
				/* if(functions!=null){
					var treeObj = $.fn.zTree.getZTreeObj("functionTree");
					for( var i = 0;i<functions.length;i++){
						var nodes = treeObj.getSelectedNodes();
						for (var j=0, l=nodes.length; j < l; j++) {
							var node = treeObj.getNodeByTId(nodes[j]);
							if(node.id==functions[i].id){
								treeObj.checkNode(nodes[j], true, true);
							}
						}
					}
				} */
				var id = $("input[name='id']").val();
				if(id!=""){
					$.post('roleAction_findById',{id:id},function(data){
						$("input[name='code']").val(data.code);
						$("input[name='name']").val(data.name);
						$("textarea[name='description']").val(data.description);
						if(data.functions.length>0){
							var treeObj = $.fn.zTree.getZTreeObj("functionTree");
							for(var i=0;i<data.functions.length;i++){
								if(data.functions[i].children.length==0){
									var node = treeObj.getNodeByParam("id",data.functions[i].id,null);
									treeObj.checkNode(node, true, true);
								}
								/* var node = treeObj.getNodeByParam("id",data.functions[i].id,null);
								if(node.children.length==0){
									treeObj.checkNode(node, true, true);
								} */
							}
						}	
					});
				}
			},
			error : function(msg) {
				alert('树加载异常!');
			}
		});
		
		
		// 点击保存
		$('#save').click(function(){
			var v = $("#roleForm").form("validate");
			if(v){
				var treeObj = $.fn.zTree.getZTreeObj("functionTree");
				var nodes = treeObj.getCheckedNodes(true);
				var array = new Array();
				for(var i=0;i<nodes.length;i++){
					var id = nodes[i].id;
					array.push(id);
				}
				var functionIds = array.join(",");
				$("input[name='functionIds']").val(functionIds);
				$("#roleForm").submit();
			}
		});
	});
</script>	
</head>
<body class="easyui-layout">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="roleForm" method="post" action="roleAction_add">
				<input type="hidden" name="id" value="${param.id }"/>
				<input type="hidden" name="functionIds"/>
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">角色信息</td>
					</tr>
					<tr>
						<td width="200">关键字</td>
						<td>
							<input type="text" name="code" class="easyui-validatebox" data-options="required:true" />						
						</td>
					</tr>
					<tr>
						<td>名称</td>
						<td><input type="text" name="name" class="easyui-validatebox" data-options="required:true"/></td>
					</tr>
					<tr>
						<td>描述</td>
						<td>
							<textarea name="description" rows="4" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td>授权</td>
						<td>
							<ul id="functionTree" class="ztree"></ul>
						</td>
					</tr>
					</table>
			</form>
		</div>
</body>
</html>