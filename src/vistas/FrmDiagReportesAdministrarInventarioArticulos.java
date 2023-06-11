package vistas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.Articulo;
import modelo.AdminArticuloDB;
import modelo.AdministrarListaInventarioArticulo;
import modelo.ItemCmbArticulo;

public class FrmDiagReportesAdministrarInventarioArticulos extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB = new RelacionesDB();

    public FrmDiagReportesAdministrarInventarioArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
        this.cargarAdministrarInventarioArticulos();
    }

    private void cargarAdministrarInventarioArticulos() {
        AdminArticuloDB objAdmArt = new AdminArticuloDB();

        for (Object obj : objAdmArt.listarTodo()) {
            Articulo objArticulo = new Articulo();
            objArticulo = (Articulo) obj;

            ItemCmbArticulo objItem = new ItemCmbArticulo();
            objItem.setIdarticulo(objArticulo.getIdarticulo());
            objItem.setNombreart(objArticulo.getNombreart());

            this.cmbArticulo.addItem(objItem);
        }
    }

    private void configurarTabla() {
        String cabecera[] = {"No", "Operación", "Cantidad", "Fecha de operación", "Responsable de la operación"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera);
        this.tblReporteAdministrarInventarioArticulos.setModel(this.modeloTabla);

    }

    private void refrescarTabla(LocalDate fechaInicio9, LocalDate fechaFin9, String nombreArt) {

        // Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        // Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[5];
        int contador = 1; // Variable autoincrementable
        int Cantidad_inicial = 0;
        int Cantidad_final = 0;

        // Asignar valores a los atributos de objListaAticulo
        for (Object obj : objRelDB.consultarDatos9(fechaInicio9, fechaFin9, nombreArt)) {
            AdministrarListaInventarioArticulo objListaAticulo9 = (AdministrarListaInventarioArticulo) obj;
            filaDeTabla[0] = Integer.toString(contador); // Asignar el valor del contador
            contador++; // Incrementar el contador para el siguiente registro
            filaDeTabla[1] = objListaAticulo9.getOperacion();
            filaDeTabla[2] = Integer.toString(objListaAticulo9.getCantidad());
            filaDeTabla[3] = objListaAticulo9.getFecha_de_operacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[4] = objListaAticulo9.getResponsable_de_la_operacion();
            Cantidad_final = objListaAticulo9.getCantidad_actual();
            Cantidad_inicial = objListaAticulo9.getCantidad_inicial();

            this.modeloTabla.addRow(filaDeTabla);
        }

        this.labCantidadInicial.setText(Integer.toString(Cantidad_inicial));
        this.labCantidadFinal.setText(Integer.toString(Cantidad_final));

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labCantidadInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteAdministrarInventarioArticulos = new javax.swing.JTable();
        btnConsultarNuevosArticulos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbArticulo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labCantidadFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 357));

        labCantidadInicial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCantidadInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCantidadInicial.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar inventario de Artículos");

        tblReporteAdministrarInventarioArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Operación", "Cantidad", "Fecha de operación", "Responsable de la operación"
            }
        ));
        jScrollPane1.setViewportView(tblReporteAdministrarInventarioArticulos);

        btnConsultarNuevosArticulos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarNuevosArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/buscar.png"))); // NOI18N
        btnConsultarNuevosArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNuevosArticulosActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha inicio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fecha fin");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Artículo:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad inicial:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cantidad final:");

        labCantidadFinal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCantidadFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCantidadFinal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultarNuevosArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCantidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labCantidadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(289, 289, 289))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(labCantidadInicial)
                    .addComponent(labCantidadFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultarNuevosArticulos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarNuevosArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNuevosArticulosActionPerformed

        
        ItemCmbArticulo objItem2 = (ItemCmbArticulo) this.cmbArticulo.getSelectedItem();
        String nombreArt = objItem2.getNombreart();

        LocalDate fechaInicio9 = this.jDateFechaInicio.getDate() != null ? this.jDateFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate fechaFin9 = this.jDateFechaFin.getDate() != null ? this.jDateFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        if (fechaInicio9 == null && fechaFin9 == null) {
            JOptionPane.showMessageDialog(this, "¡Los campos no pueden estar vacíos!");
        } else if (fechaInicio9 == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha inicial no debe estar vacía!");
        } else if (fechaFin9 == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha final no debe estar vacía!");
        } else if (fechaInicio9.isBefore(fechaFin9) || fechaInicio9.equals(fechaFin9)) {
            this.refrescarTabla(fechaInicio9, fechaFin9,nombreArt);
        } else {
            JOptionPane.showMessageDialog(this, "¡¡¡ Rango de fechas incorrecto !!!");
        }
    }//GEN-LAST:event_btnConsultarNuevosArticulosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarNuevosArticulos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<ItemCmbArticulo> cmbArticulo;
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCantidadFinal;
    private javax.swing.JLabel labCantidadInicial;
    private javax.swing.JTable tblReporteAdministrarInventarioArticulos;
    // End of variables declaration//GEN-END:variables
}
