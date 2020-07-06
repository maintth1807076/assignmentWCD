<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<section class="home-slider owl-carousel">

    <div class="slider-item" style="background-image: url(outside/assets/images/bg_3.jpg);" data-stellar-background-ratio="0.5">
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


<section class="ftco-menu mb-5 pb-5">
    <div class="container">
        <div class="row d-md-flex">
            <div class="col-lg-12 ftco-animate p-md-5">
                <div class="row">
                    <div class="col-md-12 nav-link-wrap mb-5">
                        <div class="nav ftco-animate nav-pills justify-content-center" id="v-pills-tab" role="tablist"
                             aria-orientation="vertical">
                            <c:forEach var="category" items="${requestScope.categories}">
                                <a class="nav-link ${category.id == 1 ? " active" : ""}" id="v-pills-${category.id}-tab" data-toggle="pill" href="#v-pills-${category.id}"
                                   role="tab" aria-controls="v-pills-0" aria-selected="${category.id == 1 ? "true" : "false"}">${category.name}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-12 d-flex align-items-center">

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
                                                        <p><a href="cart" class="btn btn-primary btn-outline-primary">Add
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
        </div>
    </div>
</section>
</body>