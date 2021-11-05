<%-- 
    Document   : index
    Created on : 21/10/2021, 09:38:00 AM
    Author     : jjbue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.DTOUsuario"%>
<%@page import="Modelos.DTOUsuario"%>  
<%@page import="Modelos.DAOUsuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Construsoft</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet"> 
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/slick/slick.css" rel="stylesheet">
        <link href="lib/slick/slick-theme.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div id="nav-placeholder" class="wrapper">

        </div>
        <%
            Integer rol = (Integer) application.getAttribute("rol");
            switch (rol) {
                case 2:
                    out.print("<script> $(function(){ $('#nav-placeholder').load('navbarAdmin.jsp');});</script>");
                    break;
                case 1:

                    out.print("<script> $(function(){ $('#nav-placeholder').load('navbarUsuario.jsp');});</script>");
                    break;
                default:
                    out.print("<jsp: forward page='login.html' />");
                    break;

            }

        %>


        <!-- Carousel Start -->
        <div id="carousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carousel" data-slide-to="0" class="active"></li>
                <li data-target="#carousel" data-slide-to="1"></li>
                <li data-target="#carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/carousel-1.jpg" alt="Carousel Image">
                    <div class="carousel-caption">
                        <h1 class="animated fadeInLeft">CONSTRUSOFT</h1>
                        <a class="btn animated fadeInUp" href="login.html">Iniciar Presupuesto</a>
                    </div>
                </div>  

                <div class="carousel-item">
                    <img src="img/carousel-2.jpg" alt="Carousel Image">
                    <div class="carousel-caption">
                        <p class="animated fadeInRight">Presupuestos precisos</p>
                        <h1 class="animated fadeInLeft">Podemos Ayudarte</h1>
                        <a class="btn animated fadeInUp" href="https://htmlcodex.com/construction-company-website-template">Iniciar Presupuesto</a>
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="img/carousel-3.jpg" alt="Carousel Image">
                    <div class="carousel-caption">
                        <p class="animated fadeInRight">Ayudamos</p>
                        <h1 class="animated fadeInLeft">A tu hogar soñado</h1>
                        <a class="btn animated fadeInUp" href="https://htmlcodex.com/construction-company-website-template">Iniciar Presupuesto</a>
                    </div>
                </div>
            </div>

            <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- Carousel End -->


        <!-- Feature Start-->
        <div class="feature wow fadeInUp" data-wow-delay="0.1s">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="feature-item">
                            <div class="feature-icon">
                                <i class="flaticon-worker"></i>
                            </div>
                            <div class="feature-text">
                                <h3>Trabajo Experto</h3>
                                <p>Lorem ipsum dolor sit amet elit. Phasus nec pretim ornare velit non</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="feature-item">
                            <div class="feature-icon">
                                <i class="flaticon-building"></i>
                            </div>
                            <div class="feature-text">
                                <h3>Eficacia</h3>
                                <p>Lorem ipsum dolor sit amet elit. Phasus nec pretim ornare velit non</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="feature-item">
                            <div class="feature-icon">
                                <i class="flaticon-call"></i>
                            </div>
                            <div class="feature-text">
                                <h3>24/7 Soporte</h3>
                                <p>Lorem ipsum dolor sit amet elit. Phasus nec pretim ornare velit non</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Feature End-->


        <!-- About Start -->
        <div class="footer wow fadeIn" data-wow-delay="0.3s">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-lg-3">
                        <div class="footer-contact">
                            <h2>Contacto de Oficina</h2>
                            <p><i class="fa fa-map-marker-alt"></i>cll 122, La Ceja, COL</p>
                            <p><i class="fa fa-phone-alt"></i>3245770652</p>
                            <p><i class="fa fa-envelope"></i>Construsoft2021@gmail.com</p>
                            <div class="footer-social">
                                <a href=""><i class="fab fa-twitter"></i></a>
                                <a href=""><i class="fab fa-facebook-f"></i></a>
                                <a href=""><i class="fab fa-youtube"></i></a>
                                <a href=""><i class="fab fa-instagram"></i></a>
                                <a href=""><i class="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                    </div>


                </div>
            </div>

            <div class="container copyright">
                <div class="row">
                    <div class="col-md-6">
                        <p>&copy; <a href="#">La ceja Antioquia</a> </p>
                    </div>
                    <div class="col-md-6">
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->

        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/isotope/isotope.pkgd.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        <script src="lib/slick/slick.min.js"></script>
        <!-- Template Javascript -->
        <script src="js/main.js"></script> 
    </body>
</html>
