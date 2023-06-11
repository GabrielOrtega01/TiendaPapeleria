package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InventarioArticulo {

    private String codigo;
    private String articulo;
    private int preciounitario;
    private int cantidad_actual;
    private BigDecimal valor_total;

    public InventarioArticulo() {
        this.codigo = "";
        this.articulo = "";
        this.preciounitario = 0;
        this.cantidad_actual = 0;
        this.valor_total = BigDecimal.ZERO;

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

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public String toString() {
        return "InventarioArticulo{" + "codigo=" + codigo + ", articulo=" + articulo + ", preciounitario=" + preciounitario + ", cantidad_actual=" + cantidad_actual + ", valor_total=" + valor_total + '}';
    }

}
