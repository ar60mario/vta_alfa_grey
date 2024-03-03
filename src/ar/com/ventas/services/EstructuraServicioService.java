package ar.com.ventas.services;

import ar.com.ventas.BO.EstructuraServicioBO;
import ar.com.ventas.entities.Estructura;
import ar.com.ventas.entities.EstructuraServicio;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstructuraServicioService {

    public EstructuraServicio saveEstructuraServicio(EstructuraServicio estructura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructura = new EstructuraServicioBO().saveEstructuraServicio(estructura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructura;
    }
    
    public void deleteEstructuraServicio(EstructuraServicio estructura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new EstructuraServicioBO().deleteEstructuraServicio(estructura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public EstructuraServicio updateEstructuraServicio(EstructuraServicio estructura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructura = new EstructuraServicioBO().updateEstructuraServicio(estructura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructura;
    }

    public List<EstructuraServicio> getAllEstructuraServicioActivos() throws Exception {
        List<EstructuraServicio> estructuras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructuras = new EstructuraServicioBO().getAllEstructuraServicioActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructuras;
    }
    
    public EstructuraServicio getEstructuraServicioActivoById(Long id) throws Exception {
        EstructuraServicio estructura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructura = new EstructuraServicioBO().getEstructuraServicioActivoById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructura;
    }
    
    public List<EstructuraServicio> getAllEstructuraServicioByEstructuraActivos(Estructura estructura) throws Exception {
        List<EstructuraServicio> estructuras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructuras = new EstructuraServicioBO().getAllEstructuraServicioByEstructuraActivos(estructura);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructuras;
    }
    
    public List<EstructuraServicio> getAllEstructuraServicioInactivos() throws Exception {
        List<EstructuraServicio> estructuras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            estructuras = new EstructuraServicioBO().getAllEstructuraServicioInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return estructuras;
    }
}
