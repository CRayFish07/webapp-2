<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>保存数据</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
</head>
<body>
	
	<form action="${ctx}/save.do" method="post">
		userName: <input name="username" type="text"><br/>
		password:<input name="password" type="password"><br/>
		age:<input name="age" type="text"><br/>
		address<input name="address" type="text"><br/>
		<input type="submit" value="submit">
	</form>
	
</body>
</html>