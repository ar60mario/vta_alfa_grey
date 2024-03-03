package ar.com.ventas.services;

import ar.com.ventas.BO.ComprobanteBO;
import ar.com.ventas.BO.ConsorcioBO;
import ar.com.ventas.BO.CuentaCorrienteClienteBO;
import ar.com.ventas.BO.RenglonTrabajoReparacionBO;
import ar.com.ventas.BO.ServicioBO;
import ar.com.ventas.BO.TrabajoBO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.RenglonTrabajoReparacion;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComprobanteService {

    public Comprobante saveComprobante(Comprobante comprobante) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobante = new ComprobanteBO().saveComprobante(comprobante);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public Comprobante updateComprobante(Comprobante comprobante) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobante = new ComprobanteBO().updateComprobante(comprobante);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public void updateListaComprobantes(List<Comprobante> comprobantes) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ComprobanteBO().updateListaComprobantes(comprobantes);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public Comprobante saveComprobanteAndCtaCteAndConso(Comprobante comprobante, 
            Consorcio consorcio, CuentaCorrienteCliente ccc, Trabajo trabajo, 
            Servicio servicio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ConsorcioBO coBo = new ConsorcioBO();
        CuentaCorrienteClienteBO cccBo = new CuentaCorrienteClienteBO();
        TrabajoBO trbBo = new TrabajoBO();
        ServicioBO srvBo = new ServicioBO();
        try {
            coBo.updateConsorcio(consorcio);
            comprobante = new ComprobanteBO().saveComprobante(comprobante);
            ccc.setComprobante(comprobante);
            cccBo.saveCuentaCorrienteCliente(ccc);
            trbBo.updateTrabajo(trabajo);
            srvBo.updateServicio(servicio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public Comprobante saveComprobanteAndCtaCteAndConso2(Comprobante comprobante, 
            List<ComprobanteRenglones> ivr, Consorcio consorcio, CuentaCorrienteCliente ccc, 
            Integer cuotas, List<RenglonTrabajoReparacion> renglones) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ConsorcioBO coBo = new ConsorcioBO();
        CuentaCorrienteClienteBO cccBo = new CuentaCorrienteClienteBO();
        RenglonTrabajoReparacionBO rtrBo = new RenglonTrabajoReparacionBO();
        try {
            coBo.updateConsorcio(consorcio);
            comprobante = new ComprobanteBO().saveComprobante(comprobante);
            for(RenglonTrabajoReparacion rtr : renglones){
                rtr.setComprobante(comprobante);
                rtrBo.saveRenglonTrabajoReparacion(rtr);
            }
            ccc.setComprobante(comprobante);
            cccBo.saveCuentaCorrienteCliente(ccc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public Comprobante saveComprobanteAndCtaCteAndConso3(Comprobante comprobante, 
            List<ComprobanteRenglones> ivr, Consorcio consorcio, CuentaCorrienteCliente ccc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ConsorcioBO coBo = new ConsorcioBO();
        CuentaCorrienteClienteBO cccBo = new CuentaCorrienteClienteBO();
        try {
            coBo.updateConsorcio(consorcio);
            comprobante = new ComprobanteBO().saveComprobante(comprobante);
            for(ComprobanteRenglones rtr : ivr){
                rtr.setComprobante(comprobante);
            }
            ccc.setComprobante(comprobante);
            cccBo.saveCuentaCorrienteCliente(ccc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }

    public List<Comprobante> getComprobantesEntrFechas(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechas(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobanteByNroAndTitular(Integer numero, String cuitTitular, Long idAdmin) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobanteByNroAndTitular(numero, cuitTitular, idAdmin);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesEntrFechasAndRubro(Date de, Date al, Rubro ru) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechasAndRubro(de, al, ru);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesEntreFechasAndRubroParaAsignar(Date de, Date al, Rubro ru) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntreFechasAndRubroParaAsignar(de, al, ru);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesActivos() throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesActivosReparacion() throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesActivosReparacion();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesActivosReparacion(Consorcio consorcio, Rubro rubro, Date deFecha) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesActivosReparacion(consorcio, rubro, deFecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesActivosReparacionParaRenovar() throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesActivosReparacionParaRenovar();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesActivosReparacionCuotaSiguiente() throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesActivosReparacionCuotaSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesActivosReparacionParaRenovar2() throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesActivosReparacionParaRenovar2();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(Date de, Date al
            , Double imp, Integer cuo, Rubro ru) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(de, al
                    , imp, cuo, ru);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesEntrFechasOrdenConso(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechasOrdenConso(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasOrdenConsoParaAsignar(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechasOrdenConsoParaAsignar(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesEntrFechasOrdenTitular(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechasOrdenTitular(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesEntrFechasOrdenNumero(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechasOrdenNumero(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesImpagos() throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesImpagos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesImpagosByConsorcio(Consorcio consorcio) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesImpagosByConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
//    public List<Comprobante> getComprobantesImpagosByAdministrador(Administrador adm) throws Exception {
//        List<Comprobante> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
////            comprobantes = new ComprobanteBO().getComprobantesImpagosByAdministrador(adm);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
    
    public List<Comprobante> getComprobantesEntreFechasSinPdf(Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntreFechasSinPdf(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesEntrFechasByTitular(TitularCuit titular, Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntrFechasByTitular(titular, de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }

    public List<Comprobante> getComprobantesOriginalEntrFechasByTitular(TitularCuit titular, Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesOriginalEntrFechasByTitular(titular, de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getComprobantesEntreFechasByConsorcio(Consorcio consorcio, Date de, Date al) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getComprobantesEntreFechasByConsorcio(consorcio, de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public Comprobante getUltimoComprobanteByConsorcio(Consorcio consorcio) throws Exception {
        Comprobante comprobante = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobante = new ComprobanteBO().getUltimoComprobanteByConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public Comprobante getUltimoComprobanteByConsorcioAndRubro(Consorcio consorcio, Rubro rubro) throws Exception {
        Comprobante comprobante = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobante = new ComprobanteBO().getUltimoComprobanteByConsorcioAndRubro(consorcio, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public Comprobante getComprobantesByConsorcioAndRubro(Consorcio consorcio, Rubro rubro) throws Exception {
        Comprobante comprobante = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobante = new ComprobanteBO().getComprobantesByConsorcioAndRubro(consorcio, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobante;
    }
    
    public Comprobante getComprobanteByNro(Integer numero, Integer tipoDoc) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Comprobante factura;
        try {
            factura = new ComprobanteBO().getComprobanteByNro(numero, tipoDoc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
    public List<Comprobante> getAllComprobantesByNro(Integer numero) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getAllComprobantesByNro(numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<Comprobante> getAllComprobantesAsignadosPorIdOriginal(Long numero) throws Exception {
        List<Comprobante> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            comprobantes = new ComprobanteBO().getAllComprobantesAsignadosPorIdOriginal(numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public Comprobante getComprByNroSucAndTipo(Integer numero, Integer suc, Integer tipo) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Comprobante factura;
        try {
            factura = new ComprobanteBO().getComprByNroSucAndTipo(numero, suc, tipo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
    public Comprobante getComprobanteById(Long id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Comprobante factura = null;
        try {
            factura = new ComprobanteBO().getComprobanteById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
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
