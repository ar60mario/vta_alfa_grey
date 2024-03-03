package ar.com.ventas.services;

import ar.com.ventas.BO.DomicilioBO;
import ar.com.ventas.BO.PersonaBO;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaService {

    public Persona savePersona(Persona persona) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            persona = new PersonaBO().savePersona(persona);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return persona;
    }
    
    public String getPersonaActivaById(Long id) throws Exception {
        String persona = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            persona = new PersonaBO().getPersonaActivaById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return persona;
    }
    
    public Persona updatePersona(Persona persona) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            persona = new PersonaBO().updatePersona(persona);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return persona;
    }

    public List<Persona> getTitularesActivos() throws Exception {
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            personas = new PersonaBO().getTitularesActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getAllPersonasActivas() throws Exception {
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            personas = new PersonaBO().getAllPersonasActivas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getEmpleadosActivos() throws Exception {
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            personas = new PersonaBO().getEmpleadosActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getPersonasActivasByFiltro(String filtro) throws Exception {
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            personas = new PersonaBO().getPersonasActivasByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return personas;
    }
    
    public List<Persona> getAllPersonasInactivas() throws Exception {
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            personas = new PersonaBO().getAllPersonasInactivas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return personas;
    }

    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = new PersonaBO().getCodigoSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }

}
