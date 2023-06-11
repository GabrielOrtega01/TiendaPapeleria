package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminArticuloDB extends Conexion implements CRUD {
    
    public AdminArticuloDB(){ 
    }
    
    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Articulo objArticulo = (Articulo) obj;
        try {
            String sql = "INSERT INTO articulo(codigo, nombreart, preciounitario) VALUES(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objArticulo.getCodigo());
            preparedStatement.setString(2, objArticulo.getNombreart());
            preparedStatement.setInt(3, objArticulo.getPreciounitario());            
            
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objArticulo.setIdarticulo(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del articulo fue exitoso. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar el articulo: " + e.getMessage());
        }
        cerrarConexion();
        return objArticulo;

    }

    @Override
    public boolean actualizar(Object obj) {
        Articulo objArticulo = (Articulo) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE articulo SET codigo=?,nombreart=?,preciounitario=? WHERE idarticulo=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objArticulo.getCodigo());
            preparedStatement.setString(2, objArticulo.getNombreart());
            preparedStatement.setInt(3, objArticulo.getPreciounitario());
            preparedStatement.setInt(4, objArticulo.getIdarticulo());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el articulo: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Articulo objArticulo = (Articulo) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM articulo WHERE idarticulo=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objArticulo.getIdarticulo());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar al articulo: "+e.getMessage());
            System.out.println("Error al eliminar el articulo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
        
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Articulo objArticulo;
        try {
            String sql = "SELECT * FROM articulo ORDER BY idarticulo ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objArticulo = new Articulo();
                objArticulo.setIdarticulo(resultSet.getInt("idarticulo"));
                objArticulo.setCodigo(resultSet.getString("codigo"));
                objArticulo.setNombreart(resultSet.getString("nombreart"));
                objArticulo.setPreciounitario(resultSet.getInt("preciounitario"));
                
                rowsQuery.add(objArticulo);
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
        Articulo objArticulo = (Articulo) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM articulo WHERE Idarticulo = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objArticulo.getIdarticulo());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objArticulo.setIdarticulo(resultSet.getInt("idarticulo"));
                objArticulo.setCodigo(resultSet.getString("codigo"));
                objArticulo.setNombreart(resultSet.getString("nombreart"));
                objArticulo.setPreciounitario(resultSet.getInt("preciounitario"));
                flag = true;
            }
            if (!flag ){
                objArticulo.setIdarticulo(0);
            }   
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el articulo: " + e.getMessage());
        }
        cerrarConexion();
        return objArticulo;
    }
}


