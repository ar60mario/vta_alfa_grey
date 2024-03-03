/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.BO.TitularCuitBO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.AdministradorTitularCuitComprobante;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class AdministradorTitularCuitComprobanteDAO extends GenericDAO {

    public List<AdministradorTitularCuitComprobante> getExistenFacturas(Comprobante comprobante, String cuitTitular, Administrador admin) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(AdministradorTitularCuitComprobante.class);
        TitularCuit tc = null;
        try {
            tc = new TitularCuitBO().getTitularActivoByCuit(cuitTitular);
        } catch (Exception ex) {
            Logger.getLogger(AdministradorTitularCuitComprobanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        criteria.add(Restrictions.eq("administrador", admin));
        criteria.add(Restrictions.eq("titular", tc));
        criteria.add(Restrictions.eq("comprobante", comprobante));
        return (List<AdministradorTitularCuitComprobante>) criteria.list();
    }
    
    public List<AdministradorTitularCuitComprobante> getAllPorAdministrador() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(AdministradorTitularCuitComprobante.class);
        criteria.addOrder(Order.asc("administrador"));
        return (List<AdministradorTitularCuitComprobante>) criteria.list();
    }
    
    
    
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
//
//    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Administrador.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.like("razonSocial", "%" + filtro + "%"));
//        criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Administrador>) criteria.list();
//    }
//    
//    public Administrador getAdministradorById(Long id) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Administrador.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("id", id));
//        return (Administrador) criteria.uniqueResult();
//    }
}
