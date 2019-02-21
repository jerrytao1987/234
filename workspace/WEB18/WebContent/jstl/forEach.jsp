<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cn.itcast.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<String> strList = new ArrayList<String>();
		strList.add("itcast");
		strList.add("itheima");
		strList.add("boxuegu");
		strList.add("shandingyu");
		request.setAttribute("strList", strList);
		
		List<User> userlist=new ArrayList<User>();
		User user1=new User();
		user1.setId(2);
		user1.setName("lisi");
		user1.setPassword("123");
		userlist.add(user1);
		User user2=new User();
		user2.setId(3);
		user2.setName("wangwu");
		user2.setPassword("123");
		userlist.add(user2);
		application.setAttribute("list", userlist);
		
		Map<String,String> strMap=new HashMap<String,String>();
		strMap.put("name", "lucy");
		strMap.put("age", "18");
		strMap.put("addr", "西三旗");
		strMap.put("email", "lucy@itcast.cn");
		session.setAttribute("strMap", strMap);
		
		Map<String,User> userMap=new HashMap<String,User>();
		userMap.put("user1",user1);
		userMap.put("user2",user2);
		request.setAttribute("userMap", userMap);
	%>
	<h1>取出strList的数据</h1>
	<c:forEach items="${strList }" var="str">
		${str }<br/>
	</c:forEach>
	
	<h1>取出userList的数据</h1>
	<c:forEach items="${userlist }" var="user">
		user的name:${user.name }--------user的password:${user.password }<br/>
	</c:forEach>
	<h1>取出strMap的数据</h1>
	<c:forEach items="${strMap }" var="entry">
		${entry.key }=======${entry.value }<br/>
	</c:forEach>
	<h1>取出userMap的数据</h1>
	<c:forEach items="${userMap }" var="entry">
		${entry.key }:${entry.value.name }--------${entry.value.password }<br/>
	</c:forEach>
</body>
</html>