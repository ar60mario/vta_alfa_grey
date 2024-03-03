/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Estructura;
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
public class EstructuraDAO extends GenericDAO {

    public List<Estructura> getAllEstructurasActivas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Estructura.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("nombre"));
        return (List<Estructura>) criteria.list();
    }
    
    public List<Estructura> getAllEstructurasInactivas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Estructura.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("nombre"));
        return (List<Estructura>) criteria.list();
    }
    
//    public List<Estructura> getAllEstructurasActivas() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Estructura.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.addOrder(Order.asc("nombre"));
//        return (List<Estructura>) criteria.list();
//    }
}
