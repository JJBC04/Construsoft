<%-- 
    Document   : Usuarios
    Created on : 03-ago-2021, 11:08:23
    Author     : jjbue
--%>

<%@page import="Modelos.DTOUsuario"%>
<%@page import="Modelos.DTOUsuario"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Usuarios</title>
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
        <div class="row">
            <div class="col-lg-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Usuarios</h5>
                        <form action="Controlador?menu=Usuario" method="POST">
                            <div class="mb-3">
                                <label class="form-label">Cedula</label>
                                <input type="number" class="form-control" name="txtcedula" value="${usuarioSeleccionado.getCedula()}" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Nombre</label>
                                <input type="text" class="form-control" name="txtnombre" value="${usuarioSeleccionado.getNombre()}" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Apellido</label>
                                <input type="text" class="form-control" name="txtapellido" value="${usuarioSeleccionado.getApellido()}">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Correo</label>
                                <input type="email" class="form-control" name="txtcorreo" value="${usuarioSeleccionado.getCorreo()}">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Contraseña</label>
                                <input type="password" class="form-control" name="txtclave" value="${usuarioSeleccionado.getClave()}">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Rol</label>
                                <select class="form-action form-action-sm" name="txtrol">
                                    <c:forEach var="rolU" items="${userRol}">
                                        <option value="${rolU.getCodigo()}">${rolU.getNombre()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar Usuario">
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar">
                        </form>

                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Cedula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Contraseña</th>
                            <th scope="col">Rol</th>
                            <th scope="col">Acciones</th>
                        </tr>

                    </thead>
                    <tbody>

                        <%  List<DTOUsuario> lista = (List<DTOUsuario>) request.getAttribute("usuarios");
                            for (DTOUsuario usuario : lista) {
                                out.println("<tr>");
                                out.println("<td>" + usuario.getCedula() + "</td>");
                                out.println("<td>" + usuario.getNombre() + "</td>");
                                out.println("<td>" + usuario.getApellido() + "</td>");
                                out.println("<td>" + usuario.getCorreo() + "</td>");
                                out.println("<td>" + usuario.getClave() + "</td>");

                                out.println("<td>" + usuario.getTxtRol() + "</td>");
                                out.println("<td> <a class='btn btn-warning' href='Controlador?menu=Usuario&accion=Cargar&Cedula=" + usuario.getCedula() + "'>Editar</a>");
                                out.println("<a class='btn btn-danger' href='Controlador?menu=Usuario&accion=Eliminar&Cedula=" + usuario.getCedula() + "'>Eliminar</a></td>");
                                out.println("</tr>");
                            }
                        %>

                    </tbody>
                </table>
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