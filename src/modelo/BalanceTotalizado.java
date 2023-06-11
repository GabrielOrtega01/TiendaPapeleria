package modelo;

import java.math.BigDecimal;

public class BalanceTotalizado {

    private BigDecimal cantidad_total;
    private BigDecimal dinero_total_invertido;
    private BigDecimal unidades_descontadas;
    private BigDecimal dinero_total_recolectado;
    private BigDecimal cantidad_actual;
    private BigDecimal dinero_en_inventario;

    public BalanceTotalizado() {
        this.cantidad_total = BigDecimal.ZERO;
        this.dinero_total_invertido = BigDecimal.ZERO;
        this.unidades_descontadas = BigDecimal.ZERO;
        this.dinero_total_recolectado = BigDecimal.ZERO;
        this.cantidad_actual = BigDecimal.ZERO;
        this.dinero_en_inventario = BigDecimal.ZERO;
    }
    public BigDecimal getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(BigDecimal cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public BigDecimal getDinero_total_invertido() {
        return dinero_total_invertido;
    }

    public void setDinero_total_invertido(BigDecimal dinero_total_invertido) {
        this.dinero_total_invertido = dinero_total_invertido;
    }

    public BigDecimal getUnidades_descontadas() {
        return unidades_descontadas;
    }

    public void setUnidades_descontadas(BigDecimal unidades_descontadas) {
        this.unidades_descontadas = unidades_descontadas;
    }

    public BigDecimal getDinero_total_recolectado() {
        return dinero_total_recolectado;
    }

    public void setDinero_total_recolectado(BigDecimal dinero_total_recolectado) {
        this.dinero_total_recolectado = dinero_total_recolectado;
    }

    public BigDecimal getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(BigDecimal cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public BigDecimal getDinero_en_inventario() {
        return dinero_en_inventario;
    }

    public void setDinero_en_inventario(BigDecimal dinero_en_inventario) {
        this.dinero_en_inventario = dinero_en_inventario;
    }
    @Override
    public String toString() {
        return "BalanceTotalizado{" + "cantidad_total=" + cantidad_total + ", dinero_total_invertido=" + dinero_total_invertido + ", unidades_descontadas=" + unidades_descontadas + ", dinero_total_recolectado=" + dinero_total_recolectado + ", cantidad_actual=" + cantidad_actual + ", dinero_en_inventario=" + dinero_en_inventario + '}';
    }
}
