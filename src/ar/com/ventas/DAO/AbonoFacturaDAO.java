/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.AbonoFactura;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class AbonoFacturaDAO extends GenericDAO {

//    public List<AbonoFactura> getAllAbonosActivosOrdenado() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(AbonoFactura.class);
//        Criteria criteria1 = criteria.createCriteria("cliente");
//        Criteria criteria3 = criteria1.createCriteria("direccion");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubro(Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroPendientesFacturar(Rubro rubro, Administrador admin) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("pendiente", true));
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria1.add(Restrictions.eq("administrador", admin));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroPendientesFacturar2(Rubro rubro, Administrador admin) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("pendiente", true));
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria1.add(Restrictions.eq("administrador", admin));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAllAbonosActivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.isNotNull("abono"));
//        criteria.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//
//    public Integer getCodigoSiguiente() {
//        Integer codigo = 0;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<Abono> abonos = (List<Abono>) criteria.list();
//        if (abonos != null && !abonos.isEmpty()) {
//            Abono a = abonos.get(0);
//            codigo = a.getCodigo();
//        }
//        return codigo;
//    }
//
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
////        Criteria criteria4 = criteria1.createCriteria("administrador");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria1.add(Restrictions.eq("administrador", admin));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAbonosActivosVencidosByFecha() {
//        List<Abono> abonos = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Abono abono ");
//        sb.append("where abono.activo = true and abono.cuotas = abono.cuotaFacturada");
//        Query query = session.createQuery(sb.toString());
//        abonos = (List<Abono>) query.list();
//        return abonos;
//
//    }
}
