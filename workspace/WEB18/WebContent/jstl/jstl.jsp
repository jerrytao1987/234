<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("count", 10);
	%>
	<c:if test="${count==10 }">
		xxxxx
	</c:if>
	<c:if test="${count==9 }">
		yyyyy
	</c:if>
	<c:forEach begin="0" end="5" var="i">
		${i }<br/>
	</c:forEach>
	<!-- items:一个集合或数组  var:代表集合中的某一个元素 -->
	<c:forEach items="${productList }" var="pro">
		${pro.pname }
	</c:forEach>
</body>
</html>