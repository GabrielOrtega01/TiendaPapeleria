package modelo;

public class ItemCmbPersona {

    private int idpersona;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String clave;
    private int rol_idrol;

    public ItemCmbPersona() {
    }

    public ItemCmbPersona(int idpersona, String identificacion, String nombre, String apellido, String clave, int rol_idrol) {
        this.idpersona = idpersona;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.rol_idrol = rol_idrol;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getRol_idrol() {
        return rol_idrol;
    }

    public void setRol_idrol(int rol_idrol) {
        this.rol_idrol = rol_idrol;
    }

    @Override
    public String toString() {
        return identificacion;
    }

}
