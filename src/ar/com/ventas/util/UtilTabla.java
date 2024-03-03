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

/**
 *
 * @author Mario
 */
public class UtilTabla extends DefaultTableCellRenderer {

    DefaultTableCellRenderer cellRenderRight = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderCenter = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderLeft = new DefaultTableCellRenderer();

    Color color = new Color(224, 255, 255);
    Color colorFdo = new Color(255, 255, 255);

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

        cellRenderRight.setHorizontalAlignment(SwingConstants.RIGHT);
        cellRenderCenter.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderLeft.setHorizontalAlignment(SwingConstants.LEFT);

        jtable.getColumnModel().getColumn(0).setCellRenderer(cellRenderLeft);
        jtable.getColumnModel().getColumn(1).setCellRenderer(cellRenderCenter);
        jtable.getColumnModel().getColumn(2).setCellRenderer(cellRenderLeft);
        jtable.getColumnModel().getColumn(3).setCellRenderer(cellRenderRight);
        jtable.getColumnModel().getColumn(4).setCellRenderer(cellRenderCenter);
        jtable.getColumnModel().getColumn(5).setCellRenderer(cellRenderLeft);
        jtable.getColumnModel().getColumn(6).setCellRenderer(cellRenderRight);
        jtable.getColumnModel().getColumn(7).setCellRenderer(cellRenderRight);
        jtable.getColumnModel().getColumn(8).setCellRenderer(cellRenderRight);
        jtable.getColumnModel().getColumn(9).setCellRenderer(cellRenderCenter);

//        super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);

        if (jtable.getValueAt(i, 9).toString().equals("M")) {
            jtable.setBackground(colorFdo);
            
        } else {
            jtable.setBackground(color);
        }

        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
    }
}
