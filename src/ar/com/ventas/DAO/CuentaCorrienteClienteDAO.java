/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
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
public class CuentaCorrienteClienteDAO extends GenericDAO {

    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByCliente(Consorcio consorcio) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CuentaCorrienteCliente.class);
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.addOrder(Order.asc("fecha"));
        criteria.addOrder(Order.asc("id"));
        return (List<CuentaCorrienteCliente>) criteria.list();
    }
    
    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByClienteEntreFechas(Consorcio consorcio, Date de, Date al) {
        List<CuentaCorrienteCliente> lcc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CuentaCorrienteCliente.class);
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.asc("fecha"));
        criteria.addOrder(Order.asc("id"));
        lcc = (List<CuentaCorrienteCliente>) criteria.list();
        return lcc;
    }
    
    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByClienteEntreFechas2(Consorcio consorcio, Date de, Date al) {
        List<CuentaCorrienteCliente> lcc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CuentaCorrienteCliente.class);
        criteria.add(Restrictions.eq("consorcio", consorcio));
        criteria.add(Restrictions.between("fecha", de, al));
        criteria.addOrder(Order.desc("id"));
        lcc = (List<CuentaCorrienteCliente>) criteria.list();
        return lcc;
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

}
