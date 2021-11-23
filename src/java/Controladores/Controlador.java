package Controladores;

import Modelos.DAOUsuario;
import Modelos.DTORol;
import Modelos.DTOUsuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jjbue
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
@MultipartConfig
public class Controlador extends HttpServlet {
    //Instanciar objetos DTO con los datos y DAO con las funciones
    DTOUsuario DTOUsuario = new DTOUsuario(); 
    DAOUsuario DAOUsuario = new DAOUsuario();
    int cedulaUsuario;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String rolm = request.getParameter("Rol");
        //Redireccionar a las respectivas paginas
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        //Comprueba que menu es y la accion correspondiente
        if (menu.equals("Usuario")) {
            switch (accion) {
                case "Listar":
                    //Si el caso es listar, trae los todos los registros de la tblusuario(Administrador)
                    List<DTOUsuario> lista = DAOUsuario.Listar();
                    request.setAttribute("usuarios", lista);
                    List<DTORol> listaR = DAOUsuario.ListarRol();
                    request.setAttribute("userRol", listaR);
                    request.getRequestDispatcher("Usuarios.jsp").forward(request, response);

                    break;
                case "Agregar Usuario":
                    //Captura los datos de la vista, asigna a variables y luego estas a un objeto DTO
                    int cedulaU = Integer.parseInt(request.getParameter("txtcedula"));
                    String nombreU = request.getParameter("txtnombre");
                    String apellidoU = request.getParameter("txtapellido");
                    String correoU = request.getParameter("txtcorreo");
                    String claveU = request.getParameter("txtclave");
                    int rolU = Integer.parseInt(request.getParameter("txtrol"));

                    DTOUsuario.setCedula(cedulaU);
                    DTOUsuario.setNombre(nombreU);
                    DTOUsuario.setApellido(apellidoU);
                    DTOUsuario.setCorreo(correoU);
                    DTOUsuario.setClave(claveU);
                    DTOUsuario.setRol(rolU);
                    //La funcion DAOagregar realiza un INSERT en la tblusuario
                    DAOUsuario.Agregar(DTOUsuario);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    //Cuando el usuario se registra
                    int cedula = Integer.parseInt(request.getParameter("txtcedula"));
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    String correo = request.getParameter("txtcorreo");
                    String clave = request.getParameter("txtclave");
                    int rol = Integer.parseInt(request.getParameter("txtrol"));

                    DTOUsuario.setCedula(cedula);
                    DTOUsuario.setNombre(nombre);
                    DTOUsuario.setApellido(apellido);
                    DTOUsuario.setCorreo(correo);
                    DTOUsuario.setClave(clave);
                    DTOUsuario.setRol(rol);
                    //Se llama DAOAgregar y se envia el objeto con los datos ingresados por el user
                    DAOUsuario.Agregar(DTOUsuario);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;

                case "Actualizar":
                    //Se actualiza desde la vista del administrador
                    DTOUsuario usuario1 = new DTOUsuario();
                    int cedulaUpdate = Integer.parseInt(request.getParameter("txtcedula"));
                    String nombreUpdate = request.getParameter("txtnombre");
                    String apellidoUpdate = request.getParameter("txtapellido");
                    String correoUpdate = request.getParameter("txtcorreo");
                    String claveUpdate = request.getParameter("txtclave");
                    int rolUpdate = Integer.parseInt(request.getParameter("txtrol"));
                    usuario1.setCedula(cedulaUpdate);
                    usuario1.setNombre(nombreUpdate);
                    usuario1.setApellido(apellidoUpdate);
                    usuario1.setCorreo(correoUpdate);
                    usuario1.setClave(claveUpdate);
                    usuario1.setRol(rolUpdate);
                    DAOUsuario.Actualizar(usuario1);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                    
                case "Actualizar Datos":
                    //Actualizar desde el usuario
                    DTOUsuario usuario2 = new DTOUsuario();
                    int cedulaUpdateU = Integer.parseInt(request.getParameter("txtcedula"));
                    String nombreUpdateU = request.getParameter("txtnombre");
                    String apellidoUpdateU = request.getParameter("txtapellido");
                    String correoUpdateU = request.getParameter("txtcorreo");
                    String claveUpdateU = request.getParameter("txtclave");
                    int rolUpdateU = Integer.parseInt(request.getParameter("txtrol"));
                    usuario2.setCedula(cedulaUpdateU);
                    usuario2.setNombre(nombreUpdateU);
                    usuario2.setApellido(apellidoUpdateU);
                    usuario2.setCorreo(correoUpdateU);
                    usuario2.setClave(claveUpdateU);
                    usuario2.setRol(rolUpdateU);
                    DAOUsuario.Actualizar(usuario2);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=ListarUser").forward(request, response);
                    break;
                case "Cargar":
                    //Cuando el administrador seleciona un registro para editar
                    cedulaUsuario = Integer.parseInt(request.getParameter("Cedula"));
                    DTOUsuario usuario = DAOUsuario.ListarPorId(cedulaUsuario);
                    request.setAttribute("usuarioSeleccionado", usuario);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    //Cuando el administrador seleciona un registro para eliminar
                    cedulaUsuario = Integer.parseInt(request.getParameter("Cedula"));
                    DAOUsuario.Eliminar(cedulaUsuario);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "ListarUser":
                     //Trae los registros del usuario especifico(Administrador, Usuario)
                    cedulaUsuario = Integer.parseInt(request.getParameter("cedula"));
                    DTOUsuario usser = DAOUsuario.ListarPorId(cedulaUsuario);
                    request.setAttribute("usuarioSeleccionado", usser);
                    request.getRequestDispatcher("editarPerfilUser.jsp").forward(request, response);
                    break;

                case "AgregarUsuario":
                    
                    List<DTORol> listaRol = DAOUsuario.ListarRol();
                    request.setAttribute("rol", listaRol);
                    request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                    break;
                case "Salir":
                    //Se eliima la sesion
                    HttpSession session = request.getSession();
                    session.invalidate();
                    request.getRequestDispatcher("index.html").forward(request, response);
                    break;

            }
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
