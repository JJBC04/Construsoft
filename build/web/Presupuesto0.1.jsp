<%-- 
    Document   : Presupuesto
    Created on : 8/11/2021, 10:43:47 PM
    Author     : jjbue
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelos.DTOObjetoPresupuesto"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.DTOUsuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Presupuesto</title>
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

        <!--<h1>Revisar Librerias css</h1>-->

        <div class="row justify-content-center">

            <div class="card" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Hacer Presupuesto</h5>
                    <form method="POST" action="ControladorPresupuesto">
                        <div class="inset">
                            <p>
                                <label>Metros Cuadrados</label>
                                <input type="number" value="${presupuestoDatos.getMetrosConstruir()}" name="mCuadrados" required>
                            </p>
                        </div>
                        <p class="p-container">

                            <input type="submit" name="accion" value="Crear Presupuesto">

                            <input type="text" name="nombrePresupuesto" value="${presupuestoDatos.getNombrePresupuesto()}">
                            <input type="text" name="descripcionPresupuesto" placeholder="descripcion" value="${presupuestoDatos.getDescripcionPresupuesto()}">
                            <input type ="hidden" value="<% int cedula = usuario.getCedula();
                                out.print(cedula); %>" name="cedulaUser">
                            <input type ="hidden" value="<% out.print(totalP); %>" name="TotalPresupuesto">
                            <input type="submit" name="accion" value="Guardar Presupuesto">
                            <input type="submit" name="accion" value="ListarPresupuesto">
                        </p>


                        <div class="top-row">
                            <div class="field-wrap">
                                <input type="text" name="txtNombreMaterial" value="${materialSeleccionado.getNombre()}">
                                <label>
                                    Nombre<span class="req">*</span>
                                </label>
                            </div>
                            <div class="field-wrap">
                                <input type="number" name="txtPrecio" value="${materialSeleccionado.getPrecioMetroCuadrado()}">
                                <label>
                                    Precio<span class="req">*</span>
                                </label>
                            </div>

                        </div>
                        <div class="top-row">
                            <div class="field-wrap">
                                <input type="number" name="txtCantidadMetro" value="${materialSeleccionado.getCantidadMetroCuadrado()}">
                                <label>
                                    Cantidad M2<span class="req">*</span>
                                </label>
                            </div>
                            <div class="field-wrap">
                                <input type="text" name="txtUnidadMedida" value="${materialSeleccionado.getUnidadMedida()}">
                                <label>
                                    Unidad Medida<span class="req">*</span>
                                </label>
                            </div>
                            <div class="field-wrap">
                                <input type="hidden" name="codigoM" value="${materialSeleccionado.getCodigoMaterial()}" >
                                <input type="submit" name="accion" value="Actualizar Material">
                                <input type="submit" name="accion" value="Agregar Material">
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            <div class="row">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Precio Total Por Material</th>
                            <th scope="col">Nombre Material</th>
                            <th scope="col">Unidad Medida</th>
                            <th scope="col">Handle</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${presupuesto}" var="dato">
                            <tr>
                                <th scope="row">
                                    ${dato.getCantidadTotalxMaterial()}
                                </th>
                                <th>
                                    ${dato.getPrecioUnitarioxMaterial()}
                                </th>
                                <th>    
                                    ${dato.getNombreMaterial()}
                                </th>
                                <th>
                                    ${dato.getUnidadMedida()}
                                </th>
                                <th>
                                    <a class='btn btn-warning' href="ControladorPresupuesto?accion=Cargar&codigoMaterial=${dato.getCodigoMaterial()}&metrosConstruir=${dato.getMetrosConstruir()}">Editar</a>
                                    <a class='btn btn-danger' href="ControladorPresupuesto?accion=EliminarMaterial&codigoMaterial=${dato.getCodigoMaterial()}&mCuadrados=${dato.getMetrosConstruir()}">Eliminar</a>
                                </th>

                            </tr>
                        </c:forEach>

                        <%
                            if (request.getAttribute("presupuesto") == null) {

                            } else {
                                List<DTOObjetoPresupuesto> lista = (List<DTOObjetoPresupuesto>) request.getAttribute("presupuesto");
                                int i = 0;

                                for (DTOObjetoPresupuesto objeto : lista) {
                                    if (i++ == lista.size() - 1) {
                                        out.println("<p>Total: " + objeto.getPrecioTotalMateriales() + "</a>");
                                        totalP = objeto.getPrecioTotalMateriales();
                                        request.setAttribute("TotalPresupuesto", totalP);
                                    }

                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
