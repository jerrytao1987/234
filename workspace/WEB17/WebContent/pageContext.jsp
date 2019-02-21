<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//request.setAttribute("name", "zhangsan");
		//pageContext.setAttribute("name", "sunba");
		//pageContext.setAttribute("name", "lisi", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "wangwu", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "tianqi", PageContext.APPLICATION_SCOPE);
		
	%>
	<%=request.getAttribute("name")	%>
	<%=pageContext.getAttribute("name",PageContext.REQUEST_SCOPE) %>
	<!-- findAttribute从小到大搜索域的范围中的name -->
	<%=pageContext.findAttribute("name") %>
	<%
		pageContext.getRequest();//request
		pageContext.getResponse();//response
		pageContext.getOut();//out
		pageContext.getSession();//session
		pageContext.getServletContext();//application
		pageContext.getServletConfig();//config
		pageContext.getPage();//page
		pageContext.getException();//exception
	%>
</body>
</html>