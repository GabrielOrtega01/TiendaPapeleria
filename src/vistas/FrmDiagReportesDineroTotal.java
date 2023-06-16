package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.BalanceTotalizado;

public class FrmDiagReportesDineroTotal extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB3 = new RelacionesDB();

    public FrmDiagReportesDineroTotal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Cantidad total", "Dinero total invertido", "Unidades descontadas", "Dinero total recolectado", "Cantidad actual", "Dinero en inventario"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblReporteDineroTotal.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {

        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[6];

        for (Object obj : objRelDB3.consultarDatos3()) {
            BalanceTotalizado objBalanceTotalizado = (BalanceTotalizado) obj;
            filaDeTabla[0] = objBalanceTotalizado.getCantidad_total().toString();
            filaDeTabla[1] = objBalanceTotalizado.getDinero_total_invertido().toString();
            filaDeTabla[2] = objBalanceTotalizado.getUnidades_descontadas().toString();
            filaDeTabla[3] = objBalanceTotalizado.getDinero_total_recolectado().toString();
            filaDeTabla[4] = objBalanceTotalizado.getCantidad_actual().toString();
            filaDeTabla[5] = objBalanceTotalizado.getDinero_en_inventario().toString();

            this.modeloTabla.addRow(filaDeTabla);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteDineroTotal = new javax.swing.JTable();
        btnConsultarDineroTotal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Reporte: dinero total invertido en el inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 11, -1, -1));

        tblReporteDineroTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad total", "Dinero total invertido", "Unidades descontadas", "Dinero total recolectado", "Cantidad actual", "Dinero en inventario"
            }
        ));
        jScrollPane1.setViewportView(tblReporteDineroTotal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 825, 95));

        btnConsultarDineroTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarDineroTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/buscar.png"))); // NOI18N
        btnConsultarDineroTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDineroTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarDineroTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 171, 40, 40));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 171, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarDineroTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDineroTotalActionPerformed
        this.refrescarTabla();
    }//GEN-LAST:event_btnConsultarDineroTotalActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarDineroTotal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReporteDineroTotal;
    // End of variables declaration//GEN-END:variables
}
