<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/update" method="get">
		用户名:<input type="text" name="name" id="name" value="${name }">
		<label id="tip"></label>
		<br>
		<input type="hidden" name="id" id="id" value="${id }">
		密码:<input type="text" name="password" value="${password }"><br>
		<input type="submit" value="修改">
	</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$("#name").blur(function(){
		var uname=$("input[name='name']");
		console.log(uname.val());
		$.post("${pageContext.request.contextPath }/user/isExist",{uname:uname.val()},function(response){
			console.log(response.key);
			//获取后台数据
			if(response.status == 1){
				document.getElementById("tip").innerHTML="<font color='red'>"+response.key+"</font>"
			}else{
				document.getElementById("tip").innerHTML="<font color='red'>"+response.key+"</font>"
			}
		},"json");
	})
</script>
</body>

</html>