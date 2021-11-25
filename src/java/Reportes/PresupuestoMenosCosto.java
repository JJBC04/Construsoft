/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Config.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjbue
 */
@WebServlet(name = "PresupuestoMenosCosto", urlPatterns = {"/PresupuestoMenosCosto"})
public class PresupuestoMenosCosto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        try {
            try {
                Connection con;
                PreparedStatement ps;
                ResultSet rs;
                Conexion cn = new Conexion();
                con = cn.Conexion();

                ps = con.prepareStatement("SELECT tblusuario.cedula,tblusuario.nombre,tblpresupuesto.fecha,tblpresupuesto.valor_total FROM tblusuario INNER JOIN  tblpresupuesto on tblusuario.cedula = tblpresupuesto.usuario ORDER by tblpresupuesto.valor_total   ASC LIMIT 5");
                rs = ps.executeQuery();

                if (con != null) {
                    try {
                        Document documento = new Document();
                        PdfWriter.getInstance(documento, out);

                        documento.open();
                        Image imagen = Image.getInstance("D:\\Proyectos\\proyectos NetBeans\\Construsoft\\web\\img\\Logo.png");
                        imagen.setAlignment(Element.ALIGN_LEFT);
                        imagen.scaleToFit(100, 100);
                        documento.add(imagen);

                        Paragraph par1 = new Paragraph();
                        Font fonttitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                        par1.add(new Phrase("Reporte #5 Construsoft", fonttitulo));
                        par1.setAlignment(Element.ALIGN_CENTER);
                        par1.add(new Phrase(Chunk.NEWLINE));
                        par1.add(new Phrase(Chunk.NEWLINE));

                        documento.add(par1);

                        Paragraph par2 = new Paragraph();
                        Font fontdescrip = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.ITALIC, BaseColor.DARK_GRAY);
                        par2.add(new Phrase("Reporte sobre los usuarios con presupuesto con menor costo.", fontdescrip));
                        par2.setAlignment(Element.ALIGN_JUSTIFIED);
                        par2.add(new Phrase(Chunk.NEWLINE));
                        par2.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par2);

                        PdfPTable tabla = new PdfPTable(4);
                        PdfPCell celda1 = new PdfPCell(new Paragraph("Cedula", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        PdfPCell celda3 = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        PdfPCell celda4 = new PdfPCell(new Paragraph("Valor Total", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                        tabla.addCell(celda1);
                        tabla.addCell(celda2);
                        tabla.addCell(celda3);
                        tabla.addCell(celda4);

                        while (rs.next()) {
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));
                        }

                        documento.add(tabla);

                        documento.close();
                    } catch (DocumentException | IOException ex) {
                        ex.getMessage();
                    }
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }

        } finally {

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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
