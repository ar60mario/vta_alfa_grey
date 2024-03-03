/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Estructura;
import ar.com.ventas.entities.EstructuraServicio;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class EstructuraServicioDAO extends GenericDAO {

    public List<EstructuraServicio> getAllEstructuraServicioActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(EstructuraServicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("estructura"));
        return (List<EstructuraServicio>) criteria.list();
    }
    
    public EstructuraServicio getEstructuraServicioActivoById(Long id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(EstructuraServicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("id", id));
        return (EstructuraServicio) criteria.uniqueResult();
    }
    
    public List<EstructuraServicio> getAllEstructuraServicioByEstructuraActivos(Estructura estructura) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(EstructuraServicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("estructura", estructura));
        criteria.addOrder(Order.asc("orden"));
        return (List<EstructuraServicio>) criteria.list();
    }
    
    public List<EstructuraServicio> getAllEstructuraServicioInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(EstructuraServicio.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("estructura"));
        return (List<EstructuraServicio>) criteria.list();
    }
}
