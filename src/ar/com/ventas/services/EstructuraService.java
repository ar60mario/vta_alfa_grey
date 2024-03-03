package ar.com.ventas.services;

import ar.com.ventas.BO.EstructuraBO;
import ar.com.ventas.entities.Estructura;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstructuraService {

    public Estructura saveEstructura(Estructura estructura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructura = new EstructuraBO().saveEstructura(estructura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructura;
    }
    
    public Estructura updateEstructura(Estructura estructura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructura = new EstructuraBO().updateEstructura(estructura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructura;
    }

    public List<Estructura> getAllEstructurasActivas() throws Exception {
        List<Estructura> estructuras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructuras = new EstructuraBO().getAllEstructurasActivas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructuras;
    }
    
    public List<Estructura> getAllEstructurasInactivas() throws Exception {
        List<Estructura> estructuras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructuras = new EstructuraBO().getAllEstructurasInactivas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructuras;
    }
}
