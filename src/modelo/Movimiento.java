package modelo;

import java.time.LocalDate;

public class Movimiento {
    private int idmovimiento;
    private LocalDate fecha;
    private int cantidad;
    private int persona_idpersona;
    private int articulo_idarticulo;
    private int operacion_idoperacion;
        
    public Movimiento() {
        this.idmovimiento = 0;
        this.fecha = LocalDate.parse("1900-01-01");
        this.cantidad = 0;
        this.persona_idpersona = 0;
        this.articulo_idarticulo = 0;
        this.operacion_idoperacion = 0;
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

    public int getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(int persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public int getArticulo_idarticulo() {
        return articulo_idarticulo;
    }

    public void setArticulo_idarticulo(int articulo_idarticulo) {
        this.articulo_idarticulo = articulo_idarticulo;
    }

    public int getOperacion_idoperacion() {
        return operacion_idoperacion;
    }

    public void setOperacion_idoperacion(int operacion_idoperacion) {
        this.operacion_idoperacion = operacion_idoperacion;
    }

    @Override
    public String toString() {
        return "movimiento{" + "idmovimiento=" + idmovimiento + ", fecha=" + fecha + ", cantidad=" + cantidad + ", persona_idpersona=" + persona_idpersona + ", articulo_idarticulo=" + articulo_idarticulo + ", operacion_idoperacion=" + operacion_idoperacion + '}';
    }

}
