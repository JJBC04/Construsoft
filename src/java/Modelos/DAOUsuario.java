package Modelos;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsuario {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public DTOUsuario BuscarCliente(int cedula) {
        DTOUsuario usuario = new DTOUsuario();
        String consulta = "SELECT tblusuario.cedula, tblusuario.nombre, tblusuario.apellido,tblusuario.correo,tblusuario.clave,tblrol.nombre FROM tblusuario JOIN tblrol ON tblusuario.rol = tblrol.codigo WHERE cedula = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCedula(rs.getInt("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRol(rs.getInt("rol"));
                System.err.println("" + usuario.getNombre());
            }
        } catch (SQLException ex) {
        }
        return usuario;
    }

    public DTOUsuario Validar(String correo, String clave) {
        DTOUsuario usuario = new DTOUsuario();
        String consulta = "SELECT * FROM tblusuario WHERE correo = ? AND clave = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            rs.next();
            do {
                usuario.setCedula(rs.getInt("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRol(rs.getInt("rol"));
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public List Listar() {
        String consulta = "CALL sp_MostrarUsuarios";
        List<DTOUsuario> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                DTOUsuario usuario = new DTOUsuario();
                usuario.setCedula(rs.getInt("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTxtRol(rs.getString("tblrol.nombre"));
                lista.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return lista;

    }

    public int Agregar(DTOUsuario usuario) {

        String sentencia = "CALL sp_InsertarUsuario(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getClave());
            ps.setInt(6, usuario.getRol());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public DTOUsuario ListarPorId(int cedula) {
        DTOUsuario usuario = new DTOUsuario();
        String consulta = "CALL sp_MostrarUsuarioIndividual(" + cedula + ")";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCedula(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setCorreo(rs.getString(4));
                usuario.setClave(rs.getString(5));
                usuario.setRol(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;

    }

    public int Actualizar(DTOUsuario usuario) {
        String sentencia = "UPDATE tblusuario set cedula=?,nombre=?,apellido=?,correo=?,clave=?,rol=? WHERE cedula=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getClave());
            ps.setInt(6, usuario.getRol());
            ps.setInt(7, usuario.getCedula());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Eliminar(int cedula) {

        String sql = "DELETE FROM tblusuario WHERE cedula=" + cedula;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List ListarRol() {
        String sql = "CALL sp_MostrarRol";
        List<DTORol> listaRol = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DTORol rol = new DTORol();
                rol.setCodigo(rs.getInt("Codigo"));
                rol.setNombre(rs.getString("Nombre"));
                listaRol.add(rol);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listaRol;
    }

}
