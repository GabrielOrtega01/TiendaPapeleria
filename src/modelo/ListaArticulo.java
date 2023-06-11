package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ListaArticulo {

    private String codigo;
    private String articulo;
    private int cantidad;
    private int preciounitario;
    private BigDecimal dinero_invertido;
    private LocalDate fecha_de_ingreso;
    private String responsable_del_ingreso;

    public ListaArticulo() {
        this.codigo = "";
        this.articulo = "";
        this.cantidad = 0;
        this.preciounitario = 0;
        this.dinero_invertido = BigDecimal.ZERO;
        this.fecha_de_ingreso = LocalDate.parse("1900-01-01");
        this.responsable_del_ingreso = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigDecimal getDinero_invertido() {
        return dinero_invertido;
    }

    public void setDinero_invertido(BigDecimal dinero_invertido) {
        this.dinero_invertido = dinero_invertido;
    }

    public LocalDate getFecha_de_ingreso() {
        return fecha_de_ingreso;
    }

    public void setFecha_de_ingreso(LocalDate fecha_de_ingreso) {
        this.fecha_de_ingreso = fecha_de_ingreso;
    }

    public String getResponsable_del_ingreso() {
        return responsable_del_ingreso;
    }

    public void setResponsable_del_ingreso(String responsable_del_ingreso) {
        this.responsable_del_ingreso = responsable_del_ingreso;
    }

    @Override
    public String toString() {
        return "Datos de artículo ingresado{" + "codigo=" + codigo + ", articulo=" + articulo + ", cantidad=" + cantidad + ", preciounitario=" + preciounitario + ", dinero_invertido=" + dinero_invertido + ", fecha_de_ingreso=" + fecha_de_ingreso + ", responsable_del_ingreso=" + responsable_del_ingreso + '}';
    }

}
