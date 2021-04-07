<%-- 
    Document   : verify
    Created on : Apr 7, 2021, 3:20:23 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

    <head>
        <title>Car Rent &mdash; Free Website Template by Colorlib</title>
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
                                    <h1>Verify Account</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="site-section pt-0 pb-0 bg-light">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">

                                <form class="trip-form mb-4" action="verified" method="post">
                                    <div class="row align-items-center mb-4">
                                        <div class="col-md-6">
                                            <h3 class="m-0">Verify Account</h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-2"></div>
                                        <div class="col-lg-4">
                                            <input type="text" name="verify" value="" class="form-control"/>
                                        </div>
                                        <div class="col-lg-2">
                                            <input type="submit" value="Verify" class="form-control btn "/>
                                        </div>
                                        <div class="col-lg-2">
                                            <a href="" class=" nav-link form-control btn disabled">Send again (60)</a>
                                        </div>
                                        <div class="col-lg-2"></div>
                                    </div>
                                </form>
                                <div class="row">
                                    <div class="col-lg-2"></div>
                                    <div class="col-lg-8">
                                    <c:set var="expire" value="${requestScope.EXPIRED}"/>
                                    <c:if test="${not empty expire}">
                                        <p style="color: red;font-weight: bold">${error}</p>
                                    </c:if>
                                </div>
                                <div class="col-lg-2"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
