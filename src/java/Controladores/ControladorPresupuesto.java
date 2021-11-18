/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.DAOPresupuesto;
import Modelos.DTOObjetoPresupuesto;
import Modelos.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjbue
 */
@WebServlet(name = "ControladorPresupuesto", urlPatterns = {"/ControladorPresupuesto"})
public class ControladorPresupuesto extends HttpServlet {

    DAOPresupuesto DAOPresupuesto = new DAOPresupuesto();

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

        switch (accion) {
            case "Listar":
                int metrosConstruir = Integer.parseInt(request.getParameter("mCuadrados"));

                List<DTOObjetoPresupuesto> op = DAOPresupuesto.TraerCantidadMetroCuadrado(metrosConstruir);
                request.setAttribute("presupuesto", op);
                request.getRequestDispatcher("Presupuesto.jsp").forward(request, response);
                break;
            case "Agregar":
                int codigoUser = Integer.parseInt(request.getParameter("CodigoUser"));
                

                break;
            //MC hace referecia a metros cuadrados
            /*ArrayList<Double> arrayCantidadMC = DAOPresupuesto.TraerCantidadMetroCuadrado();
                ArrayList<Integer> arrayPrecioMC = DAOPresupuesto.TraerPrecioMetroCuadrado();
                ArrayList<String> arrayNombres = DAOPresupuesto.TraerNombreMaterial();
                
                DTOObjetoPresupuesto objetoPresupuesto = new DTOObjetoPresupuesto();
                ArrayList<DTOObjetoPresupuesto> DTOObjetoPresupuestos = new ArrayList<>();
                ArrayList<Integer> valorTotalPorMaterial = new ArrayList<>();
                ArrayList<String> valorNombreMaterial = new ArrayList<>();

                int metrosConstruir = Integer.parseInt(request.getParameter("mCuadrados"));
                arrayCantidadMC.forEach((Double valor) -> {
                    Double valorCatidadMultiplicar = valor * metrosConstruir;
                    int valorRedondeado = (int) Math.round(valorCatidadMultiplicar);
                    objetoPresupuesto.setCantidadMetroCuadrado(valorRedondeado);
                    DTOObjetoPresupuestos.add(objetoPresupuesto);
                });
                int tamanoArrayPrecio = arrayPrecioMC.size();
                for (int i = 0; i < tamanoArrayPrecio; i++) {
                   // int valorTPM = arrayPrecioMC.get(i) * valorCantidadMCPorMC.get(i);
                    //valorTotalPorMaterial.add(valorTPM);
                }
                
                 
                arrayNombres.forEach((String nombre) -> {
                    objetoPresupuesto.setNombreMaterial(nombre);
                    DTOObjetoPresupuestos.add(objetoPresupuesto);
                    valorNombreMaterial.add(nombre);
                }); 
                System.out.println();*/

            //request.setAttribute("valoresNombreMaterial", DTOObjetoPresupuestos);
            //request.setAttribute("valoresTotalMaterial", valorTotalPorMaterial);

            //MC hace referecia a metros cuadrados
            /*ArrayList<Double> arrayCantidadMC = DAOPresupuesto.TraerCantidadMetroCuadrado();
                ArrayList<Integer> arrayPrecioMC = DAOPresupuesto.TraerPrecioMetroCuadrado();
                ArrayList<String> arrayNombres = DAOPresupuesto.TraerNombreMaterial();
                
                DTOObjetoPresupuesto objetoPresupuesto = new DTOObjetoPresupuesto();
                ArrayList<DTOObjetoPresupuesto> DTOObjetoPresupuestos = new ArrayList<>();
                ArrayList<Integer> valorTotalPorMaterial = new ArrayList<>();
                ArrayList<String> valorNombreMaterial = new ArrayList<>();

                int metrosConstruir = Integer.parseInt(request.getParameter("mCuadrados"));
                arrayCantidadMC.forEach((Double valor) -> {
                    Double valorCatidadMultiplicar = valor * metrosConstruir;
                    int valorRedondeado = (int) Math.round(valorCatidadMultiplicar);
                    objetoPresupuesto.setCantidadMetroCuadrado(valorRedondeado);
                    DTOObjetoPresupuestos.add(objetoPresupuesto);
                });
                int tamanoArrayPrecio = arrayPrecioMC.size();
                for (int i = 0; i < tamanoArrayPrecio; i++) {
                   // int valorTPM = arrayPrecioMC.get(i) * valorCantidadMCPorMC.get(i);
                    //valorTotalPorMaterial.add(valorTPM);
                }
                
                 
                arrayNombres.forEach((String nombre) -> {
                    objetoPresupuesto.setNombreMaterial(nombre);
                    DTOObjetoPresupuestos.add(objetoPresupuesto);
                    valorNombreMaterial.add(nombre);
                }); 
                System.out.println();*/

            //request.setAttribute("valoresNombreMaterial", DTOObjetoPresupuestos);
            //request.setAttribute("valoresTotalMaterial", valorTotalPorMaterial);
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
