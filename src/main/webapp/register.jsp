<%--
  Created by IntelliJ IDEA.
  User: BVCN 88 CS2
  Date: 7/9/2020
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="register/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <%@ include file="outside/style.jsp" %>
</head>
<style>
    .validate-input {
        color: #ff3368;
    }
</style>
<body>
<div class="limiter">
    <div class="container-login100" style="background-image: url('register/bg-01.jpg');">
        <div class="wrap-login100">
            <form class="login100-form validate-form" method="post" action="/register" id="registerForm">

                <span class="login100-form-title p-b-34 p-t-27">
						Register
					</span>

                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input class="input100" type="text" name="username" placeholder="Username">
                    <span class="focus-input100" data-placeholder="&#xf207;"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Enter fullname">
                    <input class="input100" type="text" name="fullname" placeholder="Fullname">
                    <span class="focus-input100" data-placeholder="&#xf206;"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Enter email">
                    <input class="input100" type="text" name="email" placeholder="Email">
                    <span class="focus-input100" data-placeholder="&#xf15a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100" data-placeholder="&#xf191;"></span>
                </div>


                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit">
                        Register
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#registerForm").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 5,
                    maxlength: 15
                },
                fullname: {
                    required: true,
                    minlength: 5
                },
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 5
                }
            },
            messages: {
                username: {
                    required: "Please enter username",
                    minlength: "Username Do not be too short (5-15 characters)",
                    maxlength: "Username Do not be too long 15 characters"
                },
                fullname: {
                    required: "Please enter fullname",
                    minlength: "Fullname Do not be too short"
                },
                email: {
                    required: "Please enter email",
                    email: "Email must be in proper format"
                },
                password: {
                    required: "Please enter password",
                    minlength: "Password Do not be too short"
                }
            }
        });
    })
</script>
</body>
</html>
