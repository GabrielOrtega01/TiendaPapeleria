package modelo;

import java.time.LocalDate;

public class AdministrarInventarioArticulo {

    private String operacion;
    private int cantidad;
    private LocalDate fecha_de_operacion;
    private String responsable_de_la_operacion;

    public AdministrarInventarioArticulo() {
        this.operacion = "";
        this.cantidad = 0;
        this.fecha_de_operacion = LocalDate.parse("1900-01-01");
        this.responsable_de_la_operacion = "";
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_de_operacion() {
        return fecha_de_operacion;
    }

    public void setFecha_de_operacion(LocalDate fecha_de_operacion) {
        this.fecha_de_operacion = fecha_de_operacion;
    }

    public String getResponsable_de_la_operacion() {
        return responsable_de_la_operacion;
    }

    public void setResponsable_de_la_operacion(String responsable_de_la_operacion) {
        this.responsable_de_la_operacion = responsable_de_la_operacion;
    }

    @Override
    public String toString() {
        return "AdministrarInventarioArticulo{" + "operacion=" + operacion + ", cantidad=" + cantidad + ", fecha_de_operacion=" + fecha_de_operacion + ", responsable_de_la_operacion=" + responsable_de_la_operacion + '}';
    }

}
