/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

/**
 *
 * @author Walter Benítez
 */
public class CustomComboBoxUI extends BasicComboBoxUI {
    
    //DEFINO EL COLOR QUE QUIERO QUE TENGA MI BOTÓN Y EL ELEMENTO SELECCIONADO DEL JCOMBOBOX
    private final Color customColor = new Color(22, 137, 51);

    //CREACIÓN DEL BOTON CON LOS ELEMENTOS PERSONALIZADOS
    @Override
    protected JButton createArrowButton() {
        JButton button = new JButton();
        button.setMinimumSize(new Dimension(4, 4));
        button.setMaximumSize(new Dimension(4, 4));
        button.setPreferredSize(new Dimension(4, 4));
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon("src/images/desp.png"));

        return button;
    }
    
    //CREACION DEL RENDERIZADOR PARA CAMBIAR EL COLOR DEL ELEMENTO SELECCIONADO (FONDO Y FUENTE)
    @Override
    protected ListCellRenderer createRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                //VERIFICAMOS SI EL ELEMENTO ESTÁ SELECCIONADO, SI ES ASÍ SE CAMBIA DE COLOR EL TEXTO Y EL FONDO SELECCIOANDO
                if (isSelected) {
                    setBackground(customColor);
                    setForeground(Color.WHITE);
                }
                return this;
            }
        };
    }
}
