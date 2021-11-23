/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.DAOMaterial;
import Modelos.DAOPresupuesto;
import Modelos.DTOMaterial;
import Modelos.DTOObjetoPresupuesto;
import Modelos.DTOPresupuesto;
import Modelos.DTOUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jjbue
 */
@WebServlet(name = "ControladorPresupuesto", urlPatterns = {"/ControladorPresupuesto"})
public class ControladorPresupuesto extends HttpServlet {

    DAOPresupuesto DAOPresupuesto = new DAOPresupuesto();
    DTOPresupuesto DTOPresupuesto = new DTOPresupuesto();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String accion = request.getParameter("accion");
        boolean pHecho = true;
        switch (accion) {
            //Casos para Presupuesto.jsp
            case "Crear Presupuesto":
                int metrosConstruir = Integer.parseInt(request.getParameter("mCuadrados"));
                request.setAttribute("metrosConstruir", metrosConstruir);
                int codigoUser = Integer.parseInt(request.getParameter("cedulaUser"));
                //Se envian valores definidos, porque aun no se sabe si el usuario quiere guardar el presupuesto
                DTOPresupuesto.setCodigoUsuario(codigoUser);
                DTOPresupuesto.setMetrosConstruir(metrosConstruir);
                DTOPresupuesto.setNombrePresupuesto("Nombre Sin Definir");
                DTOPresupuesto.setDescripcionPresupuesto("Descripcion Sin Definir");
                DTOPresupuesto.setValorTotal(0);
                DAOPresupuesto.AgregarPresupuesto(DTOPresupuesto);
                DAOPresupuesto.UltimoPresupuesto(codigoUser);
                DAOMaterial DAOMaterial = new DAOMaterial();
                List<DTOMaterial> listaMaterialesBD = DAOMaterial.Listar();
                DAOPresupuesto.AgregarTablaUser(listaMaterialesBD);
                List<DTOObjetoPresupuesto> primerCotizacion = DAOPresupuesto.HacerPresupuesto(metrosConstruir);
                request.setAttribute("presupuesto", primerCotizacion);

                request.setAttribute("comprobantePresupuesto", pHecho);
                DTOPresupuesto datosPresupuestoCrear = DAOPresupuesto.SeleccionarPresupuestoReciente();
                request.setAttribute("presupuestoDatos", datosPresupuestoCrear);
                request.getRequestDispatcher("Presupuesto.jsp").forward(request, response);
                break;
            case "Guardar Presupuesto":
                int metrosConstruirA = Integer.parseInt(request.getParameter("mCuadrados"));
                request.setAttribute("metrosConstruir", metrosConstruirA);
                int codigoUserA = Integer.parseInt(request.getParameter("cedulaUser"));
                String nombreP = request.getParameter("nombrePresupuesto");
                String descipcionP = request.getParameter("descripcionPresupuesto");
                int totalP = Integer.parseInt(request.getParameter("TotalPresupuesto"));

                DTOPresupuesto.setCodigoUsuario(codigoUserA);
                DTOPresupuesto.setNombrePresupuesto(nombreP);
                DTOPresupuesto.setDescripcionPresupuesto(descipcionP);
                DTOPresupuesto.setMetrosConstruir(metrosConstruirA);
                DTOPresupuesto.setValorTotal(totalP);
                DAOPresupuesto.ActualizarPresupuesto(DTOPresupuesto);
                request.setAttribute("comprobantePresupuesto", pHecho);
                request.setAttribute("nombrePresupuesto", nombreP);
                DTOPresupuesto datosPresupuestoG = DAOPresupuesto.SeleccionarPresupuestoReciente();
                request.setAttribute("presupuestoDatos", datosPresupuestoG);

                request.getRequestDispatcher("ControladorPresupuesto?accion=HacerPresupuesto").forward(request, response);
                break;
            case "HacerPresupuesto":
                int metrosConstruirP = Integer.parseInt(request.getParameter("mCuadrados"));
                request.setAttribute("metrosConstruir", metrosConstruirP);
                List<DTOObjetoPresupuesto> presupuesto = DAOPresupuesto.HacerPresupuesto(metrosConstruirP);
                request.setAttribute("presupuesto", presupuesto);
                DTOPresupuesto datosPresupuesto = DAOPresupuesto.SeleccionarPresupuestoReciente();
                request.setAttribute("presupuestoDatos", datosPresupuesto);

                request.setAttribute("metrosConstruir", metrosConstruirP);
                request.setAttribute("comprobantePresupuesto", pHecho);
                request.getRequestDispatcher("Presupuesto.jsp").forward(request, response);
                break;
            case "Cargar":
                int codigoMaterial = Integer.parseInt(request.getParameter("codigoMaterial"));
                int mC = Integer.parseInt(request.getParameter("metrosConstruir"));
                DTOMaterial materialCarga = DAOPresupuesto.SeleccionarMaterial(codigoMaterial);
                request.setAttribute("materialSeleccionado", materialCarga);
                List<DTOObjetoPresupuesto> cotizacionC = DAOPresupuesto.HacerPresupuesto(mC);
                request.setAttribute("presupuesto", cotizacionC);
                request.setAttribute("metrosConstruir", mC);
                DTOPresupuesto datosPresupuestoC = DAOPresupuesto.SeleccionarPresupuestoReciente();
                request.setAttribute("presupuestoDatos", datosPresupuestoC);
                request.getRequestDispatcher("Presupuesto.jsp").forward(request, response);
                break;
            case "Actualizar Material":
                DTOMaterial materialActualizar = new DTOMaterial();
                materialActualizar.setCodigoMaterial(Integer.parseInt(request.getParameter("codigoM")));
                materialActualizar.setNombre(request.getParameter("txtNombreMaterial"));
                materialActualizar.setPrecioMetroCuadrado(Integer.parseInt(request.getParameter("txtPrecio")));
                materialActualizar.setCantidadMetroCuadrado(Double.parseDouble(request.getParameter("txtCantidadMetro")));
                materialActualizar.setUnidadMedida(request.getParameter("txtUnidadMedida"));
                DAOPresupuesto.ActualizarMaterialPresupuesto(materialActualizar);
                request.setAttribute("comprobantePresupuesto", pHecho);
                request.getRequestDispatcher("ControladorPresupuesto?accion=HacerPresupuesto").forward(request, response);
                break;
            case "Agregar Material":
                DTOMaterial materialAgregar = new DTOMaterial();
                materialAgregar.setNombre(request.getParameter("txtNombreMaterial"));
                materialAgregar.setPrecioMetroCuadrado(Integer.parseInt(request.getParameter("txtPrecio")));
                materialAgregar.setCantidadMetroCuadrado(Double.parseDouble(request.getParameter("txtCantidadMetro")));
                materialAgregar.setUnidadMedida(request.getParameter("txtUnidadMedida"));
                DAOPresupuesto.AgregarMaterialUser(materialAgregar);
                request.setAttribute("comprobantePresupuesto", pHecho);
                request.getRequestDispatcher("ControladorPresupuesto?accion=HacerPresupuesto").forward(request, response);
                break;
            case "EliminarMaterial":
                int codigoMaterialE = Integer.parseInt(request.getParameter("codigoMaterial"));
                DAOPresupuesto.EliminarMaterial(codigoMaterialE);
                request.getRequestDispatcher("ControladorPresupuesto?accion=HacerPresupuesto").forward(request, response);
                break;
            //Casos para ver presupuestos.jsp
            case "ListarPresupuesto":
                DAOPresupuesto.CodigoPresupuesto();
                HttpSession session = request.getSession();
                DTOUsuario usuario = (DTOUsuario) session.getAttribute("usuarioSesion");
                int codigoUserSesion = usuario.getCedula();
                DAOPresupuesto.ValidarPresupuestoSinGuardar();
                List<DTOPresupuesto> listaPresupuesto = DAOPresupuesto.ListarPresupuesto(codigoUserSesion);
                request.setAttribute("Presupuesto", listaPresupuesto);
                request.getRequestDispatcher("mostrarPresupuestos.jsp").forward(request, response);
                break;
            case "MostrarDetallePresupuesto":
                int codigoPresupuestoMD = Integer.parseInt(request.getParameter("codigoPresupuesto"));
                DTOPresupuesto presupuestoMostrar = DAOPresupuesto.SeleccionarPresupuesto(codigoPresupuestoMD);
                request.setAttribute("presupuestoDatos", presupuestoMostrar);
                List<DTOObjetoPresupuesto> presupuestoM = DAOPresupuesto.HacerPresupuesto(presupuestoMostrar.getCodigoPresupuesto());
                request.setAttribute("presupuesto", presupuestoM);
                int metrosConstruirM = presupuestoMostrar.getMetrosConstruir();
                request.setAttribute("metrosConstruir", metrosConstruirM);
                request.getRequestDispatcher("Presupuesto.jsp").forward(request, response);
                break;
            case "EliminarPresupuesto":
                int codigoPresupuestoEP = Integer.parseInt(request.getParameter("codigoPresupuesto"));
                DAOPresupuesto.EliminarPresupuesto(codigoPresupuestoEP);
                request.getRequestDispatcher("mostrarPresupuestos.jsp").forward(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
