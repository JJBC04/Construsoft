<%-- 
    Document   : Presupuesto
    Created on : 22/11/2021, 04:59:30 PM
    Author     : jjbue
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelos.DTOObjetoPresupuesto"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Construsoft</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="css/factura.css">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet"> 
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/slick/slick.css" rel="stylesheet">
        <link href="lib/slick/slick-theme.css" rel="stylesheet">
        <link rel="stylesheet" href="css/materiales.css">
        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div id="nav-placeholder" class="wrapper" > 

        </div>
        <%
            DTOUsuario usuario = (DTOUsuario) session.getAttribute("usuarioSesion");

            int rol = usuario.getRol();

            switch (rol) {
                case 1:
                    out.print("<script> $(function(){ $('#nav-placeholder').load('navbarUsuario.jsp');});</script>");
                    break;
                case 2:
                    out.print("<script>alert('No se permite administradores aqui :D'); document.location.href='index.jsp'; </script >");
                    break;
                default:
                    out.print("<script>alert('Inicie Sesión'); document.location.href='login.html'; </script >");
                    break;
            }
            int totalP = 0;
            int metrosConstruir = 0;
            if (request.getAttribute("presupuesto") == null) {

            } else {
                List<DTOObjetoPresupuesto> lista = (List<DTOObjetoPresupuesto>) request.getAttribute("presupuesto");
                metrosConstruir = (int) request.getAttribute("metrosConstruir");
                int i = 0;

                for (DTOObjetoPresupuesto objeto : lista) {
                    if (i++ == lista.size() - 1) {

                        totalP = objeto.getPrecioTotalMateriales();
                    }

                }

            }
            boolean pHecho;
            if (request.getAttribute("comprobantePresupuesto") == null) {
                pHecho = false;
            } else {
                pHecho = (boolean) request.getAttribute("comprobantePresupuesto");
            }
        %>

        <script>
            function MostrarMod() {
                document.getElementById("login1").style.display = "block";
                document.getElementById("signup1").style.display = "none";
            }
            function MostrarPre() {
                document.getElementById("signup1").style.display = "block";
                document.getElementById("login1").style.display = "none";
            }
        </script>

        <div class="row align-items-center">

            <div class="form">

                <ul class="tab-group">
                    <li class="tab active"><a href="#signup" onclick="MostrarPre();">Presupuesto General</a></li>
                    <li class="tab"><a href="#login" onclick="MostrarMod();">Actulizar Presupuesto</a></li>
                </ul>
                <div class="tab-content">
                    <form action="ControladorPresupuesto" method="post">
                        <div>

                        </div>
                        <div id="signup1">   
                            <h1>Presupuesto</h1>
                            <div class="top-row">
                                <div class="field-wrap">

                                    <input type="number" value="${presupuestoDatos.getMetrosConstruir()}" name="mCuadrados" required=""/>
                                    <label>
                                        Metros a construir
                                    </label>
                                </div>

                                <div class="field-wrap">

                                    <input type="text" name="nombrePresupuesto" value="${presupuestoDatos.getNombrePresupuesto()}">
                                    <label>
                                        Nombre Presupuesto<span class="req">*</span>
                                    </label>
                                </div>
                            </div>
                            <div class="field-wrap">

                                <input type="text" name="descripcionPresupuesto" value="${presupuestoDatos.getDescripcionPresupuesto()}">

                                <label>
                                    Descripción
                                </label>
                            </div>
                            <input type ="hidden" value="<%
                                int cedula = usuario.getCedula();
                                out.print(cedula);
                                   %>" name="cedulaUser">
                            <input type ="hidden" value="<% out.print(totalP); %>" name="TotalPresupuesto">

                            <div class="top-row">
                                <div class="field-wrap">
                                    <input class="button button-block" type="submit" name="accion" value="Crear Presupuesto">
                                </div>
                                <div class="field-wrap">
                                    <input type="submit" name="accion" value="Guardar Presupuesto" class="button button-block">
                                </div>
                            </div>
                        </div>
                        <div id="login1" class="prueba">   

                            <h1>Actualiza presupuesto</h1>
                            <div class="field-wrap">
                                <input type="text" name="txtNombreMaterial" value="${materialSeleccionado.getNombre()}">
                                <label>
                                    Nombre Material<span class="req">*</span>
                                </label>
                            </div>

                            <div class="field-wrap">
                                <input type="number" name="txtPrecio" value="${materialSeleccionado.getPrecioMetroCuadrado()}">
                                <label>
                                    Precio Metro Cuadrado<span class="req">*</span>
                                </label>
                            </div>
                            <div class="field-wrap">
                                <input type="number" name="txtCantidadMetro" value="${materialSeleccionado.getCantidadMetroCuadrado()}">
                                <label>
                                    Cantidad metro cuadrado<span class="req">*</span>
                                </label>
                            </div>
                            <div class="field-wrap">

                                <input type="text" name="txtUnidadMedida" value="${materialSeleccionado.getUnidadMedida()}">
                                <label>
                                    Unidad Medida<span class="req">*</span>
                                </label>
                            </div>
                            <input type="hidden" name="codigoM" value="${materialSeleccionado.getCodigoMaterial()}" >
                            <div class="top-row">
                                <div class="field-wrap">
                                    <input type="submit" name="accion" value="Actualizar Material" class="button button-block">
                                </div>
                                <div class="field-wrap">
                                    <input type="submit" name="accion" value="Agregar Material" class="button button-block">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- Fact Start -->
        <div class="fact">
            <div class="container-fluid">
                <div class="factura">
                    <div class="titulo">
                        <h1 class="tituloTexto">Presupuesto</h1>
                    </div>
                    <!--<div class="info">
                        <div class="datos">
                            <br>
                            <div>   
                                <h4>Nombre </h4>
                                <input type="text" placeholder="NOMBRE">
                            </div>

                            <div>
                                <h4>Apellido</h4>
                                <input type="text" placeholder="NOMBRE">
                            </div>
                            <br>
                        </div>
                    </div>-->
                    <div class="tablaPrincipal">
                        <div class="tablas">
                            <table  class="table">
                                <tr>
                                    <th>NOMBRE</th>
                                    <th>CANTIDAD</th>
                                    <th>UNIDAD MEDIDA</th>
                                    <!--<th>PRECIO UNITARIO</th>-->
                                    <th>TOTAL</th>
                                    <th>ACCIONES</th>
                                </tr>
                                <c:forEach items="${presupuesto}" var="dato">
                                    <tr>
                                        <td>${dato.getNombreMaterial()}</td>
                                        <td>${dato.getCantidadTotalxMaterial()}</td>
                                        <td>${dato.getUnidadMedida()}</td>
                                        <td>${dato.getPrecioUnitarioxMaterial()}</td>
                                        <td> <a class='btn btn-warning' href="ControladorPresupuesto?accion=Cargar&codigoMaterial=${dato.getCodigoMaterial()}&metrosConstruir=${dato.getMetrosConstruir()}">Editar</a>
                                            <a class='btn btn-danger' href="ControladorPresupuesto?accion=EliminarMaterial&codigoMaterial=${dato.getCodigoMaterial()}&mCuadrados=${dato.getMetrosConstruir()}">Eliminar</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>  
                    </div>
                    <div class="presuTotal">
                        <%
                            if (request.getAttribute("presupuesto") == null) {

                            } else {
                                List<DTOObjetoPresupuesto> lista = (List<DTOObjetoPresupuesto>) request.getAttribute("presupuesto");
                                int i = 0;

                                for (DTOObjetoPresupuesto objeto : lista) {
                                    if (i++ == lista.size() - 1) {
                                        out.println("<h3>Total: " + objeto.getPrecioTotalMateriales() + "</h3>");
                                        totalP = objeto.getPrecioTotalMateriales();
                                        request.setAttribute("TotalPresupuesto", totalP);
                                    }

                                }
                            }
                        %>
                    </div>
                </div>

            </div>
        </div>
        <!-- Fact End -->


        <!-- FAQs End -->


        <!-- Footer Start -->

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
        <script src="js/material.js"></script>
        <!-- Template Javascript -->
        <script src="js/material.js"></script>
    </body>
</html>
