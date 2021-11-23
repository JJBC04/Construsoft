/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author jjbue
 */
public class DTOObjetoPresupuesto {

    //public double cantidadTotalxMaterial;
    public int codigoMaterial, precioTotalxMaterial, cantidadTotalxMaterial, precioTotalMateriales, metrosConstruir;
    public String nombreMaterial, precioUnitarioxMaterial, unidadMedida;

    public DTOObjetoPresupuesto() {
    }

    public DTOObjetoPresupuesto(int codigoMaterial, int precioTotalxMaterial, int cantidadTotalxMaterial, int precioTotalMateriales, int metrosConstruir, String nombreMaterial, String precioUnitarioxMaterial, String unidadMedida) {
        this.codigoMaterial = codigoMaterial;
        this.precioTotalxMaterial = precioTotalxMaterial;
        this.cantidadTotalxMaterial = cantidadTotalxMaterial;
        this.precioTotalMateriales = precioTotalMateriales;
        this.metrosConstruir = metrosConstruir;
        this.nombreMaterial = nombreMaterial;
        this.precioUnitarioxMaterial = precioUnitarioxMaterial;
        this.unidadMedida = unidadMedida;
    }

    public int getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(int codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public int getPrecioTotalxMaterial() {
        return precioTotalxMaterial;
    }

    public void setPrecioTotalxMaterial(int precioTotalxMaterial) {
        this.precioTotalxMaterial = precioTotalxMaterial;
    }

    public int getCantidadTotalxMaterial() {
        return cantidadTotalxMaterial;
    }

    public void setCantidadTotalxMaterial(int cantidadTotalxMaterial) {
        this.cantidadTotalxMaterial = cantidadTotalxMaterial;
    }

    public int getPrecioTotalMateriales() {
        return precioTotalMateriales;
    }

    public void setPrecioTotalMateriales(int precioTotalMateriales) {
        this.precioTotalMateriales = precioTotalMateriales;
    }

    public int getMetrosConstruir() {
        return metrosConstruir;
    }

    public void setMetrosConstruir(int metrosConstruir) {
        this.metrosConstruir = metrosConstruir;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getPrecioUnitarioxMaterial() {
        return precioUnitarioxMaterial;
    }

    public void setPrecioUnitarioxMaterial(String precioUnitarioxMaterial) {
        this.precioUnitarioxMaterial = precioUnitarioxMaterial;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

}
