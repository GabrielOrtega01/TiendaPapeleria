package modelo;

public class ItemCmbRol {
    private int idrol;
    private String rol;

    public ItemCmbRol() {
    }

    public ItemCmbRol(int idrol, String rol) {
        this.idrol = idrol;
        this.rol = rol;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return rol;
    }
}
