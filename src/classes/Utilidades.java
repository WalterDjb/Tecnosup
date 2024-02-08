/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.mail.internet.InternetAddress;
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

    public static void verificarUsuario(JTextField campo, JLabel label) {
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
                        colocarImagen("src/images/wrong_20x20.png", label);
                        cn.close();
                    } else {
                        cn.close();
                    }

                } catch (SQLException e) {
                    System.err.println("Error en validar nombre de usuario en Utilidades.java + " + e);
                    //JOptionPane.showMessageDialog(null, "Error al verificar usuario, contacte a su administrador.");
                }
            }
        });
    }

    public static void verificarCampo(JTextField campo, JLabel label, int min, int max, boolean mail) {
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
                if (!campo.getText().trim().equals("")) {
                    if (!mail) {
                        if (campo.getText().trim().length() < min || campo.getText().trim().length() > max) {
                            colocarImagen("src/images/wrong_20x20.png", label);
                        } else {
                            colocarImagen("src/images/ok_20x20.png", label);
                        }
                    } else {
                        if (isValidMail(campo)) {
                            colocarImagen("src/images/ok_20x20.png", label);
                        } else {
                            colocarImagen("src/images/wrong_20x20.png", label);
                        }
                    }
                } else {
                    colocarImagen("", label);
                }
            }
        });
    }

    private static boolean isValidMail(JTextField campo) {
        try {
            InternetAddress internetAddress = new InternetAddress(campo.getText().trim());
            internetAddress.validate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void esperar(int mseg) {
        try {
            Thread.sleep(mseg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
