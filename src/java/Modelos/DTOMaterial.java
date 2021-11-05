package Modelos;

/**
 *
 * @author jjbue
 */
public class DTOMaterial {

    private int codigoMaterial, precioMetroCuadrado, cantidadMetroCuadrado, tipoMaterial;
    private String nombre, rutaImagen, txtTipoMaterial, unidadMedida;

    public DTOMaterial() {
    }

    public DTOMaterial(int codigoMaterial, int precioMetroCuadrado, int cantidadMetroCuadrado, int tipoMaterial, String nombre, String rutaImagen, String txtTipoMaterial, String unidadMedida) {
        this.codigoMaterial = codigoMaterial;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.cantidadMetroCuadrado = cantidadMetroCuadrado;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.tipoMaterial = tipoMaterial;
        this.txtTipoMaterial = txtTipoMaterial;
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

    public int getCantidadMetroCuadrado() {
        return cantidadMetroCuadrado;
    }

    public void setCantidadMetroCuadrado(int cantidadMetroCuadrado) {
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

    public int getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(int tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getTxtTipoMaterial() {
        return txtTipoMaterial;
    }

    public void setTxtTipoMaterial(String txtTipoMaterial) {
        this.txtTipoMaterial = txtTipoMaterial;
    }
}
