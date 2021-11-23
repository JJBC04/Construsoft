/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjbue
 */
public class DAOPresupuesto {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    DAOMaterial DAOMaterial = new DAOMaterial();
    int r;
    int p = 0;

    public int AgregarPresupuesto(DTOPresupuesto presupuesto) {
        String sentencia = "INSERT INTO tblpresupuesto(nombre,descripcion,fecha,cantidad_mc_construir,valor_total,usuario)VALUES(?,?,now(),?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, presupuesto.getNombrePresupuesto());
            ps.setString(2, presupuesto.getDescripcionPresupuesto());
            ps.setInt(3, presupuesto.getMetrosConstruir());
            ps.setInt(4, presupuesto.getValorTotal());
            ps.setInt(5, presupuesto.getCodigoUsuario());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int UltimoPresupuesto(int cedulaUser) throws SQLException {
        //Sentencia ultimo
        String consulta = "SELECT codigo_presupuesto FROM tblpresupuesto WHERE usuario = " + cedulaUser + " ORDER BY codigo_presupuesto DESC LIMIT 1;";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = (rs.getInt("codigo_presupuesto"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }

    public int AgregarTablaUser(List<DTOMaterial> materialBD) throws SQLException {
        String sentencia = "INSERT INTO tblmaterial_usuario (nombre, precio_metro_cuadrado, cantidad_metro_cuadrado, unidad_medida, codigo_presupuesto) VALUES(?,?,?,?," + p + ")";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            for (DTOMaterial material : materialBD) {
                ps.setString(1, material.getNombre());
                ps.setInt(2, material.getPrecioMetroCuadrado());
                ps.setDouble(3, material.getCantidadMetroCuadrado());
                ps.setString(4, material.getUnidadMedida());
                ps.executeUpdate();
            }

        } catch (SQLException ex) {

        }
        return r;
    }

    public List HacerPresupuesto(int metrosConstruir) throws SQLException {
        String consulta = "SELECT codigo_material, nombre, precio_metro_cuadrado,cantidad_metro_cuadrado,unidad_medida FROM tblmaterial_usuario WHERE codigo_presupuesto = " + p + ";";
        System.out.println(p);
        List<DTOObjetoPresupuesto> lista = new ArrayList<>();
        int mConstruir = metrosConstruir;
        int totalPrecioMateriales = 0;
        con = cn.Conexion();
        ps = con.prepareStatement(consulta);
        rs = ps.executeQuery();
        while (rs.next()) {
            DecimalFormat formatea = new DecimalFormat("###,###");
            DTOObjetoPresupuesto objectoPresupuesto = new DTOObjetoPresupuesto();

            int precioMCxMaterial = (int) Math.ceil(mConstruir * (rs.getDouble("cantidad_metro_cuadrado")));
            objectoPresupuesto.setCodigoMaterial(rs.getInt("codigo_material"));
            objectoPresupuesto.setCantidadTotalxMaterial((int) Math.ceil(mConstruir * (rs.getDouble("cantidad_metro_cuadrado"))));
            objectoPresupuesto.setPrecioUnitarioxMaterial(formatea.format(precioMCxMaterial * (rs.getInt("precio_metro_cuadrado"))));
            objectoPresupuesto.setNombreMaterial(rs.getString("nombre"));
            objectoPresupuesto.setUnidadMedida(rs.getString("unidad_medida"));
            totalPrecioMateriales += precioMCxMaterial * rs.getInt("precio_metro_cuadrado");
            objectoPresupuesto.setPrecioTotalMateriales(totalPrecioMateriales);
            objectoPresupuesto.setMetrosConstruir(metrosConstruir);
            lista.add(objectoPresupuesto);
        }

        return lista;
    }

    public int AgregarMaterialUser(DTOMaterial material) {
        String sentencia = "INSERT INTO tblmaterial_usuario (nombre, precio_metro_cuadrado, cantidad_metro_cuadrado, unidad_medida, codigo_presupuesto) VALUES(?,?,?,?," + p + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, material.getNombre());
            ps.setInt(2, material.getPrecioMetroCuadrado());
            ps.setDouble(3, material.getCantidadMetroCuadrado());
            ps.setString(4, material.getUnidadMedida());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public int ActualizarPresupuesto(DTOPresupuesto presupuesto) {
        String sentencia = "UPDATE tblpresupuesto SET nombre = ?, descripcion = ?,cantidad_mc_construir = ?, valor_total= ? WHERE codigo_presupuesto =" + p + ";";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, presupuesto.getNombrePresupuesto());
            ps.setString(2, presupuesto.getDescripcionPresupuesto());
            ps.setInt(3, presupuesto.getMetrosConstruir());
            ps.setInt(4, presupuesto.getValorTotal());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public DTOMaterial SeleccionarMaterial(int codigoMaterial) {
        DTOMaterial material = new DTOMaterial();

        String consulta = "SELECT codigo_material,nombre, precio_metro_cuadrado, cantidad_metro_cuadrado, unidad_medida FROM tblmaterial_usuario WHERE codigo_material =" + codigoMaterial;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                material.setCodigoMaterial(rs.getInt(1));
                material.setNombre(rs.getString(2));
                material.setPrecioMetroCuadrado(rs.getInt(3));
                material.setCantidadMetroCuadrado(rs.getDouble(4));
                material.setUnidadMedida(rs.getString(5));
            }
        } catch (SQLException ex) {

        }
        return material;
    }

    public DTOPresupuesto SeleccionarPresupuestoReciente() {
        String consulta = "SELECT nombre, descripcion, fecha, cantidad_mc_construir, valor_total, usuario FROM tblpresupuesto WHERE codigo_presupuesto =" + p;
        DTOPresupuesto presupuestoReciente = new DTOPresupuesto();
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {

                presupuestoReciente.setCodigoPresupuesto(p);
                presupuestoReciente.setNombrePresupuesto(rs.getString("nombre"));
                presupuestoReciente.setDescripcionPresupuesto(rs.getString("descripcion"));
                presupuestoReciente.setMetrosConstruir(rs.getInt("cantidad_mc_construir"));
                presupuestoReciente.setCodigoUsuario(rs.getInt("usuario"));

            }
        } catch (SQLException ex) {

        }
        return presupuestoReciente;
    }

    public int ActualizarMaterialPresupuesto(DTOMaterial materialPresupuesto) throws SQLException {
        String consulta = "UPDATE tblmaterial_usuario SET nombre = ?,precio_metro_cuadrado = ?, cantidad_metro_cuadrado = ?, unidad_medida = ? WHERE codigo_material = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            ps.setString(1, materialPresupuesto.getNombre());
            ps.setInt(2, materialPresupuesto.getPrecioMetroCuadrado());
            ps.setDouble(3, materialPresupuesto.getCantidadMetroCuadrado());
            ps.setString(4, materialPresupuesto.getUnidadMedida());
            ps.setInt(5, materialPresupuesto.getCodigoMaterial());
            ps.executeUpdate();
        } catch (SQLException ex) {

        }
        return r;
    }

    public void EliminarMaterial(int codigoMaterial) {
        String sql = "DELETE FROM tblmaterial_usuario WHERE codigo_material=" + codigoMaterial;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List CodigoPresupuesto() {
        String sql = "SELECT codigo_presupuesto FROM tblpresupuesto WHERE nombre = 'Nombre Sin Definir'";
        List<DTOPresupuesto> ListaCodigos = new ArrayList<>();
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DTOPresupuesto presupuesto = new DTOPresupuesto();
                presupuesto.setCodigoPresupuesto(rs.getInt("codigo_presupuesto"));
                ListaCodigos.add(presupuesto);
            }
        } catch (SQLException ex) {

        }
        EliminarMaterialesPresupuestinSinGuardar(ListaCodigos);
        return ListaCodigos;

    }

    public void EliminarMaterialesPresupuestinSinGuardar(List<DTOPresupuesto> Lista) {
        for (DTOPresupuesto objeto : Lista) {
            String sql = "DELETE FROM tblmaterial_usuario WHERE codigo_presupuesto =" + objeto.getCodigoPresupuesto();
            con = cn.Conexion();
            try {
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ValidarPresupuestoSinGuardar() {
        String sql = "DELETE FROM tblpresupuesto WHERE nombre = 'Nombre Sin Definir'";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List ListarPresupuesto(int cedulaUser) {
        String consulta = "SELECT codigo_presupuesto, nombre, descripcion,fecha, cantidad_mc_construir, valor_total, usuario FROM tblpresupuesto WHERE usuario = " + cedulaUser;
        List<DTOPresupuesto> listaPresupuesto = new ArrayList<>();
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                DTOPresupuesto presupuesto = new DTOPresupuesto();
                presupuesto.setCodigoPresupuesto(rs.getInt("codigo_presupuesto"));
                presupuesto.setNombrePresupuesto(rs.getString("nombre"));
                presupuesto.setDescripcionPresupuesto(rs.getString("descripcion"));
                presupuesto.setFechaPresupuesto(rs.getDate("fecha"));
                presupuesto.setMetrosConstruir(rs.getInt("cantidad_mc_construir"));
                presupuesto.setValorTotal(rs.getInt("valor_total"));
                presupuesto.setCodigoUsuario(rs.getInt("usuario"));
                listaPresupuesto.add(presupuesto);
            }
        } catch (SQLException ex) {
        }
        return listaPresupuesto;
    }

    public DTOPresupuesto SeleccionarPresupuesto(int codigoPresupuesto) throws SQLException {
        String consulta = "SELECT codigo_presupuesto,nombre, descripcion, fecha, cantidad_mc_construir, valor_total, usuario FROM tblpresupuesto WHERE codigo_presupuesto =" + codigoPresupuesto;
        DTOPresupuesto presupuestoReciente = new DTOPresupuesto();
        int mCons = 0;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                presupuestoReciente.setCodigoPresupuesto(rs.getInt("codigo_presupuesto"));
                presupuestoReciente.setNombrePresupuesto(rs.getString("nombre"));
                presupuestoReciente.setDescripcionPresupuesto(rs.getString("descripcion"));
                presupuestoReciente.setMetrosConstruir(rs.getInt("cantidad_mc_construir"));
                presupuestoReciente.setCodigoUsuario(rs.getInt("usuario"));
                p = rs.getInt("codigo_presupuesto");
                mCons = (rs.getInt("cantidad_mc_construir"));
            }
        } catch (SQLException ex) {

        }

        HacerPresupuesto(mCons);
        System.out.println(mCons);
        return presupuestoReciente;
    }

    public void EliminarMaterialPresupuesto(int codigoPresupuesto) {
        String sql = "DELETE FROM tblmaterial_usuario WHERE codigo_presupuesto =" + codigoPresupuesto;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarPresupuestoUsuarioEliminar(int cedulaUser) {
        EliminarMaterialesPresupuestinSinGuardar(ListarPresupuesto(cedulaUser));

        String sql = "DELETE FROM tblpresupuesto WHERE usuario =" + cedulaUser;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarPresupuesto(int codigoPresupuesto) {
        EliminarMaterialPresupuesto(codigoPresupuesto);

        String sql = "DELETE FROM tblpresupuesto WHERE codigo_presupuesto =" + codigoPresupuesto;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
