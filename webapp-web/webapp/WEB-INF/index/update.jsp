<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询用户数据</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx }/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div>
		<c:forEach items="${users }" var="user">
		 <div>
				用户编号：${user.id }
				用户名:${user.username }
				密码：${user.password }
				年龄:${user.age }
				地址:${user.address }
			</div>
			
		</c:forEach> 
	</div>
	<br/>
	<br/>
	<form action="" method="post">
		用户编号：<input type="text" name="id" id="id">
		<input type="button" value="提交" id="button">
	</form>
	<br/>
	<br/>
	<form action="${ctx }/update.do" id="updateForm" style="display: none;" method="post">
		<input type="hidden" name="id">
		用户名：<input type="text" name="username" ><br/>
		密码: <input type="text" name="password"><br/>
		年龄:<input type="text" name="age"><br/>
		地址:<input type="text" name="address"><br/>
		<input value="提交" type="submit">
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#button").click(function(){
				var id=$("#id").val();
				if(id=="") {
					alert("error") ;
					return ;
				}
				$.post("${ctx}/selectByUserId.do",{
					"id":id
				},function(data){
					if(data.user=="error"){
						alert("error");
						return ;
					}
					$("#updateForm").show();
					$("#updateForm").find("input").eq(0).val(data.user.id);
					$("#updateForm").find("input").eq(1).val(data.user.username);
					$("#updateForm").find("input").eq(2).val(data.user.password);
					$("#updateForm").find("input").eq(3).val(data.user.age);
					$("#updateForm").find("input").eq(4).val(data.user.address);
				});
			});
		});
	</script>
</body>
</html>