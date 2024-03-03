/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
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
public class ServicioDAO extends GenericDAO {

    public List<Servicio> getAllServiciosActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("consorcio"));
        return (List<Servicio>) criteria.list();
    }
    
    public List<Servicio> getAllServiciosActivosSinTrabajo() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("trabajoCreado", false));
        criteria.addOrder(Order.asc("consorcio"));
        return (List<Servicio>) criteria.list();
    }
    
    public List<Servicio> getAllServiciosInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("consorcio"));
        return (List<Servicio>) criteria.list();
    }

    public Servicio getServicioActivoByRubroAndConsorcio(Rubro rubro, Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.add(Restrictions.eq("rubro", rubro));
        return (Servicio) criteria.uniqueResult();
    }
    
    public List<Servicio> getServiciosActivoByRubro(Rubro rubro) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", true));
        //criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.add(Restrictions.eq("rubro", rubro));
        return (List<Servicio>) criteria.list();
    }
    
    public List<Servicio> getAllServiciosActivosByConsorcio(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.addOrder(Order.asc("consorcio"));
        return (List<Servicio>) criteria.list();
    }
    
    public List<Servicio> getAllServiciosInactivosByRubroAndConsorcio(Rubro rubro, Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.add(Restrictions.eq("rubro", rubro));
        criteria.addOrder(Order.asc("consorcio"));
        return (List<Servicio>) criteria.list();
    }
}
