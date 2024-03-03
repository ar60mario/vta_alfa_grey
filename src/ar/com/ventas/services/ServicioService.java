package ar.com.ventas.services;

import ar.com.ventas.BO.ServicioBO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServicioService {

    public Servicio saveServicio(Servicio servicio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicio = new ServicioBO().saveServicio(servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicio;
    }
    
    public Servicio updateServicio(Servicio servicio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicio = new ServicioBO().updateServicio(servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicio;
    }

    public List<Servicio> getAllServiciosActivos() throws Exception {
        List<Servicio> servicios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicios = new ServicioBO().getAllServiciosActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosActivosSinTrabajo() throws Exception {
        List<Servicio> servicios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicios = new ServicioBO().getAllServiciosActivosSinTrabajo();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public Servicio getServicioActivoByRubroAndConsorcio(Rubro rubro, Consorcio consorcio) throws Exception {
        Servicio servicio = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicio = new ServicioBO().getServicioActivoByRubroAndConsorcio(rubro, consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicio;
    }
    
    public List<Servicio> getServiciosActivoByRubro(Rubro rubro) throws Exception {
        List<Servicio> servicios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicios = new ServicioBO().getServiciosActivoByRubro(rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosActivosByConsorcio(Consorcio consorcio) throws Exception {
        List<Servicio> servicios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicios = new ServicioBO().getAllServiciosActivosByConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosInactivosByRubroAndConsorcio(Rubro rubro, Consorcio consorcio) throws Exception {
        List<Servicio> servicios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicios = new ServicioBO().getAllServiciosInactivosByRubroAndConsorcio(rubro, consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicios;
    }
    
    public List<Servicio> getAllServiciosInactivos() throws Exception {
        List<Servicio> servicios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            servicios = new ServicioBO().getAllServiciosInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return servicios;
    }
}
