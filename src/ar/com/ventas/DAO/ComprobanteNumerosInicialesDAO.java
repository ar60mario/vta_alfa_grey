/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteNumerosIniciales;
import ar.com.ventas.entities.TitularCuit;
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
public class ComprobanteNumerosInicialesDAO extends GenericDAO {

    public List<Comprobante> getAllImportes() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.addOrder(Order.asc("detalle"));
        return (List<Comprobante>) criteria.list();
    }

    public ComprobanteNumerosIniciales getNumeroInicialByTitular(TitularCuit tc) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ComprobanteNumerosIniciales.class);
        criteria.add(Restrictions.eq("titular", tc));
        return (ComprobanteNumerosIniciales) criteria.uniqueResult();
    }

    public List<Comprobante> getAllImportesActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Comprobante>) criteria.list();
    }

    public Integer getImporteSiguiente() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.addOrder(Order.desc("codigo"));
        List<Comprobante> importes = (List<Comprobante>) criteria.list();
        Integer codigo;
        if (importes != null && !importes.isEmpty()) {
            codigo = 0; //importes.get(0).getCodigo() + 1;
        } else {
            codigo = 1;
        }
        return codigo;
    }

    public List<Comprobante> getAllImportesInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Comprobante>) criteria.list();
    }
}
