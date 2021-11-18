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
    public int precioTotalxMaterial,cantidadTotalxMaterial,precioTotalMateriales;
    public String nombreMaterial,precioUnitarioxMaterial;
    //public List nombreMaterial;   
    // public List cantidadMetroCuadrado;

    public DTOObjetoPresupuesto() {
    }

    public DTOObjetoPresupuesto(int precioTotalxMaterial, int cantidadTotalxMaterial, int precioTotalMateriales, String nombreMaterial, String precioUnitarioxMaterial) {
        this.precioTotalxMaterial = precioTotalxMaterial;
        this.cantidadTotalxMaterial = cantidadTotalxMaterial;
        this.precioTotalMateriales = precioTotalMateriales;
        this.nombreMaterial = nombreMaterial;
        this.precioUnitarioxMaterial = precioUnitarioxMaterial;
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

    
   
}
   
