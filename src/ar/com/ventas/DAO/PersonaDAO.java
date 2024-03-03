/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Persona;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class PersonaDAO extends GenericDAO {

    public List<Persona> getAllPersonasActivas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Persona>) criteria.list();
    }

    public List<Persona> getPersonasActivasByFiltro(String filtro) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.like("apellidoNombre", "%" + filtro + "%"));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Persona>) criteria.list();
    }

    public String getPersonaActivaById(Long id) {
        Persona p = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("id", id));
        p = (Persona) criteria.uniqueResult();
        if (p != null) {
            return p.getApellidoNombre();
        } else {
            return null;
        }
    }

    public Persona getPersonaById(Long id) {
        Persona p = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("id", id));
        p = (Persona) criteria.uniqueResult();
        return p;
    }

    public List<Persona> getAllPersonasInactivas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Persona>) criteria.list();
    }

    public Integer getCodigoSiguiente() {
        Integer codigo = 1;
        List<Persona> personas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.addOrder(Order.desc("codigo"));
        personas = (List<Persona>) criteria.list();
        if (personas != null && !personas.isEmpty()) {
            Persona perso = personas.get(0);
            codigo = perso.getCodigo() + 1;
        }
        return codigo;
    }

    public List<Persona> getEmpleadosActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("esEmpleado", true));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Persona>) criteria.list();
    }
    
    public List<Persona> getTitularesActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("esTitularCuit", true));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Persona>) criteria.list();
    }
}
