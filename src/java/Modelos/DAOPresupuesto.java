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

/**
 *
 * @author jjbue
 */
public class DAOPresupuesto {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public int AgregarPresupuesto(DTOPresupuesto presupuesto) {
        String sentencia = "INSERT INTO tblpresupuesto VALUES(null, ?, ?, CURRENT_DATE, ?)";
        try {
//            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, presupuesto.getNombrePresupuesto());
            ps.setInt(2, presupuesto.getMetrosConstruir());
            ps.setInt(3, presupuesto.getCodigoUsuario());

        } catch (SQLException e) {
        }
        return r;
    }

    public List TraerCantidadMetroCuadrado(int metrosConstruir) throws SQLException {
        String consulta = "SELECT nombre, precio_metro_cuadrado,cantidad_metro_cuadrado FROM tblmaterial;";
        List<DTOObjetoPresupuesto> lista = new ArrayList<>();
        //ArrayList<Double> cantidadMetroCua = new ArrayList<>();
        int mConstruir = metrosConstruir;
        int totalPrecioMateriales = 0;
        con = cn.Conexion();
        ps = con.prepareStatement(consulta);
        rs = ps.executeQuery();
        while (rs.next()) {

            DecimalFormat formatea = new DecimalFormat("###,###");
            DTOObjetoPresupuesto objectoPresupuesto = new DTOObjetoPresupuesto();
            //op.setCantidadMetroCuadrado(rs.getInt("cantidad_metro_cuadrado"));
            int precioMCxMaterial = (int) Math.ceil(mConstruir * (rs.getDouble("cantidad_metro_cuadrado")));
            objectoPresupuesto.setCantidadTotalxMaterial((int) Math.ceil(mConstruir * (rs.getDouble("cantidad_metro_cuadrado"))));
            objectoPresupuesto.setPrecioUnitarioxMaterial(formatea.format(precioMCxMaterial * (rs.getInt("precio_metro_cuadrado"))));
            objectoPresupuesto.setNombreMaterial(rs.getString("nombre"));
            totalPrecioMateriales += precioMCxMaterial * rs.getInt("precio_metro_cuadrado");
            objectoPresupuesto.setPrecioTotalMateriales(totalPrecioMateriales);
            lista.add(objectoPresupuesto);
        }

        return lista;
    }

}
