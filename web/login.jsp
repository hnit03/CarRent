<%-- 
    Document   : login
    Created on : Apr 6, 2021, 5:02:15 PM
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
                        <div class="col-lg-5">
                            <div class="feature-car-rent-box-1">
                                <h3>Login</h3>
                                <form action="login" method="POST">
                                    <ul class="list-unstyled">
                                        <li>
                                            <div class="form-group">
                                                <input type="text" 
                                                       name="email" 
                                                       value="${param.email}" 
                                                       placeholder="Email"
                                                       class="form-control" 
                                                       required
                                                       />
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-group">
                                                <input type="password" 
                                                       name="password" 
                                                       value="${param.password}" 
                                                       placeholder="Password"
                                                       class="form-control" 
                                                       required/>
                                            </div>
                                        </li>
                                        <li class="text-center">
                                            <div class="g-recaptcha" data-sitekey="6Ld9rYYaAAAAAMFfSByLk_AdZAzvul6RW9AB_Shd"></div>   
                                        </li>
                                    </ul>
                                    <c:set var="error" value="${requestScope.LOGIN_FAILED}"/>
                                    <c:if test="${not empty error}">
                                        <div class="text-center">
                                            <p style="color: red;font-weight: bold">${error}</p>
                                        </div>
                                    </c:if>
                                    <div class="d-flex align-items-center bg-light p-3">
                                        <input type="reset" value="Reset" />
                                        <input type="submit" value="Sign in" name="btnAction" class="ml-auto btn btn-primary"/>
                                    </div>
                                </form>
                                <div class="d-flex align-items-center bg-light p-3">
                                    <span>You don't have account</span>
                                    <a href="signup" class="ml-auto btn btn-primary">Register Now</a>
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
