<%-- 
    Document   : adminReportes
    Created on : 23/11/2021, 12:35:23 AM
    Author     : jjbue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/reportes.css" />
        <link href="style.css" rel="css/stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
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
                    out.print("<script>alert('No se permite usuarios aqui :D'); document.location.href='login.jsp'; </script >");
                    break;
                default:
                    out.print("<jsp: forward page='login.html' />");
                    break;
            }
        %>
    <body>
        <div class="about wow fadeInUp" data-wow-delay="0.1s">
            <div class="espacioReporte">
                <div class="card" id="prueba">
                    <div class="card-header">
                        BACKUP
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"> Genera el backup de la Base De Datos</h5>
                        <p class="card-text">Dale clik en Copia BD.</p>
                        <a href="Backup" class="btn btn-primary">Copia DB</a>
                    </div>
                </div>
            </div>    
            <div class="espacioReporte">
                <div class="card">
                    <div class="card-header">
                        REPORTE 1
                    </div>

                    <div class="card-body">
                        <h5 class="card-title"> Material Galon</h5>
                        <p class="card-text">El material con tipo material galon.</p>
                        <a href="MaterialGalon" class="btn btn-primary">Ver reporte</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        REPORTE 2
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Material Mas Costoso</h5>
                        <p class="card-text">El material mas costoso por metro cuadrado.</p>
                        <a href="MaterialMasCostoso" class="btn btn-primary">Ver reporte</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        REPORTE 3
                    </div>  
                    <div class="card-body">
                        <h5 class="card-title">Material Menos Costoso</h5>
                        <p class="card-text">El material menos costoso por metro cuadrado.</p>
                        <a href="MaterialMenosCostosos" class="btn btn-primary">Ver reporte</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        REPORTE 4
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Num presupuestos Cliente</h5>
                        <p class="card-text">Numero de presupuestos por cada cliente.</p>
                        <a href="NumeroPresupuesto" class="btn btn-primary">Ver reporte</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        REPORTE 5
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Presupuestos Menos Costosos</h5>
                        <p class="card-text">Los presupuestos hecho menos costosos.</p>
                        <a href="PresupuestoMenosCosto" class="btn btn-primary">Ver reporte</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        REPORTE 6
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"> Presupuestos Mas costoso</h5>
                        <p class="card-text">Los presupuestos mas costosos hechos por cada cliente.</p>
                        <a href="#" class="btn btn-primary">Ver reporte</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        REPORTE 7
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Ultimo Presupuesto Hecho Por Cliente</h5>
                        <p class="card-text">El ultimo presupuesto hecho por un cliente.</p>
                        <a href="ultimoPresupuesto" class="btn btn-primary">Ver reporte</a>
                    </div>
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
