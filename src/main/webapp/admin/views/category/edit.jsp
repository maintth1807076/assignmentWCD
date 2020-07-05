<body>
<div class="row">
    <div class="col-md-8 container">
        <div class="card">
            <div class="card-header card-header-primary">
                <h4 class="card-title">Add Category</h4>
                <p class="card-category"></p>
            </div>
            <div class="card-body">
                <form method="post" action="admin-editCategory">
                    <input type="hidden" name="id" value="${requestScope.category.id}">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="bmd-label-floating">Name</label>
                                <input name="name" type="text" class="form-control" value="${requestScope.category.name}"/>
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

