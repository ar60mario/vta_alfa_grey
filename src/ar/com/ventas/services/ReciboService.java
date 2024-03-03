package ar.com.ventas.services;

import ar.com.ventas.entities.Recibo;
import ar.com.ventas.BO.ReciboBO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReciboService {

    public Recibo saveRecibo(Recibo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            recibo = new ReciboBO().saveRecibo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibo;
    }

    public void eliminarReciboCompleto(Recibo re, Consorcio co, RcCo rcCo, 
            CuentaCorrienteCliente cc, Comprobante cmp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ReciboBO().eliminarReciboCompleto(re, co, rcCo, cc, cmp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
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
    public List<Recibo> getRecibosEntreFechas(Date de, Date al) throws Exception {
        List<Recibo> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            recibos = new ReciboBO().getRecibosEntreFechas(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }

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

    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = new ReciboBO().getCodigoSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }
}
