<%-- 
    Document   : index
    Created on : Apr 6, 2021, 3:33:43 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
                <c:set value="${requestScope.CAR}" var="carDTO"/>
                <div class="ftco-cover-1 overlay" style="background-image: url('images/${carDTO.image}')">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-lg-5">
                                <div class="feature-car-rent-box-1">
                                    <h3>${carDTO.carName}</h3>
                                    <ul class="list-unstyled">
                                        <li>
                                            <span>Category</span>
                                            <span class="spec">${carDTO.cateDTO.category}</span>
                                        </li>
                                        <li>
                                            <span>Color</span>
                                            <span class="spec">${carDTO.cdto.colorName}</span>
                                        </li>
                                        <li>
                                            <span>Year</span>
                                            <span class="spec">${carDTO.year}</span>
                                        </li>
                                        <li>
                                            <span>Quantity</span>
                                            <span class="spec">${carDTO.quantity}</span>
                                        </li>
                                    </ul>
                                    <div class="d-flex align-items-center bg-light p-3">
                                        <span>${carDTO.price}</span>
                                        <a href="contact.html" class="ml-auto btn btn-primary">Rent Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="site-section pt-0 pb-0 bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-12">

                            <form class="trip-form">
                                <div class="row align-items-center mb-4">
                                    <div class="col-md-6">
                                        <h3 class="m-0">Begin your trip here</h3>
                                    </div>
                                    <div class="col-md-6 text-md-right">
                                        <span class="text-primary">32</span> <span>cars available</span></span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-3">
                                        <label for="cf-1">Where you from</label>
                                        <input type="text" id="cf-1" placeholder="Your pickup address" class="form-control">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cf-2">Where you go</label>
                                        <input type="text" id="cf-2" placeholder="Your drop-off address" class="form-control">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cf-3">Journey date</label>
                                        <input type="text" id="cf-3" placeholder="Your pickup address" class="form-control datepicker px-3">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cf-4">Return date</label>
                                        <input type="text" id="cf-4" placeholder="Your pickup address" class="form-control datepicker px-3">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <input type="submit" value="Submit" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <div class="site-section bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <h3>Our Offer</h3>
                            <p class="mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure nesciunt nemo vel earum maxime neque!</p>
                            <p>
                                <a href="#" class="btn btn-primary custom-prev">Previous</a>
                                <span class="mx-2">/</span>
                                <a href="#" class="btn btn-primary custom-next">Next</a>
                            </p>
                        </div>
                        <div class="col-lg-9">

                            <div class="nonloop-block-13 owl-carousel">
                                <c:set var="carList" value="${requestScope.LIST_OR_CAR}"/>
                                <c:if test="${not empty carList}">
                                    <c:forEach var="car" items="${carList}">
                                        <div class="item-1">
                                            <a href="#"><img src="images/${car.image}" alt="Image" class="img-fluid"></a>
                                            <div class="item-1-contents">
                                                <div class="text-center">
                                                    <h3><a href="#">${car.carName}</a></h3>
                                                    <div class="rating">
                                                        <c:if test="${car.pointRating > 0}">
                                                            <c:forEach begin="1" end="${car.pointRating}" step="1">
                                                                <span class="icon-star text-warning"></span>
                                                            </c:forEach>
                                                        </c:if>
                                                        <c:if test="${car.pointRating == 0}">
                                                            No <span class="icon-star text-warning"></span>
                                                        </c:if>
                                                    </div>
                                                    <div class="rent-price">${car.price}</div>
                                                </div>
                                                <ul class="specs">
                                                    <li>
                                                        <span>Category</span>
                                                        <span class="spec">${car.cateDTO.category}</span>
                                                    </li>
                                                    <li>
                                                        <span>Color</span>
                                                        <span class="spec">${car.cdto.colorName}</span>
                                                    </li>
                                                    <li>
                                                        <span>Year</span>
                                                        <span class="spec">${car.year}</span>
                                                    </li>
                                                    <li>
                                                        <span>Quantity</span>
                                                        <span class="spec">${car.quantity}</span>
                                                    </li>
                                                </ul>
                                                <div class="d-flex action">
                                                    <a href="contact.html" class="btn btn-primary">Rent Now</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>

                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="site-section section-3" style="background-image: url('images/hero_2.jpg');">
                <div class="container">
                    <div class="row">
                        <div class="col-12 text-center mb-5">
                            <h2 class="text-white">Our services</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="service-1">
                                <span class="service-1-icon">
                                    <span class="flaticon-car-1"></span>
                                </span>
                                <div class="service-1-contents">
                                    <h3>Repair</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati, laboriosam.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="service-1">
                                <span class="service-1-icon">
                                    <span class="flaticon-traffic"></span>
                                </span>
                                <div class="service-1-contents">
                                    <h3>Car Accessories</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati, laboriosam.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="service-1">
                                <span class="service-1-icon">
                                    <span class="flaticon-valet"></span>
                                </span>
                                <div class="service-1-contents">
                                    <h3>Own a Car</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati, laboriosam.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <jsp:include page="howitwork.jsp"/>


            <div class="site-section bg-light">
                <div class="container">
                    <div class="row justify-content-center text-center mb-5">
                        <div class="col-7 text-center mb-5">
                            <h2>Customer Testimony</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo assumenda, dolorum necessitatibus eius earum voluptates sed!</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 mb-4 mb-lg-0">
                            <div class="testimonial-2">
                                <blockquote class="mb-4">
                                    <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, deserunt eveniet veniam. Ipsam, nam, voluptatum"</p>
                                </blockquote>
                                <div class="d-flex v-card align-items-center">
                                    <img src="images/person_1.jpg" alt="Image" class="img-fluid mr-3">
                                    <span>Mike Fisher</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-4 mb-lg-0">
                            <div class="testimonial-2">
                                <blockquote class="mb-4">
                                    <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, deserunt eveniet veniam. Ipsam, nam, voluptatum"</p>
                                </blockquote>
                                <div class="d-flex v-card align-items-center">
                                    <img src="images/person_2.jpg" alt="Image" class="img-fluid mr-3">
                                    <span>Jean Stanley</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-4 mb-lg-0">
                            <div class="testimonial-2">
                                <blockquote class="mb-4">
                                    <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, deserunt eveniet veniam. Ipsam, nam, voluptatum"</p>
                                </blockquote>
                                <div class="d-flex v-card align-items-center">
                                    <img src="images/person_3.jpg" alt="Image" class="img-fluid mr-3">
                                    <span>Katie Rose</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="site-section bg-white">
                <div class="container">
                    <div class="row justify-content-center text-center mb-5">
                        <div class="col-7 text-center mb-5">
                            <h2>Our Blog</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo assumenda, dolorum necessitatibus eius earum voluptates sed!</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="post-entry-1 h-100">
                                <a href="single.html">
                                    <img src="images/post_1.jpg" alt="Image"
                                         class="img-fluid">
                                </a>
                                <div class="post-entry-1-contents">

                                    <h2><a href="single.html">The best car rent in the entire planet</a></h2>
                                    <span class="meta d-inline-block mb-3">July 17, 2019 <span class="mx-2">by</span> <a href="#">Admin</a></span>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores eos soluta, dolore harum molestias consectetur.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="post-entry-1 h-100">
                                <a href="single.html">
                                    <img src="images/img_2.jpg" alt="Image"
                                         class="img-fluid">
                                </a>
                                <div class="post-entry-1-contents">

                                    <h2><a href="single.html">The best car rent in the entire planet</a></h2>
                                    <span class="meta d-inline-block mb-3">July 17, 2019 <span class="mx-2">by</span> <a href="#">Admin</a></span>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores eos soluta, dolore harum molestias consectetur.</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="post-entry-1 h-100">
                                <a href="single.html">
                                    <img src="images/img_3.jpg" alt="Image"
                                         class="img-fluid">
                                </a>
                                <div class="post-entry-1-contents">

                                    <h2><a href="single.html">The best car rent in the entire planet</a></h2>
                                    <span class="meta d-inline-block mb-3">July 17, 2019 <span class="mx-2">by</span> <a href="#">Admin</a></span>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores eos soluta, dolore harum molestias consectetur.</p>
                                </div>
                            </div>
                        </div>
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

