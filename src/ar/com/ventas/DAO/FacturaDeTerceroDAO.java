/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.FacturaDeTercero;
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
public class FacturaDeTerceroDAO extends GenericDAO {

    public List<FacturaDeTercero> getAllFacturasDeTerceroEntregadas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaDeTercero.class);
        criteria.add(Restrictions.eq("entregada", true));
        criteria.addOrder(Order.asc("proveedor"));
        return (List<FacturaDeTercero>) criteria.list();
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoEntregadas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaDeTercero.class);
        criteria.add(Restrictions.eq("entregada", false));
        criteria.addOrder(Order.asc("proveedor"));
        return (List<FacturaDeTercero>) criteria.list();
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoEntregadasByConsorcio(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaDeTercero.class);
        criteria.add(Restrictions.eq("entregada", false));
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.addOrder(Order.asc("proveedor"));
        return (List<FacturaDeTercero>) criteria.list();
    }
    
    public List<FacturaDeTercero> getAllFacturasDeTerceroNoCobradasByConsorcio(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaDeTercero.class);
        criteria.add(Restrictions.eq("cobrada", false));
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.addOrder(Order.asc("proveedor"));
        return (List<FacturaDeTercero>) criteria.list();
    }
}
