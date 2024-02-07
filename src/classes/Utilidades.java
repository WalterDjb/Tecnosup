/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Walter Benítez
 */
public class Utilidades {

    public static void colocarImagen(String ruta, JLabel label) {
        ImageIcon img = new ImageIcon(ruta);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }

    public static void actualizarLabel(JTextField campo, JLabel etiqueta, String texto) {
        campo.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                cambiar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cambiar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cambiar();
            }

            public void cambiar() {
                if (!(campo.getText().equals(""))) {
                    etiqueta.setText("");
                } else {
                    etiqueta.setForeground(Color.white);
                    etiqueta.setText(texto);

                }
            }
        });
    }

    public static void verificarUsuario(JTextField campo) {
        campo.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                cambiar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cambiar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cambiar();
            }

            public void cambiar() {
                try {
                    Connection cn = Conexion.connect();
                    PreparedStatement pst = cn.prepareStatement("select username from users where username = '" + campo.getText().trim() + "'");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        campo.setForeground(Color.red);
                        cn.close();
                    } else {
                        campo.setForeground(Color.white);
                        cn.close();
                    }

                } catch (SQLException e) {
                    System.err.println("Error en validar nombre de usuario en Utilidades.java + " + e);
                    //JOptionPane.showMessageDialog(null, "Error al verificar usuario, contacte a su administrador.");
                }
            }
        });
    }
}
