/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.BO.AbonoFacturaBO;
import ar.com.ventas.entities.AbonoFactura;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class AbonoFacturaService {

//    public List<Abono> getAllAbonosActivosOrdenado() throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenado();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//
//    public List<Abono> getAbonosActivosVencidosByFecha(Date fechaConsulta) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosVencidosByFecha(fechaConsulta);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubro(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenadoByRubro(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenadoByRubroAndAdministrador(rubro, admin);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroPendientesFacturar(Rubro rubro, Administrador admin) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenadoByRubroPendientesFacturar(rubro, admin);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivos() throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//
    public void saveAbonoFactura(AbonoFactura abonoFc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new AbonoFacturaBO().saveAbonoFactura(abonoFc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
//
//    public void saveAbonoCompleto(Abono abono, List<RenglonAbono> renglones) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().saveAbono(abono);
//            for (RenglonAbono re : renglones) {
//                re.setAbono(abono);
//                System.out.println(re.getAbono());
//                System.out.println(re.getImporte());
//                System.out.println(re.getOrden());
//                System.out.println(re.getTexto());
//                new RenglonAbonoBO().saveRenglonAbono(re);
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateAbono(Abono abono) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().updateAbono(abono);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateAbonoCompleto(Abono abono, List<RenglonAbono> renglones, List<RenglonAbono> renglones2) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            if (renglones2 != null && !renglones2.isEmpty()) {
//                for (RenglonAbono ra1 : renglones2) {
//                    new RenglonAbonoBO().deleteRenglonAbono(ra1);
//                }
//            }
//            new AbonoBO().updateAbono(abono);
//            if (renglones != null && !renglones.isEmpty()) {
//                for (RenglonAbono ra2 : renglones) {
//                    ra2.setAbono(abono);
//                    new RenglonAbonoBO().saveRenglonAbono(ra2);
//                }
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new AbonoBO().getCodigoSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }

}
