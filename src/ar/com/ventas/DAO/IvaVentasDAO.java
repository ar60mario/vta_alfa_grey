/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Consorcio;
//import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.ComprobanteNumerosIniciales;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.TitularCuit;
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
public class IvaVentasDAO extends GenericDAO {

//    public List<IvaVentas> getAllImportes() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<IvaVentas>) criteria.list();
//    }
//
//    public List<IvaVentas> getAllImportesActivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<IvaVentas>) criteria.list();
//    }
//    
//    public List<IvaVentas> getAllImportesInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<IvaVentas>) criteria.list();
//    }
//    
//    public List<ComprobanteRenglones> getAllRenglonesByFactura(IvaVentas iv) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.add(Restrictions.eq("ivaVentas", iv));
//        criteria.addOrder(Order.asc("id"));
//        return (List<ComprobanteRenglones>) criteria.list();
//    }
//
//    public List<IvaVentas> getFacturasEntreFechas(Date de, Date al) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.add(Restrictions.between("fecha", de, al));
//        criteria.addOrder(Order.asc("fecha"));
//        return (List<IvaVentas>) criteria.list();
//    }
//
//    public List<IvaVentas> getFacturasEntreFechasByTitular(Date de, Date al, String cuitTitular) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.add(Restrictions.between("fecha", de, al));
//        criteria.add(Restrictions.eq("cuitTitular", cuitTitular));
//        criteria.addOrder(Order.asc("fecha"));
//        return (List<IvaVentas>) criteria.list();
//    }
//    
//    public Integer getImporteSiguiente() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<IvaVentas> importes = (List<IvaVentas>) criteria.list();
//        Integer codigo;
//        if (importes != null && !importes.isEmpty()) {
//            codigo = 0; //importes.get(0).getCodigo() + 1;
//        } else {
//            codigo = 1;
//        }
//        return codigo;
//    }
//
//    
//
//    public List<IvaVentas> getFacturasByConsorcioEntreFechas(Consorcio co, Date de, Date al) {
//        String cui = co.getCuit();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(IvaVentas.class);
//        criteria.add(Restrictions.eq("cuit", cui));
//        criteria.add(Restrictions.between("fecha", de, al));
//        criteria.addOrder(Order.asc("fecha"));
//        return (List<IvaVentas>) criteria.list();
//    }
    
}
