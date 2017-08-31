<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>登录系统</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<style>
* {
	box-sizing: border-box;
	font-family: 微软雅黑;
}

html, body {
	height: 100%;
}

body {
	margin: 0;
	background-color: white;
	display: flex;
	justify-content: center;
	align-items: center;
}

.login {
	background-color: #fff;
	width: 340px;
	padding-top: 30px;
	border-radius: 5px;
}

.login img {
	display: block;
	width: 300px;
	margin: 0 auto;
}

p {
	text-align: center;
	margin: 10px 0;
	color: #888;
	padding-bottom: 5px;
}

form {
	padding: 0 30px 20px 30px;
}

input {
	border-radius: 5px;
	border: 5;
	height: 40px;
	width: 100%;
	margin: 5px 0;
	outline: none;
	border: 1px solid #aaa;
	padding-left: 10px;
	font-size: 14px;
}

input:focus {
	border: 1px solid green;
}

input[type=submit] {
	width: 100%;
	height: 40px;
	line-height: 40px;
	font-size: 16px;
	border: none;
	color: #fff;
	padding: 0;
	margin: 5px 0;
	cursor: pointer;
}

.error-message {
	color: #d70f18;
	margin: 3px 0;
}
</style>


</head>
<body>
 <form action="<c:url value="/admin/user/login.action"/>" method="post">
	 <div class="login">
		<img src="${pageContext.request.contextPath }/img/logo.png" alt="智游">
		<div>
			<input type="text" name="loginName" placeholder="用户名" value="admin">
		</div>
		<div>
			<input type="password" name="loginPwd" placeholder="密码" value="admin">
		</div>
		<div>
			<p style="color: red; font-size: 15px;">${errorMessage }</p>
		</div>
		<div>
			<input type="submit" value="登录" class="btn btn-success">
		</div>
	</div>
 </form>
</body>
</html>