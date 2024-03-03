package ar.com.ventas.services;

import ar.com.ventas.BO.ComprobanteRenglonesBO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComprobanteRenglonesService {

    public ComprobanteRenglones saveRenglon(ComprobanteRenglones renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglon = new ComprobanteRenglonesBO().saveRenglon(renglon);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglon;
    }
    
    public ComprobanteRenglones updateRenglon(ComprobanteRenglones renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglon = new ComprobanteRenglonesBO().updateRenglon(renglon);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglon;
    }
    
    public List<ComprobanteRenglones> getRenglonesPorComprobante(Comprobante comprobante) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteRenglones> renglones = null;
        try {
            renglones = new ComprobanteRenglonesBO().getRenglonesPorComprobante(comprobante);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }

//    public Comprobante saveComprobanteAndCtaCteAndConso(Comprobante comprobante, Consorcio consorcio, CuentaCorrienteCliente ccc, Trabajo trabajo, Servicio servicio) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        ConsorcioBO coBo = new ConsorcioBO();
//        CuentaCorrienteClienteBO cccBo = new CuentaCorrienteClienteBO();
//        TrabajoBO trbBo = new TrabajoBO();
//        ServicioBO srvBo = new ServicioBO();
//        try {
//            coBo.updateConsorcio(consorcio);
//            comprobante = new ComprobanteBO().saveComprobante(comprobante);
//            ccc.setComprobante(comprobante);
//            cccBo.saveCuentaCorrienteCliente(ccc);
//            trbBo.updateTrabajo(trabajo);
//            srvBo.updateServicio(servicio);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobante;
//    }
//    
//    public Comprobante saveComprobanteAndCtaCteAndConso2(Comprobante comprobante, List<ComprobanteRenglones> ivr, Consorcio consorcio, CuentaCorrienteCliente ccc, Integer cuotas, List<RenglonTrabajoReparacion> renglones) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        ConsorcioBO coBo = new ConsorcioBO();
//        CuentaCorrienteClienteBO cccBo = new CuentaCorrienteClienteBO();
//        RenglonTrabajoReparacionBO rtrBo = new RenglonTrabajoReparacionBO();
//        try {
//            coBo.updateConsorcio(consorcio);
//            comprobante = new ComprobanteBO().saveComprobante(comprobante);
//            for(RenglonTrabajoReparacion rtr : renglones){
//                rtr.setComprobante(comprobante);
//                rtrBo.saveRenglonTrabajoReparacion(rtr);
//            }
//            ccc.setComprobante(comprobante);
//            cccBo.saveCuentaCorrienteCliente(ccc);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobante;
//    }
//
//    public List<Comprobante> getComprobantesEntrFechas(Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new ComprobanteBO().getComprobantesEntrFechas(de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//
//    public List<Comprobante> getComprobantesEntreFechasSinPdf(Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new ComprobanteBO().getComprobantesEntreFechasSinPdf(de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//
//    public List<Comprobante> getComprobantesEntrFechasByTitular(TitularCuit titular, Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new ComprobanteBO().getComprobantesEntrFechasByTitular(titular, de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//
//    public List<Comprobante> getComprobantesEntreFechasByConsorcio(Consorcio consorcio, Date de, Date al) throws Exception {
//        List<Comprobante> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new ComprobanteBO().getComprobantesEntreFechasByConsorcio(consorcio, de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//    public Administrador updateAdministrador(Administrador administrador) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administrador = new AdministradorBO().updateAdministrador(administrador);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administrador;
//    }

//    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
//        List<Administrador> administradores = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administradores = new AdministradorBO().getAllAdministradoresInactivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new AdministradorBO().getCodigoSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
}
