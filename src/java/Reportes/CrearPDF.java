/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package Reportes;

import dto.DTOProducto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author jjbue
 */
/*@WebServlet(name = "CrearPDF", urlPatterns = {"/CrearPDF"})
public class CrearPDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    /*
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            /* TODO output your page here. You may use following sample code. */
            /*Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            documento.open();
            Image foto = Image.getInstance("C:\\Users\\Diego Ramirez\\Documents\\NetBeansProjects\\Reporte\\src\\java\\reporte\\paleta.png");
            foto.scaleToFit(100, 100);
            foto.setAlignment(Chunk.ALIGN_MIDDLE);
            documento.add(foto);
            documento.add(new Paragraph("Esto es el primer pÃ¡rrafo, normalito"));

            documento.add(new Paragraph("Este es el segundo y tiene una fuente rara", FontFactory.getFont("arial", // fuente
                    22, // tamaÃ±o
                    Font.ITALIC, // estilo
                    BaseColor.CYAN)));             // color

            PdfPTable tabla = new PdfPTable(3);
            for (int i = 0; i < 15; i++) {
                tabla.addCell("celda " + i);
            }
            documento.add(tabla);
            //imitacion de unos datos recuperado de la base de datos
            List<DTOProducto> products = new ArrayList<DTOProducto>();
            products.add(new DTOProducto("p01"));
            products.add(new DTOProducto("p02"));
            products.add(new DTOProducto("p03"));
            // List<Proucts> products=daoProductos.getProductos();
            
           
           for(int i=0;i<=2;i++){
            documento.add(new Paragraph(products.get(i).getTitulo()));}
            documento.close();

        } catch (Exception e) {
            System.out.println("Error: "+ e.toString());
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
   /* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
/*    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 /*   @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}*/
