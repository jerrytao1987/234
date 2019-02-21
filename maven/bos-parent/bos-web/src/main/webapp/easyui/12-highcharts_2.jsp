<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layout</title>
</head>
<script src="${pageContext.request.contextPath }/js/highcharts/highcharts.js"></script>
<script src="${pageContext.request.contextPath }/js/highcharts/modules/exporting.js"></script>
<script src="${pageContext.request.contextPath }/js/highcharts/modules/export-data.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		Highcharts.chart('container',{
			chart: {
				type: 'bar'
			},
			title: {
				text: '堆叠条形图'
			},
			xAxis: {
				categories: ['苹果', '橘子', '梨', '葡萄', '香蕉']
			},
			yAxis: {
				min: 0,
				title: {
					text: '水果消费总量'
				}
			},
			legend: {
				/* 图例显示顺序反转
		         * 这是因为堆叠的顺序默认是反转的，可以设置 
		         * yAxis.reversedStacks = false 来达到类似的效果 
		         */
				reversed: true 
			},
			plotOptions: {
				series: {
					stacking: 'normal'
				}
			},
			series: [{
				name: '小张',
				data: [5, 3, 4, 7, 2]
			}, {
				name: '小彭',
				data: [2, 2, 3, 2, 1]
			}, {
				name: '小潘',
				data: [3, 4, 4, 2, 5]
			}]
		});
	});
</script>
<body>
<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

</body>
</html>