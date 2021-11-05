<%-- 
    Document   : Materiales
    Created on : 03-ago-2021, 9:37:48
    Author     : jjbue
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Modelos.DTOMaterial"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">
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
        <link rel="stylesheet" href="css/materiales.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style2.css">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
        <title>Materiales</title>
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

                    out.print("<jsp: forward page='index.jsp'/>");
                    break;
                default:
                    out.print("<jsp: forward page='login.html' />");
                    break;

            }


        %>


        <div class="feature wow fadeInUp" > 
            <div class="linea_block">
                <div class="form">

                    <ul class="tab-group">
                        <li class="tab active"><a href="#signup">Actualizar o Insertar Material</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="signup">   
                            <h1 style="color: white;">Materiales</h1>

                            <form enctype="multipart/form-data" action="ControladorMaterial" method="POST">

                                <div class="top-row">
                                    <div class="field-wrap">
                                        <input type="text" name="txtNombreMaterial" value="${materialSeleccionado.getNombre()}" required autocomplete="off">
                                        <label>
                                            Nombre<span class="req">*</span>
                                        </label>
                                    </div>
                                    <div class="field-wrap">
                                        <input type="file"  name="fileImagen" required autocomplete="off">
                                        <label>Imagen</label>
                                    </div>
                                </div>
                                <div class="top-row">

                                    <div class="field-wrap">
                                        <input type="number" name="txtPrecio" value="${materialSeleccionado.getPrecioMetroCuadrado()}" required autocomplete="off">
                                        <label>
                                            Precio<span class="req">*</span>
                                        </label>
                                    </div>

                                    <div class="field-wrap">
                                        <input type="number" name="txtCantidadMetro" value="${materialSeleccionado.getCantidadMetroCuadrado()}" required autocomplete="off">
                                        <label>
                                            Cantidad M2<span class="req">*</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="top-row">
                                    <div class="field-wrap">
                                        <input name ="txtUnidadMedida" value="${materialSeleccionado.getUnidadMedida()}"type="text"required autocomplete="off"/>
                                        <label>
                                            Unidad Medida<span class="req">*</span>
                                        </label>
                                    </div>
                                    <div class="field-wrap">

                                        <select name ="txtTipoMaterial" required >
                                            <c:forEach var="tipoM" items ="${tipoMateriales}">
                                                <option value="${tipoM.getCodigo()}">${tipoM.getNombre()}</option>
                                            </c:forEach>
                                        </select>
                                        <label> 
                                            Tipo Material*
                                        </label>
                                    </div>
                                </div>
                                <input type="hidden" name="codigoM" value="${materialSeleccionado.getCodigoMaterial()}" >
                                <input type="hidden" name="imgActu" value="${materialSeleccionado.getRutaImagen()}">
                                <div class="top-row">

                                    <div class="field-wrap">

                                        <input type="submit" class="button button-block" name="accion" value="Agregar">
                                    </div>

                                    <div class="field-wrap">

                                        <input type="submit" class="button button-block" name="accion" value="Actualizar">
                                    </div>
                                </div>

                            </form>

                        </div>



                    </div><!-- tab-content -->

                </div> <!-- /form -->


            </div>  


        </div>

        <div class="footer wow fadeIn" data-wow-delay="0.1s">
            <div>
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Nombre Material</th>
                            <th scope="col">Tipo Material</th>
                            <th scope="col">Imagen</th>
                            <th scope="col">Precio M2</th>
                            <th scope="col">Cantidad M"</th>
                            <th scope="col">Unidad medida</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach  var="dato" items="${materiales}">
                            <tr>
                                <th scope="row">${dato.getNombre()}</th>
                                <td>${dato.getTxtTipoMaterial()}</td>
                                <td><img src="http://localhost/img/${dato.getRutaImagen()}"width="150" height="130"></td>
                                <td>${dato.getPrecioMetroCuadrado()}</td>
                                <td>${dato.getCantidadMetroCuadrado()}</td>
                                <td>${dato.getUnidadMedida()}</td>
                                <td>
                                    <a class='btn btn-warning' href='ControladorMaterial?accion=Cargar&codigoMaterial=${dato.getCodigoMaterial()}'>Editar</a>
                                    <a class='btn btn-danger' href='ControladorMaterial?accion=Eliminar&codigoMaterial=${dato.getCodigoMaterial()}'>Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>

        </div>




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


    </body>
</html>