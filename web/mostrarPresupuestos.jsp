<%-- 
    Document   : Presupuesto
    Created on : 8/11/2021, 10:43:47 PM
    Author     : jjbue
--%>
<%@page import="Modelos.DTOObjetoPresupuesto"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.DTOUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/reportes.css" />
        <link href="style.css" rel="css/stylesheet" />
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
           
        %>
        <div class="about wow fadeInUp" data-wow-delay="0.1s">
            <div class="espacioReporte">

                <c:forEach var="dato" items="${Presupuesto}">
                    <!-- Nav Bar End -->
                    <div class="card">
                        <div class="card-header">
                            ${dato.getNombrePresupuesto()}
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${dato.getNombrePresupuesto()}</h5>
                            <p class="card-text">${dato.getFechaPresupuesto()}</p>
                            <p class="card-text">${dato.getDescripcionPresupuesto()}</p>
                            <a href="ControladorPresupuesto?accion=MostrarDetallePresupuesto&codigoPresupuesto=${dato.getCodigoPresupuesto()}" class="btn btn-primary">Ver Presupuesto</a>
                            <a href="ControladorPresupuesto?accion=EliminarPresupuesto&codigoPresupuesto=${dato.getCodigoPresupuesto()}" class="btn btn-danger">Eliminar</a>
                        </div>
                    </div>  
                </c:forEach>

            </div>
        </div>       
    </body>
</html>