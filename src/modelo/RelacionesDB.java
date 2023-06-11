package modelo;

import dao.Conexion;
import static dao.Conexion.abrirConexion;
import static dao.Conexion.cerrarConexion;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelacionesDB extends Conexion {

    public RelacionesDB() {
    }

    public List<ListaArticulo> consultarDatos(LocalDate fechaInicio, LocalDate fechaFin) {
        List<ListaArticulo> rowsQuery = new ArrayList<ListaArticulo>();
        Connection conex = abrirConexion();
        ListaArticulo objListaAticulo;
        try {
            String sql = "Select codigo, nombreart as articulo, cantidad, preciounitario, preciounitario*cantidad AS dinero_invertido,\n"
                        + "fecha as fecha_de_ingreso, concat(nombre,\" \",apellido) as responsable_del_ingreso from\n"
                        + "   (Select * from operacion as o inner join\n"
                        + "  (Select * from articulo as a inner join\n"
                        + " (Select * from movimiento as m inner join persona as p\n"
                        + "  on m.persona_idpersona=p.idpersona) as tabla1\n"
                        + "   on a.idarticulo = tabla1.articulo_idarticulo) as tabla2\n"
                        + "	 on o.idoperacion = tabla2.operacion_idoperacion) as tabla3\n"
                        + "     where nombreopr = 'Ingreso' AND fecha BETWEEN ? AND ?\n"
                        + "     ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objListaAticulo = new ListaArticulo();

                objListaAticulo.setCodigo(resultSet.getString("codigo"));
                objListaAticulo.setArticulo(resultSet.getString("articulo"));
                objListaAticulo.setCantidad(resultSet.getInt("cantidad"));
                objListaAticulo.setPreciounitario(resultSet.getInt("preciounitario"));
                objListaAticulo.setDinero_invertido(resultSet.getBigDecimal("Dinero_invertido").setScale(0, RoundingMode.HALF_UP));
                objListaAticulo.setFecha_de_ingreso(resultSet.getDate("fecha_de_ingreso").toLocalDate());
                objListaAticulo.setResponsable_del_ingreso(resultSet.getString("responsable_del_ingreso"));

                rowsQuery.add(objListaAticulo);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<BalanceGeneral> consultarDatos2(LocalDate fechaInicio2, LocalDate fechaFin2) {
        List<BalanceGeneral> rowsQuery = new ArrayList<BalanceGeneral>();
        Connection conex = abrirConexion();
        BalanceGeneral objBalanceGeneral;
        try {
            String sql = "SELECT a.codigo, a.nombreart as articulo, a.preciounitario, m.fecha as fecha_de_ingreso,\n"
                        + "tabla2.unidades_descontadas+tabla1.cantidad as cantidad_total,\n"
                        + "tabla2.unidades_descontadas, tabla1.cantidad as cantidad_actual,  \n"
                        + "(a.preciounitario * tabla1.cantidad) as dinero_en_inventario\n"
                        + "FROM articulo a\n"
                        + "INNER JOIN (\n"
                        + "   SELECT m.articulo_idarticulo, SUM(CASE WHEN m.operacion_idoperacion = 1 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 2 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 3 THEN -m.cantidad END) AS cantidad\n"
                        + "   FROM movimiento m\n"
                        + "   GROUP BY m.articulo_idarticulo\n"
                        + ") as tabla1 ON a.idarticulo = tabla1.articulo_idarticulo\n"
                        + "INNER JOIN (\n"
                        + "   SELECT articulo_idarticulo, SUM(CASE WHEN operacion_idoperacion = 3 THEN cantidad ELSE 0 END) AS unidades_descontadas\n"
                        + "   FROM movimiento\n"
                        + "   GROUP BY articulo_idarticulo\n"
                        + ") as tabla2 ON a.idarticulo = tabla2.articulo_idarticulo\n"
                        + "INNER JOIN movimiento m ON m.articulo_idarticulo = a.idarticulo AND m.operacion_idoperacion = 1\n"
                        + "INNER JOIN persona p ON p.idpersona = m.persona_idpersona\n"
                        + "WHERE fecha BETWEEN ? AND ?\n"
                        + "ORDER BY fecha_de_ingreso ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio2));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin2));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objBalanceGeneral = new BalanceGeneral();

                objBalanceGeneral.setCodigo(resultSet.getString("codigo"));
                objBalanceGeneral.setArticulo(resultSet.getString("articulo"));
                objBalanceGeneral.setPreciounitario(resultSet.getInt("preciounitario"));
                objBalanceGeneral.setFecha_de_ingreso(resultSet.getDate("fecha_de_ingreso").toLocalDate());
                objBalanceGeneral.setCantidad_total(resultSet.getInt("cantidad_total"));
                objBalanceGeneral.setUnidades_descontadas(resultSet.getInt("unidades_descontadas"));
                objBalanceGeneral.setCantidad_actual(resultSet.getInt("cantidad_actual"));
                objBalanceGeneral.setDinero_en_inventario(resultSet.getInt("dinero_en_inventario"));

                rowsQuery.add(objBalanceGeneral);
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<BalanceTotalizado> consultarDatos3() {
        List<BalanceTotalizado> rowsQuery = new ArrayList<BalanceTotalizado>();
        Connection conex = abrirConexion();
        BalanceTotalizado objBalanceTotalizado;
        try {
            String sql = "select SUM(CASE WHEN operacion_idoperacion = 1 THEN cantidad\n"
                        + "                                 WHEN operacion_idoperacion = 2 THEN cantidad END) AS cantidad_total,\n"
                        + "SUM(CASE WHEN operacion_idoperacion = 1 THEN cantidad*preciounitario\n"
                        + "                                 WHEN operacion_idoperacion = 2 THEN cantidad*preciounitario END) AS dinero_total_invertido,                                 \n"
                        + "SUM(CASE WHEN operacion_idoperacion = 3 THEN cantidad ELSE 0 END) AS unidades_descontadas, \n"
                        + "SUM(CASE WHEN operacion_idoperacion = 3 THEN cantidad*preciounitario END) AS dinero_total_recolectado,\n"
                        + "SUM(CASE WHEN operacion_idoperacion = 1 THEN cantidad\n"
                        + "                                 WHEN operacion_idoperacion = 2 THEN cantidad\n"
                        + "                                 WHEN operacion_idoperacion = 3 THEN -cantidad END) AS cantidad_actual,                                 \n"
                        + "SUM(CASE WHEN operacion_idoperacion = 1 THEN cantidad*preciounitario\n"
                        + "                                 WHEN operacion_idoperacion = 2 THEN cantidad*preciounitario\n"
                        + "                                 WHEN operacion_idoperacion = 3 THEN -cantidad*preciounitario END) AS dinero_en_inventario from                        \n"
                        + "(Select * from operacion as o inner join\n"
                        + "(Select * from articulo as a inner join movimiento as m\n"
                        + "  on m.articulo_idarticulo = a.idarticulo ) as tabla1\n"
                        + "	 on o.idoperacion = tabla1.operacion_idoperacion) as tabla2";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                objBalanceTotalizado = new BalanceTotalizado();

                objBalanceTotalizado.setCantidad_total(resultSet.getBigDecimal("cantidad_total").setScale(0, RoundingMode.HALF_UP));
                objBalanceTotalizado.setDinero_total_invertido(resultSet.getBigDecimal("dinero_total_invertido").setScale(0, RoundingMode.HALF_UP));
                objBalanceTotalizado.setUnidades_descontadas(resultSet.getBigDecimal("unidades_descontadas").setScale(0, RoundingMode.HALF_UP));
                objBalanceTotalizado.setDinero_total_recolectado(resultSet.getBigDecimal("dinero_total_recolectado").setScale(0, RoundingMode.HALF_UP));
                objBalanceTotalizado.setCantidad_actual(resultSet.getBigDecimal("cantidad_actual").setScale(0, RoundingMode.HALF_UP));
                objBalanceTotalizado.setDinero_en_inventario(resultSet.getBigDecimal("dinero_en_inventario").setScale(0, RoundingMode.HALF_UP));

                rowsQuery.add(objBalanceTotalizado);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<InventarioArticulo> consultarDatos4(LocalDate fechaInicio4, LocalDate fechaFin4) {
        List<InventarioArticulo> rowsQuery = new ArrayList<InventarioArticulo>();
        Connection conex = abrirConexion();
        InventarioArticulo objInventarioArticulo;
        try {
            String sql = "SELECT a.codigo, a.nombreart as articulo, a.preciounitario, tabla1.cantidad_actual, a.preciounitario * tabla1.cantidad_actual AS valor_total\n"
                        + "FROM articulo a\n"
                        + "INNER JOIN (\n"
                        + "   SELECT m.articulo_idarticulo, SUM(CASE WHEN m.operacion_idoperacion = 1 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 2 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 3 THEN -m.cantidad END) AS cantidad_actual\n"
                        + "   FROM movimiento m\n"
                        + "   WHERE m.fecha BETWEEN ? AND ?\n"
                        + "   GROUP BY m.articulo_idarticulo\n"
                        + ") tabla1 ON a.idarticulo = tabla1.articulo_idarticulo\n"
                        + "ORDER BY a.nombreart";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio4));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin4));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objInventarioArticulo = new InventarioArticulo();

                objInventarioArticulo.setCodigo(resultSet.getString("codigo"));
                objInventarioArticulo.setArticulo(resultSet.getString("articulo"));
                objInventarioArticulo.setPreciounitario(resultSet.getInt("preciounitario"));
                objInventarioArticulo.setCantidad_actual(resultSet.getInt("cantidad_actual"));
                objInventarioArticulo.setValor_total(resultSet.getBigDecimal("valor_total").setScale(0, RoundingMode.HALF_UP));

                rowsQuery.add(objInventarioArticulo);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<AdministrarInventarioArticulo> consultarDatos5(LocalDate fechaInicio5, LocalDate fechaFin5, String nombreArt) {
        List<AdministrarInventarioArticulo> rowsQuery = new ArrayList<AdministrarInventarioArticulo>();
        Connection conex = abrirConexion();
        AdministrarInventarioArticulo objAdministrarInventarioArticulo;
        try {
            String sql = "Select nombreopr as operacion, cantidad, fecha as fecha_de_operacion, \n"
                        + "concat(nombre,\" \",apellido) as responsable_de_la_operacion from\n"
                        + "   (Select * from operacion as o inner join\n"
                        + "  (Select * from articulo as a inner join\n"
                        + " (Select * from movimiento as m inner join persona as p\n"
                        + "  on m.persona_idpersona=p.idpersona) as tabla1\n"
                        + "   on a.idarticulo = tabla1.articulo_idarticulo) as tabla2\n"
                        + "    on o.idoperacion = tabla2.operacion_idoperacion) as tabla3\n"
                        + "where nombreopr != 'Ingreso' AND fecha BETWEEN ? AND ? AND nombreart=?\n"
                        + "ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio5));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin5));
            preparedStatement.setString(3, nombreArt);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objAdministrarInventarioArticulo = new AdministrarInventarioArticulo();

                objAdministrarInventarioArticulo.setOperacion(resultSet.getString("operacion"));
                objAdministrarInventarioArticulo.setCantidad(resultSet.getInt("cantidad"));
                objAdministrarInventarioArticulo.setFecha_de_operacion(resultSet.getDate("fecha_de_operacion").toLocalDate());
                objAdministrarInventarioArticulo.setResponsable_de_la_operacion(resultSet.getString("responsable_de_la_operacion"));

                rowsQuery.add(objAdministrarInventarioArticulo);
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<ListaArticulo> consultarDatos6(LocalDate fechaInicio6, LocalDate fechaFin6) {
        List<ListaArticulo> rowsQuery = new ArrayList<ListaArticulo>();
        Connection conex = abrirConexion();
        ListaArticulo objListaAticulo;
        try {
            String sql = "SELECT a.codigo, a.nombreart as articulo, tabla1.cantidad, a.preciounitario, \n"
                        + "a.preciounitario*tabla1.cantidad AS dinero_invertido,\n"
                        + " m.fecha as fecha_de_ingreso, concat(p.nombre,\" \",p.apellido) as responsable_del_ingreso\n"
                        + "FROM articulo a\n"
                        + "INNER JOIN (\n"
                        + "   SELECT m.articulo_idarticulo, SUM(CASE WHEN m.operacion_idoperacion = 1 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 2 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 3 THEN -m.cantidad END) AS cantidad\n"
                        + "   FROM movimiento m\n"
                        + "   GROUP BY m.articulo_idarticulo\n"
                        + ") as tabla1 ON a.idarticulo = tabla1.articulo_idarticulo\n"
                        + "INNER JOIN movimiento m ON m.articulo_idarticulo = a.idarticulo AND m.operacion_idoperacion = 1\n"
                        + "INNER JOIN persona p ON p.idpersona = m.persona_idpersona\n"
                        + "WHERE fecha BETWEEN ? AND ?\n"
                        + "ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio6));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin6));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objListaAticulo = new ListaArticulo();

                objListaAticulo.setCodigo(resultSet.getString("codigo"));
                objListaAticulo.setArticulo(resultSet.getString("articulo"));
                objListaAticulo.setCantidad(resultSet.getInt("cantidad"));
                objListaAticulo.setPreciounitario(resultSet.getInt("preciounitario"));
                objListaAticulo.setDinero_invertido(resultSet.getBigDecimal("Dinero_invertido").setScale(0, RoundingMode.HALF_UP));
                objListaAticulo.setFecha_de_ingreso(resultSet.getDate("fecha_de_ingreso").toLocalDate());
                objListaAticulo.setResponsable_del_ingreso(resultSet.getString("responsable_del_ingreso"));

                rowsQuery.add(objListaAticulo);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<ArticuloOrdenadoFecha> consultarDatos7(String nombreOperacion, String nombrePersona,
                String apellidoPersona, LocalDate fechaInicio7, LocalDate fechaFin7) {
        List<ArticuloOrdenadoFecha> rowsQuery = new ArrayList<ArticuloOrdenadoFecha>();
        Connection conex = abrirConexion();
        ArticuloOrdenadoFecha objArticuloOrdenadoFecha;
        try {
            String sql = "Select codigo, nombreart as articulo, cantidad, preciounitario,\n"
                        + "fecha as fecha_de_ingreso, concat(nombre,\" \",apellido) as responsable_del_ingreso from\n"
                        + "   (Select * from operacion as o inner join\n"
                        + "  (Select * from articulo as a inner join\n"
                        + " (Select * from movimiento as m inner join persona as p\n"
                        + "  on m.persona_idpersona=p.idpersona) as tabla1\n"
                        + "   on a.idarticulo = tabla1.articulo_idarticulo) as tabla2\n"
                        + "	 on o.idoperacion = tabla2.operacion_idoperacion) as tabla3\n"
                        + "where nombreopr = ? and nombre = ? and apellido = ? and \n"
                        + "fecha BETWEEN ? AND ?\n"
                        + "ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, nombreOperacion);
            preparedStatement.setString(2, nombrePersona);
            preparedStatement.setString(3, apellidoPersona);
            preparedStatement.setDate(4, java.sql.Date.valueOf(fechaInicio7));
            preparedStatement.setDate(5, java.sql.Date.valueOf(fechaFin7));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objArticuloOrdenadoFecha = new ArticuloOrdenadoFecha();

                objArticuloOrdenadoFecha.setCodigo(resultSet.getString("codigo"));
                objArticuloOrdenadoFecha.setArticulo(resultSet.getString("articulo"));
                objArticuloOrdenadoFecha.setCantidad(resultSet.getInt("cantidad"));
                objArticuloOrdenadoFecha.setPreciounitario(resultSet.getInt("preciounitario"));
                objArticuloOrdenadoFecha.setFecha_de_ingreso(resultSet.getDate("fecha_de_ingreso").toLocalDate());
                objArticuloOrdenadoFecha.setResponsable_del_ingreso(resultSet.getString("responsable_del_ingreso"));

                rowsQuery.add(objArticuloOrdenadoFecha);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<OperacionArticulo> consultarDatos8(String codigoArticulo) {
        List<OperacionArticulo> rowsQuery = new ArrayList<OperacionArticulo>();
        Connection conex = abrirConexion();
        OperacionArticulo objOperacionArticulo;
        try {
            String sql = "Select nombreart as nombre_articulo, nombreopr as operacion, cantidad,"
                        + " fecha as fecha_de_operacion, \n"
                        + "concat(nombre,\" \",apellido) as responsable_de_la_operacion from\n"
                        + "    (Select * from operacion as o inner join\n"
                        + "  (Select * from articulo as a inner join\n"
                        + " (Select * from movimiento as m inner join persona as p\n"
                        + "  on m.persona_idpersona=p.idpersona) as tabla1\n"
                        + "   on a.idarticulo = tabla1.articulo_idarticulo) as tabla2\n"
                        + "	 on o.idoperacion = tabla2.operacion_idoperacion) as tabla3\n"
                        + "where nombreopr != 'Ingreso' and codigo =?\n"
                        + "ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, codigoArticulo);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objOperacionArticulo = new OperacionArticulo();

                objOperacionArticulo.setNombre_articulo(resultSet.getString("nombre_articulo"));
                objOperacionArticulo.setOperacion(resultSet.getString("operacion"));
                objOperacionArticulo.setCantidad(resultSet.getInt("cantidad"));
                objOperacionArticulo.setFecha_de_operacion(resultSet.getDate("fecha_de_operacion").toLocalDate());
                objOperacionArticulo.setResponsable_de_la_operacion(resultSet.getString("responsable_de_la_operacion"));

                rowsQuery.add(objOperacionArticulo);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<AdministrarListaInventarioArticulo> consultarDatos9(LocalDate fechaInicio9, LocalDate fechaFin9, String nombreArt) {
        List<AdministrarListaInventarioArticulo> rowsQuery = new ArrayList<AdministrarListaInventarioArticulo>();
        Connection conex = abrirConexion();
        AdministrarListaInventarioArticulo objListaAticulo9;
        try {
            String sql = "SELECT o.nombreopr as operacion, m.cantidad, m.fecha as fecha_de_operacion,\n"
                        + "concat(p.nombre,\" \",p.apellido) as responsable_de_la_operacion, tabla1.cantidad_actual, tabla1.cantidad_inicial\n"
                        + " FROM articulo a\n"
                        + "INNER JOIN (\n"
                        + "   SELECT m.articulo_idarticulo, SUM(CASE WHEN m.operacion_idoperacion = 1 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 2 THEN m.cantidad\n"
                        + "                                 WHEN m.operacion_idoperacion = 3 THEN -m.cantidad END) AS cantidad_actual,\n"
                        + "                                 SUM(CASE WHEN m.operacion_idoperacion = 1 THEN m.cantidad END) AS cantidad_inicial \n"
                        + "   FROM movimiento m\n"
                        + "   GROUP BY m.articulo_idarticulo\n"
                        + ") as tabla1 ON a.idarticulo = tabla1.articulo_idarticulo\n"
                        + "INNER JOIN movimiento m ON m.articulo_idarticulo = a.idarticulo\n"
                        + "INNER JOIN persona p ON p.idpersona = m.persona_idpersona\n"
                        + "INNER JOIN operacion o ON o.idoperacion = m.operacion_idoperacion\n"
                        + "where fecha BETWEEN ? AND ? AND nombreart = ?\n"
                        + "ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio9));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin9));
            preparedStatement.setString(3, nombreArt);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objListaAticulo9 = new AdministrarListaInventarioArticulo();

                objListaAticulo9.setOperacion(resultSet.getString("operacion"));
                objListaAticulo9.setCantidad(resultSet.getInt("cantidad"));
                objListaAticulo9.setFecha_de_operacion(resultSet.getDate("fecha_de_operacion").toLocalDate());
                objListaAticulo9.setResponsable_de_la_operacion(resultSet.getString("responsable_de_la_operacion"));
                objListaAticulo9.setCantidad_actual(resultSet.getInt("cantidad_actual"));
                objListaAticulo9.setCantidad_inicial(resultSet.getInt("cantidad_inicial"));

                rowsQuery.add(objListaAticulo9);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

}
