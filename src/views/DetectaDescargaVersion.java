/*
 * 
 *
 * 
 */
package views;

import Clases.SearchUpdate;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistemas
 */
public class DetectaDescargaVersion extends javax.swing.JFrame {

    String version = "8.1.2";
   

    public DetectaDescargaVersion() {
        initComponents();
        this.setTitle("Actualizar Punto de Venta v" + version);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jButtonActualizar.setVisible(false);
        jMensajes.setForeground(Color.BLUE);
        jMensajes.setText("Version del Sistema actual: " + version);
        jMensaje2.setVisible(false);
    }

    public void EVTBuscarVersion() {
        jMensajes.setVisible(true);
        jMensajes.setForeground(Color.blue);
        jButtonActualizar.setVisible(false);
        jMensaje2.setVisible(false);
        new Thread(() -> {
            try {
                Thread.sleep(1);
                jButtonBuscarVersion.setVisible(false);
                if (SearchUpdate.conexion()) {
                    Thread.sleep(128);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles   ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles.  ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles.. ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles...");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles   ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles.  ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles.. ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles...");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles   ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles.  ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles.. ");
                    Thread.sleep(500);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles...");
                    Thread.sleep(200);
                    jMensajes.setForeground(Color.blue);
                    jMensajes.setText("Buscando versiones disponibles   ");
                    jButtonBuscarVersion.setVisible(true); 
                    if (SearchUpdate.obtenerVersion().equals(version)) {
                        System.out.println("Version del Sistema actual: " + version);
                        System.out.println("No hay versiones nuevas para el punto de venta");
                        jMensajes.setForeground(Color.blue);
                        jMensajes.setText("No hay versiones nuevas para el punto de venta");
                        jMensaje2.setVisible(true);
                        jMensaje2.setForeground(Color.BLUE);
                        jMensaje2.setText("Version del Sistema actual: " + version);
                    } else {
                        jMensajes.setForeground(Color.GRAY);
                        jMensajes.setText("Version Disponible: " + SearchUpdate.obtenerVersion());
                        System.out.println("Version del Sistema actual: " + version);
                        System.out.println("Nueva Version: " + SearchUpdate.obtenerVersion() + " Disponible");
                        jButtonActualizar.setVisible(true);
                    }
                } else {
                    jMensajes.setVisible(false);
                    jMensaje2.setVisible(true);
                    jMensaje2.setForeground(Color.red);
                    jMensaje2.setText("No hay conexión a Internet.");
                }
            } catch (InterruptedException ex) {
                System.err.println(" " + ex.getMessage());
                Logger.getLogger(DetectaDescargaVersion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    public void EVTActualizar() throws IOException {
        String destinoCarpeta = "C:\\Sistema\\Version " + SearchUpdate.obtenerVersion();
        File fileDestino = new File(destinoCarpeta);
        if (fileDestino.mkdir()) {
            System.out.println("Creada");
        } else {
            System.out.println("La Carpeta ya existe");
            try {
                URL direccionDelServidor = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRldI3W-htjRIjAJiPPqoelzObCZLF-EJVIXsyMmQ5DRAhZPg-W");
                URLConnection urlCon = direccionDelServidor.openConnection();
                System.out.println(urlCon.getContentType());
                InputStream is = urlCon.getInputStream();
                FileOutputStream fos = new FileOutputStream("C:\\Sistema\\Version " + SearchUpdate.obtenerVersion() + "\\Prueba.jpg");
                byte[] array = new byte[1000];
                int leido = is.read(array);
                while (leido > 0) {
                    fos.write(array, 0, leido);
                    leido = is.read(array);
                }
                is.close();
                fos.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

//        SearchUpdate.abrirEnlace("https://drive.google.com/drive/folders/1wIfphqpiwqbAluU_9_mD7tNtOzjI6Ad1");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBuscarVersion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMensajes = new javax.swing.JLabel();
        jMensaje2 = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBuscarVersion.setText("Buscar Actualizaciones");
        jButtonBuscarVersion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarVersionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscarVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 44, -1, -1));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actualizacion del sistema");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 400, -1));

        jMensajes.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMensajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMensajes.setText("Mensajes");
        getContentPane().add(jMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 400, -1));

        jMensaje2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMensaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMensaje2.setText("V actu");
        getContentPane().add(jMensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 400, -1));

        jButtonActualizar.setText("ACTUALIZAR");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 33));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVersionActionPerformed
        EVTBuscarVersion();
    }//GEN-LAST:event_jButtonBuscarVersionActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        try {
            EVTActualizar();
        } catch (IOException ex) {
            Logger.getLogger(DetectaDescargaVersion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(DetectaDescargaVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetectaDescargaVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetectaDescargaVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetectaDescargaVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DetectaDescargaVersion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscarVersion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMensaje2;
    private javax.swing.JLabel jMensajes;
    // End of variables declaration//GEN-END:variables
}
