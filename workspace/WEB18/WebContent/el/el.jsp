<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.itcast.domain.User"%>
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
		request.setAttribute("company", "黑马程序员");
	
		User user=new User();
		user.setId(1);
		user.setName("zhangsan");
		user.setPassword("123");
		session.setAttribute("user", user);
		
		List<User> list=new ArrayList<User>();
		User user1=new User();
		user1.setId(2);
		user1.setName("lisi");
		user1.setPassword("123");
		list.add(user1);
		User user2=new User();
		user2.setId(3);
		user2.setName("wangwu");
		user2.setPassword("123");
		list.add(user2);
		application.setAttribute("list", list);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("a","helloa");
		map.put("b","hellob");
		application.setAttribute("map", map);
	%>
	<%=request.getAttribute("company") %>
	<%
		User sessionUser = (User)session.getAttribute("user");
		out.write(sessionUser.getName());
	%>
	${requestScope.company }
	${sessionScope.user.name }
	${applicationScope.list[1].name }
	${applicationScope.map['a'] }
	
	${company }
	${user.name }
	${list[1].name }
	${map['b'] }
</body>
</html>