package vistas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.ListaArticulo;

public class FrmDiagReportesListaArticulos extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB = new RelacionesDB();

    public FrmDiagReportesListaArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Código", "Artículo", "Cantidad", "Precio unitario", "Dinero invertido", "Fecha de ingreso", "Responsable del ingreso"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera);
        this.tblReporteListaArticulos.setModel(this.modeloTabla);

    }

    private void refrescarTabla(LocalDate fechaInicio, LocalDate fechaFin) {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[7];
        int TotalInvertido = 0;

        for (Object obj : objRelDB.consultarDatos(fechaInicio, fechaFin)) {
            ListaArticulo objListaAticulo = (ListaArticulo) obj;
            filaDeTabla[0] = objListaAticulo.getCodigo();
            filaDeTabla[1] = objListaAticulo.getArticulo();
            filaDeTabla[2] = Integer.toString(objListaAticulo.getCantidad());
            filaDeTabla[3] = Integer.toString(objListaAticulo.getPreciounitario());
            filaDeTabla[4] = objListaAticulo.getDinero_invertido().toString();
            filaDeTabla[5] = objListaAticulo.getFecha_de_ingreso().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[6] = objListaAticulo.getResponsable_del_ingreso();

            this.modeloTabla.addRow(filaDeTabla);

            TotalInvertido += objListaAticulo.getDinero_invertido().intValue();
        }
        // Formatear el total invertido con separadores de miles
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String totalInvertidoFormateado = decimalFormat.format(TotalInvertido);
        this.labTotalInvertido.setText(totalInvertidoFormateado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteListaArticulos = new javax.swing.JTable();
        btnConsultarNuevosArticulos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labTotalInvertido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 357));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Artículos");

        tblReporteListaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Artículo", "Cantidad", "Precio unitario", "Dinero invertido", "Fecha de ingreso", "Responsable del ingreso"
            }
        ));
        jScrollPane1.setViewportView(tblReporteListaArticulos);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Dinero total invertido en los nuevos artículos :");

        labTotalInvertido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTotalInvertido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTotalInvertido.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(labTotalInvertido, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnConsultarNuevosArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(482, 482, 482))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labTotalInvertido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarNuevosArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarNuevosArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNuevosArticulosActionPerformed

        LocalDate fechaInicio = this.jDateFechaInicio.getDate() != null ? this.jDateFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate fechaFin = this.jDateFechaFin.getDate() != null ? this.jDateFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        if (fechaInicio == null && fechaFin == null) {
            JOptionPane.showMessageDialog(this, "¡Los campos no pueden estar vacíos!");
        } else if (fechaInicio == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha inicial no debe estar vacía!");
        } else if (fechaFin == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha final no debe estar vacía!");
        } else if (fechaInicio.isBefore(fechaFin) || fechaInicio.equals(fechaFin)) {
            this.refrescarTabla(fechaInicio, fechaFin);
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
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labTotalInvertido;
    private javax.swing.JTable tblReporteListaArticulos;
    // End of variables declaration//GEN-END:variables
}
