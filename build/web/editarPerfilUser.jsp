<%-- 
    Document   : editarPerfilUser
    Created on : 13/10/2021, 09:40:58 PM
    Author     : jjbue
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.DTOUsuario"%>
<%@page import="Modelos.DTOUsuario"%>  
<%@page import="Modelos.DAOUsuario"%>

<!DOCTYPE html>
<html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <title>Editar Perfil</title>
            <meta content="width=device-width, initial-scale=1.0" name="viewport">
            <meta content="Construction Company Website Template" name="keywords">
            <meta content="Construction Company Website Template" name="description">

            <!-- Favicon -->
            <link href="img/favicon.ico" rel="icon">
            <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
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
            <div id="nav-placeholder" class="wrapper">

            </div>
            <%
                DTOUsuario usuario = (DTOUsuario) session.getAttribute("usuarioSesion");
                int rol = usuario.getRol();
                switch (rol) {
                    case 1:
                        out.print("<script> $(function(){ $('#nav-placeholder').load('navbarUsuario.jsp');});</script>");
                        break;
                    case 2:
                        out.print("<script> $(function(){ $('#nav-placeholder').load('navbarAdmin.jsp');});</script>");
                        break;
                    default:
                        out.print("<script>alert('Inicie Sesión'); document.location.href='login.html'; </script >");
                        break;
                }

            %>


            <form action="Controlador?menu=Usuario" method="POST">
                <h1>Modificar Perfil</h1>
                <div class="inset">
                    <p>
                        <label for="email">Cedula</label>
                        <input type="number" name="txtcedula" id="cedula" value="${usuarioSeleccionado.getCedula()}" readonly>
                    </p>
                    <p>
                        <label for="Nombre">Nombre</label>
                        <input type="text" name="txtnombre" id="Nombre" value="${usuarioSeleccionado.getNombre()}" >
                    </p>
                    <p>
                        <label for="Nombre">Apellido</label>
                        <input type="text" name="txtapellido" id="Apellido" value="${usuarioSeleccionado.getApellido()}">
                    </p>
                    <p>
                        <label for="Nombre">Correo</label>
                        <input type="text" name="txtcorreo" id="Correo" value="${usuarioSeleccionado.getCorreo()}">
                    </p>
                    <p>
                        <label for="Nombre">Clave</label>
                        <input type="password" name="txtclave" id="clave" value="${usuarioSeleccionado.getClave()}">
                    </p>
                    <input type="hidden" name="txtrol" value ="${usuarioSeleccionado.getRol()}">
                </div>
                <p class="p-container">

                    <input type="submit" name="accion"  value="Actualizar Datos">
                    <input type="hidden" name="cedula" value="${usuarioSeleccionado.getCedula()}">
                </p>
            </form>


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
                                    <p>Datos reales avalados por especialistas de la construcciòn</p>
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
                                    <p>Sistema rapido y seguro</p>
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
                                    <p>Soporte para preguntas y problemas con el sistema</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


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
