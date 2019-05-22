/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteprincipal;

import javax.swing.JOptionPane;

/**
 *
 * @author a18luisdvp
 */
public class ventanaprinicipal extends javax.swing.JFrame {

    SalaCine central;
    SalaCine versionOriginal;
    /**
     * Creates new form Multicines
     */
    public ventanaprinicipal() {
        initComponents();
        
        central = new SalaCine();
        versionOriginal = new SalaCine();
        
        central.setAforo(500);
        central.setEntrada(8.0);
        
        versionOriginal.setAforo(80);
        versionOriginal.setEntrada(6.0);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        etiquetaPeliculaCentral = new javax.swing.JLabel();
        textoPeliculaCentral = new javax.swing.JTextField();
        botonCentralNuevaVenta = new javax.swing.JButton();
        botonCentralOcupacion = new javax.swing.JButton();
        botonCentralVaciar = new javax.swing.JButton();
        botonCentralIngresos = new javax.swing.JButton();
        botonCambiarCentral = new javax.swing.JButton();
        panelOriginal = new javax.swing.JPanel();
        etiquetaPeliculaOriginal = new javax.swing.JLabel();
        textoPeliculaOriginal = new javax.swing.JTextField();
        botonCambiarOriginal = new javax.swing.JButton();
        botonOriginalNuevaVenta = new javax.swing.JButton();
        botonOriginalOcupacion = new javax.swing.JButton();
        botonOriginalVaciar = new javax.swing.JButton();
        botonOriginalIngresos = new javax.swing.JButton();
        botonIngresosTotales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCentral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sala Central", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        etiquetaPeliculaCentral.setText("Película:");

        botonCentralNuevaVenta.setText("Nueva Venta");
        botonCentralNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCentralNuevaVentaActionPerformed(evt);
            }
        });

        botonCentralOcupacion.setText("% Ocupación");
        botonCentralOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCentralOcupacionActionPerformed(evt);
            }
        });

        botonCentralVaciar.setText("Vaciar");
        botonCentralVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCentralVaciarActionPerformed(evt);
            }
        });

        botonCentralIngresos.setText("Ingresos");
        botonCentralIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCentralIngresosActionPerformed(evt);
            }
        });

        botonCambiarCentral.setText("Cambiar");
        botonCambiarCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarCentralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(etiquetaPeliculaCentral)
                        .addGap(18, 18, 18)
                        .addComponent(textoPeliculaCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCambiarCentral))
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonCentralNuevaVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCentralOcupacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCentralVaciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCentralIngresos)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPeliculaCentral)
                    .addComponent(textoPeliculaCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarCentral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCentralNuevaVenta)
                    .addComponent(botonCentralOcupacion)
                    .addComponent(botonCentralVaciar)
                    .addComponent(botonCentralIngresos))
                .addGap(36, 36, 36))
        );

        panelOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sala Versión Original", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        etiquetaPeliculaOriginal.setText("Película:");

        botonCambiarOriginal.setText("Cambiar");
        botonCambiarOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarOriginalActionPerformed(evt);
            }
        });

        botonOriginalNuevaVenta.setText("Nueva Venta");
        botonOriginalNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOriginalNuevaVentaActionPerformed(evt);
            }
        });

        botonOriginalOcupacion.setText("% Ocupación");
        botonOriginalOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOriginalOcupacionActionPerformed(evt);
            }
        });

        botonOriginalVaciar.setText("Vaciar");
        botonOriginalVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOriginalVaciarActionPerformed(evt);
            }
        });

        botonOriginalIngresos.setText("Ingresos");
        botonOriginalIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOriginalIngresosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOriginalLayout = new javax.swing.GroupLayout(panelOriginal);
        panelOriginal.setLayout(panelOriginalLayout);
        panelOriginalLayout.setHorizontalGroup(
            panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOriginalLayout.createSequentialGroup()
                .addGroup(panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(etiquetaPeliculaOriginal)
                        .addGap(18, 18, 18)
                        .addComponent(textoPeliculaOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCambiarOriginal))
                    .addGroup(panelOriginalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonOriginalNuevaVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonOriginalOcupacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonOriginalVaciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonOriginalIngresos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOriginalLayout.setVerticalGroup(
            panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOriginalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPeliculaOriginal)
                    .addComponent(textoPeliculaOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarOriginal))
                .addGap(46, 46, 46)
                .addGroup(panelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonOriginalNuevaVenta)
                    .addComponent(botonOriginalOcupacion)
                    .addComponent(botonOriginalVaciar)
                    .addComponent(botonOriginalIngresos))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        botonIngresosTotales.setText("Ingresos Totales");
        botonIngresosTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresosTotalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonIngresosTotales)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonIngresosTotales)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCambiarCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarCentralActionPerformed
        String titulo = JOptionPane.showInputDialog(null, "Introduce el titulo de la película: ");
        central.setPelicula(titulo);
        textoPeliculaCentral.setText(titulo);
    }//GEN-LAST:event_botonCambiarCentralActionPerformed

    private void botonCambiarOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarOriginalActionPerformed
        String titulo = JOptionPane.showInputDialog(null, "Introduce el titulo de la película: ");
        versionOriginal.setPelicula(titulo);
        textoPeliculaOriginal.setText(titulo);
    }//GEN-LAST:event_botonCambiarOriginalActionPerformed

    private void botonCentralNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCentralNuevaVentaActionPerformed
        central.entraUno();
    }//GEN-LAST:event_botonCentralNuevaVentaActionPerformed

    private void botonOriginalNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOriginalNuevaVentaActionPerformed
        versionOriginal.entraUno();
    }//GEN-LAST:event_botonOriginalNuevaVentaActionPerformed

    private void botonCentralOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCentralOcupacionActionPerformed
        String info;
        
        info = "Sala Central\n";
        info = info + "Película: "+central.getPelicula()+"\n";
        info = info + "Aforo: "+central.getAforo()+"\n";
        info = info + "Ocupadas: "+central.getOcupadas()+"\n";
        info = info + "Libres: "+central.getLibres()+"\n";
        info = info + "Porcentaje Ocupación: "+central.getPorcentaje()+"\n";
        
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_botonCentralOcupacionActionPerformed

    private void botonOriginalOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOriginalOcupacionActionPerformed
        String info;
        
        info = "Sala Versión Original\n";
        info = info + "Película: "+versionOriginal.getPelicula()+"\n";
        info = info + "Aforo: "+versionOriginal.getAforo()+"\n";
        info = info + "Ocupadas: "+versionOriginal.getOcupadas()+"\n";
        info = info + "Libres: "+versionOriginal.getLibres()+"\n";
        info = info + "Porcentaje Ocupación: "+versionOriginal.getPorcentaje()+"\n";
        
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_botonOriginalOcupacionActionPerformed

    private void botonCentralVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCentralVaciarActionPerformed
        central.Vaciar();
        textoPeliculaCentral.setText("");
    }//GEN-LAST:event_botonCentralVaciarActionPerformed

    private void botonOriginalVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOriginalVaciarActionPerformed
        versionOriginal.Vaciar();
        textoPeliculaOriginal.setText("");
    }//GEN-LAST:event_botonOriginalVaciarActionPerformed

    private void botonCentralIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCentralIngresosActionPerformed
        String info;
        
        info = "Ingresos de la sala: "+central.getIngresos()+" euros";
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_botonCentralIngresosActionPerformed

    private void botonOriginalIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOriginalIngresosActionPerformed
        String info;
        
        info = "Ingresos de la sala: "+versionOriginal.getIngresos()+" euros";
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_botonOriginalIngresosActionPerformed

    private void botonIngresosTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresosTotalesActionPerformed
        String info;
        info = "Ingresos totales\n";
        info += central.getIngresos() + versionOriginal.getIngresos() + " euros";
        
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_botonIngresosTotalesActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaprinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaprinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaprinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaprinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaprinicipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCambiarCentral;
    private javax.swing.JButton botonCambiarOriginal;
    private javax.swing.JButton botonCentralIngresos;
    private javax.swing.JButton botonCentralNuevaVenta;
    private javax.swing.JButton botonCentralOcupacion;
    private javax.swing.JButton botonCentralVaciar;
    private javax.swing.JButton botonIngresosTotales;
    private javax.swing.JButton botonOriginalIngresos;
    private javax.swing.JButton botonOriginalNuevaVenta;
    private javax.swing.JButton botonOriginalOcupacion;
    private javax.swing.JButton botonOriginalVaciar;
    private javax.swing.JLabel etiquetaPeliculaCentral;
    private javax.swing.JLabel etiquetaPeliculaOriginal;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelOriginal;
    private javax.swing.JTextField textoPeliculaCentral;
    private javax.swing.JTextField textoPeliculaOriginal;
    // End of variables declaration//GEN-END:variables
}
