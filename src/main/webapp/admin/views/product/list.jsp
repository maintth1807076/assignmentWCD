<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        background: #fff none repeat scroll 0 0;
        color: #ab47bc;
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
        background: #ab47bc none repeat scroll 0 0;
        color: #fff;
    }
</style>
<div class="row">
    <div class="col-md-12">
        <div class="card card-plain">
            <div class="card-header card-header-primary">
                <h4 class="card-title mt-0">Product</h4>
                <p class="card-category"></p>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="">
                        <th/>
                        <th>Name</th>
                        <th>Title</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th/>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${requestScope.products}">
                            <tr>
                                <td>
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" value=""/>
                                            <span class="form-check-sign">
                                            <span class="check"></span>
                                  </span>
                                        </label>
                                    </div>
                                </td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <c:url var="imgUrl" value='../../${product.thumbnail}'/>
                                <td><img width="100px" alt="" src="${imgUrl}"/></td>
                                <td>${product.price}</td>
                                <td>${product.category.name}</td>
                                <td class="td-actions text-right">
                                    <div class="row">
                                        <div class="col-6">
                                            <c:url var="editUrl" value='/admin/product/edit?id=${product.id}'/>
                                            <span><a href="${editUrl}" class="material-icons">edit</a></span>
                                        </div>
                                        <div class="col-6">
                                            <span>
                                                <form action="admin-deleteProduct" method="post">
                                                    <input type="hidden" name="id" value="${product.id}">
                                                    <button type="submit">
                                                        <i class="material-icons">close</i>
                                                    </button>
                                                </form>
                                            </span>
                                        </div>
                                    </div>

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
<div class="pagination">
    <ul>
        <c:if test="${requestScope.currentPage != 1}">
            <li><a href="admin-listProduct?page=${requestScope.currentPage - 1}"><i class="fa fa-angle-left"></i></a></li>
        </c:if>
        <c:forEach begin="1" end="${requestScope.noOfPages}" var="i">
            <c:choose>
                <c:when test="${requestScope.currentPage == i}">
                    <li class="active"><span>${i}</span></li>
                </c:when>
                <c:otherwise>
                    <li><a href="admin-listProduct?page=${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${requestScope.currentPage < requestScope.noOfPages}">
            <li><a href="admin-listProduct?page=${requestScope.currentPage + 1}"><i class="fa fa-angle-right"></i></a></li>
        </c:if>
    </ul>
</div>