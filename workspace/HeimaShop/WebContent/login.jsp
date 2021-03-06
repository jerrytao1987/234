<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
.error{
	color:red;
}
#checkCodeImg{
	cursor:pointer;
}
</style>
<script type="text/javascript">
	$.validator.addMethod(
			"checkCode",
			function(value,element,params){
				var isRight=false;
				$.ajax({
					"async":false,
					/* "url":"${pageContext.request.contextPath}/checkCode", */
					"url":"${pageContext.request.contextPath}/user?method=checkCode",
					"data":{"checkCode":value},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						isRight = data.isRight;
					}
					
				});
				return isRight;
			}
	);
	$(function(){
		$("#userForm").validate({
			rules:{
				username:{
					required:true
				},
				password:{
					required:true
				},
				checkCode:{
					required:true,
					checkCode:true
				}
				
			},
			messages:{
				username:{
					required:"用户名不能为空"
				},
				password:{
					required:"密码不能为空"
				},
				checkCode:{
					required:"验证码不能为空",
					checkCode:"验证码不正确，请重新输入"
				}
				
			}
		});
	});
	
	function changeImg(obj){
		obj.src="${pageContext.request.contextPath }/checkImg?time="+new Date().getTime();
	}
</script>
</head>
<body>
	<% 
	if(request.getSession().getAttribute("user")!=null){
		response.sendRedirect(request.getContextPath());
	}
	%>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="container"
		style="width: 100%; height: 460px; background: #FF2C4C url('images/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font>USER LOGIN
					<div><span style="color:red;">${loginInfo }</span></div>
					<form class="form-horizontal" action="${pageContext.request.contextPath }/user?method=login" method="post" id="userForm">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username" name="username"
									placeholder="请输入用户名" value="${cookie.username.value }">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3" name="password"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword4" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="inputPassword4" name="checkCode"
									placeholder="请输入验证码">
							</div>
							<div class="col-sm-3">
								<img id="checkCodeImg" src="${pageContext.request.contextPath }/checkImg" onclick="changeImg(this);" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="autoLogin" value="autoLogin"> 自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox" name="rememberUsername" value="rememberUsername"> 记住用户名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>