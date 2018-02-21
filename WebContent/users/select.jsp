<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script>
	$(function(){
	
		$("[id^=add]").click(function(){
			var $url=$(this).attr("href");
			$("[name='_method']").val("post");
			//alert(123);
			$("form").attr("action",$url).submit();
			//取消超链接请求
			return false;
		});
	});
</script>
</head>
<body>
	<form action="" method="post">
		<table width="60%" cellspacing="0px" cellpadding="1px" align="center" border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>密码</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>${item.password }</td>
				<td><a href="${pageContext.request.contextPath }/user/toupdate?id=${item.id}">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/user/delete?id=${item.id}">删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align:center;">
				<a id="add_${item.id }" href="${pageContext.request.contextPath }/users/regist">添加</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>