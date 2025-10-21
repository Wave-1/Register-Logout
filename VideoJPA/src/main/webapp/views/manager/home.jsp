<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!--=== Product Content ===-->
<div class="container-fluid content-md">

    <!-- Danh sách video -->
    <ul class="list-inline owl-slider-v2">
        <c:forEach items="${videos}" var="p">
            <c:url value="/image?fname=videos/${p.poster != null ? p.poster : 'images/video.png'}" var="imgUrl" />

            <li class="item">
                <div class="product-img">
                    <a href="/video/detail?videoId=${p.videoId}">
                        <img width="100%" height="249px" src="${imgUrl}" alt="${p.title}" />
                    </a>

                    <a class="product-review" 
                       href="/video/detail?videoId=${p.videoId}&category=${p.category != null ? p.category.id : 0}">
                        Xem trước
                    </a>

                    <a class="add-to-cart"
                       href="<c:url value='/member/cart-add?pId=${p.videoId}&quantity=1' />">
                        <i class="fa fa-shopping-cart"></i> Thêm vào giỏ
                    </a>

                    <div class="shop-rgba-red rgba-banner">Nổi bật</div>
                </div>

                <div class="product-description product-description-brd">
                    <div class="overflow-h margin-bottom-5">
                        <div class="pull-left">
                            <h5>
                                <a href="/video/detail?videoId=${p.videoId}&category=${p.category != null ? p.category.id : 0}">
                                    ${p.title}
                                </a>
                            </h5>

                            <h5>
                                <span class="gender text-uppercase">
                                    ${p.category != null ? p.category.name : 'Không có danh mục'}
                                </span>
                            </h5>

                            <h5><span class="gender">Đã xem: ${p.views}</span></h5>
                        </div>
                    </div>

                    <ul class="list-inline product-ratings">
                        <li>
                            <a data-toggle="tooltip" data-placement="right" title="Share Video"
                               href="/shareVideo?videoId=${p.videoId}">
                                <i class="rating-selected fa fa-star"></i> Share
                            </a>
                        </li>

                        <li class="like-icon">
                            <a data-toggle="tooltip" data-placement="left" title="Add to wishlist"
                               href="/likeVideo?videoId=${p.videoId}&username=${sessionScope.acc.username}">
                                <i class="fa fa-heart"></i> ${p.views}
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<!--=== End Product Content ===-->


<!--=== Danh mục sản phẩm ===-->
<div class="heading heading-v1 margin-bottom-20">
    <h2>DANH MỤC</h2>
    <p>Nơi cung cấp những danh mục theo sản phẩm</p>
</div>

<div class="illustration-v2 margin-bottom-60">
    <ul class="list-inline owl-slider-v2">
        <c:forEach var="item" items="${categorys}">
            <c:url var="editURL" value="/product/list">
                <c:param name="CategoryID" value="${item.id}" />
            </c:url>

            <c:url value="/image?fname=category/${item.images}" var="imgUrl" />

            <li class="item">
                <div class="overflow-h margin-bottom-5">
                    <a href="${editURL}&index1=-2">
                        <img width="100%" height="80px" src="${imgUrl}" alt="${item.name}" />
                    </a>

                    <div class="shop-rgba-red rgba-banner">
                        ${count.get(item)} VIDEO
                    </div>

                    <div class="pull-center">
                        <h5><span class="gender text-uppercase">${item.name}</span></h5>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<!--=== End Danh mục ===-->
