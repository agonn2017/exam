<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h3{
		width: 200px;
		margin: 0 auto;
	}
	
</style>
</head>
<body>
	<h3>论文管理系统</h3>
	<div>
		<form action="doLogin" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="userCode"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="text" name="userPassword"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="登录"/>
					<input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>