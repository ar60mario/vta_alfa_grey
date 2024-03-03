/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Hijo;
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
public class HijoDAO extends GenericDAO {

    public List<Hijo> getAllHijosActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Hijo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Hijo>) criteria.list();
    }
    
    public List<Hijo> getAllHijosActivosByPersona(Persona persona) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Hijo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("padre", persona));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Hijo>) criteria.list();
    }
    
    public List<Hijo> getAllHijosInactivosByPersona(Persona persona) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Hijo.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.add(Restrictions.eq("padre", persona));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Hijo>) criteria.list();
    }
    
    public List<Hijo> getAllHijosInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Hijo.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("apellidoNombre"));
        return (List<Hijo>) criteria.list();
    }

}
