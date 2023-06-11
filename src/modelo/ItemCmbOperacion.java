package modelo;

public class ItemCmbOperacion {

    private int idoperacion;
    private String nombreopr;

    public ItemCmbOperacion() {
    }

    public ItemCmbOperacion(int idoperacion, String nombreopr) {
        this.idoperacion = idoperacion;
        this.nombreopr = nombreopr;
    }

    public int getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(int idoperacion) {
        this.idoperacion = idoperacion;
    }

    public String getNombreopr() {
        return nombreopr;
    }

    public void setNombreopr(String nombreopr) {
        this.nombreopr = nombreopr;
    }

    @Override
    public String toString() {
        return nombreopr;
    }

}
