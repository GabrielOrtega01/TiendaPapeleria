package modelo;

public class Operacion {

    private int idoperacion;
    private String nombreopr;
 
        public Operacion() {
        this.idoperacion = 0;
        this.nombreopr = "";
    }

    public Operacion(int idoperacion, String nombreopr) {
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
        return "operacion{" + "idoperacion=" + idoperacion + ", nombreopr=" + nombreopr + '}';
    }

}