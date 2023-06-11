package vistas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.BalanceGeneral;

public class FrmDiagReportesBalanceGeneral extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB = new RelacionesDB();

    public FrmDiagReportesBalanceGeneral(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Código", "Artículo", "Precio unitario", "Fecha de ingreso", "Cantidad total", "Unidades descontadas", "Cantidad actual", "Dinero en inventario"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera);
        this.tblReporteBalanceGeneral.setModel(this.modeloTabla);
    }

    private void refrescarTabla(LocalDate fechaInicio2, LocalDate fechaFin2) {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[8];
        int BalanceGeneral = 0;

        for (Object obj : objRelDB.consultarDatos2(fechaInicio2, fechaFin2)) {
            BalanceGeneral objBalanceGeneral = (BalanceGeneral) obj;
            filaDeTabla[0] = objBalanceGeneral.getCodigo();
            filaDeTabla[1] = objBalanceGeneral.getArticulo();
            filaDeTabla[2] = Integer.toString(objBalanceGeneral.getPreciounitario());
            filaDeTabla[3] = objBalanceGeneral.getFecha_de_ingreso().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[4] = Integer.toString(objBalanceGeneral.getCantidad_total());
            filaDeTabla[5] = Integer.toString(objBalanceGeneral.getUnidades_descontadas());
            filaDeTabla[6] = Integer.toString(objBalanceGeneral.getCantidad_actual());
            filaDeTabla[7] = Integer.toString(objBalanceGeneral.getDinero_en_inventario());

            this.modeloTabla.addRow(filaDeTabla);
            
            BalanceGeneral += objBalanceGeneral.getDinero_en_inventario();
        }

        // Formatear el total invertido con separadores de miles
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String totalInvertidoFormateado = decimalFormat.format(BalanceGeneral);
        this.labTotalInventario.setText(totalInvertidoFormateado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteBalanceGeneral = new javax.swing.JTable();
        btnConsultarDineroNuevosArticulos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labTotalInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 342));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Balance General");

        tblReporteBalanceGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Artículo", "Precio unitario", "Fecha de ingreso", "Cantidad total", "Unidades descontadas", "Cantidad actual", "Dinero en inventario"
            }
        ));
        jScrollPane1.setViewportView(tblReporteBalanceGeneral);

        btnConsultarDineroNuevosArticulos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarDineroNuevosArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/buscar.png"))); // NOI18N
        btnConsultarDineroNuevosArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDineroNuevosArticulosActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Dinero total en inventarito:");

        labTotalInventario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTotalInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTotalInventario.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(483, 483, 483)
                .addComponent(jLabel1)
                .addContainerGap(484, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(btnConsultarDineroNuevosArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(labTotalInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(labTotalInventario))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarDineroNuevosArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarDineroNuevosArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDineroNuevosArticulosActionPerformed

        LocalDate fechaInicio2 = this.jDateFechaInicio.getDate() != null ? this.jDateFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate fechaFin2 = this.jDateFechaFin.getDate() != null ? this.jDateFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        if (fechaInicio2 == null && fechaFin2 == null) {
            JOptionPane.showMessageDialog(this, "¡Los campos no pueden estar vacíos!");
        } else if (fechaInicio2 == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha inicial no debe estar vacía!");
        } else if (fechaFin2 == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha final no debe estar vacía!");
        } else if (fechaInicio2.isBefore(fechaFin2) || fechaInicio2.equals(fechaFin2)) {
            this.refrescarTabla(fechaInicio2, fechaFin2);
        } else {
            JOptionPane.showMessageDialog(this, "¡¡¡ Rango de fechas incorrecto !!!");
        }
    }//GEN-LAST:event_btnConsultarDineroNuevosArticulosActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarDineroNuevosArticulos;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labTotalInventario;
    private javax.swing.JTable tblReporteBalanceGeneral;
    // End of variables declaration//GEN-END:variables
}
