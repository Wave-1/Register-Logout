<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

	<h2 class="mb-4 text-center">Chỉnh sửa Category</h2>

	<form action="${pageContext.request.contextPath}/admin/edit-category" method="post" enctype="multipart/form-data" class="card p-4">
		<input type="hidden" name="id" value="${category.id}" />

		<div class="mb-3">
			<label class="form-label">Tên Category:</label>
			<input type="text" class="form-control" name="name" value="${category.name}" required>
		</div>

		<div class="mb-3">
			<label class="form-label">Hình hiện tại:</label><br>
			<img src="${pageContext.request.contextPath}/image/${category.images}" width="150" height="150" class="img-thumbnail mb-2">
		</div>

		<div class="mb-3">
			<label class="form-label">Chọn hình mới (nếu có):</label>
			<input type="file" name="image" class="form-control">
		</div>

		<button type="submit" class="btn btn-primary">Cập nhật</button>
		<a href="${pageContext.request.contextPath}/admin/categories" class="btn btn-secondary">Quay lại</a>
	</form>

</body>
</html>
