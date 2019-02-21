<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('li.item-a').parentsUntil('.item-ii').css('background-color', 'red');
	});
</script>
</head>
<body>
	<ul class="level-1">
		<li class="item-i">I</li>
		<li class="item-ii">II
			<ul class="level-2">
				<li class="item-a">A</li>
				<li class="item-b">B
					<ul class="level-3">
						<li class="item-1">1</li>
						<li class="item-2">2</li>
						<li class="item-3">3</li>
					</ul>
				</li>
				<li class="item-c">C</li>
			</ul>
		</li>
		<li class="item-iii">III</li>
	</ul>
</body>
</html>