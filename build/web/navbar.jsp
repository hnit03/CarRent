<%-- 
    Document   : navbar
    Created on : Apr 6, 2021, 10:04:02 AM
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
    </head>
    <body>
        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close mt-3">
                    <span class="icon-close2 js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>
        <header class="site-navbar site-navbar-target" role="banner">

            <div class="container">
                <div class="row align-items-center position-relative">

                    <div class="col-3 ">
                        <div class="site-logo">
                            <a href="home">CarRent</a>
                        </div>
                    </div>

                    <div class="col-9  text-right">


                        <span class="d-inline-block d-lg-none"><a href="#" class="text-white site-menu-toggle js-menu-toggle py-5 text-white"><span class="icon-menu h3 text-white"></span></a></span>


                        <nav class="site-navigation text-right ml-auto d-none d-lg-block" role="navigation">
                            <ul class="site-menu main-menu js-clone-nav ml-auto ">
                                <li><a href="home" class="nav-link">Home</a></li>
                                <li><a href="services.html" class="nav-link">Services</a></li>
                                <li><a href="cars.html" class="nav-link">Cars</a></li>
                                <li><a href="about.html" class="nav-link">About</a></li>
                                <li><a href="blog.html" class="nav-link">Blog</a></li>
                                <li><a href="contact.html" class="nav-link">Contact</a></li>
                                    <c:set var="account" value="${sessionScope.ACCOUNT}"/>
                                    <c:if test="${not empty account}">
                                    <li><a class="nav-link">${account.fullname}</a></li>
                                    <li>
                                        <a href="logout" class="nav-link">Logout</a>
                                    </li>
                                    </c:if>
                                    <c:if test="${empty account}">
                                    <li><a href="signin" class="nav-link">Login</a></li>
                                    </c:if>

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>

        </header>
    </body>
</html>
