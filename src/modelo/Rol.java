package modelo;

public class Rol {

    private int idrol;
    private String rol;

    public Rol() {
        this.idrol = 0;
        this.rol = "";
    }

    public Rol(int idrol, String rol) {
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
        return "rol{" + "idrol=" + idrol + ", rol=" + rol + '}';
    }
}
