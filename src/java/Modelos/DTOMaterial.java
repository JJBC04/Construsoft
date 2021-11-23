package Modelos;

/**
 *
 * @author jjbue
 */
public class DTOMaterial {

    private int codigoMaterial, precioMetroCuadrado;
    private String nombre, rutaImagen, unidadMedida;
    private double cantidadMetroCuadrado;

    public DTOMaterial() {
    }

    public DTOMaterial(int codigoMaterial, int precioMetroCuadrado, double cantidadMetroCuadrado, String nombre, String rutaImagen, String unidadMedida) {
        this.codigoMaterial = codigoMaterial;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.cantidadMetroCuadrado = cantidadMetroCuadrado;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        //this.tipoMaterial = tipoMaterial;
        //this.txtTipoMaterial = txtTipoMaterial;
        this.unidadMedida = unidadMedida;
    }

    public int getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(int codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public int getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public void setPrecioMetroCuadrado(int precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public double getCantidadMetroCuadrado() {
        return cantidadMetroCuadrado;
    }

    public void setCantidadMetroCuadrado(double cantidadMetroCuadrado) {
        this.cantidadMetroCuadrado = cantidadMetroCuadrado;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

}
