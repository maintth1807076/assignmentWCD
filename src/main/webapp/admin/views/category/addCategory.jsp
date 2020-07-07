<%@ page import="com.heleyquin.model.Category" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%
    Category old = (Category) request.getAttribute("old");
    if (old == null) {
        old = new Category();
    }
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<body>
<div class="row">
    <div class="col-md-8 container">
        <div class="card">
            <div class="card-header card-header-primary">
                <h4 class="card-title">Add Category</h4>
                <p class="card-category"></p>
            </div>
            <div class="card-body">
                <form id="addCategory" method="post" action="admin-addCategory">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="bmd-label-floating">Name</label>
                                <input name="name" type="text" class="form-control"
                                       value="<%= old.getName() != null ? old.getName() : ""%>" required/>
                                <%
                                    if (errors.get("name") != null) {
                                %>
                                <small class="form-text text-danger"><%= errors.get("name")%></small>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <button id="add-category" type="submit" class="btn btn-primary pull-right">Add</button>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $('#add-category').click(function () {
            $("#addCategory").validate({
                rules: {
                    name: "required",
                },
                messages: {
                    name: "Vui lòng nhập tên Category",
                }
            });
        })
    });
</script>
</body>
