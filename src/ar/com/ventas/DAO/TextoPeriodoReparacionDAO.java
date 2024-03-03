/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.DAO;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TextoPeriodoReparacion;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class TextoPeriodoReparacionDAO extends GenericDAO {

    public TextoPeriodoReparacion getTextoPeriodoByConsorcioAndRubro(Consorcio co, Rubro ru) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TextoPeriodoReparacion.class);
        criteria.add(Restrictions.eq("consorcio", co));
        criteria.add(Restrictions.eq("rubro", ru));
        TextoPeriodoReparacion textoPeriodoReparacion = (TextoPeriodoReparacion) criteria.uniqueResult();
        return textoPeriodoReparacion;
    }
    
//    public List<Abono> getAllAbonosActivosPendientes() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("pendiente", true));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//
//    public List<Abono> getAbonoByConsorcioAndRubro(Consorcio co, Rubro ru) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("consorcio", co));
//        criteria.add(Restrictions.eq("rubro", ru));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//
//    public List<Abono> getAbonosByRubroAndCuota(Rubro rubro, Integer cuota) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria.add(Restrictions.eq("cuotaFacturada", cuota));
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
//    public List<Abono> getAllAbonosInactivosOrdenadoByRubro(Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAbonosActivosPendientesOrdenadoByRubro(Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
////        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("pendiente", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
////        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAbonosActivosOrdenadosVencidosByRubro(Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        criteria.add(Restrictions.eq("pendiente", true));
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria.add(Restrictions.eqProperty("cuotas", "cuotaFacturada"));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
////        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAbonosActivosNoFacturados() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        criteria.add(Restrictions.neProperty("cuotas", "cuotaFacturada"));
//        criteria.add(Restrictions.eq("pendiente", true));
//        criteria.add(Restrictions.eq("activo", true));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getUltimoAbonoByConsorcioAndRubro(Consorcio co, Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
////        Criteria criteria1 = criteria.createCriteria("consorcio");
////        Criteria criteria3 = criteria1.createCriteria("domicilio");
////        Criteria criteria2 = criteria.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria.add(Restrictions.eq("consorcio", co));
////        criteria.add(Restrictions.eqProperty("cuotas", "cuotaFacturada"));
//        criteria.addOrder(Order.desc("fechaPeriodo"));
////        criteria3.addOrder(Order.asc("numero"));
////        criteria2.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//    
//    public List<Abono> getAbonosActivosFinalizadosByRubro(Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
////        Criteria criteria2 = criteria1.createCriteria("rubro");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
////        criteria.add(Restrictions.eqProperty("cuotas", "cuotaFacturada"));
//        criteria3.addOrder(Order.asc("calle"));
//        criteria3.addOrder(Order.asc("numero"));
////        criteria2.addOrder(Order.asc("detalle"));
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
////        criteria.add(Restrictions.isNotNull("abono"));
////        criteria.addOrder(Order.asc("detalle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//
//    public List<Abono> getAbonosActivosByRubroAndFiltroConsorcio(String filtro, Rubro rubro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria2 = criteria1.createCriteria("domicilio");
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        criteria2.add(Restrictions.like("calle", "%" + filtro + "%"));
//        criteria2.addOrder(Order.asc("calle"));
//        List<Abono> abono = (List<Abono>) criteria.list();
//        return abono;
//    }
//
//    public Abono getAbonoById(Long id) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        criteria.add(Restrictions.eq("id", id));
//        Abono abono = (Abono) criteria.uniqueResult();
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
//    public List<Abono> getAllAbonosInactivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Abono.class);
//        Criteria criteria1 = criteria.createCriteria("consorcio");
//        Criteria criteria3 = criteria1.createCriteria("domicilio");
//        Criteria criteria2 = criteria.createCriteria("rubro");
////        Criteria criteria4 = criteria1.createCriteria("administrador");
//        criteria.add(Restrictions.eq("activo", false));
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
