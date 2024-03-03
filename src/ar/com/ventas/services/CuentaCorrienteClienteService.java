package ar.com.ventas.services;

import ar.com.ventas.BO.ComprobanteBO;
import ar.com.ventas.BO.ComprobanteRenglonesBO;
import ar.com.ventas.BO.ConsorcioBO;
import ar.com.ventas.BO.CuentaCorrienteClienteBO;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CuentaCorrienteClienteService {

    public List<CuentaCorrienteCliente> getCtaCteDeVariosClientesEntreFechas(Consorcio consorcio, Date de, Date al) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuentaCorrienteCliente = new CuentaCorrienteClienteBO().getCtaCteDeVariosClientesEntreFechas(consorcio, de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }

    public CuentaCorrienteCliente saveCuentaCorrienteCliente(CuentaCorrienteCliente cuenta) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuenta = new CuentaCorrienteClienteBO().saveCuentaCorrienteCliente(cuenta);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuenta;
    }
    
    public CuentaCorrienteCliente updateCuentaCorrienteCliente(CuentaCorrienteCliente cuenta) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuenta = new CuentaCorrienteClienteBO().updateCuentaCorrienteCliente(cuenta);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuenta;
    }

    public void eliminarComprobanteAsignadoCompleto(CuentaCorrienteCliente cuenta, Consorcio consorcio,
            List<ComprobanteRenglones> renglones, Comprobante comprobante) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ComprobanteRenglonesBO().borrarRenglones(renglones);
            new ComprobanteBO().deleteComprobante(comprobante);
            new CuentaCorrienteClienteBO().deleteCuentaCorrienteCliente(cuenta);
            new ConsorcioBO().updateConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
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
    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByCliente(Consorcio consorcio) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuentaCorrienteCliente = new CuentaCorrienteClienteBO().getCuentaCorrienteClienteByCliente(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }

    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByClienteEntreFechas(Consorcio consorcio, Date de, Date al) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuentaCorrienteCliente = new CuentaCorrienteClienteBO().getCuentaCorrienteClienteByClienteEntreFechas(consorcio, de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }

    public List<CuentaCorrienteCliente> getCuentaCorrienteClienteByClienteEntreFechas2(Consorcio consorcio, Date de, Date al) throws Exception {
        List<CuentaCorrienteCliente> cuentaCorrienteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuentaCorrienteCliente = new CuentaCorrienteClienteBO().getCuentaCorrienteClienteByClienteEntreFechas2(consorcio, de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuentaCorrienteCliente;
    }
    
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
