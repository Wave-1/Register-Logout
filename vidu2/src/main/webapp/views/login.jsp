<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body class="bg-light d-flex justify-content-center align-items-center" style="height:100vh;">

    <div class="card shadow-lg p-4" style="width: 400px;">
        <h2 class="text-center mb-4">Đăng nhập</h2>

        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>

        <form action="login" method="post">
            <!-- Username -->
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" name="username" placeholder="Tài khoản" required>
            </div>

            <!-- Password -->
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
            </div>

            <!-- Submit -->
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
            </div>

            <!-- Register link -->
            <p class="mt-3 text-center">
                Chưa có tài khoản? 
                <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
            </p>
        </form>
    </div>

    <!-- Bootstrap 5 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
