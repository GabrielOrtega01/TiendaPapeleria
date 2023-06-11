package vistas;

public class FrmPrincipalColaborador extends javax.swing.JFrame {

    public FrmPrincipalColaborador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        submenuSalir = new javax.swing.JMenuItem();
        submenuAcceso = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        submenuAdminArticulos = new javax.swing.JMenuItem();
        submenuAdmOperaciones = new javax.swing.JMenuItem();
        submenuAdmMovimientos = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        submenuReportesListaArticulos = new javax.swing.JMenuItem();
        submenuReportesAdministrarInventario = new javax.swing.JMenuItem();
        submenuReportesListaArticulosActualizada = new javax.swing.JMenuItem();
        submenuReportesBalanceGeneral = new javax.swing.JMenuItem();
        submenuReportesDinetoTotal = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        submenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setBackground(new java.awt.Color(206, 237, 237));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(1150, 668));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rol: Colaborador");
        jPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Papelería");
        jPanelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/papeleria.png"))); // NOI18N
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuArchivo.setText("Archivo");

        submenuSalir.setText("Salir");
        submenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(submenuSalir);

        submenuAcceso.setText("Acceso");
        submenuAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAccesoActionPerformed(evt);
            }
        });
        menuArchivo.add(submenuAcceso);

        barraDeMenu.add(menuArchivo);

        menuConfiguracion.setText("Configuración");

        submenuAdminArticulos.setLabel("Admin artículos");
        submenuAdminArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminArticulosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdminArticulos);

        submenuAdmOperaciones.setText("Admin operaciones");
        submenuAdmOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmOperacionesActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmOperaciones);

        submenuAdmMovimientos.setText("Admin movimientos");
        submenuAdmMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmMovimientosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmMovimientos);

        barraDeMenu.add(menuConfiguracion);

        menuReportes.setText("Reportes");

        submenuReportesListaArticulos.setText("Lista de artículos");
        submenuReportesListaArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesListaArticulosActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesListaArticulos);

        submenuReportesAdministrarInventario.setText("Administrar inventario de artículos");
        submenuReportesAdministrarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesAdministrarInventarioActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesAdministrarInventario);

        submenuReportesListaArticulosActualizada.setText("Lista de artículos actualizada");
        submenuReportesListaArticulosActualizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesListaArticulosActualizadaActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesListaArticulosActualizada);

        submenuReportesBalanceGeneral.setText("Balance general");
        submenuReportesBalanceGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesBalanceGeneralActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesBalanceGeneral);

        submenuReportesDinetoTotal.setText("Dinero total invertido en el inventario");
        submenuReportesDinetoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesDinetoTotalActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesDinetoTotal);

        barraDeMenu.add(menuReportes);

        menuAyuda.setText("Ayuda");

        submenuAcercaDe.setText("Acerca de ...");
        submenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAcercaDeActionPerformed(evt);
            }
        });
        menuAyuda.add(submenuAcercaDe);

        barraDeMenu.add(menuAyuda);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAcercaDeActionPerformed
        FrmDiagAcercaDe objFrmDiagAcerca = new FrmDiagAcercaDe(this, true);
        objFrmDiagAcerca.setLocationRelativeTo(null);
        objFrmDiagAcerca.setVisible(true);
    }//GEN-LAST:event_submenuAcercaDeActionPerformed

    private void submenuReportesDinetoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesDinetoTotalActionPerformed
        FrmDiagReportesDineroTotal objFrmDiagRepDT = new FrmDiagReportesDineroTotal(this, true);
        objFrmDiagRepDT.setLocationRelativeTo(null);
        objFrmDiagRepDT.setVisible(true);
    }//GEN-LAST:event_submenuReportesDinetoTotalActionPerformed

    private void submenuReportesBalanceGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesBalanceGeneralActionPerformed
        FrmDiagReportesBalanceGeneral objFrmDiagRepBG = new FrmDiagReportesBalanceGeneral(this, true);
        objFrmDiagRepBG.setLocationRelativeTo(null);
        objFrmDiagRepBG.setVisible(true);
    }//GEN-LAST:event_submenuReportesBalanceGeneralActionPerformed

    private void submenuAdmMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmMovimientosActionPerformed
        FrmDiagAdminMovimientos objFrmDiagAdmMovimiento = new FrmDiagAdminMovimientos(this, true);
        objFrmDiagAdmMovimiento.setLocationRelativeTo(null);
        objFrmDiagAdmMovimiento.setVisible(true);
    }//GEN-LAST:event_submenuAdmMovimientosActionPerformed

    private void submenuAdmOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmOperacionesActionPerformed
        FrmDiagAdminOperaciones objFrmDiagAdmOperacion = new FrmDiagAdminOperaciones(this, true);
        objFrmDiagAdmOperacion.setLocationRelativeTo(null);
        objFrmDiagAdmOperacion.setVisible(true);
    }//GEN-LAST:event_submenuAdmOperacionesActionPerformed

    private void submenuAdminArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdminArticulosActionPerformed
        FrmDiagAdminArticulos objFrmDiagAdmArticulo = new FrmDiagAdminArticulos(this, true);
        objFrmDiagAdmArticulo.setLocationRelativeTo(null);
        objFrmDiagAdmArticulo.setVisible(true);
    }//GEN-LAST:event_submenuAdminArticulosActionPerformed

    private void submenuAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAccesoActionPerformed
        FrmDiagLogin objFrmDiagLogin = new FrmDiagLogin(this, true);
        objFrmDiagLogin.setLocationRelativeTo(null);
        objFrmDiagLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_submenuAccesoActionPerformed

    private void submenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_submenuSalirActionPerformed

    private void submenuReportesListaArticulosActualizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesListaArticulosActualizadaActionPerformed
        FrmDiagReportesListaArticulosActualizada objFrmDiagRepLAA = new FrmDiagReportesListaArticulosActualizada(this, true);
        objFrmDiagRepLAA.setLocationRelativeTo(null);
        objFrmDiagRepLAA.setVisible(true);
    }//GEN-LAST:event_submenuReportesListaArticulosActualizadaActionPerformed

    private void submenuReportesListaArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesListaArticulosActionPerformed
        FrmDiagReportesListaArticulos objFrmDiagRepLA = new FrmDiagReportesListaArticulos(this, true);
        objFrmDiagRepLA.setLocationRelativeTo(null);
        objFrmDiagRepLA.setVisible(true);
    }//GEN-LAST:event_submenuReportesListaArticulosActionPerformed

    private void submenuReportesAdministrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesAdministrarInventarioActionPerformed
        FrmDiagReportesAdministrarInventarioArticulos objFrmDiagRepAIA = new FrmDiagReportesAdministrarInventarioArticulos(this, true);
        objFrmDiagRepAIA.setLocationRelativeTo(null);
        objFrmDiagRepAIA.setVisible(true);
    }//GEN-LAST:event_submenuReportesAdministrarInventarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem submenuAcceso;
    private javax.swing.JMenuItem submenuAcercaDe;
    private javax.swing.JMenuItem submenuAdmMovimientos;
    private javax.swing.JMenuItem submenuAdmOperaciones;
    private javax.swing.JMenuItem submenuAdminArticulos;
    private javax.swing.JMenuItem submenuReportesAdministrarInventario;
    private javax.swing.JMenuItem submenuReportesBalanceGeneral;
    private javax.swing.JMenuItem submenuReportesDinetoTotal;
    private javax.swing.JMenuItem submenuReportesListaArticulos;
    private javax.swing.JMenuItem submenuReportesListaArticulosActualizada;
    private javax.swing.JMenuItem submenuSalir;
    // End of variables declaration//GEN-END:variables
}
