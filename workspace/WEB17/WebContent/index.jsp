<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" session="true" errorPage="/error.jsp"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://" prefix="c" %> --%>
<%-- <%@ taglib uri="http://" prefix="fmt" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 使用C库的标签 -->
	<!-- <c.if></c.if>
	<fmt.if></fmt.if> -->

	<%@include file="/demo.jsp" %>
<!-- html注释 -->
	<%	//java注释
		int i=0;
		System.out.println(i);
		session.setAttribute("name", "zhangsan");
		int j=i/0;
		List list = new ArrayList();
	%>
	<%--jsp注释 --%>
	<%=i %>
	<%!
		String str = "你好 china!";
		public void fn(){
			int j=0;
			System.out.println(j);
		}
	%>
	<%=str %>
</body>
</html>