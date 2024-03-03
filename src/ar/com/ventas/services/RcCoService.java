package ar.com.ventas.services;

import ar.com.ventas.entities.RcCo;
import ar.com.ventas.BO.RcCoBO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RcCoService {

    public RcCo saveRecibo(RcCo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            recibo = new RcCoBO().saveRcCo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public void deleteRecibo(RcCo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RcCoBO().deleteRcCo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public RcCo getRecibosByReciboAndComprobante(Recibo re, Comprobante co) throws Exception {
        RcCo rc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            rc = new RcCoBO().getRecibosByReciboAndComprobante(re, co);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return rc;
    }
    
//    public Rubro updateRubro(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            rubro = new RubroBO().updateRubro(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return rubro;
//    }

//    public List<Recibo> getRecibosEntreFechas(Date de, Date al) throws Exception {
//        List<Recibo> recibos = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            recibos = new ReciboBO().getRecibosEntreFechas(de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return recibos;
//    }
    
//    public List<Rubro> getAllRubrosInactivos() throws Exception {
//        List<Rubro> rubros = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            rubros = new RubroBO().getAllRubrosInactivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return rubros;
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new RubroBO().getCodigoSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
}
