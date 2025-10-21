<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm danh mục mới</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

	<h2 class="text-center mb-4">Thêm Danh Mục Mới</h2>

	<div class="card shadow p-4">
		<form method="post" action="${pageContext.request.contextPath}/admin/category/add" enctype="multipart/form-data">
			<div class="mb-3">
				<label class="form-label">Tên danh mục:</label>
				<input type="text" name="name" class="form-control" placeholder="Nhập tên danh mục" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Chọn ảnh (icon):</label>
				<input type="file" name="image" class="form-control" accept="image/*">
			</div>

			<div class="d-flex justify-content-between mt-4">
				<a href="${pageContext.request.contextPath}/admin/categories" class="btn btn-secondary">
					⬅️ Quay lại
				</a>
				<button type="submit" class="btn btn-success">
					💾 Lưu danh mục
				</button>
			</div>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
