package ar.com.ventas.services;

import ar.com.ventas.BO.AdministradorTitularCuitComprobanteBO;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.AdministradorTitularCuitComprobante;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdministradorTitularCuitComprobanteService {

//    public Administrador saveAdministrador(Administrador administrador) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administrador = new AdministradorBO().saveAdministrador(administrador);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
//    
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
//
    public List<AdministradorTitularCuitComprobante> getExistenFacturas(Comprobante comprobante, String cuitTitular, Administrador admin) throws Exception {
        List<AdministradorTitularCuitComprobante> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new AdministradorTitularCuitComprobanteBO().getExistenFacturas(comprobante, cuitTitular, admin);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<AdministradorTitularCuitComprobante> getAll() throws Exception {
        List<AdministradorTitularCuitComprobante> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new AdministradorTitularCuitComprobanteBO().getAll();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }

    public List<AdministradorTitularCuitComprobante> getAllPorAdministrador() throws Exception {
        List<AdministradorTitularCuitComprobante> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new AdministradorTitularCuitComprobanteBO().getAllPorAdministrador();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public AdministradorTitularCuitComprobante saveFactura(AdministradorTitularCuitComprobante atcc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            atcc = new AdministradorTitularCuitComprobanteBO().saveFactura(atcc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return atcc;
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
//    
//    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) throws Exception {
//        List<Administrador> administradores = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administradores = new AdministradorBO().getAllAdministradoresActivosByFiltro(filtro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
//    public Administrador getAdministradorById(Long id) throws Exception {
//        Administrador administrador = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administrador = new AdministradorBO().getAdministradorById(id);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
    
}
