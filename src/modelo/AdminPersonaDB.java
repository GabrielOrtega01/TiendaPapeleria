package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminPersonaDB extends Conexion implements CRUD {

    public AdminPersonaDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Persona objPersona = (Persona) obj;
        try {
            String sql = "INSERT INTO persona(identificacion,nombre,apellido,clave,rol_idrol) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objPersona.getIdentificacion());
            preparedStatement.setString(2, objPersona.getNombre());
            preparedStatement.setString(3, objPersona.getApellido());
            preparedStatement.setString(4, objPersona.getClave());
            preparedStatement.setInt(5, objPersona.getRol_idrol());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objPersona.setIdpersona(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del persona fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la persona: " + e.getMessage());
        }
        cerrarConexion();
        return objPersona;

    }

    @Override
    public boolean actualizar(Object obj) {
        Persona objPersona = (Persona) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE persona SET identificacion=?,nombre=?,apellido=?,clave=?,rol_idrol=? WHERE idpersona=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objPersona.getIdentificacion());
            preparedStatement.setString(2, objPersona.getNombre());
            preparedStatement.setString(3, objPersona.getApellido());
            preparedStatement.setString(4, objPersona.getClave());
            preparedStatement.setInt(5, objPersona.getRol_idrol());
            preparedStatement.setInt(6, objPersona.getIdpersona());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la Persona: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Persona objPersona = (Persona) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Persona WHERE idpersona=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getIdpersona());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar a la persona: "+e.getMessage());
            System.out.println("Error al eliminar el persona: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Persona objPersona;
        try {
            String sql = "SELECT * FROM persona ORDER BY idpersona ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona = new Persona();
                objPersona.setIdpersona(resultSet.getInt("idpersona"));
                objPersona.setIdentificacion(resultSet.getString("identificacion"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setApellido(resultSet.getString("apellido"));
                objPersona.setClave(resultSet.getString("clave"));
                objPersona.setRol_idrol(resultSet.getInt("Rol_idrol"));

                rowsQuery.add(objPersona);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Persona objPersona = (Persona) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM persona WHERE idpersona = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getIdpersona());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona.setIdpersona(resultSet.getInt("idpersona"));
                objPersona.setIdentificacion(resultSet.getString("identificacion"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setApellido(resultSet.getString("apellido"));
                objPersona.setClave(resultSet.getString("clave"));
                objPersona.setRol_idrol(resultSet.getInt("rol_idrol"));
                flag = true;
            }
            if (!flag) {
                objPersona.setIdpersona(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la Persona: " + e.getMessage());
        }
        cerrarConexion();
        return objPersona;
    }

    public boolean puedeAccederAlsistema(String identificacion, String clave) {
        Connection conex = abrirConexion();
        boolean flag = false;
        int total = 0;
        
        try {
            String sql = "SELECT count(*) total FROM persona WHERE identificacion=? AND clave=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, identificacion);
            preparedStatement.setString(2, clave);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                total = resultSet.getInt("total"); 
            }
            
            if(total > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error al validar el acceso al sistema: " + ex.getMessage());
        }

        cerrarConexion();
        return flag;
    }
    
    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        PersonaVista objPersonaVista;
        try {
            String sql = "SELECT * FROM persona p inner join rol r where r.idrol=p.rol_idrol ORDER BY idpersona ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersonaVista = new PersonaVista();
                objPersonaVista.setIdpersona(resultSet.getInt("idpersona"));
                objPersonaVista.setIdentificacion(resultSet.getString("identificacion"));
                objPersonaVista.setNombre(resultSet.getString("nombre"));
                objPersonaVista.setApellido(resultSet.getString("apellido"));
                objPersonaVista.setClave(resultSet.getString("clave"));
                objPersonaVista.setRol(resultSet.getString("rol"));

                rowsQuery.add(objPersonaVista);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
