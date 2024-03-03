/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Importe;
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
public class ImporteDAO extends GenericDAO {

    public List<Importe> getAllImportes() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Importe.class);
        criteria.addOrder(Order.asc("detalle"));
        return (List<Importe>) criteria.list();
    }

    public List<Importe> getAllImportesActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Importe.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Importe>) criteria.list();
    }

    public Integer getImporteSiguiente() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Importe.class);
        criteria.addOrder(Order.desc("codigo"));
        List<Importe> importes = (List<Importe>) criteria.list();
        Integer codigo;
        if (importes != null && !importes.isEmpty()) {
            codigo = importes.get(0).getCodigo() + 1;
        } else {
            codigo = 1;
        }
        return codigo;
    }

    public List<Importe> getAllImportesInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Importe.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Importe>) criteria.list();
    }
}
