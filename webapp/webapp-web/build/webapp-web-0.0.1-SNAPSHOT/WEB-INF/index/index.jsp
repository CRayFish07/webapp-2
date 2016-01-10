<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
</head>
<body>
	<a href="${ctx }/toSavePage.do">保存用户数据</a>
	<a href="${ctx }/toDeletePage.do">删除用户数据</a>
	<a href="${ctx }/toSelectPage.do">查询用户数据</a>
	<a href="${ctx}/toUpdatePage.do">更新用户信息</a>
	
	
</body>
</html>