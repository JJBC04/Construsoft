package Modelos;

import java.util.Date;

/**
 *
 * @author jjbue
 */
public class DTOPresupuesto {
    private String nombrePresupuesto,nombreUsuario, fechaPresuestoCadena;
    private int metrosConstruir, codigoUsuario;
    private Date fechaPresupuesto;

    public DTOPresupuesto() {
    }
    public DTOPresupuesto(String nombrePresupuesto, String nombreUsuario, String fechaPresuestoCadena, int metrosConstruir, int codigoUsuario, Date fechaPresupuesto) {
        this.nombrePresupuesto = nombrePresupuesto;
        this.nombreUsuario = nombreUsuario;
        this.fechaPresuestoCadena = fechaPresuestoCadena;
        this.metrosConstruir = metrosConstruir;
        this.codigoUsuario = codigoUsuario;
        this.fechaPresupuesto = fechaPresupuesto;
    }

    public String getNombrePresupuesto() {
        return nombrePresupuesto;
    }

    public void setNombrePresupuesto(String nombrePresupuesto) {
        this.nombrePresupuesto = nombrePresupuesto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaPresuestoCadena() {
        return fechaPresuestoCadena;
    }

    public void setFechaPresuestoCadena(String fechaPresuestoCadena) {
        this.fechaPresuestoCadena = fechaPresuestoCadena;
    }

    public int getMetrosConstruir() {
        return metrosConstruir;
    }

    public void setMetrosConstruir(int metrosConstruir) {
        this.metrosConstruir = metrosConstruir;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getFechaPresupuesto() {
        return fechaPresupuesto;
    }

    public void setFechaPresupuesto(Date fechaPresupuesto) {
        this.fechaPresupuesto = fechaPresupuesto;
    }
    

    
}
