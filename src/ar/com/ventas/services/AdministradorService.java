package ar.com.ventas.services;

import ar.com.ventas.BO.AdministradorBO;
import ar.com.ventas.BO.DomicilioBO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdministradorService {

    public Administrador saveAdministrador(Administrador administrador) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administrador = new AdministradorBO().saveAdministrador(administrador);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administrador;
    }
    
    public Administrador updateAdministrador(Administrador administrador) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administrador = new AdministradorBO().updateAdministrador(administrador);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administrador;
    }

    public List<Administrador> getAllAdministradoresActivos() throws Exception {
        List<Administrador> administradores = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administradores = new AdministradorBO().getAllAdministradoresActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administradores;
    }
    
    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
        List<Administrador> administradores = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administradores = new AdministradorBO().getAllAdministradoresInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administradores;
    }

    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = new AdministradorBO().getCodigoSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) throws Exception {
        List<Administrador> administradores = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administradores = new AdministradorBO().getAllAdministradoresActivosByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administradores;
    }
    
    public Administrador getAdministradorById(Long id) throws Exception {
        Administrador administrador = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administrador = new AdministradorBO().getAdministradorById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administrador;
    }
    
}
