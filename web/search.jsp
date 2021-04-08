<%-- 
    Document   : search_form
    Created on : Apr 8, 2021, 11:06:23 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

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

    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">


        <div class="site-wrap" id="home-section">

            <jsp:include page="navbar.jsp"></jsp:include>

                <div class="ftco-blocks-cover-1">
                    <div class="ftco-cover-1 overlay innerpage" style="background-image: url('images/hero_2.jpg')">
                        <div class="container">
                            <div class="row align-items-center justify-content-center">
                                <div class="col-lg-6 text-center">
                                    <h1>Search</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="site-section pt-0 pb-0 bg-light">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">

                                <form class="trip-form" action="search">
                                    <div class="row align-items-center mb-4">
                                        <div class="col-md-6">
                                            <h3 class="m-0">Search</h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-3">
                                            <label for="cf-1">Car name</label>
                                            <input type="text" id="cf-1" placeholder="Your pickup address" class="form-control">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="cf-2">Category</label>
                                            <select class="form-control" name="cboCategory">
                                                <option value="">Choose Category</option>
                                            <c:set var="categoryList" value="${applicationScope.CATEGORY_LIST}"/>
                                            <c:if test="${not empty categoryList}">
                                                <c:forEach var="cate" items="${categoryList}" varStatus="counter">
                                                    <option value="${cate.category}"
                                                            <c:if test="${cate.category eq param.cboCategory}">
                                                                selected
                                                            </c:if>
                                                            >${cate.category}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cf-3">Journey date</label>
                                        <input type="date" id="cf-3" placeholder="Your pickup address" class="form-control datepicker px-3">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cf-4">Return date</label>
                                        <input type="date" id="cf-4" placeholder="Your pickup address" class="form-control datepicker px-3">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <input type="submit" value="Search" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <jsp:include page="howitwork.jsp"/>

            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
