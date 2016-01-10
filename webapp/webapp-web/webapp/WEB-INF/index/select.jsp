<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询用户数据</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx }/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<form action="${ctx }/select.do" method="post">
		用户编号：<input type="text" name="id">
		<input type="submit" value="提交">
	</form>
	<br/>
	<br/>
	<form action="" id="productForm">
		<input name="productId"  id="productId" type="text">
		<input type="button" value="点击查我" id="button">
	</form>
	<div id="imgs"></div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#button").click(function(){
				var productId=$("#productId").val();
				if(productId==null){
					alert("productId is null");
					return ;
				}
				$.post("${ctx}/selectByProductId.do",{
					"productId":productId
				},function(data){
					var list=data.list;
					for(var i=0;i<list.length;i++){
						for(var j=0;j<list[i]["rate_imgs"].length;j++)
							$("#imgs").append("<ul><img src='"+list[i]["rate_imgs"][j]+"'></ul>");
					}
				});
			});
		});
	</script>
</body>
</html>