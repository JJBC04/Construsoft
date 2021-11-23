package Reportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Config.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.mysql.cj.xdevapi.Statement;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EDWIN
 */
@WebServlet(urlPatterns = {"/MaterialMasCostoso"})
public class MaterialMasCostoso extends HttpServlet {

    @SuppressWarnings("empty-statement")
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
                ps = con.prepareStatement("SELECT tblmaterial.codigo_material, tblmaterial.nombre, tblmaterial.precio_metro_cuadrado FROM tblmaterial ORDER BY tblmaterial.precio_metro_cuadrado DESC LIMIT 1;");
                rs = ps.executeQuery();

                if (con != null) {
                    try {
                        Document documento = new Document();
                        PdfWriter.getInstance(documento, out);

                        documento.open();

                        Paragraph par1 = new Paragraph();
                        Font fontitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                        par1.add(new Phrase("Reporte con  Itexpdf.jar", fontitulo));
                        par1.setAlignment(Element.ALIGN_CENTER);
                        par1.add(new Phrase(Chunk.NEWLINE));
                        par1.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par1);

                        Paragraph par2 = new Paragraph();
                        Font fontDescripcion = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                        par2.add(new Phrase("Para hacer este reporte en formato pdf  hacemos uso de la"
                                + "libreria itextpdf.jar y el uso de sevlet para programarlo este documento" + " es un claro ejemplo", fontDescripcion));
                        par2.setAlignment(Element.ALIGN_CENTER);
                        par2.add(new Phrase(Chunk.ALIGN_JUSTIFIED));
                        par2.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par2);
                        Image imagenes = Image.getInstance("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\logo.jpg");
                        imagenes.setAlignment(Element.ALIGN_CENTER);

                        imagenes.scaleToFit(100, 100);
                        documento.add(imagenes);
                        
                        Paragraph par3 = new Paragraph();
                        par3.add(new Phrase("Los Materiales mas costosos"));
                        par3.setAlignment(Element.ALIGN_CENTER);
                        par3.add(new Phrase(Chunk.ALIGN_JUSTIFIED));
                        par3.add(new Phrase(Chunk.NEWLINE));
                        par3.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par3);
                       
                        PdfPTable tabla = new PdfPTable(3);
                        PdfPCell celda1 = new PdfPCell(new Paragraph("Codigo Material", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
                        PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
                        PdfPCell celda3 = new PdfPCell(new Paragraph("Precio metro cuadrado", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
                        tabla.addCell(celda1);
                        tabla.addCell(celda2);
                        tabla.addCell(celda3);
                        while (rs.next()) {
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                        }

                        documento.add(tabla);
                        documento.close();

                    } catch (Exception ex) {
                        ex.getMessage();
                    }

                } else {
                    System.out.println("NO CONECTA PA");
                }

            } catch (Exception ex) {
                ex.getMessage();
            }

        } finally {
            out.close();
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
