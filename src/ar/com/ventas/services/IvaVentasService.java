package ar.com.ventas.services;

import ar.com.ventas.BO.ConsorcioBO;
import ar.com.ventas.BO.CuentaCorrienteClienteBO;
import ar.com.ventas.BO.CuotaFacturaBO;
import ar.com.ventas.BO.IvaVentasBO;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.CuotaFactura;
//import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IvaVentasService {

//    public IvaVentas saveImporte(IvaVentas importe) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            importe = new IvaVentasBO().saveImporte(importe);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return importe;
//    }
//
//    public void saveFacturaCompleta(IvaVentas iv, List<ComprobanteRenglones> ivr, Consorcio consorcio, CuentaCorrienteCliente ccc, List<CuotaFactura> cuotas) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        
//        try {
//            new ConsorcioBO().updateConsorcio(consorcio);
//            iv = new IvaVentasBO().saveFacturaCompleta(iv, ivr);
//            ccc.setFactura(iv);
//            new CuentaCorrienteClienteBO().saveCuentaCorrienteCliente(ccc);
//            for(CuotaFactura cf:cuotas){
//                cf.setIv(iv);
//                new CuotaFacturaBO().saveCuotaFactura(cf);
//            }
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public IvaVentas updateIvaVentas(IvaVentas iv) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            iv = new IvaVentasBO().updateIvaVentas(iv);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return iv;
//    }
//
//    public List<IvaVentas> getAllImportesActivos() throws Exception {
//        List<IvaVentas> importes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            importes = new IvaVentasBO().getAllImportesActivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return importes;
//    }
//
//    public List<ComprobanteRenglones> getAllRenglonesByFactura(IvaVentas iv) throws Exception {
//        List<ComprobanteRenglones> ivr = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            ivr = new IvaVentasBO().getAllRenglonesByFactura(iv);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
////            throw new Exception(ex);
//        }
//        return ivr;
//    }
//
////    public List<IvaVentas> getFacturasEntreFechas(Date de, Date al) throws Exception {
////        List<IvaVentas> facturas = null;
////        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
////        Transaction tx = session.beginTransaction();
////        try {
////            facturas = new IvaVentasBO().getFacturasEntreFechas(de, al);
////            tx.commit();
////        } catch (Exception ex) {
////            tx.rollback();
////            throw new Exception(ex);
////        }
////        return facturas;
////    }
//    
//    public List<IvaVentas> getIvaVentasEntrFechas(Date de, Date al) throws Exception {
//        List<IvaVentas> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new IvaVentasBO().getFacturasEntreFechas(de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//
//    public List<IvaVentas> getFacturasEntreFechasByTitular(Date de, Date al, String cuitTitular) throws Exception {
//        List<IvaVentas> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new IvaVentasBO().getFacturasEntreFechasByTitular(de, al, cuitTitular);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//    
//    public List<IvaVentas> getFacturasByConsorcioEntreFechas(Consorcio co, Date de, Date al) throws Exception {
//        List<IvaVentas> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new IvaVentasBO().getFacturasByConsorcioEntreFechas(co, de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//
//    public List<IvaVentas> getFacturasByConsorcioEntreFechasConDeuda(Consorcio co, Date de, Date al) throws Exception {
//        List<IvaVentas> comprobantes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            comprobantes = new IvaVentasBO().getFacturasByConsorcioEntreFechasConDeuda(co, de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return comprobantes;
//    }
//    
//    public Integer getImporteSiguiente() throws Exception {
//        Integer codigo = 0;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new IvaVentasBO().getImporteSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
//
//    public List<IvaVentas> getAllImportesInactivos() throws Exception {
//        List<IvaVentas> importes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            importes = new IvaVentasBO().getAllImportesInactivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return importes;
//    }
}
