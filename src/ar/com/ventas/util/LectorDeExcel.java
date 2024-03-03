/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.services.ConsorcioService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class LectorDeExcel {

    public static List<Consorcio> leerConsorcios(File file) throws IOException, BiffException, Exception {

        Workbook archivoExcel = Workbook.getWorkbook(file);

        int cantidadFilas = archivoExcel.getSheet(0).getRows();

        Sheet hoja = archivoExcel.getSheet(0);

        List<Consorcio> listaUF = new ArrayList<Consorcio>();

        try {
            for (int i = 2; i < cantidadFilas; i++) {
                
                Long idC = Long.valueOf(hoja.getCell(0, i).getContents());
                System.out.println(idC);
                Consorcio co = new ConsorcioService().getConsorcioById(idC);
                if(co != null){
                    System.out.println(hoja.getCell(1, i).getContents());
                    System.out.println(hoja.getCell(2, i).getContents());
                    System.out.println(hoja.getCell(3, i).getContents());
                    System.out.println(hoja.getCell(4, i).getContents());
                    co.setNombre(hoja.getCell(1, i).getContents());
                    Domicilio dm = co.getDomicilio();
                    dm.setCalle(hoja.getCell(2, i).getContents());
                    dm.setNumero(hoja.getCell(3, i).getContents());
                    co.setDomicilio(dm);
                    co.setCuit(hoja.getCell(4, i).getContents());
                    new ConsorcioService().updateConsorcio(co);
                }
            }
        } catch (Exception ex) {
            throw new Exception("Error leyendo el archivo.");
        }
        return listaUF;
    }

    private static boolean isNumeric(String celda) {
        try {
            Double.parseDouble(celda);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

}
