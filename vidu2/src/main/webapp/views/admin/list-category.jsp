<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Category</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

    <h2 class="mb-4 text-center">Danh sách Category</h2>

    <table class="table table-bordered table-hover align-middle text-center">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Hình ảnh</th>
                <th>Tên</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cateList}" var="cate" varStatus="STT">
                <tr>
                    <td>${STT.index + 1}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/${cate.icon}"
                             class="img-thumbnail" style="width: 150px; height: 150px; object-fit: cover;"/>
                    </td>
                    <td>${cate.catename}</td>
                    <td>
                        <a href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>"
                           class="btn btn-sm btn-warning">Sửa</a>
                        <a href="<c:url value='/admin/category/delete?id=${cate.cateid}'/>"
                           class="btn btn-sm btn-danger"
                           onclick="return confirm('Bạn có chắc muốn xóa danh mục này?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
