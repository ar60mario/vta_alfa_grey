/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.util.HibernateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class TrabajoDAO extends GenericDAO {

    
    
    public List<Trabajo> getAllTrabajosActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (List<Trabajo>) criteria.list();
    }
    
    public List<Trabajo> getAllTrabajosActivosNoFacturados() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("facturaEmitida", false));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByCertificadosPendientes() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("pdfGenerado", false));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByCertificadosEmitido(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        Criteria criteria1 = criteria.createCriteria("servicio");
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("pdfGenerado", true));
        criteria1.add(Restrictions.eq("consorcio", consorcio));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosParaCertificados() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getAllTrabajosInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", false));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByConsorcioActivos(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        Criteria criteria1 = criteria.createCriteria("servicio");
        criteria1.add(Restrictions.eq("activo", true));
        criteria1.add(Restrictions.eq("consorcio", consorcio));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByServicioActivos(Servicio servicio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        //Criteria criteria1 = criteria.createCriteria("servicio");
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("servicio", servicio));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByRubroParaRenovarActivos(Rubro rubro) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        Criteria criteria1 = criteria.createCriteria("servicio");
        criteria.add(Restrictions.eq("activo", true));
        criteria1.add(Restrictions.eq("rubro", rubro));
        criteria.add(Restrictions.eq("renovado", false));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByServicioActivosTerminados(Servicio servicio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("servicio", servicio));
        criteria.add(Restrictions.eq("pdfGenerado", true));
        return (List<Trabajo>) criteria.list();
    }

    public Trabajo getTrabajoByConsorcioAndServicio(Consorcio consorcio, Servicio servicio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        Criteria criteria1 = criteria.createCriteria("servicio");
        criteria1.add(Restrictions.eq("activo", true));
        criteria1.add(Restrictions.eq("consorcio", consorcio));
        criteria.add(Restrictions.eq("cuota", 1));
        criteria.add(Restrictions.eq("servicio", servicio));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (Trabajo) criteria.uniqueResult();
    }

    public List<Trabajo> getTrabajosByConsorcioAndServicio(Consorcio consorcio, Servicio servicio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        Criteria criteria1 = criteria.createCriteria("servicio");
        criteria1.add(Restrictions.eq("activo", true));
        criteria1.add(Restrictions.eq("consorcio", consorcio));
        //criteria.add(Restrictions.eq("cuota", 1));
        criteria.add(Restrictions.eq("servicio", servicio));
        //criteria.addOrder(Order.asc("razonSocial"));
        return (List<Trabajo>) criteria.list();
    }

    public List<Trabajo> getTrabajosByRubroActivos(Rubro rubro) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        Criteria criteria1 = criteria.createCriteria("servicio");
        criteria.add(Restrictions.eq("pdfGenerado", false));
        criteria1.add(Restrictions.eq("activo", true));
        criteria1.add(Restrictions.eq("rubro", rubro));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Trabajo>) criteria.list();
    }
    
    public List<Trabajo> getTrabajosActivosByPeriodo(Date fecha1, Date fecha2) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Trabajo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.between("fecha", fecha1, fecha2));
        return (List<Trabajo>) criteria.list();
    }
}
