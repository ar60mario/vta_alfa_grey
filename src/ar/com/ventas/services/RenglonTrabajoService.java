package ar.com.ventas.services;

import ar.com.ventas.BO.RenglonTrabajoBO;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RenglonTrabajoService {

    public RenglonTrabajo saveRenglonTrabajo(RenglonTrabajo renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglon = new RenglonTrabajoBO().saveRenglonTrabajo(renglon);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglon;
    }
    
    public RenglonTrabajo updateRenglonTrabajo(RenglonTrabajo renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglon = new RenglonTrabajoBO().updateRenglonTrabajo(renglon);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglon;
    }
    
    public void deleteRenglonTrabajo(RenglonTrabajo renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RenglonTrabajoBO().deleteRenglonTrabajo(renglon);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public List<RenglonTrabajo> getAllRenglonTrabajoActivos() throws Exception {
        List<RenglonTrabajo> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getAllRenglonTrabajoActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonTrabajo> getEmpleados() throws Exception {
        List<RenglonTrabajo> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getEmpleados();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonTrabajo> getAllRenglonesByTrabajoActivos(List<Trabajo> trabajos) throws Exception {
        List<RenglonTrabajo> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getAllRenglonesByTrabajoActivos(trabajos);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonTrabajo> getRenglonesByTrabajoActivo(Trabajo trabajo) throws Exception {
        List<RenglonTrabajo> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getRenglonesByTrabajoActivo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public String getCaracteristicasByTrabajo(Trabajo trabajo) throws Exception {
        String caract;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            caract = new RenglonTrabajoBO().getCaracteristicasByTrabajo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            caract = "";
            throw new Exception(ex);
        }
        return caract;
    }
    
    public String getPendientesByTrabajo(Trabajo trabajo) throws Exception {
        String caract;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            caract = new RenglonTrabajoBO().getPendientesByTrabajo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            caract = "";
            throw new Exception(ex);
        }
        return caract;
    }
    
    public RenglonTrabajo getRenglonLaboratorioByTrabajoActivo(Trabajo trabajo) throws Exception {
        RenglonTrabajo renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getRenglonLaboratorioByTrabajoActivo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public RenglonTrabajo getRenglonFechaByTrabajoActivo(Trabajo trabajo) throws Exception {
        RenglonTrabajo renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getRenglonFechaByTrabajoActivo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonTrabajo> getAllRenglonTrabajoInactivos() throws Exception {
        List<RenglonTrabajo> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonTrabajoBO().getAllRenglonTrabajoInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<Persona> getEmpleadosByTrabajo(Trabajo trabajo) throws Exception {
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            personas = new RenglonTrabajoBO().getEmpleadosByTrabajo(trabajo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return personas;
    }
}
