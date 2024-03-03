/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class RcCoDAO extends GenericDAO {

//    public List<RcCo> getRecibosEntreFechas(Date de, Date al) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Recibo.class);
//        criteria.add(Restrictions.between("fecha", de, al));
//        criteria.addOrder(Order.asc("id"));
//        return (List<Recibo>) criteria.list();
//    }
    public RcCo getRecibosByReciboAndComprobante(Recibo re, Comprobante co) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RcCo.class);
        criteria.add(Restrictions.eq("recibo", re));
        criteria.add(Restrictions.eq("comprobante", co));
        criteria.addOrder(Order.asc("id"));
        return (RcCo) criteria.uniqueResult();
    }

//    public List<Rubro> getAllRubrosInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Rubro.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<Rubro>) criteria.list();
//    }
//
//    public Integer getCodigoSiguiente() {
//        Integer codigo = 0;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Rubro.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<Rubro> rubros = (List<Rubro>) criteria.list();
//        if (rubros != null && !rubros.isEmpty()) {
//            Rubro admin = rubros.get(0);
//            codigo = admin.getCodigo();
//        }
//        return codigo;
//    }
}
