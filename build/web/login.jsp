<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Construsoft</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">

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
        <link rel="stylesheet" href="css/Login.css">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>

        <div class="wrapper">
            <!-- Top Bar Start -->

            <!-- Top Bar End -->

            <!-- Nav Bar Start -->
            <div class="nav-bar">
                <div class="container-fluid">
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                        <a href="#" class="navbar-brand">MENU</a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto">
                                <a href="index.html" class="nav-item nav-link active">Inicio</a>
                                <a href="acercanosotros.html" class="nav-item nav-link">Acerca de nosotros</a>
                                <a href="" class="nav-item nav-link">Registro</a> 
                            </div>
                            <div class="ml-auto">
                                <a class="btn" href="login.jsp">Iniciar Sesion</a>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>          
            <!-- Nav Bar End -->


            <!-- Carousel Start -->
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <form method="POST" action="Validar">
                    <h1>Iniciar Sesi?n</h1>
                    <div class="inset">
                        <p>
                            <label for="email">Correo</label>
                            <input type="email" name="txtusuario" minlength="8" maxlength="40" required autocomplete="off">
                        </p>
                        <p>
                            <label for="password">Clave</label>
                            <input type="password" name="txtpassword" requiered maxlength="30" required autocomplete="off">
                        </p>

                    </div>
                    <p class="p-container">
                        <!--<a href="" onclick='enviarProm()'>?Olvido Contrase?a?</a>-->
                        <input type="submit" name="accion" value="Ingresar">
                    </p>
                </form>
            </div>



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
        </div>
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
        <script src="js/login.js"></script>
    </body>
</html>
