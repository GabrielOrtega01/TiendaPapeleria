package modelo;

import java.time.LocalDate;

public class ArticuloOrdenadoFecha {

    private String codigo;
    private String articulo;
    private int cantidad;
    private int preciounitario;
    private LocalDate fecha_de_ingreso;
    private String responsable_del_ingreso;

    public ArticuloOrdenadoFecha() {
        this.codigo = "";
        this.articulo = "";
        this.cantidad = 0;
        this.preciounitario = 0;
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
        return "ArticuloOrdenadoFecha{" + "codigo=" + codigo + ", articulo=" + articulo + ", cantidad=" + cantidad + ", preciounitario=" + preciounitario + ", fecha_de_ingreso=" + fecha_de_ingreso + ", responsable_del_ingreso=" + responsable_del_ingreso + '}';
    }

}
