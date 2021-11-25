package Controladores;

import Modelos.DAOMaterial;
import Modelos.DTOMaterial;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jjbue
 */
@MultipartConfig
@WebServlet(name = "ControladorMaterial", urlPatterns = {"/ControladorMaterial"})
public class ControladorMaterial extends HttpServlet {
 //Variables donde estara la ruta para guardar la imagen referente al servidor
    private static final long serialVersionUID = 1L;
    private DAOMaterial DAOMaterial = new DAOMaterial();
    private String pathFiles = "D:\\xampp\\htdocs\\img";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
    int codigoMaterial;
    String ImgA;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("accion");

        switch (action) {
            case "Agregar":
                guardarMaterial(request, response);
                break;
            case "Listar":
               
                List<DTOMaterial> lista = DAOMaterial.Listar();
                request.setAttribute("materiales", lista);
                //List<DTOTipoMaterial> listaTM = DAOMaterial.ListarTipoMaterial();
                //request.setAttribute("tipoMateriales", listaTM);
                request.getRequestDispatcher("Materiales.jsp").forward(request, response);
                
                break;
            case"ListarParaUser":
                List<DTOMaterial> listaM = DAOMaterial.Listar();
                request.setAttribute("materiales", listaM);
                //List<DTOTipoMaterial> listaTMU = DAOMaterial.ListarTipoMaterial();
                //request.setAttribute("tipoMateriales", listaTMU);
                request.getRequestDispatcher("MaterialesU.jsp").forward(request, response);
                break;
            case "Cargar":
                codigoMaterial = Integer.parseInt(request.getParameter("codigoMaterial"));
                DTOMaterial material = DAOMaterial.ListarPorCodigo(codigoMaterial);
                ImgA = material.getRutaImagen();
                request.setAttribute("materialSeleccionado", material);
                request.getRequestDispatcher("ControladorMaterial?accion=Listar").forward(request, response);
                break;

            case "Actualizar":
                DTOMaterial material1 = new DTOMaterial();
                String nombreUpdate = request.getParameter("txtNombreMaterial");
                String imagenUpdate;
                int precioUpdate = Integer.parseInt(request.getParameter("txtPrecio"));
                //int tipoMaterialUpdate = Integer.parseInt(request.getParameter("txtTipoMaterial"));
                double cantidadMetroCuadradoUpdate = Double.parseDouble(request.getParameter("txtCantidadMetro"));
                imagenUpdate = request.getParameter("fileImagen");
                String unidadMedidaUpdate = request.getParameter("txtUnidadMedida");
                int codigoMaterialUP = Integer.parseInt(request.getParameter("codigoM"));
                
                if (imagenUpdate == null) {
                    imagenUpdate = request.getParameter("imgActu");
                }
                material1.setNombre(nombreUpdate);
                material1.setRutaImagen(imagenUpdate);
                material1.setPrecioMetroCuadrado(precioUpdate);
                //material1.setTipoMaterial(tipoMaterialUpdate);
                material1.setCantidadMetroCuadrado(cantidadMetroCuadradoUpdate);
                material1.setUnidadMedida(unidadMedidaUpdate);
                material1.setCodigoMaterial(codigoMaterialUP);
                DAOMaterial.Actualizar(material1);
                request.getRequestDispatcher("ControladorMaterial?accion=Listar").forward(request, response);
                break;

            case "Eliminar":
                codigoMaterialUP = Integer.parseInt(request.getParameter("codigoMaterial"));
                DAOMaterial.Eliminar(codigoMaterialUP);
                request.getRequestDispatcher("ControladorMaterial?accion=Listar").forward(request, response);
                break;
            default:
                break;
        }

    }

    private void guardarMaterial(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {

            String nombre = req.getParameter("txtNombreMaterial");
            Part part = req.getPart("fileImagen");
            Path path = Paths.get(part.getSubmittedFileName());
            String nombreI = path.getFileName().toString();
            String unidadMedida = req.getParameter("txtUnidadMedida");
            //int tipoMaterial = Integer.parseInt(req.getParameter("txtTipoMaterial"));
            int precio = Integer.parseInt(req.getParameter("txtPrecio"));
            int cantidadMaterialMetro = Integer.parseInt(req.getParameter("txtCantidadMetro"));
            
            int codigo_material = 0;
            if (part == null) {
                System.out.println("No ha seleccionado un archivo");
                return;
            }

            if (esExtension(part.getSubmittedFileName(), extens)) {
                String imagen = guardarArchivo(part, uploads);
                DTOMaterial material = new DTOMaterial(codigo_material,precio,cantidadMaterialMetro,nombre,nombreI, unidadMedida);
                
                
                
                DAOMaterial.Agregar(material);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
        }

        res.sendRedirect("ControladorMaterial?accion=Listar");
    }

    private String guardarArchivo(Part part, File pathUploads) {
        String pathAbsolute = "";

        try {

            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                File file = new File(pathUploads, fileName);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }

        } catch (IOException e) {
        }

        return pathAbsolute;
    }

    private boolean esExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }

        return false;
    }
}
