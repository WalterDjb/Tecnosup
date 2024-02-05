/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Walter Benítez
 */
public class Utilidades {

    public static void actualizar(JTextField campo, JLabel etiqueta, String texto) {
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
                    etiqueta.setText(texto);

                }
            }
        });
    }
}
