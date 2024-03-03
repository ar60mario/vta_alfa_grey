/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.CategoriaMonotributo;
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
public class CategoriaMonotributoDAO extends GenericDAO {

    public List<CategoriaMonotributo> getAllCategoriasMonotributoActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CategoriaMonotributo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("categoria"));
        return (List<CategoriaMonotributo>) criteria.list();
    }

    public List<CategoriaMonotributo> getAllCategoriasMonotributoInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CategoriaMonotributo.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("categoria"));
        return (List<CategoriaMonotributo>) criteria.list();
    }

    public CategoriaMonotributo getCategoriaByLetraActivo(String letra) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CategoriaMonotributo.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("categoria", letra));
        return (CategoriaMonotributo) criteria.uniqueResult();
    }

//    public List<Cliente> getClientesInactivosByFiltroOrdenado(String f) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.like("razonSocial", "%" + f + "%"));
//        criteria.addOrder(Order.asc("razonSocial"));
//        criteria.add(Restrictions.eq("inactivo", true));
//        return (List<Cliente>) criteria.list();
//    }
//
//    public List<Cliente> getClientesByFiltro(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.razonSocial like :filtro ");
//        sb.append("and clie.activo = true ");
//        sb.append("order by clie.razonSocial asc");
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("filtro", "%" + filtro + "%");
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//    
//    public List<Cliente> getClientesByFiltroNumerico(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.razonSocial like :filtro ");
//        //sb.append("and clie.activo = false ");
//        sb.append("order by clie.codigo asc");
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("filtro", "%" + filtro + "%");
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//
//    public List<Cliente> getAllClientesOrdenadoPorNumero() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.asc("codigo"));
//        return (List<Cliente>) criteria.list();
//    }
//
//    public List<Cliente> getClientesDeudores() {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.saldo > 0.0");
//        Query query = session.createQuery(sb.toString());
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//
//    public List<Cliente> getAllClientesConSaldo() {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.saldo != 0.00");
//        Query query = session.createQuery(sb.toString());
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//
//    public List<Cliente> getByVendedor(Vendedor vendedor) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("vendedor", vendedor));
//        criteria.addOrder(Order.asc("codigo"));
//        List<Cliente> clientes = (List<Cliente>) criteria.list();
//        return clientes;
//    }
}
