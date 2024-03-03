/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.util.HibernateUtils;
import java.util.ArrayList;
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
public class RenglonTrabajoReparacionDAO extends GenericDAO {

    public List<RenglonTrabajo> getAllRenglonTrabajoActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("id"));
        return (List<RenglonTrabajo>) criteria.list();
    }

    public List<RenglonTrabajo> getAllRenglonTrabajoInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("id"));
        return (List<RenglonTrabajo>) criteria.list();
    }

    public List<RenglonTrabajo> getAllRenglonesByTrabajoActivo(Trabajo trabajo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("orden"));
        return (List<RenglonTrabajo>) criteria.list();
    }

    public String getCaracteristicasByTrabajo(Trabajo trabajo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("codigoCampo", 13));
        RenglonTrabajo rt = (RenglonTrabajo) criteria.uniqueResult();
        return rt.getContenido();
    }
    
    public String getPendientesByTrabajo(Trabajo trabajo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("codigoCampo", 7));
        RenglonTrabajo rt = (RenglonTrabajo) criteria.uniqueResult();
        return rt.getContenido();
    }
    
    public RenglonTrabajo getRenglonLaboratorioByTrabajoActivo(Trabajo trabajo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("codigoCampo", 10));
        criteria.add(Restrictions.eq("activo", true));
        return (RenglonTrabajo) criteria.uniqueResult();
    }
    
    public RenglonTrabajo getRenglonFechaByTrabajoActivo(Trabajo trabajo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("codigoCampo", 4));
        criteria.add(Restrictions.eq("activo", true));
        return (RenglonTrabajo) criteria.uniqueResult();
    }

    public RenglonTrabajo getLaboratorioRecibidoByTrabajoActivo(Trabajo trabajo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("codigoCampo", 11));
        criteria.add(Restrictions.eq("contenido", "SI"));
        criteria.add(Restrictions.eq("activo", true));
        return (RenglonTrabajo) criteria.uniqueResult();
    }

    public List<RenglonTrabajo> getRenglonesByTrabajo(Trabajo trabajo) {
        List<RenglonTrabajo> renglones;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("codigoCampo", 6));
        criteria.add(Restrictions.eq("trabajo", trabajo));
        renglones = (List<RenglonTrabajo>) criteria.list();
        return renglones;
    }
    
    public List<RenglonTrabajo> getEmpleados() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonTrabajo.class);
//        criteria.add(Restrictions.eq("trabajo", trabajo));
        criteria.add(Restrictions.eq("codigoCampo", 6));
        return (List<RenglonTrabajo>) criteria.list();
    }
}
