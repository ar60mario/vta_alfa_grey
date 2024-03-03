/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.BO.TextoPeriodoReparacionBO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TextoPeriodoReparacion;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class TextoPeriodoReparacionService {

    public TextoPeriodoReparacion getTextoPeriodoByConsorcioAndRubro(Consorcio co, Rubro ru) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        TextoPeriodoReparacion tpr = null;
        try {
            tpr = new TextoPeriodoReparacionBO().getTextoPeriodoByConsorcioAndRubro(co, ru);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tpr;
    }

//    public List<Abono> getAbonosByRubroAndCuota(Rubro rubro, Integer cuota) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosByRubroAndCuota(rubro, cuota);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAbonosActivosVencidosByFecha(Date fechaConsulta) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosVencidosByFecha(fechaConsulta);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubro(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenadoByRubro(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosInactivosOrdenadoByRubro(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosInactivosOrdenadoByRubro(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAbonosActivosPendientesOrdenadoByRubro(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosPendientesOrdenadoByRubro(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAbonosActivosPendientesOrdenadoByRubro4(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosPendientesOrdenadoByRubro4(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAbonosActivosOrdenadosVencidosByRubro(Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosOrdenadosVencidosByRubro(rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAbonosActivosNoFacturados() throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosNoFacturados();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public Abono getUltimoAbonoByConsorcioAndRubro(Consorcio co, Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        Abono abono = null;
//        try {
//            abono = new AbonoBO().getUltimoAbonoByConsorcioAndRubro(co, rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abono;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenadoByRubroAndAdministrador(rubro, admin);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosInactivosOrdenadoByRubroAndAdministrador(Rubro rubro, Administrador admin) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosInactivosOrdenadoByRubroAndAdministrador(rubro, admin);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivosOrdenadoByRubroPendientesFacturar(Rubro rubro, Administrador admin) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivosOrdenadoByRubroPendientesFacturar(rubro, admin);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public List<Abono> getAllAbonosActivos() throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAllAbonosActivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//
//    public List<Abono> getAbonosActivosByRubroAndFiltroConsorcio(String filtro, Rubro rubro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Abono> abonos = null;
//        try {
//            abonos = new AbonoBO().getAbonosActivosByRubroAndFiltroConsorcio(filtro, rubro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abonos;
//    }
//    
//    public Abono getAbonoById(Long id) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        Abono abono = null;
//        try {
//            abono = new AbonoBO().getAbonoById(id);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return abono;
//    }
//    
//    public void saveAbono(Abono abono) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().saveAbono(abono);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void saveAbonoCompleto(Abono abono, List<RenglonAbono> renglones) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().saveAbono(abono);
//            for (RenglonAbono re : renglones) {
//                re.setAbono(abono);
//                System.out.println(re.getAbono());
//                System.out.println(re.getImporte());
//                System.out.println(re.getOrden());
//                System.out.println(re.getTexto());
//                new RenglonAbonoBO().saveRenglonAbono(re);
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateAbono(Abono abono) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().updateAbono(abono);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateListaAbonosHabilitados(List<Abono> abonos) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new AbonoBO().updateListaAbonosHabilitados(abonos);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//    
//    public void updateAbonoCompleto(Abono abono, List<RenglonAbono> renglones, List<RenglonAbono> renglones2) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            if (renglones2 != null && !renglones2.isEmpty()) {
//                for (RenglonAbono ra1 : renglones2) {
//                    new RenglonAbonoBO().deleteRenglonAbono(ra1);
//                }
//            }
//            new AbonoBO().updateAbono(abono);
//            if (renglones != null && !renglones.isEmpty()) {
//                for (RenglonAbono ra2 : renglones) {
//                    ra2.setAbono(abono);
//                    new RenglonAbonoBO().saveRenglonAbono(ra2);
//                }
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new AbonoBO().getCodigoSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }

}
