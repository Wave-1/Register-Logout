<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-4">

	<!-- Tiêu đề + Thanh công cụ -->
	<div class="d-flex justify-content-between align-items-center mb-4">
		<h2 class="fw-bold">Danh sách Category</h2>

		<!-- Form tìm kiếm -->
		<form class="d-flex"
			action="${pageContext.request.contextPath}/admin/categories"
			method="get">
			<input class="form-control me-2" type="search" name="keyword"
				placeholder="Tìm theo tên..." value="${param.keyword}">
			<button class="btn btn-outline-primary" type="submit">Tìm</button>
		</form>

		<!-- Nút thêm -->
		<a href="${pageContext.request.contextPath}/admin/category/add"
			class="btn btn-primary ms-3">+ Thêm Category</a>
	</div>

	<!-- Bảng danh sách -->
	<table
		class="table table-bordered table-hover align-middle text-center">
		<thead class="table-dark">
			<tr>
				<th>#</th>
				<th>Tên</th>
				<th>Icon</th>
				<th>Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listcate}" var="cate" varStatus="loop">
				<tr>
					<td>${loop.index + 1}</td>
					<td>${cate.name}</td>
					<td><img alt="icon"
						src="${pageContext.request.contextPath}/image/${cate.images}"
						class="img-thumbnail"
						style="width: 100px; height: 100px; object-fit: cover;" /></td>
					<td><a
						href="<c:url value='/admin/edit-category?id=${cate.id}'/>"
						class="btn btn-sm btn-warning">Sửa</a> <a
						href="${pageContext.request.contextPath}/admin/delete-category?id=${cate.id}"
						class="btn btn-danger btn-sm"
						onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">
							Xóa </a></td>
				</tr>
			</c:forEach>

			<!-- Nếu danh sách trống -->
			<c:if test="${empty listcate}">
				<tr>
					<td colspan="4" class="text-muted">Không có danh mục nào.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
