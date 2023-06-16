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

public class FrmDiagActualizarMovimiento extends javax.swing.JDialog {

    AdminMovimientoDB objAdmMovDB = new AdminMovimientoDB();
    private int idmovimiento;

    public FrmDiagActualizarMovimiento(java.awt.Frame parent, boolean modal, int idmovimiento) {
        super(parent, modal);
        initComponents();
        this.idmovimiento = idmovimiento;
        this.cargarMovimientos(idmovimiento);
    }

    private void cargarMovimientos(int idmov) {
        Movimiento objMovimiento = new Movimiento();
        objMovimiento.setIdmovimiento(idmov);

        objMovimiento = (Movimiento) objAdmMovDB.listarUno(objMovimiento);

        LocalDate fechaMovimiento = objMovimiento.getFecha();
        this.jDateFechaMovimiento.setDate(java.sql.Date.valueOf(fechaMovimiento));
        this.txtCantidad.setText(String.valueOf(objMovimiento.getCantidad()));

        AdminPersonaDB objAdmPer = new AdminPersonaDB();

        ItemCmbPersona itemSeleccionado = new ItemCmbPersona();
        for (Object obj : objAdmPer.listarTodo()) {
            Persona objPersona = new Persona();
            objPersona = (Persona) obj;

            ItemCmbPersona objItem = new ItemCmbPersona();
            objItem.setIdpersona(objPersona.getIdpersona());
            objItem.setIdentificacion(objPersona.getIdentificacion());

            this.cmbPersona.addItem(objItem);

            if (objMovimiento.getPersona_idpersona() == objPersona.getIdpersona()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbPersona.setSelectedItem(itemSeleccionado);

        AdminArticuloDB objAdmArt = new AdminArticuloDB();

        ItemCmbArticulo itemSeleccionado2 = new ItemCmbArticulo();
        for (Object obj : objAdmArt.listarTodo()) {
            Articulo objArticulo = new Articulo();
            objArticulo = (Articulo) obj;

            ItemCmbArticulo objItem = new ItemCmbArticulo();
            objItem.setIdarticulo(objArticulo.getIdarticulo());
            objItem.setNombreart(objArticulo.getNombreart());

            this.cmbArticulo.addItem(objItem);

            if (objMovimiento.getArticulo_idarticulo() == objArticulo.getIdarticulo()) {
                itemSeleccionado2 = objItem;
            }
        }

        this.cmbArticulo.setSelectedItem(itemSeleccionado);

        AdminOperacionDB objAdmOpr = new AdminOperacionDB();

        ItemCmbOperacion itemSeleccionado3 = new ItemCmbOperacion();
        for (Object obj : objAdmOpr.listarTodo()) {
            Operacion objOperacion = new Operacion();
            objOperacion = (Operacion) obj;

            ItemCmbOperacion objItem = new ItemCmbOperacion();
            objItem.setIdoperacion(objOperacion.getIdoperacion());
            objItem.setNombreopr(objOperacion.getNombreopr());

            this.cmbOperacion.addItem(objItem);

            if (objMovimiento.getOperacion_idoperacion() == objOperacion.getIdoperacion()) {
                itemSeleccionado3 = objItem;
            }
        }

        this.cmbPersona.setSelectedItem(itemSeleccionado);

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
        jLabel1.setText("Actualizar Movimiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Persona:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Operación:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Artículo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jPanel1.add(cmbArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 180, -1));

        jPanel1.add(cmbOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, -1));

        jPanel1.add(cmbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 180, -1));
        jPanel1.add(jDateFechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        objMovimiento.setIdmovimiento(this.idmovimiento);
        objAdmMovDB.listarUno(objMovimiento);

        objMovimiento.setFecha(fecha);
        objMovimiento.setCantidad(cantidad);
        objMovimiento.setPersona_idpersona(idPer);
        objMovimiento.setArticulo_idarticulo(idArt);
        objMovimiento.setOperacion_idoperacion(idOpr);

        objAdmMovDB.actualizar(objMovimiento);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed
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
