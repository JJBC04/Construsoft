package Modelos;

import Config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjbue
 */
public class DAOMaterial {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r = 0;
    int codigoM;

    public List Listar() {
        String consulta = "CALL sp_MostrarMaterial";
        List<DTOMaterial> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                DTOMaterial material = new DTOMaterial();
                material.setCodigoMaterial(rs.getInt("codigo_material"));
                material.setNombre(rs.getString("nombre"));
                material.setRutaImagen(rs.getString("ruta_imagen"));
                material.setPrecioMetroCuadrado(rs.getInt("precio_metro_cuadrado"));
                material.setCantidadMetroCuadrado(rs.getInt("cantidad_metro_cuadrado"));
                material.setUnidadMedida(rs.getString("unidad_medida"));
                material.setTxtTipoMaterial(rs.getString("tipo_material"));
                lista.add(material);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public DTOMaterial ListarPorCodigo(int codigoMaterial) {
        DTOMaterial material = new DTOMaterial();
        codigoM = codigoMaterial;
        String consulta = "SELECT * FROM tblmaterial WHERE codigo_material =" + codigoMaterial;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                material.setCodigoMaterial(rs.getInt(1));
                material.setNombre(rs.getString(2));
                material.setRutaImagen(rs.getString(3));
                material.setPrecioMetroCuadrado(rs.getInt(4));
                material.setCantidadMetroCuadrado(rs.getInt(5));
                material.setUnidadMedida(rs.getString(6));
            }
        } catch (SQLException ex) {

        }
        return material;
    }

    /* public void listarImagen(int codigoMaterial, HttpServletResponse response) {
        String consulta = "SELECT * FROM tblmaterial WHERE codigo_material =" + codigoMaterial;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            if (rs.next()) {
                inputStream = rs.getBinaryStream(3);
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {

        }

    }*/
    public int Agregar(DTOMaterial material) {
        String sentencia = "CALL sp_InsertarMaterial(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, material.getNombre());
            ps.setString(2, material.getRutaImagen());
            ps.setInt(3, material.getPrecioMetroCuadrado());
            ps.setInt(4, material.getCantidadMetroCuadrado());
            ps.setString(5, material.getUnidadMedida());
            ps.setInt(6, material.getTipoMaterial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public int Actualizar(DTOMaterial material) {
        String sentencia = "UPDATE tblmaterial set nombre=?,ruta_imagen=?,precio_metro_cuadrado=?,cantidad_metro_cuadrado=?,tipo_material=? WHERE codigo_material=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, material.getNombre());
            ps.setString(2, material.getRutaImagen());
            ps.setInt(3, material.getPrecioMetroCuadrado());
            ps.setInt(4, material.getCantidadMetroCuadrado());
            ps.setInt(5, material.getTipoMaterial());
            ps.setString(6, material.getUnidadMedida());
            ps.setInt(7, material.getCodigoMaterial());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Eliminar(int codigoMaterial) {

        String sql = "DELETE FROM tblmaterial WHERE codigo_material=" + codigoMaterial;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List ListarTipoMaterial() {
        String consulta = "CALL sp_MostrarTipoMaterial() ";
        List<DTOTipoMaterial> listaTM = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                DTOTipoMaterial tipoMaterial = new DTOTipoMaterial();
                tipoMaterial.setCodigo(rs.getInt("codigo"));
                tipoMaterial.setNombre(rs.getString("nombre"));

                listaTM.add(tipoMaterial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTM;

    }
}
