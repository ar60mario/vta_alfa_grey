/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.ConsorcioMaster;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ConsorcioMasterDAO extends GenericDAO {

    public List<ConsorcioMaster> getAllConsorciosMasterActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ConsorcioMaster.class);
        criteria.add(Restrictions.eq("activo", true));
        return (List<ConsorcioMaster>) criteria.list();
    }

    public ConsorcioMaster getConsorcioActivoMaster(Consorcio co, Rubro ru, Consorcio coNuevo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Integer codigo = co.getCodigo();
        Criteria criteria = session.createCriteria(ConsorcioMaster.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("rubro", ru));
        criteria.add(Restrictions.eq("consorcio", coNuevo));
        criteria.add(Restrictions.eq("master", codigo));
        return (ConsorcioMaster) criteria.uniqueResult();
    }
    
    public ConsorcioMaster getConsorcioMasterParaElim(Consorcio co, Rubro ru) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Integer codigo = co.getCodigo();
        Criteria criteria = session.createCriteria(ConsorcioMaster.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("rubro", ru));
        criteria.add(Restrictions.eq("master", codigo));
        return (ConsorcioMaster) criteria.uniqueResult();
    }
    
    public List<ConsorcioMaster> getConsorciosByRubro(Rubro ru, int ord) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ConsorcioMaster.class);
        criteria.add(Restrictions.eq("rubro", ru));
        if(ord == 1){
            criteria.addOrder(Order.asc("master"));
        } else {
            criteria.addOrder(Order.asc("consorcio"));
        }
        return (List<ConsorcioMaster>) criteria.list();
    }
    
//    public void deleteConsorcioActivoMaster(Consorcio co, Rubro ru) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Integer codigo = co.getCodigo();
//        Criteria criteria = session.createCriteria(ConsorcioMaster.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", ru));
//        criteria.add(Restrictions.eq("consorcio", coNuevo));
//        criteria.add(Restrictions.eq("master", codigo));
//        return (ConsorcioMaster) criteria.uniqueResult();
//    }
    
    public ConsorcioMaster getConsorcioMasterByRubroAndConsorcio(Rubro ru, Consorcio coNuevo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ConsorcioMaster.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("rubro", ru));
        criteria.add(Restrictions.eq("consorcio", coNuevo));
        return (ConsorcioMaster) criteria.uniqueResult();
    }

//    public List<Consorcio> getAllConsorciosActivosByAdministrador(Administrador administrador) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("administrador", administrador));
//        Criteria criteria1 = criteria.createCriteria("domicilio");
//        criteria1.addOrder(Order.asc("calle"));
//        criteria1.addOrder(Order.asc("numero"));
////        criteria1.addOrder(Order.asc("calle"));
//        return (List<Consorcio>) criteria.list();
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByAdministrador(Administrador administrador) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.add(Restrictions.eq("administrador", administrador));
//        Criteria criteria1 = criteria.createCriteria("domicilio");
//        criteria1.addOrder(Order.asc("calle"));
//        return (List<Consorcio>) criteria.list();
//    }
//
//    public Consorcio getConsorcioById(Long idC) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("id", idC));
//        return (Consorcio) criteria.uniqueResult();
//    }
//    
//    public Consorcio getConsorcioByCodigo(Integer codigo) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("codigo", codigo));
//        return (Consorcio) criteria.uniqueResult();
//    }
//
//    public List<Consorcio> getAllConsorciosActivosByFiltro(String filtro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", true));
//        Criteria criteria1 = criteria.createCriteria("domicilio");
//        criteria1.add(Restrictions.like("calle", "%" + filtro + "%"));
//        return (List<Consorcio>) criteria.list();
//    }
//
//    public List<Consorcio> getAllConsorciosActivosByNumero(String numero) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", true));
//        Criteria criteria1 = criteria.createCriteria("domicilio");
//        criteria1.add(Restrictions.like("numero", "%" + numero + "%"));
//        return (List<Consorcio>) criteria.list();
//    }
//
//    public List<Consorcio> getAllConsorciosInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", false));
//        //criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Consorcio>) criteria.list();
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByFiltro(String filtro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", false));
//        Criteria criteria1 = criteria.createCriteria("domicilio");
//        criteria1.add(Restrictions.like("calle", "%" + filtro + "%"));
//        return (List<Consorcio>) criteria.list();
//    }
//    
//    public List<Consorcio> getAllConsorciosInactivosByNumero(String numero) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.add(Restrictions.eq("activo", false));
//        Criteria criteria1 = criteria.createCriteria("domicilio");
//        criteria1.add(Restrictions.like("numero", "%" + numero + "%"));
//        //criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Consorcio>) criteria.list();
//    }
//
//    public Integer getCodigoSiguiente() {
//        Integer codigo = 0;
//        List<Consorcio> consorcios = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Consorcio.class);
//        criteria.addOrder(Order.desc("codigo"));
//        consorcios = (List<Consorcio>) criteria.list();
//        if (consorcios != null && !consorcios.isEmpty()) {
//            Consorcio cons = consorcios.get(0);
//            codigo = cons.getCodigo();
//        }
//        return codigo;
//    }
//    public List<Cliente> getAllClientesActivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("activo", true));
//        return (List<Cliente>) criteria.list();
//    }
//
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
