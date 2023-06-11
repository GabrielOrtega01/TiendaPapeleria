package modelo;

import java.time.LocalDate;

public class BalanceGeneral {

    private String codigo;
    private String articulo;
    private int preciounitario;
    private LocalDate fecha_de_ingreso;
    private int cantidad_total;
    private int unidades_descontadas;
    private int cantidad_actual;
    private int dinero_en_inventario;

    public BalanceGeneral() {
        this.codigo = "";
        this.articulo = "";
        this.preciounitario = 0;
        this.fecha_de_ingreso = LocalDate.parse("1900-01-01");
        this.cantidad_total = 0;
        this.unidades_descontadas = 0;
        this.cantidad_actual = 0;
        this.dinero_en_inventario = 0;
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

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public int getUnidades_descontadas() {
        return unidades_descontadas;
    }

    public void setUnidades_descontadas(int unidades_descontadas) {
        this.unidades_descontadas = unidades_descontadas;
    }

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public int getDinero_en_inventario() {
        return dinero_en_inventario;
    }

    public void setDinero_en_inventario(int dinero_en_inventario) {
        this.dinero_en_inventario = dinero_en_inventario;
    }

    @Override
    public String toString() {
        return "BalanceGeneral{" + "codigo=" + codigo + ", articulo=" + articulo + ", preciounitario=" + preciounitario + ", fecha_de_ingreso=" + fecha_de_ingreso + ", cantidad_total=" + cantidad_total + ", unidades_descontadas=" + unidades_descontadas + ", cantidad_actual=" + cantidad_actual + ", dinero_en_inventario=" + dinero_en_inventario + '}';
    }

}
