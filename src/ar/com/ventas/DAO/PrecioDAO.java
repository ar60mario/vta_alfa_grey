/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Precio;
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
public class PrecioDAO extends GenericDAO {

    public List<Precio> getAllPrecios() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Precio.class);
        criteria.addOrder(Order.asc("descripcion"));
        return (List<Precio>) criteria.list();
    }

    public List<Precio> getAllPreciosActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Precio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("descripcion"));
        return (List<Precio>) criteria.list();
    }
    
    public List<Precio> getAllPreciosInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Precio.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("descripcion"));
        return (List<Precio>) criteria.list();
    }
}
