package ar.com.ventas.services;

import ar.com.ventas.BO.HijoBO;
import ar.com.ventas.entities.Hijo;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HijoService {

    public Hijo saveHijo(Hijo hijo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            hijo = new HijoBO().saveHijo(hijo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hijo;
    }
    
    public Hijo updateHijo(Hijo hijo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            hijo = new HijoBO().updateHijo(hijo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hijo;
    }

    public List<Hijo> getAllHijosActivos() throws Exception {
        List<Hijo> hijos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            hijos = new HijoBO().getAllHijosActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hijos;
    }
    
    public List<Hijo> getAllHijosActivosByPersona(Persona persona) throws Exception {
        List<Hijo> hijos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            hijos = new HijoBO().getAllHijosActivosByPersona(persona);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hijos;
    }
    
    public List<Hijo> getAllHijosInactivosByPersona(Persona persona) throws Exception {
        List<Hijo> hijos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            hijos = new HijoBO().getAllHijosInactivosByPersona(persona);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hijos;
    }
    
    public List<Hijo> getAllHijosInactivos() throws Exception {
        List<Hijo> hijos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            hijos = new HijoBO().getAllHijosInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hijos;
    }

}
