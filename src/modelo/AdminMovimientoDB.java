package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMovimientoDB extends Conexion implements CRUD {

    public AdminMovimientoDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Movimiento objMovimiento = (Movimiento) obj;
        try {
            String sql = "INSERT INTO movimiento(fecha, cantidad, persona_idpersona, articulo_idarticulo, operacion_idoperacion) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, java.sql.Date.valueOf(objMovimiento.getFecha()));
            preparedStatement.setInt(2, objMovimiento.getCantidad());
            preparedStatement.setInt(3, objMovimiento.getPersona_idpersona());
            preparedStatement.setInt(4, objMovimiento.getArticulo_idarticulo());
            preparedStatement.setInt(5, objMovimiento.getOperacion_idoperacion());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objMovimiento.setIdmovimiento(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del movimiento fue exitoso. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar el movimiento: " + e.getMessage());
        }
        cerrarConexion();
        return objMovimiento;

    }

    @Override
    public boolean actualizar(Object obj) {
        Movimiento objMovimiento = (Movimiento) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE movimiento SET fecha=?,cantidad=?,persona_idpersona=?,articulo_idarticulo=?,operacion_idoperacion=? WHERE idmovimiento=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(objMovimiento.getFecha()));
            preparedStatement.setInt(2, objMovimiento.getCantidad());
            preparedStatement.setInt(3, objMovimiento.getPersona_idpersona());
            preparedStatement.setInt(4, objMovimiento.getArticulo_idarticulo());
            preparedStatement.setInt(5, objMovimiento.getOperacion_idoperacion());
            preparedStatement.setInt(6, objMovimiento.getIdmovimiento());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el movimiento: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Movimiento objMovimiento = (Movimiento) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM movimiento WHERE idmovimiento=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMovimiento.getIdmovimiento());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar el movimiento: "+e.getMessage());
            System.out.println("Error al eliminar el movimiento: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Movimiento objMovimiento;
        try {
            String sql = "SELECT * FROM movimiento ORDER BY idmovimiento ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMovimiento = new Movimiento();
                objMovimiento.setIdmovimiento(resultSet.getInt("idmovimiento"));
                objMovimiento.setFecha(resultSet.getDate("fecha").toLocalDate());
                objMovimiento.setCantidad(resultSet.getInt("cantidad"));
                objMovimiento.setPersona_idpersona(resultSet.getInt("persona_idpersona"));
                objMovimiento.setArticulo_idarticulo(resultSet.getInt("articulo_idarticulo"));
                objMovimiento.setOperacion_idoperacion(resultSet.getInt("operacion_idoperacion"));

                rowsQuery.add(objMovimiento);
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
        Movimiento objMovimiento = (Movimiento) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM movimiento WHERE Idmovimiento = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMovimiento.getIdmovimiento());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMovimiento.setIdmovimiento(resultSet.getInt("idmovimiento"));
                objMovimiento.setFecha(resultSet.getDate("fecha").toLocalDate());
                objMovimiento.setCantidad(resultSet.getInt("cantidad"));
                objMovimiento.setPersona_idpersona(resultSet.getInt("persona_idpersona"));
                objMovimiento.setArticulo_idarticulo(resultSet.getInt("articulo_idarticulo"));
                objMovimiento.setOperacion_idoperacion(resultSet.getInt("operacion_idoperacion"));
                flag = true;
            }
            if (!flag) {
                objMovimiento.setIdmovimiento(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el movimiento: " + e.getMessage());
        }
        cerrarConexion();
        return objMovimiento;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        MovimientoVista objMovimientoVista;
        try {
            String sql = "Select idmovimiento, nombreart, nombreopr, cantidad, fecha,\n"
                        + "concat(nombre,\" \",apellido) as nombreApellido FROM \n"
                        + "(select *from operacion as o inner join\n"
                        + "(Select * from articulo as a inner join\n"
                        + "(Select * from movimiento as m inner join persona as p\n"
                        + "on m.persona_idpersona=p.idpersona) as tabla1\n"
                        + "on a.idarticulo = tabla1.articulo_idarticulo) as tabla2\n"
                        + "on o.idoperacion = tabla2.operacion_idoperacion) as tabla3\n"
                        + "ORDER BY idmovimiento ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMovimientoVista = new MovimientoVista();
                objMovimientoVista.setIdmovimiento(resultSet.getInt("idmovimiento"));
                objMovimientoVista.setFecha(resultSet.getDate("fecha").toLocalDate());
                objMovimientoVista.setCantidad(resultSet.getInt("cantidad"));
                objMovimientoVista.setNombreApellido(resultSet.getString("nombreApellido"));
                objMovimientoVista.setNombreart(resultSet.getString("nombreart"));
                objMovimientoVista.setNombreopr(resultSet.getString("nombreopr"));

                rowsQuery.add(objMovimientoVista);
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
