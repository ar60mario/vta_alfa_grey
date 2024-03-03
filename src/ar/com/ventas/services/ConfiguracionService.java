package ar.com.ventas.services;

import ar.com.ventas.BO.AdministradorBO;
import ar.com.ventas.BO.ConfiguracionBO;
import ar.com.ventas.BO.DomicilioBO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConfiguracionService {

    public Configuracion saveConfiguracion(Configuracion configuracion) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
//            configuracion = new ConfiguracionBO().saveConfiguracion(configuracion);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return configuracion;
    }
    
    public Configuracion getConfiguracion(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Configuracion configuracion = null;
        try {
            configuracion = new ConfiguracionBO().getConfiguracion(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return configuracion;
    }
    
    public Configuracion updateConfiguracion(Configuracion configuracion) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            configuracion = new ConfiguracionBO().updateConfiguracion(configuracion);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return configuracion;
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
}
