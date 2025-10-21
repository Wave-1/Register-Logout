<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="d-flex justify-content-end align-items-center bg-light p-2 border-bottom">
    <c:choose>

        <c:when test="${sessionScope.account == null}">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath }/login">
                        <i class="fa fa-sign-in-alt"></i> Đăng nhập
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath }/register">
                        <i class="fa fa-user-plus"></i> Đăng ký
                    </a>
                </li>
            </ul>
        </c:when>


        <c:otherwise>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="${pageContext.request.contextPath}/member/myaccount">
                        <i class="fa fa-user-circle"></i> ${sessionScope.account.fullName}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="${pageContext.request.contextPath }/logout">
                        <i class="fa fa-sign-out-alt"></i> Đăng Xuất
                    </a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
