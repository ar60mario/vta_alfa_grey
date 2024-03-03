/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
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
public class ComprobanteRenglonesDAO extends GenericDAO {

    public List<ComprobanteRenglones> getRenglonesPorComprobante(Comprobante comprobante) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ComprobanteRenglones.class);
        criteria.add(Restrictions.eq("comprobante", comprobante));
        criteria.addOrder(Order.asc("id"));
        return (List<ComprobanteRenglones>) criteria.list();
    }

//    public Integer getImporteSiguiente() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<Comprobante> importes = (List<Comprobante>) criteria.list();
//        Integer codigo;
//        if (importes != null && !importes.isEmpty()) {
//            codigo = 0; //importes.get(0).getCodigo() + 1;
//        } else {
//            codigo = 1;
//        }
//        return codigo;
//    }
    
//    public List<Comprobante> getAllImportesActivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<Comprobante>) criteria.list();
//    }
//    
//    public List<Comprobante> getAllImportesInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<Comprobante>) criteria.list();
//    }
    
//    public List<Comprobante> getComprobantesEntrFechasByTitular(TitularCuit titular, Date de, Date al) {
//        String cuit = titular.getCuit();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.eq("cuitTitular", cuit));
//        criteria.add(Restrictions.between("fecha", de, al));
//        return (List<Comprobante>) criteria.list();
//    }

//    public List<Comprobante> getComprobantesEntreFechasByConsorcio(Consorcio consorcio, Date de, Date al) {
//        String cuit = consorcio.getCuit();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.eq("cuitCliente", cuit));
//        criteria.add(Restrictions.between("fecha", de, al));
//        return (List<Comprobante>) criteria.list();
//    }

//    public List<Comprobante> getComprobantesEntreFechasSinPdf(Date de, Date al) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.add(Restrictions.eq("pdfGenerado", false));
//        criteria.add(Restrictions.between("fecha", de, al));
//        criteria.addOrder(Order.asc("fecha"));
//        return (List<Comprobante>) criteria.list();
//    }

    
    
//    public List<Administrador> getAllAdministradoresInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Administrador.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Administrador>) criteria.list();
//    }
//
//    public Integer getCodigoSiguiente() {
//        Integer codigo = 0;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Administrador.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<Administrador> administradores = (List<Administrador>) criteria.list();
//        if (administradores != null && !administradores.isEmpty()) {
//            Administrador admin = administradores.get(0);
//            codigo = admin.getCodigo();
//        }
//        return codigo;
//    }
}
