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
	hello
	<% 
		int i=0;
		System.out.println(i);
		test();
		out.println("firstline");
		response.getWriter().println("secondline");
		//pageContext.setAttribute("name", "aaa");
		//request.setAttribute("name", "bb");
		//session.setAttribute("name", "ccc");
		application.setAttribute("name", "dd");
		Object value = pageContext.findAttribute("name");
		out.println(value);
	%>
	<%!
		int j = 1;
		public void test(){
			System.out.println(j);
		}
	%>
	<%=
		j+"中国"
	%>
	${name}
	${param.name }
	${paramValues.name[0] }
	${paramValues.name[1] }
	${pageContext.request.contextPath }
	${pageContext.request.servletPath }
	${"1"+1 }
	\${'a'+1 }
	<c:forEach items="${paramValues.name }" var="item">
		${item }
	</c:forEach>
	<c:out value="hello"></c:out>
	<c:if test="${name=='dd'}">
		<c:out value="jerry"></c:out>
	</c:if>
</body>
</html>