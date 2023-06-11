package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRolDB extends Conexion implements CRUD {

    public AdminRolDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Rol objRol = (Rol) obj;
        try {
            String sql = "INSERT INTO rol(rol) VALUES(?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objRol.getRol());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objRol.setIdrol(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del rol fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar el rol: " + e.getMessage());
        }
        cerrarConexion();
        return objRol;

    }

    @Override
    public boolean actualizar(Object obj) {
        Rol objRol = (Rol) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE rol SET rol=? WHERE idrol=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objRol.getRol());
            preparedStatement.setInt(2, objRol.getIdrol());

             int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Rol: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Rol objRol = (Rol) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM rol WHERE idrol=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRol.getIdrol());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar el rol: "+e.getMessage());
            System.out.println("Error al eliminar el rol: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override

    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Rol objRol;
        try {
            String sql = "SELECT * FROM rol ORDER BY rol ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol = new Rol();
                objRol.setIdrol(resultSet.getInt("idrol"));
                objRol.setRol(resultSet.getString("rol"));

                rowsQuery.add(objRol);
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
        Rol objRol = (Rol) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM rol WHERE idrol = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRol.getIdrol());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol.setIdrol(resultSet.getInt("idrol"));
                objRol.setRol(resultSet.getString("rol"));
                flag = true;

            }
            if (!flag ){
                objRol.setIdrol(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el rol: " + e.getMessage());
        }
        cerrarConexion();
        return objRol;
    }

}
