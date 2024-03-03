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
public class UtilTablaRenovarAbonos extends DefaultTableCellRenderer {

    Color color = new Color(255, 255, 150);
    Color colorFdo = new Color(255, 255, 255);
    Color colorFdoI = new Color(230, 230, 250);
    DefaultTableCellRenderer cellRenderRightColor = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderRightColorFdo = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderRightColorFdoI = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderCenterColor = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderCenterColorFdo = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderCenterColorFdoI = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object o, boolean bln, boolean bln1, int i, int i1) {

//        super.getTableCellRendererComponent(tabla, o, bln, bln1, i, i1);
//        cellRenderCenterColor.setHorizontalAlignment(SwingConstants.CENTER);
//        cellRenderCenterColorFdo.setHorizontalAlignment(SwingConstants.CENTER);
//        cellRenderCenterColorFdoI.setHorizontalAlignment(SwingConstants.CENTER);
//        cellRenderRightColor.setBackground(color);
//        cellRenderRightColorFdo.setBackground(colorFdo);
//        cellRenderRightColorFdoI.setBackground(colorFdoI);

        if (tabla.getValueAt(i, 6).toString().equals("M")) {
            if (i % 2 == 0) {
                tabla.getColumnModel().getColumn(2).setCellRenderer(cellRenderCenterColorFdo);
                tabla.getColumnModel().getColumn(3).setCellRenderer(cellRenderCenterColorFdo);
            } else {
                tabla.getColumnModel().getColumn(2).setCellRenderer(cellRenderCenterColorFdoI);
                tabla.getColumnModel().getColumn(3).setCellRenderer(cellRenderCenterColorFdoI);
//                setBackground(colorFdoI);
//                tabla.setBackground(colorFdoI);
            }

        } else {
            tabla.getColumnModel().getColumn(2).setCellRenderer(cellRenderCenterColor);
            tabla.getColumnModel().getColumn(3).setCellRenderer(cellRenderCenterColor);
//            setBackground(color);
//            tabla.setBackground(color);
        }

//        
//        tabla.getColumnModel().getColumn(2).setCellRenderer(cellRenderCenter);
        return super.getTableCellRendererComponent(tabla, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
}
