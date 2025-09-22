<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Sửa danh mục</title>
</head>
<body>
    <h2>Chỉnh sửa danh mục</h2>
    <form action="${pageContext.request.contextPath}/admin/category/edit"
          method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${category.cateid}" />
        <div>
            <label>Tên danh mục:</label>
            <input type="text" name="name" value="${category.catename}" />
        </div>
        <div>
            <label>Ảnh đại diện:</label>
            <input type="file" name="image" />
            <c:if test="${not empty category.icon}">
                <img src="${pageContext.request.contextPath}/image/${category.icon}"
                     width="200" height="200" />
            </c:if>
        </div>
        <button type="submit">Cập nhật</button>
    </form>
</body>
</html>
