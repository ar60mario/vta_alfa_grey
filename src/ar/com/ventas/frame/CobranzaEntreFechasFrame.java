/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ReciboService;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class CobranzaEntreFechasFrame extends javax.swing.JFrame {

    private List<Recibo> recibos;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * Creates new form CobranzaEntreFechasFrame
     */
    public CobranzaEntreFechasFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
//        this.setLocationRelativeTo(null);
        setExtendedState(this.MAXIMIZED_BOTH);
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("COBRANZA ENTRE FECHAS");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADMIN", "CONSORCIO", "NUMERO", "RUBRO", "CUOTA", "IMPORTE", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CobranzaEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobranzaEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobranzaEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobranzaEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobranzaEntreFechasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
//        alTxt.setText("");
//        deTxt.setText("");
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        recibos = null;
        Date de = new Date();
        Date al = new Date();
//        try {
//            de = sdf.parse(deTxt.getText());
//            al = sdf.parse(alTxt.getText());
//        } catch (ParseException ex) {
//            Logger.getLogger(CobranzaEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            recibos = new ReciboService().getRecibosEntreFechas(de, al);
        } catch (Exception ex) {
            Logger.getLogger(CobranzaEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (recibos != null && !recibos.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Recibo re : recibos) {
                Object o[] = new Object[4];
                o[0] = sdf.format(re.getFecha());
                Domicilio dm = re.getConsorcio().getDomicilio();
                String cons = dm.getCalle() + " " + dm.getNumero();
                o[1] = cons;
                o[2] = re.getId().toString();
                o[3] = df.format(re.getImporte());
                tbl.addRow(o);
            }
            tabla.setModel(tbl);

        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }
}
