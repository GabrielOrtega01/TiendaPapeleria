package modelo;

public class PersonaVista {

    private int idpersona;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String clave;
    private String rol;

    public PersonaVista() {
        this.idpersona = 0;
        this.identificacion = "";
        this.nombre = "";
        this.apellido = "";
        this.clave = "";
        this.rol = "";
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "PersonaVista{" + "idpersona=" + idpersona + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", clave=" + clave + ", rol=" + rol + '}';
    }

}
