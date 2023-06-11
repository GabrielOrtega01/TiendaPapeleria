package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminOperacionDB extends Conexion implements CRUD {

    public AdminOperacionDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Operacion objOperacion = (Operacion) obj;
        try {
            String sql = "INSERT INTO operacion(nombreopr) VALUES(?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objOperacion.getNombreopr());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objOperacion.setIdoperacion(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la operacion fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la operacion: " + e.getMessage());
        }
        cerrarConexion();
        return objOperacion;

    }

    @Override
    public boolean actualizar(Object obj) {
        Operacion objOperacion = (Operacion) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE operacion SET nombreopr=? WHERE idoperacion=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objOperacion.getNombreopr());
            preparedStatement.setInt(2, objOperacion.getIdoperacion());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la operacion: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Operacion objOperacion = (Operacion) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM operacion WHERE idoperacion=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objOperacion.getIdoperacion());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar la operacion: "+e.getMessage());
            System.out.println("Error al eliminar la operacion: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
        
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Operacion objOperacion;
        try {
            String sql = "SELECT * FROM operacion ORDER BY idoperacion ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objOperacion = new Operacion();
                objOperacion.setIdoperacion(resultSet.getInt("idoperacion"));
                objOperacion.setNombreopr(resultSet.getString("nombreopr"));

                rowsQuery.add(objOperacion);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. "+e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Operacion objOperacion = (Operacion) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM operacion WHERE Idoperacion = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objOperacion.getIdoperacion());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objOperacion.setIdoperacion(resultSet.getInt("idoperacion"));
                objOperacion.setNombreopr(resultSet.getString("nombreopr"));
                flag = true;
            }
            if (!flag ){
                objOperacion.setIdoperacion(0);
            }           
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la Operacion: " + e.getMessage());
        }
        cerrarConexion();
        return objOperacion;
    }
}

