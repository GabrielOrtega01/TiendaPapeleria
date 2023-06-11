package modelo;

public class ItemCmbArticulo {

    private int idarticulo;
    private String codigo;
    private String nombreart;
    private int preciounitario;

    public ItemCmbArticulo() {
    }

    public ItemCmbArticulo(int idarticulo, String codigo, String nombreart, int preciounitario) {
        this.idarticulo = idarticulo;
        this.codigo = codigo;
        this.nombreart = nombreart;
        this.preciounitario = preciounitario;
    }

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreart() {
        return nombreart;
    }

    public void setNombreart(String nombreart) {
        this.nombreart = nombreart;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    @Override
    public String toString() {
        return nombreart;
    }

}
