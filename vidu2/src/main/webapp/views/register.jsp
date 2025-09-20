<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo tài khoản mới</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<div class="card shadow p-4">
					<h2 class="text-center mb-4">Tạo tài khoản mới</h2>

					<c:if test="${alert != null}">
						<div class="alert alert-danger text-center">${alert}</div>
					</c:if>

					<form action="register" method="post" class="row g-3">

						<div class="col-md-6">
							<label class="form-label">Họ và tên</label> <input type="text"
								name="fullname" class="form-control" placeholder="Họ và tên"
								required>
						</div>

						<div class="col-md-6">
							<label class="form-label">Email</label> <input type="email"
								name="email" class="form-control" placeholder="Email" required>
						</div>

						<div class="col-md-6">
							<label class="form-label">Tài khoản (username)</label> <input
								type="text" name="username" class="form-control"
								placeholder="Tên đăng nhập" required>
						</div>

						<div class="col-md-6">
							<label class="form-label">Mật khẩu</label> <input type="password"
								name="password" class="form-control" placeholder="Mật khẩu"
								required>
						</div>

						<div class="col-md-6">
							<label class="form-label">Ảnh đại diện (URL)</label> <input
								type="text" name="avatar" class="form-control"
								placeholder="Link ảnh">
						</div>

						<div class="col-md-6">
							<label class="form-label">Vai trò (roleid)</label> <input
								type="number" name="roleid" class="form-control"
								placeholder="1=Admin, 2=User">
						</div>

						<div class="col-md-6">
							<label class="form-label">Số điện thoại</label> <input
								type="text" name="phone" class="form-control"
								placeholder="Số điện thoại">
						</div>

						<div class="col-md-6">
							<label class="form-label">Ngày tạo</label> <input type="date"
								name="createdDate" class="form-control"
								value="<%=new java.sql.Date(System.currentTimeMillis()).toString()%>"
								readonly>
						</div>

						<div class="col-12 d-grid">
							<button type="submit" class="btn btn-primary btn-lg">Đăng
								ký</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
