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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Movimiento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Persona");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Operación");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Artículo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbArticulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCantidad)
                        .addComponent(cmbPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateFechaMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jDateFechaMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
