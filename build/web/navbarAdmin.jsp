<%-- 
    Document   : index
    Created on : 12/10/2021, 10:54:40 PM
    Author     : jjbue
--%>

<%@page import="Modelos.DTOUsuario"%>
<%@page import="Modelos.DTOUsuario"%>
<%@page import="Modelos.DAOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        DTOUsuario usuario = (DTOUsuario) session.getAttribute("usuarioSesion");

        int rol = usuario.getCedula();

    %>
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
        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="wrapper">
            <div class="nav-bar">
                <div class="container-fluid">
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                        <a href="#" class="navbar-brand">MENU</a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto">
                                <a href="index.jsp" class="nav-item nav-link">Inicio</a>
                                <a href="adminReportes.jsp" class="nav-item nav-link">Reportes</a>
                                <a href="Controlador?menu=Usuario&accion=Listar" class="nav-item nav-link">Usuarios</a>
                                <a href="ControladorMaterial?accion=Listar" class="nav-item nav-link">Materiales</a>
                                <a href="contact.html" class="nav-item nav-link">Preguntas</a>
                                <a href="Controlador?menu=Usuario&accion=ListarUser&cedula=<% out.print(rol);%>" class="nav-item nav-link">Editar Perfil</a>
                            </div>
                            <div class="ml-auto">
                                <a class="btn" href="Controlador?menu=Usuario&accion=Salir">Cerrar Sesion</a>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
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
    </body>
</html>
