/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Contenido;
import ar.com.ventas.entities.EstructuraServicio;
import ar.com.ventas.services.PersonaService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class ObtenerContenidoUtil {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa");
    private DecimalFormat df = new DecimalFormat("#0.00");

    public String getContenido(EstructuraServicio es, Contenido contenido) {
        String resultado = "";
        Date f = new Date();
        Integer ce = es.getCampoEstructura();
        switch (ce) {
            case 1:
                try {
                    f = sdf.parse(contenido.getContenido());
                } catch (ParseException ex) {
                    Logger.getLogger(ObtenerContenidoUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                resultado = sdf.format(f);
                break;
            case 2:
                try {
                    f = sdf.parse(contenido.getContenido());
                } catch (ParseException ex) {
                    Logger.getLogger(ObtenerContenidoUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                resultado = sdf.format(f);
                break;
            case 3:
                try {
                    f = sdf.parse(contenido.getContenido());
                } catch (ParseException ex) {
                    Logger.getLogger(ObtenerContenidoUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                resultado = sdf.format(f);
                break;
            case 4:
                System.out.println(contenido.getContenido());
                System.exit(0);
                try {
                    f = sdf.parse(contenido.getContenido());
                } catch (ParseException ex) {
                    Logger.getLogger(ObtenerContenidoUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                resultado = sdf.format(f);
                break;
            case 5:
                try {
                    f = sdf.parse(contenido.getContenido());
                } catch (ParseException ex) {
                    Logger.getLogger(ObtenerContenidoUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                resultado = sdf.format(f);
                break;
            case 6:
                Long id = Long.valueOf(contenido.getContenido());
                String persona = "";
                    try {
                        persona = new PersonaService().getPersonaActivaById(id);
                    } catch (Exception ex) {
                        Logger.getLogger(ObtenerContenidoUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                resultado = persona;
                break;
            case 7:
                String tex = contenido.getContenido();
                resultado = tex;
                break;
            case 8:
                Double doble = Double.valueOf(contenido.getContenido().replace(",","."));
                String importe = df.format(doble);
                resultado = importe;
                break;
            case 9:
                Integer entero = Integer.valueOf(contenido.getContenido());
                resultado = entero.toString();
                break;
            case 10:
                resultado = contenido.getContenido();
                break;
            case 11:
                resultado = contenido.getContenido();
                break;
            case 12:
                resultado = contenido.getContenido();
                break;
            default:
                resultado = "";
        }
        return resultado;
    }
    
    
}
