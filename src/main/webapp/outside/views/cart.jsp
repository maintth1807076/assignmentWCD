<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<body>
<section class="home-slider owl-carousel">

    <div class="slider-item" style="background-image: url(outside/assets/images/bg_3.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text justify-content-center align-items-center">

                <div class="col-md-7 col-sm-12 text-center ftco-animate">
                    <h1 class="mb-3 mt-5 bread">Cart</h1>
                    <p class="breadcrumbs"><span class="mr-2"><a href="home">Home</a></span> <span>Cart</span></p>
                </div>

            </div>
        </div>
    </div>
</section>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cartItem" items="${requestScope.cart.values()}">
                            <tr class="text-center">
                                <form id="remove-${cartItem.id}" action="remove-cart" method="post">
                                    <input name="id" type="hidden" value="${cartItem.id}">
                                </form>
                                <td class="product-remove"><a href="javascript:document.getElementById('remove-${cartItem.id}').submit()"><span class="icon-close"></span></a></td>

                                <td class="image-prod">
                                    <div class="img" style="background-image:url(${cartItem.thumbnail});"></div>
                                </td>

                                <td class="product-name">
                                    <h3>${cartItem.name}</h3>
                                    <p>Far far away, behind the word mountains, far from the countries</p>
                                </td>

                                <td class="price">$${cartItem.unitPrice}</td>

                                <td class="quantity">
                                    <div class="input-group mb-3">
                                        <form id="update-${cartItem.id}" action="update-cart" method="post">
                                            <input name="quantity" type="text" name="quantity" class="quantity form-control input-number"
                                                   value="${cartItem.quantity}" min="1" max="100">
                                            <input type="hidden" name="id" value="${cartItem.id}">
                                        </form>

                                    </div>
                                </td>

                                <td class="total">$${cartItem.quantity * cartItem.unitPrice}</td>
                                <td><a href="javascript:document.getElementById('update-${cartItem.id}').submit()">Update</a></td>
                            </tr><!-- END TR-->
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row justify-content-end">
            <div class="col col-lg-3 col-md-6 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Cart Totals</h3>
<%--                    <p class="d-flex">--%>
<%--                        <span>Subtotal</span>--%>
<%--                        <span>$20.60</span>--%>
<%--                    </p>--%>
<%--                    <p class="d-flex">--%>
<%--                        <span>Delivery</span>--%>
<%--                        <span>$0.00</span>--%>
<%--                    </p>--%>
<%--                    <p class="d-flex">--%>
<%--                        <span>Discount</span>--%>
<%--                        <span>$3.00</span>--%>
<%--                    </p>--%>
                    <hr>
                    <p class="d-flex total-price">
                        <span>Total</span>
                        <span>$
                            <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.totalPrice}" />
                        </span>
                    </p>
                </div>
                <p class="text-center"><a href="checkout" class="btn btn-primary py-3 px-4">Proceed to Checkout</a>
                </p>
            </div>
        </div>
    </div>
</section>

</body>