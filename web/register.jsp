<%-- 
    Document   : login
    Created on : Apr 7, 2021, 2:16:15 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Car Rent</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="css/aos.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="css/style.css">
        <script src="https://www.google.com/recaptcha/api.js?hl=en" async defer></script> 
    </head>
    <body>

        <jsp:include page="navbar.jsp"/>

        <div class="ftco-blocks-cover-1">
            <div class="ftco-cover-1 overlay" style="background-image: url('images/hero_1.jpg')">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-8">
                            <div class="feature-car-rent-box-1 ">
                                <c:set var="error" value="${requestScope.ERROR}"/>
                                <h3>Register</h3>
                                <form action="register" method="POST">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <ul class="list-unstyled">
                                                <li>
                                                    <div class="form-group" style="padding-bottom: -5x;">
                                                        <input type="email" class="form-control" 
                                                               id="email" placeholder="Email" required
                                                               name="email" value="${param.email}"
                                                               minlength="6"
                                                               >
                                                        <c:if test="${not empty error.emailIsExist}">
                                                            <font color="red">${error.emailIsExist}</font>
                                                        </c:if>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control" id="password" placeholder="Password" required
                                                               name="password" value="${param.password}"
                                                               minlength="6" maxlength="32">
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control" 
                                                               id="email" placeholder="Confirm password" required
                                                               name="confirmPassword" value="${param.confirmPassword}"
                                                               minlength="6" maxlength="32"
                                                               >
                                                        <c:if test="${not empty error.comfirmNotMatch}">
                                                            <font color="red">${error.comfirmNotMatch}</font>
                                                        </c:if>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-lg-6">
                                            <ul class="list-unstyled">
                                                <li>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" 
                                                               id="email" placeholder="Fullname" required
                                                               name="fullname" value="${param.fullname}"
                                                               >
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" 
                                                               id="email" placeholder="Phone Number" required
                                                               name="phone" value="${param.phone}"
                                                               >
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="form-group">
                                                        <textarea type="text" class="form-control" 
                                                               id="email" placeholder="Address" required
                                                               name="address" value="${param.address}"
                                                               minlength="6" maxlength="300"
                                                               ></textarea>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>


                                    <div class="d-flex align-items-center bg-light p-3">
                                        <input type="reset" value="Reset" />
                                        <input type="submit" value="Register" name="btnAction" class="ml-auto btn btn-primary"/>
                                    </div>
                                </form>
                                <div class="d-flex align-items-center bg-light p-3">
                                    <span>You had an account</span>
                                    <a href="signin" class="ml-auto btn btn-primary">Login Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
