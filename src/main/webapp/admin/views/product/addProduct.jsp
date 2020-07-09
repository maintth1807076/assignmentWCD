<%@ page import="com.heleyquin.model.Product" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
%>
<style>
    .error {
        color: red;
    }
</style>
<body>
<div class="row">
    <div class="col-md-8 container">
        <div class="card">
            <div class="card-header card-header-primary">
                <h4 class="card-title">Add Product</h4>
                <p class="card-category"></p>
            </div>
            <div class="card-body">
                <form id="addProduct" method="post" action="/admin/product/create">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-1">
                                        <label>Name</label>
                                    </div>
                                    <div class="col-md-11">
                                        <input name="name" type="text" class="form-control"/>
                                        <%
                                            if (errors != null && errors.containsKey("name")) {
                                        %>
                                        <p class="error">* <%=errors.get("name").get(0)%>
                                        </p>
                                        <%
                                            }
                                        %>
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
                                        <input name="description" type="text" class="form-control"/>
                                        <%
                                            if (errors != null && errors.containsKey("description")) {
                                        %>
                                        <p class="error">* <%=errors.get("description").get(0)%>
                                        </p>
                                        <%
                                            }
                                        %>
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
                                                <input name="price" step="0.1" type="number" class="form-control"/>
                                                <%
                                                    if (errors != null && errors.containsKey("price")) {
                                                %>
                                                <p class="error">* <%=errors.get("price").get(0)%>
                                                </p>
                                                <%
                                                    }
                                                %>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div>
                                        <img width="80px" id="thumbnail-preview">
                                    </div>
                                    <div>
                                        <button type="button" id="upload_widget" class="btn btn-primary">Upload
                                            thumbnail
                                        </button>
                                        <%
                                            if (errors != null && errors.containsKey("thumbnail")) {
                                        %>
                                        <p class="error">* <%=errors.get("thumbnail").get(0)%>
                                        </p>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <input name="thumbnail" type="hidden">
                                    <%--                                    <div class="row">--%>
                                    <%--                                        <div class="col-md-10">--%>
                                    <%--                                            --%>
                                    <%--                                        </div>--%>
                                    <%--                                        <div class="col-md-2">--%>
                                    <%--                                            --%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
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
                                            <option value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button id="add-product" type="submit" class="btn btn-primary pull-right">Add</button>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://widget.cloudinary.com/v2.0/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'kuramakyubi',
            uploadPreset: 'vzg8snty'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                var url = "https://res.cloudinary.com/kuramakyubi/image/upload/c_fill,h_500,w_500/v1593177061/" + result.info.public_id + "." + result.info.format;
                $("#thumbnail-preview").attr("src", url);
                $("input[name ='thumbnail']").val(url);
            }
        }
    )
    document.getElementById("upload_widget").addEventListener("click", function () {
        myWidget.open();
    }, false);
    $("#addProduct").validate({
        rules: {
            name: "required",
            description: "required",
            price: {
                required: true
            },
            thumbnail: "required",
        },
        messages: {
            name: "Please enter name Product",
            description: "Please enter description",
            price: {
                required: "Please enter price",
            },
            thumbnail: "Please enter thumbnail",
        }
    });
</script>
</body>
