<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div class="row">
    <div class="col-md-8 container">
        <div class="card">
            <div class="card-header card-header-primary">
                <h4 class="card-title">Add Product</h4>
                <p class="card-category"></p>
            </div>
            <div class="card-body">
                <form method="post" action="/admin/product/edit">
                    <input type="hidden" name="id" value="${requestScope.product.id}">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-1">
                                        <label>Name</label>
                                    </div>
                                    <div class="col-md-11">
                                        <input value="${requestScope.product.name}" name="name" type="text" class="form-control"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-1">
                                        <label>Description</label>
                                    </div>
                                    <div class="col-md-11">
                                        <input value="${requestScope.product.description}" name="description" type="text" class="form-control"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <label>Price</label>
                                            </div>
                                            <div class="col-md-10">
                                                <input value="${requestScope.product.price}" name="price" type="number" class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <label>Thumbnail</label>
                                        </div>
                                        <div class="col-md-10">
                                            <input value="${requestScope.product.thumbnail}" name="thumbnail" type="text">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-2">
                                    <label class="bmd-label-floating">Category</label>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control" name="categoryId">
                                        <c:forEach var="category" items="${requestScope.categories}">
                                            <option ${requestScope.product.categoryId == category.id ? "selected" : ""} value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary pull-right">Update</button>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>