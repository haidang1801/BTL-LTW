<%@ page import="java.util.*, servlets.admin.ServletUtil, models.dtos.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<AdminFullDetail> listAdminFullDetails = (List<AdminFullDetail>) request.getAttribute("listAdminFullDetails");
String message = (String) request.getSession().getAttribute("message");
String messageType = (String) request.getSession().getAttribute("messageType");
request.getSession().removeAttribute("message");
request.getSession().removeAttribute("messageType");
%>
<h1 id="title-page">Quản lý nhân viên</h1>
<div class="overflow">
	<table class="content-table">
		<tr>
			<th>ID</th>
			<th>Tên</th>
			<th>Email</th>
			<th>SDT</th>
			<th>CCCD</th>
			<th>Username</th>
			<th>Password</th>
			<th>Thao tác</th>
		</tr>
		<c:forEach var="adminFullDetail" items="${listAdminFullDetails}">
			<tr>
				<td>${adminFullDetail.getId()}</td>
				<td>${adminFullDetail.getName()}</td>
				<td>${adminFullDetail.getEmail()}</td>
				<td>${adminFullDetail.getPhonenum()}</td>
				<td>${adminFullDetail.getCccd()}</td>
				<td>${adminFullDetail.getUsername()}</td>
				<td>${adminFullDetail.getPassword()}</td>
				<td>
					<button onclick="showEditModal()">Sửa</button>
					<button>Xóa</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<p class="alert-<%=messageType%>">
	<%=(message != null ? message : "")%>
</p>
<button id="add-new-button" onclick="showAddModal()">Thêm mới</button>
<div id="add-modal" class="modal">
	<form method="post" action="/btl_ltw/admin/admin" id="add-form">
		<h3>Thêm nhân viên</h3>

		<div class="form-data-text">
			<p>Tên</p>
			<input name="name" placeholder="Nhập tên " id="add-name">
		</div>
		<div class="form-data-text">
			<p>Email</p>
			<input name="email" placeholder="Nhập email"  id="add-email">
		</div>
		<div class="form-data-text">
			<p>SDT</p>
			<input name="phonenum" placeholder="Nhập SDT" id="add-phonenum">
		</div>
		<div class="form-data-text">
			<p>CCCD</p>
			<input name="cccd" placeholder="Nhập cccd" id="add-cccd">
		</div>
		<div class="form-data-text">
			<p>Username</p>
			<input name="username" placeholder="Nhập username" id="add-username">
		</div>
		<div class="form-data-text">
			<p>Password</p>
			<input name="password" placeholder="Nhập username"  id="add-password">
		</div>
		
		<div class="form-data-button">
			<button type="submit">Thêm</button>
			<button type="button">Hoàn tác</button>
			<button type="button" id="add-cancel" onclick="closeAddModal()">Hủy</button>
		</div>

	</form>
</div>

<div id="edit-modal" class="modal">
	<form method="put" action="/btl_ltw/admin/admin" id="edit-form">
		<h3>Sửa danh mục</h3>

		<div class="form-data-text">
			<p>Tên</p>
			<input name="name" placeholder="Nhập tên " id="edit-name">
		</div>
		<div class="form-data-text">
			<p>Email</p>
			<input name="email" placeholder="Nhập email"  id="edit-email">
		</div>
		<div class="form-data-text">
			<p>SDT</p>
			<input name="phonenum" placeholder="Nhập SDT" id="edit-phonenum">
		</div>
		<div class="form-data-text">
			<p>CCCD</p>
			<input name="cccd" placeholder="Nhập cccd" id="edit-cccd">
		</div>
		<div class="form-data-text">
			<p>Username</p>
			<input name="username" placeholder="Nhập username" id="edit-username">
		</div>
		<div class="form-data-text">
			<p>Password</p>
			<input name="password" placeholder="Nhập username"  id="edit-password">
		</div>
		
		<div class="form-data-button">
			<button type="submit">Sửa</button>
			<button type="button">Hoàn tác</button>
			<button type="button" id="edit-cancel" onclick="closeEditModal()">Hủy</button>
		</div>

	</form>
</div>
<script src="/btl_ltw/admin/resources/js/content.js"
	type="text/javascript"></script>