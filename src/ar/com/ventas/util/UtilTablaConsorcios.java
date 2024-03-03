/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class UtilTablaConsorcios extends DefaultTableCellRenderer {

    Color color = new Color(224, 255, 255);
    Color colorFdo = new Color(255, 255, 255);

    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object o, boolean bln, boolean bln1, int i, int i1) {

        super.getTableCellRendererComponent(tabla, o, bln, bln1, i, i1);

        if (tabla.getValueAt(i, 7).toString().equals("MASTER")) {
            setBackground(colorFdo);
        } else {
            setBackground(color);
        }

        return super.getTableCellRendererComponent(tabla, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
}
