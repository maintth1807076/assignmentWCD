<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div class="container col-8">
        <form id="login" method="post" action="login">
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input name="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <button id="ok" type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
<script type="text/javascript">
    $(document).ready(function() {
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
