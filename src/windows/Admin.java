/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.sql.*;
import classes.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;

/**
 *
 * @author Walter Benítez
 */
public class Admin extends javax.swing.JFrame {

    private String name;
    private int sesion;

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(20, 34, 34));
        setSize(650, 430);
        setResizable(false);
        setTitle("Tecnosup - Administrador");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //RECUPERAR EL NOMBRE DEL USUARIO QUE INICIA SESIÓN PARA MOSTRARLO EN PANTALLA
        try {
            Connection cn = Conexion.connect();
            PreparedStatement pst = cn.prepareStatement("select name from users where username = '" + Login.user + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
                label_name_user.setText(name);
            }
        } catch (Exception e) {
            System.err.println("Error en conexión desde Admin.java " + e);
        }
    }

    //PONEMOS UN ICONO PERSONALIZADO A NUESTRO JFRAME
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_ref = new javax.swing.JLabel();
        label_name_user = new javax.swing.JLabel();
        boton_registrar = new javax.swing.JButton();
        boton_gestion_user = new javax.swing.JButton();
        boton_provisorio = new javax.swing.JButton();
        boton_receptor = new javax.swing.JButton();
        boton_tecnico = new javax.swing.JButton();
        boton_info = new javax.swing.JButton();
        boton_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_ref.setForeground(new java.awt.Color(204, 204, 204));
        label_ref.setText("Software creado por Walter Eduardo Benítez ©");
        getContentPane().add(label_ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 405, -1, -1));

        label_name_user.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        label_name_user.setForeground(new java.awt.Color(255, 255, 255));
        label_name_user.setText("Walter Eduardo Benítez");
        getContentPane().add(label_name_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 40, -1, -1));

        boton_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_user.png"))); // NOI18N
        boton_registrar.setBorderPainted(false);
        boton_registrar.setContentAreaFilled(false);
        boton_registrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_user_press.png"))); // NOI18N
        boton_registrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_user_select.png"))); // NOI18N
        boton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 128, 128));

        boton_gestion_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adm_user.png"))); // NOI18N
        boton_gestion_user.setBorderPainted(false);
        boton_gestion_user.setContentAreaFilled(false);
        boton_gestion_user.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adm_user_press.png"))); // NOI18N
        boton_gestion_user.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adm_user_select.png"))); // NOI18N
        getContentPane().add(boton_gestion_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 80, 128, 128));

        boton_provisorio.setBorderPainted(false);
        boton_provisorio.setContentAreaFilled(false);
        getContentPane().add(boton_provisorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 80, 128, 128));

        boton_receptor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mod_recep.png"))); // NOI18N
        boton_receptor.setBorderPainted(false);
        boton_receptor.setContentAreaFilled(false);
        boton_receptor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mod_recep_press.png"))); // NOI18N
        boton_receptor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mod_recep_select.png"))); // NOI18N
        getContentPane().add(boton_receptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 128, 128));

        boton_tecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mod_tec.png"))); // NOI18N
        boton_tecnico.setBorderPainted(false);
        boton_tecnico.setContentAreaFilled(false);
        boton_tecnico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mod_tec_press.png"))); // NOI18N
        boton_tecnico.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mod_tec_select.png"))); // NOI18N
        getContentPane().add(boton_tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 250, 128, 128));

        boton_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        boton_info.setBorderPainted(false);
        boton_info.setContentAreaFilled(false);
        boton_info.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info_press.png"))); // NOI18N
        boton_info.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info_select.png"))); // NOI18N
        getContentPane().add(boton_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 250, 128, 128));

        boton_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        boton_exit.setBorder(null);
        boton_exit.setBorderPainted(false);
        boton_exit.setContentAreaFilled(false);
        boton_exit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_selected.png"))); // NOI18N
        boton_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_exitActionPerformed(evt);
            }
        });
        getContentPane().add(boton_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, -1, 32, 32));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_boton_exitActionPerformed

    private void boton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrarActionPerformed
        try {
            new AddUser().setVisible(true);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_boton_registrarActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_exit;
    private javax.swing.JButton boton_gestion_user;
    private javax.swing.JButton boton_info;
    private javax.swing.JButton boton_provisorio;
    private javax.swing.JButton boton_receptor;
    private javax.swing.JButton boton_registrar;
    private javax.swing.JButton boton_tecnico;
    private javax.swing.JLabel label_name_user;
    private javax.swing.JLabel label_ref;
    // End of variables declaration//GEN-END:variables
}
