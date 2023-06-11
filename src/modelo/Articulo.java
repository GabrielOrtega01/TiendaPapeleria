package modelo;

public class Articulo {

    private int idarticulo;
    private String codigo;
    private String nombreart;
    private int preciounitario;

    public Articulo() {
        this.idarticulo = 0;
        this.codigo = "";
        this.nombreart = "";
        this.preciounitario = 0;
    }

    public Articulo(int idarticulo, String codigo, String nombreart, int preciounitario) {
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
        return "articulo{" + "idarticulo=" + idarticulo + ", codigo=" + codigo + ", nombreart=" + nombreart + ", preciounitario=" + preciounitario + '}';
    }
    
}
