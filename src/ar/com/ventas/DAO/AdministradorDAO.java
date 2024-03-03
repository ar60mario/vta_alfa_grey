/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Administrador;
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
public class AdministradorDAO extends GenericDAO {

    public List<Administrador> getAllAdministradoresActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Administrador>) criteria.list();
    }
    
    public List<Administrador> getAllAdministradoresInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Administrador>) criteria.list();
    }

    public Integer getCodigoSiguiente() {
        Integer codigo = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.addOrder(Order.desc("codigo"));
        List<Administrador> administradores = (List<Administrador>) criteria.list();
        if (administradores != null && !administradores.isEmpty()) {
            Administrador admin = administradores.get(0);
            codigo = admin.getCodigo();
        }
        return codigo;
    }

    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.like("razonSocial", "%" + filtro + "%"));
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Administrador>) criteria.list();
    }
    
    public Administrador getAdministradorById(Long id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("id", id));
        return (Administrador) criteria.uniqueResult();
    }
}
