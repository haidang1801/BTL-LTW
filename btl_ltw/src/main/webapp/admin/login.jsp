<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="resources/css/style.css" />
</head>

<body>
	<div>
		<div id="login-form" class="container center _80pc login-panel">
			<img class="center" src="resources/img/logo.png"
				style="width: 30%; margin-left: 35%; margin-bottom: 15px;" />
			<h3 class="center form-header">Đăng nhập hệ thống</h3>
			<h4 class="center form-header">Hệ thống quản lý bán hàng</h4>
			<form class="center " method="post" action="/btl_ltw/admin/login">
				<div class="form-label">
					<img class="form-label-icon" src="resources/img/usericon.png">
					<label class="form-label-text">Tên đăng nhập:</label>
				</div>
				<input type="text" name="username">
				<div class="form-label">
					<img class="form-label-icon" src="resources/img/passicon.png">
					<label class="form-label-text">Mật khẩu:</label>
				</div>
				<input type="password" name="password"> <br />

				<%
				String error = (String) request.getSession().getAttribute("error");
				if (error != null) {
				%>

				<p style="color: red; font-size: 15px;"><%=error%></p>
				<%
				request.getSession().removeAttribute("error");
				}
				%>

				<button class="btn1 right" type="submit">Đăng nhập</button>
			</form>
		</div>
	</div>
</body>

</html>