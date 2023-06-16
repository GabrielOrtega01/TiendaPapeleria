package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import modelo.AdminMovimientoDB;
import modelo.AdminOperacionDB;
import modelo.AdminArticuloDB;
import modelo.AdminPersonaDB;
import modelo.Articulo;
import modelo.ItemCmbArticulo;
import modelo.ItemCmbPersona;
import modelo.ItemCmbOperacion;
import modelo.Movimiento;
import modelo.Persona;
import modelo.Operacion;

public class FrmDiagAgregarMovimiento extends javax.swing.JDialog {

    public FrmDiagAgregarMovimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cargarMovimientos();
    }

    private void cargarMovimientos() {
        AdminPersonaDB objAdmPer = new AdminPersonaDB();
        AdminArticuloDB objAdmArt = new AdminArticuloDB();
        AdminOperacionDB objAdmOpr = new AdminOperacionDB();

        for (Object obj : objAdmPer.listarTodo()) {
            Persona objPersona = new Persona();
            objPersona = (Persona) obj;

            ItemCmbPersona objItem = new ItemCmbPersona();
            objItem.setIdpersona(objPersona.getIdpersona());
            objItem.setIdentificacion(objPersona.getIdentificacion());

            this.cmbPersona.addItem(objItem);

        }

        for (Object obj : objAdmArt.listarTodo()) {
            Articulo objArticulo = new Articulo();
            objArticulo = (Articulo) obj;

            ItemCmbArticulo objItem = new ItemCmbArticulo();
            objItem.setIdarticulo(objArticulo.getIdarticulo());
            objItem.setNombreart(objArticulo.getNombreart());

            this.cmbArticulo.addItem(objItem);
        }

        for (Object obj : objAdmOpr.listarTodo()) {
            Operacion objOperacion = new Operacion();
            objOperacion = (Operacion) obj;

            ItemCmbOperacion objItem = new ItemCmbOperacion();
            objItem.setIdoperacion(objOperacion.getIdoperacion());
            objItem.setNombreopr(objOperacion.getNombreopr());

            this.cmbOperacion.addItem(objItem);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbArticulo = new javax.swing.JComboBox<>();
        cmbOperacion = new javax.swing.JComboBox<>();
        cmbPersona = new javax.swing.JComboBox<>();
        jDateFechaMovimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Movimiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Persona:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Operación:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Artículo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        cmbArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbArticuloActionPerformed(evt);
            }
        });
        jPanel1.add(cmbArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 160, -1));

        jPanel1.add(cmbOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 160, -1));

        jPanel1.add(cmbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 160, -1));
        jPanel1.add(jDateFechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        LocalDate fecha = this.jDateFechaMovimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int cantidad = Integer.parseInt(this.txtCantidad.getText());

        ItemCmbPersona objItem = (ItemCmbPersona) this.cmbPersona.getSelectedItem();
        int idPer = objItem.getIdpersona();

        ItemCmbArticulo objItem2 = (ItemCmbArticulo) this.cmbArticulo.getSelectedItem();
        int idArt = objItem2.getIdarticulo();

        ItemCmbOperacion objItem3 = (ItemCmbOperacion) this.cmbOperacion.getSelectedItem();
        int idOpr = objItem3.getIdoperacion();

        AdminMovimientoDB objAdmMovDB = new AdminMovimientoDB();
        Movimiento objMovimiento = new Movimiento();

        objMovimiento.setFecha(fecha);
        objMovimiento.setCantidad(cantidad);
        objMovimiento.setPersona_idpersona(idPer);
        objMovimiento.setArticulo_idarticulo(idArt);
        objMovimiento.setOperacion_idoperacion(idOpr);

        objAdmMovDB.insertar(objMovimiento);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cmbArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbArticuloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDiagAgregarMovimiento dialog = new FrmDiagAgregarMovimiento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbArticulo> cmbArticulo;
    private javax.swing.JComboBox<ItemCmbOperacion> cmbOperacion;
    private javax.swing.JComboBox<ItemCmbPersona> cmbPersona;
    private com.toedter.calendar.JDateChooser jDateFechaMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
