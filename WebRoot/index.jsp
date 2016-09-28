<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/user/login/lkk-zft">登录</a>
	<form action="/user/regedist">
		<input name="user.name" type="text">
 		<input name="user.age" type="text">
 		<input value="提交" type="submit">
	</form>
	<hr/>
	<form action="/user/submit" enctype="multipart/form-data" method="post">
		<input name="file" type="file"><br/>
 		<input value="提交" type="submit">
	</form>
	<hr/>
	<a href="/user/download">下载</a><br/>
	${sessionScope.lkk}
</body>
</html>