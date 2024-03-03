package ar.com.ventas.services;

import ar.com.ventas.BO.DomicilioBO;
import ar.com.ventas.BO.TitularCuitBO;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TitularCuitService {

    public TitularCuit saveTitularCuit(TitularCuit titular) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            titular = new TitularCuitBO().saveTitularCuit(titular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return titular;
    }
    
    public TitularCuit updateTitularCuit(TitularCuit titular) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            titular = new TitularCuitBO().updateTitularCuit(titular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return titular;
    }

    public List<TitularCuit> getAllTitularDeCuitActivos() throws Exception {
        List<TitularCuit> titulares = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            titulares = new TitularCuitBO().getAllTitularesDeCuitActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return titulares;
    }
    
    public List<TitularCuit> getAllTitularesDeCuitInactivos() throws Exception {
        List<TitularCuit> titulares = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            titulares = new TitularCuitBO().getAllTitularesDeCuitInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return titulares;
    }
    
    public TitularCuit getTitularDeCuitActivoByPersona(Persona persona) throws Exception {
        TitularCuit tc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            tc = new TitularCuitBO().getTitularDeCuitActivoByPersona(persona);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tc;
    }
    
    public List<TitularCuit> getTitularDeCuitActivoByFiltro(String filtro) throws Exception {
        List<TitularCuit> tc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            tc = new TitularCuitBO().getTitularDeCuitActivoByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tc;
    }
    
    public TitularCuit getTitularActivoByCuit(String cuit) throws Exception {
        TitularCuit tc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            tc = new TitularCuitBO().getTitularActivoByCuit(cuit);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tc;
    }
    
    public TitularCuit getTitularByCuit(String cuit) throws Exception {
        TitularCuit tc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            tc = new TitularCuitBO().getTitularByCuit(cuit);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tc;
    }
}
