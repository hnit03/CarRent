<%-- 
    Document   : index
    Created on : Apr 6, 2021, 9:56:28 AM
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
                                    <h1>Our For Rent Cars</h1>
                                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="site-section bg-light">
                    <div class="container">
                        <div class="row">
                        <c:set var="carList" value="${requestScope.LIST_OR_CAR}"/>
                        <c:if test="${not empty carList}">
                            <c:forEach var="car" items="${carList}">
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <div class="item-1">
                                        <a href="#"><img src="images/${car.image}" alt="Image" class="img-fluid"></a>
                                        <div class="item-1-contents">
                                            <div class="text-center">
                                                <h3><a href="#">${car.carName}</a></h3>
                                                <div class="rating">
                                                    <span class="icon-star text-warning"></span>
                                                    <span class="icon-star text-warning"></span>
                                                    <span class="icon-star text-warning"></span>
                                                    <span class="icon-star text-warning"></span>
                                                    <span class="icon-star text-warning"></span>
                                                </div>
                                                <div class="rent-price">$${car.price}</div>
                                            </div>
                                            <ul class="specs">
                                                <li>
                                                    <span>Doors</span>
                                                    <span class="spec">4</span>
                                                </li>
                                                <li>
                                                    <span>Seats</span>
                                                    <span class="spec">5</span>
                                                </li>
                                                <li>
                                                    <span>Transmission</span>
                                                    <span class="spec">Automatic</span>
                                                </li>
                                                <li>
                                                    <span>Minium age</span>
                                                    <span class="spec">18 years</span>
                                                </li>
                                            </ul>
                                            <div class="d-flex action">
                                                <a href="contact.html" class="btn btn-primary">Rent Now</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                        
                        <div class="col-12">
                            <span class="p-3">1</span>
                            <a href="#" class="p-3">2</a>
                            <a href="#" class="p-3">3</a>
                            <a href="#" class="p-3">4</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container site-section mb-5">
                <div class="row justify-content-center text-center">
                    <div class="col-7 text-center mb-5">
                        <h2>How it works</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo assumenda, dolorum necessitatibus eius earum voluptates sed!</p>
                    </div>
                </div>
                <div class="how-it-works d-flex">
                    <div class="step">
                        <span class="number"><span>01</span></span>
                        <span class="caption">Time &amp; Place</span>
                    </div>
                    <div class="step">
                        <span class="number"><span>02</span></span>
                        <span class="caption">Car</span>
                    </div>
                    <div class="step">
                        <span class="number"><span>03</span></span>
                        <span class="caption">Details</span>
                    </div>
                    <div class="step">
                        <span class="number"><span>04</span></span>
                        <span class="caption">Checkout</span>
                    </div>
                    <div class="step">
                        <span class="number"><span>05</span></span>
                        <span class="caption">Done</span>
                    </div>

                </div>
            </div>



            <jsp:include page="footer.jsp"/> 

        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/jquery.fancybox.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/aos.js"></script>

        <script src="js/main.js"></script>

    </body>

</html>


