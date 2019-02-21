<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/el/form2.jsp" method="post">
		<input type="text" name="username" /><br/>
		<input type="password" name="password" /><br/>
		<input type="checkbox" name="hobby" value="zq" />足球<br/>
		<input type="checkbox" name="hobby" value="pq" />排球<br/>
		<input type="checkbox" name="hobby" value="ppq" />乒乓球<br/>
		<input type="submit" value="提交" /><br/>
	</form>
</body>
</html>