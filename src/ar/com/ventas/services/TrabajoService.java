package ar.com.ventas.services;

import ar.com.ventas.BO.TrabajoBO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TrabajoService {

    public Trabajo saveTrabajo(Trabajo trabajo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajo = new TrabajoBO().saveTrabajo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajo;
    }
    
    public void saveTrabajoCompleto(Trabajo trabajo, List<RenglonTrabajo> renglones) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new TrabajoBO().saveTrabajoCompleto(trabajo, renglones);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public void updateTrabajoCompleto(Trabajo trabajo, List<RenglonTrabajo> renglones) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new TrabajoBO().updateTrabajoCompleto(trabajo, renglones);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public void deleteTrabajo(Trabajo trabajo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new TrabajoBO().deleteTrabajo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public Trabajo updateTrabajo(Trabajo trabajo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajo = new TrabajoBO().updateTrabajo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajo;
    }

    public List<Trabajo> getAllTrabajosActivos() throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getAllTrabajosActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getAllTrabajosActivosNoFacturados() throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getAllTrabajosActivosNoFacturados();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByCertificadosPendientes() throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByCertificadosPendientes();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByCertificadosEmitido(Consorcio consorcio) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByCertificadosEmitido(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByRubroActivos(Rubro rubro) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByRubroActivos(rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public Trabajo getTrabajoByConsorcioAndServicio(Consorcio consorcio, Servicio servicio) throws Exception {
        Trabajo trabajo = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajo = new TrabajoBO().getTrabajoByConsorcioAndServicio(consorcio, servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajo;
    }
   
    public List<Trabajo> getTrabajosByConsorcioAndServicio(Consorcio consorcio, Servicio servicio) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByConsorcioAndServicio(consorcio, servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByConsorcioActivos(Consorcio consorcio) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByConsorcioActivos(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByServicioActivos(Servicio servicio) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByServicioActivos(servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByRubroParaRenovarActivos(Rubro rubro, Date fecha) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByRubroParaRenovarActivos(rubro, fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosByServicioActivosTerminados(Servicio servicio) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosByServicioActivosTerminados(servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getAllTrabajosInactivos() throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getAllTrabajosInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
    
    public List<Trabajo> getTrabajosActivosByPeriodo(Date fecha1, Date fecha2) throws Exception {
        List<Trabajo> trabajos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            trabajos = new TrabajoBO().getTrabajosActivosByPeriodo(fecha1, fecha2);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return trabajos;
    }
}
