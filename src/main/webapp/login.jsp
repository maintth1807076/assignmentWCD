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

    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .error {
            color: red;
        }
        .form-control {
            color: red;
        }
    </style>
</head>
<body>
<div class="container col-8">
    <form id="login" method="post" action="/login">
        <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <input name="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter username">
            <%
                if (errors != null && errors.containsKey("username")) {
            %>
            <p class="error">* <%=errors.get("username").get(0)%>
            </p>
            <%
                }
            %>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                   placeholder="Password">
            <%
                if (errors != null && errors.containsKey("password")) {
            %>
            <p class="error">* <%=errors.get("password").get(0)%>
            </p>
            <%
                }
            %>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
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
                    required: "Please enter username",
                    minlength: "Username Do not be too short (5-15 characters)",
                    maxlength: "Username Do not be too long 15 characters"
                },
                password: {
                    required: "Please enter password",
                    minlength: "Password Do not be too short"
                }
            }
        });
    })
</script>

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
