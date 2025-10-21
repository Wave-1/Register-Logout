<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!--=== Product Content ===-->

<div class="container-fluid content-md">



	<c:forEach items="${videos}" var="p">

		<%-- <c:url value="/${not empty p.poster?p.poster:'images/video.png'}" var="imgUrl"></c:url>

--%>

		<c:url
			value="/image?fname=videos/${p.poster!=null? p.poster:'images/video.png'}"
			var="imgUrl"></c:url>

		<li class="item">

			<div class="product-img">

				<a href="/product/detail?id=${p.videoId}"> <img width="100%"
					height="249px" src="${imgUrl }" alt=""></a> <a
					class="product-review"
					href="/video/detail?videoId=${p.videoId}&category=${p.category.id}">Xem
					trước</a> <a class="add-to-cart"
					href="<c:url value="/member/cart-add?pId=${p.videoId}&quantity=1"></c:url>">

					<i class="fa fa-shopping-cart"></i>Thêm vào giỏ
				</a>

				<div class="shop-rgba-red rgba-banner">Nổi bật</div>

			</div>

			<div class="product-description product-description-brd">

				<div class="overflow-h margin-bottom-5">

					<div class="pull-left">

						<h5>
							<a
								href="/video/detail?videoId=${p.videoId}&category=${p.category.id}">${p.title }</a>
						</h5>

						<h5>
							<span class="gender text-uppercase">${p.category.name }</span>
						</h5>

						<h5>
							<span class="gender">Đã xem:${p.views}</span>
						</h5>

					</div>

					<div class="product-price">

						<span class="title-price"></span> <span
							class="shop-red line-through"></span>



					</div>

				</div>

				<ul class="list-inline product-ratings">

					<li><a data-original-title="Share Video" data-toggle="tooltip"
						data-placement="right" class="tooltips"
						href="/shareVideo?videoId=${p.videoId}"><i
							class="rating-selected fa fa-star"></i> Share </a></li>


					<li class="like-icon"><a data-original-title="Add to wishlist"
						data-toggle="tooltip" data-placement="left" class="tooltips"
						href="/likeVideo?videoId=${p.videoId}&username=${sessionScope.acc.username}"><i
							class="fa fa-heart"></i> ${p.views} </a></li>

					<li class="like-icon"></li>

				</ul>

			</div>

		</li>

	</c:forEach>


</div>

<!--=== End Illustration v2 ===-->


<div class="heading heading-v1 margin-bottom-20">

	<h2>DANH MỤC</h2>

	<p>Nơi cung cấp những danh mục theo sản phẩm</p>

</div>

<!--=== Illustration v2 ===-->

<div class="illustration-v2 margin-bottom-60">




	<ul class="list-inline owl-slider-v2">



		<c:forEach var="item" items="${categorys}">


			<c:url var="editURL" value="/product/list">

				<c:param name="CategoryID" value="${item.id}" />

			</c:url>

			<c:url value="/image?fname=category/${item.images }" var="imgUrl"></c:url>


			<li class="item">

				<div class="overflow-h margin-bottom-5">



					<a href="${editURL}&index1=-2"> <img width="100%" height="80px"
						src="${imgUrl }" alt=""></a>

					<div class="shop-rgba-red rgba-banner">${count.get(item)}
						VIDEO</div>

					<div class="pull-center">

						<h5>
							<span class="gender text-uppercase">${item.name}</span>
						</h5>


					</div>


				</div>

			</li>




		</c:forEach>

	</ul>




</div>