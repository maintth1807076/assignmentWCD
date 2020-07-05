<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <div class="card card-plain">
            <div class="card-header card-header-primary">
                <h4 class="card-title mt-0">Category</h4>
                <p class="card-category"></p>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="">
                        <th/>
                        <th>Name</th>
                        <th/>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${requestScope.categories}">
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
                                <td>${category.name}</td>
                                <td class="td-actions text-right">
                                    <a href="admin-editCategory?id=${category.id}" class="material-icons">edit</a>
                                    <button type="submit" rel="tooltip" title="Remove"
                                            class="btn btn-danger btn-link btn-sm">
                                        <i class="material-icons">close</i>
                                    </button>
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
