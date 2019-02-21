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
<script type="text/javascript">
	$(function() {
		$("#but1").click(function() {
			var e = $("#tt").tabs("exists","New Tab");
			if(e){
				$("#tt").tabs("select","New Tab");
			}else{
				$('#tt').tabs('add', {
					title : 'New Tab',
					content : '<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>',
					closable : true,
					/* tools : [ {
						iconCls : 'icon-mini-refresh',
						handler : function() {
							alert('refresh');
						}
					} ] */
					
					
				});
			}
		});
		$('#tt').tabs({
		    border:false,
		    onSelect:function(title,index){
		    	/* $('#tt').panel('open').panel('refresh'); */
		        /* var tab = $('#tt').tabs('getSelected'); 
				$('#tt').tabs('update', {
				    tab: tab,
				    options: {
				        title: treeNode.name,
				        content: content
				    }
				}); */
				var select=$('#tt').tabs('getTab',index);
				var str = $(select.panel('options').content).find("iframe").html();
				alert(select.panel('options').content);
				/* var select=$('#tt').tabs('getTab',index);
				var url=$(select.panel('options').content).attr('src');
				$('#tt').tabs("update",{
					tab:select,
					options:{
						title:title, 
						       //href:URL, // 使用href会导致页面加载两次，所以使用content代替  
						content: '<iframe src="'
							+ url
							+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe>'
					}
				}); */
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
				style="padding: 10px;">content2</div>

			<div title="菜单3">content3</div>

		</div>

	</div>

	<div data-options="region:'center',title:''"
		style="padding: 0px; background: #eee;">
		<div id="tt" class="easyui-tabs" style="width: 500px; height: 250px;"
			fit='true' border='false'>

			<div title="Tab1" style="padding: 20px; display: none;"><iframe>hello</iframe></div>

			<div title="Tab2" data-options="closable:true"
				style="overflow: auto; padding: 20px; display: none;">tab2</div>

			<div title="Tab3" data-options="iconCls:'icon-reload',closable:true"
				style="padding: 20px; display: none;">tab3</div>

		</div>


	</div>

</body>

</html>