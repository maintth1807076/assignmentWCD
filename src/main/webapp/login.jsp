<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
%>
<html>
<head>
    <title>Login</title>
    <%@ include file="/decorators/admin/style-admin.jsp" %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div class="card container" style="width: 35%">
        <h5 class="card-header info-color white-text text-center py-4">
            <strong>Sign in</strong>
        </h5>
        <div class="card-body px-lg-5 pt-0">
            <form id="login" method="post" action="login" class="text-center" style="color: #757575">
                <div class="md-form">
                    <input type="text"
                           id="materialLoginFormEmail"
                           class="form-control"
                           name="username"
                    />
                    <label for="materialLoginFormEmail">Username</label>
                </div>
                <div class="md-form">
                    <input type="password"
                           id="materialLoginFormPassword"
                           class="form-control"
                           name="password"
                    />
                    <label for="materialLoginFormPassword">Password</label>
                </div>
                <button id="ok" type="submit"
                        class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0">Sign in
                </button>
            </form>
        </div>
    </div>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#ok').click(function () {
                $("#login").validate({
                    rules: {
                        username: {
                            required: true,
                            minlength: 5,
                            maxlength: 15
                        },
                        password: {
                            required: true,
                            minlength: 5
                        },
                    },
                    messages: {
                        username: {
                            required: "Vui lòng nhập username",
                            minlength: "Username không được quá ngắn (5-15 ký tự)",
                            maxlength: "Username không được dài quá 15 ký tự"
                        },
                        password: {
                            required: "Vui lòng nhập password",
                            minlength: "Password không được quá ngắn "
                        }
                    }
                });
            })
        });
    </script>
</body>
</html>
