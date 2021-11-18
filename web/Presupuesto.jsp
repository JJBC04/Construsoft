<%-- 
    Document   : Presupuesto
    Created on : 8/11/2021, 10:43:47 PM
    Author     : jjbue
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelos.DTOObjetoPresupuesto"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.DTOUsuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="nav-placeholder" class="wrapper">

        </div>
        <%
            DTOUsuario usuario = (DTOUsuario) session.getAttribute("usuarioSesion");

            int rol = usuario.getRol();

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
                                <input type="number" name="mCuadrados" minlength="8" maxlength="40" required>
                            </p>
                        </div>
                        <p class="p-container">

                            <input type="submit" name="accion" value="Listar">
                           <!-- <input type="submit" name="accion" value="ControladorPresupuesto?accion=Agregar&CodigoUser=" <%usuario.getCedula(); %>>-->
                           
                        </p>
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

                            </tr>
                        </c:forEach>

                        <% if (request.getAttribute("presupuesto") == null) {

                            } else {
                                List<DTOObjetoPresupuesto> lista = (List<DTOObjetoPresupuesto>) request.getAttribute("presupuesto");
                                int i = 0;
                                for (DTOObjetoPresupuesto objeto : lista) {
                                    if (i++ == lista.size() - 1) {
                                        out.println("<p>Total: " + objeto.getPrecioTotalMateriales() + "</a>");
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
