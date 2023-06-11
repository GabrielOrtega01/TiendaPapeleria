package modelo;

import java.time.LocalDate;

public class MovimientoVista {

    private int idmovimiento;
    private LocalDate fecha;
    private int cantidad;
    private String nombreApellido;
    private String apellido;
    private String nombreart;
    private String nombreopr;

    public MovimientoVista() {
        this.idmovimiento = 0;
        this.fecha = LocalDate.parse("1900-01-01");
        this.cantidad = 0;
        this.nombreApellido = "";
        this.apellido = "";
        this.nombreart = "";
        this.nombreopr = "";
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getNombreart() {
        return nombreart;
    }

    public void setNombreart(String nombreart) {
        this.nombreart = nombreart;
    }

    public String getNombreopr() {
        return nombreopr;
    }

    public void setNombreopr(String nombreopr) {
        this.nombreopr = nombreopr;
    }

    @Override
    public String toString() {
        return "MovimientoVista{" + "idmovimiento=" + idmovimiento + ", fecha=" + fecha + ", cantidad=" + cantidad + ", nombreApellido=" + nombreApellido + ", nombreart=" + nombreart + ", nombreopr=" + nombreopr + '}';
    }

}
