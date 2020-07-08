<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<style>
    .pagination {
        border-radius: 0;
        clear: both;
        display: block;
        margin-bottom: 0;
        text-align: center;
        width: 100%;
    }
    .pagination ul {
        display: inline-block;
        list-style: outside none none;
        margin: 0;
    }
    .pagination ul li {
        display: block;
        float: left;
        margin: 0 5px;
    }
    .pagination ul li a, .pagination ul li span {
        border: 1px solid #c49b63;
        background: transparent none repeat scroll 0 0;
        color: #c49b63;
        display: block;
        font-weight: 600;
        height: 30px;
        line-height: 30px;
        width: 30px;
    }
    .pagination ul li a i {
        font-size: 24px;
        line-height: 30px;
    }
    .pagination ul li span{}
    .pagination ul li.active{}
    .pagination ul li.active span, .pagination ul li a:hover {
        background: #c49b63 none repeat scroll 0 0;
        color: #fff;
    }
</style>
<section class="home-slider owl-carousel">

    <div class="slider-item" style="background-image: url(outside/assets/images/bg_3.jpg);"
         data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text justify-content-center align-items-center">

                <div class="col-md-7 col-sm-12 text-center ftco-animate">
                    <h1 class="mb-3 mt-5 bread">Order Online</h1>
                    <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Shop</span></p>
                </div>

            </div>
        </div>
    </div>
</section>
<div class="ftco-section">
    <div class="row">
        <c:forEach var="product" items="${requestScope.products}" begin="${requestScope.start}" end="${requestScope.end}">
            <div class="col-md-3">
                <div class="menu-entry">
                    <a href="product-single?id=${product.id}" class="img"
                       style="background-image: url(${product.thumbnail});"></a>
                    <div class="text text-center pt-4">
                        <h3><a href="product-single?id=${product.id}">${product.name}</a></h3>
                        <p>${product.description}</p>
                        <p class="price"><span>$${product.price}</span></p>
                        <p><a href="add-cart?id=${product.id}&quantity=1" class="btn btn-primary btn-outline-primary">Add
                            to Cart</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="pagination">
        <ul>
            <c:if test="${requestScope.currentPage != 1}">
                <li><a href="shop?page=${requestScope.currentPage - 1}&categoryId=${requestScope.categoryId}"><i class="fa fa-angle-left"></i></a></li>
            </c:if>
            <c:forEach begin="1" end="${requestScope.noOfPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.currentPage == i}">
                        <li class="active"><span>${i}</span></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="shop?page=${i}&categoryId=${requestScope.categoryId}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${requestScope.currentPage < requestScope.noOfPages}">
                <li><a href="shop?page=${requestScope.currentPage + 1}&categoryId=${requestScope.categoryId}"><i class="fa fa-angle-right"></i></a></li>
            </c:if>
        </ul>
    </div>
</div>
<!--================Category Product Area =================-->
<section class="cat_product_area section_padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="left_sidebar_area">
                    <aside class="left_widgets p_filter_widgets">
                        <div class="l_w_title">
                            <h3>Browse Categories</h3>
                        </div>
                        <div class="widgets_inner">
                            <div class="nav ftco-animate justify-content-center" id="v-pills-tab" role="tablist">
                                <ul class="list">
                                    <c:forEach var="category" items="${requestScope.categories}">
                                    <li>
                                        <a class="nav-link " id="v-pills-${category.id}-tab" data-toggle="pill"
                                           href="#v-pills-${category.id}"
                                           role="tab" aria-controls="v-pills-0"
                                           aria-selected="${category.id == 1 ? "true" : "false"}">${category.name}</a>


                                    </li>
                                    </c:forEach>

                                </ul>
                            </div>
                        </div>
                    </aside>
                    <aside class="left_widgets p_filter_widgets price_rangs_aside">
                        <div class="l_w_title">
                            <h3>Price Filter</h3>
                        </div>
                        <div class="widgets_inner">
                            <div class="range_item">
                                <!-- <div id="slider-range"></div> -->
                                <input type="text" class="js-range-slider" value=""/>
                                <div class="d-flex">
                                    <div class="price_text">
                                        <p>Price :</p>
                                    </div>
                                    <div class="price_value d-flex justify-content-center">
                                        <input type="text" class="js-input-from" id="amount1" readonly/>
                                        <span>to</span>
                                        <input type="text" class="js-input-to" id="amount2" readonly/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </aside>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="row">
                    <div class="col-lg-12" style="margin-bottom: 5%;">
                        <div class="product_top_bar d-flex justify-content-between align-items-center">

                            <div class="single_product_menu d-flex">
                                <h5>short by : </h5>
                                <select>
                                    <option data-display="Select">name</option>
                                    <option value="1">price</option>
                                    <option value="2">product</option>
                                </select>
                            </div>


                            <div class="single_product_menu d-flex">
                                <div class="input-group" style="float: right;">
                                    <input type="text" class="form-control" placeholder="search"
                                           aria-describedby="inputGroupPrepend">
                                    <div class="input-group-prepend">
                                            <span class="input-group-text" id="inputGroupPrepend"><i
                                                    class="ti-search"></i></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                        <div class="tab-content ftco-animate" id="v-pills-tabContent">
                            <c:forEach var="category" items="${requestScope.categories}">
                                <div class="tab-pane fade ${category.id == 1 ? " show active" : ""}" id="v-pills-${category.id}" role="tabpanel"
                                     aria-labelledby="v-pills-${category.id}-tab">
                                    <div class="row">
                                        <c:forEach var="product" items="${category.productList}">
                                            <div class="col-md-3">
                                                <div class="menu-entry">
                                                    <a href="product-single?id=${product.id}" class="img"
                                                       style="background-image: url(${product.thumbnail});"></a>
                                                    <div class="text text-center pt-4">
                                                        <h3><a href="product-single?id=${product.id}">${product.name}</a></h3>
                                                        <p>${product.description}</p>
                                                        <p class="price"><span>$${product.price}</span></p>
                                                        <p><a href="add-cart?id=${product.id}&quantity=1" class="btn btn-primary btn-outline-primary">Add
                                                            to Cart</a></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
        </div>


    </div>
</section>
<!--================End Category Product Area =================-->
<%--<section class="ftco-menu mb-5 pb-5">--%>
<%--    <div class="container">--%>
<%--        <div class="row d-md-flex">--%>
<%--            <div class="col-lg-12 ftco-animate p-md-5">--%>
<%--                <div class="row">--%>
<%--                    <div class="col-md-3 av-link-wrap">--%>
<%--                        <div class="left_sidebar_area">--%>
<%--                            <aside class="left_widgets p_filter_widgets">--%>
<%--                                <div class="l_w_title">--%>
<%--                                    <h3>Browse Categories</h3>--%>
<%--                                </div>--%>
<%--                                <div class="widgets_inner">--%>
<%--                                    <div class="nav ftco-animate nav-pills justify-content-center" id="v-pills-tab" role="tablist"--%>
<%--                                         >--%>
<%--                                        <c:forEach var="category" items="${requestScope.categories}">--%>
<%--                                    <ul class="list">--%>

<%--                                        <li >--%>

<%--                                                <a class="nav-link " id="v-pills-${category.id}-tab" data-toggle="pill" href="#v-pills-${category.id}"--%>
<%--                                                   role="tab" aria-controls="v-pills-0" aria-selected="${category.id == 1 ? "true" : "false"}">${category.name}</a>--%>

<%--                                        </li>--%>


<%--                                    </ul>--%>
<%--                                        </c:forEach>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </aside>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                                <div class="col-md-3 nav-link-wrap mb-5">--%>
<%--                        <div class="nav ftco-animate nav-pills justify-content-center" id="v-pills-tab" role="tablist"--%>
<%--                             aria-orientation="vertical">--%>
<%--                            <ul>--%>
<%--                                <li >--%>
<%--                                    <c:forEach var="category" items="${requestScope.categories}">--%>
<%--                                        <a class="nav-link ${category.id == 1 ? " active" : ""}" id="v-pills-${category.id}-tab" data-toggle="pill" href="#v-pills-${category.id}"--%>
<%--                                           role="tab" aria-controls="v-pills-0" aria-selected="${category.id == 1 ? "true" : "false"}">${category.name}</a>--%>
<%--                                    </c:forEach>--%>
<%--                                </li>--%>
<%--                            </ul>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-9 d-flex align-items-center">--%>

<%--                        <div class="tab-content ftco-animate" id="v-pills-tabContent">--%>
<%--                            <div class="row">--%>
<%--                                <c:forEach var="products" items="${requestScope.products}">--%>

<%--                                       <div class="col-md-3">--%>
<%--                                        <div class="menu-entry">--%>
<%--                                            <a href="product-single?id=${products.id}" class="img"--%>
<%--                                               style="background-image: url(${products.thumbnail});"></a>--%>
<%--                                            <div class="text text-center pt-4">--%>
<%--                                                <h3><a href="product-single?id=${products.id}">${products.name}</a></h3>--%>
<%--                                                <p>${products.description}</p>--%>
<%--                                                <p class="price"><span>$${products.price}</span></p>--%>
<%--                                                <p><a href="cart" class="btn btn-primary btn-outline-primary">Add--%>
<%--                                                    to Cart</a></p>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>

<%--                                                                                      --%>
<%--                                    </div>--%>
<%--                                </c:forEach>--%>

<%--                                <c:forEach var="category" items="${requestScope.categories}">--%>
<%--                                    <div class="tab-pane fade ${category.id == 1 ? " show active" : ""}" id="v-pills-${category.id}" role="tabpanel"--%>
<%--                                         aria-labelledby="v-pills-${category.id}-tab">--%>
<%--                                        <div class="row">--%>
<%--                                            <c:forEach var="product" items="${category.productList}">--%>
<%--                                                <div class="col-md-3">--%>
<%--                                                    <div class="menu-entry">--%>
<%--                                                        <a href="product-single?id=${product.id}" class="img"--%>
<%--                                                           style="background-image: url(${product.thumbnail});"></a>--%>
<%--                                                        <div class="text text-center pt-4">--%>
<%--                                                            <h3><a href="product-single?id=${product.id}">${product.name}</a></h3>--%>
<%--                                                            <p>${product.description}</p>--%>
<%--                                                            <p class="price"><span>$${product.price}</span></p>--%>
<%--                                                            <p><a href="cart" class="btn btn-primary btn-outline-primary">Add--%>
<%--                                                                to Cart</a></p>--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </c:forEach>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </c:forEach>--%>
<%--                            </div>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
</body>