<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="page-content-wrapper">
    <div class="page-content">
        <div class="row">
            <div class="col-md-12">

                <!-- BEGIN EXAMPLE TABLE PORTLET -->
                <div class="portlet box grey-cascade">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="fa fa-globe"></i> Quản lý Category
                        </div>
                        <div class="tools">
                            <a href="javascript:;" class="collapse"> </a>
                            <a href="#portlet-config" data-toggle="modal" class="config"> </a>
                            <a href="javascript:;" class="reload"> </a>
                            <a href="javascript:;" class="remove"> </a>
                        </div>
                    </div>

                    <div class="portlet-body">
                        <div class="table-toolbar">

                            <!-- Thông báo -->
                            <div class="row">
                                <div class="col">
                                    <c:if test="${not empty message}">
                                        <div class="alert alert-success">${message}</div>
                                    </c:if>
                                    <c:if test="${not empty error}">
                                        <div class="alert alert-danger">${error}</div>
                                    </c:if>
                                </div>
                            </div>

                            <div class="row">
                                <!-- Form CRUD -->
                                <div class="col-md-3">
                                    <div class="row">
                                        <div class="col-md-9">
                                            <form action="#" method="post" enctype="multipart/form-data">
                                                <br />

                                                <div class="form-group" hidden="hidden">
                                                    <label for="id">Category ID:</label>
                                                    <input type="text" name="id" value="${category.id}" id="id"
                                                        class="form-control" readonly />
                                                </div>

                                                <div class="form-group">
                                                    <label for="name">Category Name:</label>
                                                    <input type="text" class="form-control" name="name" id="name"
                                                        value="${category.name}" />
                                                </div>

                                                <div class="form-group">
                                                    <label for="code">Category Code:</label>
                                                    <input type="text" class="form-control" name="code" id="code"
                                                        value="${category.code}" />
                                                </div>

                                                <div class="form-group">
                                                    <label for="images">Images:</label>
                                                    <input type="file" class="form-control" name="images" id="images"
                                                        value="${category.images}" />
                                                </div>

                                                <div class="form-check form-check-inline">
                                                    <label for="status">Status:</label><br>
                                                    <input id="statuson" class="form-check-input" type="radio"
                                                        name="status" value="1"
                                                        ${category.status == 1 ? 'checked' : ''}>
                                                    <label for="statuson" class="form-check-label">Hoạt động</label><br>

                                                    <input id="statusoff" class="form-check-input" type="radio"
                                                        name="status" value="0"
                                                        ${category.status == 0 ? 'checked' : ''}>
                                                    <label for="statusoff" class="form-check-label">Khóa</label>
                                                </div>

                                                <br /><hr>

                                                <div class="form-group">
                                                    <button class="btn green" formaction="<c:url value='/admin-category/create'/>">
                                                        Create <i class="fa fa-plus"></i>
                                                    </button>

                                                    <button class="btn btn-warning" formaction="<c:url value='/admin-category/update'/>">
                                                        Update <i class="fa fa-edit"></i>
                                                    </button>

                                                    <br /><br />

                                                    <button class="btn btn-danger" formaction="<c:url value='/admin-category/delete'/>">
                                                        Delete <i class="fa fa-trash"></i>
                                                    </button>

                                                    <button class="btn btn-success" formaction="<c:url value='/admin-category/reset'/>">
                                                        Reset <i class="fa fa-undo"></i>
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <!-- Danh sách category -->
                                <div class="col-md-9" style="padding-right: 25px">
                                    <div class="row">
                                        <div class="col-md-6"></div>
                                        <div class="col-md-6">
                                            <div class="btn-group pull-right">
                                                <button class="btn dropdown-toggle" data-toggle="dropdown">
                                                    Tools <i class="fa fa-angle-down"></i>
                                                </button>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#">Print</a></li>
                                                    <li><a href="#">Save as PDF</a></li>
                                                    <li><a href="#">Export to Excel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <table class="table table-striped table-bordered table-hover" id="sample_2">
                                            <thead>
                                                <tr>
                                                    <th>Ảnh đại diện</th>
                                                    <th>Tên danh mục</th>
                                                    <th>Code</th>
                                                    <th>Trạng thái</th>
                                                    <th>Hành động</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="item" items="${categorys}">
                                                    <tr class="odd gradeX">
                                                        <td>
                                                            <c:url var="imgUrl" value="/image">
                                                                <c:param name="fname"
                                                                    value="category/${item.images != null ? item.images : 'uploads/abc.jpg'}" />
                                                            </c:url>
                                                            <img width="50px" height="50px" src="${imgUrl}" />
                                                        </td>

                                                        <td>${item.name}</td>
                                                        <td>${item.code}</td>

                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${item.status == 1}">
                                                                    <span class="label label-sm label-success">Hoạt động</span>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span class="label label-sm label-warning">Khóa</span>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>

                                                        <td>
                                                            <c:url var="editUrl" value="/admin-category/edit">
                                                                <c:param name="id" value="${item.id}" />
                                                            </c:url>
                                                            <c:url var="deleteUrl" value="/admin-category/delete">
                                                                <c:param name="id" value="${item.id}" />
                                                            </c:url>

                                                            <a href="${editUrl}" class="center">Edit</a> |
                                                            <a href="${deleteUrl}" class="center">Delete</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END EXAMPLE TABLE PORTLET -->

            </div>
        </div>
    </div>
</div>
