/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.BO;

import ar.com.ventas.DAO.AbonoFacturaDAO;
import ar.com.ventas.entities.AbonoFactura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class AbonoFacturaBO {

    AbonoFacturaDAO dao = new AbonoFacturaDAO();

//    public List<Abono> getAllAbonosActivosOrdenado() throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenado();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubro(Rubro rubro) throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenadoByRubro(rubro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenadoByRubroAndAdministrador(rubro, admin);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroPendientesFacturar(Rubro rubro, Administrador admin) throws Exception {
//        try {
//            return dao.getAllAbonosActivosOrdenadoByRubroPendientesFacturar(rubro, admin);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Abono> getAllAbonosActivos() throws Exception {
//        try {
//            return dao.getAllAbonosActivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
    public void saveAbonoFactura(AbonoFactura abonoFc) throws Exception {
        try {
            dao.save(abonoFc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
//
//    public void updateAbono(Abono abono) throws Exception {
//        try {
//            dao.update(abono);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        try {
//            codigo = dao.getCodigoSiguiente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
//
//    public List<Abono> getAbonosActivosVencidosByFecha(Date fechaConsulta) throws Exception {
//        List<Abono> abono2 = new ArrayList<>();
//        List<Abono> abonos = null;
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
//        Calendar cal = Calendar.getInstance();
//        String periodo1 = sdf2.format(fechaConsulta);
//        String periodo2;
//        cal.setTime(fechaConsulta);
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        int p1 = Integer.valueOf(periodo1);
//
//        try {
//            abonos = dao.getAbonosActivosVencidosByFecha();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        if (abonos != null && !abonos.isEmpty()) {
//            for (Abono ab : abonos) {
//                 periodo2 = sdf2.format(ab.getFechaPeriodo());
//                 int p2 = Integer.valueOf(periodo2);
//                 if(p2 < p1){
//                     abono2.add(ab);
//                 }
//            }
//        }
//        return abono2;
//    }
}
