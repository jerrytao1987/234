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
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
	$(function() {
		
		var setting3={
				data: {
					simpleData: {
						enable: true,
					}
				},
				callback: {
					onClick: function(event, treeId, treeNode){
						if(treeNode.page != undefined){
							var e = $("#tt").tabs("exists",treeNode.name);
							if(e){
								$("#tt").tabs("select",treeNode.name);
							}else{
								$('#tt').tabs('add', {
									title : treeNode.name,
									content : '<iframe frameborder="0" height="100%" width="100%" src="'+treeNode.page+'"></iframe>',
									closable : true,
									tools : [ {
										iconCls : 'icon-mini-refresh',
										handler : function() {
											alert('refresh');
										}
									} ]
								});
							}
					    }
					}
				}
		};
		var url = "${pageContext.request.contextPath}/json/menu.json";
		$.post(url,{},function(data){
			$.fn.zTree.init($("#ztree3"), setting3, data);
			
		},'json');
		
		var setting2={
				data: {
					simpleData: {
						enable: true,
					}
				}
		};
		var zTreeNodes2 = [
			            {"id":1,"pId":0,"name":"节点一"},
			            {"id":2,"pId":1,"name":"节点二"},
			            {"id":3,"pId":2,"name":"节点三"}
			            ];
		$.fn.zTree.init($("#ztree2"), setting2, zTreeNodes2);
		
		var setting={};
		var zTreeNodes = [
		              {"name":"节点一","children":[
		                                        {"name":"节点一_1"},
		                                        {"name":"节点一_2"}
		                                        ]},
		              {"name":"节点二"},
		              {"name":"节点三"}
		              
		              ];
		$.fn.zTree.init($("#ztree1"), setting, zTreeNodes); 
		
		$("#but1").click(function() {
			var e = $("#tt").tabs("exists","New Tab");
			if(e){
				$("#tt").tabs("select","New Tab");
			}else{
				$('#tt').tabs('add', {
					title : 'New Tab',
					content : '<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>',
					closable : true,
					tools : [ {
						iconCls : 'icon-mini-refresh',
						handler : function() {
							alert('refresh');
						}
					} ]
				});
			}
		});
	});
</script>
</head>
<body class="easyui-layout">

	<div data-options="region:'north',title:'xxx系统管理'"
		style="height: 100px;"></div>

	<div data-options="region:'south',title:'South Title'"
		style="height: 100px;"></div>

	<div data-options="region:'east',iconCls:'icon-reload',title:'East'"
		style="width: 100px;"></div>

	<div data-options="region:'west',title:'系统菜单'" style="width: 180px;">
		<div id="aa" class="easyui-accordion" fit='true' border='false'
			style="width: 300px; height: 200px;">

			<div title="菜单1" data-options="iconCls:'icon-save',selected:true"
				style="overflow: auto; padding: 10px;">

				<a id="but1" style="color: #0099FF;text-decoration:none" href="javascript:void(0)">添加一个选项卡</a>

			</div>
			
			<div title="菜单2" data-options="iconCls:'icon-reload'"
				style="padding: 10px;">
				<ul id="ztree1" class="ztree"></ul>
			</div>

			<div title="菜单3">
				<ul id="ztree2" class="ztree"></ul>
			</div>
			
			<div title="菜单4">
				<ul id="ztree3" class="ztree"></ul>
			</div>

		</div>

	</div>

	<div data-options="region:'center',title:''"
		style="padding: 0px; background: #eee;">
		<div id="tt" class="easyui-tabs" style="width: 500px; height: 250px;"
			fit='true' border='false'>

			<div title="消息" style="padding: 20px; display: none;">tab1</div>

			<!-- <div title="Tab2" data-options="closable:true"
				style="overflow: auto; padding: 20px; display: none;">tab2</div>

			<div title="Tab3" data-options="iconCls:'icon-reload',closable:true"
				style="padding: 20px; display: none;">tab3</div> -->

		</div>


	</div>

</body>

</html>